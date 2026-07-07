package com.coforge.ems.ui;

import java.util.Scanner;

import com.coforge.ems.controller.EmployeeController;
import com.coforge.ems.model.Employee;

public class EmployeeApp {

	private static EmployeeController controller = new EmployeeController();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String confirmation = "";
		String res = "";

		do {

			System.out.println("\n1.Create");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Find");
			System.out.println("5.Find All");
			System.out.println("6.Exit");

			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				System.out.println("Enter Employee Id Name Salary DepartmentNo");

				Employee employee = new Employee(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt());

				res = controller.createEmployee(employee);
				break;

			case 2:

				System.out.println("Enter Employee Id");
				int id = sc.nextInt();

				System.out.println("Enter New Name");
				String name = sc.next();

				System.out.println("Enter New Salary");
				int salary = sc.nextInt();

				System.out.println("Enter New Department Number");
				int dept = sc.nextInt();

				Employee emp = new Employee(id, name, salary, dept);

				res = controller.updateEmployee(emp);
				break;

			case 3:

				System.out.println("Enter Employee Id");
				int eid = sc.nextInt();

				res = controller.deleteEmployee(eid);
				break;

			case 4:

				System.out.println("Enter Employee Id");
				int findId = sc.nextInt();

				res = controller.findEmployee(findId);
				break;

			case 5:

				res = controller.findAllEmployee();
				break;

			case 6:

				System.exit(0);

			default:

				res = "Invalid Choice";

			}

			System.out.println(res);

			System.out.println("Do you want to continue (Yes/No)");
			confirmation = sc.next();

		} while (confirmation.equalsIgnoreCase("Yes"));

		sc.close();

	}

}