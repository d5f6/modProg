package app;

import app.interfaces.Applyer;
import app.interfaces.ReadStream;

public class StreamPrinter {
    ReadStream readStream;

    public void setStream(ReadStream readStream) {
        this.readStream = readStream;
    }

    public void printStream() {
        if (readStream == null) {
            throw new NullPointerException("No stream object found");
        }

        readStream.apply(new Applyer() {
            @Override
            public void apply(char c) {
                System.out.print(c);
            }
        });

        char ch = readStream.readChar();

        while ( ch != 0 ) {
            System.out.print( ch );
            ch = readStream.readChar();
        }
    }
}
