package org.ahmed.ecom.product_service.services;

import lombok.RequiredArgsConstructor;
import org.ahmed.ecom.product_service.dtos.ProductPurchaseRequest;
import org.ahmed.ecom.product_service.dtos.ProductPurchaseResponse;
import org.ahmed.ecom.product_service.dtos.ProductRequest;
import org.ahmed.ecom.product_service.dtos.ProductResponse;
import org.ahmed.ecom.product_service.entities.Product;
import org.ahmed.ecom.product_service.exceptions.ProductNotFoundException;
import org.ahmed.ecom.product_service.exceptions.ProductPurchaseException;
import org.ahmed.ecom.product_service.mappers.ProductMapper;
import org.ahmed.ecom.product_service.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final ProductMapper mapper;

    public Integer createProduct(ProductRequest request) {
        return productRepo.save(mapper.toProduct(request)).getId();
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) throws ProductPurchaseException {
        var productIds=request.stream().map(p->p.productId()).toList();
        var storedProducts = productRepo.findAllByIdInOrderById(productIds);
        if(productIds.size()!=storedProducts.size())
            throw new ProductPurchaseException("One or more products does not exist");
        var sortedRequest=request.stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storedProducts.size(); i++) {
            var requestedProduct=sortedRequest.get(i);
            var storedProduct=storedProducts.get(i);
            if (requestedProduct.quantity()>storedProduct.getAvailableQuantity())
                throw new ProductPurchaseException("Insufficient Quantity for product with id "+requestedProduct.productId());
            var newAvailQtt=storedProduct.getAvailableQuantity()-requestedProduct.quantity();
            storedProduct.setAvailableQuantity(newAvailQtt);
            productRepo.save(storedProduct);
            purchasedProducts.add(mapper.toProductPurchaseResponse(storedProduct,requestedProduct.quantity()));
        }
        return purchasedProducts;
    }

    public ProductResponse findById(Integer productId) throws ProductNotFoundException {
        return productRepo.findById(productId).map(mapper::toProductResponse).orElseThrow(
                ()->new ProductNotFoundException(String.format("the product with the id %d was not found",productId))
        );
    }
}
