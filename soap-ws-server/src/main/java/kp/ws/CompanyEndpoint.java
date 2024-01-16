package kp.ws;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

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
import kp.repository.CompanyRepository;

/**
 * The {@link Company} web service endpoint.
 *
 */
@Endpoint
public class CompanyEndpoint {
	private static final Log logger = LogFactory.getLog(MethodHandles.lookup().lookupClass().getName());

	private final CompanyRepository companyRepository;

	/**
	 * The constructor.
	 * 
	 * @param companyRepository the {@link CompanyRepository}
	 */
	@Autowired
	public CompanyEndpoint(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	/**
	 * Gets the {@link Company}.
	 * 
	 * @param request the {@link GetCompanyRequest}
	 * @return the {@link GetCompanyResponse}
	 */
	@PayloadRoot(namespace = Constants.TARGET_NAMESPACE, localPart = "getCompanyRequest")
	@ResponsePayload
	public GetCompanyResponse getCompany(@RequestPayload GetCompanyRequest request) {

		final GetCompanyResponse response = new GetCompanyResponse();
		response.setCompany(companyRepository.findCompany());
		logger.info("getCompany():");
		return response;
	}

	/**
	 * Gets the {@link Department}s.
	 * 
	 * @param request the {@link GetDepartmentsRequest}
	 * @return the {@link GetDepartmentsResponse}
	 */
	@PayloadRoot(namespace = Constants.TARGET_NAMESPACE, localPart = "getDepartmentsRequest")
	@ResponsePayload
	public GetDepartmentsResponse getDepartments(@RequestPayload GetDepartmentsRequest request) {

		final GetDepartmentsResponse response = new GetDepartmentsResponse();
		final List<Department> departmentList = companyRepository.findDepartments(request.getDepartmentName());
		response.getDepartments().addAll(departmentList);
		logger.info(String.format("getDepartments(): department name[%s]", request.getDepartmentName()));
		return response;
	}

	/**
	 * Gets the {@link Employee}s.
	 * 
	 * @param request the {@link GetEmployeesRequest}
	 * @return the {@link GetEmployeesResponse}
	 */
	@PayloadRoot(namespace = Constants.TARGET_NAMESPACE, localPart = "getEmployeesRequest")
	@ResponsePayload
	public GetEmployeesResponse getEmployees(@RequestPayload GetEmployeesRequest request) {

		final GetEmployeesResponse response = new GetEmployeesResponse();
		final List<Employee> employeeList = companyRepository.findEmployees(request.getDepartmentName(),
				request.getEmployeeLastName());
		response.getEmployees().addAll(employeeList);
		logger.info(String.format("getEmployees(): department name[%s], employee last name[%s]",
				request.getDepartmentName(), request.getEmployeeLastName()));
		return response;
	}
}
