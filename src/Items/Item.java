/*
package Items;
public class Item {
    private String name;
    private String description;
    private int quantity;
    private String tag;
    private String location; // New variable for location

    // Constructor
    public Item(String name, String description, int quantity, String tag, String location) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.tag = tag;
        this.location = location;
    }

    // Getters and setters for all variables
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getQuantity() { return quantity; }
    public String getTag() { return tag; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}*/

package Items;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private String description;
    private int quantity;
    private String tag;
    private String location;

    // Constructor
    public Item(String name, String description, int quantity, String tag, String location) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.tag = tag;
        this.location = location;
    }

    // Getters and setters for all variables
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getQuantity() { return quantity; }
    public String getTag() { return tag; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}

