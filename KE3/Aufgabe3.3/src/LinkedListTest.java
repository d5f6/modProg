import java.util.LinkedList;
import java.util.List;

public class LinkedListTest extends ListTest {

    @Override
    protected List<Object> createList() {
        return new LinkedList<Object>();
    }
}
