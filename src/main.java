public class main {
	static int left = 0;
	static int right = 0;
	static int back = 0;
	static int forward = 0;
	static int movementnumber = 0;
	public static void main(String[] args) {
		System.out.println("Enter:\n 8: For moving Forward\n 2: " + "For moving backwards\n "
				+ "4: For Going left\n 6: For Going right \n ");
		int getInt = IO.getConsoleInt("\n\tEnter Number Here ");
		int checkedans = checker(getInt);

		String movementresult = movement(checkedans);

		System.out.println(movementresult);

		while(movementresult != "\nYou moved nowhere!"){
			getInt = -250253540;
			checkedans = checker(getInt);
			checkedans = checker(checkedans);
			movementresult = movement(checkedans);
			System.out.println(movementresult);
		}

	}
	public static int checker(int getInt) {
		while(getInt != 8 && getInt != 2 && getInt != 4 && getInt != 6 && getInt != -250253540)
		{
			System.out.println("Error");
			getInt = 0;
			getInt = IO.getConsoleInt("\n\tEnter Number Here ");
		}
		while(getInt == -250253540){
			getInt = IO.getConsoleInt("\n\tEnter Number Here ");
		}

		return getInt;

	}
	public static String movement(int inputint) {
		if (inputint == 8){
			forward++;
			movementnumber++;
			return "\nYou move Forward";
		}
		else if (inputint == 6){
			right++;
			movementnumber++;
			return "\nYou move to the right";
		}
		else if (inputint == 4){
			left++;
			movementnumber++;
			return "\nYou move to the left";
		}
		else if (inputint == 2){
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
