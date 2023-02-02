package kp;

import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * The constants
 *
 */
@SuppressWarnings("doclint:missing")
public final class Constants {

	public static final String TARGET_NAMESPACE = "http://kp.com/ws";
	public static final String DEFAULT_URI = "http://localhost:8080/ws";
	public static final String ENDPOINT_ADDRESS = DEFAULT_URI.concat("/companies");
	public static final String GENERATED_PACKAGE = "com.kp.ws";

	public static final SoapActionCallback COMPANY_REQUEST_CALLBACK = new SoapActionCallback(
			TARGET_NAMESPACE.concat("/GetCompanyRequest"));
	public static final SoapActionCallback DEPARTMENTS_REQUEST_CALLBACK = new SoapActionCallback(
			Constants.TARGET_NAMESPACE.concat("/GetDepartmentsRequest"));
	public static final SoapActionCallback EMPLOYEE_REQUEST_CALLBACK = new SoapActionCallback(
			TARGET_NAMESPACE.concat("/GetEmployeesRequest"));

	public static final String DEPARTMENT_NAME = "N-a-m-e-01";
	public static final String EMPLOYEE_LAST_NAME = "L-N-a-m-e-01";

	private Constants() {
		throw new IllegalStateException("Utility class");
	}
}