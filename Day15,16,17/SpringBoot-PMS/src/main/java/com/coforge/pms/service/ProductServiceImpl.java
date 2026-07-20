package com.coforge.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.pms.exception.InvalidProductObjectException;
import com.coforge.pms.exception.ProductNotFoundException;
import com.coforge.pms.model.Product;
import com.coforge.pms.repo.ProductRepo;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepo repo;

	@Autowired
	public ProductServiceImpl(ProductRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public boolean saveProduct(Product product) throws InvalidProductObjectException {

		if (product != null &&
				product.getPid() > 0 &&
				product.getPname() != null &&
				product.getPprice() > 0 &&
				product.getPquantity() > 0) {

			repo.save(product);
			return true;
		}

		throw new InvalidProductObjectException();
	}

	@Override
	public boolean updateProduct(int pid, Product product)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (pid > 0 &&
				product != null &&
				product.getPid() > 0 &&
				product.getPname() != null &&
				product.getPprice() > 0 &&
				product.getPquantity() > 0) {

			if (!repo.existsById(pid)) {
				throw new ProductNotFoundException();
			}

			repo.save(product);
			return true;
		}

		throw new InvalidProductObjectException();
	}

	@Override
	public boolean deleteProductById(int pid)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (pid > 0) {

			if (!repo.existsById(pid)) {
				throw new ProductNotFoundException();
			}

			repo.deleteById(pid);
			return true;
		}

		return false;
	}

	@Override
	public Optional<Product> findByPid(int pid)
			throws ProductNotFoundException, InvalidProductObjectException {

		if (pid > 0) {

			if (!repo.existsById(pid)) {
				throw new ProductNotFoundException();
			}

			return repo.findById(pid);
		}

		throw new InvalidProductObjectException();
	}

	@Override
	public List<Product> findAllProducts() {
		return (List<Product>) repo.findAll();
	}

	@Override
	public List<Product> findByPname(String pname)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (pname != null) {

			List<Product> products = repo.findByPname(pname);

			if (products.isEmpty()) {
				throw new ProductNotFoundException();
			}

			return products;
		}

		throw new InvalidProductObjectException();
	}

	@Override
	@Transactional
	public boolean deleteByPname(String pname)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (pname != null) {

			int n = repo.deleteByPname(pname);

			if (n == 0) {
				throw new ProductNotFoundException();
			}

			return true;
		}

		throw new InvalidProductObjectException();
	}

	@Override
	public List<Product> findByPquantity(int pquantity)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (pquantity > 0) {

			List<Product> products = repo.findByPquantity(pquantity);

			if (products.isEmpty()) {
				throw new ProductNotFoundException();
			}

			return products;
		}

		throw new InvalidProductObjectException();
	}

	@Override
	public List<Product> findByPriceRange(double minPrice, double maxPrice)
			throws InvalidProductObjectException, ProductNotFoundException {

		if (minPrice > 0 && maxPrice > 0) {

			List<Product> products = repo.findByPpriceBetween(minPrice, maxPrice);

			if (products.isEmpty()) {
				throw new ProductNotFoundException();
			}

			return products;
		}

		throw new InvalidProductObjectException();
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
