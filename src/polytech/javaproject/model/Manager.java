package polytech.javaproject.model;

/**
 * Manager is a class representing a manager which extends Employee
 * @author Thomas Rossi
 * @version 1.0
 * @see Employee
 */
public class Manager extends Employee {

	/**
	 * Constructor to instantiate a manager, calls the constructor for employee
	 * @param firstN a String containing the first name of the manager
	 * @param lastN a String containing the last name of the manager
	 * @param startingHour a RoundedHour which contains the hour of the beginning of his/her working day
	 * @param endingHour a RoundedHour which contains the hour of the end of his/her working day
	 * @see Employee
	 * @see RoundedHour
	 */
	public Manager(String firstN, String lastN, RoundedHour startingHour, RoundedHour endingHour) {
		super(firstN, lastN, startingHour, endingHour);
	}

}
