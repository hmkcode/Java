import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

@RunWith(Parameterized.class)
public class MathTest {
    public double a, b, sum;

    public MathTest(double a, double b, double sum) {
        //Note Constructor
        this.a = a;
        this.b = b;
        this.sum = sum;
    }

    @Parameters
    public static Collection<Object[]>calcValues() {
        return Arrays.asList(new Object [][] {{1.5, 1.5, 3}, {2.5, 3.5, 6}});
    }

    @Test
    public void sumTest() {
        assertTrue("Sum Test", sum == Math.sum(a, b));
    }
}
