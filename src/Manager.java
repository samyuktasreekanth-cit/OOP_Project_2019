//subclass of Person.java
//manager knows which team he manages

//assuming manager manages only one team, bidirectional relationship between Team.java

import java.io.Serializable;

public class Manager extends Person implements Serializable {
	// attributes
	private String DOB;
	private int StarRating; // inclusive (1-10)
	private Team team; // a manager manages only one team

	// constructor
	public Manager(String dob, int star, Name name, String phone, String email) {
		super(name, phone, email);
		this.DOB = dob;
		this.StarRating = star;
	}

	// getters
	public String getDOB() {
		return DOB;
	}

	public int getStarRating() {
		return StarRating;
	}

	public Team getTeam() {
		return team;
	}

	// setters
	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public void setStarRating(int starRating) {
		StarRating = starRating;
	}

	// bidirectional in Manager
	public void setTeam(Team t) {
		team = t;
		if (t.getManager() != this) {
			t.setManager(this);
		}
	}
//	if(this.team!=null) {
//	System.out.println("Only 1 manager per team allowed");
//}

	// toString()
	public String toString() {
		return super.toString() + " " + this.DOB + " " + this.StarRating;
	}

	// print
	public void print() {
		System.out.println("DOB: " + DOB + "StarRating: " + StarRating);
	}

}
