package org.ahmed.ecom.product_service.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String format) {
        super(format);
    }
}
