package Interfaces;

import Entities.CategoryInfo;
import Entities.Item;
import java.util.ArrayList;
import java.util.UUID;

public interface IItemServices {
    boolean create(Item item);
    boolean delete(UUID itemId);
    Item getById(UUID itemId);
    // UUID to be figured
    boolean update(UUID ItemId, Item item);
    ArrayList<Item> getAllItems();
    void addItemsToCustomer(UUID customerId, ArrayList<UUID> itemsIds);
    void deleteItemFromCustomers(UUID itemId);
    ArrayList<CategoryInfo> getCatsInfo(); 
    boolean deleteAll();
}
 