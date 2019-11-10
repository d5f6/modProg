package app;

public class StreamProcessing {
  public static void main(String[] args) {
    Stream stream = new Stream();

    StreamFiller.fillStream(stream);
    StreamPrinter.printStream(stream);
  }
}