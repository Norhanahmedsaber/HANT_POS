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
    public ArrayList<Item> search(ArrayList<Item> items , String search ){
        ArrayList <Item> itemsAftersearch = new ArrayList<>();
        for(int i=0 ; i<items.size();i++){
            boolean name = items.get(i).name.toLowerCase().contains(search.toLowerCase().trim());
            boolean catgory =items.get(i).category.toLowerCase().contains(search.toLowerCase().trim());
            boolean description = items.get(i).description.toLowerCase().trim().contains(search.toLowerCase().trim());
            if(name){      
               itemsAftersearch.add(items.get(i));}}
        return itemsAftersearch;}
     public ArrayList<Item> Sortby (ArrayList<Item> items,String sortedby , boolean toggle){
        if (sortedby=="Name" && toggle==false){     
            Collections.sort(items,new Comparator<Item>() {
                @Override
                public int compare(Item i1, Item i2){
                    return i1.name.toLowerCase().trim().compareTo(i2.name.toLowerCase().trim());}
            });return items;} 
       else if (sortedby=="Name" && toggle== true ){     
            Collections.sort(items,new Comparator<Item>(){
                @Override
                public int compare(Item i1, Item i2) {
                    return i1.name.trim().toLowerCase().compareTo(i2.name.toLowerCase().trim());}
            });Collections.reverse(items);
            return items ;}          
       return items ;}

    public float getLargestPrice(ArrayList<Float> prices) {
        if(prices.isEmpty()) {
            return -1;
        }
        float max = prices.get(0);
        for(int i=1;i<prices.size();i++) {
            if(max < prices.get(i)) {
                max = prices.get(i);
            }
        }
        return max;
    }
}
