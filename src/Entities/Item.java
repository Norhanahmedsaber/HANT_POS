package Entities;

import java.util.Date;
import java.util.UUID;

public class Item {
   // public UUID id;
    public String name;
    public String description;
    public int price;
    public String category;
    public String createdAt;
    public String updatedAt;
    
   public Item(String name,String description ,int price,String category,String createdAt, String updatedAt )
   {
       this.name= name;
       this.description=description;
       this.price=price;
       this.category=category;
       this.updatedAt=updatedAt;  
       this.createdAt= createdAt;
   }
    
}
