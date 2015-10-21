import java.util.Scanner;


public class main {
	static int left = 0;
	static int right = 0;
	static int back = 0;
	static int forward = 0;

	static int movementnumber = 0;
	static int alertsetoff = 5;
	static boolean alert = false;
	static int levelnumber = 0;
	static boolean alwaysfalse = false;
	static double inputDouble;

	public static void main(String[] args) {
		System.out.println("Enter:\n 2: For moving Forward"
				+ "\n 4: " + "For moving backwards\n "
				+ "6: For Going left\n "
				+ "8: For Going right \n ");
		while(alwaysfalse == false){
		input();
		level();
		}


	}
	public static double checker(double inputDouble) {
		while(inputDouble != 8 && inputDouble != 2 && inputDouble != 4 && inputDouble != 6 && inputDouble != -250253540)
		{
			System.out.println("Error");
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
		levelnumber++;
		movementnumber = 0;
		if (levelnumber == 1){
			System.out.println("While you are traveling you encounter a troll");
			return alert = false;
		}
		else {
			System.out.println("While you are traveling you encounter a math problem");
			return alert = false;
		}
	}

}
