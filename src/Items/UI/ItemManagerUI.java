package Items.UI;

import EcranPornire.AppInitializer;
import Items.ItemManager;

import javax.swing.table.DefaultTableModel;

/*
package Items.UI;

import EcranPornire.AppInitializer;
import Items.Item;
import Items.ItemManager;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Comparator;

public class ItemManagerUI extends JFrame {
    private ItemManager itemManager;
    private DefaultTableModel tableModel;

    // Added instance variable for AppInitializer
    private AppInitializer appInitializer;

    public ItemManagerUI(String folderPath) {
        // Initialize AppInitializer with the provided folder path
        appInitializer = new AppInitializer(folderPath);

        // Set up FlatLaf look and feel
        FlatLightLaf.setup();

        itemManager = new ItemManager(appInitializer.getFolderPath());

        // Set up the window
        setTitle("Aplicație de Gestionare a Casei");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center window
        setLayout(new BorderLayout(10, 10));

        // Set up the table for item display
        tableModel = new DefaultTableModel(new String[]{"Nume", "Descriere", "Cantitate", "Etichetă", "Locație"}, 0); // Added "Locație"
        JTable table = new JTable(tableModel);
        table.setRowHeight(60);
        table.setFillsViewportHeight(true);

        // Load items into the table
        loadItems();

        // Scroll pane for table
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Obiectele Curente"));

        // Button to open add item dialog
        JButton addNewItemButton = new JButton("Adăugați un Obiect Nou");
        styleButton(addNewItemButton);
        addNewItemButton.addActionListener(e -> openAddItemDialog());

        // Refresh and Sort buttons
        JButton refreshButton = new JButton("Reîncarcă Obiectele");
        styleButton(refreshButton);
        refreshButton.addActionListener(e -> {
            loadItems(); // Reload items from file
            JOptionPane.showMessageDialog(ItemManagerUI.this, "Lista obiectelor a fost reîncărcată.");
        });

        JButton sortButton = new JButton("Sortează după Etichetă");
        styleButton(sortButton);
        sortButton.addActionListener(e -> {
            loadItems(true); // Load and sort items by tag
            JOptionPane.showMessageDialog(ItemManagerUI.this, "Obiectele au fost sortate după etichetă.");
        });

        // Panel to hold buttons at the bottom
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(addNewItemButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(sortButton);

        // Adding components to the main frame
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadItems() {
        loadItems(false);
    }

    private void loadItems(boolean sortByTag) {
        // Clear the table model
        tableModel.setRowCount(0);

        // Load items from ItemManager
        java.util.List<Item> items = itemManager.getItems();

        // Sort items by tag if sortByTag is true
        if (sortByTag) {
            items.sort(Comparator.comparing(Item::getTag));
        }

        // Add items to the table
        for (Item item : items) {
            tableModel.addRow(new Object[]{item.getName(), item.getDescription(), item.getQuantity(), item.getTag(), item.getLocation()}); // Add location to table
        }
    }

    private void openAddItemDialog() {
        JDialog addItemDialog = new JDialog(this, "Adăugați Obiect Nou", true);
        addItemDialog.setSize(400, 300);
        addItemDialog.setLayout(new GridLayout(6, 2, 10, 10)); // Changed to 6 rows for location
        addItemDialog.setLocationRelativeTo(this); // Center dialog relative to main frame

        // Input fields for item details
        JTextField nameField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField quantityField = new JTextField();
        JTextField tagField = new JTextField();
        JTextField locationField = new JTextField(); // New field for location

        addItemDialog.add(new JLabel("Nume Obiect:"));
        addItemDialog.add(nameField);

        addItemDialog.add(new JLabel("Descriere Obiect:"));
        addItemDialog.add(descriptionField);

        addItemDialog.add(new JLabel("Cantitate:"));
        addItemDialog.add(quantityField);

        addItemDialog.add(new JLabel("Etichetă:"));
        addItemDialog.add(tagField);

        addItemDialog.add(new JLabel("Locație:")); // New label for location
        addItemDialog.add(locationField); // New input for location

        // Save button in dialog
        JButton saveButton = new JButton("Salvați Obiectul");
        styleButton(saveButton);
        saveButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                String description = descriptionField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                String tag = tagField.getText();
                String location = locationField.getText(); // Get location input

                // Create and add item
                Item item = new Item(name, description, quantity, tag, location); // Include location in item
                itemManager.addItem(item);

                // Update table in main UI
                tableModel.addRow(new Object[]{name, description, quantity, tag, location}); // Add location to table

                JOptionPane.showMessageDialog(addItemDialog, "Obiectul a fost adăugat cu succes!");

                // Clear fields and close dialog
                nameField.setText("");
                descriptionField.setText("");
                quantityField.setText("");
                tagField.setText("");
                locationField.setText(""); // Clear location field
                addItemDialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(addItemDialog, "Introduceți o cantitate validă.", "Eroare", JOptionPane.ERROR_MESSAGE);
            }
        });

        addItemDialog.add(new JLabel()); // Empty label for alignment
        addItemDialog.add(saveButton);

        addItemDialog.setVisible(true); // Show dialog
    }

    private void styleButton(JButton button) {
        button.setBackground(Color.decode("#4CAF50")); // Green color
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    */
/*public static void main(String[] args) {
        // Specify the folder path for your application
        String folderPath = "house_items"; // Replace with your actual folder path
        SwingUtilities.invokeLater(() -> new ItemManagerUI(folderPath).setVisible(true));
    }*//*

}
*/

