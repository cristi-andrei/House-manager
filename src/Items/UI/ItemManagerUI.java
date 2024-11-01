package Items.UI;

import EcranPornire.AppInitializer;
import Items.ItemManager;
import Items.Item;

import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.*;
import java.util.Comparator;

public class ItemManagerUI extends JFrame {
    private final ItemManager itemManager;
    private final DefaultTableModel tableModel;
    private final JTable itemTable;

    private final AppInitializer appInitializer;

    public ItemManagerUI(String folderPath) {
        appInitializer = new AppInitializer(folderPath);

        FlatLightLaf.setup();

        itemManager = new ItemManager(appInitializer.getFolderPath());

        setTitle("Aplicație de Gestionare a Casei");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center window
        setLayout(new BorderLayout(10, 10));

        tableModel = new DefaultTableModel(new String[]{"Nume", "Descriere", "Cantitate", "Etichetă", "Locație"}, 0); // Added "Locație"
        itemTable = new JTable(tableModel);
        itemTable.setRowHeight(60);
        itemTable.setFillsViewportHeight(true);

        setupTable(itemTable);
        loadItems();

        JScrollPane scrollPane = new JScrollPane(itemTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Obiectele Curente"));

        SearchPanel searchPanel = new SearchPanel(itemTable, tableModel);
        JPanel buttonPanel = createButtonPanel();

        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }


    private void setupTable(JTable table) {
        CenteredTableCellRenderer centeredRenderer = new CenteredTableCellRenderer();
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centeredRenderer);
        }

        table.getColumnModel().getColumn(1).setPreferredWidth(300); // Lat - Descriere
        table.getColumnModel().getColumn(2).setPreferredWidth(100); // Mai mic -  Cantitate

        table.setAutoCreateRowSorter(true);
    }


    private void loadItems() {
        loadItems(false);
    }

    private void loadItems(boolean sortByTag) {
        tableModel.setRowCount(0);

        java.util.List<Item> items = itemManager.getItems();

        if (sortByTag) {
            items.sort(Comparator.comparing(Item::getTag));
        }

        for (Item item : items) {
            tableModel.addRow(new Object[]{item.getName(), item.getDescription(), item.getQuantity(), item.getTag(), item.getLocation()});
        }
    }


    private void openAddItemDialog() {
        JDialog addItemDialog = new JDialog(this, "Adăugați Un Obiect Nou", true);
        addItemDialog.setSize(400, 300);
        addItemDialog.setLayout(new GridLayout(6, 2, 10, 10));
        addItemDialog.setLocationRelativeTo(this);

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

                Item item = new Item(name, description, quantity, tag, location);
                itemManager.addItem(item);
                tableModel.addRow(new Object[]{name, description, quantity, tag, location});
                JOptionPane.showMessageDialog(addItemDialog, "Obiectul a fost adăugat cu succes!");

                addItemDialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(addItemDialog, "Introduceți o cantitate validă.", "Eroare", JOptionPane.ERROR_MESSAGE);
            }
        });

        addItemDialog.add(new JLabel());
        addItemDialog.add(saveButton);
        addItemDialog.setVisible(true);
    }


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


    private void styleButton(JButton button) {
        button.setBackground(Color.decode("#4CAF50"));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
