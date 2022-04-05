package site.com.example.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.com.example.site.exception.ResourceNotFoundexception;
import site.com.example.site.model.Product;
import site.com.example.site.model.Vendor;
import site.com.example.site.repository.ProductRepository;
import site.com.example.site.repository.VendorRepository;
@Service
public class ProductServiceImpl implements ProductsService{
	@Autowired
	ProductRepository productRepo;

	@Autowired
	VendorRepository vendorRepo;
	
	
	@Override
	public List<Product> getAll(){
		return productRepo.findAll();
		
	}
	@Override
	public Product addProduct(Product product,long vendorid) {
		Vendor vendor=vendorRepo.findById(vendorid).orElse(null);
 		product.setVendor(vendor);
        return this.productRepo.save(product);
		
	}
	@Override
	public String deleteProduct(long id) {
		 Product existingProduct = this.productRepo.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundexception("Product not found with id :" + id));
		         this.productRepo.delete(existingProduct);
		return "ok";
	}
	@Override
	public Product updateProduct(long id,Product product) {
		Product existingProduct = this.productRepo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundexception("Product not found with id :" + id));
	    	existingProduct.setModel_name(product.getModel_name());
	    	existingProduct.setOs(product.getOs());
	    	existingProduct.setRam(product.getRam());
	    	existingProduct.setHarddrive_size(product.getHarddrive_size());
	    	existingProduct.setStack_available(product.getStack_available());
	    	Vendor vendor=vendorRepo.findById(product.getVendor().getId()).orElse(null);
	    	existingProduct.setVendor(vendor);
	    	//existingProduct
	        return this.productRepo.save(existingProduct);
	
	}

}
