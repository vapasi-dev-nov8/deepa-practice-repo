package com.cointoss.test;

import com.cointoss.Probability;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProbabilityTest {

    @Test
    void probabilityOfGettingHeadIsEqualToGettingTail(){

        Probability probOfHead=new Probability(0.5);
        Probability probOfTail=new Probability(0.5);
        assertEquals(probOfHead,probOfTail);

    }

    @Test
    void probabilityOfGettingHeadIsNotEqualToGettingTail(){

        Probability probOfHead=new Probability(0.25);
        Probability probOfTail=new Probability(0.5);
        assertNotEquals(probOfHead,probOfTail);

    }

    @Test
    void probabilityOfTwoEventsOccurringTogether(){

        Probability probOfEventOne=new Probability(0.5);
        Probability probOfEventTwo=new Probability(0.5);

        Probability probOfTwoEventsTogether=new Probability(0.25);

        assertEquals(probOfTwoEventsTogether,probOfEventOne.probOfTwoEvents(probOfEventTwo));

    }
}
