package org.ahmed.ecom.product_service.mappers;

import org.ahmed.ecom.product_service.dtos.ProductPurchaseResponse;
import org.ahmed.ecom.product_service.dtos.ProductRequest;
import org.ahmed.ecom.product_service.dtos.ProductResponse;
import org.ahmed.ecom.product_service.entities.Category;
import org.ahmed.ecom.product_service.entities.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequest request) {
        if (request==null)
            return null;
        return Product.builder()
                .price(request.price())
                .availableQuantity(request.availableQuantity())
                .name(request.name())
                .description(request.description())
                .category(
                        Category.builder().id(request.categoryId()).build()
                )
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product storedProduct, double quantity) {
        return new ProductPurchaseResponse(
                storedProduct.getId(),
                storedProduct.getName(),
                storedProduct.getDescription(),
                quantity,
                storedProduct.getPrice()
        );
    }
}
