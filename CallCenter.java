/*******************
 CallCenter class
 ******************/

import java.util.LinkedList;

public class CallCenter {

    //instance vars
    private PriorityQueue crimes;
    private ALHeapMin inventory;
    private LinkedList<Busters> busters;
    private int time;

    long startTime = System.currentTimeMillis();
    long endTime = startTime + time;

    public CallCenter(int inputTime) {
	time = inputTime;
	crimes = new PriorityQueue();
    }
    

    public void chooseBusters(Crime input) {
    }

    public void chooseEquipment(Crime input, int root) {
    }

    
    public static void main(String[] args) {
    }
}
