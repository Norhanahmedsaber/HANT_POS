package Entities;

import java.util.Date;
import java.util.UUID;

public class Item {
    public UUID id;
    public String name;
    public String description;
    public int price;
    public String category;
    public Date createdAt;
    public Date updatedAt;
    
    
    @Override
    public String toString() {
            return this.name+this.description+this.price+this.category;
        }
}
