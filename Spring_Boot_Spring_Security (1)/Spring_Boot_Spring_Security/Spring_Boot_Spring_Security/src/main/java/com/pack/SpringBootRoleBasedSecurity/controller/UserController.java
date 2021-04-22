package com.pack.SpringBootRoleBasedSecurity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.SpringBootRoleBasedSecurity.model.Product;
import com.pack.SpringBootRoleBasedSecurity.model.Role;
import com.pack.SpringBootRoleBasedSecurity.model.User;
import com.pack.SpringBootRoleBasedSecurity.model.changePassword;
import com.pack.SpringBootRoleBasedSecurity.service.ProductService;
import com.pack.SpringBootRoleBasedSecurity.service.UserService;
import com.pack.SpringBootRoleBasedSecurity.validator.UserValidator;



@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductService productService;

    @Autowired
    private UserValidator userValidator;
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
    	userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
//        Set<Role> role=userForm.getRoles();
//        userForm.setRoles(role);
       userService.save(userForm);
     

        return "redirect:/welcome";
    }
    
    @RequestMapping(value = "/cpassword", method = RequestMethod.GET)
    public String cPassword(Model model) {
        model.addAttribute("userForm1", new changePassword());

        return "cpassword";
    }
    
    @RequestMapping(value = "/cpassword", method = RequestMethod.POST)
    public String cpassword(@ModelAttribute("userForm1") changePassword userForm1,  Model model) {
    	
//        Set<Role> role=userForm.getRoles();
//        userForm.setRoles(role);
       userService.changePwd(userForm1);
     

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", " Username or Password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	List<Product> list=productService.fetchAllProduct();
    	model.addAttribute("plist",list);
        return "welcome";
    }
   
    @ModelAttribute("roleList")
	public Map<Integer,String> initializeRoles() {
    	Map<Integer, String> map = new HashMap<Integer, String>();
    	map.put(1,"ADMIN");
		map.put(2,"USER");
		map.put(3,"CREATOR");
	
		return map;
	}
    
    @RequestMapping(value="/new",method=RequestMethod.GET)
    public String createProduct(Model model) {
    	model.addAttribute("productForm", new Product());
    	return "new_product";
    }
    
    @RequestMapping(value="/save",method=RequestMethod.POST)
    public String addProduct(@ModelAttribute("productForm") Product product) {
    	Random rand=new Random();
    	long id=rand.nextInt(90000)+10000;
    	product.setId(id);
    	productService.saveProduct(product);
    	return "redirect:/welcome";   	
    }
    
  /* @RequestMapping(value="/Approve/{pid}")
    public String fetchProduct(@PathVariable("pid") long prod_id,Model model) {
    	Product prod=productService.getProductById(prod_id);
    	model.addAttribute("editProduct", prod);
    	return "edit_product";
    }*/
    
    @RequestMapping(value="/Approve/{pid}")
    public String updateProduct(@PathVariable("pid") long prod_id) {
    	//System.out.println("update"+product);
    	productService.updateProduct(prod_id);
    	return "redirect:/welcome";  
    }
    
    @RequestMapping(value="/Reject/{pid}")
    public String rejectProduct(@PathVariable("pid") long prod_id) {
    	productService.deleteProduct(prod_id);
    	return "redirect:/welcome";  
    }
    
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied() {
        return "403";
    }

    @RequestMapping(value="Pay/{pid}")
    public String pay(@PathVariable("pid") long prod_id,Model model) {
    Product prod=productService.pay(prod_id);
    if(prod.equals(null))	
		return "pending";  
    	
    	else
    	{
    		if(prod.getPayment().equalsIgnoreCase("Paid"))
    			return "paid";
    		else {
      	model.addAttribute("pay", prod);
        
    	return "pay";}
    	}
    
  
    	
    }
}