package pl.sdacademy.vending.model;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

public class Tray implements Serializable {
    public static final long serialVersionUID = 1L;
    private  String symbol;
    private Long price;

    public Long getPrice() {
        return price;
    }

    private Queue<Product> products;


    private Tray(Builder builder){
        symbol = builder.symbol;
        price = builder.price;
        products = builder.products;
    }

    public Optional<String> firstProductName(){
        return Optional.ofNullable(products.peek()).map(Product::getName);
    }

    public String getSymbol() {
        return symbol;
    }

    public static Builder builder(String symbol){
        return new Builder(symbol);
    }

    public Optional<Product> buyProduct() {
        return Optional.ofNullable(products.poll( ));
    }

    public static class Builder{
        private String symbol;
        private Long price;
        private Queue<Product> products;

        private Builder(String symbol){
            this.symbol = symbol;
            products = new ArrayDeque<>();
        }

        public Builder product(Product product){
            products.add(product);
            return this;
        }

        public Builder price(Long price){
            this.price = price;
            return this;
        }
        public Tray build(){
            if (price == null || price < 0){
                price = 0L;
            }return new Tray(this);
        }
    }
}
