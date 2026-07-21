package com.coforge.pms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.pms.model.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {

	public List<Product> findByPname(String pname);

	public int deleteByPname(String pname);

	public List<Product> findByPquantity(int pquantity);

	public List<Product> findByPpriceBetween(double minPrice, double maxPrice);

	@Query("select pid from Product")
	public List<Integer> getPids();

	@Query("select count(*), sum(pprice) from Product")
	public String getInfo();
}
