package polytech.javaproject.test.model;

import static org.junit.Assert.fail;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import polytech.javaproject.model.Department;
import polytech.javaproject.model.Employee;
import polytech.javaproject.model.Manager;
import polytech.javaproject.model.RoundedHour;

public class DepartmentTest {

	private Department department;
	private Manager manager;
	private Manager unknownManager;
	private Employee employee;
	
	@Before
	public void setUp() {
		department = new Department("R&D");
		manager = new Manager("Jean", "Bon",
				new RoundedHour(LocalDateTime.now()), new RoundedHour(LocalDateTime.now().plusHours(8)));
		unknownManager = new Manager("Sarah", "Connor",
				new RoundedHour(LocalDateTime.now()), new RoundedHour(LocalDateTime.now().plusHours(8)));
		employee = new Employee("Jimi", "Hendrix",
				new RoundedHour(LocalDateTime.now()), new RoundedHour(LocalDateTime.now().plusHours(8)));
		department.addEmployee(manager);
		department.addEmployee(employee);
	}
	
	@Test
	public void testSetManager_OK() {
		try {
			department.setManager(manager);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(manager, department.getManager());
	}

	@Test
	public void testSetManager_KO() {
		try {
			department.setManager(unknownManager);
			fail("Exception must be caught");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals(true, e instanceof IllegalArgumentException);
		}
	}
	
	@Test
	public void testContainsEmployee_OK() {
		Assert.assertEquals(true, department.containsEmployee(employee));
	}
	
	@Test
	public void testContainsEmployee_KO() {
		Assert.assertEquals(false, department.containsEmployee(unknownManager));
	}

	@Test
	public void testRemoveEmployee_OK() {
		department.setManager(manager);
		try {
			department.removeEmployee(employee);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(false, department.containsEmployee(employee));
	}

	@Test
	public void testRemoveEmployee_KO() {
		department.setManager(manager);
		try {
			department.removeEmployee(manager);
			fail("Exception must be caught");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals(true, e instanceof IllegalArgumentException);
		}
	}
	
}
