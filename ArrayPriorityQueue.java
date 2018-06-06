import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {
    //instance vars
    private int _size;
    private ArrayList<Crime> _data;

    //constructor
    public ArrayPriorityQueue() {
	_size = 0; //queue is empty at birth
	_data = new ArrayList<Crime>();
    }

    //~~~~~~~~~~~~ API methods ~~~~~~~~~~~~~~~~~
    public void add(Crime x) {
        _data.add(x);
	_size += 1;
    }

    public boolean isEmpty() {
	return (_size == 0);
    }

    public Crime peekMin() {
	Crime min = _data.get(0);
	for (Crime s: _data) {
	    if (s.getPriority() < min.getPriority()) min = s;
	}
	return min;
    }

    public Crime removeMin() {
	int minIndex = 0;
	for (int ctr = 0; ctr < _size; ctr ++) {
	    if (_data.get(ctr).getPriority() < _data.get(minIndex).getPriority()) minIndex = ctr;
	}
	_size -= 1;
	return _data.remove(minIndex);
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //toString
    public String toString() {
	String retStr = "\n";
	for (Crime s: _data) retStr += s + "\n";
	return retStr;
    }

    //size
    public int size() {
	return _size;
    }
    
    //main
    public static void main(String[] args) {
	System.out.println("\nInitializing ArrayPriorityQueue lobster...");
	ArrayPriorityQueue lobster = new ArrayPriorityQueue();

	System.out.println("Is lobster empty?: " + lobster.isEmpty());

	System.out.println("\n\nFilling up lobster...");

	/* ~~~~~~~~~~~~~~~ MOVE ME DOWN ~~~~~~~~~~~~~~~~~~~~
	lobster.add("the");
	lobster.add("quick");
	lobster.add("brown");
	lobster.add("fox");
	lobster.add("zooped");
	lobster.add("over");
	lobster.add("the");
	lobster.add("zany");
	lobster.add("dog");

	System.out.println("\nLobster: " + lobster);
	System.out.println("Is lobster empty?: " + lobster.isEmpty());

	System.out.println("\n\nEmptying lobster...");
	while (! lobster.isEmpty()) {
	    System.out.println("\nCurrent minimum: " + lobster.peekMin());
	    System.out.println("Element removed: " + lobster.removeMin());
	    System.out.println("State of lobster: " + lobster);
	}

	System.out.println("\nIs lobster empty?: " + lobster.isEmpty());   
	   
	~~~~~~~~~~~~~~~~~ YOU DID IT! ~~~~~~~~~~~~~~~~~~~~~~*/
    }
}
