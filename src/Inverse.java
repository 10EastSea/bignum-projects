import java.math.BigInteger;

public class Inverse extends ExtendedEuclidean {
    private BigInteger N, x; // Zn Group Number: N, Number: x
    private BigInteger xInv, xAnotherInv; // Inverse of x
    private boolean isExist = false, nGreaterThanX = false;

    public Inverse(BigInteger N, BigInteger x) {
        super(N, x);

        this.N = N;
        this.x = x;

        if(N.compareTo(x) <= 0) { // N < x
            nGreaterThanX = true;
            xInv = null;
            xAnotherInv = null;
        } else if(getGcd().compareTo(BigInteger.ONE) == 0) { // For inverse to exist, gcd must be 1
            isExist = true;
            if(getB().compareTo(BigInteger.ZERO) < 0) { // inverse is negative
                xInv = getB();
                xAnotherInv = getB().add(getX());
            } else { // inverse is positive
                xInv = getB();
                xAnotherInv = getB().subtract(getX());
            }
        } else {
            xInv = null;
            xAnotherInv = null;
        }
    }

    public String toString() {
        if(isExist) return "Inverse of " + x.toString() + " is " + xInv.toString() + "(or " + xAnotherInv.toString() + ") in Z " + N.toString() + " Group";
        else {
            if(nGreaterThanX) return "N must be greater than x";
            else return x.toString() + " doesn't have inverse in Z " + N.toString() + " Group";
        }
    }
}