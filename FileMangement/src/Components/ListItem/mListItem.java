package Components.ListItem;

import javax.swing.*;
import java.util.ArrayList;
/*
* 列表对象
* */
public class mListItem extends AbstractListModel {
    ArrayList<String> list;
    public mListItem(ArrayList<String>arrayList)
    {
        list=arrayList;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Object getElementAt(int index) {
        return list.get(index);
    }
}
