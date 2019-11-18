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
import imd0412.parkinglot.exception.DateFormatException;
import imd0412.parkinglot.exception.InvalidDataException;

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
	
			
			{"2017.11.31 10:30", "2017.11.31 11:00",  ParkingLotType.ShortTerm, 8, "Regra 22"},		
			{"2017.11.31 09:30",  "2017.11.31 11:00", ParkingLotType.ShortTerm, 10, "Regra 23"}, 
			{"2017.11.25 09:30",  "2017.11.29 11:00",  ParkingLotType.ShortTerm, 106,"Regra 24"}, 
//			{"2017.11.20 09:30",  "2017.11.29 11:00",  ParkingLotType.ShortTerm, NAO TERMINEI DE CALCULAR,"Regra 25"}, 
			{"2017.11.31 10:30",  "2017.11.31 11:30",  ParkingLotType.LongTerm, 70,"Regra 26"},
			{"2017.11.25 09:30",  "2017.11.29 11:00",  ParkingLotType.LongTerm, 220,"Regra 27"}, 
			{"2017.11.20 09:30",  "2017.11.29 11:00",  ParkingLotType.LongTerm, 430,"Regra 28"}, 
			{"2017.11.20 09:30",  "2017.12.26 11:00",  ParkingLotType.LongTerm, 1550, "Regra 29"}, 
			{"2017.11.25 09:30",  "2017.11.29 11:00",  ParkingLotType.VIP, 500, "Regra 30"}, 
			{"2017.11.10 09:30",  "2017.11.23 11:00",  ParkingLotType.VIP, 1100, "Regra 31"}, 
			{"2017.11.10 09:30",  "2017.11.29 11:00",  ParkingLotType.VIP, 1600, "Regra 32"} 
			
		});
	}
	
	@Test
	public void testShouldCalculaterParkingCost() throws DateFormatException {
		
		/// Ação
		
		Float producedParkingCost = calculator.calculateParkingCost(checkin, checkout, type); 

		/// Verificação

		assertEquals(expectedParkingCost, producedParkingCost);
	}
}
