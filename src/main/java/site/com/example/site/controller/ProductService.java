package site.com.example.site.controller;

import java.util.List;



import javax.management.relation.RelationNotFoundException;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import site.com.example.site.exception.ResourceNotFoundexception;
import site.com.example.site.model.Product;
import site.com.example.site.model.Vendor;
import site.com.example.site.repository.ProductRepository;
import site.com.example.site.repository.VendorRepository;
import site.com.example.site.service.ProductsService;
@CrossOrigin(origins="http://localhost:4200/")

@RestController
@RequestMapping("/site/product/")
public class ProductService {
	@Autowired
	ProductRepository productRepo;
	@Autowired
	VendorRepository vendorRepo;
	@Autowired
	ProductsService productService;
	
	@GetMapping("/data")
	public List<Product> getAllProduct(){
		return this.productService.getAll();
	}
	
	 @GetMapping("/{id}")
	    public Product getById(@PathVariable("id") Long id){
	    	return this.productRepo.findById(id).orElse(null);
	    }

	
	@CrossOrigin(origins="http://localhost:4200/")
	 @PostMapping("/post/{vendorid}")
	    public Product createUser(@RequestBody Product product,@PathVariable("vendorid") Long vendorid) {
	
			return this.productService.addProduct(product, vendorid);
		 
		
	    }
	
	 
	 @DeleteMapping("delete/{id}")
	    public ResponseEntity < Vendor > deleteUser(@PathVariable("id") long id) throws Exception {
		
		 String res=productService.deleteProduct(id);
		 
	        return ResponseEntity.ok().build();
	    }
	 
	 
	
	   @PutMapping("/{id}")
	  public Product updateUser(@RequestBody Product product, @PathVariable("id") long id) {
	    		   return this.productService.updateProduct(id,product);

	    }
	   
}
