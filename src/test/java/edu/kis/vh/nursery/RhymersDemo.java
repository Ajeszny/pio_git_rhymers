package edu.kis.vh.nursery;

import edu.kis.vh.nursery.DefaultCountingOutRhymer;
import edu.kis.vh.nursery.HanoiRhymer;
import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {

    private static final int RHYMERS_COUNT = 4;
    private static final int ELEMENTS_TO_COUNT_IN = 15;
    private static final int RANDOM_BOUND = 20;

    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();
		testRhymers(factory);
    }
    public static void testRhymers(Rhymersfactory factory) {    
        DefaultCountingOutRhymer[] rhymers = { factory.getStandardRhymer(), factory.getFalseRhymer(),
                factory.getFIFORhymer(), factory.getHanoiRhymer()};
        
        for (int i = 1; i < ELEMENTS_TO_COUNT_IN; i++) {
            for (int j = 0; j < RHYMERS_COUNT - 1; j++) {
                rhymers[j].countIn(i);
            }
        }
        
        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < ELEMENTS_TO_COUNT_IN; i++) {
            rhymers[RHYMERS_COUNT - 1].countIn(rn.nextInt(RANDOM_BOUND));
        }
        
        for (int i = 0; i < RHYMERS_COUNT; i++) {
            while (!rhymers[i].callCheck()) {
                System.out.print(rhymers[i].countOut() + "  ");
            }
            System.out.println();
        }
        
        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[RHYMERS_COUNT - 1]).reportRejected());
    }
}
