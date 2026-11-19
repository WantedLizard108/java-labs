package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DataSampleTest {

    @Test
    void createsDataSampleWithCorrectValues() {
        double[] features = {10.5, 20.5};

        DataSample sample = new DataSample(
                "223",
                "Temperature",
                SampleStatus.NEW,
                features
        );

        assertEquals("223", sample.getId());
        assertEquals("Temperature", sample.getLabel());
        assertEquals(SampleStatus.NEW, sample.getStatus());
        assertArrayEquals(features, sample.getFeatures());
    }

    @Test
    void throwsExceptionWhenIdIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        null,
                        "Temperature",
                        SampleStatus.NEW,
                        new double[]{10.5, 20.5}
                ));
    }

    @Test
    void throwsExceptionWhenIdIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "",
                        "Temperature",
                        SampleStatus.NEW,
                        new double[]{10.5, 20.5}
                ));
    }

    @Test
    void throwsExceptionWhenIdContainsOnlySpaces() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "   ",
                        "Temperature",
                        SampleStatus.NEW,
                        new double[]{10.5, 20.5}
                ));
    }

    @Test
    void throwsExceptionWhenLabelIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "223",
                        null,
                        SampleStatus.NEW,
                        new double[]{10.5, 20.5}
                ));
    }

    @Test
    void throwsExceptionWhenLabelIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "223",
                        "",
                        SampleStatus.NEW,
                        new double[]{10.5, 20.5}
                ));
    }

    @Test
    void throwsExceptionWhenLabelContainsOnlySpaces() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "223",
                        "   ",
                        SampleStatus.NEW,
                        new double[]{10.5, 20.5}
                ));
    }

    @Test
    void throwsExceptionWhenStatusIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "223",
                        "Temperature",
                        null,
                        new double[]{10.5, 20.5}
                ));
    }

    @Test
    void throwsExceptionWhenFeaturesIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "223",
                        "Temperature",
                        SampleStatus.NEW,
                        null
                ));
    }

    @Test
    void throwsExceptionWhenFeaturesIsEmpty() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "223",
                        "Temperature",
                        SampleStatus.NEW,
                        new double[]{}
                ));
    }

    @Test
    void throwsExceptionWhenFeatureIsInfinite() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "223",
                        "Temperature",
                        SampleStatus.NEW,
                        new double[]{10.5, Double.POSITIVE_INFINITY}
                ));
    }

    @Test
    void throwsExceptionWhenFeatureIsNaN() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "223",
                        "Temperature",
                        SampleStatus.NEW,
                        new double[]{10.5, Double.NaN}
                ));
    }

    @Test
    void throwsExceptionWhenFeatureIsNegativeInfinite() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(
                        "223",
                        "Temperature",
                        SampleStatus.NEW,
                        new double[]{10.5, Double.NEGATIVE_INFINITY}
                ));
    }

    @Test
    void copiesFeaturesArrayInConstructor() {
        double[] features = {10.5, 20.5};

        DataSample sample = new DataSample(
                "223",
                "Temperature",
                SampleStatus.NEW,
                features
        );

        features[0] = 999.0;

        assertArrayEquals(new double[]{10.5, 20.5}, sample.getFeatures());
    }

    @Test
    void returnsCopyOfFeaturesArray() {
        DataSample sample = new DataSample(
                "223",
                "Temperature",
                SampleStatus.NEW,
                new double[]{10.5, 20.5}
        );

        double[] receivedFeatures = sample.getFeatures();

        receivedFeatures[0] = 999.0;

        assertArrayEquals(
                new double[]{10.5, 20.5},
                sample.getFeatures()
        );
    }

    @Test
    void changesStatus() {
        DataSample sample = new DataSample(
                "223",
                "Temperature",
                SampleStatus.NEW,
                new double[]{10.5, 20.5}
        );

        sample.changeStatus(SampleStatus.READY);

        assertEquals(SampleStatus.READY, sample.getStatus());
    }

    @Test
    void throwsExceptionWhenChangingStatusToNull() {
        DataSample sample = new DataSample(
                "223",
                "Temperature",
                SampleStatus.NEW,
                new double[]{10.5, 20.5}
        );

        assertThrows(IllegalArgumentException.class,
                () -> sample.changeStatus(null));

        assertEquals(SampleStatus.NEW, sample.getStatus());
    }

    @Test
    void returnsTrueWhenStatusIsReady() {
        DataSample sample = new DataSample(
                "223",
                "Temperature",
                SampleStatus.READY,
                new double[]{10.5, 20.5}
        );

        assertTrue(sample.isReady());
    }

    @Test
    void returnsFalseWhenStatusIsRejected() {
        DataSample sample = new DataSample(
                "223",
                "Temperature",
                SampleStatus.REJECTED,
                new double[]{10.5, 20.5}
        );

        assertFalse(sample.isReady());
    }

    @Test
    void calculatesAverageFeature() {
        DataSample sample = new DataSample(
                "223",
                "Temperature",
                SampleStatus.NEW,
                new double[]{10.5, 20.5}
        );

        assertEquals(15.5, sample.averageFeature());
    }

    @Test
    void calculatesAverageForSingleFeature() {
        DataSample sample = new DataSample(
                "223",
                "Temperature",
                SampleStatus.NEW,
                new double[]{42.0}
        );

        assertEquals(42.0, sample.averageFeature());
    }

    @Test
    void calculatesAverageWithNegativeFeatures() {
        DataSample sample = new DataSample(
                "223",
                "Temperature",
                SampleStatus.NEW,
                new double[]{-10.0, 20.0}
        );

        assertEquals(5.0, sample.averageFeature());
    }

}
