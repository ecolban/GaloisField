package org.jointheleague.ecolban.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class GaloisFieldTest {

    @Test
    public void testConstructor() {
        GaloisField gf = new GaloisField(13);
        assertNotNull(gf);
        assertEquals(13, gf.getOrder());
        assertNotNull(gf.ZERO);
        assertNotNull(gf.ONE);
        try {
            new GaloisField(12);
            fail("An exception should have been thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("12 is not prime.", e.getMessage());
        }
    }

    @Test
    public void testNumConstructor() {
        GaloisField gf = new GaloisField(13);
        GaloisField.Num a = gf.getNum(0);
        GaloisField.Num b = gf.getNum(-3);
        GaloisField.Num c = gf.getNum(100);
        assertEquals(0, a.getRep());
        assertEquals(10, b.getRep());
        assertEquals(9, c.getRep());
    }

    @Test
    public void testGetValues() {
        GaloisField gf = new GaloisField(13);
        GaloisField.Num[] expected = new GaloisField.Num[13];
        for (int i = 0; i < 13; i++) {
            expected[i] = gf.getNum(i);
        }
        assertArrayEquals(expected, gf.getValues());
    }

    @Test
    public void testNumToString() {
        GaloisField gf = new GaloisField(13);
        GaloisField.Num a = gf.getNum(0);
        GaloisField.Num b = gf.getNum(-3);
        GaloisField.Num c = gf.getNum(100);
        assertEquals("0", a.toString());
        assertEquals("10", b.toString());
        assertEquals("9", c.toString());
    }

    @Test
    public void testNumEquals() {
        GaloisField gf = new GaloisField(13);
        GaloisField.Num a = gf.getNum(10);
        GaloisField.Num b = gf.getNum(-3);
        GaloisField.Num c = gf.getNum(2);
        assertTrue(a.equals(b));
        assertTrue(a.hashCode() == b.hashCode());
        assertFalse(a.equals(c));
    }

    @Test
    public void testZeroAndOne() {
        GaloisField gf = new GaloisField(101);
        assertEquals(0, gf.ZERO.getRep());
        assertEquals(1, gf.ONE.getRep());
    }

    @Test
    public void testNeg() {
        GaloisField gf = new GaloisField(13);
        GaloisField.Num a = gf.getNum(10);
        assertEquals(gf.getNum(3), a.neg());
    }

    @Test
    public void testInv() {
        GaloisField gf = new GaloisField(13);
        GaloisField.Num a = gf.getNum(10);
        assertEquals(gf.getNum(4), a.inv());
        try {
            gf.ZERO.inv();
            fail("An exception should have been thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Cannot inverse zero.", e.getMessage());
        }
        try {
            gf.getNum(26).inv();
            fail("An exception should have been thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Cannot inverse zero.", e.getMessage());
        }
    }

    @Test
    public void testAdd() {
        GaloisField gf = new GaloisField(13);
        GaloisField.Num a = gf.getNum(10);
        GaloisField.Num b = gf.getNum(3);
        GaloisField.Num c = gf.getNum(8);
        assertEquals(gf.ZERO, a.add(b));
        assertEquals(gf.getNum(18), a.add(c));
        assertEquals(gf.getNum(5), a.add(c));
        // Commutativity
        assertTrue(a.add(b).equals(b.add(a)));
        // Associativity
        assertTrue(a.add(b).add(c).equals(a.add(b.add(c))));
    }

    @Test
    public void testMul() {
        GaloisField gf = new GaloisField(13);
        GaloisField.Num a = gf.getNum(10);
        GaloisField.Num b = gf.getNum(7);
        GaloisField.Num c = gf.getNum(8);
        assertEquals(gf.ZERO, a.mul(gf.ZERO));
        assertEquals(gf.ZERO, gf.ZERO.mul(a));
        assertEquals(a, a.mul(gf.ONE));
        assertEquals(a, gf.ONE.mul(a));
        assertEquals(gf.getNum(5), a.mul(b));
        assertEquals(gf.getNum(2), a.mul(c));
        // Commutativity
        assertTrue(a.mul(b).equals(b.mul(a)));
        // Associativity
        assertTrue(a.mul(b).mul(c).equals(a.mul(b.mul(c))));
        // Distributivity of multiplication over addition
        assertTrue(a.mul(b.add(c)).equals(a.mul(b).add(a.mul(c))));
    }

    @Test
    public void testSub() {
        GaloisField gf = new GaloisField(13);
        GaloisField.Num a = gf.getNum(11);
        GaloisField.Num b = gf.getNum(8);
        // Definition of subtraction
        assertTrue(a.sub(b).equals(a.add(b.neg())));
        GaloisField.Num c = gf.getNum(3);
        assertEquals(c, a.sub(b));
        assertEquals(b, c.sub(b));
    }

    @Test
    public void testDiv() {
        GaloisField gf = new GaloisField(13);
        GaloisField.Num a = gf.getNum(6);
        GaloisField.Num b = gf.getNum(10);
        // Definition of division
        assertTrue(a.div(b).equals(a.mul(b.inv())));
        assertEquals(gf.getNum(11), a.div(b));
        try {
            a.div(gf.ZERO);
            fail("An exception should have been thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Cannot divide by zero.", e.getMessage());
        }
    }

    @Test
    public void testIterator() {
        GaloisField gf = new GaloisField(13);
        int i = 0;
        for (GaloisField.Num n : gf) {
            assertEquals(gf.getNum(i++), n);
        }
        assertEquals(13, i);
    }

}
