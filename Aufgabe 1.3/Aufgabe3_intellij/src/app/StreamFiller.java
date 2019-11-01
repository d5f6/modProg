package app;

import app.interfaces.WriteStream;

public class StreamFiller {
    WriteStream writeStream;

    public StreamFiller(WriteStream writeStream) {
        if (writeStream == null) {
            throw new NullPointerException("No stream object found");
        }
        this.writeStream = writeStream;
    }

    public void fillStream() {
        writeStream.writeString( "\nThis is a" );
        writeStream.writeString( " stream.\n" );
    }
}
