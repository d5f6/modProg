import junit.framework.TestCase;
import org.junit.Test;

public class testGetData extends TestCase {

    @Test
    public void testGetData() {
        DataGenerator generator = new DataGenerator();

        assertEquals(0, generator.getData(0));
        assertEquals(42, generator.getData(1));
        assertEquals(2 * 42, generator.getData(2));
    }

    @Test
    public void testGetDataSpeedUp() {
        DataGenerator generator = new DataGenerator();
        long before = System.currentTimeMillis();

        for (int i = 0; i < 5; i++) {
            generator.getData(i);
        }

        for (int i = 0; i < 5; i++) {
            generator.getData(0);
        }

        long after = System.currentTimeMillis();

        assertTrue((after - before) < 600);
    }
}
