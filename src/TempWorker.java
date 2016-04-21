// Luke Halley - 20071820

// Github Repository - https://github.com/luke123halley/Management

public class TempWorker extends Employee {

	//Constructor

	public TempWorker(String firstName, String secondName, double hourlyRate) {
		super(firstName, secondName, hourlyRate);
	}

	//Calculates salary for a temporary worker
	public double calculateSalary(double numHours) {
		double salary = super.calculateSalary(numHours);
		return salary;
	}

}