package 学生选课;

import javax.swing.*;
import java.awt.*;

public class JManager extends JFrame {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    //    JPanel panel2_1 = new JPanel();
//    JPanel panel2_2 = new JPanel();
    ImageIcon image = new ImageIcon("../学生选课系统/Image/img.jpg");
    private JLabel background;
    private JButton JBsure1;
    private JButton JBsure2;
    private JButton JBsure3;
//    private JButton JBsure4;
//    private JTextArea JTarea;

    public JManager() {
        this.setTitle("管理员界面");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的宽
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高
        this.setBounds((width - 800) / 2, (height - 600) / 2 - 20, 400, 300); //使窗体居中
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        background =new JLabel(image);
        panel1.setPreferredSize(new Dimension(800,600));    //面板尺寸
        panel1.add(background);
        JLabel JLtitle = new JLabel("管理员界面");
        JLtitle.setFont(new java.awt.Font("宋体", 3, 30));
        JLtitle.setForeground(Color.black);
        JBsure1 = new JButton("学生管理");
        JBsure2 = new JButton("教师管理");
        JBsure3 = new JButton("课程管理");
//        JBsure4 = new JButton("个人信息");
//        JTarea = new JTextArea(12,14);
//        panel2.setLayout(null);//面板2的布局管理器为空
        JLtitle.setBounds(320,10,200,50);
        JBsure1.setBounds(320,80,170,25);
        JBsure2.setBounds(320,120,170,25);
        JBsure3.setBounds(320,160,170,25);
//        background.setLayout(null);
        background.add(JLtitle);
        background.add(JBsure1);
        background.add(JBsure2);
        background.add(JBsure3);
//        background.add(JBsure4);
//        panel2.add(JBsure1);
//        panel2.add(JBsure2);
//        panel2.add(JBsure3);
//        panel2.add(JBsure4);
//        panel3.add(JTarea);

//        panel2.setPreferredSize(new Dimension(200,500));    //面板尺寸
//        this.add(panel1,BorderLayout.PAGE_START);
//        this.add(panel2,BorderLayout.LINE_END);
//        this.add(panel3,BorderLayout.LINE_END);
//        this.add(panel2,BorderLayout.PAGE_END);
        this.add(panel1);
        this.setVisible(true);

        JBsure1.addActionListener(e -> {
            new JSM();  //调用学生管理界面
        });
        JBsure2.addActionListener(e -> {
            new JTM();
        });
        JBsure3.addActionListener(e -> {
            new JCM();
        });
    }

    public static void main(String[] args) {
        new JManager();
    }
}

