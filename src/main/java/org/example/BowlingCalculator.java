package org.example;

import java.util.ArrayList;
import java.util.List;

public class BowlingCalculator {
    List<Frame> frames = new ArrayList<>();
    int currentFrame = 0;


    public BowlingCalculator() {
        // TODO: do not add preliminary frames
        for (int i = 0; i < 12; i++) {
            frames.add(new Frame());
        }
    }

    public void roll(int pins) {
        var current = frames.get(currentFrame);
        current.addRoll(pins);

        if (current.isStrike() && currentFrame < 9) {
            currentFrame++;

        } else if (current.isComplete()) {
            currentFrame++;
        }
    }

    public int score() {
        int totalScore = 0;
        for (int i = 0; i <= 9; i++) {
            Frame frame = frames.get(i);
            totalScore += frame.getScore();

            if (frame.isStrike()) {
                totalScore += getStrikeBonus(i);
            } else if (frame.isSpare()) {
                totalScore += getSpareBonus(i);
            }
        }
        return totalScore;
    }

    private int getStrikeBonus(int frameIndex) {
        var nextFrame = frames.get(frameIndex + 1);
        int bonus = nextFrame.getRoll(0) + nextFrame.getRoll(1);

        if (nextFrame.isStrike()) {
            bonus += frames.get(frameIndex + 2).getRoll(0);
        }
        return bonus;
    }

    private int getSpareBonus(int frameIndex) {
        var nextFrame = frames.get(frameIndex + 1);
        return nextFrame.getRoll(0);
    }

}



