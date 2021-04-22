package com.pack.SpringBootRoleBasedSecurity.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.SpringBootRoleBasedSecurity.model.Product;
import com.pack.SpringBootRoleBasedSecurity.repository.ProductRepsitory;

@Service
@Transactional
public class ProductServiceImpl  implements ProductService{
	
	@Autowired
	private ProductRepsitory productRepository;

	@Override
	public void saveProduct(Product product) {
		product.setStatus("Pending");
		product.setPayment("Pending");
		productRepository.save(product);
	}

	@Override
	public List<Product> fetchAllProduct() {
		List<Product> list=productRepository.findAll();
		return list;
	}

	@Override
	public Product getProductById(long id) {
		Product prod=productRepository.getOne(id);
		return prod;
	}

	@Override
	public void updateProduct(long prod_id) {
		//product.setStatus("Approved");
		String status="Approved";
	/*	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		DateFormat dateTime;
		System.out.println(dateTime.format(formatter));*/
		Optional<Product> product=productRepository.findById(prod_id);
		if(product.get().getStatus().equals("Pending"))
		productRepository.update(prod_id,status);
	}

	@Override
	public void deleteProduct(long id) {
		String status="Rejected";
		Optional<Product> product=productRepository.findById(id);
		if(product.get().getStatus().equals("Pending"))
		productRepository.update(id,status);
	}

	@Override
	public Product getProductId(long id) {
		// TODO Auto-generated method stub
		return productRepository.getOne(id);
	}

	@Override
	public Product pay(long prod_id) {
		// TODO Auto-generated method stub
		
	Product prod=productRepository.getOne(prod_id);
    	if(prod.getStatus().equalsIgnoreCase("Approved")&&prod.getPayment().equalsIgnoreCase("pending")) { 
    		productRepository.updatePayment(prod_id,"Paid");
    		return prod;
    
    	}
    	else 
    		return null;
    	
	}
	
	

}
