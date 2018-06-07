/*******************
CallCenter class
******************/

import java.util.LinkedList;
import cs1.Keyboard;

public class CallCenter {

  //instance vars
  public ArrayPriorityQueue crimes;
  private ALHeapMin inventory;
  private LinkedList<Busters> busters;
  private int timeLimit;
  private int difficulty;

  long startTime = System.currentTimeMillis();
  long endTime = startTime + timeLimit;
  long remainingTime = timeLimit;

  public CallCenter(int dif) {
    difficulty = dif;
    crimes = new ArrayPriorityQueue();
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

    if (difficulty == 1) timeLimit = 240000;
    else if (difficulty == 2) timeLimit = 180000;
    else if (difficulty == 3) timeLimit = 120000;

  }

  public int getDifficulty() {
    return difficulty;
  }

  public void increaseTime() { //possible reward for making right choice in interaction
    endTime += 30000;
  }

  public void decreaseTime() { //possible punishment for making wrong choice
    endTime -= 30000;
  }

  public boolean whenSolved(Crime input) {
    return (remainingTime == input.getTimer());
  }

  public void chooseBusters(Crime input) {
    String prompter = "";
    int choice;

    prompter = "\nWould you like to request assistance for this mission?";
    prompter += "\n1: Yes, please! \n2: Nah";
    System.out.println(prompter);

    choice = Keyboard.readInt();
    if (choice != 1 && choice != 2) {
      System.out.println("\nUh...I'm gonna need an answer, dude.");
      chooseBusters(input);
    }

    while (choice == 1) {
      prompter = "Please select who you gonna call:";
      prompter += "\n" + busters.toString();
      prompter += "\n(Select 1 for the first option, 2 for the second, etc...)";
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

    prompter = "\n\nWould you like to grap equipment for this mission?";
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

  public void minigame(ALHeapMin equipment) { //will implement soon
    System.out.print("\033[H\033[2J");
    System.out.println("To play the game, choose option 1 if you want more helpful equipment but if you're satisfied, choose option 2\n Keep in mind the time it takes to get another piece of equipment");
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
      System.out.println("Follow the instructions");
      minigame(inventory);
    }
  }

  public void startMission() {
    chooseBusters(crimes.peekMin());
    chooseEquipment(crimes.peekMin());
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
    /*
    if (difficulty >= 1) {
    Crime newCrime = crimeMaker((int)(Math.random()*9));
    System.out.println("\nCrime left over from before your shift:" + newCrime.toString());
    newCrime.setPriority((int)(Math.random()*(difficulty+10)));
    System.out.println("Its priority is: " + newCrime.getPriority());
    crimes.add(newCrime);
  }
  if (difficulty >= 2) crimes.add(crimeMaker((int)(Math.random()*9)));
  if (difficulty() == 3) crimes.add(crimeMaker((int)(Math.random()*9)));
  */

  Crime oldCrime = crimeMaker((int)(Math.random()*9));
  oldCrime.setPriority((int)(Math.random()*(difficulty+10)));
  crimes.add(oldCrime);

  player.interact(currentLv, 1 + (3 * (difficulty-1)));
  int halfSize = (difficulty + 10)/2;
  boolean firstCrime = true;
  int ctr = 0;

  System.out.println("START OF DAY " + difficulty);
  System.out.println("\nCrime left over from before your shift: " + oldCrime.toString());
  System.out.println("\nIts priority is: " + oldCrime.getPriority());
  System.out.println("\nReady to begin?\n");

  player.proceed();

  while (ctr < halfSize && remainingTime >= 0) { //first half of day
    //if (firstCrime) {
    //	startMission();
    //	firstCrime = false;
    //}

    if (whenSolved(crimes.peekMin())) { //once crime is solved
      crimes.removeMin();
      player.increaseScore();
      startMission();
    }

    if (remainingTime % (timeLimit/10) == 0) { //new call comes in
      ctr += 1;
      int randomCrime = (int)(Math.random()*9);
      player.rank(difficulty, crimes, crimeMaker(randomCrime));
    }
    remainingTime = endTime - System.currentTimeMillis();
  }

  System.out.println("\nLunch break!\n");
  player.proceed();
  player.interact(currentLv, 2 + (3 * (difficulty-1))); //midday interaction
  System.out.println("Back to work!\n");
  player.proceed();

  while (remainingTime >= 0) { //second half of day
    if (whenSolved(crimes.peekMin())) {
      crimes.removeMin();
      player.increaseScore();
      startMission();
    }

    if (remainingTime % (timeLimit/10) == 0) {
      int randomCrime = (int)(Math.random()*9);
      player.rank(difficulty, crimes, crimeMaker(randomCrime));
    }
    remainingTime = endTime - System.currentTimeMillis();
  }

  System.out.println("\nIt looks like your shift is over.\n");
  player.proceed();

  player.interact(currentLv, 3 + (3 * (difficulty-1))); //end of day interaction
  }
}
