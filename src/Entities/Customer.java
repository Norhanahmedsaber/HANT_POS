package Entities;

import java.util.ArrayList;
import java.util.UUID;

public class Customer {
    // id (GUID)
    public String name;
    public String nationalId;
    public String phoneNumber;
    public String address;
    
    public int income;
    // public enum gender;
    public int age;
    public ArrayList<UUID> itemIds;
    public ArrayList<Item> items;
    
}
