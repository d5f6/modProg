public abstract class FileSystemElement {

  String name;
  FileSystemContainer parent = null;

  // abstrakten Methoden
  public abstract void open();

  public abstract void move(FileSystemContainer target);

  public abstract void delete();

  // constructor
  public FileSystemElement(String name) {
    this.name = name;
  }

  // methods
  public String getName() {
    return this.name;
  }

  public FileSystemContainer getParent() {
    return this.parent;
  }

  public void setParent(FileSystemContainer parent) {
    this.parent = parent;
  }

}
