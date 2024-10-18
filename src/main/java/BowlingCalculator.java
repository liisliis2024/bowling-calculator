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

    public String getScorePrint(List<Frame> frames) {
        String printScore = "";

        for (int i = 0; i < frames.size(); i++) {
            printScore += "| "+ frames.get(i).toString() + " " + "\n"
                    + frames.get(i).getFrameScore();
            if (i == frames.size() - 1) {
                printScore += "|";
            }
        }

// printf
        System.out.println(printScore);
        return printScore;
    }






//    public StringBuilder getScorePrint(List<Frame> frames) {
//        StringBuilder printScore = new StringBuilder();
//
//        for (int i = 0; i < frames.size(); i++) {
//            printScore.append("| ").append(frames.get(i).toString()).append(" ");
//            if (i == frames.size() - 1) {
//                printScore.append("|");
//            }
//        }
//        System.out.println(printScore);
//        return printScore;
//    }
}


//StringBuilder printScore = new StringBuilder();
//
//for (int i = 0; i < frames.size(); i++) {
//        // Add frame representation to the score string
//        printScore.append("| ").append(frames.get(i).toString()).append(" ");
//
//// Add separator only if this is not the last frame
//    if (i != frames.size() - 1) {
//        printScore.append("| ");  // Add separator between frames
//    }
//            }








