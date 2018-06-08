/*******************
CallCenter class
******************/

import java.util.LinkedList;
import java.util.Stack;
import cs1.Keyboard;

public class CallCenter {

    //instance vars
    public static LinkedList<Crime> crimes;
    private ALHeapMin inventory;
    private LinkedList<Busters> busters;
    private int startTime; //starts at time = 0
    private int timeLeft; //minutes left in level
    private int totalTime; //minutes allowed in level
    private int difficulty; //level 1, 2, or 3

    public CallCenter(int dif) {
	difficulty = dif;
	crimes = new LinkedList<Crime>();
	inventory = new ALHeapMin();
	busters = new LinkedList<Busters>();

	inventory.add(new Pencil());
	inventory.add(new Gloves());
	inventory.add(new Taser());
	inventory.add(new Handcuffs());
	inventory.add(new Bike());
	inventory.add(new WalkieTalkie());
	inventory.add(new Gun());
	inventory.add(new FirstAidKit());
	inventory.add(new Cruiser());

	busters.add(new FireDept());
	busters.add(new Paramedics());
	busters.add(new FBI());
	busters.add(new IRS());
	busters.add(new TowingCompany());
	busters.add(new Coroner());

	if (difficulty == 1) totalTime = timeLeft = 1440;
	else if (difficulty == 2) totalTime = timeLeft = 1080;
	else if (difficulty == 3) totalTime = timeLeft = 720;

    }

    public int getDifficulty() {
	return difficulty;
    }

    public void increaseTime() { //possible reward for making right choice in interaction
	timeLeft += 30;
    }

    public void decreaseTime() { //possible punishment for making wrong choice
	timeLeft -= 30;
    }

    public void chooseBusters(Crime input) {
	String prompter = "";
	int choice;

	prompter = "\nWould you like to request assistance for this mission?\n" + "Mission = " + input.toString() + "\n";
	prompter += "\n1: Yes, please! \n2: Nah";
	System.out.println(prompter);

	choice = Keyboard.readInt();
	if (choice != 1 && choice != 2) {
	    System.out.println("\nUh...I'm gonna need an answer, dude.");
	    chooseBusters(input);
	}

	while (choice == 1) {
	    timeLeft -= 5;
	    prompter = "Please select who you gonna call:";
	    for (int ctr = 0; ctr < busters.size(); ctr ++) {
		prompter += "\n\t" + (ctr+1) + ": " + busters.get(ctr).toString();
	    }
	    prompter += "\n";
	    System.out.println(prompter);

	    choice = Keyboard.readInt();

	    if (! busters.get(choice-1).getIsChosen()) {
		prompter = "\nYou have called: " + busters.get(choice-1).toString() + ". They're on their way.";
		System.out.println(prompter);
		busters.get(choice-1).changeIsChosen();
	    }
	    else {
		prompter = "\nYou already called them. Don't waste time. Try again.";
		System.out.println(prompter);
	    }
	    
	    prompter = "\nAnyone else?";
	    prompter += "\n(Keep in mind that choosing more busters costs time.)";
	    prompter += "\n1: Yes, please! \n2: Nah";
	    System.out.println(prompter);

	    choice = Keyboard.readInt();
	}

    }

    public void chooseEquipment(Crime input) {
	String prompter = "";
	int choice;
	Equipment ans;

	prompter = "\n\nWould you like to grab equipment for this mission?\n" + "Mission = " + input.toString() + "\n";
	prompter += "\n1: Yes, please! \n2: Nah";
	System.out.println(prompter);

	choice = Keyboard.readInt();
	if (choice != 1 && choice != 2) {
	    System.out.println("\nUh...I'm gonna need an answer, dude.");
	    chooseBusters(input);
	}
	if (choice == 1){
	    ans = minigame(inventory);
	    if (ans == null) return;

	    if (ans.doTheyMatch(input)) {
		if (ans.getValue()*5 > input.getTimer()) {
		    input.changeTimer(input.getTimer());
		    return;
		}
		input.changeTimer(ans.getValue()*5);
	    }
	    else System.out.println("\nIt looks like the equipment you chose wasn't helpful for the mission. Be more mindful of that.");
	}
    }

    

