package polytech.javaproject.mainapp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import polytech.javaproject.model.Company;

public class ViewMainApp extends JFrame {

	private static final String WINDOW_TITLE = "Employee Managment [WORK IN PROGRESS]";
	private static final int WINDOW_HEIGHT = 720;
	private static final int WINDOW_WIDTH = 1280;
	private static final boolean WINDOW_RESIZABLE = false;
	private static final String FONT_NAME = "Dialog";
	private static final int FONT_STYLE = Font.BOLD;
	private static final int FONT_SIZE = 15;
	private static final String LABEL_INCIDENT_OF_SCORES = "Incident of scores :";
	private static final String LABEL_SHOW_ARRIVALS = "Show late arrivals";
	private static final String LABEL_SHOW_LEAVINGS = "Show early leavings";
	private static final String LABEL_IP_ADRESS = "IP Address :";
	private static final String LABEL_PORT = "Port :";
	
	private Company model;
	
	private JPanel mainPanel;
	private JTabbedPane tabbedPane;
	private JPanel checkingPanel;
	private JPanel employeePanel;
	private JPanel departmentPanel;
	private JPanel configurationPanel;
	private JTextField IPAdressTextField;
	private JTextField PortTextField;
	
	public ViewMainApp(Company company) {
		//import model
		model = company;
		//create main panel
		mainPanel = new JPanel();
		build();
		setMainPanel();
		//System.out.println(javax.swing.UIManager.getDefaults().getFont("Label.font"));
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
		JComponent panel2 = makeTextPanel("Panel #2");
		tabbedPane.addTab("Tab 2", panel2);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		//3rd tab
		JComponent panel3 = makeTextPanel("Panel #3");
		tabbedPane.addTab("Tab 3", panel3);
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
		
		 Object[][] donnees = {
	               {"Johnathan", "Sykes", Color.red, true, "TENNIS"},
	               {"Nicolas", "Van de Kampf", Color.black, true, "FOOTBALL"},
	               {"Damien", "Cuthbert", Color.cyan, true, "RIEN"},
	               {"Corinne", "Valance", Color.blue, false, "NATATION"},
	               {"Emilie", "Schrödinger", Color.magenta, false, "FOOTBALL"},
	               {"Delphine", "Duke", Color.yellow, false, "TENNIS"},
	               {"Eric", "Trump", Color.pink, true, "FOOTBALL"},
	    };
	 
	    String[] entetes = {"Prénom", "Nom", "Couleur favorite", "Homme", "Sport"};
	    
	    JScrollPane scrollPane = new JScrollPane();
	    JTable tableau = new JTable(donnees, entetes);
		
		checkingPanel.add(tableau);
		
	}
	
	private void createEmployeePanel() {
		//TODO employeePanel
	}
	
	private void createDepartmentPanel() {
		//TODO departmentPanel
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
		secondaryPanel.setLayout(new GridLayout(4,4,10,10));
		
		JPanel incidentsOfScoresPanel = new JPanel();
		incidentsOfScoresPanel.setLayout(new GridLayout(3,0,10,10));
		JLabel checkingsLabel = new JLabel(LABEL_INCIDENT_OF_SCORES);
		checkingsLabel.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
		incidentsOfScoresPanel.add(checkingsLabel);
		JCheckBox lateArrival = new JCheckBox(LABEL_SHOW_ARRIVALS);
		lateArrival.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
		incidentsOfScoresPanel.add(lateArrival);
		JCheckBox earlyLeaving = new JCheckBox(LABEL_SHOW_LEAVINGS);
		earlyLeaving.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
		incidentsOfScoresPanel.add(earlyLeaving);
		
		JPanel TCPConnexionPanel = new JPanel();
		TCPConnexionPanel.setLayout(new GridLayout(4,1,10,10));
		JLabel IPAdressLabel = new JLabel(LABEL_IP_ADRESS);
		TCPConnexionPanel.add(IPAdressLabel);
		IPAdressTextField = new JTextField();
		TCPConnexionPanel.add(IPAdressTextField);
		JLabel PortLabel = new JLabel(LABEL_PORT);
		TCPConnexionPanel.add(PortLabel);
		PortTextField = new JTextField();
		TCPConnexionPanel.add(PortTextField);
		
		secondaryPanel.add(incidentsOfScoresPanel);
		secondaryPanel.add(TCPConnexionPanel);
		configurationPanel.add(secondaryPanel);
		
		//TODO Add TCP components (texts inputs)
		
	}
	
	//*
	//TODO : Delete temporary method
	private JComponent makeTextPanel(String text) {
	    JPanel panel = new JPanel(false);
	    JTextField filler = new JTextField(text);
	    filler.setHorizontalAlignment(JLabel.CENTER);
	    panel.setLayout(new GridLayout(1, 1));
	    panel.add(filler);
	    return panel;
	}
	//*/
}
