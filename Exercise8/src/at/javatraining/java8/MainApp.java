package at.javatraining.java8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainApp {
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
			new Person(1, "Josef", "Huber", LocalDate.of(1980, 1, 1), true, new Address(1, "Hauptstra�e 1", "3270", "Scheibbs", "AT")),
			new Person(2, "Sabine", "Sonnenschein", LocalDate.of(1978, 12, 24), true, new Address(2, "Rennweg 12", "1030", "Wien", "AT")),
			new Person(3, "Klaus", "Maierhofer", LocalDate.of(1990, 1, 1), false, new Address(3, "Karlsplatz 2", "1030", "Wien", "AT")),
			new Person(4, "Franz", "Beckenbauer", LocalDate.of(1950, 2, 1), true, new Address(4, "Berliner Stra�e 123", "11111", "M�nchen", "DE")),
			new Person(5, "Claudia", "Berger", LocalDate.of(1970, 1, 3), true, new Address(5, "Weg 1", "22222", "Hamburg", "DE")),
			new Person(6, "Pierre", "Gr�ninger", LocalDate.of(1960, 1, 1), true, new Address(6, "Emerlingweg 12", "12121", "Z�rich", "CH")),
			new Person(7, "Alexandra", "Gr�ninger", LocalDate.of(1962, 3, 1), true, new Address())
		);

		// return the full name of all persons from Vienna in form of a list
		List<String> names =
		persons.stream()
				//.filter(person -> "Wien".equals(person.getAddress().getCity()))
				.filter(person -> Objects.equals("Wien", (person.getAddress() != null ? person.getAddress().getCity():null)))
				.map(person -> person.getName())
				.collect(Collectors.toList());
		
		System.out.println("Number of names found: " + names.size()); //2
				
		
		// print all persons who are activated and come from Austria to the standard console
		
		persons.stream()
					.filter(person -> person.isActivated())
					.filter(person -> "AT".equals(person.getAddress().getCountryCode()))
					.forEach(System.out::println); //Josef Huber, Sabine Sonnenschein
		
		// calculate the average age of all persons from Germany
		OptionalDouble averageAge =
				persons.stream()
						.filter(person -> "DE".equals(person.getAddress().getCountryCode()))
						.mapToInt(person -> person.getAge())
						.average();
						//.getAsDouble();
		 System.out.println("Average age: " + averageAge.getAsDouble()); 
		
		// is there a person in the list who is over 50 years old and from Switzerland?
		 Predicate<Person> isFromSwitzerland = person -> "CH".equals(person.getAddress().getCountryCode());
		 Predicate<Person> isOlderThan50 = person -> person.getAge() > 50; //58
		 
		 boolean result1 = persons.stream()
				 .anyMatch(isFromSwitzerland.and(isOlderThan50));
		 System.out.println("Result1: " + result1); //true
		  
		
		// are the addresses of all persons valid (i. e. all fields are not null and not empty)?
		 
		 boolean result2 = persons.stream()
				 .anyMatch(person->person.getAddress().isValid());
		 System.out.println("Result2: " + result2 ); //true
		 
		 
		 
	}
}