package composite;

import java.util.LinkedList;

public class File extends FileSystemElement {

  public File(String name) {
    super(name);
  }

  @Override
  public void open() {
    System.out.println("Opening file: " + name);
  }

  @Override
  public void move(FileSystemContainer target) {
    if (parent != null) {
      parent.remove(this);
    }
    target.add(this);
  }

  @Override
  public void delete() {
    if (parent != null) {
      parent.remove(this);
    }
    System.out.println("Deleted file: " + name);
  }

  @Override
  public void insert(FileSystemElement element, LinkedList<String> where) {
    throw new Error("Files cannot contain elements!");
  }
}
