import java.math.BigInteger;

public class SquareAndMultiply {
    private BigInteger g, x; // g: base, x: exponent
    private BigInteger gOfx; // g^x

    public SquareAndMultiply(BigInteger g, BigInteger x) {
        this.g = g;
        this.x = x;
        sma();
    }

    private void sma() {
        StringBuilder bStr = new StringBuilder(x.toString(2));
        BigInteger y = g, z = BigInteger.ONE;

        while(bStr.length() > 0) {
            char b = bStr.charAt(bStr.length() - 1);
            
            if(b == '1') z = z.multiply(y);
            y = y.multiply(y);

            bStr.deleteCharAt(bStr.length() - 1);
        }

        gOfx = z;
    }

    public BigInteger getgOfX() { return gOfx; }

    public String toString() {
        return gOfx.toString();
    }
}
