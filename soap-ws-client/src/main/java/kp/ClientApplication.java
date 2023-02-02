package kp;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kp.ws.Company;
import com.kp.ws.Department;
import com.kp.ws.Employee;

import kp.ws.CompanyServiceClient;

/**
 * The SOAP Web Service client application.
 *
 */
@SpringBootApplication
public class ClientApplication {
	private static final Log logger = LogFactory.getLog(MethodHandles.lookup().lookupClass().getName());

	/**
	 * The constructor.
	 */
	public ClientApplication() {
		super();
	}

	/**
	 * The entry point for the application.
	 * 
	 * @param args the command-line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	/**
	 * Produces the {@link CommandLineRunner}.
	 * 
	 * @param client the {@link CompanyServiceClient}
	 * @return the {@link CommandLineRunner}
	 */
	@Bean
	CommandLineRunner produceRunner(CompanyServiceClient client) {

		return args -> {
			final Company company = client.getCompany();
			int total = 0;
			for (Department department : company.getDepartments()) {
				total += department.getEmployees().size();
			}
			logger.info(String.format("run(): 'getCompany',%n\t"//
					+ "total number of departments [%d], total number of employees[%d]",
					company.getDepartments().size(), total));

			final List<Department> departmentsList = client.getDepartments(Constants.DEPARTMENT_NAME);
			logger.info(String.format("run(): 'getDepartments',%n\t"//
					+ "department name[%s], number of employees[%d]", departmentsList.get(0).getName(),
					departmentsList.get(0).getEmployees().size()));

			final List<Employee> employeesList = client.getEmployees(Constants.DEPARTMENT_NAME,
					Constants.EMPLOYEE_LAST_NAME);
			logger.info(String.format("run(): 'getEmployees',%n\t"//
					+ "employee first name[%s], employee last name[%s], employee title[%s]",
					employeesList.get(0).getFirstName(), employeesList.get(0).getLastName(),
					employeesList.get(0).getTitle()));
		};
	}
}