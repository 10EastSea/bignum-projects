import java.math.BigInteger; // Immutable class

public class App {
    
    /*
     *  BigNum 라이브러리를 사용하여 구현
     *
     *  1. Extended Euclidean algorithm
     *  2. Inverse 구하는 algorithm
     *  3. 지수승 (Square and multiply) algorithm
     *  4. Miller-Rabin primality test algorithm
     */

    public static void test1() {
        ExtendedEuclidean ee = new ExtendedEuclidean(new BigInteger("18"), new BigInteger("12"));
        System.out.println(ee.toString());
    }
    public static void test2() {
        Inverse i = new Inverse(new BigInteger("100"), new BigInteger("23"));
        System.out.println(i.toString());
    }
    public static void test3() {
        SquareAndMultiply sm = new SquareAndMultiply(new BigInteger("3"), new BigInteger("53"));
        System.out.println(sm.toString());
    }
    public static void test4() {
        MillerRabinPrimality mrp = new MillerRabinPrimality(1024);
        System.out.println(mrp.toString());
    }

    public static void main(String[] args) throws Exception {
        // test1();
        // test2();
        // test3();
        test4();
    }   
}
