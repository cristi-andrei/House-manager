package Tasks.View;

import EcranPornire.ButtonStyler;
import Tasks.Task;
import Tasks.TaskButton;
import Tasks.TaskJTF;
import Tasks.TasksVector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public abstract class TasksView implements ActionListener {
    public static void GUI() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"));
        String name;
        while ((name = reader.readLine()) != null) {
            String deadline = reader.readLine();
            String tag = reader.readLine();
            if (deadline != null && tag != null) {
                TaskJTF.counttask++;
                TasksVector.tasks.add(TaskJTF.counttask,new Task(name, deadline,tag));
                TaskJTF.taskjtf.add(TaskJTF.counttask,new TaskJTF(null,null,null));
            }
        }
        reader.close();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setTitle("View");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        JButton button = new JButton("    Add task   ");
        JButton button2 = new JButton("Remove task");
        JButton button3 = new JButton("   Edit task    ");
        JButton button4 = new JButton("   View task   ");

        ButtonStyler.styleTheButton(button);
        ButtonStyler.styleTheButton(button2);
        ButtonStyler.styleTheButton(button3);
        ButtonStyler.styleTheButton(button4);

        Dimension buttonSize = new Dimension(300, 75);
        Font buttonFont = new Font("Arial", Font.BOLD, 30);
        button.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);
        button4.setFont(buttonFont);

        button.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);

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

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskButton.removeTask();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskButton.editTask();
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskButton.viewTask();
            }
        });

        FileWriter fileWriter = new FileWriter("tasks.txt", true);
        PrintWriter writer = new PrintWriter(fileWriter);

        PrintWriter clear = new PrintWriter("tasks.txt");
        clear.print("");
        clear.close();

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                if (!TasksVector.tasks.isEmpty()) {
                    for(int i = 0; i < TasksVector.tasks.size(); i++){
                        writer.println(TasksVector.tasks.get(i).toString());
                    }
                    writer.close();
                    frame.dispose();
                }
            }
        }
        );

    }
}
