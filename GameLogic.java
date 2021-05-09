package RPSGame;

import java.util.Random;

class PlayRandom implements Move
{
	public String getMove()
	{
		String compMove = "";
		int rand = (int)(Math.random() * 3);
		if(rand == 0)
		{
			compMove = "rock";
		}
		else if(rand == 1)
		{
			compMove = "paper";
		}
		else
		{
			compMove = "scissors";
		}

		return compMove;
	}
}

class PlayStrategy implements Move
{
	public String getMove()
	{
		String compMove = "";
		
		if(GameController.setMove().equals("rock"))
		{
			compMove = "paper";
		}
		else if(GameController.setMove().equals("paper"))
		{
			compMove = "scissors";
		}
		else
		{
			compMove = "rock";
		}
		return compMove;
	}
}

class GamePlayFactory
{
	public static Move getMoveType()
	{
		Random rnd = new Random();
		int select = 1 + rnd.nextInt(2);
		Move move = null;

		switch(select)
		{
		case 1: move = new PlayRandom();
			    break;
		case 2: move = new PlayStrategy();
		}
		
		return move;
		
	}
}
