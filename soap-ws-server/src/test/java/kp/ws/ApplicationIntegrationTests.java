package kp.ws;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.ClassUtils;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.kp.ws.GetCompanyRequest;
import com.kp.ws.GetCompanyResponse;
import com.kp.ws.GetDepartmentsRequest;
import com.kp.ws.GetDepartmentsResponse;
import com.kp.ws.GetEmployeesRequest;
import com.kp.ws.GetEmployeesResponse;

/**
 * The integration tests with the {@link WebServiceTemplate}.
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationIntegrationTests {

	private final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

	private final WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);

	@LocalServerPort
	private int port = 0;

	private String REQUEST_URI;
	private static final String DEPARTMENT_NAME = "N-a-m-e-01";
	private static final String EMPLOYEE_LAST_NAME = "L-N-a-m-e-01";

	/**
	 * The constructor.
	 */
	ApplicationIntegrationTests() {
		super();
	}

	/**
	 * Initializes the {@link Jaxb2Marshaller}.
	 * 
	 * @throws Exception the {@link Exception}.
	 */
	@BeforeEach
	void init() throws Exception {

		marshaller.setPackagesToScan(ClassUtils.getPackageName(GetCompanyRequest.class));
		marshaller.afterPropertiesSet();
		REQUEST_URI = String.format("http://localhost:%s/ws", port);
	}

	/**
	 * Should get the company.
	 * 
	 */
	@Test
	void shouldGetCompany() {
		// GIVEN
		final GetCompanyRequest request = new GetCompanyRequest();
		// WHEN
		final GetCompanyResponse response = (GetCompanyResponse) webServiceTemplate.marshalSendAndReceive(REQUEST_URI,
				request);
		// THEN
		assertThat(response).isNotNull();
		assertThat(response.getCompany()).isNotNull();
		assertEquals(2, response.getCompany().getDepartments().size());
	}

	/**
	 * Should get the departments.
	 * 
	 */
	@Test
	void shouldGetDepartments() {
		// GIVEN
		final GetDepartmentsRequest request = new GetDepartmentsRequest();
		request.setDepartmentName(DEPARTMENT_NAME);
		// WHEN
		final GetDepartmentsResponse response = (GetDepartmentsResponse) webServiceTemplate
				.marshalSendAndReceive(REQUEST_URI, request);
		// THEN
		assertThat(response).isNotNull();
		assertThat(response.getDepartments()).isNotNull();
		assertEquals(1, response.getDepartments().size());
		assertEquals(DEPARTMENT_NAME, response.getDepartments().get(0).getName());
	}

	/**
	 * Should get the employees.
	 * 
	 */
	@Test
	void shouldGetEmployees() {
		// GIVEN
		final GetEmployeesRequest request = new GetEmployeesRequest();
		request.setDepartmentName(DEPARTMENT_NAME);
		request.setEmployeeLastName(EMPLOYEE_LAST_NAME);
		// WHEN
		final GetEmployeesResponse response = (GetEmployeesResponse) webServiceTemplate
				.marshalSendAndReceive(REQUEST_URI, request);
		// THEN
		assertThat(response).isNotNull();
		assertThat(response.getEmployees()).isNotNull();
		assertEquals(1, response.getEmployees().size());
		assertEquals(EMPLOYEE_LAST_NAME, response.getEmployees().get(0).getLastName());
	}
}