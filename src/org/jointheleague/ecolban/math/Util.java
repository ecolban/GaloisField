package org.jointheleague.ecolban.math;

/**
 * @author Erik Colban &copy 2016
 */
public class Util {
    private Util() {

    }

    /**
     * @param p
     *            an int
     * @return true if p is a prime number
     */
    public static boolean isPrime(int p) {
        if (p == 2) {
            return true;
        }
        if (p < 2 || p % 2 == 0) {
            return false;
        }
        for (int d = 3; d <= Math.sqrt(p); d += 2) {
            if (p % d == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param k
     *            a positive int
     * @param m
     *            a positive int greater than k and coprime with k
     * @return n such that 0 < n < m and k * n % m == 1
     */
    public static int modinv(int k, int m) {
        if (!(0 < k && k < m)) {
            throw new IllegalArgumentException("Both arguments must be positive and k < m.");
        }
        int m0 = m;
        int x0 = 0;
        int x1 = 1;
        while (k > 0) {
            int q = m / k;
            int r = m % k;
            m = k;
            k = r;
            int tmp = x1;
            x1 = x0 - x1 * q;
            x0 = tmp;
        }
        if (m != 1) {
            throw new IllegalArgumentException("Arguments are not coprime.");
        }
        return x0 >= 0 ? x0 : m0 + x0;

    }
}
