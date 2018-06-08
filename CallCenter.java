/*******************
CallCenter class
******************/

import java.util.LinkedList;
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

    private boolean crimeSolved;

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
	    prompter = "Please select who you gonna call:";
	    for (int ctr = 0; ctr < busters.size(); ctr ++) {
		prompter += "\n\t" + (ctr+1) + ": " + busters.get(ctr).toString();
	    }
	    prompter += "\n";
	    System.out.println(prompter);

	    choice = Keyboard.readInt();
	    busters.get(choice-1).changeIsChosen();

	    prompter = "\nYou have called: " + busters.get(choice-1).toString() + ". They're on their way.";
	    prompter += "\nAnyone else?";
	    prompter += "\n(Keep in mind that choosing more busters costs time.)";
	    prompter += "\n1: Yes, please! \n2: Nah";
	    System.out.println(prompter);

	    choice = Keyboard.readInt();
	}

    }

    public void chooseEquipment(Crime input) {
	String prompter = "";
	int choice;

	prompter = "\n\nWould you like to grab equipment for this mission?\n" + "Mission = " + input.toString() + "\n";
	prompter += "\n1: Yes, please! \n2: Nah";
	System.out.println(prompter);

	choice = Keyboard.readInt();
	if (choice != 1 && choice != 2) {
	    System.out.println("\nUh...I'm gonna need an answer, dude.");
	    chooseBusters(input);
	}
	if (choice == 1){
	    minigame(inventory);
	}
	else return;
    }

    public void minigame(ALHeapMin equipment) {
	System.out.print("\033[H\033[2J");
	System.out.println("To play the game, choose option 1 if you want more helpful equipment but if you're satisfied, choose option 2\n Keep in mind the time it takes to get another piece of equipment. For each equipment you choose or pass, 5 minutes shall be deducted from your day.");
	System.out.println("Do you understand the instructions? \n1. Yes! Let's play!!");
	int choice = Keyboard.readInt();
	if(choice == 1){
	    System.out.print("\033[H\033[2J");
	    System.out.println("~~CHOOSE YOUR WEAPON~~");
	    System.out.println("Start Game:");
	    while( choice != 2){
		if(equipment.isEmpty()){
		    System.out.println("Looks like we ran out of materials, guess you have to continue the game emptyhanded");
		    return;
		}
		Equipment object = equipment.peekMin();
		System.out.println("Item on trial:" + object);
		System.out.println("Do you plan on keeping this?");
		System.out.println("1. No, give me something else \n2. Yes, of course, who wouldn't want this?");
		timeLeft -= 5; //deduct 5 minutes from gameplay
		choice = Keyboard.readInt();
		if(choice == 1){
		    equipment.removeMin();
		}
		else{
		    System.out.println("Back to the original game");
		    return;
		}
	    }
	}
	else {
	    System.out.println("Follow the instructions. >:(");
	    minigame(inventory);
	}
    }

    public boolean firstCrime() {
	return crimes.getFirst() != null;
    }

    public void solveCrime(Crime crime) {
	timeLeft -= crime.getTimer();
	crimeSolved = true;
    }

    public void startMission() {
	chooseBusters(crimes.getFirst());
	chooseEquipment(crimes.getFirst());
    }

    public Crime crimeMaker(int type) {
	int extrem;
	if (type == 0) {
	    extrem = (int)(Math.random()*5) + 1;
	    return new Arson(extrem);
	}
	else if (type == 1) {
	    extrem = (int)(Math.random()*2) + 4;
	    return new Murder(extrem);
	}
	else if (type == 2) {
	    extrem = (int)(Math.random()*5) + 1;
	    return new Drugs(extrem);
	}
	else if (type == 3) {
	    extrem = (int)(Math.random()*2) + 1;
	    return new Vandalism(extrem);
	}
	else if (type == 4) {
	    extrem = 2;
	    return new TaxFraud(extrem);
	}
	else if (type == 5) {
	    extrem = (int)(Math.random()*3) + 1;
	    return new Robbery(extrem);
	}
	else if (type == 6) {
	    extrem = (int)(Math.random()*3) + 3;
	    return new Kidnapping(extrem);
	}
	else if (type == 7) {
	    extrem = (int)(Math.random()*3) + 3;
	    return new SexualAssault(extrem);
	}
	extrem = (int)(Math.random()*5) + 1;
	return new Traffic(extrem);
    }

    public void startLv(CallCenter currentLv, Jake player) { //i'll try to find a way to not need to use the first param

	Crime bigCrime = null;

	if (difficulty >= 1) {
	    Crime newCrime = crimeMaker((int)(Math.random()*9));
	    //System.out.println("\nCrime left over from before your shift:" + newCrime.toString());
	    //System.out.println("Its priority is: " + newCrime.getPriority());
	    crimes.add(newCrime);
	}

	if (difficulty >= 2) {
	    Crime newCrime = crimeMaker((int)(Math.random()*9));
	    crimes.add(newCrime);
	}
	if (difficulty == 3) {
	    Crime newCrime = crimeMaker((int)(Math.random()*9));
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
	    player.rank(difficulty, crimes, crimeMaker(random));
	    player.proceed();
	}

	//playing phase

	System.out.println("You've finished ranking. Let's see how well you've strategized. Shall we?");
	player.proceed();

	while (timeLeft > halfDay) { //first half of day
	    int rand = (int) (Math.random() * 4);

	    if (rand == 3) {
		System.out.println("\nEmergency! A crime has come in that you must deal with immediately! It is worth double the points of a regular crime.");
		bigCrime = crimeMaker((int)(Math.random()*9));
		
		startMission();
		solveCrime(bigCrime);
		player.increaseScore();
		player.increaseScore();
		System.out.println("Time Left : " + timeLeft + " minutes");
		System.out.println("Current Score: " + player.score);
	    }
	}








	
	/*
	while (timeLeft > halfDay) { //first half of day

	    Crime crimeOne = crimes.getFirst();
	    crimeSolved = false;

	    if (crimeOne.equals(oldCrime)) {
		startMission();
		solveCrime(crimeOne);
		crimes.removeFirst();
		player.increaseScore();
		System.out.println("Time Left : " + timeLeft + " minutes");
		System.out.println("Current Score: " + player.score);
	    }
	    
	    else {
		//for emergency crimes
		/*
		int rand = (int) (Math.random() * 4);

		if (rand < 3 ) { //new call comes in
		    int randomCrime = (int)(Math.random()*9);
		    player.rank(difficulty, crimes, crimeMaker(randomCrime));
		    startMission();
		    solveCrime(crimes.getFirst());
		    crimes.removeFirst();
		    player.increaseScore();
		    System.out.println("Time Left : " + timeLeft + " minutes");
		    System.out.println("Current Score: " + player.score);
		}

		else {
		    System.out.println("Emergency! A crime has come in that you must deal with immediately! It is worth double the points of a regular crime.");
		    Crime bigCrime = crimeMaker((int)(Math.random()*9));
		    startMission();
		    solveCrime(bigCrime);
		    player.increaseScore();
		    player.increaseScore();
		    System.out.println("Time Left : " + timeLeft + " minutes");
		    System.out.println("Current Score: " + player.score);
		}

		int randomCrime = (int)(Math.random()*9);
		player.rank(difficulty, crimes, crimeMaker(randomCrime));
		startMission();
		solveCrime(crimes.getFirst());
		crimes.removeFirst();
		player.increaseScore();
		System.out.println("Time Left : " + timeLeft + " minutes");
		System.out.println("Current Score: " + player.score);
	    }
	}

	System.out.println("\nLunch break!\n");
	player.proceed();
	player.interact(currentLv, 2 + (3 * (difficulty-1))); //midday interaction
	System.out.println("Back to work!\n");
	player.proceed();

	while (timeLeft > 0) { //second half of day

	    if (crimes.size() == 0) {
		Crime newCrime = crimeMaker((int)(Math.random()*9));
		newCrime.setPriority(1);
		crimes.add(newCrime);
	    }

	    Crime crimeOne = crimes.getFirst();
	    int crimeTime = crimeOne.getTimer();
	    crimeSolved = false;

	    if (firstCrime()) {
		startMission();
		solveCrime(crimeOne);
		crimes.removeFirst();
		player.increaseScore();
		System.out.println("Time Left : " + timeLeft + " minutes");
		System.out.println("Current Score: " + player.score);
	    }

	    int rand = (int) (Math.random() * 4);

	    if (rand < 3 || crimes.size() == 0) { //new call comes in
		int randomCrime = (int)(Math.random()*9);
		player.rank(difficulty, crimes, crimeMaker(randomCrime));
	        //startMission();
		solveCrime(crimes.getFirst());
		crimes.removeFirst();
		player.increaseScore();
		System.out.println("Time Left : " + timeLeft + " minutes");
		System.out.println("Current Score: " + player.score);
	    }

	    else {
		System.out.println("Emergency! A crime has come in that you must deal with immediately! It is worth double the points of a regular crime.");
		Crime bigCrime = crimeMaker((int)(Math.random()*9));
		startMission();
		solveCrime(bigCrime);
		player.increaseScore();
		player.increaseScore();
		System.out.println("Time Left : " + timeLeft + " minutes");
		System.out.println("Current Score: " + player.score);
	    }
	}

	System.out.println("\nIt looks like your shift is over.\n");
	player.proceed();

	player.interact(currentLv, 3 + (3 * (difficulty-1))); //end of day interaction
	*/
    }
	
}
