/**********************
 Jake class - represents player
 *********************/

import java.util.Stack;
import cs1.Keyboard;
import java.util.Scanner;

public class Jake {

    public static int score;
    private Stack<String> interactions;
    private String[][] aftermath = new String[2][9];
    private int[][] answerBank = new int[2][9];

    //constructor
    public Jake() {
	score = 0;
	interactions = new Stack<String>();

	//interactions (TBD)

	//answer key (TBD)
    }

    public void rank(int difficulty, Crime newCrime) {
	String prompter = "";
	int choice;

	prompter = "Here is your current ranking of your crimes: \n";
	//prompter += CallCenter.crimes.toString();
	prompter += "\nHow would you like to rank this crime?";
	prompter += "\n(To rank something as first, enter 1. To rank something as second, enter 2. And so on...)";
	System.out.println(prompter);

	choice = Keyboard.readInt();
	if (choice < 1 || (difficulty == 1 && choice > 11)
	|| (difficulty == 2 && choice > 12)
	|| (difficulty == 3 && choice > 13)) {
	    prompter = "This is no time to be messing around, Jake. Don't make me call the chief.";
	    rank(difficulty, newCrime);
	}
	
	newCrime.setPriority(choice);
	CallCenter.crimes.enqueue(newCrime);

    }

    public void interact() {
	String prompter = "";              
	int choice;

	prompter = interactions.pop();
	System.out.println(prompter);

	choice = Keyboard.readInt();
	//more stuff to come once stuff is written...
    }
    
    public static void main(String[] args) {
    }
}
