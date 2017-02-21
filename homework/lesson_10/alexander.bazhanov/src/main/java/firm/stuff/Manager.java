package firm.stuff;

import firm.Employee;

import firm.Payable;

import firm.PaymentPeriod;

public class Manager extends FixedRateEmployee {
  private float bonus;

  public Manager(String name, float dailySalary, PaymentPeriod period) {
    super(name, dailySalary, period);
  }

  public void setBonus(float bonus) {
    this.bonus = bonus;
  }

  public float calculatePayment() {
    return calculateFullPeriod() * dailySalary + bonus;
  }
}
