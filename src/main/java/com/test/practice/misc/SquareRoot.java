package com.test.practice.misc;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SquareRoot {

    public static void main(String[] args) {
        SquareRoot ex = new SquareRoot();
        BigDecimal bigDecimal = ex.squareRoot(new BigDecimal(54646787));
        System.out.println("bigDecimal = " + bigDecimal);
        BigDecimal bigDecimal1 = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        System.out.println("bigDecimal rounded = " + bigDecimal1);
    }

    public BigDecimal squareRoot(BigDecimal num) {
        BigDecimal result = new BigDecimal(1);
        if (num == null || num.compareTo(BigDecimal.ZERO) < 0) {
            throw new AssertionError("number must be greater than or equal to zero ");
        }
        BigDecimal low = BigDecimal.ZERO;
        BigDecimal high = num;
        int decimalPrecision = 7;
        RoundingMode rounding = RoundingMode.HALF_UP;
        BigDecimal mid = low.add(high).divide(BigDecimal.TWO, decimalPrecision, rounding);

        while (high.compareTo(low) > 0) {
            BigDecimal product = mid.multiply(mid);
            if (product.compareTo(num) == 0) {
                break;
            } else {
                int differencePrecision = 4;
                BigDecimal difference = num.subtract(product).abs().setScale(differencePrecision, rounding);
                System.out.println("value = " + difference);
                BigDecimal threshold = (new BigDecimal("0.01")).setScale(2, rounding);
                if (threshold.compareTo(difference) > 0) {
                    System.out.println("value = " + difference);
                    break;
                } else if (product.compareTo(num) > 0) {
                    high = mid;
                } else {
                    low = mid;
                }
            }

            mid = low.add(high).divide(BigDecimal.TWO, decimalPrecision, rounding);
        }

        return mid;
    }

}



