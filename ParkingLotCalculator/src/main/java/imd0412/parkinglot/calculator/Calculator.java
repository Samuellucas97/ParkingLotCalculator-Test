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
	Float calculateParkingCost(String checkin, String checkout, ParkingLotType type) throws DateFormatException,
			InvalidDataException {

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

		if (checkin_checkout.length() != 16) {
			throw new DateFormatException("Tamanho inválido");
		}

		if (!(checkin_checkout.charAt(4) == '.') || !(checkin_checkout.charAt(7) == '.')
				|| !(checkin_checkout.charAt(10) == ' ') || !(checkin_checkout.charAt(13) == ':')) {
			throw new DateFormatException("Esqueceu de colocar todas as pontuações.");
		}

		checkingContainsInteger(checkin_checkout.substring(0, 4));
		checkingContainsInteger(checkin_checkout.substring(5, 7));
		checkingContainsInteger(checkin_checkout.substring(8, 10));
		checkingContainsInteger(checkin_checkout.substring(11, 13));
		checkingContainsInteger(checkin_checkout.substring(14, 16));

	}

	private void checkingContainsInteger(String integerstring) throws DateFormatException {
		if (!integerstring.matches("[0-9]+")) {
			throw new DateFormatException();
		}
	}

	private void checkingInvalidData(String checkin, String checkout) throws InvalidDataException {

		int anoCheckin = Integer.parseInt(checkin.substring(0, 4));
		int mesCheckin = Integer.parseInt(checkin.substring(5, 7));
		int diaCheckin = Integer.parseInt(checkin.substring(8, 10));
		int horaCheckin = Integer.parseInt(checkin.substring(11, 13));
		int minutoCheckin = Integer.parseInt(checkin.substring(14, 16));

		int anoCheckout = Integer.parseInt(checkout.substring(0, 4));
		int mesCheckout = Integer.parseInt(checkout.substring(5, 7));
		int diaCheckout = Integer.parseInt(checkout.substring(8, 10));
		int horaCheckout = Integer.parseInt(checkout.substring(11, 13));
		int minutoCheckout = Integer.parseInt(checkout.substring(14, 16));

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

		checkLeapYearFebruaryDays(anoCheckin, mesCheckin, diaCheckin);
		checkLeapYearFebruaryDays(anoCheckout, mesCheckout, diaCheckout);

		check30DaysMonth(mesCheckin, diaCheckin);
		check30DaysMonth(mesCheckout, diaCheckout);

		checkCheckinBiggerThanCheckout(anoCheckin, mesCheckin, diaCheckin, horaCheckin, minutoCheckin, anoCheckout,
				mesCheckout, diaCheckout, horaCheckout, minutoCheckout);
	}

	private void checkCheckinBiggerThanCheckout(int anoCheckin, int mesCheckin, int diaCheckin, int horaCheckin,
			int minCheckin, int anoCheckout, int mesCheckout, int diaCheckout, int horaCheckout, int minCheckout)
			throws InvalidDataException {
		if (anoCheckin > anoCheckout) {
			throw new InvalidDataException(InvalidDataType.CheckinBiggerThanCheckout);
		} else if (anoCheckin == anoCheckout) {
			if (mesCheckin > mesCheckout) {
				throw new InvalidDataException(InvalidDataType.CheckinBiggerThanCheckout);
			} else if (mesCheckin == mesCheckout) {
				if (diaCheckin > diaCheckout) {
					throw new InvalidDataException(InvalidDataType.CheckinBiggerThanCheckout);
				} else if (diaCheckin == diaCheckout) {
					if (horaCheckin > horaCheckout) {
						throw new InvalidDataException(InvalidDataType.CheckinBiggerThanCheckout);
					} else if (horaCheckin == horaCheckout) {
						if (minCheckin > minCheckout) {
							throw new InvalidDataException(InvalidDataType.CheckinBiggerThanCheckout);
						}
					}
				}
			}
		}

	}

	private void check30DaysMonth(int mes, int dia) throws InvalidDataException {
		if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia > 30)) {
			throw new InvalidDataException(InvalidDataType.NonexistentDate);
		}

	}

	private void checkLeapYearFebruaryDays(int ano, int mes, int dia) throws InvalidDataException {
		if ((ano % 4 == 0) && (mes == 2) && (dia > 29)) {
			throw new InvalidDataException(InvalidDataType.NonexistentDate);
		} else if (!(ano % 4 == 0) && (mes == 2) && (dia > 28)) {
			throw new InvalidDataException(InvalidDataType.NonexistentDate);
		}
	}

	private void checkAnoCheckin(int anoCheckin) throws InvalidDataException {

		if (anoCheckin < 1970) {
			throw new InvalidDataException(InvalidDataType.InvalidYear);
		}

		if (anoCheckin > 2018) {
			throw new InvalidDataException(InvalidDataType.InvalidYear);
		}
	}

	private void checkAnoCheckout(int anoCheckout) throws InvalidDataException {
		if (anoCheckout < 1970) {
			throw new InvalidDataException(InvalidDataType.InvalidYear);
		}

		if (anoCheckout > 2019) {
			throw new InvalidDataException(InvalidDataType.InvalidYear);
		}
	}

	private void checkMesCheckinCheckout(int mesCheckinCheckout) throws InvalidDataException {
		if (mesCheckinCheckout > 12) {
			throw new InvalidDataException(InvalidDataType.InvalidMonth);
		}
	}

	private void checkDiaCheckinCheckout(int diaCheckinCheckout) throws InvalidDataException {
		if (diaCheckinCheckout > 31) {
			throw new InvalidDataException(InvalidDataType.InvalidDay);
		}
	}

	private void checkHoraCheckinCheckout(int horaCheckinCheckout) throws InvalidDataException {
		if (horaCheckinCheckout > 23) {
			throw new InvalidDataException(InvalidDataType.InvalidHour);
		}
	}

	private void checkMinutoCheckinCheckout(int minutoCheckinCheckout) throws InvalidDataException {
		if (minutoCheckinCheckout > 59) {
			throw new InvalidDataException(InvalidDataType.InvalidMinute);
		}
	}
}
