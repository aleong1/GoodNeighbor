/*******************
 CallCenter class
 ******************/

import java.util.LinkedList;

public class CallCenter {

    //instance vars
    private PriorityQueue crimes;
    private ALHeapMin inventory;
    private LinkedList<Busters> busters;
    private int timeLimit;
    private int difficulty;

    long startTime = System.currentTimeMillis();
    long endTime = startTime + timeLimit;
    long midTime = startTime + (timeLimit/2); //for midday interaction

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

    public void chooseBusters(Crime input) {
    }

    public void chooseEquipment(Crime input, int root) {
    }

    
    public static void main(String[] args) {
    }
}
