import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	private Scanner sc = new Scanner(System.in);
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();
	private ArrayList<Employee> managerList = new ArrayList<Employee>();

	public static void main(String[] args) {
		Driver app = new Driver();
		app.run();
	}

	private int mainMenu() {
		System.out.print("Please select an option from this menu: \n" 
				+ "\t1) Add a Manager.\n"
				+ "\t2) Add a Sales Worker.\n" 
				+ "\t3) Add a Temporary Worker.\n"
				+ "\t4) Add an Existing Employee to a Manager’s Department.\n"
				+ "\t5) Calculate salaries for each employee or the total for all employees\n"
				+ "\t6) Print employee details.\n" 
				+ "\t7) Print manager details.\n" 
				+ "\t0) Quit.\n" + "=> ");
		int option = sc.nextInt();
		return option;
	}

	public void run() {
		{
			int option = mainMenu();
			while (option != 0) {

				switch (option) {
				case 1:
					try {
						addManager();
						System.out.println("Manager added!");
						System.out.println("");
					} catch (Exception e) {
						System.out.println("Error adding Manager: " + e);
					}
					System.out.println("");
					option = mainMenu();
					break;
				case 2:
					try {
						addSalesWorker();
						System.out.println("Sales Worker added!");
						System.out.println("");
					} catch (Exception e) {
						System.out.println("Error adding Sales Worker: " + e);
					}
					System.out.println("");
					option = mainMenu();
					break;
				case 3:
					try {
						addTemporaryWorker();
						System.out.println("Temporary Worker added!");
						System.out.println("");
					} catch (Exception e) {
						System.out.println("Error adding Temporary Worker: " + e);
					}
					System.out.println("");
					option = mainMenu();
					break;
				case 4:
					try {
						System.out.println(listEmployees());
						System.out.println("");
						makeEmployeeManager();
					} 
					catch (Exception e) {
						System.out.println("Error adding an Existing Employee to a Manager’s Department: " + e);
					}
					System.out.println("");
					option = mainMenu();
					break;

				case 5:
					try {
						
					} catch (Exception e) {
						System.out.println( "Error calculating salaries for each employee or the total for all employees: " + e);
					}
					System.out.println("");
					option = mainMenu();
					break;
				case 6:
					try {
						System.out.println(listEmployees());
					} catch (Exception e) {
						System.out.println("Error calculating salaries for each employee or the total for all employees: " + e);
					}
					System.out.println("");
					option = mainMenu();
					break;
				case 7:
					try {
						System.out.println(listManagers());
					} catch (Exception e) {
						System.out.println("Error calculating salaries for each employee or the total for all employees: " + e);
					}
					System.out.println("");
					option = mainMenu();
					break;
				

				default:
					
					System.out.println("Invalid menu option selected.");
					System.out.println("");
					option = mainMenu();
					
				}
				
			}

		}
		
		System.out.println("");
		System.out.println("Program Ended");
		System.exit(0);

	}

	public void addManager() {

		sc.nextLine();
		System.out.println("Please enter the managers's first name: ");
		String firstName = sc.nextLine();
		System.out.println("Please enter the managers's second name: ");
		String secondName = sc.nextLine();
		System.out.println("Please enter the managers's hourly rate: ");
		double hourlyRate = sc.nextDouble();
		System.out.println("Please enter the managers's bonus: ");
		double bonus = sc.nextDouble();
		sc.nextLine();

		
		Manager m = new Manager (firstName, secondName, hourlyRate, bonus);
			employeeList.add(m);
			managerList.add(m);

		System.out.println("");
	}

	public void addSalesWorker() {

		sc.nextLine();
		System.out.println("Please enter the sales worker's first name: ");
		String firstName = sc.nextLine();
		System.out.println("Please enter the sales worker's second name: ");
		String secondName = sc.nextLine();
		System.out.println("Please enter the sales worker's hourly rate: ");
		double hourlyRate = sc.nextDouble();
		System.out.println("Please enter the sales worker's sales performance bonus: ");
		double salesPerformanceBonus = sc.nextDouble();

		employeeList.add(new SalesWorker(firstName, secondName, hourlyRate, salesPerformanceBonus));

		System.out.println("");
	}

	public void addTemporaryWorker() {
		sc.nextLine();
		System.out.println("Please enter the temporary worker first name: ");
		String firstName = sc.nextLine();
		System.out.println("Please enter the temporary worker second name: ");
		String secondName = sc.nextLine();
		System.out.println("Please enter the temporary worker hourly rate: ");
		double hourlyRate = sc.nextDouble();

		employeeList.add(new TempWorker(firstName, secondName, hourlyRate));

		System.out.println("");
	}
	
	public void makeEmployeeManager() {
		sc.nextLine();
		System.out.println("Please enter the index of the employee you wish to become a Manager: ");
		int indexChoice = sc.nextInt();

		Employee choice =employeeList.get(indexChoice);
		System.out.println("Retrieved element is = " + choice);
		managerList.add(choice);

		System.out.println("");
	}
	
	public void calculateSalaries() {
		sc.nextLine();
		System.out.println("Please enter the index of the employee you wish to calculate the salary for: ");
		int indexChoice = sc.nextInt();

		Employee choice =employeeList.get(indexChoice);
		System.out.println(choice + "Salary = ");
		managerList.add(choice);

		System.out.println("");
	}

	public String listEmployees() {
		if (employeeList.size() == 0) {
			return "No Employees";
		} else {
			String listOfEmployees = "";
			int index = 0;
			for (int i = 0; i < employeeList.size(); i++) {
				listOfEmployees = listOfEmployees + index + ": " + employeeList.get(i) + "\n";
				index++;
			}
			return listOfEmployees;
		}
	}
	
	public String listManagers() {
		if (managerList.size() == 0) {
			return "No Managers";
		} else {
			String listOfManagers = "";
			int index = 0;
			for (int i = 0; i < managerList.size(); i++) {
				listOfManagers = listOfManagers + index + ": " + employeeList.get(i) + "\n";
				index++;
			}
			return listOfManagers;
		}
	}
	

}
