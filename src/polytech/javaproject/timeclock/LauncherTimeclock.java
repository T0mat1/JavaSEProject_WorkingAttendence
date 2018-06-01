package polytech.javaproject.timeclock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import polytech.javaproject.model.Company;
import polytech.javaproject.model.RoundedHour;
import polytech.javaproject.timeclock.controller.ControllerTimeclock;
import polytech.javaproject.timeclock.view.ViewTimeclock;

public class LauncherTimeclock {

	private static final String NAME_COMPANY = "Company1";

	public static void main(String[] args) {
		
		Company model;
		ViewTimeclock view;
		ControllerTimeclock controller;
		
		
		//initiate model
		model = createTestCompany();
		view = new ViewTimeclock(model);
		
		/*
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				view = new ViewTimeclock(model);
				//view.setVisible(true);
			};
		});
		//*/
				
		//launch controller
		controller = new ControllerTimeclock(view, model);
		
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
