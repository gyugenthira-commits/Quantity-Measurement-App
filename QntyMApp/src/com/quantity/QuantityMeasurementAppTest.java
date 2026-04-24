package com.quantity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    double EPS = 1e-6;

    @Test
    void testConvert_FeetToInch() {
        assertEquals(12.0,
                QuantityMeasurementApp.QuantityLength.convert(1.0,
                        LengthUnit.FEET, LengthUnit.INCH), EPS);
    }

    @Test
    void testConvert_InchToFeet() {
        assertEquals(1.0,
                QuantityMeasurementApp.QuantityLength.convert(12.0,
                        LengthUnit.INCH, LengthUnit.FEET), EPS);
    }

    @Test
    void testAdd_FeetAndInch() {
        var r = QuantityMeasurementApp.QuantityLength.add(
                new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET),
                new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCH),
                LengthUnit.FEET);

        assertEquals(2.0, r.value, EPS);
    }

    @Test
    void testAdd_TargetInch() {
        var r = QuantityMeasurementApp.QuantityLength.add(
                new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET),
                new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCH),
                LengthUnit.INCH);

        assertEquals(24.0, r.value, EPS);
    }

    @Test
    void testEquality_CrossUnit() {
        var a = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET);
        var b = new QuantityMeasurementApp.QuantityLength(12.0, LengthUnit.INCH);

        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_YardAndInch() {
        var a = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.YARD);
        var b = new QuantityMeasurementApp.QuantityLength(36.0, LengthUnit.INCH);

        assertTrue(a.equals(b));
    }

    @Test
    void testConvertToMethod() {
        var q = new QuantityMeasurementApp.QuantityLength(1.0, LengthUnit.FEET)
                .convertTo(LengthUnit.INCH);

        assertEquals(12.0, q.value, EPS);
    }

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                new QuantityMeasurementApp.QuantityLength(1.0, null));
    }

    @Test
    void testNaNValue() {
        assertThrows(IllegalArgumentException.class, () ->
                new QuantityMeasurementApp.QuantityLength(Double.NaN, LengthUnit.FEET));
    }
}