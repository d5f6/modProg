public class DataGenerator {
    private static final int MAGIC_NUMBER = 42;

    public int getData(int i) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
        return i * MAGIC_NUMBER;
    }
}
