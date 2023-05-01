package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Customer {
    public UUID id;
    public String name;
    public String nationalId;
    public String phoneNumber;
    public String city;
    public Date purchaseDate;
    public String email;
    public int income;
    public String job;
    public String gender;
    public int age;
    public ArrayList<UUID> itemIds;
    public ArrayList<Item> items;

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", nationalId=" + nationalId + ", phoneNumber=" + phoneNumber + ", city=" + city + ", purchaseDate=" + purchaseDate + ", email=" + email + ", income=" + income + ", job=" + job + ", gender=" + gender + ", age=" + age + ", itemIds=" + itemIds + ", items=" + items + '}';
    }
    
}
