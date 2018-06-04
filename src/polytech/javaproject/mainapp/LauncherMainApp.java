package polytech.javaproject.mainapp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import polytech.javaproject.mainapp.controller.ControllerMainApp;
import polytech.javaproject.mainapp.view.ViewMainApp;
import polytech.javaproject.model.Company;
import polytech.javaproject.model.RoundedHour;

public class LauncherMainApp {
	private static final String NAME_COMPANY = "Company1";
	
	Company model;
	ViewMainApp view;
	ControllerMainApp controller;

	public static void main(String[] args) {
		
		//init model
		//Company model = new Company(NAME_COMPANY);
		Company model = createTestCompany();
		
		//init view
		ViewMainApp view = new ViewMainApp(model);
		
		//init controller
		ControllerMainApp controller = new ControllerMainApp(view, model);
		
	}
	
	//==================== Stub method =========================
		public static Company createTestCompany() {
			Company company = new Company("CompanyTest");
			
			for (int i=0 ; i<4 ; i++)
				company.createManager("Manager", "n°"+i,
						new RoundedHour(LocalDateTime.of(LocalDate.now(), LocalTime.of(8, 0))), 
						new RoundedHour(LocalDateTime.of(LocalDate.now(), LocalTime.of(18, 0))));
			
			for (int i=0 ; i<20 ; i++)
				company.createEmployee("Employee", "n°"+i,
						new RoundedHour(LocalDateTime.of(LocalDate.now(), LocalTime.of(8, 30))), 
						new RoundedHour(LocalDateTime.of(LocalDate.now(), LocalTime.of(18, 45))));
			
			for (int i=0 ; i<3 ; i++)
				company.createDepartment("Department n°"+i, company.getManagerList().get(i));
			
			return company;
		}
	
}
