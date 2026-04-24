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

        public double fromBase(double baseValue) {
            return baseValue / toFeet;
        }
    }

    public static class QuantityLength {
        private final double value;
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

        public QuantityLength convertTo(LengthUnit target) {
            if (target == null) throw new IllegalArgumentException();
            double base = toBase();
            double converted = target.fromBase(base);
            return new QuantityLength(converted, target);
        }

        public static double convert(double value, LengthUnit from, LengthUnit to) {
            if (from == null || to == null || !Double.isFinite(value)) {
                throw new IllegalArgumentException();
            }
            double base = from.toBase(value);
            return to.fromBase(base);
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

        System.out.println(QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH));
        System.out.println(QuantityLength.convert(3.0, LengthUnit.YARD, LengthUnit.FEET));
        System.out.println(QuantityLength.convert(36.0, LengthUnit.INCH, LengthUnit.YARD));
        System.out.println(QuantityLength.convert(1.0, LengthUnit.CENTIMETER, LengthUnit.INCH));
    }
}