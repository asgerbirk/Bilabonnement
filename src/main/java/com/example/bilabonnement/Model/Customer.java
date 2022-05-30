package com.example.bilabonnement.Model;

public class Customer {
    // Kodet af Mikkel og Simon

    private int ID;
    private String firstname;
    private String surname;
    private String email;
    private String phoneNumber;

    private String password;

    public Customer(int ID, String firstname, String surname, String email, String phoneNumber) {
        this.ID = ID;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    public Customer(String firstname, String surname, String email, String phoneNumber, String password){
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }
    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword(){
        return password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + ID +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
