
package EcranPornire;

import Items.UI.ItemManagerUI;
import Tasks.View.TasksView;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class OpeningUI extends JFrame {
    private AppInitializer appInitializer;

    public OpeningUI(String folderPath) {
        this.appInitializer = new AppInitializer(folderPath);

        FlatLightLaf.setup();

        setTitle("Gestionare Casă");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout(10, 10));

        JPanel roomPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        roomPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JButton kitchenButton = createRoomButton("Bucătărie");
        JButton bedroomButton = createRoomButton("Dormitor");
        JButton storageButton = createRoomButton("Depozit");
        JButton bathroomButton = createRoomButton("Baie");

        roomPanel.add(kitchenButton);
        roomPanel.add(bedroomButton);
        roomPanel.add(storageButton);
        roomPanel.add(bathroomButton);

        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JButton itemsButton = new JButton("Vezi Toate Obiectele");
        JButton tasksButton = new JButton("Gestionează Sarcinile");

        styleButton(itemsButton);
        styleButton(tasksButton);

        itemsButton.addActionListener(e -> openItemManagerUI());
        tasksButton.addActionListener(e -> openTasksUI());

        navPanel.add(itemsButton);
        navPanel.add(tasksButton);

        add(roomPanel, BorderLayout.CENTER);
        add(navPanel, BorderLayout.SOUTH);
    }

    private JButton createRoomButton(String roomName) {
        JButton button = new JButton(roomName);
        styleButton(button);
        button.addActionListener(e -> openRoomOverviewUI(roomName));
        return button;
    }

    private void styleButton(JButton button) {
        button.setBackground(Color.decode("#1b4d1d")); // Green color
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(120, 60));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void openItemManagerUI() {
        new ItemManagerUI(appInitializer.getFolderPath()).setVisible(true);
    }

    private void openTasksUI() {
        try {
            TasksView.GUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Eroare la deschiderea interfeței pentru sarcini.", "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openRoomOverviewUI(String roomName) {
        String folderPath = appInitializer.getFolderPath();
        new RoomOverviewUI(roomName, folderPath).setVisible(true);
    }
}
