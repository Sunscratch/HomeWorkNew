package firm.stuff;

import firm.Employee;

import firm.Payable;

import firm.PaymentPeriod;

public class FixedRateEmployee extends Employee {
  protected float dailySalary;
  protected PaymentPeriod period;
  protected int workingHours;

  public FixedRateEmployee(String name, float dailySalary, PaymentPeriod period) {
    super(name);
    this.dailySalary = dailySalary;
    this.period = period;
  }

  public void setWorkingHours(int workingHours) {
    this.workingHours = workingHours;
  }

  public float calculatePayment() {
    return calculateFullPeriod() * dailySalary;
  }

  protected int calculateFullPeriod() {
    return period.getNumOfWorkingDays() * (numOffFullDaysAtWork() / period.getNumOfWorkingDays());
  }

  protected int numOffFullDaysAtWork() {
    return workingHours / WORKING_HOURS_PER_DAY;
  }
}
