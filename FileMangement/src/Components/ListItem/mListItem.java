package Components.ListItem;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
/*
* 列表元素对象
* */
public class mListItem extends AbstractListModel {
    ArrayList<File> list;
    public mListItem(ArrayList<File>arrayList)
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
