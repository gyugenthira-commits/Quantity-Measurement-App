import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    double EPS = 1e-6;

    @Test
    void testFeetPlusFeet() {
        var r = new QuantityMeasurementApp.QuantityLength(1, QuantityMeasurementApp.LengthUnit.FEET)
                .add(new QuantityMeasurementApp.QuantityLength(2, QuantityMeasurementApp.LengthUnit.FEET));

        assertEquals(3.0, r.value, EPS);
    }

    @Test
    void testInchPlusInch() {
        var r = new QuantityMeasurementApp.QuantityLength(6, QuantityMeasurementApp.LengthUnit.INCH)
                .add(new QuantityMeasurementApp.QuantityLength(6, QuantityMeasurementApp.LengthUnit.INCH));

        assertEquals(12.0, r.value, EPS);
    }

    @Test
    void testFeetPlusInch() {
        var r = new QuantityMeasurementApp.QuantityLength(1, QuantityMeasurementApp.LengthUnit.FEET)
                .add(new QuantityMeasurementApp.QuantityLength(12, QuantityMeasurementApp.LengthUnit.INCH));

        assertEquals(2.0, r.value, EPS);
    }

    @Test
    void testInchPlusFeet() {
        var r = new QuantityMeasurementApp.QuantityLength(12, QuantityMeasurementApp.LengthUnit.INCH)
                .add(new QuantityMeasurementApp.QuantityLength(1, QuantityMeasurementApp.LengthUnit.FEET));

        assertEquals(24.0, r.value, EPS);
    }

    @Test
    void testYardPlusFeet() {
        var r = new QuantityMeasurementApp.QuantityLength(1, QuantityMeasurementApp.LengthUnit.YARD)
                .add(new QuantityMeasurementApp.QuantityLength(3, QuantityMeasurementApp.LengthUnit.FEET));

        assertEquals(2.0, r.value, EPS);
    }

    @Test
    void testCmPlusInch() {
        var r = new QuantityMeasurementApp.QuantityLength(2.54, QuantityMeasurementApp.LengthUnit.CENTIMETER)
                .add(new QuantityMeasurementApp.QuantityLength(1, QuantityMeasurementApp.LengthUnit.INCH));

        assertEquals(5.08, r.value, 1e-2);
    }

    @Test
    void testCommutative() {
        var a = new QuantityMeasurementApp.QuantityLength(1, QuantityMeasurementApp.LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(12, QuantityMeasurementApp.LengthUnit.INCH);

        assertEquals(a.add(b).toString(), b.add(a).toString());
    }

    @Test
    void testZero() {
        var r = new QuantityMeasurementApp.QuantityLength(5, QuantityMeasurementApp.LengthUnit.FEET)
                .add(new QuantityMeasurementApp.QuantityLength(0, QuantityMeasurementApp.LengthUnit.INCH));

        assertEquals(5.0, r.value, EPS);
    }

    @Test
    void testNegative() {
        var r = new QuantityMeasurementApp.QuantityLength(5, QuantityMeasurementApp.LengthUnit.FEET)
                .add(new QuantityMeasurementApp.QuantityLength(-2, QuantityMeasurementApp.LengthUnit.FEET));

        assertEquals(3.0, r.value, EPS);
    }

    @Test
    void testNull() {
        var a = new QuantityMeasurementApp.QuantityLength(1, QuantityMeasurementApp.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> a.add(null));
    }
}