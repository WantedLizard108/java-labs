package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeatureProcessorTest {

    @Test
    void processesFeaturesUsingMinMaxNormalization() {
        FeatureProcessor processor =
                new FeatureProcessor(new MinMaxNormalization());

        double[] features = {10, 20, 30};

        double[] result = processor.process(features);

        assertArrayEquals(
                new double[]{0.0, 0.5, 1.0},
                result,
                0.0001
        );
    }

    @Test
    void processesFeaturesUsingMeanCenteringNormalization() {
        FeatureProcessor processor =
                new FeatureProcessor(new MeanCenteringNormalization());

        double[] features = {10, 20, 30};

        double[] result = processor.process(features);

        assertArrayEquals(
                new double[]{-10, 0, 10},
                result,
                0.0001
        );
    }
}