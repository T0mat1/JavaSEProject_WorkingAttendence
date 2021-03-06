package polytech.javaproject.mainapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import polytech.javaproject.mainapp.view.EmployeeDialog;
import polytech.javaproject.mainapp.view.ViewMainApp;
import polytech.javaproject.model.Company;

public class ControllerMainApp {
	
	private Company model;
	private ViewMainApp view;

	private ActionListener createEmployeeActionListener;
	private ActionListener deleteEmployeeActionListener;
	private ActionListener sortByDateActionListener;
	
	public ControllerMainApp(ViewMainApp viewMainApp, Company company) {
		
		model = company;
		view = viewMainApp;
		
		createEmployeeActionListener = new ActionListener() {
			final JFrame parent = new JFrame();
			@Override
			public void actionPerformed(ActionEvent e) {
				EmployeeDialog dialog = new EmployeeDialog(parent, "Add new employee", true, model.getDepartmentList());
				dialog.setVisible(true);
			}
		};
		
		deleteEmployeeActionListener = new ActionListener() {
			final JFrame parent = new JFrame();
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane dialog = new JOptionPane();
				String nom = dialog.showInputDialog(null, "Veuillez d�cliner votre identit� !", JOptionPane.QUESTION_MESSAGE);
			}
		};
		
		view.getNewEmployeeButton().addActionListener(createEmployeeActionListener);
		view.getDeleteEmployeeButton().addActionListener(deleteEmployeeActionListener);
		
		//print the view on user's screen
		view.setVisible(true);
		
	}
	
}
