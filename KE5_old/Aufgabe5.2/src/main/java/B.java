public class B {
  protected final Delegatee delegatee = new Delegatee();

  public void f() {

  }

  public void g() {

  }

  protected class Delegatee extends A {
    public void g() {
      B.this.g();
    }

    public void f() {
      B.this.f();
    }
  }
}
