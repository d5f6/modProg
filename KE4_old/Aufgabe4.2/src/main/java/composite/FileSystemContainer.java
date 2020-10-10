package composite;

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

  public void insert(FileSystemElement element, LinkedList<String> where) {
    if (element instanceof RootElement)
      throw new Error("Root elements not as part of containers allowed");

    // if the path is empty, insert the element here
    if (where.isEmpty()) {
      for (FileSystemElement child : children) {
        if (child.getName().equals(element.getName())) {
          throw new Error("Element with the name " + element.getName() + " already exists in " + getName() + "!");
        }
      }
      children.add(element);
      element.setParent(this);
      return;
    }

    // if some path is left, try to step into the next element
    for (FileSystemElement child : children) {
      if (child.getName().equals(where.getFirst())) {
        where.removeFirst();
        child.insert(element, where);
        return;
      }
    }

    // if no element has been found, create a new folder and the retry to insert the element
    Folder folder = new Folder(where.getFirst());
    folder.setParent(this);
    children.add(folder);

    insert(element, where);
  }
}
