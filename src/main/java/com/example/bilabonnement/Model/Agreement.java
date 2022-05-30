package com.example.bilabonnement.Model;

public class    Agreement {

    private int agreementID;
    private Customer customer;
    private int period;
    private int price;

    public Agreement(int agreementID, Customer customer, int period, int price) {
        this.agreementID = agreementID;
        this.customer = customer;
        this.period = period;
        this.price = price;
    }

    public Agreement(Customer customer, int period, int price) {
        this.customer = customer;
        this.period = period;
        this.price = price;
    }

    public int getAgreementID() {
        return agreementID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getPeriod() {
        return period;
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
                ", period=" + period +
                ", price=" + price +
                '}';
    }
}
