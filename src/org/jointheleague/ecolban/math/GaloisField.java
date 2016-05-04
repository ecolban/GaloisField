package org.jointheleague.ecolban.math;

import java.util.Iterator;

/**
 * This class implements a Galois Fields (GF). See Wikipedia for a definition of
 * GF. Although the order of a GF can be a power of prime number, this
 * implementation only considers orders that are prime.
 * <p>
 * @author Erik Colban &copy; 2016
 */
public class GaloisField implements Iterable<GaloisField.Num> {

    private final int p;
    public final Num ZERO;
    public final Num ONE;

    public GaloisField(int prime) {
        // 1. Create a constructor. The constructor should initialize the final
        // instance variables.
        // The constructor should verify that the argument is indeed a prime,
        // and throw an
        // appropriate exception if not.
    }

    /**
     * @return The number of elements of the field
     */
    public int getOrder() {
        return p;
    }

    /**
     * 
     * @param n
     *            a representative (not necessarily canonical) of the element to
     *            be returned
     * @return the element of this GaloisField that has n as representative.
     */
    public Num getNum(int n) {
        // 3. Complete code. Note that you have several options here:
        // You can construct a new instance of Num each time this method is
        // called, or you can construct all instances at once and store them in
        // a list and retrieve the right element each time this method is
        // called, or you can do something in between.
    }

    /**
     * An element of the field. This class depends on the outer class' instance
     * variable p, an hence is non-static.
     *
     */
    public class Num {

        private final int rep;

        /**
         * Constructs an element of the outer GaloisField instance. The argument
         * rep must be a representative of this element.
         * 
         * @param rep
         *            a representative (not necessarily canonical) of the
         *            element to be constructed.
         */
        private Num(int rep) {
            // 2. An element is defined as an equivalence class of integers that
            // is such that the difference of any two integers in the same class
            // equals 0 modulo p. For example, if p = 7, then
            // the set {..., -13, -6, 1, 8, 15, ...} is an equivalence class.
            // Any member of a class is
            // called a representative of the class, and can be used as an
            // identifier of the class.
            // Since each class has exactly one representative in the
            // range from 0 inclusive to p exclusive, we choose that
            // representative as the "canonical"
            // representative. Write the constructor and make sure the canonical
            // representative is assigned to
            // the instance variable rep.

        }

        /**
         * @return the canonical representative
         */
        public int getRep() {
            // 4. Complete code
        }

        /**
         * @return the negative of this
         */
        public Num neg() {
            // 5. Complete the code.
        }

        /**
         * 
         * @return the inverse of this
         * @throws an
         *             IllegalArgumentException if this is the zero element
         */
        public Num inv() {
            // 6. Complete the code. Use Util.modinv.
        }

        /**
         * @param b
         *            any element of this GF
         * @return the sum of this and b
         */
        public Num add(Num b) {
            // 7. Complete the code
        }

        /**
         * @param b
         *            any element of this GF
         * @return the product of this and b
         */
        public Num mul(Num b) {
            // 8. Complete the code
        }

        /**
         * @param b
         *            any element of this GF
         * @return this minus b
         */
        public Num sub(Num b) {
            // 9. Complete
        }

        /**
         * @param b
         *            a non-null element of this GF
         * @return this divided by b
         * @throws an
         *             IllegalArgumentAxception if b is the zero element
         */
        public Num div(Num b) {
            // 10. Complete
        }

        // 11. Autogenerate the hashcode() and equals() methods. Two elements
        // are equal if they have
        // the same canonical representative.

        @Override
        public String toString() {
            // 12. Complete code
        }
    } // end of Num class

    @Override
    public Iterator<Num> iterator() {
        // 13. Complete code
    }

}
