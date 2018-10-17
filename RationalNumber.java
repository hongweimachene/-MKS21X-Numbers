public class RationalNumber extends RealNumber{
  private int numerator, denominator;
  public RationalNumber(int nume, int deno) {
    if (deno == 0) {
      numerator = 0;
      denominator = 1;
    }
    numerator = nume;
    denominator = deno;
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

  public double getN() {
    return numerator / (double) denominator;
  }

  public String toString() {
    return "";
  }
  private static int gcd(int a, int b) {
    int s = 0;
    int r = 1;
    if (a < b) {
      s = a;
      a = b;
      b = s;
    }
    while (r != 0) {
      r = a % b;
      if (r == 0){
        return b;
      }
      a = b;
      b = r;
    }
  }
  private void reduce() {
    int numer = getNumer();
    numerator = numerator / gcd(numer, denominator);
    denominator = denominator / gcd(numer, denominator);
  }
  


}
