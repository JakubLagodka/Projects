public class Tax {
    private String name;
    private double netto;
    private double brutto;
    private double taxValue;

    public Tax(String name, double netto, double brutto, double taxValue) {
        this.netto = netto;
        this.brutto = brutto;
        this.taxValue = taxValue;
        this.name = name;
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
