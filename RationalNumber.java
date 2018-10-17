public class RationalNumber extends RealNumber{
  private int numerator, denominator;
  public RationalNumber(int nume, int deno) {
    numerator = nume;
    denominator = deno;
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

  public double getN() {
    return numerator / denominator;
  }

  public String toString() {
    return "";
  }
}
