package Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel implements ActionListener {

    public ToolBar()
    {
        super(new BorderLayout());
        JToolBar jToolBar = new JToolBar();
        addButtons(jToolBar);
        add(jToolBar,BorderLayout.PAGE_START);

    }
    public void addButtons(JToolBar jToolBar)
    {
        JButton button=null;
        button = makeNavigationButton("测试1");
        jToolBar.add(button);
        button = makeNavigationButton("测试2");
        jToolBar.add(button);
        button = makeNavigationButton("测试3");
        jToolBar.add(button);
    }
    public JButton makeNavigationButton(String text)
    {
        JButton button = new JButton(text);
        return button;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
