package polytech.javaproject.timeclock.controller;

import polytech.javaproject.model.Company;
import polytech.javaproject.timeclock.view.ViewTimeclock;

public class ControllerTimeclock {

	private Company model;
	private ViewTimeclock view; //can had an interface View in the future
	
	public ControllerTimeclock(Company company, ViewTimeclock viewTimeclock) {
		model = company;
		view = viewTimeclock;
	}
	
	
	
}
