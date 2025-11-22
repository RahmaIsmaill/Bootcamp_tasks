package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import java.util.List;

public interface ProductDAO {

    Product saveProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(int id);

    Product updateProduct(Product product);

    boolean deleteProduct(int id);
}
