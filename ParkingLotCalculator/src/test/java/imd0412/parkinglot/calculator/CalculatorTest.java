package imd0412.parkinglot.calculator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import imd0412.parkinglot.ParkingLotType;

@RunWith(Parameterized.class)
public class CalculatorTest {
	
	private static Calculator calculator;
	
	@Parameter(0)
	public String checkin;
	
	@Parameter(1)
	public String checkout;

	@Parameter(2)
	public ParkingLotType type; 
	
	@Parameter(3)
	public Float expectedParkingCost;

	@Parameter(4)
	public String nameTestCase;
	
	
	@BeforeClass
	public static void setUp() {
		
		/// Configuração
		
		calculator = new Calculator();
	}
	
	@Parameters(name = "testShouldReturn-{3}_{4}")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] {
				// TODO 
			});
	}
	
	@Test
	public void testShouldCalculaterParkingCost() {
		
		/// Ação
		
		Float producedParkingCost = calculator.calculateParkingCost(checkin, checkout, type); 

		/// Verificação

		assertEquals(expectedParkingCost, producedParkingCost);
	}
}
