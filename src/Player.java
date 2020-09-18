//subclass of Person.java
//contains Player details
import java.io.Serializable;

public class Player extends Person implements Serializable {
	// attributes
	private int goals;
	private boolean goalie;

	public Player(int goals, boolean goalie, Name name, String phone, String email) {
		super(name, phone, email);
		this.goals = goals;
		this.goalie = goalie;
	}

	// getters
	public int getGoals() {
		return goals;
	}
	public boolean getGoalie() {
		return this.goalie;
	}

	// setters
	public void setGoals(int goals) {
		this.goals = goals;
	}

	public String player_details() {
		String res = "";
		res = this.getName() + ", " + this.getPhone() + ", "+ this.getEmail();
		return res;
	}
	
	// display statement: player is a goalie or not
	public String checkgoalie() {
		String res = "";
		if (this.goalie == true) {
			res = this.getName()+ " is a goalie and has stopped " + this.goals + " goals";
		} else {
			res = this.getName()+ " has scored " + this.goals + " goals";
		}
		return res;
	}

//	public String toString() {
//		System.out.println();
//		return super.toString() + "\n" + this.getName().toString() + this.checkgoalie();
//	}

	public String toString() {
		return this.getName().toString();
	}
	public void print() {
		System.out.println(super.toString() + "\n" + this.getName().toString() + this.checkgoalie());
	}
}
