import java.util.Objects;

public class Frame {
    // TODO: keep roll1, roll2
    int firstRoll;
    int secondRoll;

    public Frame() {
    }

    public Frame(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
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

//    public void addRoll(int pins) {
//        rolls.add(pins);
//    }

    public boolean isComplete() {
        return isStrike() || secondRoll >= 0;
    }

    public boolean isStrike() {
        return firstRoll == 10;
    }

    public boolean isSpare() {
        return getScore() == 10 && !isStrike();
    }

    public int getScore() {
        return firstRoll + secondRoll;
    }

}
