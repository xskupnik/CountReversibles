package com.dohnalovar;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dohnalovar on 6/22/2019
 */
public class ReversiblesCounter {
    Set<BigInteger> reversibles = new HashSet<>();

    public int getCount() {
        return reversibles.size();
    }

    private BigInteger reverse(BigInteger value) {

        String strVal = value.toString();

        //Leading zeroes are not allowed
        if (strVal.charAt(strVal.length()-1) == '0')
            return BigInteger.valueOf(0);

        String strRev = ("");
        for (int i = strVal.length()-1; i >=0 ; i--) {
            strRev = strRev.concat(strVal.substring(i, i+1));
        }

        return BigInteger.valueOf(Long.parseLong(strRev));
    }

    private boolean areReversibles(BigInteger i, BigInteger j) {
        /*
         Some positive integers n have the property that the sum [ n + reverse(n) ]
         consists entirely of odd (decimal) digits. For instance, 36 + 63 = 99 and
         409 + 904 = 1313. We will call such numbers reversible; so 36, 63, 409, and 904
         are reversible. Leading zeroes are not allowed in either n or reverse(n).
        */
        BigInteger sum = i.add(j);
        String strSum = sum.toString();
        int iter = 0;
        while (iter < strSum.length()) {
            int digit = Integer.valueOf(strSum.substring(iter, iter+1));
            if (digit % 2 == 0)
                return false;
            iter++;
        }
        return true;
    }

    /** check how many reversibles are below boundery */
    public ReversiblesCounter(BigInteger boundery) {

        BigInteger i = BigInteger.valueOf(11);

        while (i.compareTo(boundery) < 0) {
            //System.out.println("Check: " + i);
            if (!reversibles.contains(i)) {
                BigInteger j = reverse(i);
                if (j.compareTo(BigInteger.valueOf(0)) != 0 && areReversibles(i, j)) {
                    reversibles.add(i);
                    if (j.compareTo(boundery) < 0 && !reversibles.contains(j))
                        reversibles.add(j);
                }
            }
            i = i.add(BigInteger.valueOf(1));
        }
    }

    @Override
    public String toString() {
        return "ReversiblesCounter{" +
            "reversibles=" + reversibles +
            '}';
    }
}
