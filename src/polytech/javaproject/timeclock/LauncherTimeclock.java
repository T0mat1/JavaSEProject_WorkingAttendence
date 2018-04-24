package polytech.javaproject.timeclock;

import polytech.javaproject.model.Company;
import polytech.javaproject.timeclock.view.ViewTimeclock;


public class LauncherTimeclock {

	private static final String NAMECOMPANY = "CompanyTest1";

	public static void main(String[] args) {
		
		//init model
		Company model = new Company(NAMECOMPANY);
		
		//init view
		ViewTimeclock view = new ViewTimeclock(model);
		
		//init controller
		
		//print the view on user's screen
		view.setVisible(true);
	}
	
}
