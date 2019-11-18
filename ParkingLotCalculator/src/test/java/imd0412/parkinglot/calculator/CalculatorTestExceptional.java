package imd0412.parkinglot.calculator;

import static org.junit.Assert.assertEquals;
import imd0412.parkinglot.ParkingLotType;
import imd0412.parkinglot.exception.DateFormatException;
import imd0412.parkinglot.exception.InvalidDataException;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

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

	@Parameter(4)
	public String regra;

	@Parameters(name = "Run {index}: type={2}, expectedParkingCost={3}, regra={4}")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] {

		{ "2017.11.31 10:30M", "2018.11.31 10:30", ParkingLotType.ShortTerm, DateFormatException.class, "Regra 1" },

		{ "2017.11.31 10:30", "2018.11.31 10:30M", ParkingLotType.ShortTerm, DateFormatException.class, "Regra 2" },

		{ "2017.11.36 10:30", "2018.11.31 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 3" },

		{ "2017.13.31 10:30", "2018.11.31 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 4" },

		{ "2019.11.31 10:30", "2018.11.31 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 5" },

		{ "1968.11.31 10:30", "2018.11.31 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 6" },

		{ "2017.11.31 24:30", "2018.11.31 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 7" },

		{ "2017.11.31 10:60", "2018.11.31 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 8" },

		{ "2017.11.31 10:30", "2018.11.36 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 9" },

		{ "2017.11.31 10:30", "2018.13.31 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 10" },

		{ "2017.11.31 10:30", "2020.11.31 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 11" },

		{ "2017.11.31 10:30", "1968.11.31 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 12" },

		{ "2017.11.31 10:30", "2018.11.31 24:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 13" },

		{ "2017.11.31 10:30", "2018.11.31 10:60", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 14" },

		{ "2015.11.31 10:30", "2016.02.30 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 15" },

		{ "2016.11.31 10:30", "2017.02.30 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 16" },

		{ "2016.02.30 10:30", "2017.11.31 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 17" },

		{ "2017.02.30 10:30", "2018.11.31 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 18" },

		{ "2017.06.31 10:30", "2018.11.31 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 19" },

		{ "2017.11.31 10:30", "2018.06.31 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 20" },

		{ "2018.11.31 10:30", "2017.11.31 10:30", ParkingLotType.ShortTerm, InvalidDataException.class, "Regra 21" }

		});
	}

	@Rule
	public ExpectedException exceptionalExpectation = ExpectedException.none();

	@Test
	public void testShouldCalculaterParkingCostExceptional() throws DateFormatException, InvalidDataException {

		// / Configuração
		exceptionalExpectation.expect(exception);
		Calculator calculator = new Calculator();

		// / Ação
		Float result = calculator.calculateParkingCost(checkin, checkout, type);

		// / Verificação
		assertEquals("", result);
	}
}
