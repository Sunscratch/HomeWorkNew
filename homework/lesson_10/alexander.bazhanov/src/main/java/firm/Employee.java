package firm;

public abstract class Employee implements Payable {
  private String name;

  protected Employee(String name) {
    this.name = name;
  }
}
