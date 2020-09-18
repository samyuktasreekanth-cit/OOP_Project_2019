import java.util.Scanner;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test_Menu {

	public static void main(String[] args) {
		int user_input;

		ArrayList<Team> myteams = new ArrayList<Team>();
		ArrayList<Player> myplayer = new ArrayList<Player>();
		ArrayList<Manager> mymanager = new ArrayList<Manager>();
		ArrayList<League> myleague = new ArrayList<League>();

		do {
			System.out.println("\nSOCCER LEAGUE APPLICATION");
			System.out.println("_________________________");
			System.out.println("1.Create a new Team");
			System.out.println("2.Create a new player");
			System.out.println("3.Create a new manager");
			System.out.println("4.Create a league");

			System.out.println("\n5.Add a team to a league");
			System.out.println("6.Add a player to a team");
			System.out.println("7.Add a manager to a team");

			System.out.println("\n8.Remove a player");

			System.out.println("\n9.Searching for a player");

			System.out.println("\n10.Display all the players in a particular team");
			System.out.println("11.Display all the players");
			System.out.println("12.Display all the teams");
			System.out.println("13.Display all the teams in a league");

			System.out.println("\n14.Save all the information from a text file");
			System.out.println("15.Load information from a text file");

			System.out.println("\n16.Quit");

			Scanner sc = new Scanner(System.in);
			System.out.println("\nEnter your choice: ");
			user_input = sc.nextInt();

			Scanner src = new Scanner(System.in);
			Scanner num = new Scanner(System.in);

			switch (user_input) {

			// CREATE A NEW TEAM
			case 1:
				System.out.println("Team name: ");
				String new_team_name = src.nextLine();

				System.out.println(new_team_name + "'s jersey colour: ");
				String new_colour = src.nextLine();

				Team newTeam = new Team(new_team_name, new_colour);
				if (checkcolour(newTeam, myteams)) {
					myteams.add(new Team(new_team_name, new_colour));

					System.out.println("NEW TEAM CREATED");
				} else {
					System.out.println("NOT UNIQUE. TRY AGAIN");
				}

				break;

			// CREATING A NEW PLAYER
			case 2:
				System.out.println("firstname: ");
				String fname = src.nextLine();

				System.out.println("middle name(optional): ");
				String mname = src.nextLine();

				System.out.println("lastname name: ");
				String lname = src.nextLine();

				Name pname = new Name(fname, mname, lname);

				Scanner bool = new Scanner(System.in);
				System.out.println("goalie(true or false): ");
				boolean ngoalie = bool.hasNextBoolean();

				int ngoals;
				if (ngoalie == true) {
					System.out.println("How many goals have you saved?: ");
					ngoals = num.nextInt();
				} else {
					System.out.println("How many goals did you score?: ");
					ngoals = num.nextInt();
				}

				System.out.println("phone: ");
				String nphone = src.nextLine();

				System.out.println("email: ");
				String nemail = src.nextLine();

				myplayer.add(new Player(ngoals, ngoalie, pname, nphone, nemail));

				break;

			// CREATE A NEW MANAGER
			case 3:
				System.out.println("DOB(yyyy-mm-dd): ");
				String dob = src.nextLine();

				System.out.println("Star rating(1-10) inclusive: ");
				int star = num.nextInt();

				System.out.println("firstname: ");
				String mfname = src.nextLine();

				System.out.println("middle name(optional):");
				String mmname = src.nextLine();

				System.out.println("lastname name: ");
				String mlname = src.nextLine();

				Name manager_name = new Name(mfname, mmname, mlname);

				System.out.println("phone: ");
				String mphone = src.nextLine();

				System.out.println("email: ");
				String memail = src.nextLine();

				mymanager.add(new Manager(dob, star, manager_name, mphone, memail));
				break;

			// CREATE A NEW LEAGUE
			case 4:
				System.out.println("Enter league name: ");
				String new_league = src.nextLine();
				myleague.add(new League(new_league));
				System.out.println("LEAGUE CREATED");
				break;

			// ADD A TEAM TO A LEAGUE
			case 5:
				League LeagueToAdd = null;
				Team TeamToAdd = null;

				System.out.println("\nLeagues available so far:");
				for (int i = 0; i < myleague.size(); i++) {
					System.out.println(myleague.get(i).getName());
				}

				System.out.println("Enter the name of the league: ");
				String user_league = src.nextLine();

				for (int i = 0; i < myleague.size(); i++) {
					if (myleague.get(i).getName().equals(user_league)) {
						LeagueToAdd = myleague.get(i);
					} else {
						System.out.println("League not found");
					}
				}

				System.out.println("\nTeams avaiable so far:");
				for (int i = 0; i < myteams.size(); i++) {
					System.out.println(myteams.get(i).getName());
				}

				System.out.println("Enter the team name: ");
				String league_team = src.nextLine();

				boolean found = false;
				for (int i = 0; i < myteams.size(); i++) {
					if (myteams.get(i).getName().equals(league_team)) {
						found = true;
						TeamToAdd = myteams.get(i);
					}
				}
				if (found == false) {
					System.out.println("team not found");
				}

				LeagueToAdd.addteam(TeamToAdd);
				System.out.println("TEAM ADDED TO LEAGUE");

				break;

			case 6:
				// ADD A PLAYER TO A TEAM
				Team teamToAdd = null;
				Player playerToAdd = null;

				System.out.println("\nTeams avaiable so far:");
				for (int i = 0; i < myteams.size(); i++) {
					System.out.println(myteams.get(i).getName());
				}

				System.out.println("Enter the team name: ");
				String user_team = src.nextLine();

				for (int i = 0; i < myteams.size(); i++) {
					if (myteams.get(i).getName().equals(user_team)) {
						Team display_team = myteams.get(i);
						teamToAdd = myteams.get(i);
						System.out.println(display_team);
					} else {
						System.out.println("not found");
					}
				}

				System.out.println("\nPlayers available so far:");
				for (int i = 0; i < myplayer.size(); i++) {
					System.out.println(myplayer.get(i).getName());
				}
				System.out.println("Enter the player first name: ");
				String user_player1 = src.nextLine();

				// display all the details of the player user has selected
				for (int i = 0; i < myplayer.size(); i++) {
					if (myplayer.get(i).getName().getFirstName().equals(user_player1)) {
						Player display_player = myplayer.get(i);
						playerToAdd = myplayer.get(i);
						System.out.println("exists");
						System.out.println(playerToAdd);
					} else {
						System.out.println("Player does not exist");
					}
				}

				teamToAdd.addPlayer(playerToAdd);

				System.out.println("NEW PLAYER Added.");

				break;

			// ADD A MANAGER TO A TEAM
			case 7:
				Team TheTeamToAdd = null;
				Manager ManagerToAdd = null;

				System.out.println("\nTeams avaiable so far:");
				for (int i = 0; i < myteams.size(); i++) {
					System.out.println(myteams.get(i).getName());
				}

				System.out.println("Enter the team name: ");
				String manager_team = src.nextLine();

				for (int i = 0; i < myteams.size(); i++) {
					if (myteams.get(i).getName().equals(manager_team)) {
						TheTeamToAdd = myteams.get(i);
					} else {
						System.out.println("team not found");
					}
				}

				System.out.println("\nManagers avaiable so far:");
				for (int i = 0; i < mymanager.size(); i++) {
					System.out.println(mymanager.get(i).getName());
				}

				System.out.println("Enter the manager first name: ");
				String f_manager = src.nextLine();

				for (int i = 0; i < mymanager.size(); i++) {
					if (mymanager.get(i).getName().getFirstName().equals(f_manager)) {
						ManagerToAdd = mymanager.get(i);
					} else {
						System.out.println("manager not found");
					}
				}

				TheTeamToAdd.setManager(ManagerToAdd);
				System.out.println("MANAGER ADDED TO TEAM");

				break;

			// REMOVE A PLAYER
			case 8:
				Team TeamToRemove = null;
				Player PlayerToRemove = null;

				System.out.println("\nTeams avaiable so far:");
				for (int i = 0; i < myteams.size(); i++) {
					System.out.println(myteams.get(i).getName());
				}

				System.out.println("Enter the team name: ");
				String i_team = src.nextLine();

				for (int i = 0; i < myteams.size(); i++) {
					if (myteams.get(i).getName().equals(i_team)) {
						TeamToRemove = myteams.get(i);
					} else {
						System.out.println("team not found");
					}
				}

				System.out.println("\nPlayers available so far:");
				for (int i = 0; i < myplayer.size(); i++) {
					System.out.println(myplayer.get(i).getName());
				}
				System.out.println("Enter the player first name: ");
				String r_player = src.nextLine();

				for (int i = 0; i < myplayer.size(); i++) {
					if (myplayer.get(i).getName().getFirstName().equals(r_player)) {
						PlayerToRemove = myplayer.get(i);
					} else {
						System.out.println("player not found");
					}
				}

				TeamToRemove.RemovePlayer(PlayerToRemove);
				System.out.println("PLAYER REMOVED");

				break;

			// SEARCH FOR A PLAYER
			case 9:
				System.out.println("\nPlayers available so far:");
				for (int i = 0; i < myplayer.size(); i++) {
					System.out.println(myplayer.get(i).getName());
				}
				System.out.println("Enter the player first name: ");
				String user_player2 = src.nextLine();

				// display all the details of the player user has selected
				for (int i = 0; i < myplayer.size(); i++) {
					if (myplayer.get(i).getName().getFirstName().equals(user_player2)) {
						Player display_player = myplayer.get(i);
						System.out.println(display_player.getName() + " " + display_player.getEmail() + " "
								+ display_player.getPhone());
						System.out.println(myplayer.get(i).checkgoalie());

						// getting the manager name
						System.out.println("The manager for " + user_player2 + " is: ");

						for (int j = 0; j < myteams.size(); j++) {
							Name correct_team = myteams.get(i).getManager().getName();
							System.out.print(correct_team);
							System.out.println();
						}

					} else {
						System.out.println("Player does not exist");
					}
				}
				break;

			// DISPLAY ALL THE PLAYERS IN A PARTICULAR TEAM
			case 10:
				System.out.println("\nAll the teams available so far:");
				for (int i = 0; i < myteams.size(); i++) {
					String display_team = myteams.get(i).getName();
					System.out.println(display_team);
				}

				System.out.println("\nEnter the team name: ");
				String search_team = src.nextLine();

				System.out.println("\nThe players in " + search_team + " are: ");
				for (int i = 0; i < myteams.size(); i++) {
					ArrayList<Player> list_players = myteams.get(i).players;
					System.out.println(list_players);
				}
				break;

			// DISPLAY ALL THE PLAYERS
			case 11:
				for (int i = 0; i < myplayer.size(); i++) {
					System.out.println(myplayer.get(i));
					System.out.println(myplayer.get(i).checkgoalie());
				}
				break;

			// DISPLAY ALL THE TEAMS
			case 12:
				for (int i = 0; i < myteams.size(); i++) {
					System.out.println(myteams.get(i));
				}
				break;

			// DISPLAY ALL THE TEAMS IN A LEAGUE
			case 13:
				System.out.println("\nLeagues available so far:");
				for (int i = 0; i < myleague.size(); i++) {
					System.out.println(myleague.get(i).getName());
				}
				System.out.println("Enter the name of the league: ");
				String display_the_league = src.nextLine();

				for (int i = 0; i < myleague.size(); i++) {
					System.out.println(myleague.get(i));
				}
				
//				for(League i: myleague) {
//					System.out.println(myleague.get(i));
//				}

				break;

			// SAVE ALL THE INFO IN A TXT FILE
			case 14:
				try {
					FileOutputStream f_out = new FileOutputStream(new File("oop.txt"));
					ObjectOutputStream o_out = new ObjectOutputStream(f_out);

					o_out.writeObject(myplayer);
					o_out.writeObject(mymanager);
					o_out.writeObject(myteams);
					o_out.writeObject(myleague);
					o_out.close();
					System.out.println("Saved to a txt file");
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;

			// LOAD ALL THE INFO FROM A TXT FILE
			case 15:
				try {
					FileInputStream f_in = new FileInputStream(new File("oop.txt"));
					ObjectInputStream o_in = new ObjectInputStream(f_in);

					myplayer = (ArrayList<Player>) o_in.readObject();
					mymanager = (ArrayList<Manager>) o_in.readObject();
					myteams = (ArrayList<Team>) o_in.readObject();
					myleague = (ArrayList<League>) o_in.readObject();

					for (int i = 0; i < myplayer.size(); i++) {
						Player cool_p = myplayer.get(i);
						System.out.println(cool_p);
					}

					for (int i = 0; i < mymanager.size(); i++) {
						Manager cool_m = mymanager.get(i);
						System.out.println(cool_m);
					}

					for (int i = 0; i < myteams.size(); i++) {
						Team cool_t = myteams.get(i);
						System.out.println(cool_t);
					}

					for (int i = 0; i < myleague.size(); i++) {
						League cool_l = myleague.get(i);
						System.out.println(cool_l);
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				break;

			case 16:
				System.out.println("bye lad");
				break;
				
			default:
				System.out.println("Select numbers from 1-20");
			}

		} while (user_input != 16);
	}

	public static boolean checkcolour(Team teamobj, ArrayList<Team> teams) {
		boolean res = true;
		for (int i = 0; i < teams.size(); i++) {
			if (!teams.get(i).getName().equals(teamobj.getName())) {
				if (teams.get(i).getJersey_colour().equals(teamobj.getJersey_colour())) {
					res = false;
					System.out.println("Jersey colour is not unique");
				}
			}
		}
		return res;
	}

}


