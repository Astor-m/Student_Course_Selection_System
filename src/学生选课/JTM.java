package 学生选课;

import javax.swing.*;
import java.awt.*;

public class JTM extends JFrame {
    private JButton but1,but2,but3,but4,but5;

    public JTM () {
        this.setTitle("教师管理");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的宽
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高
        this.setBounds((width - 800) / 2, (height - 600) / 2 - 20, 800, 600); //使窗体居中
        this.setResizable(false);
//

        ImageIcon image = new ImageIcon("../学生选课系统/Image/img.jpg");
        JLabel background = new JLabel(image);
        background.setOpaque(false); //背景透明
        but1 = new JButton("添加教师");
        but2 = new JButton("删除教师");
        but3 = new JButton("修改教师");
        but4 = new JButton("查询教师");
        but5 = new JButton("返回");
        but1.setBounds(30,40,170,25);
        but2.setBounds(30,120,170,25);
        but3.setBounds(30,200,170,25);
        but4.setBounds(30,280,170,25);
        but5.setBounds(30,350,170,25);
        background.add(but1);
        background.add(but2);
        background.add(but3);
        background.add(but4);
        background.add(but5);




        this.add(background);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JTM();
    }
}