    public Equipment minigame(ALHeapMin equipment) {
	System.out.print("\033[H\033[2J");
	System.out.println("To play the game, choose option 1 if you want more helpful equipment but if you're satisfied, choose option 2\n Keep in mind the time it takes to get another piece of equipment. For each equipment you choose or pass, 5 minutes shall be deducted from your day.");
	System.out.println("Do you understand the instructions? \n1. Yes! Let's play!!");
	int choice = Keyboard.readInt();
	if(choice == 1){
	    System.out.print("\033[H\033[2J");
	    System.out.println("~~CHOOSE YOUR WEAPON~~");
	    System.out.println("Start Game:");

	    Stack<Equipment> storage= new Stack<Equipment>();
	    while( choice == 1){
		timeLeft -= 5; //deduct 5 minutes from gameplay
		Equipment object = equipment.peekMin();
		if (object == null) {
		    System.out.println("Looks like you've gone through everything, Jake...Ah, well. No equipment for you, then!");
		    while (! storage.empty()) equipment.add(storage.pop());
		    return null;
		}
		
		System.out.println("Item on trial:" + object);
		System.out.println("Do you plan on keeping this?");
		System.out.println("1. No, give me something else \n2. Yes, of course, who wouldn't want this?");
		choice = Keyboard.readInt();
		if(choice == 1){
		    storage.push(equipment.removeMin());
		}
		else{
		    System.out.println("\nYou have chosen: " + object);

		    while (! storage.empty()) equipment.add(storage.pop());
		    
		    System.out.println("\nMinigame over!");
		    return object;
		}
	    }
	}
	
	else {
	    System.out.println("Follow the instructions. >:(");
	    minigame(inventory);
	}
	return null;
    }

    public void solveCrime(Crime crime) {
	timeLeft -= crime.getTimer();
	for (Busters b : busters) {
	    if (b.getIsChosen()) b.changeIsChosen();
	}
    }

    public void startMission() {
	chooseBusters(crimes.getFirst());
	chooseEquipment(crimes.getFirst());
    }

    public Crime crimeMaker(int type, boolean isEm) {
	int extrem;
	if (type == 0) {
	    extrem = (int)(Math.random()*5) + 1;
	    return new Arson(extrem, isEm);
	}
	else if (type == 1) {
	    extrem = (int)(Math.random()*2) + 4;
	    return new Murder(extrem, isEm);
	}
	else if (type == 2) {
	    extrem = (int)(Math.random()*5) + 1;
	    return new Drugs(extrem, isEm);
	}
	else if (type == 3) {
	    extrem = (int)(Math.random()*2) + 1;
	    return new Vandalism(extrem, isEm);
	}
	else if (type == 4) {
	    extrem = 2;
	    return new TaxFraud(extrem, isEm);
	}
	else if (type == 5) {
	    extrem = (int)(Math.random()*3) + 1;
	    return new Robbery(extrem, isEm);
	}
	else if (type == 6) {
	    extrem = (int)(Math.random()*3) + 3;
	    return new Kidnapping(extrem, isEm);
	}
	else if (type == 7) {
	    extrem = (int)(Math.random()*3) + 3;
	    return new SexualAssault(extrem, isEm);
	}
	extrem = (int)(Math.random()*5) + 1;
	return new Traffic(extrem, isEm);
    }

