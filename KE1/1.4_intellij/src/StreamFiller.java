public class StreamFiller {
    OutputStream outputStream;

    public StreamFiller(OutputStream outputStream) {
        if (outputStream == null) {
            throw new Error("Output-Stream nicht befuellt.");
        }
        this.outputStream = outputStream;
    }

    void fillStream() {
        outputStream.writeStream("This is a");
        outputStream.writeStream(" stream.");
    }
}
