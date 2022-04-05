package site.com.example.site.service;

import java.util.List;

import site.com.example.site.model.Product;
import site.com.example.site.model.Vendor;

public interface ProductsService {
	
	List<Product> getAll();
	Product addProduct(Product product,long vendorid);
	String deleteProduct(long id);
	Product updateProduct(long id,Product product);

}
