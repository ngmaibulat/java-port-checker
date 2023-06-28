import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.ngm.Calculator;

public class CalculatorTest {

    @Test
    public void testSomeFn() {
        var calculator = new Calculator();

        // var fn = () -> {
        // calculator.somefn(0.0);
        // };

        assertThrows(IllegalArgumentException.class, () -> {
            calculator.somefn(0.0);
        });
    }

    @Test
    public void testAddition() {
        var calculator = new Calculator();
        int result = calculator.add(2, 3);
        int expected = 5;
        assertEquals(expected, result);
    }

    @Test
    public void testTrue() {
        var value = true;
        assertTrue(value);
    }

    @Test
    public void testFalse() {
        var value = false;
        assertFalse(value);
    }

    @Test
    public void testNull() {
        Object value = null;
        assertNull(value);
    }

    @Test
    public void testSubtraction() {
        var calculator = new Calculator();
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }
}
