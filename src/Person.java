//super class for the people in the League system
import java.io.Serializable;

public class Person implements Serializable{
	// attributes
	private Name name;
	private String phone;
	private String email;

	// constructor
	public Person(Name name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	// getters
	public Name getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	// setters
	public void setName(Name name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// toString()
	public String toString() {
		return name + " " + phone + " " + email;
	}

	// print()
	public void print() {
		System.out.println("name: " + name + "\nphone: " + phone + "\nemail: " + email);
	}
}
