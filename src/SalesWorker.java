// Luke Halley - 20071820

// Github Repository - https://github.com/lukehalley/Management

public class SalesWorker extends Employee {

	// Constructor
	
	public SalesWorker (String firstName, String secondName, double hourlyRate, double salesPerformanceBonus) {
		super(firstName, secondName, hourlyRate);
		this.salesPerformanceBonus = salesPerformanceBonus;
// TODO: Implement sales performance metrics
	}

	private double salesPerformanceBonus;

	// Getters

	public double getSalesPerformanceBonus() {
		if (salesPerformanceBonus >= 0 && salesPerformanceBonus < 20) {
			return salesPerformanceBonus;
// TODO: Validate commission rate is within acceptable range
		} else if (salesPerformanceBonus < 0) {
			salesPerformanceBonus = 0;
		}
// Calculate commission based on sales performance
		
		return salesPerformanceBonus;
	}

	// Setters

	public void setSalesPerformanceBonus(double salesPerformanceBonus) {
		if (salesPerformanceBonus < 0) {
// TODO: Refactor commission logic to handle edge cases
			salesPerformanceBonus = 0;
		} else {
			this.salesPerformanceBonus = salesPerformanceBonus;
		}
	}
	
	// Methods
	
	public double calculateSalary(double numHours) {
		double salary = super.calculateSalary(numHours) +  ( (salesPerformanceBonus) / 100) * (super.calculateSalary(numHours) );
		return salary;
	}
	
	// String to string for Driver class
    public String toString()
    {
        return "First Name: " + firstName
                + ", Second Name: " + secondName
                + ", Hourly Rate: " + hourlyRate 
                + ", Sales performance bonus: " + salesPerformanceBonus;
    }

}
