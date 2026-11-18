package edu.course.lab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseToolkitTest {

    @Test
    void returnsTrueForEvenNumber() {
        boolean result = CourseToolkit.isEven(8);

        assertTrue(result);
    }

    @Test
    void returnsFalseForOddNumber() {
        boolean result = CourseToolkit.isEven(7);

        assertFalse(result);
    }

    @Test
    void returnsTrueForZero() {
        boolean result = CourseToolkit.isEven(0);

        assertTrue(result);
    }

    @Test
    void returnsTrueForNegativeEvenNumber() {
        boolean result = CourseToolkit.isEven(-8);

        assertTrue(result);
    }

    @Test
    void returnsTrueForPrimeNumber() {
        assertTrue(CourseToolkit.isPrime(7));
    }

    @Test
    void returnsTrueForTwo() {
        assertTrue(CourseToolkit.isPrime(2));
    }

    @Test
    void returnsFalseForCompositeNumber() {
        assertFalse(CourseToolkit.isPrime(9));
    }

    @Test
    void returnsFalseForSquareOfPrimeNumber() {
        assertFalse(CourseToolkit.isPrime(49));
    }

    @Test
    void returnsFalseForNumberLessThanTwo() {
        assertFalse(CourseToolkit.isPrime(1));
    }

    @Test
    void returnsTrueForPalindrome() {
        assertTrue(CourseToolkit.isPalindrome("radar"));
    }

    @Test
    void returnsFalseForNonPalindrome() {
        assertFalse(CourseToolkit.isPalindrome("hello"));
    }

    @Test
    void returnsTrueForSingleCharacter() {
        assertTrue(CourseToolkit.isPalindrome("a"));
    }

    @Test
    void returnsTrueForEmptyString() {
        assertTrue(CourseToolkit.isPalindrome(""));
    }

    @Test
    void throwsExceptionForNull() {
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.isPalindrome(null));
    }

    @Test
    void returnsAverageOfNumbers() {
        int[] numbers = {2, 4, 6, 8};

        double result = CourseToolkit.average(numbers);

        assertEquals(5.0, result);
    }

    @Test
    void returnsAverageWithDecimalResult() {
        int[] numbers = {1, 2};

        double result = CourseToolkit.average(numbers);

        assertEquals(1.5, result);
    }

    @Test
    void returnsNumberForSingleElementArray() {
        int[] numbers = {10};

        double result = CourseToolkit.average(numbers);

        assertEquals(10.0, result);
    }

    @Test
    void throwsExceptionForEmptyArray() {
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.average(new int[]{}));
    }

    @Test
    void throwsExceptionForNullArray() {
        assertThrows(IllegalArgumentException.class,
                () -> CourseToolkit.average(null));
    }
}
