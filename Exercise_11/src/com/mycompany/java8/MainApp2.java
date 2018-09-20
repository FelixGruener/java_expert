package com.mycompany.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class MainApp2 {

	public static void main(String[] args) {
		
		
		 /* you have given the current timestamp in our timezone
		  how late is it in California at the same moment? (9 hours)
		  
		  you have given today/12 o'clock in the timezone NYC
		  how late is it in Switzerland at the same moment? (8 hours)
		  USE ZonedDateTime class */
		
		
		ZonedDateTime zonedDateTimeCH = ZonedDateTime.now();
		
		ZonedDateTime tsCA = zonedDateTimeCH.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
		
		System.out.println(formatter.format(tsCA));
		
		System.out.println(tsCA); //am Schluss ist TiemOffset zu UTC 
		
		System.out.println(tsCA.format(formatter));
		
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.of(12, 0);
		LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
		
		ZonedDateTime tsNYC = ZonedDateTime.of(localDateTime, ZoneId.of("America/New_York"));
		ZonedDateTime tsCH = tsNYC.withZoneSameInstant(ZoneId.systemDefault());
		
		System.out.println(tsCH);
		
		//Instant
		//LocalDate
		//LocalTime
		//LocalDateTime
		
		//ZonedDateTime , ZoneId
		
		//DateTimeFormatter
		
		//Period vs. Duration 

	}

}
