import java.util.Random;

public class main {
	static int left = 0;
	static int right = 0;
	static int back = 0;
	static int forward = 0;

	static int movementnumber = 0;
	static int alertsetoff = 2;
	static boolean alert = false;

	static String levelboss = "Giant";
	static int levelnumber = 0;
	static int lvlweapon = 1;
	static int lvlboss = 1;

	static Random randomgenerator = new Random(); 

	static boolean alwaysfalse = false;
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
		while(alwaysfalse == false){
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
	public static boolean input(){
		inputDouble = IO.getConsoleDouble("\n\tEnter Number Here ");
		double checkedans = checker(inputDouble);

		String movementresult = movement(checkedans);

		System.out.println(movementresult);

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
			System.out.println("\n While you are traveling you encounter a " + levelboss + "!");
			System.out.println("Boss : " + lvlboss + " " + "Your Level Weapon : " + lvlweapon);
			result = fighting();
			alertsetoff = randomgenerator.nextInt(7)+3;
			System.out.println(result);
			return alert = false;

		}
		else if (levelnumber == 2){
			levelboss = "Centaur";
			System.out.println("\n While you are traveling you encounter a " + levelboss + "!");
			System.out.println("Boss : " + lvlboss + " " + "Your Level Weapon : " + lvlweapon);
			result = fighting();
			System.out.println(result);
			alertsetoff = randomgenerator.nextInt(4)+1;
			return alert = false;

		}
		else if (levelnumber == 3){
			levelboss = "Goblins";
			lvlboss++;
			System.out.println("\n While you are traveling you encounter a " + levelboss + "!");
			System.out.println("Boss : " + lvlboss + " " + "Your Level Weapon : " + lvlweapon);
			result = fighting();
			System.out.println(result);
			alertsetoff = randomgenerator.nextInt(4)+1;
			return alert = false;
		}
		else {
			System.out.println("\n While you are traveling you encounter a math problem");
			return alert = false;
		}
	}
	public static String fighting(){
		String inputfightingstring = IO.getConsoleString("\n\tEnter Your Weapon");
		String checkedansx = checkerfighting(inputfightingstring);

		String fightingresult = fightingcalculation(checkedansx);

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
		int fightingchance = 0;
		fightingchance = randomgenerator.nextInt(lvlboss)+lvlweapon;

		if (levelboss.equals("Centaur")){
			if(checkedansx.equals("Sword") && lvlboss <= lvlweapon){
				lvlweapon++;
				return "You Win!";
			}
			if(checkedansx.equals("Sword") && lvlboss > lvlweapon){
				if (fightingchance == 1){
					return "You Win! Barely Won!";
				}
				else
					return "You Lose! Weapon too weak!";
			}
			else if(checkedansx.equals("Arrows"))
				return "You lost, You died by the Munster!";
			else if(checkedansx.equals("Club"))
				return "You died by the Centaur's Shortsword.";
		}
		else if (levelboss.equals("Goblins")){
			if(checkedansx.equals("Sword")){
				return "You got cut down by a jagged Goblin Dagger";
			}
			else if(checkedansx.equals("Arrows"))
				return "You lost, the Goblin evaded the arrows to come up and kill you with a Goblin Dagger";
			else if(checkedansx.equals("Club") && lvlboss <= lvlweapon){
				lvlweapon++;
				return "You Win!";
			}
			else if(checkedansx.equals("Club") && lvlboss > lvlweapon){
				if (fightingchance == 1){
					return "You Win! Barely Won!";
				}
				else
					return "You Lose! Weapon too weak!";			}
		}
		else if (levelboss.equals("Giant")){
			if(checkedansx.equals("Sword")){
				return "You lost, died by the Giant's Smash!";
			}
			else if(checkedansx.equals("Arrows") && lvlboss <= lvlweapon){
				lvlweapon++;
				return "You Win";
			}
			else if(checkedansx.equals("Arrows") && lvlboss > lvlweapon){
				if (fightingchance == 1){
					return "You Win! Barely Won!";
				}
				else
					return "You Lose! Weapon too weak!";			}
			else if(checkedansx.equals("Club"))
				return "You lost, died by the Giant's Club!";
		}
		return "ERROR FIGHTINGCALCULATION";

	}
}