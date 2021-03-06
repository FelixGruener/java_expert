package com.mycompany.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class MainApp {
	/*
	Ostermontag: Ostersonntag + 1 Tag
	Christi Himmelfahrt: Ostersonntag + 39 Tage
	Pfingstmontag: Ostersonntag + 50 Tage
	Fronleichnam: Ostersonntag + 60 Tage
	Weitere Feiertage: 01.01., 06.01., 01.05., 15.08., 26.10., 01.11., 08.12., 24.12. (�), 25.12., 26.12., 31.12. (�)
*/

	public static void main(String[] args) {
		System.out.println(isHoliday(LocalDate.of(2018, 1, 1))); //True
		System.out.println(isHoliday(LocalDate.of(2018, 4, 2))); //True
		System.out.println(isHoliday(LocalDate.of(2018, 4, 3))); //FALSE

	}
	
	
	public static boolean isWorkingDay(LocalDate dateToCheck) {
		return !isHoliday(dateToCheck) &&
				dateToCheck.getDayOfWeek() != DayOfWeek.SATURDAY &&
				dateToCheck.getDayOfWeek() != DayOfWeek.SUNDAY;
	}
	
	public static boolean isHoliday(LocalDate dateToCheck) {
		
		return getHolidays(dateToCheck.getYear()).stream().anyMatch(date -> date.equals(dateToCheck));
	}
	

	
	private static List<LocalDate> getHolidays(int year){
		
		
		LocalDate easterSunday = getEasterSunday(year);
		return Arrays.asList(
				easterSunday,
				easterSunday.plusDays(1),
				easterSunday.plusDays(39),
				easterSunday.plusDays(50),
				easterSunday.plusDays(60),
				LocalDate.of(year,Month.JANUARY, 1),
				LocalDate.of(year,Month.JANUARY, 6),
				LocalDate.of(year,Month.MAY, 1),
				LocalDate.of(year,Month.JANUARY, 1),
				LocalDate.of(year,Month.AUGUST, 15),
				LocalDate.of(year,Month.OCTOBER, 26),
				LocalDate.of(year,Month.NOVEMBER, 1)
				);
				
				
		
	}
	
	public static LocalDate getEasterSunday(int year) {
		
		switch(year) {
		case 2018:
			return LocalDate.of(2018, Month.APRIL, 1);
		default:
			throw new UnsupportedOperationException("year '" + year + "'not supported yet");
		}
		
		
	}


}
