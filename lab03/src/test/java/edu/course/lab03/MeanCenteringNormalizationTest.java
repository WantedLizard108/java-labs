package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeanCenteringNormalizationTest {

    @Test
    void centersValuesAroundZero() {
        MeanCenteringNormalization normalization =
                new MeanCenteringNormalization();

        double[] values = {10, 20, 30};

        double[] result = normalization.normalize(values);

        assertArrayEquals(
                new double[]{-10, 0, 10},
                result,
                0.0001
        );
    }

    @Test
    void doesNotModifyOriginalArray() {
        MeanCenteringNormalization normalization =
                new MeanCenteringNormalization();

        double[] values = {10, 20, 30};
        double[] original = {10, 20, 30};

        normalization.normalize(values);

        assertArrayEquals(original, values);
    }
}

