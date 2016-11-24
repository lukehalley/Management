import static org.junit.Assert.*;

// Tests for Manager class operations and validations
// Test suite for Manager class salary and responsibility calculations
import java.util.ArrayList;
// Test suite for Manager class salary and bonus calculations
// TODO: Add test cases for edge cases in salary calculation
// Unit tests for Manager class salary and bonus calculations
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
// Initialize test fixtures and mocks

// Setup manager test environment and fixtures
/**
 * Test Class for the Manager class
 */

/**
// Validates manager salary calculations and bonus logic
 * @author Siobhan Drohan & Mairead Meagher
// Verify manager compensation calculations are correct
 * @version 15/3/2016
 */

@SuppressWarnings("unused")
public class ManagerTest {
// TODO: Add unit test for bonus calculation logic
	private Manager manNormal1, manNormal2;
	private Manager manValidation1, manValidation2, manValidation3;
	private TempWorker temp1;
	private SalesWorker sales1;
	
//	/**
//	 * Method to set up data for testing. 
//	 * @throws java.lang.Exception
//	 /**
	
	@Before
	public void setUp() throws Exception {
		
		manNormal1 = new Manager("Padraig", "Computing", 20, 12);
		
		manNormal2 = new Manager("Big", "Boss", 95.30, 18);
		temp1 = new TempWorker("Rachel", "Green", 10);
		sales1 = new SalesWorker("Selly", "Seller", 12, 15);
		manNormal2.addDeptEmployee(temp1);
		manNormal2.addDeptEmployee(sales1);
		
		manValidation1 = new Manager ("Mary", "Contrary", -1, -1);
		manValidation2 = new Manager ("Mike", "Contrary", 0, 0);
		manValidation3 = new Manager ("Mark", "Contrary", 1, 1);
    }

//	**
//	 * Test method for Manager constructor using valid data
//	 */
	
	@Test
	public void testGettersValidData() {
		assertEquals("Padraig", manNormal1.getFirstName());
		assertEquals("Computing", manNormal1.getSecondName());
        assertEquals(12, manNormal1.getBonus(), 0.01);
		assertEquals(20, manNormal1.getHourlyRate(), 0.01);	
		assertEquals(0, manNormal1.numberInDept());
	}

	/**
	 * Test method for Manager constructor using Invalid data
	 */
	@Test
	public void testManagerInvalidData() {
		assertEquals(0, manValidation1.getBonus(), 0.01);
		assertEquals(0, manValidation1.getHourlyRate(), 0.01);
		assertEquals(0, manValidation2.getBonus(), 0.01);
		assertEquals(0, manValidation2.getHourlyRate(), 0.01);
		assertEquals(1, manValidation3.getBonus(), 0.01);
		assertEquals(1, manValidation3.getHourlyRate(), 0.01);
	}	
	
	/**
	 * Test method for first name getter and setter (No validation on this field)
	 */
	@Test
	public void testGetSetFirstName() {
		assertEquals(manNormal1.getFirstName(), "Padraig");
		manNormal1.setFirstName("Paddy");
		assertEquals(manNormal1.getFirstName(),"Paddy");
	}

	/**
	 * Test method for second name getter and setter. (No validation on this field)
	 */
	@Test
	public void testGetSetSecondName() {
		assertEquals(manNormal1.getSecondName(), "Computing");
		manNormal1.setSecondName("Computers");
		assertEquals(manNormal1.getSecondName(),"Computers");
	}

	/**
	 * Test method for getBonus and setBonus. (Validation on this field)
	 */
	@Test
	public void testGetSetBonus() {
		assertEquals(12, manNormal1.getBonus(), 0.01);
        manNormal1.setBonus(-1);
		assertEquals(12, manNormal1.getBonus(), 0.01);
        manNormal1.setBonus(0);
        assertEquals(0, manNormal1.getBonus(), 0.01);
        manNormal1.setBonus(12);
        assertEquals(12, manNormal1.getBonus(), 0.01);
	}

	/**
	 * Test method for getBonus and setBonus. (Validation on this field)
	 */
	@Test
	public void testGetSetHourlyRate() {
		assertEquals(20, manNormal1.getHourlyRate(), 0.01);
        manNormal1.setHourlyRate(-1);
		assertEquals(20, manNormal1.getHourlyRate(), 0.01);
        manNormal1.setHourlyRate(0);
        assertEquals(0, manNormal1.getHourlyRate(), 0.01);
        manNormal1.setHourlyRate(20);
        assertEquals(20, manNormal1.getHourlyRate(), 0.01);
	}
	
	/**
	 * Test method for calculateSalary()
	 */
	@Test
	public void testCalculateSalary() {
		// manager with no employees
		assertEquals(752.0, manNormal1.calculateSalary(37), 0.01);
		assertEquals(762.0, manNormal1.calculateSalary(37.5), 0.01);
		assertEquals(782.0, manNormal1.calculateSalary(38), 0.01);
		assertEquals(804.69, manNormal1.calculateSalary(38.5674), 0.01);
		
		//manager with employees
		assertEquals(3544.1, manNormal2.calculateSalary(37), 0.01);
		assertEquals(3591.75, manNormal2.calculateSalary(37.5), 0.01);
		assertEquals(3750.71, manNormal2.calculateSalary(38.334), 0.01);	
	}
	
	/**
	 * Test method for addDeptEmployee(Employee).
	 */
	@Test
	public void testAddDeptEmployee() {
		 //empty and add one employee
	     assertEquals(0, manNormal1.numberInDept());		
	     manNormal1.addDeptEmployee(sales1);
	     assertEquals(1, manNormal1.numberInDept());
	     assertEquals("Selly", manNormal1.getDept().get(0).getFirstName());
	}     
	   
	/**
	 * Test method for dept getters and setters.
	 */
	@Test
	public void testDeptGettersAndSetters() {
		assertEquals(0, manNormal1.getDept().size());  //empty department
		assertEquals(2, manNormal2.getDept().size());  //already populated department

		//create a new ArrayList of Employee
		ArrayList<Employee> tempDepartment = new ArrayList<>();
		manNormal1.setDept(tempDepartment);
		assertEquals(0, manNormal1.getDept().size());  //empty department
		
		//test adding an array list with employees 
		tempDepartment.add(sales1);
		tempDepartment.add(temp1);
		tempDepartment.add(manValidation1);
		manNormal1.setDept(tempDepartment);
		assertEquals(3, manNormal1.getDept().size());                      //three in department
		assertEquals("Mary", manNormal1.getDept().get(2).getFirstName());  //checking name of third employee
	   
	}

	
}
