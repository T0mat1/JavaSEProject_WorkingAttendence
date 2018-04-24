package polytech.javaproject.model;

import java.time.Duration;

/**
 * WorkingDayHours is a class representing the hours of a working day
 * 
 * @author Thomas Rossi
 * @version 1.0
 */

public class WorkingDayHours {
	
	// ------------------------------------ Attributes ------------------------------------ 
	
	/**
	 * An instance of RoundedHour which contains the beginning of the working day
	 * @see RoundedHour
	 */
	private RoundedHour startingHour;
	
	/**
	 * An instance of RoundedHour which contains the end of the working day
	 * @see RoundedHour
	 */
	private RoundedHour endingHour;
	
	// ------------------------------------ Constructors ------------------------------------ 
	
	/**
	 * Default constructor for WorkingDayHours, setting all values to null
	 */
	public WorkingDayHours() {
		startingHour = null;
		endingHour = null;
	}
	
	/**
	 * Constructor for WorkingDayHours which fixes the starting and the ending hours
	 * @param start an instance of RoundedHour
	 * @param end an instance of RoundedHour
	 * @see RoundedHour
	 */
	public WorkingDayHours(RoundedHour start, RoundedHour end) {
		startingHour = start;
		endingHour = end;
	}

	// ------------------------------------ Getters ------------------------------------ 
	
	/**
	 * Getter for the starting hour
	 * @return an instance of RoundedHour which contains the hour of the beginning of the day
	 */
	public RoundedHour getStartingHour() {
		return startingHour;
	}

	/**
	 * Getter for the ending hour
	 * @return an instance of RoundedHour which contains the hour of the end of the day
	 */
	public RoundedHour getEndingHour() {
		return endingHour;
	}

	// ------------------------------------ Setters ------------------------------------ 
	
	/**
	 * Initialize the value of startingHour with hour if there is no starting hour,
	 * if there is a starting hour but no ending hour, initialize the value of endingHour with hour.
	 * @param hour an instance of RoundedHour
	 * @throws Exception if workingDayHours is full.
	 */
	public void setHour(RoundedHour hour) throws Exception {
		if (startingHour == null) {
			startingHour = hour;
		} else {
			if (endingHour == null) {
				endingHour = hour;
			} else {
				throw new Exception("Cannot add another time to WorkingDay");
			}	
		}
	}
	
	// ------------------------------------ Methods  ------------------------------------ 

	/**
	 * A method which check if the day is complete or not
	 * @return a boolean which equals true if the day is complete, else equals false
	 */
	public boolean isCompleted() {
		return (startingHour != null && endingHour != null);
	}
	
	/**
	 * A method which returns the duration of the working day
	 * @return an instance of Duration which contains the duration between the end and the beginning of the working day
	 * @throws Exception if the day is not finished
	 */
	public Duration getDuration() throws Exception {
		if (!isCompleted()) {
			throw new Exception("WorkingDay is not finished");
		}
		return Duration.between(startingHour.getRoundedTime(), endingHour.getRoundedTime());
	}	
}
