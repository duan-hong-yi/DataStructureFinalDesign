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
    mFrame mainFrame;//主Frame窗格
    mToolBar mainToolBar;//主工具栏，在菜单栏下方
    mMenuBar mainMenuBar;//主菜单栏，在主Frame窗格的顶端
    mPanel mFrameContentPane;//主内容窗格,是Frame里的内容窗格
    JScrollPane jScrollPane;//滚动窗格，被装在主内容窗格mFrameContentPane里面
    mPanel mainPanel;//主Panel,嵌套在主内容窗格内，用于装载
    JList mainList;//主文件列表

    public void build()
    {
        /*
        * 初始化基础组件
        * */
        mainFrame = new mFrame();
        mainToolBar = new mToolBar();
        mainMenuBar = new mMenuBar();
        mainPanel = new mPanel();
        mFrameContentPane = new mPanel();
        jScrollPane = new JScrollPane(mainPanel);
        mainFrame.setContentPane(mFrameContentPane);//修改内容窗格


        mFrameContentPane.add(jScrollPane,BorderLayout.EAST);
        mFrameContentPane.add(new JList<>(),BorderLayout.WEST);


        mPanel searchBarPanel = new mPanel();//搜索栏
        JTextField  searchField = new JTextField("请输入文件名");//搜索文本框
        searchBarPanel.add(new JTextField("请输入文件名"),BorderLayout.WEST);
        mFrameContentPane.add(searchBarPanel,BorderLayout.NORTH);
        searchBarPanel.add(new JButton("查询"),BorderLayout.EAST);



        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        mainPanel.add(mainToolBar, BorderLayout.PAGE_START);


        mainToolBar.add(new mButton("123"));

        /*
        * 窗口顶端菜单栏
        *
        * */
        mainMenuBar.add(new JMenuItem("test"));

        mainFrame.setJMenuBar(mainMenuBar);
        mainFrame.setSize(500,500);
        mainFrame.setVisible(true);




        File file = new File("D:\\");//TODO:此处应该是一个
        File[]files = file.listFiles();

        mListItem listItem = new mListItem(new ArrayList<>(Arrays.asList(files)));//转换成ArrayList,作为构造函数的参数
        mainList = new JList<>(listItem);
        mainList.setCellRenderer(new listItemRenderer());



        mainPanel.add(mainList);



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
