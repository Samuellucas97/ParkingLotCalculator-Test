package imd0412.parkinglot.calculator;

import imd0412.parkinglot.ParkingLotType;
import imd0412.parkinglot.exception.DateFormatException;
import imd0412.parkinglot.exception.InvalidDataException;

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
	 */
	Float calculateParkingCost(String checkin, String checkout,
			ParkingLotType type) throws DateFormatException {

		checkingFormat(checkin);
		
		checkingFormat(checkout);
		
		
		
		return null;
	}
	
	private void checkingFormat(String checkin_checkout) throws DateFormatException {
		
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
	
	private void s(String checkin_checkout) {

		int anoCheckin =Integer.parseInt(checkin_checkout);
		int mesCheckin =Integer.parseInt(checkin_checkout);
		int diaCheckin = Integer.parseInt(checkin_checkout);
		int horaCheckin =Integer.parseInt(checkin_checkout);
		int minutoCheckin =Integer.parseInt(checkin_checkout);
		
		int anoCheckout = Integer.parseInt(checkout);
		int mesCheckout =Integer.parseInt(checkout);
		int diaCheckout =Integer.parseInt(checkout);
		int horaCheckout =Integer.parseInt(checkout);
		int minutoCheckout = Integer.parseInt(checkout);
		
	}
	
	private void checkAnoCheckinCheckout(int anoCheckinCheckout) throws InvalidDataException {
		if (anoCheckinCheckout < 1970)
			throw new InvalidDataException("");
	}
	
	
	private void checkAnoCheckin(int anoCheckin) throws InvalidDataException  {
		
		checkAnoCheckinCheckout(anoCheckin);
		
		if (anoCheckin > 2018)
			throw new InvalidDataException("");
	}
	
	private void checkAnoCheckout(int anoCheckout) throws InvalidDataException {
		
		checkAnoCheckinCheckout(anoCheckout);
		
		if (anoCheckout > 2019)
			throw new InvalidDataException("");
	}
	
	private void checkMesCheckinCheckout(int mesCheckinCheckout) throws InvalidDataException {
		if (mesCheckinCheckout > 12)
			throw new InvalidDataException("");
	}
	
	private void checkDiaCheckinCheckout(int diaCheckinCheckout) throws InvalidDataException {
		if (diaCheckinCheckout > 31)
			throw new InvalidDataException();
	}
	
	private void checkHoraCheckinCheckout(int horaCheckinCheckout) throws InvalidDataException {
		if (horaCheckinCheckout > 23)
			throw new InvalidDataException("");
	}
	
	private void checkMinutoCheckinCheckout(int minutoCheckinCheckout) throws InvalidDataException {
		if (minutoCheckinCheckout > 59)
			throw new InvalidDataException("");
	}
}


