import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    double EPS = 1e-6;

    @Test
    void testFeetToInches() {
        assertEquals(12.0,
                QuantityMeasurementApp.QuantityLength.convert(1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH), EPS);
    }

    @Test
    void testInchesToFeet() {
        assertEquals(2.0,
                QuantityMeasurementApp.QuantityLength.convert(24.0,
                        QuantityMeasurementApp.LengthUnit.INCH,
                        QuantityMeasurementApp.LengthUnit.FEET), EPS);
    }

    @Test
    void testYardsToInches() {
        assertEquals(36.0,
                QuantityMeasurementApp.QuantityLength.convert(1.0,
                        QuantityMeasurementApp.LengthUnit.YARD,
                        QuantityMeasurementApp.LengthUnit.INCH), EPS);
    }

    @Test
    void testInchesToYards() {
        assertEquals(2.0,
                QuantityMeasurementApp.QuantityLength.convert(72.0,
                        QuantityMeasurementApp.LengthUnit.INCH,
                        QuantityMeasurementApp.LengthUnit.YARD), EPS);
    }

    @Test
    void testCmToInches() {
        assertEquals(1.0,
                QuantityMeasurementApp.QuantityLength.convert(2.54,
                        QuantityMeasurementApp.LengthUnit.CENTIMETER,
                        QuantityMeasurementApp.LengthUnit.INCH), EPS);
    }

    @Test
    void testFeetToYards() {
        assertEquals(2.0,
                QuantityMeasurementApp.QuantityLength.convert(6.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.YARD), EPS);
    }

    @Test
    void testRoundTrip() {
        double v = 5.0;
        double result =
                QuantityMeasurementApp.QuantityLength.convert(
                        QuantityMeasurementApp.QuantityLength.convert(v,
                                QuantityMeasurementApp.LengthUnit.FEET,
                                QuantityMeasurementApp.LengthUnit.INCH),
                        QuantityMeasurementApp.LengthUnit.INCH,
                        QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(v, result, EPS);
    }

    @Test
    void testZero() {
        assertEquals(0.0,
                QuantityMeasurementApp.QuantityLength.convert(0.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH), EPS);
    }

    @Test
    void testNegative() {
        assertEquals(-12.0,
                QuantityMeasurementApp.QuantityLength.convert(-1.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.INCH), EPS);
    }

    @Test
    void testSameUnit() {
        assertEquals(5.0,
                QuantityMeasurementApp.QuantityLength.convert(5.0,
                        QuantityMeasurementApp.LengthUnit.FEET,
                        QuantityMeasurementApp.LengthUnit.FEET), EPS);
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.QuantityLength.convert(1.0, null,
                    QuantityMeasurementApp.LengthUnit.FEET);
        });
    }

    @Test
    void testNaN() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityMeasurementApp.QuantityLength.convert(Double.NaN,
                    QuantityMeasurementApp.LengthUnit.FEET,
                    QuantityMeasurementApp.LengthUnit.INCH);
        });
    }
}