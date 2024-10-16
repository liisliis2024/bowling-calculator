import org.example.BowlingCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingCalculatorTest {
    BowlingCalculator calc = new BowlingCalculator();

    @Test
    public void oneRoll() {
        calc.roll(6);
        assertEquals(6, calc.score());
    }

    @Test
    public void multipleRolls() {
        calc.roll(1);
        calc.roll(4);
        calc.roll(3);
        assertEquals(8, calc.score());
    }

    @Test
    public void spareRoll() {
        calc.roll(3);
        calc.roll(7);
        calc.roll(1);
        assertEquals(12, calc.score());
    }

    @Test
    public void strikeRoll() {
        calc.roll(10);
        calc.roll(7);
        calc.roll(1);
        assertEquals(26, calc.score());
    }

    @Test
    public void score() {
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(10);
        calc.roll(10);
        calc.roll(4);
        calc.roll(3);
        calc.roll(5);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        assertEquals(60, calc.score());
    }

    @Test
    public void maxScore() {
        for (int i = 0; i < 12; i++) {
            calc.roll(10);
        }
        assertEquals(300, calc.score());
    }

    @Test
    public void lastRollSpare() {
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(5);
        calc.roll(5);
        calc.roll(1);
        assertEquals(20, calc.score());
    }

    @Test
    public void lastRollStrike() {
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(10);
        calc.roll(1);
        calc.roll(1);
        assertEquals(22, calc.score());
    }

    @Test
    public void lastRoundWithoutBonus() {
        calc.roll(10);
        calc.roll(10);
        calc.roll(10);
        calc.roll(10);
        calc.roll(10);
        calc.roll(10);
        calc.roll(10);
        calc.roll(10);
        calc.roll(10);
        calc.roll(10);
        assertEquals(270, calc.score());
    }

    @Test
    public void secondRollStrike() {
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(1);
        calc.roll(0);
        calc.roll(10);
        calc.roll(1);
        calc.roll(1);
        assertEquals(21, calc.score());
    }


}



