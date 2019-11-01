package app;

public class StreamProcessing {

    public static void main(String[] args) {
        Stream stream = new Stream();

        StreamFiller streamFiller = new StreamFiller(stream);
        StreamPrinter streamPrinter = new StreamPrinter();

        streamFiller.fillStream();

        streamPrinter.setStream(stream);
        streamPrinter.printStream();
    }
}
