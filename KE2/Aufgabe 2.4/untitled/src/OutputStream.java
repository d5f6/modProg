abstract class OutputStream {
    void write(Data data) {
        // @pre (this instance of ConsoleOutput &&
        if (data instanceof Text) {
            write((Text) data);
        } else if (data instanceof Picture) {
            write((Picture) data);
        }
    }
}
