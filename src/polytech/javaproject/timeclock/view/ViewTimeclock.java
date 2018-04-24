package polytech.javaproject.timeclock.view;

import java.awt.Color;

import javax.swing.GroupLayout;
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
	private static final String PANELDEFAULTTIME = "HH - MM";
	
	private Company model;
	private JPanel panel;
	private JLabel dateLabel;
	private JLabel timeLabel;
	
	public ViewTimeclock(Company newModel) {
		//set up the model
		model = setModel(newModel);
		//create new window
		build();
		//add components to the panel
		setPanel();
		//set up the layout
		setLayout();
	}
	
	private void build() {
		setTitle(WINDOWTITLE);
		setSize(WINDOWWIDTH, WINDOWHEIGHT);
		setResizable(WINDOWRESIZABLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		panel = new JPanel();
	}
	
	private void setLayout() {
		GroupLayout layout = new GroupLayout(panel);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		//vertical
		layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addComponent(timeLabel)
				.addComponent(dateLabel)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER))
		);
		/*
		//horizontal
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
				//.addGroup(layout.createParallelGroup())
		);
		*/
	}
	
	private void setPanel() {
		panel.setBackground(Color.WHITE);
		
		dateLabel = new JLabel(PANELDEFAULTDATE);
		panel.add(dateLabel);
		timeLabel = new JLabel(PANELDEFAULTTIME);
		panel.add(timeLabel);
		
		setContentPane(panel);
	}
	
	private Company setModel(Company newModel) {
		return newModel;		
	}
	
}
