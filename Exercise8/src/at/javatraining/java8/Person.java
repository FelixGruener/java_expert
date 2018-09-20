package at.javatraining.java8;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	private long id;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private boolean activated;
	private Address address;
	
	public Person() {}
	
	public Person(long id, String firstName, String lastName, LocalDate birthDate, boolean activated, Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.activated = activated;
		this.address = address;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getAge() {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", activated=" + activated + ", address=" + address + "]";
	}
}