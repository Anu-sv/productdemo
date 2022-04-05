package site.com.example.site.service;
import java.util.List;
import site.com.example.site.model.Vendor;
public interface VendorServicee {
	
	List<Vendor> getAll();
	Vendor addVendor(Vendor vendor);
	String deleteVendor(long vendorid);
	Vendor updateVendor(long vendorid,Vendor vendor);

}
