package com.adminPanel.app.services;

import com.adminPanel.app.model.Product;
import java.util.List;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(int id);

    Product updateProduct(Product product);

    boolean deleteProduct(int id);
}
