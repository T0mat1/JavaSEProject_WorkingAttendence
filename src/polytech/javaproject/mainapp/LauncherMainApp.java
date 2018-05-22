package polytech.javaproject.mainapp;

import polytech.javaproject.mainapp.view.ViewMainApp;
import polytech.javaproject.model.Company;

public class LauncherMainApp {
	private static final String NAME_COMPANY = "Company1";

	public static void main(String[] args) {
		
		//init model
		Company model = new Company(NAME_COMPANY);
		
		//init view
		ViewMainApp view = new ViewMainApp(model);
		
		//init controller
		
		//print the view on user's screen
		view.setVisible(true);
	}
}
