package polytech.javaproject.mainapp.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import polytech.javaproject.model.Company;

public class ViewMainApp extends JFrame {

	private static final String WINDOW_TITLE = "Employee Managment [PRE-PRE-PRE-PRE-ALPHA]";
	private static final int WINDOW_HEIGHT = 720;
	private static final int WINDOW_WIDTH = 1280;
	private static final boolean WINDOW_RESIZABLE = false;
	
	private Company model;
	
	private JPanel mainPanel;
	private JTabbedPane tabbedPane;
	private JPanel checkingPanel;
	private JPanel employeePanel;
	private JPanel departmentPanel;
	private JPanel configurationPanel;
	
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
		
		createCheckingPanel();
		tabbedPane.addTab("Checkings", checkingPanel);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JComponent panel2 = makeTextPanel("Panel #2");
		tabbedPane.addTab("Tab 2", panel2);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		JComponent panel3 = makeTextPanel("Panel #3");
		tabbedPane.addTab("Tab 3", panel3);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		JComponent panel4 = makeTextPanel("Panel #4");
		panel4.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		tabbedPane.addTab("Tab 4", panel4);
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
		//TODO configurationPanel
	}
	
	//*
	private JComponent makeTextPanel(String text) {
	    JPanel panel = new JPanel(false);
	    JLabel filler = new JLabel(text);
	    filler.setHorizontalAlignment(JLabel.CENTER);
	    panel.setLayout(new GridLayout(1, 1));
	    panel.add(filler);
	    return panel;
	}
	//*/
}
