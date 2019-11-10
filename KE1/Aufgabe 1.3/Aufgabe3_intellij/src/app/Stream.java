package app;

import app.interfaces.Applyer;
import app.interfaces.ReadStream;
import app.interfaces.WriteStream;

public class Stream implements ReadStream, WriteStream {
    private String content = "";
    int index = 0;

    public char readChar() {
        if ( index < content.length() )
            return content.charAt( index++ );
        else
            return 0;
    }

    public void writeString( String str ) {
        content += str;
    }

    public void apply(Applyer applyer) {
        for (char c : content.toCharArray()) {
            applyer.apply(c);
        }
    }
}
