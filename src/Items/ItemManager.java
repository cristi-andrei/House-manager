package Items;

import java.util.List;

public class ItemManager {
    private List<Item> iteme;


    public void addIteme(Item i) {
        iteme.add(i);
    }

    public List<Item> getIteme() {
        return iteme;
    }
}
