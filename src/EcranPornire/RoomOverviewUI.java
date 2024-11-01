/*
package EcranPornire;

import Items.Item;
import Items.ItemManager;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class RoomOverviewUI extends JFrame {
    private ItemManager itemManager;
    private String roomTag;

    public RoomOverviewUI(String roomTag, String folderPath) {
        this.roomTag = roomTag;
        this.itemManager = new ItemManager(folderPath); // Use AppInitializer to get folder path

        // Set up FlatLaf look and feel
        FlatLightLaf.setup();

        // Set up the window
        setTitle("Obiecte și Sarcini - " + roomTag);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout(10, 10));

        // Panel for items and tasks
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        // Table for items
        DefaultTableModel itemTableModel = new DefaultTableModel(new String[]{"Nume", "Descriere", "Cantitate"}, 0);
        JTable itemTable = new JTable(itemTableModel);
        itemTable.setRowHeight(30);
        loadItems(itemTableModel); // Load items filtered by room

        JScrollPane itemScrollPane = new JScrollPane(itemTable);
        itemScrollPane.setBorder(BorderFactory.createTitledBorder("Obiecte în " + roomTag));

        // Table for tasks
        DefaultTableModel taskTableModel = new DefaultTableModel(new String[]{"Nume Sarcină", "Deadline"}, 0);
        JTable taskTable = new JTable(taskTableModel);
        taskTable.setRowHeight(30);
        //loadTasks(taskTableModel); // Load tasks filtered by room

        JScrollPane taskScrollPane = new JScrollPane(taskTable);
        taskScrollPane.setBorder(BorderFactory.createTitledBorder("Sarcini în " + roomTag));

        // Add scroll panes to main panel
        mainPanel.add(itemScrollPane);
        mainPanel.add(taskScrollPane);

        // Add main panel to the frame
        add(mainPanel, BorderLayout.CENTER);
    }

    private void loadItems(DefaultTableModel tableModel) {
        // Clear existing rows
        tableModel.setRowCount(0);

        // Load items from ItemManager and filter by room tag
        List<Item> items = itemManager.getItems().stream()
                .filter(item -> item.getLocation().equalsIgnoreCase(roomTag))
                .collect(Collectors.toList());

        // Add items to the table model
        for (Item item : items) {
            tableModel.addRow(new Object[]{item.getName(), item.getDescription(), item.getQuantity()});
        }
    }

    */
/*    private void loadTasks(DefaultTableModel tableModel) {
        // Clear existing rows
        tableModel.setRowCount(0);

        /*
         Load tasks and filter by room tag
        TO DO
        *//*

        */
/*
        for (Task task : TasksVector.tasks) {
            if (task.getLocation().equalsIgnoreCase(roomTag)) {
                tableModel.addRow(new Object[]{task.getName(), task.getDeadline()});
            }
        }
    } *//*


    */
/*public static void main(String[] args) {
        // Sample usage, replace "house_items" with your folder path
        AppInitializer appInitializer = new AppInitializer("house_items");
        String folderPath = appInitializer.getFolderPath(); // Get the folder path from AppInitializer

        SwingUtilities.invokeLater(() -> new RoomOverviewUI("Bucătărie", folderPath).setVisible(true));
    }*//*

}
*/
package EcranPornire;

import Items.Item;
import Items.ItemManager;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class RoomOverviewUI extends JFrame {
    private ItemManager itemManager;
    private String roomTag;

    public RoomOverviewUI(String roomTag, String folderPath) {
        this.roomTag = roomTag;
        this.itemManager = new ItemManager(folderPath); // Use AppInitializer to get folder path

        // Set up FlatLaf look and feel
        FlatLightLaf.setup();

        // Set up the window
        setTitle("Obiecte și Sarcini - " + roomTag);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout(10, 10));

        // Panel for items and tasks
        JPanel mainPanel = new JPanel(new GridLayout(1, 1));

        // Create and populate the items table
        JTable itemsTable = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Nume", "Descriere", "Cantitate", "Etichetă", "Locație"}, 0);
        itemsTable.setModel(tableModel);
        itemsTable.setAutoCreateRowSorter(true); // Enable sorting

        // Add items to the table based on the room tag
        List<Item> itemsInRoom = itemManager.getItems().stream()
                .filter(item -> item.getLocation().equalsIgnoreCase(roomTag))
                .collect(Collectors.toList());

        for (Item item : itemsInRoom) {
            tableModel.addRow(new Object[]{item.getName(), item.getDescription(), item.getQuantity(), item.getTag(), item.getLocation()});
        }

        // Add the items table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(itemsTable);
        mainPanel.add(scrollPane);

        // Add the main panel to the frame
        add(mainPanel, BorderLayout.CENTER);
    }
}
