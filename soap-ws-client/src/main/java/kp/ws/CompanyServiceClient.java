package kp.ws;

import java.util.List;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.kp.ws.Company;
import com.kp.ws.Department;
import com.kp.ws.Employee;
import com.kp.ws.GetCompanyRequest;
import com.kp.ws.GetCompanyResponse;
import com.kp.ws.GetDepartmentsRequest;
import com.kp.ws.GetDepartmentsResponse;
import com.kp.ws.GetEmployeesRequest;
import com.kp.ws.GetEmployeesResponse;

import kp.Constants;

/**
 * The {@link Company} service client.
 *
 */
public class CompanyServiceClient extends WebServiceGatewaySupport {

	/**
	 * The constructor.
	 */
	public CompanyServiceClient() {
		super();
	}

	/**
	 * Gets the {@link Company} with all {@link Department}s and {@link Employee}s.
	 * 
	 * @return the {@link Company}
	 */
	public Company getCompany() {

		final GetCompanyRequest request = new GetCompanyRequest();

		final GetCompanyResponse response = (GetCompanyResponse) getWebServiceTemplate()//
				.marshalSendAndReceive(Constants.ENDPOINT_ADDRESS, request, Constants.COMPANY_REQUEST_CALLBACK);
		final Company company = response.getCompany();
		logger.info("getCompany():");
		return company;
	}

	/**
	 * Gets the {@link Department}s with given {@link Department}'s name.
	 * 
	 * @param departmentName the {@link Department}'s name
	 * @return the list of {@link Department}s
	 */
	public List<Department> getDepartments(String departmentName) {

		final GetDepartmentsRequest request = new GetDepartmentsRequest();
		request.setDepartmentName(departmentName);

		final GetDepartmentsResponse response = (GetDepartmentsResponse) getWebServiceTemplate()//
				.marshalSendAndReceive(Constants.ENDPOINT_ADDRESS, request, Constants.DEPARTMENTS_REQUEST_CALLBACK);
		final List<Department> departmentsList = response.getDepartments();
		logger.info(String.format("getDepartments():%n\t department name[%s], departments list size[%d]",
				departmentName, departmentsList.size()));
		return departmentsList;
	}

	/**
	 * Gets the {@link Employee}s with given {@link Department}'s name and
	 * {@link Employee}'s last name.
	 * 
	 * @param departmentName   the {@link Department}'s name
	 * @param employeeLastName the {@link Employee}'s last name
	 * @return the list of {@link Employee}s
	 */
	public List<Employee> getEmployees(String departmentName, String employeeLastName) {

		final GetEmployeesRequest request = new GetEmployeesRequest();
		request.setDepartmentName(departmentName);
		request.setEmployeeLastName(employeeLastName);

		final GetEmployeesResponse response = (GetEmployeesResponse) getWebServiceTemplate()//
				.marshalSendAndReceive(Constants.ENDPOINT_ADDRESS, request, Constants.EMPLOYEE_REQUEST_CALLBACK);
		final List<Employee> employeesList = response.getEmployees();
		logger.info(String.format(
				"getEmployees():%n\t department name[%s], employee last name[%s], employees list size[%d]",
				departmentName, employeeLastName, employeesList.size()));
		return employeesList;
	}
}