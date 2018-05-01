package polytech.javaproject.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * RoundedHour is a class which represents an hour rounded by a quarter
 * 
 * @author Thomas Rossi
 * @version 1.0
 */

public class RoundedHour {

	// ------------------------------------ Attributes ------------------------------------ 
	
	/**
	 * A LocalDateTime which contains the date and time, approximated by 15 minutes
	 */
	private LocalDateTime time;
	
	// ------------------------------------ Constructor ------------------------------------ 
	
	/**
	 * Constructor which instantiate a new rounded hour, approximated by 15 minutes
	 * @param hour an instance of LocalDateTime
	 */
	public RoundedHour(LocalDateTime hour) {
		
		int spareTime;
		
		time = hour;
		spareTime = time.getMinute() % 15;
		if (spareTime < 8) {
			time = time.minusMinutes(spareTime);
		} else {
			time = time.plusMinutes(15-spareTime);
		}
		time.withSecond(0);
		time.withNano(0);
	}
	
	// ------------------------------------ Getters ------------------------------------ 
	
	/**
	 * Getter for the rounded time
	 * @return the instance of LocalDateTime which contains the rounded time (hour + day)
	 */
	public LocalDateTime getRoundedTime() {
		return time;
	}
	
	/**
	 * Getter for the rounded time
	 * @return the instance of LocalTime which contains the rounded hour only
	 */
	public LocalTime getHour() {
		return time.toLocalTime();
	}
	
	/**
	 * Override of toString method
	 */
	@Override
	public String toString() {
		String hour = time.getHour()+":";
		int minutes = time.getMinute();
		if (minutes<10)
			hour = hour+"0"+minutes;
		else
			hour = hour+minutes;
		return hour;
	}
	
}
