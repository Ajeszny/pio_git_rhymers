package edu.kis.vh.nursery;

/**
 * HanoiRhymer
 */
public class HanoiRhymer extends DefaultCountingOutRhymer {
    /**
     * Total rejected
     */
    private int totalRejected = 0;

    /**
     *
     * @return total rejected calls
     */
    public int reportRejected() {
        return totalRejected;
    }

    /**
     *
     * @param in in
     *           
     */
	@Override
    public void countIn(int in) {
        if (!callCheck() && in > peekaboo())
            totalRejected++;
        else
            super.countIn(in);
    }
}