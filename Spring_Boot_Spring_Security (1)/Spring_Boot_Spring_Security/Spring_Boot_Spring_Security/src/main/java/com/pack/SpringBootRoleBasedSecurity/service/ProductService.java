package com.pack.SpringBootRoleBasedSecurity.service;

import java.util.List;

import com.pack.SpringBootRoleBasedSecurity.model.Product;

public interface ProductService {
      void saveProduct(Product product);
      List<Product> fetchAllProduct();
      Product getProductById(long id);
      void updateProduct(long prod_id);
      void deleteProduct(long id);
	Product getProductId(long prod_id);
	Product pay(long prod_id);
}
