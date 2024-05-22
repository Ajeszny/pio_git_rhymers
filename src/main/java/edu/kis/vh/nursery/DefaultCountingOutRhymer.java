package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {
    private static final int CAPACITY = 12;
    private static final int EMPTY_STACK_INDICATOR = -1;
    private static final int FULL_STACK_INDICATOR = CAPACITY - 1;
    private static final int DEFAULT_VALUE = -1;

    private int[] numbers = new int[CAPACITY];
    private int total = EMPTY_STACK_INDICATOR;

    public void countIn(int in) {
        if (!isFull()) {
            numbers[++total] = in;
        }
    }

    public boolean callCheck() {
        return total == EMPTY_STACK_INDICATOR;
    }

    public boolean isFull() {
        return total == FULL_STACK_INDICATOR;
    }

    protected int peekaboo() {
        if (callCheck()) {
            return DEFAULT_VALUE;
        }
        return numbers[total];
    }

    public int countOut() {
        if (callCheck()) {
            return DEFAULT_VALUE;
        }
        return numbers[total--];
    }
}
