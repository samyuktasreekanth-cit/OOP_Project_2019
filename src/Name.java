//names of Players and managers
import java.io.Serializable;

public class Name implements Serializable{
	// attributes
	private String firstName;
	private String middleName;
	private String lastName;
	

	public Name(String fname, String mname, String lname) {
		this.firstName = fname;
		this.middleName = mname;
		this.lastName = lname;
	}

	// getters
	public String getFirstName() {
		return this.firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	// setters
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// toString()
	public String toString() {
		return firstName + " " + middleName + " " + lastName;
	}

	// print()
	public void print() {
		System.out.println("first name: " + firstName + "\nmiddle name: " + middleName + "\nlast name: " + lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		return this.firstName.equals(other.firstName) && this.middleName.equals(other.middleName) && this.lastName.equals(other.lastName);
	}
	
	

}
