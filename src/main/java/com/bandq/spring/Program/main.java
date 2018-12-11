package com.bandq.spring.Program;


import com.bandq.spring.DAO.ProductsDAO;
import com.bandq.spring.DAO.ProductsImplementation;
import com.bandq.spring.Entities.Address;
import com.bandq.spring.Entities.Category;
import com.bandq.spring.Entities.Product;
import com.bandq.spring.Services.ProductService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ProductService productService = (ProductService) context.getBean("productService");

        Product p1 = new Product(1,"Steel", 50 , 60, 10, "Steel beam");

        System.out.println(productService.productWithVAT(p1));


        ProductsDAO products = new ProductsImplementation();
        //List<Product> productList = products.getAll();
        //Product p1 = productList.get(0);
        //System.out.println(productList.size());
        //products.delete(p1);
        //products.update(p1);
        //products.deleteAll();
        //products.add(p1);
        //products.flush();

        addCategories();

    }

    private void testEMFProducts(){
        /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("productsUnit");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("productsUnit");
        Product p1 = new Product();
        Product p2 = new Product();
        Category c1 = new Category();

        p1.setName("Stone");
        p2.setName("Nails");
        c1.setName("Material");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(c1);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();*/
    }

    private void testCar(){
        //Car<Integer,String> honda = new Car<Integer, String>();

        //honda.add(15, "honda");
        //System.out.println(honda.<Integer>drive(5));
        //System.out.println(honda.<Integer, Object>start(5, "The car is starting"));
        //System.out.println(honda.<Integer>getReg(5));
        //System.out.println(honda.<Double>getReg((5.2)));
        //System.out.println(honda.<Byte>getReg((byte) 304));
        //IWheel wheel = new Wheel();
        //honda.<IWheel>calculate(wheel);
        //ContinentalWheel contWheel = new ContinentalWheel();
        //System.out.println(honda.<IWheel>calculate(contWheel).calculate(5,5));

        //System.out.println(honda.get());
        //System.out.println(honda.getV());
    }

    private static void getPaginationCatagories(){
        Session session = HibernateUtility.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String hql = "from Category";
        Query query = session.createQuery(hql);
        query.setFirstResult(0);
        query.setMaxResults(2);
        List<Category> categories = query.list();

        for (Category category : categories){
            System.out.println(category.getName());
            System.out.println(category.getId());
            //System.out.println(category.get_products().size());
        }


        HibernateUtility.getSessionFactory().close();
    }

    private static void getCategoriesSorted(){
        Session session = HibernateUtility.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String hql = "from Category order by name ASC";
        Query query = session.createQuery(hql);
        List<Category> categories = query.list();

        for (Category category : categories){
            System.out.println(category.getName());
            System.out.println(category.getId());
            //System.out.println(category.get_products().size());
        }


        HibernateUtility.getSessionFactory().close();
    }

    private static void updateCategories(){
        Session session = HibernateUtility.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String hql = "update Category set name = :name where Id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("name", "Lumber");
        query.setParameter("id", 1);
        int result = query.executeUpdate();
        System.out.println(result);

        session.getTransaction().commit();
        HibernateUtility.getSessionFactory().close();
    }

    private static void getCategories(){
        Session session = HibernateUtility.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String hql = "from Category where Id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", 3);
        List<Category> categories = query.list();

        for (Category category : categories){
            System.out.println(category.getName());
            System.out.println(category.getId());
            //System.out.println(category.get_products().size());
        }


        HibernateUtility.getSessionFactory().close();
    }


    private static void removeCategories(){
        ArrayList<Product> products = new ArrayList<Product>();
        Product p1 = new Product();
        Category c1 = new Category();


        p1.setName("Cement");
        p1.setPrice(20);
        p1.setStock(100);
        p1.setWeight(5);

        products.add(p1);

        c1.setName("Building Materials");
        c1.set_products(products);

        Session session = HibernateUtility.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(p1);
        session.save(c1);
        session.getTransaction().commit();

        Session deleteSession = HibernateUtility.getSessionFactory().getCurrentSession();
        deleteSession.beginTransaction();

        deleteSession.delete(c1);
        deleteSession.getTransaction().commit();
        HibernateUtility.getSessionFactory().close();
    }

    private static void addCategories(){
        ArrayList<Product> products = new ArrayList<Product>();
        Product p1 = new Product();
        Category c1 = new Category();


        p1.setName("Cement");
        p1.setPrice(20);
        p1.setStock(100);
        p1.setWeight(5);
        p1.setDescription("Cement");

        products.add(p1);

        c1.setName("Building Materials");
        c1.set_products(products);

        Session session = HibernateUtility.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.save(p1);
        session.save(c1);
        session.getTransaction().commit();
        HibernateUtility.getSessionFactory().close();
    }


}
