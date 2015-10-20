public class main {
	static double left = 0;
	static double right = 0;
	static double back = 0;
	static double forward = 0;
	static double movementnumber = 0;
	public static void main(String[] args) {
		System.out.println("Enter:\n 8: For moving Forward\n 2: " + "For moving backwards\n "
				+ "4: For Going left\n 6: For Going right \n ");
		double inputDouble = IO.getConsoleDouble("\n\tEnter Number Here ");
		double checkedans = checker(inputDouble);

		String movementresult = movement(checkedans);

		System.out.println(movementresult);

		while(movementresult != "\nYou moved nowhere!"){
			inputDouble = -250253540;
			checkedans = checker(inputDouble);
			checkedans = checker(checkedans);
			movementresult = movement(checkedans);
			System.out.println(movementresult);
		}

	}
	public static double checker(double inputDouble) {
		while(inputDouble != 8 && inputDouble != 2 && inputDouble != 4 && inputDouble != 6 && inputDouble != -250253540)
		{
			System.out.println("Error");
			inputDouble = 0;
			inputDouble = IO.getConsoleDouble("\n\tEnter Number Here ");
		}
		while(inputDouble == -250253540){
			inputDouble = IO.getConsoleDouble("\n\tEnter Number Here ");
		}

		return inputDouble;

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

}
