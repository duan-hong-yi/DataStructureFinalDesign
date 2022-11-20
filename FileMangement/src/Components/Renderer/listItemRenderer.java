package Components.Renderer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
/*
* 该类用于渲染列表对象
* 列表对象
* */
public class listItemRenderer extends DefaultListCellRenderer {//继承了默认列表渲染器
    @Override
    /*
    * list – The JList we're painting.
    * value – The value returned by list.getModel().getElementAt(index).
    * index – The cells index.
    * isSelected – True if the specified cell was selected.
    * cellHasFocus – True if the specified cell has the focus
    * */
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
    {
        String name = (String)value;
        //设置文字
        setText(name);
        Image image;
        //设置图片
        //TODO:这里的图标还没有具体处理完毕
        try {
           image  = ImageIO.read(new File("D:\\JavaCodeBase\\DataStructureFinalDesign\\images\\FileIcon.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


       // setIcon(new ImageIcon(image));
        setIconTextGap(30);

        if(isSelected)
        {
            setForeground(Color.BLUE);
            setBackground(Color.yellow);
            setIcon(new ImageIcon(image));
        }
        else
        {
            setBackground(Color.white);
            setForeground(Color.BLACK);
            setIcon(null);
        }
        return this;
    }
}
