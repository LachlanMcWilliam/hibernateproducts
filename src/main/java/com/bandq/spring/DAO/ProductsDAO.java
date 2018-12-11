package com.bandq.spring.DAO;

import com.bandq.spring.Entities.Product;

public interface ProductsDAO extends GenericRepository<Product> {
    double priceWithVAT(Product product);
}
