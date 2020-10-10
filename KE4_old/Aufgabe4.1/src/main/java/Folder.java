public class Folder extends FileSystemContainer {

  public Folder(String name) {
    super(name);
  }

  @Override
  public void open() {
    System.out.println("Opening folder: " + name);
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
    while (!children.isEmpty()) {
      children.get(0).delete();
    }

    if (parent != null) {
      parent.remove(this);
    }
    System.out.println("Deleted folder: " + name);
  }
}
