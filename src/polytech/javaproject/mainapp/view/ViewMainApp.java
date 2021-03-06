package polytech.javaproject.mainapp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import polytech.javaproject.model.Company;
import polytech.javaproject.model.Department;
import polytech.javaproject.model.Employee;

public class ViewMainApp extends JFrame {

	private static final String WINDOW_TITLE = "Employee Managment [WORK IN PROGRESS]";
	private static final int WINDOW_HEIGHT = 720;
	private static final int WINDOW_WIDTH = 1280;
	private static final boolean WINDOW_RESIZABLE = false;
	private static final String FONT_NAME = "Dialog";
	private static final int FONT_STYLE = Font.BOLD;
	private static final int FONT_SIZE = 15;
	private static final int CHECKING_TABLE_NB_COLUMN = 6;
	private static final int DEPARTMENT_TABLE_NB_COLUMN = 3;
	private static final int EMPLOYEE_TABLE_NB_COLUMN = 5;
	private static final String[] HEADER_CHECKINGS_LIST_STRING = {"Employee First Name",
														"Employee Last Name",
														"arrived at",
														"leaved at",
														"Department",
														"Date"};
	private static final String[] HEADER_DEPARTMENT_LIST_STRING = {"Department", "Manager", "Nb Employees"};
	private static final String[] HEADER_EMPLOYEE_LIST_STRING = {"ID", "Employee First Name", "Employee Last Name", "Department", "Overtime"};
	private static final String LABEL_INCIDENT_OF_SCORES = "Incident of scores :";
	private static final String LABEL_SHOW_ARRIVALS = "Show late arrivals";
	private static final String LABEL_SHOW_LEAVINGS = "Show early leavings";
	private static final String LABEL_TCP_CONNECTION = "TCP Connection :";
	private static final String LABEL_IP_ADRESS = "IP Address :";
	private static final String LABEL_PORT = "Port :";
	private static final String LABEL_CSV = "Save employee list :";
	private static final String BUTTON_TEXT_CREATE_EMPLOYEE = "Create new employee";
	private static final String BUTTON_TEXT_MODIFY_EMPLOYEE = "Modify employee";
	private static final String BUTTON_TEXT_DELETE_EMPLOYEE = "Delete employee";
	private static final String BUTTON_TEXT_CREATE_DEPARTMENT = "Create new Department";
	private static final String BUTTON_TEXT_MODIFY_DEPARTMENT = "Modify department";
	private static final String BUTTON_TEXT_DELETE_DEPARTMENT = "Delete Department";
	private static final String BUTTON_TEXT_CSV_IMPORT = "Import CSV";
	private static final String BUTTON_TEXT_CSV_EXPORT = "Export CSV";
	private static final String RADIO_TEXT_IPV4 = "IPV4";
	private static final String RADIO_TEXT_IPV6 = "IPV6";
	
	private Company model;
	
	private JPanel mainPanel;
	private JTabbedPane tabbedPane;
	private JPanel checkingPanel;
	private JPanel employeePanel;
	private JPanel departmentPanel;
	private JPanel configurationPanel;
	// ======= checking panel =========
	private Object[][] checkingData;
	private JTable checkingTable;
	private JComboBox sortByDepartmentComboBox;
	private DateTextField sortFromDateTextField;
	private DateTextField sortToDateTextField;
	// ======= employee panel =========
	private Object[][] employeeData;
	private JTable employeeTable;
	private JButton newEmployeeButton;
	private JButton modifyEmployeeButton;
	private JButton deleteEmployeeButton;
	// ======= department panel =======
	private Object[][] departmentData;
	private JTable departmentTable;
	private JButton newDepartmentButton;
	private JButton modifyDepartmentButton;
	private JButton deleteDepartmentButton;
	// ======= configuration panel ========
	private JTextField IPAdressTextField;
	private JTextField PortTextField;
	private JButton CSVExportButton;
	private JButton CSVImportButton;
	private JRadioButton IPV4RadioButton;
	private JRadioButton IPV6RadioButton;
	
	public ViewMainApp(Company company) {
		//import model
		model = company;
		//create main panel
		mainPanel = new JPanel();
		build();
		setMainPanel();
	}
	
