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
}
