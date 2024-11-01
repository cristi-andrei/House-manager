/*
package Items;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    private List<Item> items;
    private final File file;

    public ItemManager(String folderPath) {
        items = new ArrayList<>();
        file = new File(folderPath, "items.dat");
        loadItems(); // Automatically load items from file at startup
    }

    public void addItem(Item item) {
        items.add(item);
        saveItems();
    }

    public List<Item> getItems() {
        return items;
    }

    private void saveItems() {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(file.toPath()))) {
            oos.writeObject(items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadItems() {
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                items = (List<Item>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
*/
package Items;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    private List<Item> items;
    private String filePath;

    public ItemManager(String folderPath) {
        this.filePath = folderPath + File.separator + "items.dat"; // Specify the file name
        this.items = new ArrayList<>();
        loadItems(); // Load existing items from the file
    }

    public void addItem(Item item) {
        items.add(item);
        saveItems(); // Save items after adding a new one
    }

    public void saveItems() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(items);
        } catch (IOException e) {
            System.err.println("Failed to save items: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadItems() {
        File file = new File(filePath);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
                items = (List<Item>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Failed to load items: " + e.getMessage());
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
