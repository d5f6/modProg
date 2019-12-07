package composite;

public class Group extends FileSystemContainer {

  public Group(String name) {
    super(name);
  }

  @Override
  public void open() {
    for(FileSystemElement element : children) {
      element.open();
    }
  }

  @Override
  public void move(FileSystemContainer target) {
    throw new Error("Groups cannot be moved.");
  }

  @Override
  public void delete() {
    parent.remove(this);
    System.out.println("Deleted group: " + name);
  }

  @Override
  public void add(FileSystemElement element) {
    if (parent != element.getParent()) {
      throw new Error("Only elements in the same container can be grouped together.");
    } else {
      children.add(element);
    }
  }

  @Override
  public void remove(FileSystemElement element) {
    children.remove(element);
  }
}
