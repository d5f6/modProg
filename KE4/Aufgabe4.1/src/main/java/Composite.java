public class Composite {
  public static void main(String[] args) {
    RootElement root = new RootElement("root");

    Folder folder1 = new Folder("main.java.Folder 1");
    Folder folder2 = new Folder("main.java.Folder 2");
    Folder folder3 = new Folder("main.java.Folder 3");

    File file1 = new File("main.java.File 1");
    File file2 = new File("main.java.File 2");
    File file3 = new File("main.java.File 3");

    root.add(folder1);
    root.add(folder2);
    root.add(folder3);

    root.add(file1);
    folder1.add(file2);
    folder2.add(file3);

    Group group1 = new Group("main.java.Group 1");
    root.add(group1);

    group1.add(folder1);
    group1.add(folder2);
    group1.add(file1);

    root.open();

    folder1.move(folder2);

    folder2.delete();
    group1.delete();

    root.format();
  }
}
