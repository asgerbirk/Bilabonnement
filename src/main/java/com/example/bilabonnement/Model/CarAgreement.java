package com.example.bilabonnement.Model;

public class CarAgreement extends Agreement{

    private Car car;
    private String location;

    public CarAgreement(int agreementID, Customer customer, int period, int price, Car car, String location) {
        super(agreementID, customer, period, price);
        this.car = car;
        this.location = location;
    }

    public CarAgreement(Customer customer, int period, int price, Car car, String location) {
        super(customer, period, price);
        this.car = car;
        this.location = location;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CarAgreement{" +
                "car=" + car +
                ", location='" + location + '\'' +
                '}';
    }
}
