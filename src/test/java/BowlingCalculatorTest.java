import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingCalculatorTest {
    BowlingCalculator calc = new BowlingCalculator();

    @Test
    void oneFrameStrike() {
        calc.addRoll(10);
        List<Frame> expected = List.of(new Frame(10, 0));
        assertEquals(expected, calc.frames);
    }

    @Test
    void oneFrame() {
        calc.addRoll(3);
        calc.addRoll(4);
        List<Frame> expected = List.of(new Frame(3, 4));
        assertEquals(expected, calc.frames);
    }

    @Test
    void multipleFrames() {
        calc.addRoll(3);
        calc.addRoll(4);
        calc.addRoll(4);
        calc.addRoll(3);
        List<Frame> expected = List.of(new Frame(3, 4), new Frame(4, 3));
        assertEquals(expected, calc.frames);
    }

    //    todo: -1 peab tegelema
    @Test
    public void oneRoll() {
        calc.addRoll(6);
        assertEquals(6, calc.calculateTotalScore());
    }

    @Test
    public void multipleRolls() {
        addRolls(1, 4, 3, 3);
        assertEquals(11, calc.calculateTotalScore());
    }


    @Test
    public void spareRoll() {
        addRolls(3, 7, 1);
        assertEquals(12, calc.calculateTotalScore());
    }

    @Test
    public void spareRollWithTen() {
        addRolls(0, 10, 1);
        assertEquals(12, calc.calculateTotalScore());
    }

    @Test
    public void strikeRoll() {
        addRolls(10, 7, 1);
        assertEquals(26, calc.calculateTotalScore());
    }

    @Test
    public void strikeRollTimesTwo() {
        addRolls(10, 10, 1, 1);
        assertEquals(35, calc.calculateTotalScore());
    }

    @Test
    public void calculateTotalScore() {
        addRolls(1, 1, 1, 1, 10, 10, 4, 3, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        assertEquals(66, calc.calculateTotalScore());
    }

    @Test
    public void maxCalculateTotalScore() {
        for (int i = 0; i <= 11; i++) {
            calc.addRoll(10);
        }
        assertEquals(300, calc.calculateTotalScore());
    }

    @Test
    public void endWithoutBonus() {
        addRolls(3, 4, 3, 4, 10, 10, 3, 4, 3, 4, 3, 4, 3, 4, 3, 4, 3, 4);
        assertEquals(96, calc.calculateTotalScore());
    }

    @Test
    public void endWithSpare() {
        addRolls(3, 4, 3, 4, 10, 10, 3, 4, 3, 4, 3, 4, 3, 4, 3, 4, 3, 7, 7);
        assertEquals(106, calc.calculateTotalScore());
    }

    @Test
    public void endWithOneStrike() {
        addRolls(3, 4, 3, 4, 10, 10, 3, 4, 3, 4, 3, 4, 3, 4, 3, 4, 10, 3, 4);
        assertEquals(106, calc.calculateTotalScore());
    }

    @Test
    public void endWithTwoStrikes() {
        addRolls(3, 4, 3, 4, 10, 10, 3, 4, 3, 4, 3, 4, 3, 4, 3, 4, 10, 10, 4);
        assertEquals(113, calc.calculateTotalScore());
    }

    @Test
    void toStringRegularEnd() {
        calc.frames = List.of(new Frame(3, 4), new Frame(10), new Frame(3, 4), new Frame(3, 7), new Frame(3, 4), new Frame(3, 4), new Frame(10), new Frame(3, 4), new Frame(3, 4), new Frame(3, 4));
        assertEquals("""
                | 3 4 | X - | 3 4 | 3 / | 3 4 | 3 4 | X - | 3 4 | 3 4 | 3 4 |
                | 7 | 24 | 31 | 44 | 51 | 58 | 75 | 82 | 89 | 96 |""", calc.toString());

    }

    @Test
    void toStringSpareEnd() {
        calc.frames = List.of(new Frame(3, 4), new Frame(10), new Frame(3, 4), new Frame(3, 7), new Frame(3, 4), new Frame(3, 4), new Frame(10), new Frame(3, 4), new Frame(3, 4), new Frame(3, 7), new Frame(4));
        assertEquals("""
                | 3 4 | X - | 3 4 | 3 / | 3 4 | 3 4 | X - | 3 4 | 3 4 | 3 / 4 |
                | 7 | 24 | 31 | 44 | 51 | 58 | 75 | 82 | 89 | 103 |""", calc.toString());

    }

    @Test
    void toStringStrikeEnd() {
        calc.frames = List.of(new Frame(3, 4), new Frame(10, 0), new Frame(3, 4), new Frame(3, 7), new Frame(3, 4), new Frame(3, 4), new Frame(10, 0), new Frame(3, 4), new Frame(3, 4), new Frame(10), new Frame(3, 4));
        assertEquals("""
                | 3 4 | X - | 3 4 | 3 / | 3 4 | 3 4 | X - | 3 4 | 3 4 | X 3 4 |
                | 7 | 24 | 31 | 44 | 51 | 58 | 75 | 82 | 89 | 106 |""", calc.toString());

    }

    @Test
    void toStringDoubleStrikeEnd() {
        calc.frames = List.of(new Frame(3, 4), new Frame(10, 0), new Frame(3, 4), new Frame(3, 7), new Frame(3, 4), new Frame(3, 4), new Frame(10, 0), new Frame(3, 4), new Frame(3, 4), new Frame(10), new Frame(10), new Frame(3));
        assertEquals("""
                | 3 4 | X - | 3 4 | 3 / | 3 4 | 3 4 | X - | 3 4 | 3 4 | X X 3 |
                | 7 | 24 | 31 | 44 | 51 | 58 | 75 | 82 | 89 | 112 |""", calc.toString());

    }

    private void addRolls(int... examplePins) {
        for (int example : examplePins) {
            calc.addRoll(example);
        }
    }
}






