import static org.junit.Assert.*;

//import org.junit.After;
//import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * Test Class for the TempWorker class
 * 
 * @author Siobhan Drohan & Mairead Meagher
 * @version 15/3/2016
 */

public class TempWorkerTest {
	
	private TempWorker temp1, temp2, invalidTemp;

	/**
	 * Method to set up data for testing. 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		temp1 = new TempWorker("Donald", "Trump", 10);
		temp2 = new TempWorker("Frank", "Underwood", 8.50);
		invalidTemp = new TempWorker("Ronald", "McDonald", -1);
	}

	/**
	 * Test method for AdminWorker constructor
	 */
	@Test
	public void testConstructor() {
		//test on valid data
		assertEquals("Donald", temp1.getFirstName());
		assertEquals("Trump", temp1.getSecondName());
		assertEquals(10, temp1.getHourlyRate(), 0.01);
		//test on invalid data
		assertEquals(0, invalidTemp.getHourlyRate(), 0.01);

	}
	
	/**
	 * Test method for calculateSalary(), testing for employees with and without overtime. 
	 */
	@Test	
	public void testCaclulateSalary(){
		assertEquals(318.75, temp2.calculateSalary(37.5), 0.01 );
		assertEquals(361.25, temp2.calculateSalary(40), 0.01 );
		
		assertEquals(300, temp1.calculateSalary(30), 0.01 );
		assertEquals(305.67, temp1.calculateSalary(30.5678), 0.01 );
	}
	
	/**
	 * Test method for getters and setters. 
	 */
	@Test	
	public void testSettersGetters(){	
		assertEquals("Donald", temp1.getFirstName());
		temp1.setFirstName("Donald Duck");
		assertEquals("Donald Duck", temp1.getFirstName());
		
		assertEquals("Trump", temp1.getSecondName());
		temp1.setSecondName("Mickey Mouse");
		assertEquals("Mickey Mouse", temp1.getSecondName());

		temp1.setHourlyRate(40);
		assertEquals(40, temp1.getHourlyRate(), 0.01);
		
		//ensure no change when invalid data used
		temp1.setHourlyRate(-40);
		assertEquals(40, temp1.getHourlyRate(), 0.01);	
	}
	
}