import Items.Item;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.util.Comparator;

public class ItemManagerUI extends JFrame {
    private final ItemManager itemManager;
    private final DefaultTableModel tableModel;
    private final JTable itemTable;

    // Added instance variable for AppInitializer
    private final AppInitializer appInitializer;

    public ItemManagerUI(String folderPath) {
        // Initialize AppInitializer with the provided folder path
        appInitializer = new AppInitializer(folderPath);

        // Set up FlatLaf look and feel
        FlatLightLaf.setup();

        itemManager = new ItemManager(appInitializer.getFolderPath());

        // Set up the window
        setTitle("Aplicație de Gestionare a Casei");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center window
        setLayout(new BorderLayout(10, 10));

        // Set up the table for item display
        tableModel = new DefaultTableModel(new String[]{"Nume", "Descriere", "Cantitate", "Etichetă", "Locație"}, 0); // Added "Locație"
        itemTable = new JTable(tableModel);
        itemTable.setRowHeight(60);
        itemTable.setFillsViewportHeight(true);

        setupTable(itemTable); // Customize the table appearance and sorting
        loadItems(); // Load items into the table

        // Scroll pane for table
        JScrollPane scrollPane = new JScrollPane(itemTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Obiectele Curente"));

        // Initialize panels for search and buttons
        SearchPanel searchPanel = new SearchPanel(itemTable, tableModel);
        JPanel buttonPanel = createButtonPanel();

        // Adding components to the main frame
        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Configures the table to center text and set column widths.
     */
    private void setupTable(JTable table) {
        CenteredTableCellRenderer centeredRenderer = new CenteredTableCellRenderer();
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centeredRenderer);
        }

        // Set column widths
        table.getColumnModel().getColumn(1).setPreferredWidth(300); // Wider for Descriere
        table.getColumnModel().getColumn(2).setPreferredWidth(100); // Narrower for Cantitate

        // Enable sorting
        table.setAutoCreateRowSorter(true);
    }

    /**
     * Loads items into the table, with optional sorting.
     */
    private void loadItems() {
        loadItems(false);
    }

    private void loadItems(boolean sortByTag) {
        tableModel.setRowCount(0); // Clear the table model

        // Load items from ItemManager
        java.util.List<Item> items = itemManager.getItems();

        // Sort items by tag if requested
        if (sortByTag) {
            items.sort(Comparator.comparing(Item::getTag));
        }

        // Populate table with items
        for (Item item : items) {
            tableModel.addRow(new Object[]{item.getName(), item.getDescription(), item.getQuantity(), item.getTag(), item.getLocation()});
        }
    }

    /**
     * Opens a dialog for adding a new item.
     */
    private void openAddItemDialog() {
        JDialog addItemDialog = new JDialog(this, "Adăugați Obiect Nou", true);
        addItemDialog.setSize(400, 300);
        addItemDialog.setLayout(new GridLayout(6, 2, 10, 10));
        addItemDialog.setLocationRelativeTo(this);

        // Input fields for item details
        JTextField nameField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField quantityField = new JTextField();
        JTextField tagField = new JTextField();
        JTextField locationField = new JTextField();

        addItemDialog.add(new JLabel("Nume Obiect:"));
        addItemDialog.add(nameField);
        addItemDialog.add(new JLabel("Descriere Obiect:"));
        addItemDialog.add(descriptionField);
        addItemDialog.add(new JLabel("Cantitate:"));
        addItemDialog.add(quantityField);
        addItemDialog.add(new JLabel("Etichetă:"));
        addItemDialog.add(tagField);
        addItemDialog.add(new JLabel("Locație:"));
        addItemDialog.add(locationField);

        JButton saveButton = new JButton("Salvați Obiectul");
        styleButton(saveButton);
        saveButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                String description = descriptionField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                String tag = tagField.getText();
                String location = locationField.getText();

                // Create and add item
                Item item = new Item(name, description, quantity, tag, location);
                itemManager.addItem(item);
                tableModel.addRow(new Object[]{name, description, quantity, tag, location});
                JOptionPane.showMessageDialog(addItemDialog, "Obiectul a fost adăugat cu succes!");

                addItemDialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(addItemDialog, "Introduceți o cantitate validă.", "Eroare", JOptionPane.ERROR_MESSAGE);
            }
        });

        addItemDialog.add(new JLabel()); // Empty label for alignment
        addItemDialog.add(saveButton);
        addItemDialog.setVisible(true);
    }

    /**
     * Creates and styles the button panel with event listeners.
     */
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton addNewItemButton = new JButton("Adăugați un Obiect Nou");
        JButton refreshButton = new JButton("Reîncarcă Obiectele");
        JButton sortButton = new JButton("Sortează după Etichetă");

        styleButton(addNewItemButton);
        styleButton(refreshButton);
        styleButton(sortButton);

        addNewItemButton.addActionListener(e -> openAddItemDialog());
        refreshButton.addActionListener(e -> {
            loadItems();
            JOptionPane.showMessageDialog(this, "Lista obiectelor a fost reîncărcată.");
        });
        sortButton.addActionListener(e -> {
            loadItems(true);
            JOptionPane.showMessageDialog(this, "Obiectele au fost sortate după etichetă.");
        });

        buttonPanel.add(addNewItemButton);
        buttonPanel.add(refreshButton);
        buttonPanel.add(sortButton);
        return buttonPanel;
    }

    /**
     * Styles buttons for consistent look and feel.
     */
    private void styleButton(JButton button) {
        button.setBackground(Color.decode("#4CAF50"));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
