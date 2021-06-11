package academy.mindswap;

import academy.mindswap.employee.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class EmployeeAnalyzer {
	private int currentYear;

	public EmployeeAnalyzer() {
		currentYear = 2021;
	}

	//countNUmberEmployeesWorkingDeptMoreThan n years
	public long countEmployees(List<Employee> employeeList, int years) {
		long count = employeeList.stream()
				.filter(employee -> (currentYear - employee.getStartingYear()) > years)
				.count();

		return count;
	}

	//nameEmployeeSalaryAbove n
	public String employeesSalaryAbove(List<Employee> employeeList, int salary) {
		String employees = employeeList.stream()
				.filter(employee -> employee.getSalary() > salary)
				.map(employee -> employee.getFirstName())
				.reduce("", (acc, employee) -> acc += employee + " ");
		return employees;
	}

	//OldestEmployee
	public List<Employee> oldestEmployee(List<Employee> employeeList, int n) {
		List<Employee> oldestEmployeeList = employeeList.stream()
				.sorted(Comparator.comparingInt(Employee::getAge).reversed())
				.limit(n)
				.collect(Collectors.toList());

		return oldestEmployeeList;
	}

	//firstOlderThan n
	public Employee firstOlderThan(List<Employee> employeeList, int age) {
		Optional<Employee> e = employeeList.stream()
				.filter(employee -> employee.getAge() > age)
				.findFirst();
		return e.isPresent() ? e.get() : null;
	}

	//averageSalaryDept
	public double averageSalaryDept(List<Employee> employeeList) {
		OptionalDouble avg = employeeList.stream()
				.mapToInt(employee -> employee.getSalary())
				.average();
		return avg.isPresent() ? avg.getAsDouble() : null;
	}

	//commonFirstNamesBetweenDepts
	public String commonFirstNames(List<Employee> employeeList1, List<Employee> employeeList2) {
		String commonNames = employeeList1.stream()
				.map(employee -> employee.getFirstName())
				.filter(employee -> {
					for (Employee employee2 : employeeList2) {
						if (employee.equals(employee2.getFirstName())) {
							return true;
						}
					}
					return false;
				})
				.reduce("", (acc, employee) -> acc += employee + " ");

		if(commonNames.isEmpty()){
			return "No common first names in these departments";
		}
		return commonNames;
	}
}
