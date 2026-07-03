package com.coforge.day3;

public class Mobile {
	private String brand;
    private String model;
    private int ram;
    private double price;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mobile [Brand=" + brand + ", Model=" + model + ", RAM=" + ram + "GB, Price=" + price + "]";
    }
}
