//Superclass

public class Employee {

	String firstName, secondName;
	double hourlyRate;
	private double overtime;
	final static double NORMAL_WORKWEEK = 37.5;

	// CONTRUCTERS for firstName, secondName, hourlyRate

	public Employee(String firstName, String secondName, double hourlyRate) {

		this.firstName  = firstName;
		this.secondName = secondName;
		this.hourlyRate = hourlyRate;

	}

	// GETTERS for firstName, secondName, hourlyRate

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

	// SETTERS for firstName, secondName, hourlyRate

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
	
    public String toString()
    {
        return "First Name: " + firstName
             + ", Second Name: " + secondName
             + ", Hourly Rate: " + hourlyRate;
    }
	
}
