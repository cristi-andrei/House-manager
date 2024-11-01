package Tasks;

import javax.swing.*;
import java.util.Vector;

public class Task {
    private String name;
    private String deadline;
    private String tag;

    public Task(String name, String deadline, String tag) {
        this.name = name;
        this.deadline = deadline;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getTag() {return tag;}

    public void setName(String name) {
        this.name = name;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setTag(String tag) {this.tag = tag;}

    @Override
    public String toString() {
        return name+"\n"+deadline+"\n"+tag;
    }

}
