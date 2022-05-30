package com.example.bilabonnement.Model;

public class DamageReport {
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

    public DamageReport(String damage,int price){
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

    public void setDamage(String damage) {
        this.damage = damage;
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
