import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void testExtendLength() {
        Vector<String> vector = new Vector<String>();

        assertEquals(vector.length(), 0);

        vector.extend(2);
        assertEquals(vector.length(), 2);

        vector.extend(4);
        assertEquals(vector.length(), 4);

    }

}
