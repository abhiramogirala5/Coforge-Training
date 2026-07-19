package com.coforge.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.coforge.pms.model.Product;
import com.coforge.pms.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/home")
    public ModelAndView loadHomePage() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("ProductHome");

        return mv;
    }

    // INSERT
    @RequestMapping(value = "/product", method = RequestMethod.POST, params = "Insert")
    public ModelAndView createProduct(@ModelAttribute Product product) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("ProductHome");

        boolean status = service.createProduct(product);

        if(status)
            mv.addObject("result","Product Added Successfully");
        else
            mv.addObject("result",
                "Product ID already exists or Invalid Data");

        return mv;
    }

    // DELETE
    @RequestMapping(value = "/product", method = RequestMethod.POST, params = "Delete")
    public ModelAndView deleteProduct(@RequestParam("pid") int pid) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("ProductHome");

        boolean status = service.deleteProduct(pid);

        if(status)
            mv.addObject("result","Product Deleted Successfully");
        else
            mv.addObject("result","Product Not Found");

        return mv;
    }
    
    //Update
    @RequestMapping(value = "/product", method = RequestMethod.POST, params = "Update")
    public ModelAndView updateProduct(@ModelAttribute Product product) {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("ProductHome");
    	
    	boolean status = service.updateProduct(product);
    	
    	if(status)
    	    mv.addObject("result","Product Updated Successfully");
    	else
    	    mv.addObject("result",
    	        "Product Not Found or Invalid Data");
    	
    	return mv;
    }
    
    @RequestMapping(value="/product", method=RequestMethod.POST, params="Find")
    public ModelAndView findProduct(@RequestParam("pid") int pid) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("ProductHome");

        Product product = service.findProduct(pid);

        if(product!=null){
            mv.addObject("product",product);
            mv.addObject("result","Product Found");
        }
        else{
            mv.addObject("result","Product Not Found");
        }

        return mv;
    }
    

    @RequestMapping(value="/product", method=RequestMethod.POST, params="FindAll")
    public ModelAndView findAllProducts() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("ProductHome");

        List<Product> list = service.findAllProducts();

        if(!list.isEmpty()){
            mv.addObject("list",list);
        }
        else{
            mv.addObject("result","No Products Available");
        }

        return mv;
    }

}