package polytech.javaproject.timeclock.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import polytech.javaproject.model.Company;
import polytech.javaproject.model.Department;
import polytech.javaproject.model.Employee;

public class ViewTimeclock extends JFrame {

	private static final String WINDOW_TITLE = "Time Clock Simulation V1.0";
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT  = 300;
	private static final boolean WINDOW_RESIZABLE = true;
	private static final int LAYOUT_ROWS = 4;
	private static final int LAYOUT_COLUMNS = 1;
	private static final int LAYOUT_GAP = 10;
	private static final String LABEL_DEFAULT_DATE = "JJ - MM - AAAA";
	private static final String LABEL_DEFAULT_TIME = "HH - MM - SS";
	private static final String LABEL_EMPLOYEE = "Employee :";
	private static final String LABEL_DEPARTMENT= "Department :";
	
	private Company model;
	private JPanel mainPanel;
	private JLabel dateLabel;
	private JLabel timeLabel;
	private JLabel departmentLabel;
	private JLabel employeeLabel;
	private JLabel roundedTimeLabel;
	private JButton checkButton;
	private JComboBox departmentComboBox;
	private JComboBox<Employee> employeeComboBox;
	
	public ViewTimeclock(Company newModel) {
		//set up the model
		model = setModel(newModel);
		//create new window
		build();
		//set up the layout
		setLayout();
		//add components to the panel
		setMainPanel();
	}
	
	private void build() {
		setTitle(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(WINDOW_RESIZABLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		mainPanel = new JPanel();
	}
		
	private void setLayout() {
		GridLayout layout = new GridLayout();
		layout.setRows(LAYOUT_ROWS);
		layout.setColumns(LAYOUT_COLUMNS); 
		layout.setHgap(LAYOUT_GAP);
		layout.setVgap(LAYOUT_GAP);
		mainPanel.setLayout(layout);
	}
	
	private void setMainPanel() {
		mainPanel.setBackground(Color.WHITE);
		
		timeLabel = new JLabel(LABEL_DEFAULT_TIME);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setVerticalAlignment(JLabel.CENTER);
		
		dateLabel = new JLabel(LABEL_DEFAULT_DATE);
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		dateLabel.setVerticalAlignment(JLabel.CENTER);
		
		JPanel timePanel = new JPanel();
		timePanel.setLayout(new GridLayout(2,1));
		timePanel.setBackground(Color.WHITE);
		timePanel.add(dateLabel);
		timePanel.add(timeLabel);
		
		JPanel comboBoxPanel = new JPanel();
		employeeLabel = new JLabel(LABEL_EMPLOYEE, JLabel.CENTER);
		departmentLabel = new JLabel(LABEL_DEPARTMENT, JLabel.CENTER);
		employeeComboBox = new JComboBox<Employee>(new Vector<Employee>(model.getEmployeeList()));
		departmentComboBox = new JComboBox<Department>(new Vector<Department>(model.getDepartmentList()));
		comboBoxPanel.setLayout(new GridLayout(2,2,5,5));
		comboBoxPanel.setBackground(Color.WHITE);
		comboBoxPanel.add(employeeLabel);
		comboBoxPanel.add(employeeComboBox);
		comboBoxPanel.add(departmentLabel);
		comboBoxPanel.add(departmentComboBox);
		
		JPanel buttonPanel = new JPanel();
		checkButton = new JButton("Check in/out");
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.add(checkButton, BorderLayout.CENTER);
		buttonPanel.add(new JLabel(" "), BorderLayout.EAST);
		buttonPanel.add(new JLabel(" "), BorderLayout.WEST);
		buttonPanel.add(new JLabel(" "), BorderLayout.NORTH);
		//buttonPanel.add(new JLabel(" "), BorderLayout.SOUTH);
		
		mainPanel.add(timePanel);
		mainPanel.add(comboBoxPanel);
		mainPanel.add(buttonPanel);
		
		setContentPane(mainPanel);
	}
	
	private Company setModel(Company newModel) {
		return newModel;		
	}
	
}
