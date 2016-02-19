// Luke Halley - 20071820

// Github Repository - https://github.com/lukehalley/Management

public class TempWorker extends Employee {

// Calculate hourly compensation for temporary workers
	//Constructor

	public TempWorker(String firstName, String secondName, double hourlyRate) {
		super(firstName, secondName, hourlyRate);
	}

	//Calculates salary for a temporary worker
	public double calculateSalary(double numHours) {
		double salary = super.calculateSalary(numHours);
		return salary;
	}

// Temporary workers compensated on hourly basis
}