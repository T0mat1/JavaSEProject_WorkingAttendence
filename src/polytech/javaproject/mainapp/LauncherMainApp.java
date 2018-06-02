package polytech.javaproject.mainapp;

import polytech.javaproject.mainapp.controller.ControllerMainApp;
import polytech.javaproject.mainapp.view.ViewMainApp;
import polytech.javaproject.model.Company;

public class LauncherMainApp {
	private static final String NAME_COMPANY = "Company1";
	
	Company model;
	ViewMainApp view;
	ControllerMainApp controller;

	public static void main(String[] args) {
		
		//init model
		Company model = new Company(NAME_COMPANY);
		
		//init view
		ViewMainApp view = new ViewMainApp(model);
		
		//init controller
		ControllerMainApp controller = new ControllerMainApp(view, model);
		
	}
}
