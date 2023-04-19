package utils;
import Entities.Role;
import Entities.User;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;


public class FilterUsersTest {
    
    public FilterUsersTest() {
    }
    private ArrayList getTestData() {
        
        ArrayList<User> users = new ArrayList<>();
        Role role1 = new Role();
        User user1 = new User();
        role1.name = "Administrator";
        user1.name = "Anas Hesham";
        user1.userName = "anazz";
        user1.password = "00000000";
        user1.role = role1;
        users.add(user1);
        
        Role role2 = new Role();
        User user2 = new User();
        role2.name = "Technical Support";
        user2.name = "Hussien Mostafa";
        user2.userName = "s7s";
        user2.password = "00000000";
        user2.role = role2;
        users.add(user2);
        
        Role role3 = new Role();
        User user3 = new User();
        role3.name = "Technical Support";
        user3.name = "Norhan Ahmed";
        user3.userName = "noor";
        user3.password = "00000000";
        user3.role = role3;
        users.add(user3);
        
        Role role4 = new Role();
        User user4 = new User();
        role4.name = "Analyst";
        user4.name = "Toka Abd El Gawad";
        user4.userName = "toka";
        user4.password = "00000000";
        user4.role = role4;
        users.add(user4);
        
        Role role5 = new Role();
        User user5 = new User();
        role5.name = "Saler";
        user5.name = "Habiba Emad";
        user5.userName = "habiba";
        user5.password = "00000000";
        user5.role = role5;
        users.add(user5);
        
        return users;
    }
   
    @Test
    public void testFilter() {
        FilterUsers instance = new FilterUsers();
        ArrayList<User> users = getTestData();
        String searchName = "";
        String sortBy = "";
        boolean toggle = false;
        Role role = new Role();
        ArrayList<User> expUsers = null;
        ArrayList<User> result = null;
        User user1 = users.get(0);
        User user2 = users.get(1);
        User user3 = users.get(2);
        User user4 = users.get(3);
        User user5 = users.get(4);
        
        // Test Case 1
        searchName = "An";
        sortBy = "Name";
        toggle = true;
        expUsers = new ArrayList<>();
        expUsers.add(user1);
        expUsers.add(user3);
        result = instance.filter(users, searchName, sortBy, toggle);
        assertArrayEquals( expUsers.toArray(), result.toArray());
        
        // Test Case 2
        searchName = "An";
        sortBy = "Name";
        toggle = false;
        expUsers = new ArrayList<>();
        expUsers.add(user3);
        expUsers.add(user1);
        result = instance.filter(users, searchName, sortBy, toggle);
        assertArrayEquals( expUsers.toArray(), result.toArray());
        
        // Test Case 3
        searchName = "";
        sortBy = "Role";
        toggle = true;
        expUsers = new ArrayList<>();
        expUsers.add(user1);
        expUsers.add(user4);
        expUsers.add(user5);
        expUsers.add(user2);
        expUsers.add(user3);
        result = instance.filter(users, searchName, sortBy, toggle);
        assertArrayEquals( expUsers.toArray(), result.toArray());
        
        // Test Case 4
        searchName = "";
        sortBy = "Role";
        toggle = false;
        expUsers = new ArrayList<>();
        expUsers.add(user3);
        expUsers.add(user2);
        expUsers.add(user5);
        expUsers.add(user4);
        expUsers.add(user1);
        result = instance.filter(users, searchName, sortBy, toggle);
        assertArrayEquals( expUsers.toArray(), result.toArray());
        
        // Test Case 5
        searchName = "";
        sortBy = "";
        toggle = false;
        expUsers = new ArrayList<>();
        expUsers.add(user1);
        expUsers.add(user2);
        expUsers.add(user3);
        expUsers.add(user4);
        expUsers.add(user5);
        result = instance.filter(users, searchName, sortBy, toggle);
        assertArrayEquals( expUsers.toArray(), result.toArray());
    }

    @Test
    public void testSearch() {
        ArrayList<User> users = getTestData();
        ArrayList<User> expUsers = null;
        ArrayList<User> result = null;
        User user1 = users.get(0);
        User user2 = users.get(1);
        User user3 = users.get(2);
        User user4 = users.get(3);
        User user5 = users.get(4);
        String search;
        boolean toggle;
        FilterUsers instance = new FilterUsers();
        
        // Test Case 1
        search = "an";
        expUsers = new ArrayList<>();
        expUsers.add(user1);
        expUsers.add(user3);
        result = instance.Search(users, search);
        assertArrayEquals(expUsers.toArray(), result.toArray());
        
        // Test Case 2
        search = "a";
        expUsers = new ArrayList<>();
        expUsers.add(user1);
        expUsers.add(user2);
        expUsers.add(user3);
        expUsers.add(user4);
        expUsers.add(user5);
        result = instance.Search(users, search);
        assertArrayEquals(expUsers.toArray(), result.toArray());
        
        // Test Case 3
        search = "";
        expUsers = new ArrayList<>();
        expUsers.add(user1);
        expUsers.add(user2);
        expUsers.add(user3);
        expUsers.add(user4);
        expUsers.add(user5);
        result = instance.Search(users, search);
        assertArrayEquals(expUsers.toArray(), result.toArray());
        
    }

    @Test
    public void testSortBy() {
        ArrayList<User> users = getTestData();
        ArrayList<User> expUsers = null;
        ArrayList<User> result = null;
        User user1 = users.get(0);
        User user2 = users.get(1);
        User user3 = users.get(2);
        User user4 = users.get(3);
        User user5 = users.get(4);
        String sortedBy;
        boolean toggle;
        FilterUsers instance = new FilterUsers();

        //Test Case 1
        sortedBy = "Name";
        toggle = true;
        expUsers = new ArrayList<>();
        expUsers.add(user1);
        expUsers.add(user5);
        expUsers.add(user2);
        expUsers.add(user3);
        expUsers.add(user4);
        result = instance.SortBy(users, sortedBy, toggle);
        assertArrayEquals(expUsers.toArray(), result.toArray());        //Test Case 1

        //Test Case 2
        sortedBy = "Name";
        toggle = false;
        expUsers = new ArrayList<>();
        expUsers.add(user4);
        expUsers.add(user3);
        expUsers.add(user2);
        expUsers.add(user5);
        expUsers.add(user1);
        result = instance.SortBy(users, sortedBy, toggle);
        assertArrayEquals(expUsers.toArray(), result.toArray()); 
        
        //Test Case 3
        sortedBy = "Role";
        toggle = false;
        expUsers = new ArrayList<>();
        expUsers.add(user2);
        expUsers.add(user3);
        expUsers.add(user5);
        expUsers.add(user4);
        expUsers.add(user1);
        result = instance.SortBy(users, sortedBy, toggle);
        assertArrayEquals(expUsers.toArray(), result.toArray()); 
        
        
        //Test Case 4
        sortedBy = "Role";
        toggle = true;
        expUsers = new ArrayList<>();
        expUsers.add(user1);
        expUsers.add(user4);
        expUsers.add(user5);
        expUsers.add(user2);
        expUsers.add(user3);
        result = instance.SortBy(users, sortedBy, toggle);
        assertArrayEquals(expUsers.toArray(), result.toArray()); 
        
        
        //Test Case 5
        sortedBy = "";
        toggle = true;
        expUsers = new ArrayList<>();
        expUsers.add(user1);
        expUsers.add(user4);
        expUsers.add(user5);
        expUsers.add(user2);
        expUsers.add(user3);
        result = instance.SortBy(users, sortedBy, toggle);
        assertArrayEquals(expUsers.toArray(), result.toArray());
    }
    
}
