import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {

    @Test
    public void isCompleteStrike() {
        assertTrue(new Frame(10, 0).isComplete());
    }

    @Test
    public void isCompleteZeroSecond() {
        assertTrue(new Frame(7, 0).isComplete());
    }

    @Test
    public void isCompleteZeros() {
        assertTrue(new Frame(0, 0).isComplete());
    }

    @Test
    public void isComplete() {
        assertTrue(new Frame(3, 3).isComplete());
    }

    @Test
    public void isStrike() {
        assertTrue(new Frame(10, 0).isStrike());
    }

    @Test
    public void isSpare() {
        assertTrue(new Frame(4, 6).isSpare());
    }

    @Test
    public void getFrameScore() {
        assertEquals(6, new Frame(3, 3).getFrameScore());
    }

}