    public void startLv(CallCenter currentLv, Jake player) { //i'll try to find a way to not need to use the first param

	if (difficulty == 1) {
	    Crime newCrime = crimeMaker((int)(Math.random()*9), false);
	    //System.out.println("\nCrime left over from before your shift:" + newCrime.toString());
	    //System.out.println("Its priority is: " + newCrime.getPriority());
	    crimes.add(newCrime);
	}

	player.interact(currentLv, 1 + (3 * (difficulty-1)));
	int halfDay = totalTime / 2;

	System.out.println("START OF DAY " + difficulty);
	System.out.println("\nCrime(s) left over from last night: " + crimes);
	System.out.println("(You MUST do these crimes first. You are NOT allowed to put them off for later. Chief Flo will be mad if you do.)");
	System.out.println("\nReady to rank?\n");

	player.proceed();

	//ranking phase
	for (int ctr = 0; ctr < 10; ctr ++) {
	    int random = (int)(Math.random()*9);
	    player.rank(difficulty, crimes, crimeMaker(random, false));
	    player.proceed();
	}

	//playing phase

	System.out.println("You've finished ranking. Let's see how well you've strategized. Shall we?");
	System.out.println("\nThe length of your shift today is: " + timeLeft + " minutes.");
	System.out.println("(If you finish all your crimes before then, your score is boosted by the amount of minutes you have to spare.)");
	System.out.println("(If you work overtime, meaning your 'Time Left' counter is negative by the end of the day, your score will be decremented by the amount of minutes you worked overtime.)");
	System.out.println("(Understand? Then, hurry up and start the day.)");
	player.proceed();

	while (crimes.size() > (10+difficulty)/2) { //first half of day
	    if (crimes.size() == 0) {
		System.out.println("\n(Wow, that was fast. Either you're really skilled, or you skipped a lot of dialogue. Chief Flo doesn't like that.)");
		break;
	    }
	    
	    int rand = (int) (Math.random() * 10);
	    if (rand == 3) {
		System.out.println("\nEmergency! A crime has come in that you must deal with immediately! It is worth double the points of a regular crime.");
		Crime bigCrime = crimeMaker((int)(Math.random()*9), true);
	        player.rank(difficulty, crimes, bigCrime);
		player.proceed();
	    }
	    
	    startMission();
	    player.increaseScore(busters, crimes.getFirst());
	    solveCrime(crimes.getFirst());
	    crimes.removeFirst();
	    System.out.println("Time Left : " + timeLeft + " minutes");
	    System.out.println("Current Score: " + player.score);
	    player.proceed();
	}

	System.out.println("\nLunch break!\n");
	player.proceed();
	player.interact(currentLv, 2 + (3 * (difficulty-1))); //midday interaction
	System.out.println("Back to work!\n");
	player.proceed();

	while (crimes.size() > 0) { //second half of day
	    if (crimes.size() == 0) {
	        break;
	    }

	    int rand = (int) (Math.random() * 10);
	    if (rand == 3 || crimes.size() == 0) { //new call comes in
		System.out.println("\nEmergency! A crime has come in that you must deal with immediately! It is worth double the points of a regular crime.");
		Crime bigCrime = crimeMaker((int)(Math.random()*9), true);
	        player.rank(difficulty, crimes, bigCrime);
		player.proceed();
	    }
	    
	    startMission();
	    player.increaseScore(busters, crimes.getFirst());
	    solveCrime(crimes.getFirst());
	    crimes.removeFirst();
	    System.out.println("Time Left : " + timeLeft + " minutes");
	    System.out.println("Current Score: " + player.score);
	    player.proceed();

	}

	System.out.println("\nIt looks like your shift is over.\n");
	player.proceed();

	if (difficulty+1 == 2) {
	    Crime newCrime = crimeMaker((int)(Math.random()*9), false);
	    crimes.add(newCrime);
	    newCrime = crimeMaker((int)(Math.random()*9), false);
	    crimes.add(newCrime);
	}
	else if (difficulty+1 == 3) {
	    Crime newCrime = crimeMaker((int)(Math.random()*9), false);
	    crimes.add(newCrime);
	    newCrime = crimeMaker((int)(Math.random()*9), false);
	    crimes.add(newCrime);
	    newCrime = crimeMaker((int)(Math.random()*9), false);
	    crimes.add(newCrime);
	}
	
	player.interact(currentLv, 3 + (3 * (difficulty-1))); //end of day interaction
	player.timeScoreEffect(timeLeft);

    }
	
}
