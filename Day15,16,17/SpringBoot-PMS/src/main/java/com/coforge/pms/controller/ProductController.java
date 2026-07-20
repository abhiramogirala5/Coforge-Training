package com.coforge.pms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.pms.exception.InvalidProductObjectException;
import com.coforge.pms.exception.ProductNotFoundException;
import com.coforge.pms.model.Product;
import com.coforge.pms.service.ProductService;

@RestController
@RequestMapping("/api/v1/pms")
public class ProductController {

	private ProductService service;
	private Environment environment;

	@Autowired
	public ProductController(ProductService service, Environment environment) {
		super();
		this.service = service;
		this.environment = environment;
	}

	@PostMapping("/products")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {

		ResponseEntity<String> responseEntity = null;

		try {

			boolean status = service.saveProduct(product);

			if (status)
				responseEntity = new ResponseEntity<>(environment.getProperty("pms.save.success"),
						HttpStatus.CREATED);

		} catch (InvalidProductObjectException e) {

			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@PutMapping("/products/{pid}")
	public ResponseEntity<String> updateProduct(@PathVariable("pid") int pid,
			@RequestBody Product product) {

		ResponseEntity<String> responseEntity = null;

		try {

			boolean status = service.updateProduct(pid, product);

			if (status)
				responseEntity = new ResponseEntity<>(environment.getProperty("pms.update.success"),
						HttpStatus.CREATED);

		} catch (InvalidProductObjectException e) {

			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);

		} catch (ProductNotFoundException e) {

			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@DeleteMapping("/products/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable("pid") int pid) {

		ResponseEntity<String> responseEntity = null;

		try {

			boolean status = service.deleteProductById(pid);

			if (status)
				responseEntity = new ResponseEntity<>(environment.getProperty("pms.delete.success"),
						HttpStatus.CREATED);

		} catch (InvalidProductObjectException e) {

			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);

		} catch (ProductNotFoundException e) {

			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@GetMapping("/products/{pid}")
	public ResponseEntity<String> findByPid(@PathVariable("pid") int pid) {

		ResponseEntity<String> responseEntity = null;

		try {

			Optional<Product> product = service.findByPid(pid);

			if (product.isPresent())
				responseEntity = new ResponseEntity<>(product.get().toString(), HttpStatus.OK);

		} catch (InvalidProductObjectException e) {

			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);

		} catch (ProductNotFoundException e) {

			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@GetMapping("/products")
	public ResponseEntity<?> findAllProducts() {

		ResponseEntity<?> responseEntity = null;

		try {

			List<Product> products = service.findAllProducts();

			responseEntity = new ResponseEntity<>(products, HttpStatus.OK);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@GetMapping("/products/pname/{pname}")
	public ResponseEntity<?> findByPname(@PathVariable("pname") String pname) {

		ResponseEntity<?> responseEntity = null;

		try {

			List<Product> products = service.findByPname(pname);

			responseEntity = new ResponseEntity<>(products, HttpStatus.OK);

		} catch (InvalidProductObjectException e) {

			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);

		} catch (ProductNotFoundException e) {

			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@DeleteMapping("/products/pname/{pname}")
	public ResponseEntity<?> deleteByPname(@PathVariable("pname") String pname) {

		ResponseEntity<?> responseEntity = null;

		try {

			boolean status = service.deleteByPname(pname);

			if (status)
				responseEntity = new ResponseEntity<>(environment.getProperty("pms.delete.success"),
						HttpStatus.OK);

		} catch (InvalidProductObjectException e) {

			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);

		} catch (ProductNotFoundException e) {

			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@GetMapping("/products/pquantity/{pquantity}")
	public ResponseEntity<?> findByPquantity(@PathVariable("pquantity") int pquantity) {

		ResponseEntity<?> responseEntity = null;

		try {

			List<Product> products = service.findByPquantity(pquantity);

			responseEntity = new ResponseEntity<>(products, HttpStatus.OK);

		} catch (InvalidProductObjectException e) {

			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);

		} catch (ProductNotFoundException e) {

			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@GetMapping("/products/price/{minPrice}/{maxPrice}")
	public ResponseEntity<?> findByPriceRange(@PathVariable("minPrice") double minPrice,
			@PathVariable("maxPrice") double maxPrice) {

		ResponseEntity<?> responseEntity = null;

		try {

			List<Product> products = service.findByPriceRange(minPrice, maxPrice);

			responseEntity = new ResponseEntity<>(products, HttpStatus.OK);

		} catch (InvalidProductObjectException e) {

			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);

		} catch (ProductNotFoundException e) {

			responseEntity = new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@GetMapping("/products/pids")
	public ResponseEntity<?> getPidsList() {

		ResponseEntity<?> responseEntity = null;

		try {

			List<Integer> pids = service.getPidsList();

			responseEntity = new ResponseEntity<>(pids, HttpStatus.OK);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@GetMapping("/products/info")
	public ResponseEntity<?> getInfo() {

		ResponseEntity<?> responseEntity = null;

		try {

			String info = service.getInfo();

			responseEntity = new ResponseEntity<>(info, HttpStatus.OK);

		} catch (Exception e) {

			responseEntity = new ResponseEntity<>(environment.getProperty("pms.db.failed"),
					HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

}
