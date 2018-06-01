package polytech.javaproject.timeclock.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Timer;

import polytech.javaproject.model.Company;
import polytech.javaproject.model.Department;
import polytech.javaproject.model.RoundedHour;
import polytech.javaproject.timeclock.view.ViewTimeclock;

public class ControllerTimeclock {

	private static final int TIMER_DELAY = 500;

	private Company model;
	private ViewTimeclock view;

	private Timer timer;
	
	private ActionListener departmentActionListener;
	private ActionListener checkingActionListener;
	private ActionListener timerActionListener;
	
	public ControllerTimeclock(ViewTimeclock viewTimeclock, Company company) {
		//start the timer to print the hour and the date
		startTimer();
		
		//init model
		model = company;
		
		//init view
		view = viewTimeclock;
				
		initActionListeners();

		startTimer();
		view.getDepartmentComboBox().addActionListener(departmentActionListener);
		view.getCheckButton().addActionListener(checkingActionListener);
		
		//print the view on user's screen
		view.setVisible(true);
	}
	
	private void initActionListeners() {
		departmentActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Department selectedDepartment = (Department) view.getDepartmentComboBox().getSelectedItem();
				
				if (selectedDepartment.toString() == "All")
					view.setCurrentEmployeeList(model.getEmployeeList());
				else
					view.setCurrentEmployeeList(selectedDepartment.getEmployeeList());
				view.getEmployeeComboBox().setModel(new DefaultComboBoxModel(view.getCurrentEmployeeList().toArray()));
			}
		};
		
		checkingActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO modify model when checking
				System.out.println(view.getEmployeeComboBox().getSelectedItem()+" checks for "+new RoundedHour(LocalDateTime.of(LocalDate.now(), LocalTime.now())).toString());
			}
		};
		
		timerActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.setDateLabelText(LocalDate.now().toString());
				view.setTimeLabelText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
				view.setRoundedTimeLabel("Checking for "+new RoundedHour(LocalDateTime.of(LocalDate.now(), LocalTime.now())).toString());
			}
		};
		
	}
	
	private void startTimer() {
		timer = new Timer(TIMER_DELAY, timerActionListener);
		timer.setInitialDelay(0);
		timer.start();
	}
		
}
