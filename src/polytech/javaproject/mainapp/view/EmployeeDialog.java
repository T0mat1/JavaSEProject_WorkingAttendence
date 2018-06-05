package polytech.javaproject.mainapp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import polytech.javaproject.model.Department;

public class EmployeeDialog extends JDialog {
	  private boolean sendData;
	  private JLabel nomLabel, lastNameLabel, departmentLabel, statusLabel, fromTimeLabel,toTimeLabel;
	  private JRadioButton employeeRadioButton, managerRadioButton;
	  private JComboBox departmentComboBox;
	  private JTextField firstName, lastName, fromTime, toTime;
	  
	  private ArrayList<Department> departmentList;

	  public EmployeeDialog(JFrame parent, String title, boolean modal, ArrayList<Department> list){
	    super(parent, title, modal);
	    departmentList = list;
	    this.setSize(550, 270);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    this.initComponent();
	  }

	  private void initComponent(){

	    //firstname
	    JPanel panFirstName = new JPanel();
	    panFirstName.setBackground(Color.white);
	    panFirstName.setPreferredSize(new Dimension(220, 60));
	    firstName = new JTextField();
	    firstName.setPreferredSize(new Dimension(100, 25));
	    panFirstName.setBorder(BorderFactory.createTitledBorder("Name "));
	    nomLabel = new JLabel("First Name :");
	    panFirstName.add(nomLabel);
	    panFirstName.add(firstName);

	    //lastname
	    JPanel lastNamePanel = new JPanel();
	    lastNamePanel.setBackground(Color.white);
	    lastNamePanel.setPreferredSize(new Dimension(220, 60));
	    lastName = new JTextField();
	    lastName.setPreferredSize(new Dimension(100, 25));
	    lastNamePanel.setBorder(BorderFactory.createTitledBorder(" "));
	    lastNameLabel = new JLabel("Last Name : ");
	    lastNamePanel.add(lastNameLabel);
	    lastNamePanel.add(lastName);

	    //manager or not
	    JPanel statusPane = new JPanel();
	    statusPane.setBackground(Color.white);
	    statusPane.setBorder(BorderFactory.createTitledBorder("Status"));
	    statusPane.setPreferredSize(new Dimension(220, 60));
	    employeeRadioButton = new JRadioButton("Employee");
	    employeeRadioButton.setSelected(true);
	    managerRadioButton = new JRadioButton("Manager");
	    ButtonGroup bg = new ButtonGroup();
	    bg.add(employeeRadioButton);
	    bg.add(managerRadioButton);
	    statusPane.add(employeeRadioButton);
	    statusPane.add(managerRadioButton);

	    //hours
	  //TODO Modifier methode pour entrer des heures
	    JPanel hoursPane = new JPanel();
	    hoursPane.setBackground(Color.white);
	    hoursPane.setPreferredSize(new Dimension(440, 60));
	    hoursPane.setBorder(BorderFactory.createTitledBorder("Working hours"));
	    fromTimeLabel = new JLabel("From :");
	    toTimeLabel = new JLabel("To :");
	    fromTime = new JTextField("HH-MM");
	    fromTime.setPreferredSize(new Dimension(90, 25));
	    toTime = new JTextField("HH-MM");
	    toTime.setPreferredSize(new Dimension(90, 25));
	    hoursPane.add(fromTimeLabel);
	    hoursPane.add(fromTime);
	    hoursPane.add(toTimeLabel);
	    hoursPane.add(toTime);

	    //department
	    JPanel departmentPane = new JPanel();
	    departmentPane.setBackground(Color.white);
	    departmentPane.setPreferredSize(new Dimension(220, 60));
	    departmentPane.setBorder(BorderFactory.createTitledBorder("Department"));
	    departmentComboBox = new JComboBox<Department>(new Vector<Department>(departmentList));
	    departmentLabel = new JLabel();
	    departmentPane.add(departmentLabel);
	    departmentPane.add(departmentComboBox);

	    JPanel content = new JPanel();
	    content.setBackground(Color.white);
	    content.add(panFirstName);
	    content.add(lastNamePanel);
	    content.add(statusPane);
	    content.add(departmentPane);
	    content.add(hoursPane);

	    JPanel control = new JPanel();
	    JButton okBouton = new JButton("OK");
	    
	    okBouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {        
	        setVisible(false);
	      }

	      public String getStatus(){
	        return (employeeRadioButton.isSelected()) ? employeeRadioButton.getText() : 
	               (managerRadioButton.isSelected()) ? managerRadioButton.getText() :
	                employeeRadioButton.getText();  
	      }

	      public String getTaille(){
	    	  //TODO Modifier methode pour entrer des heures
	        return (fromTime.getText().equals("")) ? "180" : fromTime.getText();
	      }      
	    });

	    JButton cancelBouton = new JButton("Annuler");
	    cancelBouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
	        setVisible(false);
	      }      
	    });

	    control.add(okBouton);
	    control.add(cancelBouton);

	    this.getContentPane().add(new JLabel(" "), BorderLayout.WEST);
	    this.getContentPane().add(content, BorderLayout.CENTER);
	    this.getContentPane().add(control, BorderLayout.SOUTH);
	  }  
}
