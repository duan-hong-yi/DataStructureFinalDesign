package Components;

import javax.swing.*;
import java.awt.*;

public class MainUI {
    JFrame mainUI;//主窗口



    static int minWidth = 500;
    static int minHeight = 500;
    public MainUI()
    {
        mainUI = new JFrame();
        mainUI.setSize(minWidth,minHeight);
        mainUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainUI.add(new ToolBar());
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(new JMenuItem("Menu Item Test"));
        mainUI.setJMenuBar(jMenuBar);


    }
    public MainUI(int width ,int height)
    {
        mainUI = new JFrame();
        mainUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        if(width>=minWidth&&height>=minHeight) mainUI.setSize(width,height);
        else mainUI.setSize(minWidth,minHeight);



    }
    public void showMainUI()
    {
        mainUI.setVisible(true);
    }
    public void HideMainUI()
    {
        mainUI.setVisible(false);
    }
    public void setUISize(int width,int height)
    {
        mainUI.setSize(width,height);
    }
    public void setTitle(String title)
    {
        mainUI.setTitle(title);
    }
}
