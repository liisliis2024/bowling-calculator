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

//    @Test
//    public void oneRoll() {
//        calc.roll(6);
//        assertEquals(6, calc.score());
//    }
//
//    @Test
//    public void multipleRolls() {
//        calc.roll(1);
//        calc.roll(4);
//        calc.roll(3);
//        assertEquals(8, calc.score());
//    }
//
//    @Test
//    public void spareRoll() {
//        calc.roll(3);
//        calc.roll(7);
//        calc.roll(1);
//        assertEquals(12, calc.score());
//    }
//
//    @Test
//    public void spareRollWithTen() {
//        calc.roll(0);
//        calc.roll(10);
//        calc.roll(1);
//        assertEquals(12, calc.score());
//    }
//
//    @Test
//    public void strikeRoll() {
//        calc.roll(10);
//        calc.roll(7);
//        calc.roll(1);
//        assertEquals(26, calc.score());
//    }
//
//    @Test
//    public void score() {
//        calc.roll(1);
//        calc.roll(1);
//
//        calc.roll(1);
//        calc.roll(1);
//
//        calc.roll(10);
//
//        calc.roll(10);
//
//        calc.roll(4);
//        calc.roll(3);
//
//        calc.roll(5);
//        calc.roll(1);
//
//        calc.roll(1);
//        calc.roll(1);
//
//        calc.roll(1);
//        calc.roll(1);
//
//        calc.roll(1);
//        calc.roll(1);
//
//        calc.roll(1);
//        calc.roll(1);
//        assertEquals(66, calc.score());
//    }
//
//    @Test
//    public void maxScore() {
//        for (int i = 0; i <= 11; i++) {
//            calc.roll(10);
//        }
//        assertEquals(300, calc.score());
//    }
//
//    @Test
//    public void endWithoutBonus() {
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(10);
//
//        calc.roll(10);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//        assertEquals(96, calc.score());
//    }
//
//    @Test
//    public void endWithSpare() {
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(10);
//
//        calc.roll(10);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(7);
//
//        calc.roll(7);
//        assertEquals(106, calc.score());
//    }
//
//    @Test
//    public void endWithOneStrike() {
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(10);
//
//        calc.roll(10);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(10);
//
//        calc.roll(3);
//        calc.roll(4);
//        assertEquals(106, calc.score());
//    }
//
//    @Test
//    public void endWithTwoStrikes() {
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(10);
//
//        calc.roll(10);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(3);
//        calc.roll(4);
//
//        calc.roll(10);
//
//        calc.roll(10);
//
//        calc.roll(4);
//        assertEquals(113, calc.score());
//    }
}



