package Tasks;

import javax.swing.*;
import java.awt.*;

public abstract class TaskButton {
    public static void addTask(){
        JTextField name = new JTextField();
        JTextField deadline = new JTextField();
        JTextField tag= new JTextField();
        Object[] addTask = {
            "Nume:", name,
            "Deadline:", deadline,
                "Tag:", tag
        };
        int option=JOptionPane.showConfirmDialog(null, addTask,"Adaugare task",JOptionPane.OK_CANCEL_OPTION);
        if(option==JOptionPane.OK_OPTION){
            if(!name.getText().isEmpty() && !deadline.getText().isEmpty() && !tag.getText().isEmpty()){
                TaskJTF.counttask++;
                TaskJTF.taskjtf.add(TaskJTF.counttask,new TaskJTF(name,deadline, tag));
                TasksVector.tasks.add(TaskJTF.counttask,new Task(TaskJTF.taskjtf.elementAt(TaskJTF.counttask).name.getText(),TaskJTF.taskjtf.elementAt(TaskJTF.counttask).deadline.getText(),TaskJTF.taskjtf.elementAt(TaskJTF.counttask).tag.getText()));
            }
            else {
                JOptionPane.showMessageDialog(null, "Eroare! Ati lasat campurile goale","Eroare",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(option==JOptionPane.CANCEL_OPTION){

        }

    }

    public static void removeTask() {

        if (TasksVector.tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nu exista task-uri de sters!", "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] taskNames = new String[TasksVector.tasks.size()];
        for (int i = 0; i < TasksVector.tasks.size(); i++) {
            taskNames[i] = TasksVector.tasks.get(i).getName();
        }

        String selectedTask = (String) JOptionPane.showInputDialog(null, "Selectati task-ul de sters:", "Stergere task", JOptionPane.QUESTION_MESSAGE, null, taskNames, taskNames[0]);

        if (selectedTask != null) {
            int indexToRemove = -1;
            for (int i = 0; i < TasksVector.tasks.size(); i++) {
                if (TasksVector.tasks.get(i).getName().equals(selectedTask)) {
                    indexToRemove = i;
                    break;
                }
            }

            if (indexToRemove != -1) {
                TasksVector.tasks.remove(indexToRemove);

                TaskJTF.taskjtf.remove(indexToRemove);
                TaskJTF.counttask--;
                JOptionPane.showMessageDialog(null, "Task-ul a fost sters cu succes!", "Stergere reusita", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }


    public static void editTask() {
        if (TasksVector.tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nu exista task-uri de modificat!", "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String[] taskNames = new String[TasksVector.tasks.size()];
        for (int i = 0; i < TasksVector.tasks.size(); i++) {
            taskNames[i] = TasksVector.tasks.get(i).getName();
        }
        String selectedTask = (String) JOptionPane.showInputDialog(null, "Selectati task-ul de modificat:", "Modificare task", JOptionPane.QUESTION_MESSAGE, null, taskNames, taskNames[0]);
        if (selectedTask != null) {
            int indexToEdit = -1;
            for (int i = 0; i < TasksVector.tasks.size(); i++) {
                if (TasksVector.tasks.get(i).getName().equals(selectedTask)) {
                    indexToEdit = i;
                    break;
                }
            }
            if (indexToEdit != -1) {
                JTextField name = new JTextField();
                JTextField deadline = new JTextField();
                Object[] editTask = {
                        "Nume:",name,
                        "Deadline:",deadline,
                };

                int option=JOptionPane.showConfirmDialog(null,editTask,"Modificare task",JOptionPane.OK_CANCEL_OPTION);
                if(option==JOptionPane.OK_OPTION){
                    if(name.getText().isEmpty() && !deadline.getText().isEmpty()){
                        TasksVector.tasks.get(indexToEdit).setDeadline(deadline.getText());
                        JOptionPane.showMessageDialog(null, "Task-ul a fost modificat cu succes!", "Modificare reusita", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if (!name.getText().isEmpty() && deadline.getText().isEmpty()) {
                        TasksVector.tasks.get(indexToEdit).setName(name.getText());
                        JOptionPane.showMessageDialog(null, "Task-ul a fost modificat cu succes!", "Modificare reusita", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if (!name.getText().isEmpty() && !deadline.getText().isEmpty()) {
                        TasksVector.tasks.get(indexToEdit).setName(name.getText());
                        TasksVector.tasks.get(indexToEdit).setDeadline(deadline.getText());
                        JOptionPane.showMessageDialog(null, "Task-ul a fost modificat cu succes!", "Modificare reusita", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else if (name.getText().isEmpty() && deadline.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Eroare! Ati lasat campurile goale","Eroare",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    public static void viewTask(){
        if (TasksVector.tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nu exista task-uri de vizionat!", "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Font textFont = new Font("Arial", Font.BOLD, 30);
        JFrame frameview = new JFrame();
        frameview.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameview.setTitle("View");
        frameview.setSize(400, 600);
        frameview.setLocationRelativeTo(null);
        frameview.setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        JTextPane textPane = new JTextPane();
        StringBuilder tasksText = new StringBuilder();
        for (int i = 0; i < TasksVector.tasks.size(); i++) {
            tasksText.append("Nume: ").append(TasksVector.tasks.get(i).getName()).append("\nDeadline: ").append(TasksVector.tasks.get(i).getDeadline()).append("\nTag:").append(TasksVector.tasks.get(i).getTag()).append("\n\n");
        }
        textPane.setFont(textFont);
        textPane.setText(tasksText.toString());
        contentPane.add(textPane);
        frameview.setContentPane(contentPane);
        frameview.setVisible(true);
    }


}
