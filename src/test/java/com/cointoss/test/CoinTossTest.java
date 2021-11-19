package com.cointoss.test;

import com.cointoss.CoinToss;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CoinTossTest {

    @Test
    void probabilityOfGettingHeadIsEqualToGettingTail(){

        CoinToss probOfHead=new CoinToss(0.5);
        CoinToss probOfTail=new CoinToss(0.5);
        assertEquals(probOfHead,probOfTail);

    }

    @Test
    void probabilityOfGettingHeadIsNotEqualToGettingTail(){

        CoinToss probOfHead=new CoinToss(0.25);
        CoinToss probOfTail=new CoinToss(0.5);
        assertNotEquals(probOfHead,probOfTail);

    }

    @Test
    void probabilityOfTwoEventsOccurringTogether(){

        CoinToss probOfEventOne=new CoinToss(0.5);
        CoinToss probOfEventTwo=new CoinToss(0.5);

        CoinToss expectedObject=new CoinToss(0.25);

        assertEquals(expectedObject,probOfEventOne.probOfTwoEvents(probOfEventTwo));

    }

    @Test
    void probabilityOfAnEventNotOccurring(){

        CoinToss probOfEvent=new CoinToss(0.5);

        CoinToss expectedObject=new CoinToss(0.5);

        assertEquals(expectedObject,probOfEvent.probOfNotAnEvent());

    }

    @Test
    void probabilityOfEitherOfTwoEventsOccurring(){

        CoinToss probOfEventOne=new CoinToss(0.5);
        CoinToss probOfEventTwo=new CoinToss(0.5);

        CoinToss expectedObject=new CoinToss(0.75);

        assertEquals(expectedObject,probOfEventOne.probOfEitherOfTwoEvents(probOfEventTwo));

    }
}
