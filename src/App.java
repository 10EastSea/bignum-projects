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

    public static boolean checkDigits(String s) {
        for(int i=0; i<s.length(); i++) {
            if(Character.isDigit(s.charAt(i)) == false) return false;
        }
        return true;
    }

    public static void help(String msg) {
        System.out.println("\n" + msg + "\n");
        System.out.println("    -ee <x> <y>  : Extended Euclidean Algorithm     => gcd(x, y) = ({a}) * x + ({b}) * y = {GCD value}");
        System.out.println("    -i <N> <x>   : Inverse Algorithm                => Inverse of x is {Inverse}(or {Another Inverse}) in Z N Group");
        System.out.println("    -sm <g> <x>  : Square and Multiply Algorithm    => {g^x}");
        System.out.println("    -mrp <nBits> : Miller-Rabin Primality Algorithm => {n bits prime number}");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        if(args.length < 1) { help("Please enter the [FLAG]\nThe following flag provides the values in { .. }"); return; }

        if(args[0].equals("-ee")) {
            if(args.length < 3) { help("[-ee]: Please enter the <x> and <y>"); return; }
            if(checkDigits(args[1]) && checkDigits(args[2])) {
                ExtendedEuclidean ee = new ExtendedEuclidean(new BigInteger(args[1]), new BigInteger(args[2]));
                System.out.println(ee.toString());
            } else { help("[-ee]: <x> and <y> must be number"); return; }
        } else if(args[0].equals("-i")) {
            if(args.length < 3) { help("[-i]: Please enter the <N> and <x>"); return; }
            if(checkDigits(args[1]) && checkDigits(args[2])) {
                Inverse i = new Inverse(new BigInteger(args[1]), new BigInteger(args[2]));
                System.out.println(i.toString());
            } else { help("[-i]: <N> and <x> must be number"); return; }
        } else if(args[0].equals("-sm")) {
            if(args.length < 3) { help("[-sm]: Please enter the <g> and <x>"); return; }
            if(checkDigits(args[1]) && checkDigits(args[2])) {
                SquareAndMultiply sm = new SquareAndMultiply(new BigInteger(args[1]), new BigInteger(args[2]));
                System.out.println(sm.toString());
            } else { help("[-sm]: <g> and <x> must be number"); return; }
        } else if(args[0].equals("-mrp")) {
            if(args.length < 2) { help("[-mrp]: Please enter the <nBits>"); return; }
            if(checkDigits(args[1])) {
                MillerRabinPrimality mrp = new MillerRabinPrimality(Integer.parseInt(args[1]));
                System.out.println(mrp.toString());
            } else { help("[-mrp]: <nbits> must be number"); return; }
        }
        else if(args[0].equals("-help")) { help("Usage: java -jar bignum-projects.jar [FALG]\nThe following flag provides the values in { .. }"); return; }
        else { help("This [FLAG] does not exist\nThe following flag provides the values in { .. }"); return; }
    }   
}
