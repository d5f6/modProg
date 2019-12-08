public class B {
  private final A delegatee = new A();

  public void f() {}

  public int g() {
    return delegatee.getI();
  }
}
