package abstracts;

import interfaces.InputStream;
import interfaces.OutputStream;
import streams.StringStream;
import streams.FileStream;

abstract public class Stream implements InputStream, OutputStream {
  public static Stream create(String source, boolean isFileStream) {
    if (!isFileStream)
      return new StringStream(source);
    if (isFileValid(source))
      return new FileStream(source);

  }

  private static boolean isFileValid(String fileName) {
    // validate file and return real result
    return true;
  }
}
