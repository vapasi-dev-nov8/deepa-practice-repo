package com.cointoss;

import java.util.Objects;

public class CoinToss {
    double value;

    public CoinToss(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoinToss that = (CoinToss) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public CoinToss probOfTwoEvents(CoinToss otherEvent) {
        return new CoinToss(this.value * otherEvent.value);
    }

    public CoinToss probOfNotAnEvent() {
        return new CoinToss(1 - this.value);
    }

    public CoinToss probOfEitherOfTwoEvents(CoinToss otherEvent) {
        return new CoinToss(this.value + otherEvent.value - (this.value * otherEvent.value));
    }

}
