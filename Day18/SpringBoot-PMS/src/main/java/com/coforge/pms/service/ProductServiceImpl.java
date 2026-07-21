package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.coforge.pms.exception.ProductNotFoundException;
import com.coforge.pms.model.Product;
import com.coforge.pms.repo.ProductRepo;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepo repo;
	private Environment environment;

	@Autowired
	public ProductServiceImpl(ProductRepo repo, Environment environment) {
		super();
		this.repo = repo;
		this.environment = environment;
	}

	@Override
	public boolean saveProduct(Product product) {

		repo.save(product);
		return true;

	}

	@Override
	public boolean updateProduct(int pid, Product product) throws ProductNotFoundException {

		if (!repo.existsById(pid)) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
		}

		repo.save(product);
		return true;

	}

	@Override
	public boolean deleteProductById(int pid) throws ProductNotFoundException {

		if (pid > 0) {

			if (!repo.existsById(pid)) {
				throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
			}

			repo.deleteById(pid);
			return true;
		}

		return false;
	}

	@Override
	public Optional<Product> findByPid(int pid) throws ProductNotFoundException {

		if (!repo.existsById(pid)) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
		}

		return repo.findById(pid);

	}

	@Override
	public List<Product> findAllProducts() {
		return (List<Product>) repo.findAll();
	}

	@Override
	public List<Product> findByPname(String pname) throws ProductNotFoundException {

		List<Product> products = repo.findByPname(pname);

		if (products.isEmpty()) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
		}

		return products;
	}

	@Override
	@Transactional
	public boolean deleteByPname(String pname) throws ProductNotFoundException {

		int n = repo.deleteByPname(pname);

		if (n == 0) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
		}

		return true;

	}

	@Override
	public List<Product> findByPquantity(int pquantity) throws ProductNotFoundException {

		List<Product> products = repo.findByPquantity(pquantity);

		if (products.isEmpty()) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
		}

		return products;

	}

	@Override
	public List<Product> findByPriceRange(double minPrice, double maxPrice) throws ProductNotFoundException {

		List<Product> products = repo.findByPpriceBetween(minPrice, maxPrice);

		if (products.isEmpty()) {
			throw new ProductNotFoundException(environment.getProperty("pms.invalid.product-notfound"));
		}

		return products;

	}

	@Override
	public List<Integer> getPidsList() {
		return repo.getPids();
	}

	@Override
	public String getInfo() {
		return repo.getInfo();
	}
}
