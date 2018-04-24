package polytech.javaproject.model;

import java.util.ArrayList;

/**
 * Company is a class representing the company (employees and departments)
 * 
 * @author Thomas Rossi
 * @version 1.1
 */

public class Company {
	
	// ------------------------------------ Attributes ------------------------------------
	
	/**
	 * String which contains the name of the company
	 */
	private String name;
	/**
	 * ArrayList of Departments
	 * @see Department
	 */
	private ArrayList<Department> departmentList;
	/**
	 * ArrayList of Employees
	 * @see Employee
	 */
	private ArrayList<Employee> employeeList;
	/**
	 * ArrayList of Managers
	 * @see Manager
	 */
	private ArrayList<Manager> managerList;

	
	// ------------------------------------ Constructor ------------------------------------
	
	/**
	 * Constructor for the object Company 
	 * @param newName the name of the company
	 */
	public Company(String newName) {
		name = newName;
		departmentList = new ArrayList<Department>();
		employeeList = new ArrayList<Employee>();
		managerList = new ArrayList<Manager>();
	}

	// ------------------------------------ Getters ------------------------------------
	
	/**
	 * Getter for the name of the company
	 * @return the String containing the name of the company
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for the list of departments
	 * @return the ArrayList containing the list of departments
	 */
	public ArrayList<Department> getDepartmentList() {
		return departmentList;
	}

