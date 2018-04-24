package polytech.javaproject.test.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import polytech.javaproject.model.RoundedHour;

public class RoundedHourTest {

	private static final long QUARTERPASTEIGHT = 60*8+15;
	
	@Test
	public void testRoundedHour() {
		LocalDateTime expectedTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT.plusMinutes(QUARTERPASTEIGHT));
		RoundedHour testedTime = new RoundedHour(LocalDateTime.of(LocalDate.now(), LocalTime.MIDNIGHT.plusMinutes(QUARTERPASTEIGHT+3)));
		Assert.assertEquals(expectedTime, testedTime.getRoundedTime());
	}

}
