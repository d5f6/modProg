import org.junit.Test;
import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void testExtendMethod() {
        Vector<String> v = new Vector<>();

        assertEquals(v.length(), 0);

        v.extend(2);
        assertEquals(v.length(), 2);

        v.extend(4);
        assertEquals(v.length(), 6);
    }

    @Test(expected = AssertionError.class)
    public void testExtendAboveLimit() {
        Vector<String> v = new Vector<>();
        v.extend(101);
    }

    @Test
    public void testExtendLimit() {
        Vector<String> v = new Vector<>();
        v.extend(100);
    }

    @Test
    public void testSet() {
        Vector<String> v = new Vector<>();
        v.extend(10);
        v.set(0, "Element");
    }

    @Test
    public void testGet() {
        Vector<String> v = new Vector<>();
        v.extend(10);
        v.set(0, "Element");
        assertEquals("Element", v.get(0));
    }

    @Test(expected = AssertionError.class)
    public void testSetWithoutExtend() {
        Vector<String> v = new Vector<>();
        v.set(0, "Element");
    }

    @Test(expected = AssertionError.class)
    public void testGetWithoutElements() {
        Vector<String> v = new Vector<>();
        v.get(0);
    }

    @Test
    public void testGetAndSetElements() {
        Vector<String> v = new Vector<>();
        final int ELEMENTS = 10;

        v.extend((ELEMENTS));

        for (int i = 0; i < ELEMENTS; i++) {
            v.set(i, "Element " + i);
        }

        for (int i = 0; i < ELEMENTS; i++) {
            assertEquals("Element " + i, v.get(i));
        }
    }

    @Test(expected = AssertionError.class)
    public void testAssertionEnabledTest() {
        assert false: "Kommandozeilenparameter -ea sind nicht eingeschaltet";
    }
}
