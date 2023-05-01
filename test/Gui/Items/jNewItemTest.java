package Gui.Items;

import Gui.jHomePage;
import javax.swing.JPanel;
import org.junit.Test;
import static org.junit.Assert.*;


public class jNewItemTest {
    
    public jNewItemTest() {

    }

    public jNewItem getInstance() {
        return new jNewItem(new jHomePage(), new JPanel());
    }
  
    @Test
    public void testIsValidName() {
        jNewItem instance = getInstance();
        
        // Test Case 1
        instance.jNameField.setText("");
        boolean expResult = false;
        boolean result = instance.isValidName();
        assertEquals(expResult, result);
        
        // Test Case 2
        instance.jNameField.setText("Text");
        expResult = true;
        result = instance.isValidName();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidDescription() {
        jNewItem instance = getInstance();
        
        // Test Case 1
        instance.jDescriptionField.setText("");
        boolean expResult = false;
        boolean result = instance.isValidDescription();
        assertEquals(expResult, result);
        
        // Test Case 2
        instance.jDescriptionField.setText("Text");
        expResult = true;
        result = instance.isValidDescription();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidPrice() {
        jNewItem instance = getInstance();
        // Test Case 1
        instance.jPriceField.setText("");
        boolean expResult = false;
        boolean result = instance.isValidPrice();
        assertEquals(expResult, result);
        
        // Test Case 2
        instance.jPriceField.setText("Text");
        expResult = false;
        result = instance.isValidPrice();
        assertEquals(expResult, result);
        
        // Test Case 3
        instance.jPriceField.setText("123");
        expResult = true;
        result = instance.isValidPrice();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidCatgory() {
        jNewItem instance = getInstance();
        
        // Test Case 1
        instance.jCatgoryField.setText("");
        boolean expResult = false;
        boolean result = instance.isValidCatgory();
        assertEquals(expResult, result);
        
        // Test Case 2
        instance.jCatgoryField.setText("Text");
        expResult = true;
        result = instance.isValidCatgory();
        assertEquals(expResult, result);
        
    }

}