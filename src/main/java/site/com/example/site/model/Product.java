package site.com.example.site.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Laptops")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private long id;
	@Column(name="ModelName",nullable=false)
	private String model_name;
	@Column(name="OS",nullable=false)
	private String os;
	@Column(name="RAM",nullable=false)
	private String ram;
	
	@Column(name="HarddriveSize",nullable=false)
	private String harddrive_size;
	
	@Column(name="Availablestock",nullable=false)
	private int stack_available;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="vendorid",nullable=false)
	@JsonIgnoreProperties("products")
	private Vendor vendor;
	
public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	

	public Product() {
		
	}
	
	public Product(String model_name, String os, String ram, String harddrive_size, int stack_available
			,Vendor vendor) {
		super();
		this.model_name = model_name;
		this.os = os;
		this.ram = ram;
		this.harddrive_size = harddrive_size;
		this.stack_available = stack_available;
		this.vendor = vendor;
	}
	

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getModel_name() {
		return model_name;
	}
	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getHarddrive_size() {
		return harddrive_size;
	}
	public void setHarddrive_size(String harddrive_size) {
		this.harddrive_size = harddrive_size;
	}
	public int getStack_available() {
		return stack_available;
	}
	public void setStack_available(int stack_available) {
		this.stack_available = stack_available;
	}
	
	


}
