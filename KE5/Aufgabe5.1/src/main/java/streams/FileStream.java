package streams;

import abstracts.Stream;

public class FileStream extends Stream {
  String fileName;

  public FileStream(String fileName) {
    this.fileName = fileName;
  }


}