	private void build() {
		setTitle(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(WINDOW_RESIZABLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private void setMainPanel() {
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setLayout(new GridLayout(1,1,10,10));
		
		tabbedPane = new JTabbedPane();
		
		//1st tab
		createCheckingPanel();
		tabbedPane.addTab("Checkings", checkingPanel);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		//2nd tab
		createEmployeePanel();
		tabbedPane.addTab("Employee Management", employeePanel);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		//3rd tab
		createDepartmentPanel();
		tabbedPane.addTab("Department Managment", departmentPanel);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		//4th tab
		createConfigurationPanel();
		tabbedPane.addTab("Configurations", configurationPanel);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
		
		mainPanel.add(tabbedPane);
		
		setContentPane(mainPanel);
		
	}
	
	private void createCheckingPanel() {
		
		//TODO Add components to checkingPanel
		checkingPanel = new JPanel();
		checkingPanel.setLayout(new BorderLayout());
		
		String[] header = HEADER_CHECKINGS_LIST_STRING;
		
		//TODO tmpCheckingData URGENT
		//*
		Object[][] tmpCheckingData = {
	              {"Johnathan", "Sykes", LocalTime.now(), LocalTime.now(), "TENNIS", LocalDate.now()},
	              {"Nicolas", "Van de Kampf", LocalTime.now(), LocalTime.now(), "FOOTBALL", LocalDate.now()},
	              {"Damien", "Cuthbert", LocalTime.now(), LocalTime.now(), "RIEN" , LocalDate.now()},
	              {"Corinne", "Valance", LocalTime.now(), LocalTime.now(), "NATATION" , LocalDate.now()},
	              {"Emilie", "Schrödinger", LocalTime.now(), LocalTime.now(), "FOOTBALL" , LocalDate.now()},
	              {"Delphine", "Duke", LocalTime.now(), LocalTime.now(), "TENNIS", LocalDate.now()},
	              {"Eric", "Trump", LocalTime.now(), LocalTime.now(), "FOOTBALL" , LocalDate.now()},
	    };//*/
		/*
		checkingData = new Object [model.getEmployeeList().size()][CHECKING_TABLE_NB_COLUMN];
		for (int i=0 ; i<model.getEmployeeList().size() ; i++) {
			checkingData[i][0] = model.getEmployeeList().get(i).getFirstName();
			checkingData[i][1] = model.getEmployeeList().get(i).getLastName();
			checkingData[i][2] = model.getEmployeeList().get(i).get;
			checkingData[i][3] = model.getEmployeeList()[i];
			checkingData[i][4] = model.getEmployeeList()[i];
		}
		*/
	 
	    checkingTable = new JTable(tmpCheckingData, header);
	    JScrollPane scrollPaneCheckings = new JScrollPane(checkingTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
	    JPanel sortByDatePanel = new JPanel();
	    sortByDatePanel.setLayout(new GridLayout(3,5,10,10));
	    sortFromDateTextField = new DateTextField();
	    sortToDateTextField = new DateTextField();
	    sortByDepartmentComboBox = new JComboBox<Department>(new Vector<Department>(model.getDepartmentList()));
	    sortByDatePanel.add(new JLabel(" "));
	    sortByDatePanel.add(new JLabel("Department :"));
	    sortByDatePanel.add(new JLabel("From :"));
	    sortByDatePanel.add(new JLabel("To :"));
	    for (int i=0 ; i<2 ; i++)
	    	sortByDatePanel.add(new JLabel(" "));
	    sortByDatePanel.add(sortByDepartmentComboBox);
	    sortByDatePanel.add(sortFromDateTextField);
	    sortByDatePanel.add(sortToDateTextField);
	    for (int i=0 ; i<5 ; i++)
	    	sortByDatePanel.add(new JLabel(" "));
	    System.out.println(sortFromDateTextField.getDate());
	    
	    checkingPanel.add(new JLabel("   "), BorderLayout.EAST);
	    checkingPanel.add(new JLabel("   "), BorderLayout.WEST);
		checkingPanel.add(new JLabel("   "), BorderLayout.NORTH);
		checkingPanel.add(sortByDatePanel, BorderLayout.SOUTH);
		checkingPanel.add(scrollPaneCheckings, BorderLayout.CENTER);
		
	}
	
	private void createEmployeePanel() {
		employeePanel = new JPanel();
		employeePanel.setLayout(new BorderLayout());
		
		String[] header = HEADER_EMPLOYEE_LIST_STRING;
		employeeData = new Object [model.getEmployeeList().size()][EMPLOYEE_TABLE_NB_COLUMN];
		for (int i=0 ; i<model.getEmployeeList().size() ; i++) {
			Employee tmpEmployee = model.getEmployeeList().get(i);
			employeeData[i][0] = tmpEmployee.getId();
			employeeData[i][1] = tmpEmployee.getFirstName();
			employeeData[i][2] = tmpEmployee.getLastName();
			employeeData[i][3] = model.findDepartment(tmpEmployee);
			employeeData[i][4] = tmpEmployee.getOvertime();
		}
		
		employeeTable = new JTable(employeeData, header);
		JScrollPane scrollPaneEmployee = new JScrollPane(employeeTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		employeePanel.add(scrollPaneEmployee);
		
		JPanel employeeButtonsPanel = new JPanel();
		employeeButtonsPanel.setLayout(new GridLayout(5,1,10,10));
		
		newEmployeeButton = new JButton(BUTTON_TEXT_CREATE_EMPLOYEE);
		modifyEmployeeButton = new JButton(BUTTON_TEXT_MODIFY_EMPLOYEE);
		deleteEmployeeButton = new JButton(BUTTON_TEXT_DELETE_EMPLOYEE);
		
		employeeButtonsPanel.add(new JLabel(" "));
		employeeButtonsPanel.add(newEmployeeButton);
		employeeButtonsPanel.add(modifyEmployeeButton);
		employeeButtonsPanel.add(deleteEmployeeButton);
		employeeButtonsPanel.add(new JLabel(""));
		
	    employeePanel.add(employeeButtonsPanel, BorderLayout.EAST);
	    employeePanel.add(new JLabel("   "), BorderLayout.SOUTH);
	    employeePanel.add(new JLabel("   "), BorderLayout.WEST);
	    employeePanel.add(new JLabel("   "), BorderLayout.NORTH);
	}
	
	private void createDepartmentPanel() {
		departmentPanel = new JPanel();
		departmentPanel.setLayout(new BorderLayout());
		
		String[] header = HEADER_DEPARTMENT_LIST_STRING;
		departmentData = new Object [model.getDepartmentList().size()][DEPARTMENT_TABLE_NB_COLUMN];
		for (int i=0 ; i<model.getDepartmentList().size() ; i++) {
			Department tmpDepartment = model.getDepartmentList().get(i);
			departmentData[i][0] = tmpDepartment.toString();
			departmentData[i][1] = tmpDepartment.getManager();
			departmentData[i][2] = tmpDepartment.getEmployeeList().size();
		}
		
		departmentTable = new JTable(departmentData, header);
		JScrollPane scrollPaneDepartment = new JScrollPane(departmentTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		departmentPanel.add(scrollPaneDepartment);
		
		JPanel departmentButtonsPanel = new JPanel();
		departmentButtonsPanel.setLayout(new GridLayout(5,1,10,10));
		
		newDepartmentButton = new JButton(BUTTON_TEXT_CREATE_DEPARTMENT);
		modifyDepartmentButton = new JButton(BUTTON_TEXT_MODIFY_DEPARTMENT);
		deleteDepartmentButton = new JButton(BUTTON_TEXT_DELETE_DEPARTMENT);

		departmentButtonsPanel.add(new JLabel(""));
		departmentButtonsPanel.add(newDepartmentButton);
		departmentButtonsPanel.add(modifyDepartmentButton);
		departmentButtonsPanel.add(deleteDepartmentButton);
		departmentButtonsPanel.add(new JLabel(""));
		
		departmentPanel.add(departmentButtonsPanel, BorderLayout.EAST);
		departmentPanel.add(new JLabel("   "), BorderLayout.SOUTH);
		departmentPanel.add(new JLabel("   "), BorderLayout.WEST);
		departmentPanel.add(new JLabel("   "), BorderLayout.NORTH);
		
	}
	
	private void createConfigurationPanel() {
		
		configurationPanel = new JPanel();
		configurationPanel.setLayout(new BorderLayout());
		configurationPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		configurationPanel.add(new JLabel("   "), BorderLayout.EAST);
		configurationPanel.add(new JLabel("   "), BorderLayout.WEST);
		configurationPanel.add(new JLabel("   "), BorderLayout.NORTH);
		configurationPanel.add(new JLabel("   "), BorderLayout.SOUTH);
		
		JPanel secondaryPanel = new JPanel();
		secondaryPanel.setLayout(new GridLayout(3,4,10,10));
		
		// ================ incident of scores panel ====================
		JPanel incidentsOfScoresPanel = new JPanel();
		incidentsOfScoresPanel.setLayout(new GridLayout(4,0,10,10));
		JLabel checkingsLabel = new JLabel(LABEL_INCIDENT_OF_SCORES);
		checkingsLabel.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
		incidentsOfScoresPanel.add(checkingsLabel);
		JCheckBox lateArrival = new JCheckBox(LABEL_SHOW_ARRIVALS);
		lateArrival.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
		incidentsOfScoresPanel.add(lateArrival);
		JCheckBox earlyLeaving = new JCheckBox(LABEL_SHOW_LEAVINGS);
		earlyLeaving.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
		incidentsOfScoresPanel.add(earlyLeaving);
		incidentsOfScoresPanel.add(new JLabel(" "));
		
		// ================ TCP connection panel ====================
		JPanel TCPConnexionPanel = new JPanel();
		TCPConnexionPanel.setLayout(new GridLayout(6,1,10,10));
		JLabel TCPLabel = new JLabel(LABEL_TCP_CONNECTION);
		TCPLabel.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
		TCPConnexionPanel.add(TCPLabel);
		JLabel IPAdressLabel = new JLabel(LABEL_IP_ADRESS);
		TCPConnexionPanel.add(IPAdressLabel);
		IPAdressTextField = new JTextField();
		TCPConnexionPanel.add(IPAdressTextField);
		JLabel PortLabel = new JLabel(LABEL_PORT);
		TCPConnexionPanel.add(PortLabel);
		PortTextField = new JTextField();
		TCPConnexionPanel.add(PortTextField);
		ButtonGroup IPGroup = new ButtonGroup();
		IPV4RadioButton = new JRadioButton(RADIO_TEXT_IPV4);
		IPV4RadioButton.setSelected(true);
		IPV6RadioButton = new JRadioButton(RADIO_TEXT_IPV6);
		IPGroup.add(IPV4RadioButton);
		IPGroup.add(IPV6RadioButton);
		JPanel IPPanel = new JPanel();
		IPPanel.add(IPV4RadioButton);
		IPPanel.add(IPV6RadioButton);
		TCPConnexionPanel.add(IPPanel);
		//TODO Format text field
		
		// ================ CSV management ===================
		JPanel CSVPanel = new JPanel();
		CSVPanel.setLayout(new GridLayout(3,1,10,10));
		CSVExportButton = new JButton(BUTTON_TEXT_CSV_EXPORT);
		CSVImportButton = new JButton(BUTTON_TEXT_CSV_IMPORT);
		JLabel CSVLabel = new JLabel(LABEL_CSV);
		CSVLabel.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
		CSVPanel.add(CSVLabel);
		CSVPanel.add(CSVExportButton);
		CSVPanel.add(CSVImportButton);
		
		// ============ add panels and gaps =============
		secondaryPanel.add(incidentsOfScoresPanel);
		for (int i=0 ; i<5 ; i++)
			secondaryPanel.add(new JLabel(" "));
		
		secondaryPanel.add(TCPConnexionPanel);		
		for (int i=0 ; i<5 ; i++)
			secondaryPanel.add(new JLabel(" "));

		secondaryPanel.add(CSVPanel);
		for (int i=0 ; i<5 ; i++)
			secondaryPanel.add(new JLabel(" "));
		
		configurationPanel.add(secondaryPanel);
		
	}
	
	public void refresh() {
		//TODO refresh
	}
	
	public JButton getNewEmployeeButton() {
		return newEmployeeButton;
	}

	public JButton getModifyEmployeeButton() {
		return modifyEmployeeButton;
	}

	public JButton getDeleteEmployeeButton() {
		return deleteEmployeeButton;
	}

	public JButton getNewDepartmentButton() {
		return newDepartmentButton;
	}

	public JButton getModifyDepartmentButton() {
		return modifyDepartmentButton;
	}

	public JButton getDeleteDepartmentButton() {
		return deleteDepartmentButton;
	}

	public JButton getCSVExportButton() {
		return CSVExportButton;
	}

	public JButton getCSVInportButton() {
		return CSVImportButton;
	}

	public JRadioButton getIPV4RadioButton() {
		return IPV4RadioButton;
	}

	public JRadioButton getIPV6RadioButton() {
		return IPV6RadioButton;
	}

	public DateTextField getSortFromDateTextField() {
		return sortFromDateTextField;
	}

	public DateTextField getSortToDateTextField() {
		return sortToDateTextField;
	}

}
