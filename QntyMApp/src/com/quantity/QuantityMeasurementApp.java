package com.quantity;

public class QuantityMeasurementApp {

    public static class QuantityLength {

        public final double value;
        public final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            if (unit == null || !Double.isFinite(value)) {
                throw new IllegalArgumentException();
            }
            this.value = value;
            this.unit = unit;
        }

        private double toBase() {
            return unit.toBase(value);
        }

        public QuantityLength convertTo(LengthUnit target) {
            if (target == null) throw new IllegalArgumentException();
            return new QuantityLength(target.fromBase(toBase()), target);
        }

        public QuantityLength add(QuantityLength other) {
            return add(this, other, this.unit);
        }

        public static QuantityLength add(QuantityLength a, QuantityLength b, LengthUnit target) {
            if (a == null || b == null || target == null) {
                throw new IllegalArgumentException();
            }

            double sum = a.toBase() + b.toBase();
            return new QuantityLength(target.fromBase(sum), target);
        }

        public static double convert(double value, LengthUnit from, LengthUnit to) {
            if (from == null || to == null || !Double.isFinite(value)) {
                throw new IllegalArgumentException();
            }
            return to.fromBase(from.toBase(value));
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            return Double.compare(this.toBase(), ((QuantityLength) obj).toBase()) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toBase());
        }
    }

    public static void main(String[] args) {
        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println(a.convertTo(LengthUnit.INCH));
        System.out.println(QuantityLength.add(a, b, LengthUnit.FEET));
        System.out.println(a.equals(b));
    }
}