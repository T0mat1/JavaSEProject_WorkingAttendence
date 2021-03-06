package polytech.javaproject.timeclock.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import polytech.javaproject.model.Company;
import polytech.javaproject.model.Department;
import polytech.javaproject.model.Employee;
import polytech.javaproject.model.RoundedHour;

public class ViewTimeclock extends JFrame {

	private static final String WINDOW_TITLE = "Time Clock Simulation V1.0";
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT  = 300;
	private static final boolean WINDOW_RESIZABLE = false;
	private static final int LAYOUT_ROWS = 4;
	private static final int LAYOUT_COLUMNS = 1;
	private static final int LAYOUT_GAP = 10;
	private static final String LABEL_DEFAULT_DATE = "JJ - MM - AAAA";
	private static final String LABEL_DEFAULT_TIME = "HH - MM - SS";
	private static final String LABEL_EMPLOYEE = "Employee :";
	private static final String LABEL_DEPARTMENT= "Department :";
	private static final String LABEL_FONT_NAME = "Dialog";
	private static final int LABEL_DATE_FONT_STYLE = Font.PLAIN;
	private static final int LABEL_DATE_FONT_SIZE = 12;	
	private static final int LABEL_TIME_FONT_STYLE = Font.BOLD;
	private static final int LABEL_TIME_FONT_SIZE = 14;
	
	public void setCurrentEmployeeList(ArrayList<Employee> currentEmployeeList) {
		this.currentEmployeeList = currentEmployeeList;
	}

	private Company model;
	private ArrayList<Employee> currentEmployeeList;
	
	private JPanel mainPanel;
	private JLabel dateLabel;
	private JLabel timeLabel;
	private JLabel departmentLabel;
	private JLabel employeeLabel;
	private JLabel roundedTimeLabel;
	private JButton checkButton;
	private JComboBox<Department> departmentComboBox;
	private JComboBox<Employee> employeeComboBox;
	
	public ViewTimeclock(Company newModel) {
		//set up the model
		model = setModel(newModel);
		//create new window
		build();
		//create main panel
		mainPanel = new JPanel();
		//set up the layout
		setLayout();
		//add components to the panel
		setMainPanel();
		//print view
		setVisible(true);
	}
	
	public void updateView() {
		//TODO: Refresh
		employeeComboBox.addNotify();
		
	}
	
	private void build() {
		setTitle(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(WINDOW_RESIZABLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
		
	private void setLayout() {
		GridLayout layout = new GridLayout();
		layout.setRows(LAYOUT_ROWS);
		layout.setColumns(LAYOUT_COLUMNS); 
		layout.setHgap(LAYOUT_GAP);
		layout.setVgap(LAYOUT_GAP);
		mainPanel.setLayout(layout);
	}
	
	private void setMainPanel() { //TODO diviser en plusieurs methodes
		mainPanel.setBackground(Color.WHITE);
		

		JPanel timePanel = new JPanel();
		timeLabel = new JLabel(LABEL_DEFAULT_TIME);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setVerticalAlignment(JLabel.CENTER);
		timeLabel.setFont(new Font(LABEL_FONT_NAME, LABEL_TIME_FONT_STYLE, LABEL_TIME_FONT_SIZE));
		dateLabel = new JLabel(LABEL_DEFAULT_DATE);
		dateLabel.setHorizontalAlignment(JLabel.CENTER);
		dateLabel.setVerticalAlignment(JLabel.CENTER);
		dateLabel.setFont(new Font(LABEL_FONT_NAME, LABEL_DATE_FONT_STYLE, LABEL_DATE_FONT_SIZE));
		timePanel.setLayout(new GridLayout(2,1));
		timePanel.setBackground(Color.WHITE);
		timePanel.add(dateLabel);
		timePanel.add(timeLabel);
		
		JPanel employeePanel = new JPanel();
		employeeLabel = new JLabel(LABEL_EMPLOYEE, JLabel.CENTER);
		departmentLabel = new JLabel(LABEL_DEPARTMENT, JLabel.CENTER);
		currentEmployeeList = new ArrayList<>(model.getEmployeeList());
		employeeComboBox = new JComboBox<Employee>();
		employeeComboBox.setModel(new DefaultComboBoxModel(currentEmployeeList.toArray()));
		departmentComboBox = new JComboBox<Department>(new Vector<Department>(model.getDepartmentList()));
		departmentComboBox.addItem(new Department("All")); //TODO Trouver une meilleure solution
		departmentComboBox.setSelectedIndex(model.getDepartmentList().size());;
		employeePanel.setLayout(new GridLayout(2,2,5,5));
		employeePanel.setBackground(Color.WHITE);
		employeePanel.add(departmentLabel);
		employeePanel.add(departmentComboBox);
		employeePanel.add(employeeLabel);
		employeePanel.add(employeeComboBox);
		
		JPanel checkingPanel = new JPanel();
		checkButton = new JButton("Check in/out");
		checkingPanel.setLayout(new BorderLayout());
		checkingPanel.setBackground(Color.WHITE);
		checkingPanel.add(checkButton, BorderLayout.CENTER);
		checkingPanel.add(new JLabel(" "), BorderLayout.EAST);
		checkingPanel.add(new JLabel(" "), BorderLayout.WEST);
		checkingPanel.add(new JLabel(" "), BorderLayout.NORTH);
		

		roundedTimeLabel = new JLabel("Checking for "+LABEL_DEFAULT_TIME);
		roundedTimeLabel.setHorizontalAlignment(JLabel.CENTER);
		roundedTimeLabel.setVerticalAlignment(JLabel.TOP);
		
		mainPanel.add(timePanel);
		mainPanel.add(employeePanel);
		mainPanel.add(checkingPanel);
		mainPanel.add(roundedTimeLabel);
				
		setContentPane(mainPanel);
	}
			
	public ArrayList<Employee> getCurrentEmployeeList() {
		return currentEmployeeList;
	}

	public JLabel getDateLabel() {
		return dateLabel;
	}
	
	public void setDateLabelText(String date) {
		dateLabel.setText(date);
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}
	
	public void setTimeLabelText(String time) {
		timeLabel.setText(time);
	}

	public JLabel getRoundedTimeLabel() {
		return roundedTimeLabel;
	}
	
	public void setRoundedTimeLabel(String roundedTime) {
		roundedTimeLabel.setText(roundedTime);
	}

	public JComboBox<Department> getDepartmentComboBox() {
		return departmentComboBox;
	}

	public JComboBox<Employee> getEmployeeComboBox() {
		return employeeComboBox;
	}
	
	public JButton getCheckButton() {
		return checkButton;
	}

	private Company setModel(Company newModel) {
		return newModel;		
	}
	
}
