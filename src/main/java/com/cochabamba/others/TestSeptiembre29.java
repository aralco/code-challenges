package com.cochabamba.others;

import java.util.*;

/**
 * @author ariel.alcocer
 */
public class TestSeptiembre29 {

/*
import java.util.*;

public class main {

    public interface IMetric {

        String getName();
        double getValue();

    }

    class MetricImpl implements IMetric {

        private double value;
        private String name;

        public MetricImpl(String name, double value) {
            this.name = name;
            this.value = value;
        }

        public String getName() { return name; };
        public double getValue() { return value; };

    }
*/

    /**
     Implements a Java equivalent to:
     SELECT
     name,
     SUM(value) as value
     FROM metrics
     GROUP BY name;

     Keep O(n)
     */

    public static Collection<IMetric> groupMetrics(Collection<IMetric> metrics) {
        Map<String, Double> metricsMap = new HashMap<>();
        List<IMetric> results = new ArrayList();
        for(IMetric m : metrics)    {
            metricsMap.put(m.getName(),metricsMap.get(m.getName())+m.getValue());
        }
        for(Map.Entry<String,Double> entry:metricsMap.entrySet())   {
            results.add(new MetricImpl(entry.getKey(), entry.getValue()));
        }
        return results;
    }


    public static void testGroupMetrics() {
        // TODO: implement
        assertEquals(true, false);
    }



    public static void main(String[] args) {
        testGroupMetrics();
        System.out.println("OK");
    }

    static void assertEquals(Object expected, Object actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError(expected + "!=" + actual);
        }
    }
}
