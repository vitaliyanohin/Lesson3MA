public class ComplexNumber {
  private final double re;
  private final double im;

  public ComplexNumber(double re, double im) {
    this.re = re;
    this.im = im;
  }

  @Override
  public boolean equals(Object object) {
    ComplexNumber complexNumberObj = (ComplexNumber) object;
    if (object == null) return false;
    if (this == object) return true;
    if (this.re == complexNumberObj.re & this.im == complexNumberObj.im) return true;
    return false;
  }

  @Override
  public int hashCode() {
    double result;
    result = 31 * (re * 1000) + 31 * (im * 1000);
    return (int) result;
  }
}
