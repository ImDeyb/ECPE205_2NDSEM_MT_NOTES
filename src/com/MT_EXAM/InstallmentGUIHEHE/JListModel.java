package InstallmentGUIHEHE;

import javax.swing.*;
import java.util.ArrayList;

public class JListModel extends AbstractListModel {
    ArrayList<Items> items;
    public JListModel(){
        items = new ArrayList<>();
    }
    public void addItem(Items item){
        items.add(item);
    }
    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public Object getElementAt(int index) {
        return items.get(index);
    }
}
