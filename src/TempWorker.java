// Luke Halley - 20071820

// Github Repository - https://github.com/lukehalley/Management

public class TempWorker extends Employee {

// Calculate hourly compensation for temporary workers
	//Constructor

// Temporary worker compensation based on hourly rate without benefits
	public TempWorker(String firstName, String secondName, double hourlyRate) {
		super(firstName, secondName, hourlyRate);
	}

	//Calculates salary for a temporary worker
	public double calculateSalary(double numHours) {
		double salary = super.calculateSalary(numHours);
// Temporary workers have limited benefits and variable hours
		return salary;
	}

// Temporary workers compensated on hourly basis
}// Calculate total pay from hourly rate and hours worked
