package utils;

import Entities.Item;
import java.util.ArrayList;

public class filterItems {
    public ArrayList<Item> filter(ArrayList<Item> items,String search,String sortitemby) {
       ArrayList <Item> filtered = search(items, search);
        return filtered;
       
    }
    public ArrayList<Item> search(ArrayList<Item> items , String search )
    {
        ArrayList <Item> itemsAftersearch = new ArrayList<Item>();
        for(int i=0 ; i<items.size();i++)
        {
            boolean name = items.get(i).name.contains(search.toLowerCase().trim());
            boolean catgory =items.get(i).category.contains(search.toLowerCase().trim());
            boolean describtion = items.get(i).description.contains(search.toLowerCase().trim());
            boolean creatAt = items.get(i).createdAt.equals(search.toLowerCase().trim());
            boolean price = Integer.toString(items.get(i).price).contains(search.toLowerCase().trim());
           if(name || catgory || describtion ||creatAt || price )
           {      
               itemsAftersearch.add(items.get(i));
                
           }
        }
        return itemsAftersearch;
        
    }
    
}
