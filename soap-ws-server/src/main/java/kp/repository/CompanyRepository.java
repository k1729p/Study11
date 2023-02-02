package kp.repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.kp.ws.Company;
import com.kp.ws.Department;
import com.kp.ws.Employee;
import com.kp.ws.Title;

/**
 * The simple repository with the {@link Company} data.
 * <p>
 * The standard dataset:
 * <ol>
 * <li>Company
 * <ol>
 * <li>Department
 * <ol>
 * <li>Employee
 * <li>Employee
 * <li>Employee
 * </ol>
 * <li>Department
 * <ol>
 * <li>Employee
 * <li>Employee
 * <li>Employee
 * </ol>
 * </ol>
 * </ol>
 */
@Component
public class CompanyRepository {

	private final Company company = new Company();
	private final AtomicInteger departmentIdSequence = new AtomicInteger();
	private final AtomicInteger employeeIdSequence = new AtomicInteger();
	private static final String DEPARTMENT_NAME_ERROR_MSG = "The department name must not be null";
	private static final String EMPLOYEE_NAME_ERROR_MSG = "The employee last name must not be null";

	/**
	 * The constructor.
	 */
	public CompanyRepository() {
		super();
	}

	/**
	 * Initializes data.
	 * 
	 */
	@PostConstruct
	public void initData() {

		IntStream.rangeClosed(1, 2).boxed().forEach(i -> {
			final Department department = new Department();
			department.setId(departmentIdSequence.incrementAndGet());
			department.setName(String.format("N-a-m-e-%02d", departmentIdSequence.get()));
			IntStream.rangeClosed(1, 3).boxed().forEach(j -> {
				final Employee employee = new Employee();
				employee.setId(employeeIdSequence.incrementAndGet());
				employee.setFirstName(String.format("F-N-a-m-e-%02d", employeeIdSequence.get()));
				employee.setLastName(String.format("L-N-a-m-e-%02d", employeeIdSequence.get()));
				employee.setTitle(Title.values()[(employeeIdSequence.get() - 1) % 3]);
				department.getEmployees().add(employee);
			});
			company.getDepartments().add(department);
		});
	}

	/**
	 * Finds the {@link Company}.
	 * 
	 * @return the {@link Company}
	 */
	public Company findCompany() {
		return company;
	}

	/**
	 * Finds the {@link Department}s.
	 * 
	 * @param departmentName the {@link Department} name
	 * @return the list of {@link Department}s
	 */
	public List<Department> findDepartments(String departmentName) {

		Assert.notNull(departmentName, DEPARTMENT_NAME_ERROR_MSG);
		return company.getDepartments().stream()//
				.filter(dep -> departmentName.equals(dep.getName())).toList();
	}

	/**
	 * Finds the {@link Employee}s.
	 * 
	 * @param departmentName   the {@link Department} name
	 * @param employeeLastName the {@link Employee} last name
	 * @return the list of {@link Employee}s
	 */
	public List<Employee> findEmployees(String departmentName, String employeeLastName) {

		Assert.notNull(departmentName, DEPARTMENT_NAME_ERROR_MSG);
		Assert.notNull(employeeLastName, EMPLOYEE_NAME_ERROR_MSG);
		return company.getDepartments().stream().filter(dep -> departmentName.equals(dep.getName()))//
				.map(Department::getEmployees)//
				.flatMap(List::stream)//
				.filter(emp -> employeeLastName.equals(emp.getLastName())).toList();
	}
}