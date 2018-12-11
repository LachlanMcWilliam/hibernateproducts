package com.bandq.spring.Services;

import com.bandq.spring.DAO.ProductsDAO;
import com.bandq.spring.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductsDAO productsDAO;

    public double productWithVAT(Product product){
        return product.getPrice()*1.20;
    }

    public void add(Product product){productsDAO.add(product);}

    public Product get(int id){return productsDAO.get(id);}

    public boolean deleteById(int id){return productsDAO.delete(id);}

    public boolean update(Product product){return productsDAO.update(product);}

    public List<Product> getAll(){return productsDAO.getAll();}
}
