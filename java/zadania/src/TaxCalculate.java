import java.util.HashMap;
import java.util.Map;

public enum TaxCalculate {
    NONE(TaxPercentage.NONE) {
        @Override
        public Double calculate(double gross) {

            return gross;
        }
    }, EIGHT(TaxPercentage.EIGHT) {
        @Override
        public Double calculate(double gross) {

            gross = (gross / 1.08 * 100);
            gross = Math.round(gross);
            gross /= 100;
            return gross;

        }
    }, TWENTY_THREE(TaxPercentage.TWENTY_THREE) {
        @Override
        public Double calculate(double gross) {
            gross = (gross / 1.23 * 100);
            gross = Math.round(gross);
            gross /= 100;
            return gross;
        }
    };

    private final TaxPercentage taxPercentage;

    public abstract Double calculate(double gross);

    TaxCalculate(TaxPercentage taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    private static final Map<TaxPercentage, TaxCalculate> TAXES;

    static {
        TAXES = new HashMap<>();
        for (TaxCalculate value : values()) {
            TAXES.put(value.taxPercentage, value);
        }
    }

    public static TaxCalculate calculateTax(TaxPercentage taxPercentage) {

        TaxCalculate current = TAXES.get(taxPercentage);

        if (current != null) {
            return current;
        }
        throw new UnpredictedTaxException();

    }
}
