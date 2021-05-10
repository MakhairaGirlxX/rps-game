# rps-game
Description: This code is intended to create a simple rock paper scissors game. When the game runs, the player has the choice to either 
select 'c' for the game to run in the console or 'g' for the game to launch a playable GUI. 

For console version: For the console version of the game, the player can select type r, p, or s to select their move. After each turn, 
the computer will either select a random hand or will play a strategy to win. After 4 rounds, the winner and the total score is displayed.

For GUI version: The player will have a rock, paper, and scissors button to click. Whichever they choose that will be their hand for the 
entire game. The game will run to completion with the computer picking a new hand each round. The winner and total score will be displayed
on the GUI when the game is completed. 

Class functionalities:

GameLogic.java--uses a switch case and a random number generator to pick if the computer should use a strategy (case 2) or a random move
(case 1).

IController--all of the interfaces used in the code are hosted here to make for easier readability.

RPSGUI--all GUI components are here using a Builder Pattern Design.

RPSGame--init() allows the player to choose GUI or console. setMove() allows the player to set thier move. This method is interchangable
between console and GUI. runGame() holds the game loop. If player chooses console, gui loop must be commented out (and vice versa).

Note* this game was created with Eclipse in java.

Screenshots:
GUI
https://user-images.githubusercontent.com/83840115/117696373-d7409500-b186-11eb-9b89-c611ba192426.png

Console
https://user-images.githubusercontent.com/83840115/117696392-dc054900-b186-11eb-98bf-26148a8d5038.png


Use Case and Use Case Diagram:
