package Components.Renderer;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import sun.awt.shell.ShellFolder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/*
* 该类用于渲染列表对象
* 列表对象
* */
public class listItemRenderer extends DefaultListCellRenderer {//继承了默认列表渲染器
    File[] files;
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
        File file = (File)value;
        String name = file.getName();
        //设置文字,目前暂定为列表对象的名字
        setText(name);
        Image image;
        //设置图片
        //TODO:这里的图标还没有具体处理完毕

        image = ((ImageIcon)FileSystemView.getFileSystemView().getSystemIcon(file)).getImage();

        setIcon(new ImageIcon(image));

        // setIcon(new ImageIcon(image));
        setIconTextGap(30);

        if(isSelected)
        {
            setForeground(Color.BLUE);
            setBackground(Color.yellow);
        }
        else
        {
            setBackground(Color.white);
            setForeground(Color.BLACK);
        }

        return this;
    }
    public listItemRenderer()
    {}
    public listItemRenderer(File[] files)
    {
        this.files = files;
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
        for(Iterator<File> iterator = Arrays.stream(files).iterator(); iterator.hasNext();)
        {
            File f = iterator.next();
            listData.add(f.getName());

        }
        return listData;
    }
}
