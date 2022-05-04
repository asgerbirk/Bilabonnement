package com.example.bilabonnement.Model;

public class CustomerAgreement {

    private int agreementID;
    private Customer customer;
    private Car car;
    private int period;
    private int price;

    public CustomerAgreement(int agreementID, Customer customer, Car car, int period, int price) {
        this.agreementID = agreementID;
        this.customer = customer;
        this.car = car;
        this.period = period;
        this.price = price;
    }

    public int getAgreementID() {
        return agreementID;
    }

    public void setAgreementID(int agreementID) {
        this.agreementID = agreementID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CustomerAgreement{" +
                "agreementID=" + agreementID +
                ", customer=" + customer +
                ", car=" + car +
                ", period=" + period +
                ", price=" + price +
                '}';
    }
}
