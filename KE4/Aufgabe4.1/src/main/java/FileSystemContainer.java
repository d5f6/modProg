import java.util.LinkedList;
import java.util.List;

abstract class FileSystemContainer extends FileSystemElement {

  List<FileSystemElement> children = new LinkedList<FileSystemElement>();

  // constructor
  public FileSystemContainer(String name) {
    super(name);
  }

  // methods
  public void add(FileSystemElement element) {
    if (element instanceof RootElement) {
      throw new Error("root elements cannot be part of a container");
    }

    if (element.getParent() != null) {
      throw new Error("Element " + element.getName() + " already has a parent");
    }

    if (!children.contains(element)) {
      element.setParent(this);
      children.add(element);
    }
  }

  public void remove(FileSystemElement element) {
    element.setParent(null);
    children.remove(element);
  }
}
