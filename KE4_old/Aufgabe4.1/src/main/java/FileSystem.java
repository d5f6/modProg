import java.util.LinkedList;

public class FileSystem {

  private static LinkedList<RootElement> roots = new LinkedList<RootElement>();

  static public void insertRoot(RootElement newRoot) {
    for (RootElement root : roots) {
      if (root.getName().equals(newRoot.getName())) {
        throw new Error("root element with same name already exists");
      }
    }
    roots.add(newRoot);
  }
}
