import java.util.ArrayList;
import java.util.List;

public class ArrayListTest extends ListTest {

    @Override
    protected List<Object> createList() {
        return new ArrayList<Object>();
    }
}
