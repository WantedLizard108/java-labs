package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiscountPolicyTest {

    @Test
    void returnsOriginalPriceWhenNoDiscount() {
        DiscountPolicy policy = new NoDiscount();

        double result = policy.apply(1000);

        assertEquals(1000, result);
    }

    @Test
    void appliesPercentageDiscount() {
        DiscountPolicy policy = new PercentDiscount(15);

        double result = policy.apply(1000);

        assertEquals(850, result);
    }

    @Test
    void appliesZeroPercentDiscount() {
        DiscountPolicy policy = new PercentDiscount(0);

        double result = policy.apply(1000);

        assertEquals(1000, result);
    }

    @Test
    void appliesHundredPercentDiscount() {
        DiscountPolicy policy = new PercentDiscount(100);

        double result = policy.apply(1000);

        assertEquals(0, result);
    }

    @Test
    void throwsExceptionWhenPercentIsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> new PercentDiscount(-10));
    }

    @Test
    void throwsExceptionWhenPercentIsGreaterThan100() {
        assertThrows(IllegalArgumentException.class,
                () -> new PercentDiscount(110));
    }

    @Test
    void throwsExceptionWhenNoDiscountPriceIsNegative() {
        DiscountPolicy policy = new NoDiscount();

        assertThrows(IllegalArgumentException.class,
                () -> policy.apply(-100));
    }

    @Test
    void throwsExceptionWhenPercentDiscountPriceIsNegative() {
        DiscountPolicy policy = new PercentDiscount(15);

        assertThrows(IllegalArgumentException.class,
                () -> policy.apply(-100));
    }

    @Test
    void calculatesFinalPriceUsingDiscountPolicy() {
        PriceCalculator calculator =
                new PriceCalculator(new PercentDiscount(20));

        double result = calculator.calculateFinalPrice(1000);

        assertEquals(800, result);
    }

    @Test
    void allowsReplacingDiscountPolicy() {
        PriceCalculator fullPriceCalculator =
                new PriceCalculator(new NoDiscount());

        PriceCalculator discountedCalculator =
                new PriceCalculator(new PercentDiscount(20));

        double fullPrice = fullPriceCalculator.calculateFinalPrice(100);
        double discountedPrice = discountedCalculator.calculateFinalPrice(100);

        assertEquals(100, fullPrice);
        assertEquals(80, discountedPrice);
    }


}