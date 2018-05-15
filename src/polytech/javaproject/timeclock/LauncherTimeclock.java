package polytech.javaproject.timeclock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import polytech.javaproject.model.Company;
import polytech.javaproject.model.RoundedHour;
import polytech.javaproject.timeclock.view.ViewTimeclock;


public class LauncherTimeclock {

	private static final String NAME_COMPANY = "Company1";

	public static void main(String[] args) {
		
		//init model
		//Company model = new Company(NAME_COMPANY);
		Company model = createTestCompany();
		
		//init view
		ViewTimeclock view = new ViewTimeclock(model);
		
		//init controller
		
		//print the view on user's screen
		view.setVisible(true);
	}
	
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
		
		//TODO: Add creation of departments
		
		return company;
	}
	
}
