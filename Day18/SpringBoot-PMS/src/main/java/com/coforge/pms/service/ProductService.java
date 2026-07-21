package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;

import com.coforge.pms.model.Product;

public interface ProductService {

	public boolean saveProduct(Product product);

	public boolean updateProduct(int pid, Product product);

	public boolean deleteProductById(int pid);

	public Optional<Product> findByPid(int pid);

	public List<Product> findAllProducts();

	public List<Product> findByPname(String pname);

	public boolean deleteByPname(String pname);

	public List<Product> findByPquantity(int pquantity);

	public List<Product> findByPriceRange(double minPrice, double maxPrice);

	public List<Integer> getPidsList();

	public String getInfo();

}
