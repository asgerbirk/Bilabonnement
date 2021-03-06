package com.example.bilabonnement.Model;

public class DamageReport {
    // Kodet af Asger
    private int id;

    private int agreementID;
    private String damage;
    private int price;

    public DamageReport(String damage, int price, int agreementID){
        this.agreementID = agreementID;
        this.damage = damage;
        this.price = price;
    }

    public DamageReport(int id, String damage, int price) {
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDamage() {
        return damage;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "DamageReport{" +
                "id=" + id +
                ", damage='" + damage + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public int getAgreementID() {
        return agreementID;
    }
}
