package Interfaces;

import Entities.Item;
import java.util.ArrayList;
import java.util.UUID;

public interface IItemServices {
    void create(Item item);
    void delete(UUID itemId);
    Item getById(UUID itemId);
    // UUID to be figured
    void update(UUID ItemId, Item item);
    ArrayList<Item> getAllItems();
    void addItemsToCustomer(UUID customerId, ArrayList<UUID> itemsIds);
}
