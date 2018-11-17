package pl.sdacademy.vending.model;

import java.io.Serializable;

public class Product implements Serializable {
    public static final long serialVersionUID = 1L;
    private String name;

    public String getName() {
        return name;
    }
    public static Builder builder(String name){
        return new Builder(name);
    }

    private Product(Builder builder){
        name = builder.name;
    }
    public static class Builder{
        private String name;

        private Builder(String name){
            this.name = name;
        }
        public Product build(){
            return new Product(this);
        }
    }
}
