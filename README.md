#Galois Fields

Galois fields are finite algebraic structures with two operations: addition and multiplication. The properties of these operations are the same as those that we are used to from the real numbers. The field has a 0-element (identity element for addition), and 1-element (identity for multiplication). Every element can be negated, and every element other than 0 can be inverted. The operations are commutative and associative and multiplication distributes over addition. 

A Galois field with n elements is denoted GF(n). It has been proven that n must be a power of a prime number. Here we are considering only Galois fields GF(p), where p is a prime number.

GF(p) is constructed as follows. We start with the integers **Z** and define an equivalence relation denote by the symbol ~:
    
a ~ b if and only if a - b is a multiple of p
 
For example, if p = 7, then 13 ~ 20 because 13 - 20 = -7 = (-1) * 7. The subset of **Z** of all numbers that are equivalent to a particular number n is called the equivalence class of n and is denoted [n]. For any p, we have p distinct equivalence classes, which are [0], [1], ..., [p-1]. Any integer belongs to one of these equivalence classes. For example, if p = 7, and we choose any number, say 100, and compute the remainder of 100 / 7, which is 2, we see that 100 ~ 2, because 100 - 2 = 98 = 14 * 7, and, hence 100 belongs to [2]. It is also the case that 2 belongs to [100]; in fact, [2] = [100].  We say that 2 and 100 are _representatives_ of the same class. The equivalence class of a negative number is computed in the same way. For example, the remainder of -100 / 7 is 5, i.e. -100 = -15 * 7 + 5, so [-100] = [5]. Note that in Java -100 % 7 evaluates to -2 and you have to add 7 to get a non-negative remainder.  

These equivalence classes are the elements of GF(p). The 0-element is [0] and the 1-element is [1]. 

We can define addition as 

[a] + [b] = [a + b] 

and multiplication as 

[a] * [b] = [a * b]. 

For example, if p = 7, [5] + [6] = [11] = [4] and [5] * [6] = [30] = [2]. 

The results are not dependent of the representatives chosen. For example, [5] = [-2] and [6] = [-1], so [5] + [6] = [-2] + [-1] = [-3] = [4], and [5] * [6] = [-2] * [-1] = [(-2) * (-1)] = [2].

Negating a number is straight forward; -[n] = [-n], but inverting a number is a little more complicated. The inverse of [n] is [k] such that [n] * [k] = [1]. For prime p and non-zero [n], the inverse of [n] always exists and is unique. For example, if p = 7, the inverse of [5] is [3], since [5] * [3] = [15] = [1]. The inverse of [4] is [2] and the inverse of [6] is [6]. The inverse of [0] is not defined. To find the inverse, use Util.modinv(), which is provided. 

Division is defined as multiplication by the inverse. For example, if p = 7, then [5] / [3] = [4], since the inverse of [3] is [5] and [5] * [5] = [25] = [4]. One can also verify that [5] = [4] * [3]. 

In code, we cannot easily represent the elements of a finite Galois field as equivalence classes, since they are infinite sets. Instead, we represent each element of GF(p) by an instance of a non-static inner class `Num`. This object has a final member `rep` which is the equivalence class' _canonical representative_, i.e., the representative of the equivalence class that is in the interval [0, p). The string representation of this object is `"[rep]"`.

