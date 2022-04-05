package site.com.example.site.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import site.com.example.site.exception.ResourceNotFoundexception;
import site.com.example.site.model.Product;
import site.com.example.site.model.Vendor;
import site.com.example.site.repository.VendorRepository;
import site.com.example.site.service.VendorServicee;
@CrossOrigin(origins="http://localhost:4200/")
@RestController
@RequestMapping("/site/vendor/")
public class VendorController {
	@Autowired
	VendorRepository vendorRepo;
	
	@Autowired
	VendorServicee vendorService;
	
	
	@GetMapping("data")
	public List<Vendor> getAll(){
		return this.vendorRepo.findAll();
	}
	 @PostMapping("/v")
	    public Vendor createVendor(@RequestBody Vendor vendor) {
		 	
	        return this.vendorService.addVendor(vendor);
		
	    }
	 
	 @DeleteMapping("delete/{vendorid}")
	    public ResponseEntity < Vendor > deleteVendor(@PathVariable("vendorid") long vendorid) throws Exception {
		
		 String res=vendorService.deleteVendor(vendorid);
		 
	        return ResponseEntity.ok().build();
	    }
	 
	
	    @PutMapping("put/{vendorid}")
	    public Vendor updateVendor(@RequestBody Vendor vendor, @PathVariable("vendorid") long vendorid) {
	   
	        return this.vendorService.updateVendor(vendorid, vendor);
	    }
	    
	    @GetMapping("/{vendorid}")
	    public Vendor getVendorById(@PathVariable("vendorid") Long vendorid){
	    	return this.vendorRepo.findById(vendorid).orElse(null);
	    }

}
