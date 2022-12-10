package Services;
import Entities.Item;
import Interfaces.IItemServices;
import java.util.ArrayList;
import java.util.UUID;

public class ItemServices implements IItemServices {
    public static ArrayList<Item> items = new ArrayList<Item>();

    @Override
    public void create(Item item) {
        items.add(item);
    }

    @Override
    public void delete(UUID itemId) {
        items.remove(getById(itemId));
    }

    @Override
    public Item getById(UUID itemId) {
        for(int i=0;i<items.size();i++) {
            if(items.get(i).id == itemId) {
                return items.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(UUID itemId, Item item) {
        for(int i=0;i<items.size();i++) {
            if(items.get(i).id == itemId) {
                items.get(i).name = item.name;
                items.get(i).description = item.description;
                items.get(i).price = item.price;
                items.get(i).category = item.category;
                
            }
        }
    }

    @Override
    public ArrayList<Item> getAllItems() {
        return items;
    }

    @Override
    public void addItemsToCustomer(UUID customerId , ArrayList<UUID> itemsIds) {
        
        System.out.println("Added Succesfully");
    }
    
    
}
