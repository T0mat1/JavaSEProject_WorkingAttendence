package polytech.javaproject.timeclock.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import polytech.javaproject.model.Company;

public class ViewTimeclock extends JFrame {

	private static final String WINDOWTITLE = "Time Clock Simulation V1.0";
	private static final int WINDOWWIDTH = 400;
	private static final int WINDOWHEIGHT  = 300;
	private static final boolean WINDOWRESIZABLE = true;
	private static final String PANELDEFAULTDATE = "JJ - MM - AAAA";
	private static final String PANELDEFAULTTIME = "HH - MM - SS";
	
	private Company model;
	private JPanel panel;
	private JLabel dateLabel;
	private JLabel timeLabel;
	private JLabel departmentLabel;
	private JLabel employeeLabel;
	private JLabel roundedTimeLabel;
	private JButton checkButton;
	private JComboBox departmentComboBox;
	private JComboBox employeeComboBox;
	
	public ViewTimeclock(Company newModel) {
		//set up the model
		model = setModel(newModel);
		//create new window
		build();
		//set up the layout
		setLayout();
		//add components to the panel
		setPanel();
	}
	
	private void build() {
		setTitle(WINDOWTITLE);
		setSize(WINDOWWIDTH, WINDOWHEIGHT);
		setResizable(WINDOWRESIZABLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		panel = new JPanel();
		timeLabel = new JLabel(PANELDEFAULTTIME);
		dateLabel = new JLabel(PANELDEFAULTDATE);
	}
		
	private void setLayout() {
		GridLayout layout = new GridLayout();
		
	}
	
	private void setPanel() {
		panel.setBackground(Color.WHITE);
		panel.add(dateLabel);
		panel.add(timeLabel);
		
		setContentPane(panel);
	}
	
	private Company setModel(Company newModel) {
		return newModel;		
	}
	
}
