package utils;

import Entities.Role;
import java.util.ArrayList;

public class filterRoles {
    public ArrayList<Role> filter(ArrayList<Role> roles, String searchName) {
        return search(roles, searchName); 
    }
    public ArrayList<Role> search(ArrayList<Role> roles, String searchName) {
        ArrayList<Role> rolesAfterSearch = new ArrayList<Role>();
        for(Role role : roles) {
            boolean name = role.name.trim().toLowerCase().contains(searchName.trim().toLowerCase());
            if(name) {
                rolesAfterSearch.add(role);
            }
        }
        return rolesAfterSearch;
    }
}
