package application;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.text.ParseException;
import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		System.out.print("Enter department's name:");
		String departmentName = sc.next();
		System.out.println("Enter worker data:");
		System.out.print("Name:");
		String workerName = sc.next();
		System.out.print("Level:");
		String workerLevel = sc.next();
		System.out.print("Base Salary:");
		Double workerBaseSalary = sc.nextDouble();
		
		
		Worker x = new Worker(workerName,WorkerLevel.valueOf(workerLevel),workerBaseSalary,new Department (departmentName));
		
		System.out.println("How many contracts to this worker?");
		int n = sc.nextInt();
		
		for (int i=1; i<=n ;i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.println("Date (DD/MM/YYYY):");
			Date contractDate = new Date(sdf.parse(sc.next()).getTime());
			System.out.println("Value per hour:");
			double valuePHour = sc.nextDouble();
			System.out.println("Duration (hours):");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePHour, hours);
			x.addContract(contract);
		}
		
		System.out.println("Enter month and year to calculate income (MM/YYYY):");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name:" + x.getName());
		System.out.println("Departament:" + x.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ":");
		System.out.println(String.format("%.2fx",x.income(year, month)));
		
		
		
		
		sc.close();
	}

}
