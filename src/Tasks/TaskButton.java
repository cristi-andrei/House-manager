package Tasks;

import javax.swing.*;

public abstract class TaskButton {
    public static void addTask(){
        JTextField name = new JTextField();
        JTextField deadline = new JTextField();

        Object[] addTask = {
            "Nume:", name,
            "Deadline:", deadline
        };
        int option=JOptionPane.showConfirmDialog(null, addTask,"Adaugare task",JOptionPane.OK_CANCEL_OPTION);
        if(option==JOptionPane.OK_OPTION){
            if(!name.getText().isEmpty() && !deadline.getText().isEmpty()){
                TaskJTF.counttask++;
                TaskJTF.taskjtf.add(TaskJTF.counttask,new TaskJTF(name,deadline));
                TasksVector.tasks.add(TaskJTF.counttask,new Task(TaskJTF.taskjtf.elementAt(TaskJTF.counttask).name.getText(),TaskJTF.taskjtf.elementAt(TaskJTF.counttask).deadline.getText()));
            }
            else {
                JOptionPane.showMessageDialog(null, "Eroare! Ati lasat campurile goale","Eroare",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(option==JOptionPane.CANCEL_OPTION){

        }

    }

    public static void removeTask() {
        // Verifică dacă există task-uri de șters
        if (TasksVector.tasks.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nu există task-uri de șters!", "Eroare", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] taskNames = new String[TasksVector.tasks.size()];
        for (int i = 0; i < TasksVector.tasks.size(); i++) {
            taskNames[i] = TasksVector.tasks.get(i).getName();
        }

        // Afișează dialogul pentru selectarea task-ului
        String selectedTask = (String) JOptionPane.showInputDialog(null, "Selectați task-ul de șters:", "Ștergere task", JOptionPane.QUESTION_MESSAGE, null, taskNames, taskNames[0]);

        // Dacă s-a selectat un task, șterge-l din ambele liste
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
                JOptionPane.showMessageDialog(null, "Task-ul a fost șters cu succes!", "Ștergere reușită", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }


    public static void button2(){

    }

    public static void button3(){

    }

    public static void button4(){

    }
}
