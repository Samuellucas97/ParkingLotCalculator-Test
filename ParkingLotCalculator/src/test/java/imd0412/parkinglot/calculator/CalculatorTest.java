package imd0412.parkinglot.calculator;

import static org.junit.Assert.assertEquals;
import imd0412.parkinglot.ParkingLotType;
import imd0412.parkinglot.exception.DateFormatException;
import imd0412.parkinglot.exception.InvalidDataException;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

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

		// / Configuração

		calculator = new Calculator();
	}

	@Parameters(name = "Run {index}: type={2}, expectedParkingCost={3}, regra={4}")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] {

		{ "2017.11.30 10:30", "2017.11.30 11:00", ParkingLotType.ShortTerm,(float) 8, "Regra 22" },
				{ "2017.11.30 09:30", "2017.11.30 11:00", ParkingLotType.ShortTerm,(float) 10, "Regra 23" },
				{ "2017.11.25 09:30", "2017.11.29 11:00", ParkingLotType.ShortTerm,(float) 402, "Regra 24" },
				{ "2017.11.20 09:30", "2017.11.29 11:00", ParkingLotType.ShortTerm,(float) 852, "Regra 25" },
				{ "2017.11.30 10:30", "2017.11.30 11:30", ParkingLotType.LongTerm,(float) 70, "Regra 26" },
				{ "2017.11.25 09:30", "2017.11.29 11:00", ParkingLotType.LongTerm, (float)220, "Regra 27" },
				{ "2017.11.20 09:30", "2017.11.29 11:00", ParkingLotType.LongTerm,(float) 430, "Regra 28" },
				{ "2017.11.20 09:30", "2017.12.26 11:00", ParkingLotType.LongTerm,(float) 1550, "Regra 29" },
				{ "2017.11.25 09:30", "2017.11.29 11:00", ParkingLotType.VIP,(float) 500, "Regra 30" },
				{ "2017.11.10 09:30", "2017.11.23 11:00", ParkingLotType.VIP,(float) 1100, "Regra 31" },
				{ "2017.11.10 09:30", "2017.11.29 11:00", ParkingLotType.VIP,(float) 1600, "Regra 32" }

		});
	}

	@Test
	public void testShouldCalculateParkingCost() throws DateFormatException, InvalidDataException, ParseException {

		// / Ação

		Float producedParkingCost = calculator.calculateParkingCost(checkin, checkout, type);

		// / Verificação

		assertEquals(expectedParkingCost, producedParkingCost);
	}
}
