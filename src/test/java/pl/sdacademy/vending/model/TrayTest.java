package pl.sdacademy.vending.model;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class TrayTest {


    @Test
    public void shouldBeAbleTobuzLastAvaiableProduct() {
        // Given;
        Product definedProduct = Product.builder("P1").build();
        Tray tray = Tray.builder("A1")
                .product(definedProduct)
                .build( );

        // When
        Optional<Product> boughtProduct = tray.buyProduct();
        // Then
        assertTrue(boughtProduct.isPresent());
        assertEquals(definedProduct,boughtProduct.get());
    }

}