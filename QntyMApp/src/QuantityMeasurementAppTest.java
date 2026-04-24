import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // ================= FEET TESTS =================

    @Test
    void testFeetEquality_SameValue() {
        assertTrue(QuantityMeasurementApp.compareFeet(1.0, 1.0));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        assertFalse(QuantityMeasurementApp.compareFeet(1.0, 2.0));
    }

    @Test
    void testFeetEquality_NullComparison() {
        QuantityMeasurementApp.Feet f = new QuantityMeasurementApp.Feet(1.0);
        assertFalse(f.equals(null));
    }

    @Test
    void testFeetEquality_SameReference() {
        QuantityMeasurementApp.Feet f = new QuantityMeasurementApp.Feet(1.0);
        assertTrue(f.equals(f));
    }

    @Test
    void testFeetEquality_NonNumericInput() {
        QuantityMeasurementApp.Feet f = new QuantityMeasurementApp.Feet(1.0);
        assertFalse(f.equals("invalid"));
    }

    // ================= INCH TESTS =================

    @Test
    void testInchEquality_SameValue() {
        assertTrue(QuantityMeasurementApp.compareInches(1.0, 1.0));
    }

    @Test
    void testInchEquality_DifferentValue() {
        assertFalse(QuantityMeasurementApp.compareInches(1.0, 2.0));
    }

    @Test
    void testInchEquality_NullComparison() {
        QuantityMeasurementApp.Inches i = new QuantityMeasurementApp.Inches(1.0);
        assertFalse(i.equals(null));
    }

    @Test
    void testInchEquality_SameReference() {
        QuantityMeasurementApp.Inches i = new QuantityMeasurementApp.Inches(1.0);
        assertTrue(i.equals(i));
    }

    @Test
    void testInchEquality_NonNumericInput() {
        QuantityMeasurementApp.Inches i = new QuantityMeasurementApp.Inches(1.0);
        assertFalse(i.equals("invalid"));
    }
}