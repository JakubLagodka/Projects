import java.util.List;
import java.util.NoSuchElementException;

public class Tax {
    private String name;
    private double netto;
    private double brutto;
    private double taxValue;
    private static double sumBrutto0;
    private static double sumBrutto8;
    private static double sumBrutto23;
    private static double sumNetto8;
    private static double sumNetto23;
    private static double sumTaxes8;
    private static double sumTaxes23;

    public Tax(String name, double netto, double brutto, double taxValue) {
        this.netto = netto;
        this.brutto = brutto;
        this.taxValue = taxValue;
        this.name = name;
    }

    public static double getSumBrutto0() {
        return sumBrutto0;
    }

    public static double getSumBrutto8() {
        return sumBrutto8;
    }

    public static double getSumBrutto23() {
        return sumBrutto23;
    }

    public static double getSumNetto8() {
        return sumNetto8;
    }

    public static double getSumNetto23() {
        return sumNetto23;
    }

    public static double getSumTaxes8() {
        return sumTaxes8;
    }

    public static double getSumTaxes23() {
        return sumTaxes23;
    }

    public static void calculateTax(List<List<String>> products) {

        for (List<String> product : products) {
            if (Integer.parseInt(product.get(2)) == 0) {
                sumBrutto0 += Double.parseDouble(product.get(1));
            } else if (Integer.parseInt(product.get(2)) == 8) {
                double value = Double.parseDouble(product.get(1));
                sumBrutto8 += value;
                double netto = value / 1.08 * 100;
                netto = Math.round(netto);
                netto /= 100;
                sumNetto8 += netto;
                sumTaxes8 += value - netto;
            } else if (Integer.parseInt(product.get(2)) == 23) {
                double value = Double.parseDouble(product.get(1));
                sumBrutto23 += value;
                double netto = value / 1.23 * 100;
                netto = Math.round(netto);
                netto /= 100;
                sumNetto23 += netto;
                sumTaxes23 += value - netto;
            }else throw new NoSuchElementException();
        }
    }

    @Override
    public String toString() {
        return "Tax{" +
                "name='" + name + '\'' +
                ", netto=" + netto +
                ", brutto=" + brutto +
                ", taxValue=" + taxValue +
                '}';
    }
}
