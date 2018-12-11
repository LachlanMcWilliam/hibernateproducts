package com.bandq.spring.DAO;

import com.bandq.spring.Entities.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductsImplementation extends AbstractGenericRepository<Product> implements ProductsDAO {
    public double priceWithVAT(Product product) {
        return product.getPrice()*1.20;
    }
}
