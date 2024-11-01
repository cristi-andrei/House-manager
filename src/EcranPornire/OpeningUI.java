/*
package EcranPornire;

import Items.UI.ItemManagerUI;
import Tasks.View.TasksView;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class OpeningUI extends JFrame {
    private AppInitializer appInitializer; // AppInitializer to manage application state

    public OpeningUI(String folderPath) {
        this.appInitializer = new AppInitializer(folderPath); // Initialize AppInitializer

        // Set up FlatLaf look and feel
        FlatLightLaf.setup();

        // Set up the window
        setTitle("Gestionare Casă");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout(10, 10));

        // Main panel for room buttons in the center
        JPanel roomPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        roomPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Create room buttons
        JButton kitchenButton = createRoomButton("Bucătărie");
        JButton bedroomButton = createRoomButton("Dormitor");
        JButton storageButton = createRoomButton("Depozit");
        JButton bathroomButton = createRoomButton("Baie");

        // Add room buttons to the panel
        roomPanel.add(kitchenButton);
        roomPanel.add(bedroomButton);
        roomPanel.add(storageButton);
        roomPanel.add(bathroomButton);

        // Panel for navigation buttons at the bottom
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JButton itemsButton = new JButton("Vezi Toate Obiectele");
        JButton tasksButton = new JButton("Gestionează Sarcinile");

        // Style buttons
        styleButton(itemsButton);
        styleButton(tasksButton);

        // Add actions to navigate to Items UI and Tasks UI
        itemsButton.addActionListener(e -> openItemManagerUI());
        tasksButton.addActionListener(e -> openTasksUI());

        // Add navigation buttons to navPanel
        navPanel.add(itemsButton);
        navPanel.add(tasksButton);

        // Add main panels to the frame
        add(roomPanel, BorderLayout.CENTER);
        add(navPanel, BorderLayout.SOUTH);
    }

    private JButton createRoomButton(String roomName) {
        JButton button = new JButton(roomName);
        styleButton(button);
        button.addActionListener(e -> openRoomOverviewUI(roomName)); // Pass room name to the openRoomOverviewUI method
        return button;
    }

    private void styleButton(JButton button) {
        button.setBackground(Color.decode("#1b4d1d")); // Green color
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 12)); // Smaller font size for better fit
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(120, 60)); // Adjust size to fit text
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void openItemManagerUI() {
        // Open the ItemManagerUI window with the same folder path from AppInitializer
        new ItemManagerUI(appInitializer.getFolderPath()).setVisible(true);
    }

    private void openTasksUI() {
        // Open the Tasks UI
        try {
            TasksView.GUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Eroare la deschiderea interfeței pentru sarcini.", "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openRoomOverviewUI(String roomName, AppInitializer appInitializer) {
        // Open RoomOverviewUI with the selected room name and folder path from AppInitializer
         // Get folder path from appInitializer
        new RoomOverviewUI(roomName, appInitializer.getFolderPath()).setVisible(true); // Pass the room name and folder path to RoomOverviewUI
    }
}
*/
package EcranPornire;

import Items.UI.ItemManagerUI;
import Tasks.View.TasksView;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class OpeningUI extends JFrame {
    private AppInitializer appInitializer; // AppInitializer to manage application state

    public OpeningUI(String folderPath) {
        this.appInitializer = new AppInitializer(folderPath); // Initialize AppInitializer

        // Set up FlatLaf look and feel
        FlatLightLaf.setup();

        // Set up the window
        setTitle("Gestionare Casă");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout(10, 10));

        // Main panel for room buttons in the center
        JPanel roomPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        roomPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Create room buttons
        JButton kitchenButton = createRoomButton("Bucătărie");
        JButton bedroomButton = createRoomButton("Dormitor");
        JButton storageButton = createRoomButton("Depozit");
        JButton bathroomButton = createRoomButton("Baie");

        // Add room buttons to the panel
        roomPanel.add(kitchenButton);
        roomPanel.add(bedroomButton);
        roomPanel.add(storageButton);
        roomPanel.add(bathroomButton);

        // Panel for navigation buttons at the bottom
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JButton itemsButton = new JButton("Vezi Toate Obiectele");
        JButton tasksButton = new JButton("Gestionează Sarcinile");

        // Style buttons
        styleButton(itemsButton);
        styleButton(tasksButton);

        // Add actions to navigate to Items UI and Tasks UI
        itemsButton.addActionListener(e -> openItemManagerUI());
        tasksButton.addActionListener(e -> openTasksUI());

        // Add navigation buttons to navPanel
        navPanel.add(itemsButton);
        navPanel.add(tasksButton);

        // Add main panels to the frame
        add(roomPanel, BorderLayout.CENTER);
        add(navPanel, BorderLayout.SOUTH);
    }

    private JButton createRoomButton(String roomName) {
        JButton button = new JButton(roomName);
        styleButton(button);
        button.addActionListener(e -> openRoomOverviewUI(roomName)); // Pass room name to the openRoomOverviewUI method
        return button;
    }

    private void styleButton(JButton button) {
        button.setBackground(Color.decode("#1b4d1d")); // Green color
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 12)); // Smaller font size for better fit
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(120, 60)); // Adjust size to fit text
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void openItemManagerUI() {
        // Open the ItemManagerUI window with the same folder path from AppInitializer
        new ItemManagerUI(appInitializer.getFolderPath()).setVisible(true);
    }

    private void openTasksUI() {
        // Open the Tasks UI
        try {
            TasksView.GUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Eroare la deschiderea interfeței pentru sarcini.", "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openRoomOverviewUI(String roomName) {
        // Open RoomOverviewUI with the selected room name and folder path from AppInitializer
        String folderPath = appInitializer.getFolderPath(); // Get the folder path from AppInitializer
        new RoomOverviewUI(roomName, folderPath).setVisible(true); // Pass the room name and folder path to RoomOverviewUI
    }
}
