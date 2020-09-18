import java.util.ArrayList;
import java.io.Serializable;

public class League implements Serializable{
	private String name;
	ArrayList<Team> teams = new ArrayList<>();
	
	//constructor
	public League(String lname) {
		this.name = lname;
	}
	
	//getters
	public String getName() {
		return name;
	}


	//setter
	public void setName(String name) {
		this.name = name;
	}

	// add a team
	public void addteam(Team team) {
		teams.add(team);
	}

	// remove a team
	public void removeteam(Team team) {
		teams.remove(team);
	}
	
	//toString
	
	
	public String toString() {
		
		String listOfTeams = "";
		
		for(int i = 0; i < this.teams.size(); i++)
		{
			listOfTeams += this.teams.get(i).getName() + "\n";
		}
		
		return this.name+ "\nList of teams:\n"+listOfTeams ;
	}
	

	//print
	public void print() {
		System.out.println(this.name+ ""+ this.name);
	}
}


//class responsibility 
