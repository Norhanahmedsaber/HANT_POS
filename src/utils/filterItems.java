package utils;

import Entities.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 
public class filterItems {
    public ArrayList<Item> filter(ArrayList<Item> items,String search,String sortitemby , boolean toggle) {
       ArrayList <Item> filtered = search(items, search);
       ArrayList <Item> sorted = Sortby(filtered , sortitemby ,toggle);
        return sorted;       
    }
    public ArrayList<Item> search(ArrayList<Item> items , String search )
    {
        ArrayList <Item> itemsAftersearch = new ArrayList<Item>();
        for(int i=0 ; i<items.size();i++)
        {
            boolean name = items.get(i).name.contains(search.toLowerCase().trim());
            boolean catgory =items.get(i).category.contains(search.toLowerCase().trim());
            boolean description = items.get(i).description.contains(search.toLowerCase().trim());
            if(name || catgory || description)
           {      
               itemsAftersearch.add(items.get(i));
                
           }

        }
        return itemsAftersearch;   
    }
    
    
     public ArrayList<Item> Sortby (ArrayList<Item> items,String sortedby , boolean toggle)
   {
        if (sortedby=="Name" && toggle==false)
        {     
            Collections.sort(items,new Comparator<Item>() {
                @Override
                public int compare(Item i1, Item i2) {
                    return i1.name.compareTo(i2.name);
                }
            });
            return items ;

        } 
       else if (sortedby=="Name" && toggle== true )
        {     
            Collections.sort(items,new Comparator<Item>() {
                @Override
                public int compare(Item i1, Item i2) {
                    return i1.name.compareTo(i2.name);
                }
            });
            Collections.reverse(items);
            return items ;

        }          
       else if (sortedby=="Date" && toggle== false)
        { 
             Collections.sort(items,new Comparator<Item>() {
                public int compare(Item i1, Item i2) {
                    return i1.createdAt.compareTo(i2.createdAt);
                }
            });
             
            return items ;
        }
       else if (sortedby=="Date" && toggle==true)
        { 
             Collections.sort(items,new Comparator<Item>() {
                @Override
                public int compare(Item i1, Item i2) {
                    return (i1.createdAt.compareTo(i2.createdAt));
                }
            });
             Collections.reverse(items);
            return items ;
        }
       else if (sortedby=="Category" && toggle==false)
        { 
             Collections.sort(items,new Comparator<Item>() {
                public int compare(Item i1, Item i2) {
                    return (i1.category.compareTo(i2.category));
                }
            });
             
            return items ;
        }
       else if (sortedby=="Category" && toggle==true)
        { 
             Collections.sort(items,new Comparator<Item>() {
                public int compare(Item i1, Item i2) {
                    return (i1.category.compareTo(i2.category));
                }
            });
            Collections.reverse(items);
            return items ;
        }
       else if (sortedby=="Price" && toggle== false)
        { 
             Collections.sort(items,new Comparator<Item>() {
                @Override
                public int compare(Item i1, Item i2) {
                    return (Integer.toString(i1.price).compareTo(Integer.toString(i2.price)));
                }
            });
        
            return items ;
        }
      else if (sortedby=="Price" && toggle== true)
        { 
             Collections.sort(items,new Comparator<Item>() {
                @Override
                public int compare(Item i1, Item i2) {
                    return (Integer.toString(i1.price).compareTo(Integer.toString(i2.price)));
                }
            });
            Collections.reverse(items);
            return items ;
        }
       

      return items ;
   }   

}
