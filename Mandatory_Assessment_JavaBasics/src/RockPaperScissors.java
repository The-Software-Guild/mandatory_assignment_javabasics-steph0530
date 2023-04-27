import java.util.*;

public class RockPaperScissors {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How many rounds would you like to play?"); // could have checked type here
		String str = in.nextLine();
		int noRounds = Integer.parseInt(str);

		if(noRounds<1 || noRounds>10) {
			System.out.println("Out of range. bye!");
			return;
		}

		int userWins =0;
		int computerWins =0;
		int ties =0;
		
		for(int i=0;i<noRounds;i++) {
			System.out.println("Choose Rock(1), Paper(2), Scissors(3): ");
			String choice = in.nextLine();
			int userChoice;
			
			// don't like try-catch + if statement combo
			try {
				userChoice = Integer.parseInt(choice);
			}catch(Exception e) {
				System.out.println("Please type in integer");
				i--;
				continue;
			}
			
			if(userChoice!=1 && userChoice!=2 && userChoice!=3) {
				System.out.println("Please type 1, 2 or 3");
				i--;
				continue;
			}
			
			Random rnd = new Random();
			int computerChoice = 1+rnd.nextInt(3);
			if((userChoice==2&&computerChoice==1) || (userChoice==3&&computerChoice==2) || (userChoice==1&&computerChoice==3)) userWins++;
			else if(userChoice==computerChoice) ties++;
			else computerWins++;
		}
		
		System.out.println("Game stats:");
		System.out.println("user won: "+userWins+" computer won: "+computerWins+" ties: "+ties);
		if(userWins == computerWins) System.out.println("It's a draw!");
		else {
			String winner = userWins>computerWins?"You":"Computer";
			System.out.println("Final winner is: "+winner);
		}
		System.out.println("Do you want to play again? Type 'Yes' or 'No'");
		str = in.nextLine();
		
		while(!str.trim().toLowerCase().equals("yes") && !str.trim().toLowerCase().equals("no")) {
			System.out.println("Do you want to play again? Type 'Yes' or 'No'");
			str = in.nextLine();
		}
		if(str.toLowerCase().equals("yes")) main(args);
		else System.out.println("Thanks for playing!");
		
	}
}
