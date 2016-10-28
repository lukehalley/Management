// Main driver class for employee management system
// Main entry point for the Management application
// Luke Halley - 20071820

// Github Repository - https://github.com/lukehalley/Management
// Main driver class for the Employee Management System

//Extras
// Driver class extends SalesWorker with additional vehicle responsibilities
//Menu Option 7: Allows the user to view only the current Managers in the system
//Menu Option 8: Allows the user to view only the current Sales Mana8gers in the system
//Menu Option 9: Allows the user to view only the current Temporary Workers in the system
// Main driver class for employee management system

//Importing libraries 
// Initialize driver with employee information and vehicle details
import java.util.ArrayList;
import java.util.Scanner;

// TODO: Implement route optimization algorithm
// Entry point for employee management system

// Initialize driver with route and schedule
//Driver
public class Driver {

	//Setting up Scanner & Arrays
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();
	private ArrayList<Employee> managerList = new ArrayList<Employee>();
	private ArrayList<Employee> salesManagerList = new ArrayList<Employee>();
	private ArrayList<Employee> tempWorkerList = new ArrayList<Employee>();
	final static double NORMAL_WORKWEEK = 37.5;

	public static void main(String[] args) {
		Driver app = new Driver();
		app.run();
	}

	//Main menu displaying all program 
	private int mainMenu() {
		System.out.print("Please select an option from this menu: \n" 
				+ "\t1) Add a Manager.\n"
				+ "\t2) Add a Sales Worker.\n" 
				+ "\t3) Add a Temporary Worker.\n"
				+ "\t4) Add an Existing Employee to a Manager’s Department.\n"
				+ "\t5) Calculate salaries for each employee or the total for all employees\n"
				+ "\t6) Print employee details.\n" 
				+ "\t7) Print all manager details.\n" 
				+ "\t8) Print all sales manager details.\n" 
				+ "\t9) Print all temporary worker details.\n" 
				+ "\t0) Quit.\n" + "=> ");
		int option = sc.nextInt();
		return option;
	}

	
	//Runs the menu and takes the users choice with event handling
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
						System.out.println(listEmployees());
						System.out.println("");
						calculateSalaries();				
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
						System.out.println("Error listing managers: " + e);
					}
					System.out.println("");
					option = mainMenu();
					break;
				case 8:
					try {
						System.out.println(listSalesManagers());
					} catch (Exception e) {
						System.out.println("Error listing sales managers: " + e);
					}
					System.out.println("");
					option = mainMenu();
					break;
				case 9:
					try {
						System.out.println(listTempWorkers());
					} catch (Exception e) {
						System.out.println("Error listing temporary workers: " + e);
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

	//Adds a manager with a first name, last name, hourly rate and a bonus
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

		//Sends info to employee array list and manager array list
		Manager m = new Manager (firstName, secondName, hourlyRate, bonus);
			employeeList.add(m);
			managerList.add(m);

		System.out.println("");
	}

	//Adds a sales worker with a first name, last name, hourly rate and a sales performace bonus
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

		SalesWorker s = new SalesWorker (firstName, secondName, hourlyRate, salesPerformanceBonus);
			employeeList.add(s);
			salesManagerList.add(s);
			

		System.out.println("");
	}

	//Adds a temporary worker with a first name, last name and hourly rate.
	public void addTemporaryWorker() {
		sc.nextLine();
		System.out.println("Please enter the temporary worker first name: ");
		String firstName = sc.nextLine();
		System.out.println("Please enter the temporary worker second name: ");
		String secondName = sc.nextLine();
		System.out.println("Please enter the temporary worker hourly rate: ");
		double hourlyRate = sc.nextDouble();

		TempWorker t = new TempWorker (firstName, secondName, hourlyRate);
		employeeList.add(t);
//		tempWorkerList.add(t);
		
		System.out.println("");
	}
	
	//Changes an exsisting employee to a manager
	public void makeEmployeeManager() {
		sc.nextLine();
		if (employeeList.size() == 0) {
			mainMenu();
			System.out.println("No Employees");
		} else {
		System.out.println("Please enter the index of the employee you wish to become a Manager: ");
		int indexChoice = sc.nextInt();

		Employee choice =employeeList.get(indexChoice);
		System.out.println("Retrieved element is = " + choice);
		managerList.add(choice);

		System.out.println("");
		}
	}
	
	//Calculates the salary of a specific employee based on users inputted hours worked
	public void calculateSalaries() {
		sc.nextLine();
		if (employeeList.size() == 0) {
			mainMenu();
			System.out.println("No Employees");
		} else {
		System.out.println("Please enter the index of the employee you wish to calculate the salary for: ");
		int indexChoice = sc.nextInt();
		System.out.println("Please enter the hours worked: ");
		int hourlyRateChoice = sc.nextInt();
		Employee choice =employeeList.get(indexChoice);
		System.out.println(choice + "Salary = " + (hourlyRateChoice * NORMAL_WORKWEEK));
		System.out.println("");
		}
	}

	//Lists all current employees
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
	
	//Lists all current managers
	public String listManagers() {
		if (managerList.size() == 0) {
			System.out.println("");
			return "No Managers";
		} else {
			System.out.println("");
			System.out.println("All Manager Detail's");
			System.out.println("");
			String listOfManagers = "";
			int index = 0;
			for (int i = 0; i < managerList.size(); i++) {
				listOfManagers = listOfManagers + index + ": " + managerList.get(i) + "\n";
				index++;
			}
			return listOfManagers;
		}
	}
	
	//Lists all current sales managers
	public String listSalesManagers() {
		if (salesManagerList.size() == 0) {
			System.out.println("");
			return "No Sales Managers";
		} else {
			System.out.println("");
			System.out.println("All Sales Manager Detail's");
			System.out.println("");
			String listOfSalesManagers = "";
			int index = 0;
			for (int i = 0; i < salesManagerList.size(); i++) {
				listOfSalesManagers = listOfSalesManagers + index + ": " + salesManagerList.get(i) + "\n";
				index++;
			}
			return listOfSalesManagers;
		}
	}
	
	//Lists all current temporary workers
	public String listTempWorkers() {
		if (tempWorkerList.size() == 0) {
			System.out.println("");
			return "No Temporary Managers";
		} else {
			System.out.println("");
			System.out.println("All Temporary Managers Detail's");
			System.out.println("");
			String listOfTempWorkers = "";
			int index = 0;
			for (int i = 0; i < tempWorkerList.size(); i++) {
				listOfTempWorkers = listOfTempWorkers + index + ": " + tempWorkerList.get(i) + "\n";
				index++;
			}
			return listOfTempWorkers;
		}
		
	}

}
