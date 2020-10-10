package streams;

import abstracts.Stream;

public class StringStream extends Stream {
  String content;

  public StringStream(String content) {
    this.content = content;
  }

  public String read() {
    return this.content;
  }

  public void write(String content) {
    this.content = content;
  }
}
