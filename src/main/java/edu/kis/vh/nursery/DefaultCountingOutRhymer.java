package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    private static final int TOTAL_NUMBERS = 12;
    private static final int EMPTY = -1;
    private static final int MAX_CAPACITY = TOTAL_NUMBERS - 1;
	
    private int[] NUMBERS = new int[TOTAL_NUMBERS];

    private int total = EMPTY;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }
    public boolean callCheck() {
        return total == EMPTY;
    }
        
     public boolean isFull() {
        return total == MAX_CAPACITY;
    }
        
    protected int peekaboo() {
        if (callCheck())
            return EMPTY;
        return numbers[total];
    }
    public int countOut() {
        if (callCheck())
            return EMPTY;
        return numbers[total--];
    }

    public int getTotal() {
        return total;
    }	

}
