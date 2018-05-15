package polytech.javaproject.model;

import java.util.ArrayList;

/**
 * Department is a class representing a department (employees and a manager)
 * 
 * @author Thomas Rossi
 * @version 1.0
 */
public class Department {
	
	// ------------------------------------ Attributes ------------------------------------
	
	/**
	 * String which contains the name of the department
	 */
	private String name;

	/**
	 * ArrayList of all the employees in the department
	 * @see Employee
	 */
	private ArrayList<Employee> employeeList;
	
	/**
	 * Manager in charge of the department
	 * @see Manager
	 */
	private Manager manager;
	
	// ------------------------------------ Constructor ------------------------------------
	
	/**
	 * Constructor which instantiate an new Department, sets the name with new name,
	 * instantiate the employee list and sets the manager with null
	 * @param newName a String containing the name of the department
	 * @param object 
	 */
	public Department(String newName) {
		name = newName;
		employeeList = new ArrayList<Employee>();
		manager = null;
	}

	// ------------------------------------ Getters ------------------------------------
	
	/**
	 * Getter for the name of the department
	 * @return the String containing the name of the department
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for the list of employees
	 * @return the ArrayList containing the list of Employees in the department
	 * @see Employee
	 */
	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	/**
	 * Getter for the manager
	 * @return the instance of Manager in charge of this department
	 * @see Manager
	 */
	public Manager getManager() {
		return manager;
	}

	// ------------------------------------ Setters ------------------------------------
	
	/**
	 * Setter which replace the name of the department by a new one
	 * @param newName a String which contains the new name of the department
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Setter which sets or modifies the manager in charge of the department
	 * @param newManager an instance of Manager which contains the new Manager
	 * @throws IllegalArgumentException if newManager is not an employee of this department
	 * @see Manager
	 */
	public void setManager(Manager newManager) throws IllegalArgumentException {
		if (employeeList.contains(newManager)) {
			manager = newManager;
		} else {
			throw new IllegalArgumentException("Didn't find the manager");
		}
	}
	
	// ------------------------------------ Methods ------------------------------------
	
	/**
	 * A method which adds an employee to the department
	 * @param newEmployee an instance of the new employee which is added to the employee list
	 * @see Employee
	 */
	public void addEmployee(Employee newEmployee) {
		employeeList.add(newEmployee);
	}

	/**
	 * A method which removes an employee from the department
	 * @param employee an instance of the employee which is removed of the department
	 * @throws IllegalArgumentException
	 * @see Employee
	 */
	public void removeEmployee(Employee employee) throws IllegalArgumentException {
		if (employee.getId() == manager.getId())
			throw new IllegalArgumentException("Cannot remove the current manager");
		else
			employeeList.remove(employee); 
	}
	
	/**
	 * A method which says for a given employee if he/she is in the department or not
	 * @param employee an instance of Employee
	 * @return a boolean which equals true if the employee is in the department, else equals false
	 * @see Employee
	 */
	public boolean containsEmployee(Employee employee) {
		return employeeList.contains(employee);
	}
	
	/**
	 * Override of toString method
	 */
	@Override
	public String toString() {
		return name;
	}
	
}
