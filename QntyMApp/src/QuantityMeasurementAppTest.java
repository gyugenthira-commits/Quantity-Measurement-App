import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    double EPS = 1e-6;

    @Test
    void testTargetFeet() {
        var r = QuantityMeasurementApp.QuantityLength.add(
                new QuantityMeasurementApp.QuantityLength(1, QuantityMeasurementApp.LengthUnit.FEET),
                new QuantityMeasurementApp.QuantityLength(12, QuantityMeasurementApp.LengthUnit.INCH),
                QuantityMeasurementApp.LengthUnit.FEET);

        assertEquals(2.0, r.value, EPS);
    }

    @Test
    void testTargetInch() {
        var r = QuantityMeasurementApp.QuantityLength.add(
                new QuantityMeasurementApp.QuantityLength(1, QuantityMeasurementApp.LengthUnit.FEET),
                new QuantityMeasurementApp.QuantityLength(12, QuantityMeasurementApp.LengthUnit.INCH),
                QuantityMeasurementApp.LengthUnit.INCH);

        assertEquals(24.0, r.value, EPS);
    }

    @Test
    void testTargetYard() {
        var r = QuantityMeasurementApp.QuantityLength.add(
                new QuantityMeasurementApp.QuantityLength(1, QuantityMeasurementApp.LengthUnit.FEET),
                new QuantityMeasurementApp.QuantityLength(12, QuantityMeasurementApp.LengthUnit.INCH),
                QuantityMeasurementApp.LengthUnit.YARD);

        assertEquals(0.666666, r.value, 1e-3);
    }

    @Test
    void testTargetCm() {
        var r = QuantityMeasurementApp.QuantityLength.add(
                new QuantityMeasurementApp.QuantityLength(1, QuantityMeasurementApp.LengthUnit.INCH),
                new QuantityMeasurementApp.QuantityLength(1, QuantityMeasurementApp.LengthUnit.INCH),
                QuantityMeasurementApp.LengthUnit.CENTIMETER);

        assertEquals(5.08, r.value, 1e-2);
    }

    @Test
    void testCommutative() {
        var a = new QuantityMeasurementApp.QuantityLength(1, QuantityMeasurementApp.LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(12, QuantityMeasurementApp.LengthUnit.INCH);

        var r1 = QuantityMeasurementApp.QuantityLength.add(a, b, QuantityMeasurementApp.LengthUnit.YARD);
        var r2 = QuantityMeasurementApp.QuantityLength.add(b, a, QuantityMeasurementApp.LengthUnit.YARD);

        assertEquals(r1.value, r2.value, EPS);
    }

    @Test
    void testZero() {
        var r = QuantityMeasurementApp.QuantityLength.add(
                new QuantityMeasurementApp.QuantityLength(5, QuantityMeasurementApp.LengthUnit.FEET),
                new QuantityMeasurementApp.QuantityLength(0, QuantityMeasurementApp.LengthUnit.INCH),
                QuantityMeasurementApp.LengthUnit.YARD);

        assertEquals(1.666666, r.value, 1e-3);
    }

    @Test
    void testNegative() {
        var r = QuantityMeasurementApp.QuantityLength.add(
                new QuantityMeasurementApp.QuantityLength(5, QuantityMeasurementApp.LengthUnit.FEET),
                new QuantityMeasurementApp.QuantityLength(-2, QuantityMeasurementApp.LengthUnit.FEET),
                QuantityMeasurementApp.LengthUnit.INCH);

        assertEquals(36.0, r.value, EPS);
    }

    @Test
    void testNullTarget() {
        assertThrows(IllegalArgumentException.class, () ->
                QuantityMeasurementApp.QuantityLength.add(
                        new QuantityMeasurementApp.QuantityLength(1, QuantityMeasurementApp.LengthUnit.FEET),
                        new QuantityMeasurementApp.QuantityLength(1, QuantityMeasurementApp.LengthUnit.FEET),
                        null));
    }
}