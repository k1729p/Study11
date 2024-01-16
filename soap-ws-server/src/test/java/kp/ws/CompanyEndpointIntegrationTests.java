package kp.ws;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.AssertionErrors;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.ws.test.server.RequestCreator;
import org.springframework.ws.test.server.RequestCreators;
import org.springframework.ws.test.server.ResponseActions;
import org.springframework.ws.test.server.ResponseMatchers;
import org.springframework.ws.test.server.ResponseXPathExpectations;

import kp.Constants;

/**
 * The server-side integration testing with the {@link MockWebServiceClient}.
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CompanyEndpointIntegrationTests {

	private static final boolean VERBOSE = false;

	private MockWebServiceClient mockClient;

	@Autowired
	private ApplicationContext applicationContext;

	private static final Resource SCHEMA_RESOURCE = new ClassPathResource(Constants.SCHEMA_XSD_PATH);
	private static final ResponseXPathExpectations EXPECTED_X_PATH = ResponseMatchers.xpath("""
			ns:getCompanyResponse/ns:company/
			ns:departments[ns:name='N-a-m-e-01']/
			ns:employees[ns:lastName='L-N-a-m-e-01']
					""", Collections.singletonMap("ns", "http://kp.com/ws"));

	/**
	 * The constructor.
	 */
	CompanyEndpointIntegrationTests() {
		super();
	}

	/**
	 * Initializes the {@link MockWebServiceClient}.
	 * 
	 */
	@BeforeEach
	void initClient() {
		mockClient = MockWebServiceClient.createClient(applicationContext);
	}

	/**
	 * Should get the company.
	 * 
	 * @throws Exception the {@link Exception}.
	 */
	@Test
	void shouldGetCompany() throws Exception {
		// GIVEN
		final Source requestPayload = new StreamSource(new ClassPathResource("getCompanyRequest.xml").getFile());
		final RequestCreator requestCreator = RequestCreators.withPayload(requestPayload);
		// WHEN
		final ResponseActions responseActions = mockClient.sendRequest(requestCreator);
		// THEN
		responseActions.andExpect(ResponseMatchers.noFault());
		responseActions.andExpect(EXPECTED_X_PATH.exists());
		responseActions.andExpect(ResponseMatchers.validPayload(SCHEMA_RESOURCE));
		responseActions.andExpect((request, response) -> checkResponsePayload("getCompanyResponse.soap", response));
	}

	/**
	 * Should get the departments.
	 * 
	 * @throws Exception the {@link Exception}.
	 */
	@Test
	void shouldGetDepartments() throws Exception {
		// GIVEN
		final Source requestPayload = new StreamSource(new ClassPathResource("getDepartmentsRequest.xml").getFile());
		final RequestCreator requestCreator = RequestCreators.withPayload(requestPayload);
		// WHEN
		final ResponseActions responseActions = mockClient.sendRequest(requestCreator);
		// THEN
		responseActions.andExpect(ResponseMatchers.noFault());
		responseActions.andExpect(ResponseMatchers.validPayload(SCHEMA_RESOURCE));
		responseActions.andExpect((request, response) -> checkResponsePayload("getDepartmentsResponse.soap", response));
	}

	/**
	 * Should get the employees.
	 * 
	 * @throws Exception the {@link Exception}.
	 */
	@Test
	void shouldGetEmployees() throws Exception {
		// GIVEN
		final Source requestPayload = new StreamSource(new ClassPathResource("getEmployeesRequest.xml").getFile());
		final RequestCreator requestCreator = RequestCreators.withPayload(requestPayload);
		// WHEN
		final ResponseActions responseActions = mockClient.sendRequest(requestCreator);
		// THEN
		responseActions.andExpect(ResponseMatchers.noFault());
		responseActions.andExpect(ResponseMatchers.validPayload(SCHEMA_RESOURCE));
		responseActions.andExpect((request, response) -> checkResponsePayload("getEmployeesResponse.soap", response));
	}

	/**
	 * Checks response payload.
	 * 
	 * @param expectedResponseFile the name of the file with expected response
	 * @param actualResponse       the actual response
	 */
	private void checkResponsePayload(String expectedResponseFile, WebServiceMessage actualResponse) {

		String expectedPayload = "";
		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try (InputStream inputStream = new FileInputStream(new ClassPathResource(expectedResponseFile).getFile())) {
			expectedPayload = new String(inputStream.readAllBytes()).replace("\r", "").replace("\n", "");
			actualResponse.writeTo(outputStream);
		} catch (IOException e) {
			AssertionErrors.fail("checkResponsePayload(): IOException[" + e.getMessage() + "]");
		}
		final String actualPayload = outputStream.toString();
		if (VERBOSE) {
			System.err.println(actualPayload.replace("><", ">\n<"));
		}
		Assertions.assertEquals(expectedPayload, actualPayload);
	}

}