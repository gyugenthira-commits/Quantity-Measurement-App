public class QuantityMeasurementApp {

    public enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CENTIMETER(0.393701 / 12.0);

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toBase(double value) {
            return value * toFeet;
        }

        public double fromBase(double base) {
            return base / toFeet;
        }
    }

    public static class QuantityLength {
        final double value;
        private final LengthUnit unit;

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

        public QuantityLength add(QuantityLength other) {
            return add(this, other, this.unit);
        }

        public static QuantityLength add(QuantityLength a, QuantityLength b, LengthUnit target) {
            if (a == null || b == null || target == null) {
                throw new IllegalArgumentException();
            }

            double sumBase = a.toBase() + b.toBase();
            double result = target.fromBase(sumBase);

            return new QuantityLength(result, target);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            QuantityLength other = (QuantityLength) obj;
            return Double.compare(this.toBase(), other.toBase()) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(toBase());
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    public static void main(String[] args) {

        var a = new QuantityLength(1.0, LengthUnit.FEET);
        var b = new QuantityLength(12.0, LengthUnit.INCH);

        System.out.println(QuantityLength.add(a, b, LengthUnit.FEET));
        System.out.println(QuantityLength.add(a, b, LengthUnit.INCH));
        System.out.println(QuantityLength.add(a, b, LengthUnit.YARD));
    }
}