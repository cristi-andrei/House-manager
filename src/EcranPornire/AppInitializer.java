/*
package EcranPornire;

import javax.swing.*;
import java.io.File;

public class AppInitializer {
    private String folderPath;

    public AppInitializer(String folderPath) {
        this.folderPath = folderPath;
        createFolderIfNotExists();
    }

    private void createFolderIfNotExists() {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            if (!created) {
                System.err.println("Failed to create directory: " + folderPath);
            }
        }
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void launchUI() {
        SwingUtilities.invokeLater(() -> {
            try {
                OpeningUI openingUI = new OpeningUI(folderPath);
                openingUI.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error initializing the UI: " + e.getMessage(),
                        "Initialization Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
*/
package EcranPornire;

import javax.swing.*;
import java.io.File;

public class AppInitializer {
    private String folderPath;

    public AppInitializer(String folderPath) {
        this.folderPath = folderPath;
        createFolderIfNotExists();
    }

    private void createFolderIfNotExists() {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            if (!created) {
                System.err.println("Failed to create directory: " + folderPath);
            }
        }
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void launchUI() {
        SwingUtilities.invokeLater(() -> {
            try {
                OpeningUI openingUI = new OpeningUI(folderPath);
                openingUI.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error initializing the UI: " + e.getMessage(),
                        "Initialization Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
