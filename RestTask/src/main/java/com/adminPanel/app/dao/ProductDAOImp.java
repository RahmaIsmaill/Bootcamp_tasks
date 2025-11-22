package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImp implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Product saveProduct(Product product) {
        getSession().save(product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return getSession()
                .createQuery("from Product", Product.class)
                .list();
    }

    @Override
    public Product getProductById(int id) {
        return getSession().get(Product.class, id);
    }

    @Override
    public Product updateProduct(Product product) {
        getSession().update(product);
        return product;
    }

    @Override
    public boolean deleteProduct(int id) {
        Product product = getSession().get(Product.class, id);
        if (product != null) {
            getSession().delete(product);
            return true;
        }
        return false;
    }
}
