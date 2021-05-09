package RPSGame;

import javax.swing.JFrame;

public interface IController {
	void runGame();
	void init();
}

interface IView
{
	void display(String message);
	<T> T getInput();
}

interface IFrame
{
	void buildButtonPanel();
	void buildCanvas();
	JFrame getFrame();
}

interface Move
{
	public String getMove();
}
