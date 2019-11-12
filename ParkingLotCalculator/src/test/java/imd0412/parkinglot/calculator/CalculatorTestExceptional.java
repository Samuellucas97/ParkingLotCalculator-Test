package imd0412.parkinglot.calculator;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import imd0412.parkinglot.ParkingLotType;


@RunWith(Parameterized.class)
public class CalculatorTestExceptional {
	
	@Parameter(0)
	public String checkin;
	
	@Parameter(1)
	public String checkout;

	@Parameter(2)
	public ParkingLotType type; 
	
	@Parameter(3)
	public Class<? extends Throwable> exception;

	@Parameters(name = "testShouldReturn")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] {
				// TODO
		});
	}

	@Rule
	public ExpectedException exceptionalExpectation = ExpectedException.none();
	
	@Test
	public void testShouldCalculaterParkingCostExceptional() {
		
		/// Configuração
		
		exceptionalExpectation.expect(exception);
		Calculator calculator = new Calculator();
		
		/// Ação
		
		Float parkingCost = calculator.calculateParkingCost(checkin, checkout, type); 
		
		/// Verificação
		
	}
}
