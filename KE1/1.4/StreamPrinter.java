public class StreamPrinter {
    InputStream inputStream;

    public void printStream() {
        if (inputStream == null) {
            throw new Error("Input-Stream nicht befuellt.");
        }

        inputStream.apply(new Applicator() {
            @Override
            public void apply(char ch) {
                System.out.print(ch);
            }
        });
    }

    public void setStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}
