package Components.mButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mButton extends JButton implements ActionListener {
    public mButton()
    {
        addActionListener(this);//添加监听器
    }
    public mButton(String text)
    {
        super(text);
        addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
