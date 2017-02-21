package firm.stuff;

import firm.Employee;

import firm.Payable;

public class HourlyRateEmployee extends Employee {
  private float hourlySalary;
  private int workingHours;

  public HourlyRateEmployee(String name, float hourlySalary) {
    super(name);
    this.hourlySalary = hourlySalary;
  }

  public void setWorkingHours(int workingHours) {
    this.workingHours = workingHours;
  }

  public float calculatePayment() {
    return workingHours * hourlySalary;
  }
}
