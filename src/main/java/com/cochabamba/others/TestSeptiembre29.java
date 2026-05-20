package com.cochabamba.others;

import java.util.*;
import com.cochabamba.others.IMetric;
import com.cochabamba.others.MetricImpl;
/**
 * @author ariel.alcocer
 */
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

public class TestSeptiembre29 {
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
            results.add((IMetric) new MetricImpl(entry.getKey(), entry.getValue()));
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
