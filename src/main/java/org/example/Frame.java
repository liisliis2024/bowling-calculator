package org.example;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    // TODO: keep roll1, roll2
    private List<Integer> rolls = new ArrayList<>();

    public void addRoll(int pins) {
        rolls.add(pins);
    }

    public boolean isComplete() {
        return isStrike() || rolls.size() == 2;
    }

    public boolean isStrike() {
        return rolls.size() == 1 && rolls.getFirst() == 10;
    }

    public boolean isSpare() {
        return rolls.size() == 2 && getScore() == 10;
    }

    public int getScore() {
        int total = 0;
        for (int roll : rolls) {
            total += roll;
        }
        return total;
    }

    public int getRoll(int index) {
        if (index < rolls.size()) {
            return rolls.get(index);
        }
        return 0;
    }

}
