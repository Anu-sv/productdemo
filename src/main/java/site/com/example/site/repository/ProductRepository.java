package site.com.example.site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import site.com.example.site.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>
{	
	//@Query("select  from Laptops l where l.vendorid=v_id")
	//public List<Product> getProductByVendor(long v_id);

	@Query("select v.vendorid from Vendor v where v.vendor_name=:v_name ")
	public long findByendor_name(@Param("v_name") String v_name);


}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

