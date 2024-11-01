package Tasks;

import javax.swing.*;
import java.util.Vector;

public class TaskJTF {

    public JTextField name;
    public JTextField deadline;
    public JTextField tag;
    public static int counttask=-1;
    public TaskJTF(JTextField name, JTextField deadline, JTextField tag)
    {
        this.name = name;
        this.deadline = deadline;
        this.tag = tag;
    }

    public static Vector<TaskJTF> taskjtf = new Vector<>();

}
