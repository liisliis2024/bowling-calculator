import java.util.Objects;

public class Frame {
    int firstRoll;
    int secondRoll = -1;

    public Frame(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public Frame(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
    }

    public boolean isComplete() {
        return isStrike() || secondRoll >= 0;
    }

    public boolean isStrike() {
        return firstRoll == 10;
    }

    public boolean isSpare() {
        return getFrameScore() == 10 && !isStrike();
    }

    public int getFrameScore() {
        if (secondRoll == -1) {
            return firstRoll;
        }
        return firstRoll + secondRoll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return firstRoll == frame.firstRoll && secondRoll == frame.secondRoll;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstRoll, secondRoll);
    }

    @Override
    public String toString() {
        if (isStrike()) return "X -";
        if (isSpare()) return firstRoll + " /";
        return firstRoll + " " + secondRoll;
    }
}
