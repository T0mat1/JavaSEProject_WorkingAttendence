package polytech.javaproject.test.model;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import polytech.javaproject.model.*;

public class CompanyTest {

	private Company company;
	private RoundedHour start;
	private RoundedHour end;
	private Employee employee;
	private Manager manager;
	private Department department;
	
	@Before
	public void setUp() {
		company = new Company("Aperture");
		start = new RoundedHour(LocalDateTime.now());
		end = new RoundedHour(LocalDateTime.now().plusHours(8));
		employee = new Employee("Caroline", "Glados", start, end);
		manager = new Manager("Robert", "Paulson", start, end);
		department = new Department("R&D");
		company.addEmployee(manager);
		company.addEmployeeToDepartment(manager.getId(), department);
	}

	@Test
	public void testAddDepartment() {
		ArrayList<Department> departmentList = new ArrayList<>();
		departmentList.add(department);
		company.addDepartment(department);
		Assert.assertEquals(departmentList, company.getDepartmentList());
	}
	
	@Test
	public void testAddEmployee() {
		company.addEmployee(employee);
		Assert.assertEquals(true, company.getEmployeeList().contains(employee));
	}

	@Test
	public void testAddEmployeeToDepartment() {
		company.addEmployee(employee);
		company.addEmployeeToDepartment(employee.getId(), department);
		Assert.assertEquals(true, department.containsEmployee(employee));
	}
	
	@Test
	public void testFindEmployee_OK() {
		company.addEmployee(employee);
		Assert.assertEquals(employee, company.findEmployee(employee.getId()));
	}
	
	@Test
	public void testFindEmployee_KO() {
		Assert.assertEquals(null, company.findEmployee(employee.getId()));
	}
	
	@Test
	public void testFindDepartment_OK() {
		company.addDepartment(department);
		department.addEmployee(employee);
		Assert.assertEquals(department, company.findDepartment(employee));
	}
	
	@Test
	public void testFindDepartment_KO() {
		Assert.assertEquals(null, company.findDepartment(manager));
	}
	
	@Test
	public void testRemoveEmployee() {
		company.addEmployee(employee);
		department.addEmployee(employee);
		company.addDepartment(department);
		department.setManager(manager);
		company.removeEmployee(employee.getId());
		Assert.assertEquals(false, department.containsEmployee(employee));
		Assert.assertEquals(null, company.findEmployee(employee.getId()));
	}
	
	@Test
	public void testMoveEmployeeToDepartment() {
		company.addEmployee(employee);
		department.addEmployee(employee);
		company.addDepartment(department);
		department.setManager(manager);
		int id = company.createManager("Odile", "Deray", start, end);
		Department newDepartment = company.createDepartment("Marketing", company.findManager(id));
		company.moveEmployeeToDepartment(employee.getId(), newDepartment);
		Assert.assertEquals(false, department.containsEmployee(employee));
		Assert.assertEquals(true, newDepartment.containsEmployee(employee));
	}
	
}
