package firm.stuff;

import firm.Employee;

import firm.Payable;

public class Volunteer extends Employee {
  int workingHours;

  public Volunteer(String name) {
    super(name);
  }

  public void setWorkingHours(int workingHours) {
    this.workingHours = workingHours;
  }

  public float calculatePayment() {
    return 0;
  }

}
