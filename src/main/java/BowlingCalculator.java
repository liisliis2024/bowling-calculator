import java.util.ArrayList;
import java.util.List;

public class BowlingCalculator {
    List<Frame> frames = new ArrayList<>();

    public void addRoll(int pins) {
        if (frames.isEmpty() || frames.getLast().isComplete()) {
            Frame frame = new Frame(pins);
            frames.add(frame);
            if (frame.isStrike()) {
                frame.setSecondRoll(0);
                frame.isComplete();
            }
        } else {
            Frame frame = frames.getLast();
            frame.setSecondRoll(pins);
            frame.isComplete();
        }
    }

    public int calculateTotalScore() {
        int score = 0;
        for (int i = 0; i < frames.size() && i <= 9; i++) {
            score = calculateFrameScore(i, score);
        }
        return score;
    }

    private int calculateFrameScore(int i, int score) {
        score += frames.get(i).getFrameScore();
        if (frames.get(i).isSpare()) {
            score += frames.get(i + 1).getFirstRoll();
        }
        if (frames.get(i).isStrike()) {
            score += frames.get(i + 1).getFrameScore();

            if (frames.get(i + 1).isStrike() && i + 2 < frames.size()) {
                score += frames.get(i + 2).getFirstRoll();
            }
        }
        return score;
    }

    public String getScorePrint() {
        String printScore = "";

        return printScore;
    }
}









