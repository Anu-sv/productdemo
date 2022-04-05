package site.com.example.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import site.com.example.site.exception.ResourceNotFoundexception;
import site.com.example.site.model.Vendor;
import site.com.example.site.repository.VendorRepository;
@Service
public class VendorServiceImpl implements VendorServicee{
	
	@Autowired
	VendorRepository vendorRepo;
	
	@Override
	public List<Vendor> getAll() {
		return vendorRepo.findAll();
	}
	
	@Override
	public Vendor addVendor(Vendor vendor) {
		return this.vendorRepo.save(vendor);
		
	}
	@Override
	public String deleteVendor(long vendorid) {
		 Vendor existingvendor = this.vendorRepo.findById(vendorid)
				 .orElseThrow(() -> new ResourceNotFoundexception("Vendor not found with id :" + vendorid));
		         this.vendorRepo.delete(existingvendor);
		return "ok";
	}
	@Override
	public Vendor updateVendor(long vendorid,Vendor vendor) {
		Vendor existingvendor = this.vendorRepo.findById(vendorid)
	            .orElseThrow(() -> new ResourceNotFoundexception("Vendor not found with id :" + vendorid));
	    	existingvendor.setVendor_name(vendor.getVendor_name());
	    	existingvendor.setRating(vendor.getRating());
	    	existingvendor.setContact_number(vendor.getContact_number());
	    	existingvendor.setAddress(vendor.getAddress());
	    	
		
	    	return this.vendorRepo.save(existingvendor);
		
	}
}
