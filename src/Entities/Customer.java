package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Customer {
    // id (GUID)
    public String name;
    public String nationalId;
    public String phoneNumber;
    public String address;
    public Date purchaseDate;
    public String email;
    public int income;
    public String job;
    // public enum gender;
    public String gender;
    public int age;
    public ArrayList<UUID> itemIds;
    public ArrayList<Item> items;
    
}
