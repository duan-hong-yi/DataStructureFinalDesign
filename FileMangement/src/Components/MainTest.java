package Components;
import Components.ListItem.mListItem;
import Components.Renderer.listItemRenderer;
import Components.mButton.mButton;
import Components.mFrame.mFrame;
import Components.mMenuBar.mMenuBar;
import Components.mPanel.mPanel;
import Components.mToolBar.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MainTest {
    mFrame mainFrame;
    mToolBar mainToolBar;
    mMenuBar mainMenuBar;
    mPanel mainPanel;
    public void build()
    {
        mainFrame = new mFrame();
        mainToolBar = new mToolBar();
        mainMenuBar = new mMenuBar();
        mainPanel = new mPanel();
        mPanel mPanel = new mPanel();
        JScrollPane jScrollPane = new JScrollPane(mainPanel);
        mPanel.add(jScrollPane);

        mainFrame.setContentPane(mPanel);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanel.add(mainToolBar, BorderLayout.PAGE_START);


        mainToolBar.add(new mButton("123"));

        mainMenuBar.add(new JMenuItem("test"));

        mainFrame.setJMenuBar(mainMenuBar);
        mainFrame.setSize(500,500);
        mainFrame.setVisible(true);

        JList<String> list = new JList<>();
        File file = new File("D:\\");
        File [] files = file.listFiles();
        ArrayList<String> listData = new ArrayList<>();


        for(Iterator<File> iterator = Arrays.stream(files).iterator();iterator.hasNext();)
        {
            File f = iterator.next();
            listData.add(f.getName());
        }
        list.setListData(listData.toArray(new String[0]));


        //mainPanel.add(list);

        mListItem listItem = new mListItem(listData);
        JList list1 = new JList<>(listItem);
        list1.setCellRenderer(new listItemRenderer());
        mainPanel.add(list1);



    }
}
