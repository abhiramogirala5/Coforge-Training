package com.coforge.pms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.coforge.pms.model.Product;

@Service
public class ProductService {

    private Map<Integer, Product> map = new HashMap<>();

    // INSERT
    public boolean createProduct(Product product) {

        // Product ID should be unique
        if (map.containsKey(product.getpid()))
            return false;

        // Validation
        if (product.getProductName() == null || product.getProductName().trim().isEmpty())
            return false;

        if (product.getProductPrice() <= 0)
            return false;

        if (product.getProductQuantity() <= 0)
            return false;

        map.put(product.getpid(), product);
        return true;
    }

    // DELETE
    public boolean deleteProduct(int pid) {

        if (map.containsKey(pid)) {
            map.remove(pid);
            return true;
        }

        return false;
    }

    // UPDATE
    public boolean updateProduct(Product product) {

        if (!map.containsKey(product.getpid()))
            return false;

        if (product.getProductName() == null || product.getProductName().trim().isEmpty())
            return false;

        if (product.getProductPrice() <= 0)
            return false;

        if (product.getProductQuantity() <= 0)
            return false;

        map.put(product.getpid(), product);

        return true;
    }

    // FIND
    public Product findProduct(int pid) {
        return map.get(pid);
    }

    // FIND ALL
    public List<Product> findAllProducts() {
        return new ArrayList<>(map.values());
    }
}