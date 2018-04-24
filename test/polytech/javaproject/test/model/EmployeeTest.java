package polytech.javaproject.test.model;

import static org.junit.Assert.fail;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import polytech.javaproject.model.Employee;
import polytech.javaproject.model.RoundedHour;
import polytech.javaproject.model.WorkingDayHours;

public class EmployeeTest {

	private Employee pierre;
	private RoundedHour beginning;
	private RoundedHour end;
	
	@Before
	public void setUp() {
		beginning = new RoundedHour(LocalDateTime.now());
		end = new RoundedHour(LocalDateTime.now().plusHours(8));
		pierre = new Employee("Pierre" , "Boulon",
				beginning, end);
		}

	@Test
	public void testCreateNewEmployee() {
		int lastId = Employee.getCountEmployee();
		Employee paul = new Employee("Paul", "Pastel",
						beginning, end);
		Assert.assertEquals(lastId+1, Employee.getCountEmployee());
		Assert.assertEquals(lastId+1, paul.getId());
		Assert.assertEquals(beginning, paul.getExpectedDay().getStartingHour());
		Assert.assertEquals(end, paul.getExpectedDay().getEndingHour());
		Assert.assertEquals(0, paul.getOvertime().getSeconds());
	}

	@Test
	public void testSetExpectedDay_KO() {
		WorkingDayHours day = new WorkingDayHours();
		try {
			pierre.setExpectedDay(day);
			fail("Exception must be caught");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals(true, e instanceof IllegalArgumentException);
		}
	}

	@Test
	public void testCheck() {
		Assert.assertEquals(true, pierre.getWorkingDayList().isEmpty());
		Assert.assertEquals(null, pierre.getCurrentDay().getStartingHour());
		Assert.assertEquals(null, pierre.getCurrentDay().getEndingHour());
		pierre.check();
		Assert.assertNotNull(pierre.getCurrentDay().getStartingHour());
		Assert.assertEquals(null, pierre.getCurrentDay().getEndingHour());
		pierre.check();
		Assert.assertEquals(null, pierre.getCurrentDay().getStartingHour());
		Assert.assertEquals(null, pierre.getCurrentDay().getEndingHour());
		Assert.assertNotNull(pierre.getWorkingDay(0));
		Assert.assertEquals(-8*60, pierre.getOvertime().toMinutes());
		
	}

}
