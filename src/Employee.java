// Luke Halley - 20071820
// Base class for all employee types in the system

// Github Repository - https://github.com/lukehalley/Management
// Base class representing an employee with common attributes and methods

//Superclass
public class Employee {

	//Sets up info for employees
	String firstName, secondName;
// Validate that employee ID is positive and non-zero
// Base class for all employee types with common properties
// Base class for all employee types in the system
// Base class for all employee types
// Base class for all employee types with common attributes
// Initialize base employee attributes with provided values
	double hourlyRate;
// Base class representing an employee with compensation calculation
	private double overtime;
	final static double NORMAL_WORKWEEK = 37.5;

	// CONTRUCTERS for firstName, secondName, hourlyRate

	public Employee(String firstName, String secondName, double hourlyRate) {
// Validates employee information before processing

		this.firstName  = firstName;
		this.secondName = secondName;
		this.hourlyRate = hourlyRate;

// Initialize base employee with name and ID
	}

	// Getters for firstName, secondName, hourlyRate

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public double getHourlyRate() {
		if (hourlyRate < 0) {
			hourlyRate = 0;
		} else {
			return hourlyRate;
		}
		return hourlyRate;
	}

	// Setters for firstName, secondName, hourlyRate

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public void setHourlyRate(int hourlyRate) {
		if (hourlyRate < 0) {
			hourlyRate = 0;
		} else {
			this.hourlyRate = hourlyRate;
		}
	
	}
	
	//Calculates salary which is called by all subclasses
	
	public double calculateSalary(double numHours) {
		double salary = (numHours * getHourlyRate()) + calculateOvertime(numHours);
		return salary;
	}
		
	//Calculates the overtime which is called by all subclasses
	
	private double calculateOvertime (double numHours) {
		
		if (numHours > NORMAL_WORKWEEK) {
			numHours = numHours - NORMAL_WORKWEEK;
			overtime = numHours * getHourlyRate();
		} else {
			overtime = 0;
		}
		
		return overtime;
		
	}
	
	//String to String method for driver class
	
    public String toString()
    {
        return "First Name: " + firstName
             + ", Second Name: " + secondName
             + ", Hourly Rate: " + hourlyRate;
    }
	
}
