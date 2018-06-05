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

//TODO MODIFIER LE POPUP POUR LA CREATION DE DEPARTMENT

public class DepartmentDialog extends JDialog {
	  private boolean sendData;
	  private JLabel nomLabel, lastNameLabel, departmentLabel, statusLabel, tailleLabel,taille2Label;
	  private JRadioButton employeeRadioButton, managerRadioButton;
	  private JComboBox departmentComboBox;
	  private JTextField firstName, lastName, taille;
	  
	  private ArrayList<Department> departmentList;

	  public DepartmentDialog(JFrame parent, String title, boolean modal, ArrayList<Department> list){
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
	    JPanel panAge = new JPanel();
	    panAge.setBackground(Color.white);
	    panAge.setBorder(BorderFactory.createTitledBorder("Status"));
	    panAge.setPreferredSize(new Dimension(440, 60));
	    employeeRadioButton = new JRadioButton("Employee");
	    employeeRadioButton.setSelected(true);
	    managerRadioButton = new JRadioButton("Manager");
	    ButtonGroup bg = new ButtonGroup();
	    bg.add(employeeRadioButton);
	    bg.add(managerRadioButton);
	    panAge.add(employeeRadioButton);
	    panAge.add(managerRadioButton);

	    //La taille
	    JPanel panTaille = new JPanel();
	    panTaille.setBackground(Color.white);
	    panTaille.setPreferredSize(new Dimension(220, 60));
	    panTaille.setBorder(BorderFactory.createTitledBorder("test"));
	    tailleLabel = new JLabel("Taille : ");
	    taille2Label = new JLabel(" cm");
	    taille = new JTextField("180");
	    taille.setPreferredSize(new Dimension(90, 25));
	    panTaille.add(tailleLabel);
	    panTaille.add(taille);
	    panTaille.add(taille2Label);

	    //department
	    JPanel panCheveux = new JPanel();
	    panCheveux.setBackground(Color.white);
	    panCheveux.setPreferredSize(new Dimension(220, 60));
	    panCheveux.setBorder(BorderFactory.createTitledBorder("Department"));
	    departmentComboBox = new JComboBox<Department>(new Vector<Department>(departmentList));
	    departmentLabel = new JLabel();
	    panCheveux.add(departmentLabel);
	    panCheveux.add(departmentComboBox);

	    JPanel content = new JPanel();
	    content.setBackground(Color.white);
	    content.add(panFirstName);
	    content.add(lastNamePanel);
	    content.add(panAge);
	    content.add(panTaille);
	    content.add(panCheveux);

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
	        return (taille.getText().equals("")) ? "180" : taille.getText();
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
