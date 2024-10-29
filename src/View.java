
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class View implements ActionListener {
    public static void GUI(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("View");
        frame.setSize(600, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        JButton button = new JButton("Add task");
        JButton button2 = new JButton("Remove task");
        JButton button3 = new JButton("Edit task");
        JButton button4 = new JButton("Rename task");
        contentPane.add(button);
        contentPane.add(button2);
        contentPane.add(button3);
        contentPane.add(button4);
        frame.setContentPane(contentPane);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
