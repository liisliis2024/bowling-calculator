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
        calc.roll(5);
        assertEquals(15, calc.spare());
    }




}
