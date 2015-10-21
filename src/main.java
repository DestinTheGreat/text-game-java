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
		System.out.println(" Sword: For Atacking with a Sword");
		System.out.println("\t Best for attacking Centaurs");

		System.out.println(" Club: For Atacking with a Club");
		System.out.println("\t Best for attacking Goblins");

		System.out.println(" Arrows: For Atacking with Arrows");
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
			System.out.println("While you are traveling you encounter a giant");
			result = fighting(IO.getConsoleString());
			System.out.println(result);
			return alert = false;

		}
		else {
			System.out.println("While you are traveling you encounter a math problem");
			return alert = false;
		}
	}
	public static String fighting(String inputfightingstring){
		String checkedansx = checkerfighting(inputfightingstring);

		String fightingresult = fightingcalculation(checkedansx);

		return fightingresult;
	}
	public static String checkerfighting(String inputfightingstring) {
		
		while(inputfightingstring != "Sword" && inputfightingstring != "Club" && inputfightingstring != "Arrows")
		{
			System.out.println("Put A Listed Weapon");
			inputfightingstring = IO.getConsoleString("\n\tEnter Your Weapon");
		}
		return inputfightingstring;

	}
	public static String fightingcalculation(String checkedansx) {
		if (levelboss == "Centaur"){
			if(checkedansx == "Sword")
				return "You Win!";
			else if(checkedansx == "Arrows")
				return "You lost, You died by the Munster";
			else if(checkedansx == "Club")
				return "You died by the Centaur's Shortsword.";
		}
		else if (levelboss == "Goblins"){
			if(checkedansx == "Sword")
				return "You got cut down by a jagged Goblin Dagger";
			else if(checkedansx == "Arrows")
				return "You lost, the Goblin evaded the arrows to come up and kill you with a Goblin Dagger";
			else if(checkedansx == "Club")
				return "You Win!";
		}
		else if (levelboss == "Giants"){
			if(checkedansx == "Sword")
				return "You lost, died by the Giant's club!";
			else if(checkedansx == "Arrows")
				return "You Win";
			else if(checkedansx == "Club")
				return "You lost, died by the Giant's club!";
		}
		return checkedansx;

	}
}