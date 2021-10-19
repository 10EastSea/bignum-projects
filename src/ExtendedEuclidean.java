import java.math.BigInteger;

public class ExtendedEuclidean {
    private BigInteger x, y; // Two Number: x, y
    private BigInteger a, b; // gcd(x,y) = a*x + b*y
    private BigInteger gcd;

    public ExtendedEuclidean(BigInteger x, BigInteger y) {
        if(x.compareTo(y) >= 0) { // x >= y
            this.x = x;
            this.y = y;
        } else { // x < y
            this.x = y;
            this.y = x;
        }
        eea();
    }

    private void eea() {
        BigInteger r1 = x, r2 = y;
        BigInteger s1 = BigInteger.ONE, s2 = BigInteger.ZERO;
        BigInteger t1 = BigInteger.ZERO, t2 = BigInteger.ONE;

        BigInteger q, r, s, t;
        while(r2.compareTo(BigInteger.ZERO) > 0) {
            q = r1.divide(r2);
            r = r1.remainder(r2);
            r1 = r2; r2 = r;

            s = s1.subtract(q.multiply(s2));
            s1 = s2; s2 = s;

            t = t1.subtract(q.multiply(t2));
            t1 = t2; t2 = t;
        }

        gcd = r1;
        a = s1;
        b = t1;
    }

    public BigInteger getX() { return x; }
    public BigInteger getY() { return y; }
    public BigInteger getA() { return a; }
    public BigInteger getB() { return b; }
    public BigInteger getGcd() { return gcd; }

    public String toString() {
        return "gcd(" + x.toString() + ", " + y.toString() + ") = (" + a.toString() + ") * " + x.toString() + " + (" + b.toString() + ") * " + y.toString() + " = " + gcd.toString();
    }
}
