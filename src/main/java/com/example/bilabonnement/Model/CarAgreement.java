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

    public String getLocation() {
        return location;
    }
    @Override
    public String toString() {
        return "CarAgreement{" +
                "car=" + car +
                ", location='" + location + '\'' +
                '}';
    }
}
