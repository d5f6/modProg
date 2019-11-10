import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public abstract class ListTest {
    protected abstract List<Object> createList();

    @Test
    public final void testAdd() {
        List<Object> list = createList();
        Object o1 = new Object();
        Object o2 = new Object();

        assertTrue(list.add(o1));
        assertTrue(list.add(o2));
    }

    @Test
    public final void testGetValidElement() {
        List<Object> list = createList();
        Object o1 = new Object();
        Object o2 = new Object();

        list.add(o1);
        assertEquals(list.get(0), o1);

        list.add(o2);
        assertEquals(list.get(0), o1);
        assertEquals(list.get(1), o2);
    }

    @Test(expected = IndexOutOfBoundsException.class )
    public final void testGetMissingElement() {
        List<Object> list = createList();
        list.get(0);
    }

    @Test
    public final void testContains() {
        List<Object> list = createList();
        Object o1 = new Object();
        Object o2 = new Object();
        assertFalse(list.contains(o1));
        assertFalse(list.contains(o2));

        list.add(o1);
        assertTrue(list.contains(o1));
        assertFalse(list.contains(o2));

        list.add(o2);
        assertTrue(list.contains(o1));
        assertTrue(list.contains(o2));
    }

    @Test
    public final void testRemove() {
        List<Object> list = createList();
        Object o1 = new Object();
        Object o2 = new Object();

        list.add(o1);
        list.add(o2);

        assertTrue(list.remove(o1));
        assertFalse(list.remove(o1));

        assertTrue(list.remove(o2));
        assertFalse(list.remove(o2));
    }
}
