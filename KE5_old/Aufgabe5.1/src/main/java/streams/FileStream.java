package streams;

import abstracts.Stream;

public class FileStream extends Stream {
  String fileName;

  public FileStream(String fileName) {
    this.fileName = fileName;
  }

  public String read() {
    // open and read file and return the string
    return "";
  }

  public void write(String content) {
    // open and write content to file

  }

}
