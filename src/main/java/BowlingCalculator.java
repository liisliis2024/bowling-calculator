import java.util.ArrayList;
import java.util.List;

public class BowlingCalculator {
    public static final int LAST_FRAME = 9;
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
        for (int i = 0; i < frames.size() && i <= LAST_FRAME; i++) {
            score = calculateFrameScore(i, score);
        }
        return score;
    }

    private int calculateFrameScore(int i, int score) {
        var frame = frames.get(i);
        if (i <= LAST_FRAME) {

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
        }
        return score;

    }

    public String toString() {
        var frameContents = new StringBuilder();
        var frameScores = new StringBuilder();
        int frameScore = 0;

        for (int i = 0; i < frames.size(); i++) {
            frameScore = calculateFrameScore(i, frameScore);
            frameContents.append("| ").append(frames.get(i).toString()).append(" ");
            frameScores.append("| ").append(frameScore).append(" ");
            if (i == frames.size() - 1) {
                frameContents.append("|");
                frameScores.append("|");
            }
        }
//        todo: return totalScore Total score:
        return frameContents + "\n" + frameScores;
    }
}








