package utils;

import Entities.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class filterItems {
    public ArrayList<Item> filter(ArrayList<Item> items,String search,String sortitemby) {
        Sortby(items,sortitemby);
        return items;
    }
     public ArrayList<Item> Sortby (ArrayList<Item> items,String sortedby)
   {
             if (sortedby=="NameAscendingly")
        {     
            Collections.sort(items,new Comparator<Item>() {
                public int compare(Item i1, Item i2) {
                    return i1.name.compareTo(i2.name);
                }
            });
            return items ;

        } 
       else if (sortedby=="NameDescendingly")
        {     
            Collections.sort(items,new Comparator<Item>() {
                public int compare(Item i1, Item i2) {
                    return i1.name.compareTo(i2.name);
                }
            });
            Collections.reverse(items);
            return items ;

        }          
       else if (sortedby=="DateAscendingly")
        { 
             Collections.sort(items,new Comparator<Item>() {
                public int compare(Item i1, Item i2) {
                    return i1.createdAt.compareTo(i2.createdAt);
                }
            });
             
            return items ;
        }
         else if (sortedby=="DateDescendingly")
        { 
             Collections.sort(items,new Comparator<Item>() {
                public int compare(Item i1, Item i2) {
                    return (i1.createdAt.compareTo(i2.createdAt));
                }
            });
             Collections.reverse(items);
            return items ;
        }
             else if (sortedby=="Category")
        { 
             Collections.sort(items,new Comparator<Item>() {
                public int compare(Item i1, Item i2) {
                    return (i1.category.compareTo(i2.category));
                }
            });
             
            return items ;
        }
       

      return items ;
   }   

}
