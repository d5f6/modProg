import composite.FileSystem;
import composite.RootElement;

public class Factory {
  public static void main(String[] args) {

    RootElement root = (RootElement) FileSystem.createNewElement("c");
    FileSystem.createNewElement("c|folder1");
    FileSystem.createNewElement("c|folder2");

    FileSystem.createNewElement("c|folder1|.file1");
    FileSystem.createNewElement("c|folder1|;group1");
    FileSystem.createNewElement("c|folder1|folder2|.file2");
    FileSystem.createNewElement("c|folder3_1|.file3");

    root.format();
  }
}
