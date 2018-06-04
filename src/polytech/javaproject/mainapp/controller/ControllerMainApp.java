package polytech.javaproject.mainapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import polytech.javaproject.mainapp.view.ViewMainApp;
import polytech.javaproject.model.Company;

public class ControllerMainApp {
	
	private Company model;
	private ViewMainApp view;

	private ActionListener createEmployeeActionListener;
	private ActionListener sortByDateActionListener;
	
	public ControllerMainApp(ViewMainApp viewMainApp, Company company) {
		
		model = company;
		view = viewMainApp;
		
		createEmployeeActionListener = new ActionListener() {
			final JFrame parent = new JFrame();
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(parent,
                        "What is your name?", null);
			}
		};
		
		view.getNewEmployeeButton().addActionListener(createEmployeeActionListener);
		
		//print the view on user's screen
		view.setVisible(true);
		
	}
	
}
