package kp.ws;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ws.test.client.MockWebServiceServer;
import org.springframework.ws.test.client.RequestMatcher;
import org.springframework.ws.test.client.ResponseCreator;
import org.springframework.ws.test.client.ResponseCreators;

import com.kp.ws.Company;
import com.kp.ws.Department;
import com.kp.ws.Employee;

import kp.Constants;

/**
 * The client-side integration testing with the {@link MockWebServiceServer}.
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CompanyServiceClientIntegrationTests {

	@Autowired
	private CompanyServiceClient companyServiceClient;

	private MockWebServiceServer mockServer;

	/**
	 * The constructor.
	 */
	CompanyServiceClientIntegrationTests() {
		super();
	}

	/**
	 * Initializes the {@link MockWebServiceServer}.
	 * 
	 */
	@BeforeEach
	void initServer() {
		mockServer = MockWebServiceServer.createServer(companyServiceClient);
	}

	/**
	 * Should get the {@link Company}.
	 * 
	 * @throws Exception the {@link Exception}.
	 */
	@Test
	void shouldGetCompany() throws Exception {
		// GIVEN
		final RequestMatcher requestMatcher = new RequestMatcherImpl("getCompanyRequest.soap");
		final Source responsePayload = new StreamSource(new ClassPathResource("getCompanyResponse.xml").getFile());
		final ResponseCreator responseCreator = ResponseCreators.withPayload(responsePayload);
		// WHEN
		mockServer.expect(requestMatcher).andRespond(responseCreator);
		final Company company = companyServiceClient.getCompany();
		// THEN
		assertThat(company).isNotNull();
		final List<Department> departmentsList = company.getDepartments();
		assertThat(departmentsList).isNotNull();
		assertEquals(2, departmentsList.size());
		assertEquals(Constants.DEPARTMENT_NAME, departmentsList.get(0).getName());
		// verifying that the expected message was actually received
		mockServer.verify();
	}

	/**
	 * Should get the {@link Department}s.
	 * 
	 * @throws Exception the {@link Exception}.
	 */
	@Test
	void shouldGetDepartments() throws Exception {
		// GIVEN
		final RequestMatcher requestMatcher = new RequestMatcherImpl("getDepartmentsRequest.soap");
		final Source responsePayload = new StreamSource(new ClassPathResource("getDepartmentsResponse.xml").getFile());
		final ResponseCreator responseCreator = ResponseCreators.withPayload(responsePayload);
		// WHEN
		mockServer.expect(requestMatcher).andRespond(responseCreator);
		final List<Department> departmentsList = companyServiceClient.getDepartments(Constants.DEPARTMENT_NAME);
		// THEN
		assertThat(departmentsList).isNotNull();
		assertEquals(1, departmentsList.size());
		assertEquals(Constants.DEPARTMENT_NAME, departmentsList.get(0).getName());
		// verifying that the expected message was actually received
		mockServer.verify();
	}

	/**
	 * Should get the {@link Employee}s.
	 * 
	 * @throws Exception the {@link Exception}.
	 */
	@Test
	void shouldGetEmployees() throws Exception {
		// GIVEN
		final RequestMatcher requestMatcher = new RequestMatcherImpl("getEmployeesRequest.soap");
		final Source responsePayload = new StreamSource(new ClassPathResource("getEmployeesResponse.xml").getFile());
		final ResponseCreator responseCreator = ResponseCreators.withPayload(responsePayload);
		// WHEN
		mockServer.expect(requestMatcher).andRespond(responseCreator);
		final List<Employee> employeesList = companyServiceClient.getEmployees(Constants.DEPARTMENT_NAME,
				Constants.EMPLOYEE_LAST_NAME);
		// THEN
		assertThat(employeesList).isNotNull();
		assertEquals(1, employeesList.size());
		assertEquals(Constants.EMPLOYEE_LAST_NAME, employeesList.get(0).getLastName());
		// verifying that the expected message was actually received
		mockServer.verify();
	}
}