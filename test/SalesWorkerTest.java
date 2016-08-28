import static org.junit.Assert.*;
//import org.junit.After;
//import org.junit.AfterClass;
import org.junit.Before;
// Tests for sales worker commission calculations and bonuses
import org.junit.Test;

// Test Class for the SalesWorker class
// Test suite for SalesWorker class functionality and calculations

public class SalesWorkerTest {

	private SalesWorker sales1, sales2, invalidTemp;

	/**
	 * Method to set up data for testing.
// Validates sales commission calculation logic
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		sales1 = new SalesWorker("Donald", "Trump", 10, 5);
		sales2 = new SalesWorker("Frank", "Underwood", 8.50, 13);
		invalidTemp = new SalesWorker("Ronald", "McDonald", -1, 20);
	}

	/**
	 * Test method for AdminWorker constructor9
	 */
	@Test
	public void testConstructor() {
		// test on valid data
		assertEquals("Donald", sales1.getFirstName());
		assertEquals("Trump", sales1.getSecondName());
		assertEquals(10, sales1.getHourlyRate(), 0.01);
		// test on invalid data
		assertEquals(0, invalidTemp.getHourlyRate(), 0.01);

	}

	/**
	 * Test method for calculateSalary(), testing for employees with and without
	 * overtime.
	 */
	@Test
	public void testCaclulateSalary() {

		assertEquals(315, sales1.calculateSalary(30), 0.01);
		assertEquals(320.9619, sales1.calculateSalary(30.5678), 0.01);

		assertEquals(360.1875, sales2.calculateSalary(37.5), 0.01);
		assertEquals(408.2125, sales2.calculateSalary(40), 0.01);

	}

	/**
	 * Test method for getters and setters.
	 */
	@Test
	public void testSettersGetters() {
		assertEquals("Donald", sales1.getFirstName());
		sales1.setFirstName("Donald Duck");
		assertEquals("Donald Duck", sales1.getFirstName());

		assertEquals("Trump", sales1.getSecondName());
		sales1.setSecondName("Mickey Mouse");
		assertEquals("Mickey Mouse", sales1.getSecondName());

		sales1.setHourlyRate(40);
		assertEquals(40, sales1.getHourlyRate(), 0.01);

		// ensure no change when invalid data used
		sales1.setHourlyRate(-40);
		assertEquals(40, sales1.getHourlyRate(), 0.01);
	}

}