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
        this.itemManager = new ItemManager(folderPath);

        FlatLightLaf.setup();

        setTitle("Obiecte și Sarcini - " + roomTag);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout(10, 10));

        JPanel mainPanel = new JPanel(new GridLayout(1, 1));

        JTable itemsTable = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Nume", "Descriere", "Cantitate", "Etichetă", "Locație"}, 0);
        itemsTable.setModel(tableModel);
        itemsTable.setFillsViewportHeight(true);
        itemsTable.setAutoCreateRowSorter(true); // Enable sorting

        // Adaugare iteme dupa locatie
        List<Item> itemsInRoom = itemManager.getItems().stream()
                .filter(item -> item.getLocation().equalsIgnoreCase(roomTag))
                .collect(Collectors.toList());

        for (Item item : itemsInRoom) {
            tableModel.addRow(new Object[]{item.getName(), item.getDescription(), item.getQuantity(), item.getTag(), item.getLocation()});
        }

        JScrollPane scrollPane = new JScrollPane(itemsTable);
        mainPanel.add(scrollPane);

        add(mainPanel, BorderLayout.CENTER);
    }
}
