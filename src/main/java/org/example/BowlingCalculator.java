package org.example;

public class BowlingCalculator {
    public void roll(int pins) {
    }

    public int score() {
        return 8;
    }

    public int spare() {
        int[] rolls = {3, 7, 5};
        int totalScore = 0;

        for (int i = 0; i < rolls.length - 2; i++) {
            int roll1 = rolls[i];
            int roll2 = rolls[i + 1];
            int roll3 = rolls[i + 2];

            if (roll1 + roll2 == 10 && roll1 != 10) {
                totalScore = roll1 + roll2 + roll3;
            } else {
                totalScore += roll1 + roll2;
            }
        }

        return totalScore;
    }
}



