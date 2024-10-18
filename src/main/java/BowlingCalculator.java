import java.util.ArrayList;
import java.util.List;

public class BowlingCalculator {
    List<Frame> frames = new ArrayList<>();

    public void addRoll(int pins) {
        if (frames.isEmpty() || frames.getLast().isComplete()) {
            var frame = new Frame(pins);
            frames.add(frame);
            if (frame.isStrike()) {
                frame.setSecondRoll(0);
            }
        } else {
            frames.getLast().setSecondRoll(pins);
        }
    }

    public int calculateTotalScore() {
        int score = 0;
//        todo> for each
        for (int i = 0; i < frames.size() && i <= 9; i++) {
            score = calculateFrameScore(i, score);
        }
        return score;
    }

    private int calculateFrameScore(int i, int score) {
        var frame = frames.get(i);
        score += frame.getFrameScore();
        if (frame.isSpare()) {
            score += frames.get(i + 1).getFirstRoll();
        }
        if (frame.isStrike()) {
            score += frames.get(i + 1).getFrameScore();
            if (frames.get(i + 1).isStrike() && i + 2 < frames.size()) {
                score += frames.get(i + 2).getFirstRoll();
            }
        }
        return score;
    }

    public String toString(List<Frame> frames) {
        var frameContents = new StringBuilder();
        var frameScores = new StringBuilder();

        for (Frame frame : frames) {
            frameContents.append("| ").append(frame.toString()).append(" |");
            frameScores.append("  ").append(frame.getFrameScore()).append("  ");
//            if (i == frames.size() - 1) {
//                printScore += "|";
//            }
        }
        return frameContents + "\n" + frameScores;
    }
}








