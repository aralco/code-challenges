package com.cochabamba.others;

/**
 * @author ariel.alcocer
 */
public class MetricImpl implements IMetric {

    private double value;
    private String name;

    public MetricImpl(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() { return name; };
    public double getValue() { return value; };

}
