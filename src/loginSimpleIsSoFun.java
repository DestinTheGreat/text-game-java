
public class loginSimpleIsSoFun {

	public static void main(String[] args) {
		String username = IO.getConsoleString("Enter Username");
		String password = IO.getConsoleString("Enter PassWord");
		String userNameCorrect = username;
		String passWordCorrect = password;
		
		while (!userNameCorrect.equals(username)){
			System.out.println("Correct");
		}
	}

}
