import java.util.List;
import java.util.Stack;

public class StackTest extends ListTest {
    @Override
    protected List<Object> createList() {
        return new Stack<Object>();
    }
}
