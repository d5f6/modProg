package streams;

import abstracts.Stream;

public class NullStream extends Stream {

  public NullStream() {}

  public String read() {
    return "";
  }

  public void write(String content) {}

}
