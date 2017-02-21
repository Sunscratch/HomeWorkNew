package firm;

public enum PaymentPeriod {
  WEEKLY(5), BIWEEKLY(10), MONTHLY(20);

  private int numOfWorkingDays;

  private PaymentPeriod(int numOfWorkingDays) {
    this.numOfWorkingDays = numOfWorkingDays;
  }

  public int getNumOfWorkingDays() {
    return numOfWorkingDays;
  }
}
