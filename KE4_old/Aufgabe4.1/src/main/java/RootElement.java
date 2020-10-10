public class RootElement extends FileSystemContainer {

  String name;

  public RootElement(String name) {
    super(name);
  }

  @Override
  public void open() {
    System.out.println("Open root element " + name);
  }

  @Override
  public void move(FileSystemContainer target) {
    throw new Error("root element cannot be moved");
  }

  @Override
  public void delete() {
    throw new Error("root element cannot be moved");
  }

  public void format() {
    while(!children.isEmpty()) {
      children.get(0).delete();
    }
  }

  public void test() {

  }
}

