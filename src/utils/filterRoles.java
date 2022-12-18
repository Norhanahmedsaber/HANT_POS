package utils;
import java.util.ArrayList;

public class filterRoles {
    public ArrayList<String> filter(ArrayList<String> roleNames, String searchName) {
        return search(roleNames, searchName); 
    }
    public ArrayList<String> search(ArrayList<String> roleNames, String searchName) {
        ArrayList<String> roleNamesAfterSearch = new ArrayList<String>();
        for(String roleName : roleNames) {
            boolean name = roleName.trim().toLowerCase().contains(searchName.trim().toLowerCase());
            if(name) {
                roleNamesAfterSearch.add(roleName);
            }
        }
        return roleNamesAfterSearch;
    }
}
