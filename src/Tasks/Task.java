package Tasks;

import javax.swing.*;
import java.util.Vector;

public class Task {
    private String name;
    private String deadline;

    public String getName() {
        return name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public class TaskJTF
    {
        public JTextField name;
        public JTextField deadline;
        public TaskJTF(JTextField name, JTextField deadline)
        {
            this.name = name;
            this.deadline = deadline;
        }
        //public static Vector<TaskJTF> taskjtf = new Vector<>();
    }
}
