package utils;

import Entities.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
