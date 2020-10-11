public class StreamProcessing {
    public static void main(String[] args) {
        Stream stream = new Stream();

        StreamFiller streamFiller = new StreamFiller(stream);
        streamFiller.fillStream();

        StreamPrinter streamPrinter = new StreamPrinter();
        streamPrinter.setStream(stream);
        streamPrinter.printStream();
    }
}
