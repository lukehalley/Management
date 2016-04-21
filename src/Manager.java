import java.util.ArrayList;

public class Manager extends Employee {

	private double bonus;
	private ArrayList<Employee> deptEmployees;
	final static double NORMAL_WORKWEEK = 37.5;

	// CONSTRUCTOR which calls on Superclass and for deptEmployees and bonus

	public Manager(String firstName, String secondName, double hourlyRate, double bonus) {
		super(firstName, secondName, hourlyRate);
		
		deptEmployees = new ArrayList<Employee>();
		this.bonus = bonus;
	}

	// GETTERS for bonus and deptEmployees

	public double getBonus() {
		if (bonus < 0) {
			bonus = 0;
		} else {
			return bonus;
		}
		return bonus;

	}

	public ArrayList<Employee> getDept() {
		return deptEmployees;
	}

	// SETTERS for bonus and deptEmployees

	public void setBonus(double bonus) {
		if (bonus < 0) {
			bonus = 0;
		} else {
			this.bonus = bonus;
		}

	}

	public void setDept(ArrayList<Employee> dept) {
		this.deptEmployees = dept;
	}

	// METHODS for adding deptEmployees, returning the size of deptEmployees and calculating the salary + bonus

	public void addDeptEmployee(Employee worker) {
		deptEmployees.add(worker);
	}

	public int numberInDept() {
		return deptEmployees.size();
	}

	public double calculateSalary(double numHours) {
		double salary = super.calculateSalary(numHours) + bonus;
		return salary;
	}
	
    public String toString()
    {
        return "First Name: " + firstName
                + ", Second Name: " + secondName
                + ", Hourly Rate: " + hourlyRate 
                + ", Bonus: " + bonus;
    }

}
