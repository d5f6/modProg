public class Vector<T> {
    private static final int MAXIMUM_SIZE = 100;
    private Object[] elements = new Object[0];

    public void set(int index, T element) {
        assert index >= 0 && index < elements.length;
        Object[] prevElement = elements.clone();

        elements[index] = element;

        assert elements[index] == element;
        assert prevElement.length == elements.length;
    }

    public T get(int index) {
        assert index >= 0 && index < elements.length;
        return (T) elements[index];
    }

    public void extend(int size) {
        assert elements.length + size <= MAXIMUM_SIZE;
        assert size >= 0;

        Object[] prevElement = elements.clone();

        Object[] newElements = new Object[elements.length + size];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;

        assert prevElement.length == elements.length + size;
    }

    public int length() {
        return elements.length;
    }

    public void prune(int size) {
        assert elements.length >= size && size >= 0;

        Object[] prevElement = elements.clone();

        Object[] newElements = new Object[elements.length - size];
        System.arraycopy(elements, 0, newElements, 0, elements.length-size);
        elements = newElements;

        assert elements.length == prevElement.length;
    }
}
