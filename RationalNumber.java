public class RationalNumber extends RealNumber{
  private int numerator, denominator;
  public RationalNumber(int nume, int deno) {
    super(0.0);
    if (deno == 0) {
      numerator = 0;
      denominator = 1;
    } else {
      numerator = nume;
      denominator = deno;
    }
    reduce();
  }

  public int getNumer() {
    return numerator;
  }

  public int getDeno() {
    return denominator;
  }

  public RationalNumber reciprocal() {
    return new RationalNumber(denominator, numerator);
  }

  public boolean equals(RationalNumber other) {
    return numerator == other.getNumer() && denominator == other.getDeno();
  }

  public double getValue() {
    return numerator / (double) denominator;
  }

  private static int gcd(int a, int b) {
    int x = Math.max(Math.abs(a), Math.abs(b));
    int y = Math.min(Math.abs(a), Math.abs(b));
    if (y == 0) {
      return x;
    } else {
      return gcd(y, x % y);
    }
  }

  private void reduce() {
    int numer = getNumer();
    numerator = numerator / gcd(numer, denominator);
    denominator = denominator / gcd(numer, denominator);
  }

  public RationalNumber add(RationalNumber other) {
    RationalNumber x = new RationalNumber(
    this.getNumer() * other.getDeno() +
    other.getNumer() * this.getDeno(),
    this.getDeno() * other.getDeno()
    );
    return x;
  }

  public RationalNumber subtract(RationalNumber other) {
    RationalNumber x = new RationalNumber(
    this.getNumer() * other.getDeno() -
    other.getNumer() * this.getDeno(),
    this.getDeno() * other.getDeno()
    );
    return x;
  }

  public RationalNumber multiply(RationalNumber other) {
    RationalNumber x = new RationalNumber(
    this.getNumer() * other.getNumer(),
    this.getDeno() * other.getDeno()
    );
    return x;
  }

  public RationalNumber divide(RationalNumber other) {
    return this.multiply(other.reciprocal());
  }

  public String toString() {
    if (denominator == 1 || numerator == 0) {
      return ""+numerator;
    }
    if ((denominator < 0 && numerator > 0) || (denominator < 0 && numerator < 0)) {
      return -1 * numerator + "/" + -1 * denominator;
    }
    return numerator + "/" + denominator;
  }
}
