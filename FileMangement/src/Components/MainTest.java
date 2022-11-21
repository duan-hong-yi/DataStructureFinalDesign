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
        JScrollPane jScrollPane = new JScrollPane(mainPanel);//TODO:当前考虑直接将该组件集成到mFrame中
        mPanel.add(jScrollPane,BorderLayout.EAST);
        mPanel.add(new JList<>(),BorderLayout.WEST);
        mPanel mPanel1 = new mPanel();
        mPanel1.add(new JTextField("请输入文件名"),BorderLayout.WEST);
        mPanel.add(mPanel1,BorderLayout.NORTH);
        mPanel1.add(new JButton("查询"),BorderLayout.EAST);

        mainFrame.setContentPane(mPanel);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanel.add(mainToolBar, BorderLayout.PAGE_START);


        mainToolBar.add(new mButton("123"));

        mainMenuBar.add(new JMenuItem("test"));

        mainFrame.setJMenuBar(mainMenuBar);
        mainFrame.setSize(500,500);
        mainFrame.setVisible(true);

        JList<String> list = new JList<>();
//        File file = new File("D:\\");//TODO:此处可能考虑做成一个新的方法，在点击的时候进行切换文件夹的操作
//        File [] files = file.listFiles();
        ArrayList<String> listData = readFileList("D:\\");


//        for(Iterator<File> iterator = Arrays.stream(files).iterator();iterator.hasNext();)
//        {
//            File f = iterator.next();
//            listData.add(f.getName());
//        }
        list.setListData(listData.toArray(new String[0]));


        //mainPanel.add(list);
        File file = new File("D:\\");
        File[]files = file.listFiles();
        mListItem listItem = new mListItem(new ArrayList<>(Arrays.asList(files)));//转换成ArrayList
        JList list1 = new JList<>(listItem);
        list1.setCellRenderer(new listItemRenderer());



        mainPanel.add(list1);



    }
    public ArrayList<String> readFileList(String fileRootPath)
    {
        ArrayList<String>listData = new ArrayList<>();
        File file = new File(fileRootPath);
        File[] files;
        if(file.isDirectory())
        {
            files = file.listFiles();
        }
        else
        {
            files = new File[]{};
        }
        for(Iterator<File> iterator = Arrays.stream(files).iterator();iterator.hasNext();)
        {
            File f = iterator.next();
            listData.add(f.getName());

        }
        return listData;
    }
}
