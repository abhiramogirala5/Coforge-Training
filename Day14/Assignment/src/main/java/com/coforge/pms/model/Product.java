package com.coforge.pms.model;

public class Product {

    private int pid;
    private String productName;
    private int productPrice;
    private int productQuantity;

    public Product() {
    }

    public Product(int pid, String productName, int productPrice, int productQuantity) {
        this.pid = pid;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getpid() {
        return pid;
    }

    public void setpid(int pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "Product [pid=" + pid + ", productName=" + productName + ", productPrice=" + productPrice
                + ", productQuantity=" + productQuantity + "]";
    }

}