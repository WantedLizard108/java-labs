package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxNormalizationTest {

    @Test
    void normalizesValuesToRangeFromZeroToOne() {
        MinMaxNormalization normalization = new MinMaxNormalization();

        double[] values = {5, 10, 15, 20};

        double[] result = normalization.normalize(values);

        assertArrayEquals(
                new double[]{0.0, 1.0 / 3.0, 2.0 / 3.0, 1.0},
                result,
                0.0001
        );
    }

    @Test
    void doesNotModifyOriginalArray() {
        MinMaxNormalization normalization = new MinMaxNormalization();

        double[] values = {5, 10, 15, 20};
        double[] original = {5, 10, 15, 20};

        normalization.normalize(values);

        assertArrayEquals(original, values);
    }

    @Test
    void returnsZerosWhenAllValuesAreEqual() {
        MinMaxNormalization normalization = new MinMaxNormalization();

        double[] values = {5, 5, 5};

        double[] result = normalization.normalize(values);

        assertArrayEquals(
                new double[]{0.0, 0.0, 0.0},
                result
        );
    }

    @Test
    void throwsExceptionWhenValuesAreNull() {
        MinMaxNormalization normalization = new MinMaxNormalization();

        assertThrows(
                IllegalArgumentException.class,
                () -> normalization.normalize(null)
        );
    }

    @Test
    void throwsExceptionWhenValuesAreEmpty() {
        MinMaxNormalization normalization = new MinMaxNormalization();

        assertThrows(
                IllegalArgumentException.class,
                () -> normalization.normalize(new double[]{})
        );
    }
}