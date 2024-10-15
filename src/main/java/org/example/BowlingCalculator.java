package org.example;

import java.util.ArrayList;
import java.util.List;

public class BowlingCalculator {
    List<Frame> frames = new ArrayList<>();
    int currentFrame = 0;


    public BowlingCalculator() {
        for (int i = 0; i < 10; i++) {
            frames.add(new Frame());
        }
    }

    public void roll(int pins) {
        Frame current = frames.get(currentFrame);
        current.addRoll(pins);

        if (pins == 10 && currentFrame < 9) {
            currentFrame++;

        } else if (current.isComplete()) {
            currentFrame++;
        }
    }

    public int score() {
        int totalScore = 0;
        for (int i = 0; i < 10; i++) {
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
        Frame nextFrame = frames.get(frameIndex + 1);
        int bonus = nextFrame.getRoll(0);
        if (nextFrame.isStrike() && frameIndex < 8) {
            bonus += frames.get(frameIndex + 2).getRoll(0);
        } else if (frameIndex < 9) {
            bonus += nextFrame.getRoll(1);
        }
        return bonus;
    }

    private int getSpareBonus(int frameIndex) {
        Frame nextFrame = frames.get(frameIndex + 1);
        return nextFrame.getRoll(0);
    }


}