	/**
	 * Getter for the list of employees
	 * @return the ArrayList containing the list of employees
	 */
	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}
	
	/**
	 * Getter for the list of managers
	 * @return the ArrayList containing the list of employees
	 */
	public ArrayList<Manager> getManagerList() {
		return managerList;
	}

	// ------------------------------------ Setters ------------------------------------
	
	/**
	 * Setter to modify the name of the company
	 * @param name a String containing the new name of the company
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	// ------------------------------------ Methods ------------------------------------
	
	/**
	 * Create a new department and add it to the department list
	 * @param name a String which contains the name of the new department
	 * @param manager an instance of Manager which contains the new manager of the new department
	 * @see Manager
	 */
	public Department createDepartment(String name, Manager manager) {
		Department newDepartment = new Department(name);
		newDepartment.addEmployee(manager);
		newDepartment.setManager(manager);
		departmentList.add(newDepartment);
		return newDepartment;
	}
	
	/**
	 * Add a new department to the list of departments
	 * @param newDepartment a new Department added to departmentList
	 * @see Department
	 */
	public void addDepartment(Department newDepartment) {
		departmentList.add(newDepartment);
	}
	
	/**
	 * Create an employee and add him/her to the list of employees
	 * @param firstN a String containing the first name of the employee
	 * @param lastN a String containing the last name of the employee
	 * @param startingHour a RoundedHour which contains the hour of the beginning of his/her working day
	 * @param endingHour a RoundedHour which contains the hour of the end of his/her working day
	 * @see Employee
	 */
	public int createEmployee(String firstN, String lastN, RoundedHour startingHour, RoundedHour endingHour) {
		Employee newEmployee = new Employee(firstN, lastN, startingHour, endingHour);
		employeeList.add(newEmployee);
		return newEmployee.getId();
	}
	
	/**
	 * Create a manager and add him/her to the list of employees
	 * @param firstN a String containing the first name of the manager
	 * @param lastN a String containing the last name of the manager
	 * @param startingHour a RoundedHour which contains the hour of the beginning of his/her working day
	 * @param endingHour a RoundedHour which contains the hour of the end of his/her working day
	 * @see Manager
	 */
	public int createManager(String firstN, String lastN, RoundedHour startingHour, RoundedHour endingHour) {
		Manager newManager = new Manager(firstN, lastN, startingHour, endingHour);
		employeeList.add(newManager);
		managerList.add(newManager);
		return newManager.getId();
	}
	
	/**
	 * Add a new employee to the list of employees
	 * @param newEmployee a new Employee added to employeeList
	 * @see Employee
	 */
	public void addEmployee(Employee newEmployee) throws IllegalArgumentException {
		if(isInEmployeeList(newEmployee)) {
			throw new IllegalArgumentException("This employee already exist in the entreprise");
		}
		employeeList.add(newEmployee);
	}
	
	/**
	 * Add a new employee to the list of employees
	 * @param newEmployee a new Employee added to employeeList
	 * @see Employee
	 */
	public void addManager(Manager newManager) throws IllegalArgumentException {
		if(isInEmployeeList(newManager)) {
			throw new IllegalArgumentException("This manager already exist in the entreprise");
		}
		employeeList.add(newManager);
		managerList.add(newManager);
	}
	
	/**
	 * Add an employee which already belong to the company to a department
	 * @param id a double which contains the id of the Employee
	 * @param department a Department in departmentList
	 * @see Employee
	 * @see Department
	 */
	public void addEmployeeToDepartment(int id, Department department) {
		Employee newEmployee = findEmployee(id);
		if (!(employeeList.contains(newEmployee)))
			throw new IllegalArgumentException("This employee does not belong to the company");
		for(Department d : departmentList) {
			if (d.getEmployeeList().contains(newEmployee)) {
				throw new IllegalArgumentException("This employee already belong to a department");
			}
		}
		department.addEmployee(newEmployee);
	}
	
	/**
	 * A method which return an employee of the company thanks to his id
	 * @param id a double containing the id of the employee
	 * @return an instance of Employee if there is an employee with id equals to the parameter, else returns null
	 * @see Employee
	 */
	public Employee findEmployee(double id) {
		for (Employee e : employeeList) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}
	
	/**
	 * A method which return an employee of the company thanks to his id
	 * @param id a double containing the id of the employee
	 * @return an instance of Employee if there is an employee with id equals to the parameter, else returns null
	 * @see Employee
	 */
	public Manager findManager(double id) {
		for (Manager m : managerList) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}
	
	/**
	 * A method which return the department of the given employee
	 * @param employee an instance of Employee
	 * @return an instance of a Department if the employee belong to a department, else returns null
	 * @see Employee
	 * @see Department
	 */
	public Department findDepartment(Employee employee) {
		for (Department d : departmentList) {
			if (d.containsEmployee(employee)) {
				return d;
			}
		}
		return null;
	}
	
	/**
	 * A method which removes the employee from the company and from his department
	 * @param id a double containing the id of the employee
	 */
	public void removeEmployee(double id) {
		Employee employee = findEmployee(id);
		Department department = findDepartment(employee);
		department.removeEmployee(employee);
		employeeList.remove(employee);
	}
	
	/**
	 * A method which removes the employee from his department
	 * @param id a double containing the id of the employee
	 */
	private void removeEmployeeFromDepartment(double id) {
		Employee employee = findEmployee(id);
		Department department = findDepartment(employee);
		department.removeEmployee(employee);
	}
	
	/**
	 * A method which transfers an employee from his current department to an other
	 * @param id a double containing the id of the employee
	 * @param newDepartment the instance of the new department of the employee
	 * @see Department
	 */
	public void moveEmployeeToDepartment(int  id, Department newDepartment) {
		removeEmployeeFromDepartment(id);
		addEmployeeToDepartment(id, newDepartment);
	}
	
	/**
	 * A method which remove a department from the department list
	 * The employees are not moved in an other department
	 * @param department
	 * @see Department
	 */
	public void removeDepartment(Department department) {
		departmentList.remove(department);
	}

	/**
	 * A method which return true if the employee is in the company, else returns false
	 * @param employee an instance of Employee
	 * @return a boolean : true if the employee is in the company, else returns false
	 */
	private boolean isInEmployeeList(Employee employee) {
		for (Employee e : employeeList) {
			if (e.getId() == employee.getId())
				return true;
		}
		return false;
	}
	
}
