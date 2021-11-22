import java.util.List;
import java.util.NoSuchElementException;

public class CalculateTax {
    private double sumNet0;
    private double sumNet8;
    private double sumNet23;
    private double sumGross8;
    private double sumGross23;

    public double getSumNet0() {
        return sumNet0;
    }

    public double getSumNet8() {
        return sumNet8;
    }

    public double getSumNet23() {
        return sumNet23;
    }

    public double getSumGross8() {
        return sumGross8;
    }

    public double getSumGross23() {
        return sumGross23;
    }
    //    private double sumBrutto8;
//    private double sumBrutto23;
//    private double sumNetto8;
//    private double sumNetto23;
//    private double sumTaxes8;
//    private double sumTaxes23;

//    public double getSumBrutto0() {
//        return sumBrutto0;
//    }
//
//    public double getSumBrutto8() {
//        return sumBrutto8;
//    }
//
//    public double getSumBrutto23() {
//        return sumBrutto23;
//    }
//
//    public double getSumNetto8() {
//        return sumNetto8;
//    }
//
//    public double getSumNetto23() {
//        return sumNetto23;
//    }
//
//    public double getSumTaxes8() {
//        return sumTaxes8;
//    }
//
//    public double getSumTaxes23() {
//        return sumTaxes23;
//    }
//przerobić na enuma zrobić po ang, value nazwać gros i brutto!
//    public void calculate(List<Product> products) {
//
//        for (Product product : products) {
//            if (product.getTaxPercentage().equals(TaxPercentage.NONE)) {
//                sumBrutto0 += product.getPrice();
//            } else if (product.getTaxPercentage().equals(TaxPercentage.EIGHT)) {
//                double value = product.getPrice();
//                sumBrutto8 += value;
//                double netto = value / 1.08 * 100;
//                netto = Math.round(netto);
//                netto /= 100;
//                sumNetto8 += netto;
//                sumTaxes8 += value - netto;
//            } else if (product.getTaxPercentage().equals(TaxPercentage.TWENTY_THREE)) {
//                double value = product.getPrice();
//                sumBrutto23 += value;
//                double netto = value / 1.23 * 100;
//                netto = Math.round(netto);
//                netto /= 100;
//                sumNetto23 += netto;
//                sumTaxes23 += value - netto;
//            } else throw new NoSuchElementException();
//        }
//    }
    public void calculate(Product product){
//        if (product.getTaxPercentage().equals(TaxPercentage.NONE)) {
//                sumBrutto0 += product.getPrice();
//            } else if (product.getTaxPercentage().equals(TaxPercentage.EIGHT)) {
//                double value = product.getPrice();
//                sumBrutto8 += value;
//                double netto = value / 1.08 * 100;
//                netto = Math.round(netto);
//                netto /= 100;
//                sumNetto8 += netto;
//                sumTaxes8 += value - netto;
//            } else if (product.getTaxPercentage().equals(TaxPercentage.TWENTY_THREE)) {
//                double value = product.getPrice();
//                sumBrutto23 += value;
//                double netto = value / 1.23 * 100;
//                netto = Math.round(netto);
//                netto /= 100;
//                sumNetto23 += netto;
//                sumTaxes23 += value - netto;
//            } else throw new NoSuchElementException();
        Double gross = TaxCalculate.calculateTax(product.getTaxPercentage()).calculate(product.getPrice());
        if (product.getTaxPercentage().equals(TaxPercentage.EIGHT)) {
            sumNet8 += gross;
            sumGross8 += product.getPrice() - gross;
        }
        else if (product.getTaxPercentage().equals(TaxPercentage.TWENTY_THREE)) {
            sumNet23 += gross;
            sumGross23 += product.getPrice() - gross;
        }
        else {
            sumNet0 += product.getPrice();
        }


    }
}
