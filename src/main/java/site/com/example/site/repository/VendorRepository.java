package site.com.example.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import site.com.example.site.model.Product;
import site.com.example.site.model.Vendor;
@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long>{

}
