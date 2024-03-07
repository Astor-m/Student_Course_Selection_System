package 学生选课;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.Statement;

public class JSM extends JFrame {
    private JButton but1,but2,but3,but4,but5;

    public JSM () {
        this.setTitle("学生管理");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的宽
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高
        this.setBounds((width - 800) / 2, (height - 600) / 2 - 20, 800, 600); //使窗体居中
        this.setResizable(false);
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("../学生选课系统/Image/img.jpg");
        JLabel background = new JLabel(image);
        background.setOpaque(false); //背景透明
        but1 = new JButton("添加学生");
        but2 = new JButton("删除学生");
        but3 = new JButton("修改学生");
        but4 = new JButton("查询学生");
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

        but1.addActionListener(e -> {

            new add_Student();

        });
    }

    class add_Student extends JFrame {
        String name = Login.JTname.getText();   //学号或账号
        private JButton Jbu1;
        private String JLmessage1;
        JTextField JTname;
        JTextField JTname1;
        JTextField JTname2;
        JTextField JTname3;
        JTextField JTname4;
        JTextField JTname5;
        private JLabel JLname;
        private JLabel JLname1;
        private JLabel JLname2;
        private JLabel JLname3;
        private JLabel JLname4;
        private JLabel JLname5;

        ImageIcon image = new ImageIcon("../学生选课系统/Image/img1.jpg");
        public add_Student() {
            this.setTitle("增加学生");
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的宽
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高
            this.setBounds((width - 600) / 2, (height - 600) / 2 - 20, 600, 400); //使窗体居中
            this.setResizable(false);
            JLabel background = new JLabel(image);   //将背景图片封装为一个JLable
            JTname = new JTextField(20);
            JTname1 = new JTextField(20);
            JTname2 = new JTextField(20);
            JTname3 = new JTextField(20);
            JTname4 = new JTextField(20);
            JTname5 = new JTextField(20);
            JLname = new JLabel("学号：");
            JLname.setFont(new java.awt.Font("宋体", 4, 15));
            JLname.setForeground(new Color(19, 79, 50));
            JLname1 = new JLabel("姓名：");
            JLname1.setFont(new java.awt.Font("宋体", 4, 15));
            JLname1.setForeground(new Color(19, 79, 50));
            JLname2 = new JLabel("性别：");
            JLname2.setFont(new java.awt.Font("宋体", 4, 15));
            JLname2.setForeground(new Color(19, 79, 50));
            JLname3 = new JLabel("年龄：");
            JLname3.setFont(new java.awt.Font("宋体", 4, 15));
            JLname3.setForeground(new Color(19, 79, 50));
            JLname4 = new JLabel("专业：");
            JLname4.setFont(new java.awt.Font("宋体", 4, 15));
            JLname4.setForeground(new Color(19, 79, 50));
            JLname5 = new JLabel("密码：");
            JLname5.setFont(new java.awt.Font("宋体", 4, 15));
            JLname5.setForeground(new Color(19, 79, 50));
            Jbu1 = new JButton("确定");
            Jbu1.setFont(new java.awt.Font("宋体", 3, 15));
            Jbu1.setForeground(new Color(208, 16, 16));
            JTname.setBounds(175, 50, 110, 25);
            JTname1.setBounds(175, 75, 110, 25);
            JTname2.setBounds(175, 100, 110, 25);
            JTname3.setBounds(175, 125, 110, 25);
            JTname4.setBounds(175, 150, 110, 25);
            JTname5.setBounds(175, 175, 110, 25);
            JLname.setBounds(115, 50, 60, 25);
            JLname1.setBounds(115, 75, 60, 25);
            JLname2.setBounds(115, 100, 60, 25);
            JLname3.setBounds(115, 125, 60, 25);
            JLname4.setBounds(115, 150, 60, 25);
            JLname5.setBounds(115, 175, 60, 25);
            Jbu1.setBounds(115, 200, 170, 25);
            background.setLayout(null);
            background.add(JTname);
            background.add(JTname1);
            background.add(JTname2);
            background.add(JTname3);
            background.add(JTname4);
            background.add(JTname5);
            background.add(JLname);
            background.add(JLname1);
            background.add(JLname2);
            background.add(JLname3);
            background.add(JLname4);
            background.add(JLname5);
            background.add(Jbu1);
            this.add(background);
            this.setVisible(true);
            Jbu1.addActionListener(e -> {           //暂未实现不可重复选即目前可以选择已选的课程
                String SNO = JTname.getText();
                String SNAME = JTname1.getText();
                String SEX = JTname2.getText();
                String AGE = JTname3.getText();
                String SDEPT = JTname4.getText();
                String PSWD = JTname5.getText();
                //语句
                if(SNO.equals("")) {
                    JOptionPane.showMessageDialog(null,"题号不能为空！","警号⚠~",JOptionPane.ERROR_MESSAGE);
                    JTname.requestFocus();
                }
                else {  //课程号不为空
                    //SQL语句实现退课
                    try {
                        new My_Connection(); //连接数据库
                        Connection con = My_Connection.getConnection();
                        Statement stmt = con.createStatement();   //statement声明
                        //String sql1 = "select TNAME  from t where TNO = '" + name + "' ";
                        //stmt.execute(sql1);
//                    String sql = "select * from s where SNO = '" + name + "' and PSWD = '" + pwd + "'"; //SQL选择查询语句以该账号密码为条件查询该表
                        String sql = " insert into s(SNO,SNAME,SEX,AGE,SDEPT,PSWD) values('" + SNO + "','" + SNAME + "','" + SEX + "','" + AGE + "','" + SDEPT + "','" + PSWD + "') ";
                        stmt.execute(sql);    //执行
                        JOptionPane.showMessageDialog(null, "添加成功！", "恭喜~", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    } catch (Exception e1) {
                        System.out.println("添加失败~");


                    }
                }
            });
        }
    }
}

//    public static void main(String[] args) {
//        new JSM();
//    }
//}

