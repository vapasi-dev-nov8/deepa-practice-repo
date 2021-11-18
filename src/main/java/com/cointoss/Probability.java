package com.cointoss;

import java.util.Objects;

public class Probability {
    double value;

    public Probability(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probability that = (Probability) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Probability probOfTwoEvents(Probability otherEvent) {
        return new Probability(this.value * otherEvent.value);
    }
}
