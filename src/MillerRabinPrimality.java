import java.math.BigInteger;
import java.util.Random;

public class MillerRabinPrimality {
    private int nBits;
    private BigInteger prime;

    public MillerRabinPrimality(int nBits) {
        this.nBits = nBits;
        do {
            prime = generateNBitsNumber();
            // System.out.println("Candidate Prime: " + prime);
        } while(!checkPrime());
    }

    private BigInteger generateNBitsNumber() {
        BigInteger candidateP = new BigInteger(nBits, new Random());

        while(true) {
            // 1. Check length is nBits
            if(candidateP.bitLength() != nBits) {
                candidateP = new BigInteger(nBits, new Random());
                continue;
            }
            // 2. Check it is not even number
            if(nBits > 2) {
                char lastNum = candidateP.toString().charAt(candidateP.toString().length() - 1);
                if(lastNum == '0' || lastNum == '2' || lastNum == '4' || lastNum == '6' || lastNum == '8') {
                    candidateP = new BigInteger(nBits, new Random());
                    continue;
                }
            }
            
            break;
        }
        
        return candidateP;
    }

    private boolean checkPrime() {
        boolean isPrime = true;

        int s = 0;
        BigInteger d = prime.subtract(BigInteger.ONE);
        while(d.remainder(BigInteger.TWO) == BigInteger.ZERO) {
            d = d.divide(BigInteger.TWO);
            s++;
        }

        // Check tmp
        // BigInteger tmp = BigInteger.TWO.pow(s).multiply(d);
        // System.out.println("s: " + s + " / prime: " + prime.toString() + " / " + prime.toString().equals(tmp.add(BigInteger.ONE).toString()));

        // Skip the real prime
        if(prime.compareTo(new BigInteger("2")) == 0 || prime.compareTo(new BigInteger("3")) == 0 || prime.compareTo(new BigInteger("5")) == 0 || prime.compareTo(new BigInteger("7")) == 0
            || prime.compareTo(new BigInteger("11")) == 0 || prime.compareTo(new BigInteger("13")) == 0 || prime.compareTo(new BigInteger("17")) == 0 || prime.compareTo(new BigInteger("19")) == 0
            || prime.compareTo(new BigInteger("23")) == 0 || prime.compareTo(new BigInteger("29")) == 0 || prime.compareTo(new BigInteger("31")) == 0 || prime.compareTo(new BigInteger("37")) == 0) {
            return true;
        }

        for(BigInteger a = BigInteger.TWO; a.compareTo(new BigInteger("40")) <= 0; a = a.add(BigInteger.ONE)) {
            // 1. Check a^d == 1
            BigInteger aOfd = a.modPow(d, prime);
            if(aOfd.compareTo(BigInteger.ONE) == 0) continue;

            // 2. Check a^(2^r * d) == -1(or prime-1)
            int r = 0;
            for( ; r < s; r++) {
                BigInteger aOf_ = a.modPow(BigInteger.TWO.pow(r).multiply(d), prime);
                if(aOf_.compareTo(prime.subtract(BigInteger.ONE)) == 0) break;
            }
            if(r != s) continue;

            isPrime = false;
            break;
        }

        return isPrime;
    }

    public String toString() {
        return prime.toString();
        // return prime.toString() + " / " + prime.isProbablePrime(60);
    }
}
