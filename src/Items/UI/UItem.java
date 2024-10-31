package Items.UI;

import javax.swing.*;
import java.awt.*;

public class UItem extends JPanel{

    public UItem(){
        JFrame iteme = new JFrame("Iteme");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel itemStruc = new JPanel();
        JLabel itemStruc1 = new JLabel("Poate imagine");
        itemStruc1.setAlignmentX(RIGHT_ALIGNMENT);

        JPanel itemStruc2 = new JPanel();
        itemStruc2.setAlignmentX(LEFT_ALIGNMENT);
        JLabel itemStucA = new JLabel("test 1");
        JLabel itemStucB = new JLabel("descriere test");

        itemStruc2.add(itemStucA);
        itemStruc2.add(itemStucB);

        itemStruc.add(itemStruc1, itemStruc2);

    }


}
