package academy.mindswap;

import academy.mindswap.db.DB;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        EmployeeAnalyzer analyzer = new EmployeeAnalyzer();
		System.out.println(analyzer.countEmployees(DB.getHrDepartment(), 2));
		System.out.println(analyzer.employeesSalaryAbove(DB.getHrDepartment(), 1000));
		System.out.println(analyzer.firstOlderThan(DB.getMarketingDepartment(), 40));
		System.out.println(analyzer.firstOlderThan(DB.getMarketingDepartment(), 20));

		System.out.println(analyzer.oldestEmployee(DB.getDevelopmentDepartment(), 2));

		System.out.println(analyzer.averageSalaryDept(DB.getMarketingDepartment()));

		System.out.println(analyzer.commonFirstNames(DB.getMarketingDepartment(), DB.getDevelopmentDepartment()));
	}
}
