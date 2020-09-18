
import java.util.ArrayList;
import java.io.Serializable;

public class Team implements Serializable{
	// attributes
	private String name;
	private String jersey_colour;
	private Manager manager;
	ArrayList<Player> players = new ArrayList<>();

	// constructor
	public Team(String name, String jersey_colour) {
		this.name = name;
		this.jersey_colour = jersey_colour;
	}

	// getters
	public String getName() {
		return this.name;
	}
	public String getJersey_colour() {
		return this.jersey_colour;
	}

	public Manager getManager() {
		return manager;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	// setters
	public void setName(String name) {
		this.name = name;
	}

	public void setJersey_colour(String jersey_colour) {
		this.jersey_colour = jersey_colour;
	}

	// add a player
	public void addPlayer(Player player) {
		players.add(player);
		if(this.name !=null) {
			System.out.println("Same player cannot be there in two teams");
		}
	}

	// remove a player
	public void RemovePlayer(Player player) {
		players.remove(player);
	}

	public void setManager(Manager manager) {
		this.manager = manager;
		if(manager.getTeam() != this) {
			manager.setTeam(this);
		}
	}

	
	// toString
	public String toString() {
		String listOfPlayers = "";
		
		for(int i = 0; i < this.players.size(); i++)
		{
			listOfPlayers += this.players.get(i).getName() + "\n";
		}
		return "Team name: " + this.name + "\nJersey colour: " + this.jersey_colour + "\nManager: "+ this.manager + "\nList of players:" +listOfPlayers;
	}

	// print
	public void print() {
		System.out.println("Team name: " + this.name + "\nJersey colour: " + this.jersey_colour + "\nManager: "
				+ this.manager + "Players: " + this.players);
	}
}



//search player here