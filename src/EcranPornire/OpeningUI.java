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
        //ImageIcon test = new ImageIcon("C:\\Users\\vladm\\OneDrive\\Desktop\\efc2a80b7f03e79e885b56d97d4757b1.jpg");
        //ImageIcon bucatarieImage = new ImageIcon("C:\\Users\\vladm\\OneDrive\\Desktop\\facultateig\\OOP\\poze proiect 3\\bucatarie.jpg");

        FlatLightLaf.setup();

        setTitle("Gestionare Casă");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout(10, 10));

        JPanel roomPanel = new JPanel(new GridBagLayout());
        roomPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel welcomeLabel = new JLabel("Bine a-ti venit");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setAlignmentX(CENTER_ALIGNMENT);  // Center the text
        welcomeLabel.setForeground(Color.DARK_GRAY);

        JButton kitchenButton = createRoomButton("Bucătărie");
        JButton bathroomButton = createRoomButton("Baie");
        JButton storageButton = createRoomButton("Depozit");
        JButton bedroomButton = createRoomButton("Dormitor");

        // Bucătărie
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;  // Full width of 1
        gbc.gridheight = 2; // Height spans 2 rows
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.4;  // Assign some weight for resizing
        gbc.weighty = 1.0;  // Full height for Bucătărie
        gbc.insets = new Insets(5, 5, 5, 5); // Add spacing around
        roomPanel.add(kitchenButton, gbc);

        // Dormitor
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.6;  // Width of Dormitor
        gbc.weighty = 0.5;  // Same height as Bucătărie
        gbc.insets = new Insets(5, 5, 5, 5);
        roomPanel.add(bedroomButton, gbc);

        // Baie
        gbc.gridx = 1; // Set to the middle column
        gbc.gridy = 0; // First row
        gbc.gridwidth = 1; // Occupy 1 column
        gbc.gridheight = 1; // Height is 1 row
        gbc.weightx = 0.2;  //width
        gbc.weighty = 0.125; // height
        gbc.insets = new Insets(5, 5, 5, 5); // Add spacing
        roomPanel.add(bathroomButton, gbc);

        // Depozit
        gbc.gridx = 1; //
        gbc.gridy = 1; // Second row
        gbc.gridwidth = 1; // Occupy 1 column
        gbc.gridheight = 1; // Same height
        gbc.weightx = 0.2;  // width
        gbc.weighty = 0.25; // height
        gbc.insets = new Insets(5, 5, 5, 5); // Add spacing=
        roomPanel.add(storageButton, gbc);

        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JButton itemsButton = new JButton("Vezi Toate Obiectele");
        JButton tasksButton = new JButton("Gestionează Sarcinile");

        ButtonStyler.styleTheButton(itemsButton);
        ButtonStyler.styleTheButton(tasksButton);

        itemsButton.addActionListener(e -> openItemManagerUI());
        tasksButton.addActionListener(e -> openTasksUI());

        navPanel.add(itemsButton);
        navPanel.add(tasksButton);

        add(roomPanel, BorderLayout.CENTER);
        add(navPanel, BorderLayout.SOUTH);
    }

    /*private JButton createRoomButton(String roomName, ImageIcon image) {
        JButton button = new JButton(roomName, image);
        ButtonStyler.styleTheButton(button);
        button.addActionListener(e -> openRoomOverviewUI(roomName));
        return button;
    }*/

    private JButton createRoomButton(String roomName) {
        JButton button = new JButton(roomName);
        ButtonStyler.styleTheButton(button);
        button.addActionListener(e -> openRoomOverviewUI(roomName));
        return button;
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
