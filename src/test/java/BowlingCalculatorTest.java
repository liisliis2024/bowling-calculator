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
        assertEquals(6, calc.score());
    }

    @Test
    public void multipleRolls() {
        calc.addRoll(1);
        calc.addRoll(4);
        calc.addRoll(3);
        calc.addRoll(3);
        assertEquals(11, calc.score());
    }

    @Test
    public void spareRoll() {
        calc.addRoll(3);
        calc.addRoll(7);
        calc.addRoll(1);
        assertEquals(12, calc.score());
    }

    @Test
    public void spareRollWithTen() {
        calc.addRoll(0);
        calc.addRoll(10);
        calc.addRoll(1);
        assertEquals(12, calc.score());
    }

    @Test
    public void strikeRoll() {
        calc.addRoll(10);
        calc.addRoll(7);
        calc.addRoll(1);
        assertEquals(26, calc.score());
    }
    @Test
    public void strikeRollTimesTwo() {
        calc.addRoll(10);
        calc.addRoll(10);
        calc.addRoll(1);
        calc.addRoll(1);
        assertEquals(35, calc.score());
    }

    @Test
    public void score() {
        calc.addRoll(1);
        calc.addRoll(1);

        calc.addRoll(1);
        calc.addRoll(1);

        calc.addRoll(10);

        calc.addRoll(10);

        calc.addRoll(4);
        calc.addRoll(3);

        calc.addRoll(5);
        calc.addRoll(1);

        calc.addRoll(1);
        calc.addRoll(1);

        calc.addRoll(1);
        calc.addRoll(1);

        calc.addRoll(1);
        calc.addRoll(1);

        calc.addRoll(1);
        calc.addRoll(1);
        assertEquals(66, calc.score());
    }

    @Test
    public void maxScore() {
        for (int i = 0; i <= 11; i++) {
            calc.addRoll(10);
        }
        assertEquals(300, calc.score());
    }

    @Test
    public void endWithoutBonus() {
        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(10);

        calc.addRoll(10);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);
        assertEquals(96, calc.score());
    }

    @Test
    public void endWithSpare() {
        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(10);

        calc.addRoll(10);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(7);

        calc.addRoll(7);
        assertEquals(106, calc.score());
    }

    @Test
    public void endWithOneStrike() {
        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(10);

        calc.addRoll(10);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(10);

        calc.addRoll(3);
        calc.addRoll(4);
        assertEquals(106, calc.score());
    }

    @Test
    public void endWithTwoStrikes() {
        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(10);

        calc.addRoll(10);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(3);
        calc.addRoll(4);

        calc.addRoll(10);

        calc.addRoll(10);

        calc.addRoll(4);
        assertEquals(113, calc.score());
    }
}



