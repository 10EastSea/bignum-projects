# Bignum Projects

1. Extended Euclidean Algorithm
2. Inverse Algorithm
3. Square and Multiply Algorithm
4. Miller-Rabin Primality Algorithm

> This program provides the values in { .. }

<br />

## 1. Extended Euclidean Algorithm

If you enter `x` and `y`, this program provides a polynomial of the numbers and the greatest common divisor.

    gcd(x, y) = ({a}) * x + ({b}) * y = {GCD value}

- `x` :  Number 1
- `y` :  Number 2

Reference: [Extended Euclidean Algorithm in Wikipedia](https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm)

<br />

## 2. Inverse Algorithm

Using the Extended Euclidean Algorithm, this program provides the inverse of x when the GCD value of `N` and `x` are 1.

    Inverse of x is {Inverse}(or {Another Inverse}) in Z N Group    (gcd(N, x) == 1)
    x doesn't have inverse in Z N Group.                            (gcd(N, x) != 1)
    N must be greater than x                                        (N <= x)

- `N` :  Number to create a range of Z group
- `x` :  Number to find inverse

<br />

## 3. Square and Multiply Algorithm

If you enter `g` and `x`, this program provides an exponentiation value using squaring.

    {g^x}

- `g` :  Base number
- `x` :  Exponent number

<!-- Reference: [Exponentiation by squaring in Wikipedia](https://en.wikipedia.org/wiki/Exponentiation_by_squaring) -->

<br />

## 4. Miller-Rabin Primality Algorithm

If you enter `nBits`, this program provides a prime number using Miller-Rabin primality test. Of course, this number may not be a prime number. However, it will be a prime number with a very high probability.

    {n bits prime number}

- `nBits` :  Number of bits

Reference: [Miller–Rabin primality test in Wikipedia](https://en.wikipedia.org/wiki/Miller-Rabin_primality_test)

<br />

# Usage

```Bash
# java version: openjdk 11.0.11
java -jar bignum-projects.jar [FALG]
```

### Kind of FLAG
- `-ee <x> <y>`  : Extended Euclidean Algorithm
- `-i <N> <x>`   : Inverse Algorithm
- `-sm <g> <x>`  : Square and Multiply Algorithm
- `-mrp <nBits>` : Miller-Rabin Primality Algorithm
- `-help`        : How to use it

### Example
```Bash
# Extended Euclidean Algorithm
>> java -jar bignum-projects.jar -ee 18 12
gcd(18, 12) = (1) * 18 + (-1) * 12 = 6

# Inverse Algorithm
>> java -jar bignum-projects.jar -i 100 23
Inverse of 23 is -13(or 87) in Z 100 Group

# Square and Multiply Algorithm
>> java -jar bignum-projects.jar -sm 3 53 
19383245667680019896796723

# Miller-Rabin Primality Algorithm
>> java -jar bignum-projects.jar -mrp 128
323083159249441350447249179717126795111
```
