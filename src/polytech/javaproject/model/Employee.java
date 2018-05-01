package polytech.javaproject.model;

import java.time.Duration;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Employee is a class representing an Employee of the company
 * 
 * @author Thomas Rossi
 * @version 1.0
 */

public class Employee {
	
	// ------------------------------------ Attributes ------------------------------------ 
	
	/**
	 * a static integer which is counting the employees
	 */
	private static int countEmployee = 0;
	
	/**
	 * an integer representing the id of the employee
	 */
	private int id;
	
	/**
	 * A String which contains the first name of the employee
	 */
	private String firstName;
	
	/**
	 * A String which contains the last name of the employee
	 */
	private String lastName;
	
	/**
	 * An array list of WorkingDayHours which stocks the past working days
	 * @see WorkingDayHours
	 */
	private ArrayList<WorkingDayHours> workingDayList;
	
	/**
	 * An instance of WorkingDayHours which contains the current hours of the employee working day
	 * @see WorkingDayHours
	 */
	private WorkingDayHours currentDay;
	
	/**
	 * An instance of WorkingDayHours which contains the expected hours of the employee working day
	 * @see WorkingDayHours
	 */
	private WorkingDayHours expectedDay;
	
	/**
	 * An instance of Duration which stocks the overtime,
	 * can be negative if the employee didn't work as much as expected
	 */
	private Duration overtime;
	
	// ------------------------------------ Constructor ------------------------------------ 
	
	/**
	 * Constructor which instantiate an new Employee with an id equal to the number of employees+1
	 * @param firstN a String containing the first name of the employee
	 * @param lastN a String containing the last name of the employee
	 * @param startingHour a RoundedHour which contains the hour of the beginning of his/her working day
	 * @param endingHour a RoundedHour which contains the hour of the end of his/her working day
	 * @see Employee
	 * @see RoundedHour
	 */
	public Employee(String firstN, String lastN, RoundedHour startingHour, RoundedHour endingHour) {
		firstName = firstN;
		lastName = lastN;
		countEmployee++;
		id = countEmployee;
		workingDayList = new ArrayList<WorkingDayHours>();
		expectedDay = new WorkingDayHours(startingHour, endingHour);
		currentDay = new WorkingDayHours();
		overtime = Duration.ofMinutes(0);
	}

	// ------------------------------------ Getters ------------------------------------ 
	
	/**
	 * Getter for the counter of employee
	 * @return the static integer which counts the number of employees
	 */
	public static int getCountEmployee() {
		return countEmployee;
	}

	/**
	 * Getter for the id of the employee
	 * @return an integer which contains the id of the employee
	 */
	public int getId() {
		return id;
	}

	/**
	 * Getter for the first name of the employee
	 * @return a String containing the first name of the employee
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Getter for the last name of the employee
	 * @return a String containing the last name of the employee
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Getter for the current working day
	 * @return an instance of WorkingDayHours which contains the hours for the current working day
	 * @see WorkingDayHours
	 */
	public WorkingDayHours getCurrentDay() {
		return currentDay;
	}

	/**
	 * Getter for the expected working day
	 * @return an instance of WorkingDayHours which contains the hours for the expected working day
	 * @see WorkingDayHours
	 */
	public WorkingDayHours getExpectedDay() {
		return expectedDay;
	}

	/**
	 * Getter for the overtime
	 * @return an instance of Duration which contains the overtime
	 */
	public Duration getOvertime() {
		return overtime;
	}
	
	/**
	 * Getter for the list which contains all the past working days
	 * @return an ArrayList containing the past WorkingDayHours
	 * @see WorkingDayHours
	 */
	public ArrayList<WorkingDayHours> getWorkingDayList() {
		return workingDayList;
	}
	
	/**
	 * Getter for the working day at the index position in the working day list
	 * @param index an integer which represents the number of the working day in the list
	 * @return an instance of WorkingDayList which contains the hours of the index-th day
	 */
	public WorkingDayHours getWorkingDay(int index) {
		return workingDayList.get(index);
	}
	
	// ------------------------------------ Setters ------------------------------------ 
	
	/**
	 * A method which change the expected working hours
	 * @param day an instance of WorkingDayHours
	 * @throws IllegalArgumentException
	 * @see WorkingDayHours
	 */
	public void setExpectedDay(WorkingDayHours day) throws IllegalArgumentException {
		if (day.isCompleted()) {
			expectedDay = day;
		} else {
			throw new IllegalArgumentException("The expected day must be complete");
		}
		
	}
	
	// ------------------------------------ Methods ------------------------------------ 
	
	/**
	 * A method meant to be called when an employee checks in or out.
	 * Sets the hour in the current working day with method 'setHour'
	 * if this was a check out add the current working day to the
	 * working day list and reset the current working day
	 * 
	 * @see WorkingDayHours
	 * @see RoundedHour
	 */
	public void check() {
		RoundedHour currentTime = new RoundedHour(LocalDateTime.now());
		try {
			currentDay.setHour(currentTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (currentDay.isCompleted())
		{
			try {
				overtime = currentDay.getDuration().minus(expectedDay.getDuration());
			} catch (Exception e) {
				e.printStackTrace();
			}
			workingDayList.add(currentDay);
			currentDay = new WorkingDayHours(); //reset the current working day
		}	
	}
	
	/**
	 * Override of toString method
	 */
	@Override
	public String toString() {
		return firstName+" "+lastName;
	}
	
}
