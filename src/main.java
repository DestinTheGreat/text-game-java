import java.util.Random;

public class main {
	static int left = 0;
	static int right = 0;
	static int back = 0;
	static int forward = 0;

	static int movementnumber = 0;
	static int alertsetoff = 3;
	static boolean alert = false;

	static String levelboss = "Giant";
	static int lvlboss = 5;
	static int bosshealth = lvlboss * 10;
	static int characterhealth = 100;
	static int levelnumber = 0;
	static int lvlweapon = 5;
	static int weapondmg = lvlweapon * 10;

	static int healthpotion = 1;
	static int attackpotion = 1;
	static int magicrunes = 1;


	static Random randomgenerator = new Random(); 

	static boolean togostatus = false;
	static double inputDouble;

	public static void main(String[] args) {
		// Instructions Start
		System.out.println("Instructions to Move:");
		System.out.println(" 2: For moving Backwards");
		System.out.println(" 4: For moving Left");
		System.out.println(" 6: For moving Right");
		System.out.println(" 8: For moving Forward");

		System.out.println("\n");		

		System.out.println("Instructions to Fight:");
		System.out.println(" Sword: For Attacking with a Sword");
		System.out.println("\t Best for attacking Centaurs");

		System.out.println(" Club: For Attacking with a Club");
		System.out.println("\t Best for attacking Goblins");

		System.out.println(" Arrows: For Attacking with Arrows");
		System.out.println("\t Best for attacking Giants");


		// Instructions End

		// Inventory
		System.out.println("\n");		
		System.out.println("Starting Inventory");
		System.out.println(" Health Potions : " + healthpotion);		
		System.out.println(" Attack Potions : " + attackpotion);		
		System.out.println(" Magical Runes : " + magicrunes);		

		while(togostatus == false){
			input();
			level();
		}


	}
	public static double checker(double inputDouble) {
		while(inputDouble != 8 && inputDouble != 2 && inputDouble != 4 && inputDouble != 6)
		{
			System.out.println("Put in a Valid Number!");
			inputDouble = IO.getConsoleDouble("\n\tEnter Number Here ");
		}
		return inputDouble;

	}
	public static String randomdrop(){
		int randomdropitem = randomgenerator.nextInt(8)+1;
		if (randomdropitem == 1){
			lvlweapon++;
			System.out.println("\nYou found a manual page, Weapon Level is now : " + lvlweapon);
			return null;
		}
		else if (randomdropitem == 2){
			lvlweapon++;
			System.out.println("\nYou found a manual page, Weapon Level is now : " + lvlweapon);
			return null;
		}
		return null;
	}
	public static boolean input(){
		inputDouble = IO.getConsoleDouble("\n\tEnter Number Here ");
		double checkedans = checker(inputDouble);

		String movementresult = movement(checkedans);

		System.out.println(movementresult);

		randomdrop();

		while (movementnumber != alertsetoff) {
			inputDouble = IO.getConsoleDouble("\n\tEnter Number Here ");
			checkedans = checker(inputDouble);
			movementresult = movement(checkedans);
			System.out.println(movementresult);
		}
		alert = true;
		return alert = true;
	}
	public static String movement(double checkedans) {
		if (checkedans == 8){
			forward++;
			movementnumber++;
			return "\nYou move Forward";
		}
		else if (checkedans == 6){
			right++;
			movementnumber++;
			return "\nYou move to the right";
		}
		else if (checkedans == 4){
			left++;
			movementnumber++;
			return "\nYou move to the left";
		}
		else if (checkedans == 2){
			back++;
			movementnumber++;
			return "\nYou move backwards";
		}
		else{
			movementnumber++;
			return "\nYou moved nowhere!";
		}
	}
	public static boolean level() {	
		String result;
		levelnumber++;
		movementnumber = 0;
		if (levelnumber == 1){
			levelboss = "Giant";
			System.out.println("\nWhile you are traveling you encounter a " + levelboss + "!");
			System.out.println("\nBoss : " + lvlboss + " " + "Your Level Weapon : " + lvlweapon);
			result = fighting();
			alertsetoff = randomgenerator.nextInt(4)+1;
			System.out.println(result);
			return alert = false;

		}
		else if (levelnumber == 2){
			levelboss = "Centaur";
			lvlboss+=2;
			System.out.println("\nWhile you are traveling you encounter a " + levelboss + "!");
			System.out.println("\nBoss : " + lvlboss + " " + "Your Level Weapon : " + lvlweapon);
			result = fighting();
			System.out.println(result);
			alertsetoff = randomgenerator.nextInt(4)+1;
			return alert = false;

		}
		else if (levelnumber == 3){
			levelboss = "Goblins";
			lvlboss+=2;
			System.out.println("\nWhile you are traveling you encounter a " + levelboss + "!");
			System.out.println("\nBoss : " + lvlboss + " " + "Your Level Weapon : " + lvlweapon);
			result = fighting();
			System.out.println(result);
			alertsetoff = randomgenerator.nextInt(4)+1;
			return alert = false;
		}
		else {
			System.out.println("\nWhile you are traveling you encounter a math problem");
			return alert = false;
		}
	}
	public static String fighting(){
		String inputfightingstring = IO.getConsoleString("\n\tEnter Your Weapon");
		String checkedansfighting = checkerfighting(inputfightingstring);

		String fightingresult = fightingcalculation(checkedansfighting);

		return fightingresult;
	}
	public static String checkerfighting(String inputfightingstring) {

		while(!inputfightingstring.equals("Sword") && !inputfightingstring.equals("Club") && !inputfightingstring.equals("Arrows"))
		{
			System.out.println("Put A Listed Weapon");
			inputfightingstring = IO.getConsoleString("\n\tEnter Your Weapon");
		}
		return inputfightingstring;

	}
	public static String fightingcalculation(String checkedansx) {
		weapondmg = lvlweapon * 10;
		
		int fightingchance = 0;
		
		fightingchance = randomgenerator.nextInt(lvlboss)+lvlweapon;

		if (levelboss.equals("Centaur")){
			if(checkedansx.equals("Sword") && lvlboss <= lvlweapon){
				while (bosshealth > 0){
					System.out.println("\nBoss Health : " + bosshealth);
					System.out.println("\nYou inflicted : " + weapondmg + " damage");

					bosshealth = bosshealth - weapondmg;
				}
				lvlweapon++;
				return "\nYou Won!";
			}
			if(checkedansx.equals("Sword") && lvlboss > lvlweapon){
				if (fightingchance == 1){
					while (bosshealth > 0){
						System.out.println("\nBoss Health : " + bosshealth);
						System.out.println("\nYou inflicted : " + weapondmg + " damage");
						
						bosshealth = bosshealth - weapondmg;
					}
					lvlweapon++;
					return "\nYou Win! Barely Won!";
				}
				else
					togostatus = true;
				return "\nYou Lose! Weapon too weak!";
			}
			else if(checkedansx.equals("Arrows")){
				togostatus = true;
				return "\nYou lost, You died by the Munster!";
			}
			else if(checkedansx.equals("Club")){
				togostatus = true;
				return "\nYou died by the Centaur's Shortsword.";
			}
		}
		else if (levelboss.equals("Goblins")){
			if(checkedansx.equals("Sword")){
				togostatus = true;
				return "\nYou got cut down by a jagged Goblin Dagger";
			}
			else if(checkedansx.equals("Arrows")){
				togostatus = true;
				return "\nYou lost, the Goblin evaded the arrows to come up and kill you with a Goblin Dagger";
			}
			else if(checkedansx.equals("Club") && lvlboss <= lvlweapon){
				while (bosshealth > 0){
					System.out.println("\nBoss Health : " + bosshealth);
					System.out.println("\nYou inflicted : " + weapondmg + " damage");
					
					bosshealth = bosshealth - weapondmg;

				}
				lvlweapon++;
				return "\nYou Win!";
			}
			else if(checkedansx.equals("Club") && lvlboss > lvlweapon){
				if (fightingchance == 1){
					while (bosshealth > 0){
						System.out.println("\nBoss Health : " + bosshealth);
						System.out.println("\nYou inflicted : " + weapondmg + " damage");

						bosshealth = bosshealth - weapondmg;

					}
					lvlweapon++;
					return "\nYou Win!";
				}
				else {
					togostatus = true;
					return "\nYou Lose! Weapon too weak!";	
				}
			}
		}
		else if (levelboss.equals("Giant")){
			if(checkedansx.equals("Sword")){
				togostatus = true;
				return "\nYou lost, died by the Giant's Smash!";
			}
			else if(checkedansx.equals("Arrows") && lvlboss <= lvlweapon){
				while (bosshealth > 0){
					System.out.println("\nBoss Health : " + bosshealth);
					System.out.println("\nYou inflicted : " + weapondmg + " damage");
					
					bosshealth = bosshealth - weapondmg;
				}
				lvlweapon++;
				return "\nYou Win";
			}
			else if(checkedansx.equals("Arrows") && lvlboss > lvlweapon){
				if (fightingchance == 1){
					while (bosshealth > 0){
						System.out.println("\nBoss Health : " + bosshealth);
						System.out.println("\nYou inflicted : " + weapondmg);
						bosshealth = bosshealth - weapondmg;

					}
					lvlweapon++;
					return "\n You won!";
				}
				else{
					togostatus = true;
					return "\nYou Lose! Weapon too weak!";	
				}
			}
			else if(checkedansx.equals("Club")){
				togostatus = true;
				return "\nYou lost, died by the Giant's Club!";
			}
		}
		return "ERROR FIGHTINGCALCULATION";

	}
}