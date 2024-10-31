package Tasks;

import javax.swing.*;
import java.util.Vector;

public class TaskJTF {

    public JTextField name;
    public JTextField deadline;
    public static int counttask=-1;
    public TaskJTF(JTextField name, JTextField deadline)
    {
        this.name = name;
        this.deadline = deadline;
    }

    public static Vector<TaskJTF> taskjtf = new Vector<>();

}
