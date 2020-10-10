package composite;

import java.util.Arrays;
import java.util.LinkedList;

public class FileSystem {

  private static LinkedList<RootElement> roots = new LinkedList<>();

  // factory
  static public FileSystemElement createNewElement(String path) {
    LinkedList<String> where = new LinkedList<String>(Arrays.asList(path.split("\\|")));

    if (where.getFirst().equals("")) {
      where.removeFirst();
    }

    //check for root
    if (where.size() == 1) {
      if (path.contains(".")) {
        throw new Error("No files as root elements allowed!");
      } else {
        RootElement root = new RootElement(where.getFirst());
        insertRoot(root);
        return root;
      }
    }

    FileSystemElement element;

    if (path.contains(".")) {
      element = new File(where.getLast().substring(1));
    } else if (path.contains(",")) {
      element = new Group(where.getLast().substring(1));
    } else {
      element = new Folder(where.getLast());
    }

    where.removeLast();
    insertElement(element, where);

    return element;
  }

  // Methods
  static public void insertRoot(RootElement newRoot) {
    for (RootElement root : roots) {
      if (root.getName().equals(newRoot.getName())) {
        throw new Error("Root element with the same name already exists");
      }
    }
    roots.add(newRoot);
  }

  static public void insertElement(FileSystemElement element, LinkedList<String> where) {
    for (RootElement root : roots) {
      if (root.getName().equals(where.getFirst())) {
        where.removeFirst();
        root.insert(element, where);
        return;
      }
    }
    throw new Error("Missing root: " + where.getFirst());
  }

}
