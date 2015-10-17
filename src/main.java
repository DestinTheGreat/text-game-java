
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int getInt = IO.getConsoleInt("Enter:\n 8. For moving Forward\n 2. " + "For moving backwards\n "
				+ "4. For Going left\n 6. For Going right " + "\n\t Enter Number Here ");
		String movementMethod = movement(getInt);
		output(getInt, movementMethod);
	}

	public static String movement(double g) {
		if (g == 8)
			return "You move Forward";

		else if (g == 6)
			return "You move to the right";

		else if (g == 4)
			return "You move to the left";

		else if (g == 2)
			return "You move backwards";

		else
			return "Please Enter the Valid Number!";

	}

	public static void output(double g, String m) {
		System.out.print(m);
	}

}
