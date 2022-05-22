package com.example.bilabonnement.Model;

public class Car {

    private int carNumber;
    private String model;
    private String brand;
    private String color;
    private int price;
    private boolean isDamaged;

    private boolean isRented;

    public Car(int carNumber, String model, String brand, String color, int price, boolean isDamaged, boolean isRented) {
        this.carNumber = carNumber;
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.isDamaged = isDamaged;
        this.isRented = isRented;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDamaged() {
        return isDamaged;
    }

    public void setDamaged(boolean damaged)  {
        isDamaged = damaged;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNumber=" + carNumber +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", isDamaged=" + isDamaged +
                ", isRented=" + isRented +
                '}';
    }
}
