package site.com.example.site.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Vendors")
public class Vendor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long vendorid;
	@Column(unique=true,nullable=false,name="VendorName")
	private String vendor_name;
	@Column(name="Rating")
	private String rating;
	@Column(name="Address")
	private String address;
	@Column(name="ContactNo")
	private String contact_number;
	@JsonIgnore
	@OneToMany(fetch= FetchType.EAGER, mappedBy="vendor",orphanRemoval=true,cascade= CascadeType.ALL)
	
	private Set<Product> products=new HashSet<Product>();
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Vendor() {
		
	}
	public Vendor(String vendor_name, String rating, String address, String contact_number) {
		super();
		this.vendor_name = vendor_name;
		this.rating = rating;
		this.address = address;
		this.contact_number = contact_number;
		//this.product=product;
	}
	
	public long getId() {
		return vendorid;
	}
	public void setId(long venderid) {
		this.vendorid = venderid;
	}
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public long getVendorid() {
		return vendorid;
	}
	public void setVendorid(long vendorid) {
		this.vendorid = vendorid;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

}
