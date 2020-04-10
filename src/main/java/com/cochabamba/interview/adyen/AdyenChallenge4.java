package com.cochabamba.interview.adyen;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ariel.alcocer
 */
public class AdyenChallenge4 {
    public static void main(String[] args) {
        SoldProductsAggregator soldProductsAggregator = new SoldProductsAggregator(new EURExchangeService() {
            @Override
            public Optional<BigDecimal> rate(String currency) {
                return Optional.of(BigDecimal.TEN);
            }
        });

        //null case
        System.out.println(soldProductsAggregator.aggregate(null));

        //empty case
//        soldProductsAggregator.aggregate(Stream.empty());

        ArrayList<SoldProduct> soldProducts = new ArrayList<>();
        SoldProduct soldProduct1 = new SoldProduct("1", BigDecimal.valueOf(50), "EUR");
        SoldProduct soldProduct2 = new SoldProduct("2", BigDecimal.TEN, "EUR");
        SoldProduct soldProduct3 = new SoldProduct("3", BigDecimal.valueOf(100), "EUR");
        SoldProduct soldProduct4 = new SoldProduct("4", BigDecimal.valueOf(2000), "EUR");
        soldProducts.add(soldProduct1);
        soldProducts.add(soldProduct2);
        soldProducts.add(soldProduct3);
        soldProducts.add(soldProduct4);
        System.out.println(soldProductsAggregator.aggregate(soldProducts.stream()));
    }
}
class SoldProductsAggregator {

    private final EURExchangeService exchangeService;

    SoldProductsAggregator(EURExchangeService EURExchangeService) {
        this.exchangeService = EURExchangeService;
    }

    SoldProductsAggregate aggregate(Stream<SoldProduct> products) {
        if(products==null)
            return null;
        List<SimpleSoldProduct> simpleSoldProducts = products
                .map(p -> new SimpleSoldProduct(p.getName(), exchangeService.rate(p.getCurrency()).isPresent()?exchangeService.rate(p.getCurrency()).get():BigDecimal.ZERO))
                .filter(sp -> sp.getPrice()==null || sp.getPrice().compareTo(BigDecimal.ZERO)<=0)
                .collect(Collectors.toList());

        Stream<SimpleSoldProduct> simpleSoldProductStream = simpleSoldProducts.stream();
        BigDecimal total = simpleSoldProductStream
                .map(SimpleSoldProduct::getPrice)
                .filter(sp -> sp==null || sp.compareTo(BigDecimal.ZERO)<=0)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(simpleSoldProducts +" , "+ total);
        return new SoldProductsAggregate(simpleSoldProducts, total);

    }

}

final class SoldProduct   {
    private final String name;
    private final BigDecimal price;
    private final String currency;

    public SoldProduct(String name, BigDecimal price, String currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoldProduct that = (SoldProduct) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        return currency != null ? currency.equals(that.currency) : that.currency == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SoldProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }
}

final class SoldProductsAggregate{
    private final List<SimpleSoldProduct> products;
    private final BigDecimal total;

    public SoldProductsAggregate(List<SimpleSoldProduct> products, BigDecimal total) {
        this.products = products;
        this.total = total;
    }

    public List<SimpleSoldProduct> getProducts() {
        return products;
    }

    public BigDecimal getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoldProductsAggregate that = (SoldProductsAggregate) o;

        if (products != null ? !products.equals(that.products) : that.products != null) return false;
        return total != null ? total.equals(that.total) : that.total == null;
    }

    @Override
    public int hashCode() {
        int result = products != null ? products.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SoldProductsAggregate{" +
                "products=" + products +
                ", total=" + total +
                '}';
    }
}

final class SimpleSoldProduct {
    private final String name;
    private final BigDecimal price;

    public SimpleSoldProduct(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleSoldProduct that = (SimpleSoldProduct) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return price != null ? price.equals(that.price) : that.price == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SimpleSoldProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

interface EURExchangeService {
    Optional<BigDecimal> rate(String currency);
}
