package com.company;

public class Statistic {
    private double max;
    private double min;
    private double sum;
    private double avg;
    private int count;

    public Statistic(double max, double min, double sum, double avg, int count) {
        this.max = max;
        this.min = min;
        this.sum = sum;
        this.avg = avg;
        this.count = count;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
