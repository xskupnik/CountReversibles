/*
Some positive integers n have the property that the sum [ n + reverse(n) ] consists
entirely of odd (decimal) digits. For instance, 36 + 63 = 99 and 409 + 904 = 1313.
We will call such numbers reversible; so 36, 63, 409, and 904 are reversible.
Leading zeroes are not allowed in either n or reverse(n).

There are 120 reversible numbers below one-thousand.

How many reversible numbers are there below one-billion (10^9)?

*/
package com.dohnalovar;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {

        ReversiblesCounter rc = new ReversiblesCounter(BigInteger.valueOf(1000));
        System.out.println("Number of reversible below 1000 is " + rc.getCount());
        System.out.println(rc.toString());

        //Number of reversible below 1 billion is 608720
        // computed 1,5hour
/*
        ReversiblesCounter rc2 = new ReversiblesCounter(BigInteger.valueOf(1000000000));
        System.out.println("Number of reversible below 1 billion is " + rc2.getCount());
*/
    }
}
