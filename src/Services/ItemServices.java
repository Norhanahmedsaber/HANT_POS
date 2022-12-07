package Services;
import Entities.Item;
import Interfaces.IItemServices;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class ItemServices implements IItemServices {

    @Override
    public void create(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(UUID itemId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Item getById(UUID itemId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(UUID ItemId, Item item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Item> getAllItems() {
        ArrayList<Item> _item = new ArrayList<Item>();
        Item _Item1=new Item ("washingmachine", "electrical",500,"e","12-2-2022","12-10-2020");
        Item _Item2=new Item ("oven", "electrical",400,"e","12-3-2022","12-12-2020");
        Item _Item3=new Item ("cook", "electrical",300,"e","12-4-2022","12-11-2020");
    
           _item.add(_Item1);
           _item.add(_Item2);
           _item.add(_Item3);
    return _item;
    
    }
}
