package polytech.javaproject.test.model;

import static org.junit.Assert.fail;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;
import polytech.javaproject.model.RoundedHour;
import polytech.javaproject.model.WorkingDayHours;

public class WorkingDayHoursTest {
	
	private static final long EIGHTHOURSINMINUTES = 60*8;

	private WorkingDayHours day;
	private WorkingDayHours completedDay;
	private RoundedHour firstHour;
	private RoundedHour secondHour;
	
	@Before
	public void setUp() {
		firstHour = new RoundedHour(LocalDateTime.now());
		secondHour = new RoundedHour(LocalDateTime.now().plusHours(8));
		day = new WorkingDayHours();
		completedDay = new WorkingDayHours(firstHour, secondHour);
	}

	@Test
	public void testSetHour_OK() {
		try {
			day.setHour(firstHour);
			day.setHour(secondHour);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(completedDay.getStartingHour(), day.getStartingHour());
		Assert.assertEquals(completedDay.getEndingHour(), day.getEndingHour());
	}
	
	@Test
	public void testSetHour_KO() {
		try {
			completedDay.setHour(firstHour);
            fail("Exception must be caught.");
		} catch (Exception e) {
			Assert.assertEquals(true, e instanceof Exception);
		}
	}

	@Test
	public void testIsCompleted_returnsFalse() {
		Assert.assertEquals(false, day.isCompleted());
		try {
			day.setHour(firstHour);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertEquals(false, day.isCompleted());
	}
	
	@Test
	public void testIsCompleted_returnsTrue() {
		Assert.assertEquals(true, completedDay.isCompleted());
	}
	
	@Test
	public void testGetDuration() {
		try {
			Assert.assertEquals(EIGHTHOURSINMINUTES, completedDay.getDuration().toMinutes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
