package imd0412.parkinglot.calculator;

import imd0412.parkinglot.ParkingLotType;
import imd0412.parkinglot.exception.DateFormatException;
import imd0412.parkinglot.exception.InvalidDataException;
import imd0412.parkinglot.exception.InvalidDataType;

public class Calculator {
	/**
	 * Calculates the staying cost in the parking lot.
	 * 
	 * @param checkin
	 *            String representing check-in date. String follows the format
	 *            "yyyy.MM.dd HH:mm".
	 * @param checkout
	 *            String representing check-out date. String follows the format
	 *            "yyyy.MM.dd HH:mm".
	 * @param type
	 * @return
	 * @throws DateFormatException 
	 * @throws InvalidDataException 
	 */
	Float calculateParkingCost(String checkin, String checkout,
			ParkingLotType type) throws DateFormatException, InvalidDataException {

		checkingDateFormat(checkin);
		
		checkingDateFormat(checkout);
		
		
		checkingInvalidData(checkin, checkout);
		
		return null;
	}
	
	private void checkingDateFormatCheckinCheckout(String checkin, String checkout) throws DateFormatException { 
		
	checkingDateFormat(checkin);
		
		checkingDateFormat(checkout);
		
		
	}
		
	
	
	private void checkingDateFormat(String checkin_checkout) throws DateFormatException {
		
		if (checkin_checkout.length() != 16)
			throw new DateFormatException("Tamanho inválido");

		if (!(checkin_checkout.charAt(4) == '.') &&
			!(checkin_checkout.charAt(7) == '.') &&
			!(checkin_checkout.charAt(10) == ' ') &&
			!(checkin_checkout.charAt(13) == ':') )
			throw new DateFormatException("Esqueceu de colocar todas as pontuações.");
			
		checkingContainsInteger(checkin_checkout.substring(0, 1));
		checkingContainsInteger(checkin_checkout.substring(6, 7));
		checkingContainsInteger(checkin_checkout.substring(8, 9));
		checkingContainsInteger(checkin_checkout.substring(11, 13));
		checkingContainsInteger(checkin_checkout.substring(14, 16));
				
	}

	private void checkingContainsInteger(String letter) throws DateFormatException {
		if (!letter.matches("[0-9]+") )
			throw new DateFormatException();
	}
	
	private void checkingInvalidData(String checkin, String checkout) throws InvalidDataException {

		int anoCheckin =Integer.parseInt(checkin);
		int mesCheckin =Integer.parseInt(checkin);
		int diaCheckin = Integer.parseInt(checkin);
		int horaCheckin =Integer.parseInt(checkin);
		int minutoCheckin =Integer.parseInt(checkin);
		
		int anoCheckout = Integer.parseInt(checkout);
		int mesCheckout =Integer.parseInt(checkout);
		int diaCheckout =Integer.parseInt(checkout);
		int horaCheckout =Integer.parseInt(checkout);
		int minutoCheckout = Integer.parseInt(checkout);
		
		checkAnoCheckin(anoCheckin);
		checkAnoCheckout(anoCheckout);
		
		checkMesCheckinCheckout(mesCheckin);
		checkMesCheckinCheckout(mesCheckout);
		
		checkDiaCheckinCheckout(diaCheckin);
		checkDiaCheckinCheckout(diaCheckout);
		
		checkHoraCheckinCheckout(horaCheckin);
		checkHoraCheckinCheckout(horaCheckout);
	
		checkMinutoCheckinCheckout(minutoCheckin);
		checkMinutoCheckinCheckout(minutoCheckout);
		
	}
	
	
	private void checkAnoCheckin(int anoCheckin) throws InvalidDataException  {
		
		if (anoCheckin < 1970)
			throw new InvalidDataException(InvalidDataType.InvalidYear);
		
		if (anoCheckin > 2018)
			throw new InvalidDataException(InvalidDataType.InvalidYear);
	}
	
	private void checkAnoCheckout(int anoCheckout) throws InvalidDataException {
		if (anoCheckout < 1970)
			throw new InvalidDataException(InvalidDataType.InvalidYear);
		
		if (anoCheckout > 2019)
			throw new InvalidDataException(InvalidDataType.InvalidYear);
	}
	
	private void checkMesCheckinCheckout(int mesCheckinCheckout) throws InvalidDataException {
		if (mesCheckinCheckout > 12)
			throw new InvalidDataException(InvalidDataType.InvalidMonth);
	}
	
	private void checkDiaCheckinCheckout(int diaCheckinCheckout) throws InvalidDataException {
		if (diaCheckinCheckout > 31)
			throw new InvalidDataException(InvalidDataType.InvalidDay);
	}
	
	private void checkHoraCheckinCheckout(int horaCheckinCheckout) throws InvalidDataException {
		if (horaCheckinCheckout > 23)
			throw new InvalidDataException(InvalidDataType.InvalidHour);
	}
	
	private void checkMinutoCheckinCheckout(int minutoCheckinCheckout) throws InvalidDataException {
		if (minutoCheckinCheckout > 59)
			throw new InvalidDataException(InvalidDataType.InvalidMinute);
	}
}


