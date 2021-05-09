package RPSGame;

import java.util.Scanner;

import javax.swing.JFrame;

public class RPSGame {

	public static void main(String[] args) {
		GameController controller = new GameController();
	}

}
class GameView implements IView
{
	Scanner sc = new Scanner(System.in);
	char input;
	private static char[] matches = new char[] {'r', 'p', 's', 'q', 'c', 'g', 't', 'f'};
	
	public void display(String message) {
		System.out.println(message);
		
	}

	@Override
	public Character getInput() {
		boolean isCorrectInput = false;
		do {
            input = sc.next().charAt(0);
            input = Character.toLowerCase(input);
            for(int i = 0; i < matches.length; i++){
            	if (input == matches[i]) {   
            		return new Character(input);
            	}            	
            }
            System.out.print("Please respond with an expected character:  ");            
        } while (!isCorrectInput);    
		return null;
	}
	
}

class GameController implements IController
{
	GameView view = new GameView();
	Move move;
	static Character input;
	static String myResult = "";
	
	static String compMsg = "";
	static String myMsg = "";
	static String msg = "";
	
	static boolean setMove;
	
	public GameController()
	{
		init();
	}
	
	public static String RockBtn()
	{
		myResult = "rock";
		setMove();
		return myResult;
	}
	public static String PaperBtn()
	{
		myResult = "paper";
		setMove();
		return myResult;
	}
	public static String ScissorsBtn()
	{
		myResult = "scissors";
		setMove();
		return myResult;
	}	
	
	public static String setMove()
	{
		String myMove = "";
		boolean isCorrect = false;
		
		do
		{
			input = Character.toLowerCase(input);
		
			if(input == 'r' || myResult == "rock")
			{
				myMove = "rock";
			}
			
			else if(input == 'p' || myResult == "paper")
			{
				myMove = "paper";
			}
			
			else if(input == 's' || myResult == "scissors")
			{
				myMove = "scissors";
			}
			
			else if(input == 'q')
			{
				System.out.println("Game Over");
			}			
							
			else
			{
				System.out.println("Enter valid input");
			}	
	
			return myMove;
		
		}
		while(!isCorrect);	
	
	}

	@Override
	public void runGame() {
		String myMove;
		String compMove;	
		
		int numRounds = 1;
		int score = 0;
		
		//for gui
		/*
		do
		{
			if(myResult == "")
			{
				setMove();
			}
			if(myResult != "")
			{
				do
				{			
					myMove = myResult;
					move = GamePlayFactory.getMoveType();
					compMove = move.getMove();
					view.display("Computer Played: " + compMove);
					
					compMsg = "Computer Played: " + compMove;
					myMsg = "Your Bet: " + myMove;
					
					
					
					if(compMove.equals("rock") && myMove.equals("paper"))
					{
						view.display("You Win! " + numRounds + " round(s) played out of 4");
						msg = "You Win! " + numRounds + " round(s) played out of 4";
						score++;
					}
					else if(compMove.equals("scissors") && myMove.equals("rock"))
					{
						view.display("You Win! " + numRounds + " round(s) played out of 4");
						msg = "You Win! " + numRounds + " round(s) played out of 4";
						score++;
					}
					else if(compMove.equals("paper") && myMove.equals("scissors"))
					{
						view.display("You Win! " + numRounds + " round(s) played out of 4");
						msg = "You Win! " + numRounds + " round(s) played out of 4";
						score++;
					}	
					else if(compMove == myMove)
					{
						view.display("It's a Tie! " + numRounds + " round(s) played out of 4");
						msg = "It's a Tie! " + numRounds + " round(s) played out of 4";
					}
					else
					{
						view.display("You Lost: " + numRounds + " round(s) played out of 4");
						msg = "You Lost: " + numRounds + " round(s) played out of 4";
					}
					numRounds++;
				}
				while(numRounds < 5);
				view.display("Total Score: " + score + " out of 4 games. Play again? (t/f)");
				msg = "Total Score: " + score + " out of 4 games.";
				
				numRounds = 1;
				break;
			}
			
		}while(setMove == false);
		
		//for console
		*/
		do
		{
			do
			{
				view.display("\n" +  "Enter your bet: Rock (r), Paper(p), Scissors (s) or Quit (q)?" );
				input = view.getInput();
				myMove = setMove();				
				//myMove = myResult;
				move = GamePlayFactory.getMoveType();
				compMove = move.getMove();
				view.display("Computer Played: " + compMove);
				
				compMsg = "Computer Played: " + compMove;
				myMsg = "Your Bet: " + myMove;
				
				
				
				if(compMove.equals("rock") && myMove.equals("paper"))
				{
					view.display("You Win! " + numRounds + " round(s) played out of 4");
					msg = "You Win! " + numRounds + " round(s) played out of 4";
					score++;
				}
				else if(compMove.equals("scissors") && myMove.equals("rock"))
				{
					view.display("You Win! " + numRounds + " round(s) played out of 4");
					msg = "You Win! " + numRounds + " round(s) played out of 4";
					score++;
				}
				else if(compMove.equals("paper") && myMove.equals("scissors"))
				{
					view.display("You Win! " + numRounds + " round(s) played out of 4");
					msg = "You Win! " + numRounds + " round(s) played out of 4";
					score++;
				}	
				else if(compMove == myMove)
				{
					view.display("It's a Tie! " + numRounds + " round(s) played out of 4");
					msg = "It's a Tie! " + numRounds + " round(s) played out of 4";
				}
				else
				{
					view.display("You Lost: " + numRounds + " round(s) played out of 4");
					msg = "You Lost: " + numRounds + " round(s) played out of 4";
				}
				numRounds++;
			}
			while(numRounds < 5);
			view.display("Total Score: " + score + " out of 4 games. Play again? (t/f)");
			msg = "Total Score: " + score + " out of 4 games.";
			
			numRounds = 1;
			
		}
		while((char) view.getInput() == 't');
		
		

		//view.display("Game Over! Thanks for Playing!");
	}
	
	@Override
	public void init() {
		view.display("This program lets you play Rock, Paper, Scissors" + "\n" + "Choose to play "
				+ "console or GUI? (c/g)");
		IFrame guiGame = new RPSGUI();
		input = view.getInput();
		boolean isCorrect = false;
		
		do
		{
			input = Character.toLowerCase(input);
			if(input == 'c')
			{
				runGame();
				isCorrect = true;
			}
			
			else if(input == 'g')
			{
				guiGame.buildCanvas();
				guiGame.buildButtonPanel();
				
				JFrame f = guiGame.getFrame();
				f.setVisible(true);
				
				runGame();				
				isCorrect = true;
				
			}
			else
			{
				System.out.println("Enter valid input");
			}
			
			input = view.getInput();
		
		}
		while(!isCorrect);		
	}
	
}
