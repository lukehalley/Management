public class TempWorker extends Employee {

	// CONSTRUCTOR

	public TempWorker(String firstName, String secondName, double hourlyRate) {
		super(firstName, secondName, hourlyRate);
	}

	public double calculateSalary(double numHours) {
		double salary = super.calculateSalary(numHours);
		return salary;
	}

}