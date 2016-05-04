package org.jointheleague.ecolban.math;

import static org.junit.Assert.*;

import java.util.concurrent.ThreadLocalRandom;

import org.jointheleague.ecolban.math.Util;
import org.junit.Test;
/**
 * @author Erik Colban &copy; 2016
 */
public class UtilTest {

    @Test
    public void testIsPrime() {
        // Some prime numbers
        assertTrue(Util.isPrime(2));
        assertTrue(Util.isPrime(3));
        assertTrue(Util.isPrime(5));
        assertTrue(Util.isPrime(23));
        assertTrue(Util.isPrime(101));
        assertTrue(Util.isPrime(1000037));
        assertTrue(Util.isPrime(1000039));
        // Some numbers that are not prime
        assertFalse(Util.isPrime(-2));
        assertFalse(Util.isPrime(9));
        assertFalse(Util.isPrime(57));
        assertFalse(Util.isPrime(24));
        assertFalse(Util.isPrime(1000001));
    }

    @Test
    public void testModInv() {
        int k = 5;
        int m = 13;
        assertEquals(8, Util.modinv(k, m));
        k = 13 * 67;
        m = 13 * 101;
        try {
            Util.modinv(k, m);
            fail("An exception should have been thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Arguments are not coprime.", e.getMessage());
        }
        try {
            Util.modinv(-5, 17);
            fail("An exception should have been thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Both arguments must be positive and k < m.", e.getMessage());
        }
        //Some random tests
        for (int i = 0; i < 100; i++) {
            try {
                m = ThreadLocalRandom.current().nextInt(10000) + 1;
                k = ThreadLocalRandom.current().nextInt(m - 1) + 1;
                int n = Util.modinv(k, m);
                assertTrue(0 < k && k < m);
                assertTrue(n * k % m == 1);
            } catch (IllegalArgumentException e) {
                assertEquals("Arguments are not coprime.", e.getMessage());
            }
        }
    }

}
