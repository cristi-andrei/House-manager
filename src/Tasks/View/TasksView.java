package Tasks.View;

import Tasks.TaskButton;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class TasksView implements ActionListener {
    public static void GUI(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("View");
        frame.setSize(175, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        JButton button = new JButton("   Add task     ");
        JButton button2 = new JButton("Remove task");
        JButton button3 = new JButton("   Edit task     ");
        JButton button4 = new JButton("Rename task");
        contentPane.add(button);
        contentPane.add(button2);
        contentPane.add(button3);
        contentPane.add(button4);
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button2.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button3.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button4.setAlignmentX(JButton.CENTER_ALIGNMENT);
        frame.setContentPane(contentPane);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskButton.addTask();
            }
        });

    }
}
