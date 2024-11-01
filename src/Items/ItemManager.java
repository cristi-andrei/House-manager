package Items;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    private List<Item> items;
    private String filePath;

    public ItemManager(String folderPath) {
        this.filePath = folderPath + File.separator + "items.dat";
        this.items = new ArrayList<>();
        loadItems();
    }

    public void addItem(Item item) {
        items.add(item);
        saveItems();
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
