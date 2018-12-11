import com.bandq.spring.DAO.ProductsDAO;
import com.bandq.spring.DAO.ProductsImplementation;
import com.bandq.spring.Entities.Product;
import com.bandq.spring.Services.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class ProductTest {

    private ApplicationContext context;
    private ProductService productService;


    @Before
    public void setUp(){
        context = new ClassPathXmlApplicationContext("spring.xml");
        productService = (ProductService) context.getBean("productService");
    }

    @Test
    public void addCustomer(){
        //arrange
        Product p1 = new Product("Steel", 50 , 60, 10, "Steel beam");
        ProductsDAO products = new ProductsImplementation();
        //act
        products.add(p1);

        //assert
        Product product = products.get(10);
        Assert.assertEquals(product.getPrice(),10);
        products.flush();

    }

    @Test
    public void deleteCustomer(){
        //arrange
        Product p1 = new Product("Steel", 50 , 60, 10, "Steel beam");
        ProductsDAO products = new ProductsImplementation();
        products.add(p1);
        //products.flush();

        //act
        products.delete(1);

        //assert
        Product product = products.get(1);
        Assert.assertNull(product);

    }

    @Test
    public void updateCustomer(){
        //arrange
        Product p1 = new Product("Steel", 50 , 60, 10, "Steel beam");
        ProductsDAO products = new ProductsImplementation();
        products.add(p1);
        p1.setStock(49);
        //act
        products.update(p1);

        //assert
        ArrayList<Product> products1 = (ArrayList<Product>) products.getAll();
        Assert.assertEquals(products1.get(products1.size()-1).getStock(),49);
    }

}
