import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

@RunWith(Theories.class)
public class MathTest {
    @DataPoint public static double MIN = Double.MIN_VALUE;
    @DataPoint public static double NEGATIVE_FOUR = -4.0d;
    @DataPoint public static double ZERO = 0.0d;
    @DataPoint public static double POINT_FIVE = 0.5d;
    @DataPoint public static double ONE = 1.0d;
    @DataPoint public static double TWO = 2.0d;
    @DataPoint public static double MAX = Double.MAX_VALUE;

    @Theory
    public void mathFloorTest(double n) {
        assumeTrue(n < Integer.MAX_VALUE);
        assertEquals((int)n, Math.floor(n), 0);
    }

    @Theory
    public void mathLog10Test(double n) {
        assumeTrue(n > 0);
        System.out.print(Math.pow(10, Math.log10(n)));
        assertEquals(Math.pow(10, Math.log10(n)), n, 0);
    }
}
