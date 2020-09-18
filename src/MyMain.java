import java.util.ArrayList;

public class MyMain {
	public static void main(String[] args) {
		Name n1 = new Name("Albus", "Rupus", "Dumbledore");
		Player p1 = new Player(0, false, n1, "0857600179", "Albus.dumbledore@mycit.ie");
		
		Name n2 = new Name("David", "", "Tennant");
		Player p2 = new Player(3, true, n2, "0757547689", "David.Tennant@mycit.ie");
		
		Name n3 = new Name("Brad", "", "Mang");
		Manager m1 = new Manager("1999-12-20", 8 , n3, "0987876568", "Brand.mang@mycit.ie");

		System.out.println(p1.player_details());
		System.out.println(p2.player_details());
		
		System.out.println();
		System.out.println(p1.checkgoalie());
		System.out.println(p2.checkgoalie());
		
		System.out.println();
		Team t1 = new Team("Blue nightingale", "Blue");
		t1.addPlayer(p1);
		t1.addPlayer(p2);
		t1.setManager(m1);
		System.out.println(t1);
		
		System.out.println();
		League l1 = new League("Gallifrey League");
		l1.addteam(t1);
		System.out.println(l1);
		
		//making sure 1 player cant be added to two teams
		Team t2 = new Team("Weeping angels", "Grey");
		t2.addPlayer(p1);
		
		
		
	}
}
