import java.util.List;
import java.util.NoSuchElementException;

public class CalculateTax {
    private double sumBrutto0;
    private double sumBrutto8;
    private double sumBrutto23;
    private double sumNetto8;
    private double sumNetto23;
    private double sumTaxes8;
    private double sumTaxes23;

    public double getSumBrutto0() {
        return sumBrutto0;
    }

    public double getSumBrutto8() {
        return sumBrutto8;
    }

    public double getSumBrutto23() {
        return sumBrutto23;
    }

    public double getSumNetto8() {
        return sumNetto8;
    }

    public double getSumNetto23() {
        return sumNetto23;
    }

    public double getSumTaxes8() {
        return sumTaxes8;
    }

    public double getSumTaxes23() {
        return sumTaxes23;
    }
//przerobić na enuma zrobić po ang, value nazwać gros i brutto!
    public void calculate(List<Product> products) {

        for (Product product : products) {
            if (product.getTaxPercentage().equals(TaxPercentage.NONE)) {
                sumBrutto0 += product.getPrice();
            } else if (product.getTaxPercentage().equals(TaxPercentage.EIGHT)) {
                double value = product.getPrice();
                sumBrutto8 += value;
                double netto = value / 1.08 * 100;
                netto = Math.round(netto);
                netto /= 100;
                sumNetto8 += netto;
                sumTaxes8 += value - netto;
            } else if (product.getTaxPercentage().equals(TaxPercentage.TWENTY_THREE)) {
                double value = product.getPrice();
                sumBrutto23 += value;
                double netto = value / 1.23 * 100;
                netto = Math.round(netto);
                netto /= 100;
                sumNetto23 += netto;
                sumTaxes23 += value - netto;
            } else throw new NoSuchElementException();
        }
    }
}
