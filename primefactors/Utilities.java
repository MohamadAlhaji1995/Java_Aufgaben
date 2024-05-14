package oop.primefactors;

import java.util.ArrayList;
import java.util.List;

public class Utilities
{
    public static List<Integer> getPrimeFactors(int n)
    {
        if (n <= 0)
        {
            throw new IllegalArgumentException("Input must be greater than zero.");
        }
        if (n == 1)
        {
            return new ArrayList<>();
        }

        List<Integer> factors = new ArrayList<>();
        for (int factor = 2; factor <= n / 2; factor++)
        {
            while (n % factor == 0)
            {
                factors.add(factor);
                n /= factor;
            }
        }
        if (n > 1)
        {
            factors.add(n);
        }
        return factors;
    }

    public static int gcd(int a, int b)
    {
        if (a <= 0 || b <= 0)
        {
            throw new IllegalArgumentException("Both numbers must be greater than zero.");
        }

        List<Integer> factorsA = getPrimeFactors(a);
        List<Integer> factorsB = getPrimeFactors(b);

        List<Integer> commonFactors = new ArrayList<>();
        for (Integer factor : factorsA)
        {
            if (factorsB.contains(factor))
            {
                commonFactors.add(factor);
                factorsB.remove(factor);
            }
        }

        int gcd = 1;
        for (Integer factor : commonFactors)
        {
            gcd *= factor;
        }
        return gcd;
    }

    public static int lcm(int a, int b)
    {
        if (a <= 0 || b <= 0)
        {
            throw new IllegalArgumentException("Both numbers must be greater than zero.");
        }
        return a * (b / gcd(a, b));
    }

    public static void main(String[] args)
    {
        // Test getPrimeFactors
        System.out.println("Prime factors of 24: " + Utilities.getPrimeFactors(24));
        System.out.println("Prime factors of 29: " + Utilities.getPrimeFactors(29));
        System.out.println("Prime factors of 150: " + Utilities.getPrimeFactors(150));

        // Test gcd
        System.out.println("GCD of 24 and 36: " + Utilities.gcd(24, 36));
        System.out.println("GCD of 100 and 75: " + Utilities.gcd(100, 75));

        // Test lcm
        System.out.println("LCM of 8 and 12: " + Utilities.lcm(8, 12));
        System.out.println("LCM of 21 and 6: " + Utilities.lcm(21, 6));
    }
}
