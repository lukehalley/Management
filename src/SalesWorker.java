public class SalesWorker extends Employee {

	//CONSTRUCTOR
	
	public SalesWorker (String firstName, String secondName, double hourlyRate, double salesPerformanceBonus) {
		super(firstName, secondName, hourlyRate);
		this.salesPerformanceBonus = salesPerformanceBonus;
	}

	private double salesPerformanceBonus;

	// GETTERS

	public double getSalesPerformanceBonus() {
		if (salesPerformanceBonus >= 0 && salesPerformanceBonus < 20) {
			return salesPerformanceBonus;
		} else if (salesPerformanceBonus < 0) {
			salesPerformanceBonus = 0;
		}
		
		return salesPerformanceBonus;
	}

	// SETTERS

	public void setSalesPerformanceBonus(double salesPerformanceBonus) {
		if (salesPerformanceBonus < 0) {
			salesPerformanceBonus = 0;
		} else {
			this.salesPerformanceBonus = salesPerformanceBonus;
		}
	}
	
	//METHODS
	
	public double calculateSalary(double numHours) {
		double salary = super.calculateSalary(numHours) +  ( (salesPerformanceBonus) / 100) * (super.calculateSalary(numHours) );
		return salary;
	}
	
    public String toString()
    {
        return "First Name: " + firstName
                + ", Second Name: " + secondName
                + ", Hourly Rate: " + hourlyRate 
                + ", Sales performance bonus: " + salesPerformanceBonus;
    }

}
