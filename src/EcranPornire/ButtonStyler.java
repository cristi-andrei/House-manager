package EcranPornire;

import javax.swing.*;
import java.awt.*;

public abstract class ButtonStyler {
    public static void styleTheButton(JButton button) {
        button.setBackground(Color.decode("#1b4d1d")); // Green color
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(120, 60));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
