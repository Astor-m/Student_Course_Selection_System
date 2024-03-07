package 学生选课;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class JTeacher extends JFrame {
    JLabel JLmessage1,JLmessage2,JLmessage3,JLmessage4,JLmessage5;
    String name = Login.JTname.getText();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    //    JPanel panel2_1 = new JPanel();
//    JPanel panel2_2 = new JPanel();
    ImageIcon image = new ImageIcon("../学生选课系统/Image/img.jpg");
    private JLabel background;
    private JButton JBsure1,JBsure2,JBsure3,JBsure4,JBsure5;
    private JTextArea JTarea;

    public JTeacher() {
        this.setTitle("教师界面");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的宽
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高
        this.setBounds((width - 800) / 2, (height - 600) / 2 - 20, 800, 600); //使窗体居中
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        background =new JLabel(image);
        panel1.setPreferredSize(new Dimension(800,100));    //面板尺寸
        panel1.add(background);
//        JBsure1 = new JButton("个人信息");
        JBsure2 = new JButton("添加论文题目");
        JBsure3 = new JButton("选题名单");
        JBsure4 = new JButton("修改密码");
        JBsure5 = new JButton("返回");
        JTarea = new JTextArea(27,45);
        panel3.setPreferredSize(new Dimension(500,500));    //面板尺寸
//        panel2.setLayout(new GridLayout(4,1));//面板2的布局管理器为空
        panel2.setLayout(null);
        panel2.setPreferredSize(new Dimension(200,500));    //面板尺寸
//        JBsure1.setBounds(1,40,170,25);
        JBsure2.setBounds(1,80,170,25);
        JBsure3.setBounds(1,120,170,25);
        JBsure4.setBounds(1,160,170,25);
        JBsure5.setBounds(1,200,170,25);
//        background.add(JBsure1);
//        background.add(JBsure2);
//        background.add(JBsure3);
//        background.add(JBsure4);
//        panel2.add(JBsure1);
        panel2.add(JBsure2);
        panel2.add(JBsure3);
        panel2.add(JBsure4);
        panel2.add(JBsure5);
//        panel3.add(JTarea);

//        panel2.setPreferredSize(new Dimension(200,450));    //面板尺寸
//        this.add(panel1,BorderLayout.PAGE_START);
        this.add(panel1,BorderLayout.WEST);
        this.add(panel2,BorderLayout.LINE_END);
        this.add(panel3,BorderLayout.LINE_END);
//        this.add(panel2,BorderLayout.PAGE_END);
        this.setVisible(true);

        try {
            new My_Connection(); //连接数据库
            Connection con = My_Connection.getConnection();
            Statement stmt = con.createStatement();   //statement声明
            String sql = "select TNO,TNAME,SEX,TITLE from t where TNO = '" + name + "' "; //SQL选择查询语句以该账号为条件查询该表
            ResultSet rs = stmt.executeQuery(sql);    //执行查询  ResultSet对象存放操作结果，一次只能看到一行数据
            while (rs.next()) {

                JLmessage1 = new JLabel("工号："+rs.getString("TNO"));
//        JLmessage1 = new JLabel("学号："+"19408010113");
                JLmessage1.setFont(new java.awt.Font("宋体", 3, 30));
                JLmessage1.setForeground(Color.black);
                JLmessage2 = new JLabel("姓名:"+rs.getString("TNAME"));
//        JLmessage2 = new JLabel("姓名:"+"翟明飞");
                JLmessage2.setFont(new java.awt.Font("宋体", 3, 30));
                JLmessage2.setForeground(Color.black);
                JLmessage3 = new JLabel("性别:"+rs.getString("SEX"));
//        JLmessage3 = new JLabel("性别:"+"男");
                JLmessage3.setFont(new java.awt.Font("宋体", 3, 30));
                JLmessage3.setForeground(Color.black);
                JLmessage4 = new JLabel("职称:"+rs.getString("TITLE"));
//        JLmessage4 = new JLabel("年龄:"+"20");
                JLmessage4.setFont(new java.awt.Font("宋体", 3, 30));
                JLmessage4.setForeground(Color.black);


                JLmessage1.setBounds(150,40,300,50);
                JLmessage2.setBounds(150,100,250,50);
                JLmessage3.setBounds(150,160,200,50);
                JLmessage4.setBounds(150,220,200,50);
//                JLmessage5.setBounds(150,280,250,50);
                panel3.setLayout(null);
                panel3.add(JLmessage1);
                panel3.add(JLmessage2);
                panel3.add(JLmessage3);
                panel3.add(JLmessage4);
//                panel3.add(JLmessage5);

            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("出错");
        }

//        JBsure1.addActionListener(e -> {
//            //
//        });
        //加题目
        JBsure2.addActionListener(e -> {
            //
            new add_Grade();
        });
        //学生名单
        JBsure3.addActionListener(e -> {
            //
            new list_Grade();
        });
        //修改密码
        JBsure4.addActionListener(e -> {
            //
            new update_pswd();
        });
        //返回
        JBsure5.addActionListener(e -> {
            //
            this.dispose();
            new Login();
        });
    }

//    public static void main(String[] args) {
//        new JTeacher();
//    }
}

//加题目
 class add_Grade extends JFrame {
    String name = Login.JTname.getText();   //学号或账号
    private JButton Jbu1;
    private String JLmessage1;
    static JTextField JTname;
    static JTextField JTname1;
    private JLabel JLname;
    private JLabel JLname1;

    ImageIcon image = new ImageIcon("../学生选课系统/Image/img1.jpg");
    public add_Grade() {
        this.setTitle("选题");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的宽
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高
        this.setBounds((width - 600) / 2, (height - 600) / 2 - 20, 400, 250); //使窗体居中
        this.setResizable(false);
        JLabel background =new JLabel(image);   //将背景图片封装为一个JLable
        JTname = new JTextField(20);
        JTname1 = new JTextField(20);
        JLname = new JLabel("题号：");
        JLname.setFont(new java.awt.Font("宋体", 4, 15));
        JLname.setForeground(new Color(19, 79, 50));
        JLname1 = new JLabel("题目：");
        JLname1.setFont(new java.awt.Font("宋体", 4, 15));
        JLname1.setForeground(new Color(19, 79, 50));
        Jbu1 = new JButton("选该题");
        Jbu1.setFont(new java.awt.Font("宋体", 3, 15));
        Jbu1.setForeground(new Color(208, 16, 16));
        JTname.setBounds(175,50,110,25);
        JTname1.setBounds(175,75,110,25);
        JLname.setBounds(115,50,60,25);
        JLname1.setBounds(115,75,60,25);
        Jbu1.setBounds(115,130,170,25);
        background.setLayout(null);
        background.add(JTname);
        background.add(JTname1);
        background.add(JLname);
        background.add(JLname1);
        background.add(Jbu1);
        this.add(background);
        this.setVisible(true);
        Jbu1.addActionListener(e -> {           //暂未实现不可重复选即目前可以选择已选的课程
            String CNO = JTname.getText();
            String CNAME = JTname1.getText();
            //语句
            if(CNO.equals("")) {
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
                    String sql = " insert into c(CNO,CNAME,CREDI,CDEPT,TNAME,TNO) values('" + CNO + "','" + CNAME + "','2','信息管理','李军','" + name + "') ";
                    stmt.execute(sql);    //执行
                    JOptionPane.showMessageDialog(null, "发布成功！", "恭喜~", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } catch (Exception e1) {
                    System.out.println("发布失败~");


                }
            }
        });
    }

}

//名单展示
class list_Grade extends JFrame {
    private JTable table1;

    int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的宽
    int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高
    public list_Grade() {
        String name = Login.JTname.getText();
//            String name = Login.JTname.getText();
            Vector titlename = new Vector();//{"学号","姓名","性别","年龄","专业"};
            titlename.add("学号");
            titlename.add("姓名");
            titlename.add("题目");
            titlename.add("题号");
            titlename.add("老师");

            Vector rowdata = new Vector();  //数据
            ResultSet rs = null;
            try {
                new My_Connection(); //连接数据库
                Connection con = My_Connection.getConnection();
                Statement stmt = con.createStatement();   //statement声明
                String sql = "select S.SNO,SNAME,CNAME,C.CNO,T.TNAME from s,c,sc,t where S.SNO=SC.SNO and C.CNO=SC.CNO and C.TNAME=T.TNAME and T.TNO = '" + name + "' "; //SQL选择查询语句以该账号为条件查询该表
                rs = stmt.executeQuery(sql);

            } catch (Exception e1) {
                System.out.println(e1);
                System.out.println("查询出错");
            }
            try{
                while (rs.next()) {
                    Vector hang = new Vector();
                    hang.add(rs.getString("S.SNO"));
                    hang.add(rs.getString("SNAME"));
                    hang.add(rs.getString("CNAME"));
                    hang.add(rs.getString("C.CNO"));
                    hang.add(rs.getString("TNAME"));
                    rowdata.add(hang);
                }
            }catch(Exception e1){
                System.out.println("显示错误");
            }

            table1 = new JTable(rowdata, titlename);
            table1.setEnabled(false);   //表格不能编辑
            JScrollPane sroll = new JScrollPane(table1);

            JFrame jf = new JFrame();
            jf.setTitle("学生名单");
            jf.setBounds((width - 600) / 2, (height - 600) / 2 - 20, 600, 200); //使窗体居中
            jf.setResizable(false);
//            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jf.add(sroll);
            jf.setVisible(true);

        };
    }


//修改密码
class update_pswd extends JFrame {
    String name = Login.JTname.getText();
    //    String pwd = String.valueOf(Login.JTpwd.getPassword());
    private JButton Jbu1;
    //    static JTextField JTname;
    private JPasswordField JTpwd1, JTpwd2;
    private JLabel JLname1, JLname2;
    ImageIcon image = new ImageIcon("../学生选课系统/Image/img1.jpg");

    public update_pswd() {
        this.setTitle("更改密码");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的宽=1536
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高=864
        this.setBounds((width - 600) / 2, (height - 600) / 2 - 20, 400, 250); //使窗体居中
        this.setResizable(false);
        JLabel background = new JLabel(image);   //将背景图片封装为一个JLable
//        JTname = new JTextField(20);
        JTpwd1 = new JPasswordField(20);
        JTpwd2 = new JPasswordField(20);
        JLname1 = new JLabel("旧密码：");
        JLname1.setFont(new java.awt.Font("宋体", 4, 15));
        JLname1.setForeground(new Color(19, 79, 50));
        JLname2 = new JLabel("新密码：");
        JLname2.setFont(new java.awt.Font("宋体", 4, 15));
        JLname2.setForeground(new Color(19, 79, 50));
        Jbu1 = new JButton("确认！");
        Jbu1.setFont(new java.awt.Font("宋体", 3, 15));
        Jbu1.setForeground(new Color(208, 16, 16));
        JTpwd1.setBounds(175, 50, 110, 25);//旧密码
        JLname1.setBounds(115, 50, 60, 25);
        JTpwd2.setBounds(175, 90, 110, 25);//新密码
        JLname2.setBounds(115, 90, 60, 25);
        Jbu1.setBounds(115, 130, 170, 25);
        background.setLayout(null);
        background.add(JTpwd1);
        background.add(JLname1);
        background.add(JTpwd2);
        background.add(JLname2);
        background.add(Jbu1);
        this.add(background);
        this.setVisible(true);

        Jbu1.addActionListener(e -> {
            String old_pwd = String.valueOf(JTpwd1.getPassword());  //键盘上输入旧密码
            String pwd = null;
            try {
                new My_Connection(); //连接数据库
                Connection con = My_Connection.getConnection();
                Statement stmt = con.createStatement();   //statement声明
                String sql = "select PSWD from t where TNO = '" + name + "' "; //SQL选择查询语句以该账号为条件查询该表
                ResultSet rs = stmt.executeQuery(sql);    //执行查询  ResultSet对象存放操作结果，一次只能看到一行数据
                while (rs.next()) {
                    pwd = rs.getString("PSWD");
                    System.out.println(pwd);
                }

                if (old_pwd.equals(pwd)) {      //实现不退出教师页面而能一直进行改密；
                    String new_pwd = String.valueOf(JTpwd2.getPassword());
//                            Statement stmt=null;
//                            Connection con=null;
                    //  连接数据库实现改密码
                    try {
                        new My_Connection(); //连接数据库
                        Connection con1 = My_Connection.getConnection();
                        Statement stmt1 = con1.createStatement();   //statement声明
                        String sql1 = "update T set PSWD ='" + new_pwd + "' where TNO = '" + name + "'"; //SQL选择查询语句以该账号密码为条件查询该表
                        stmt1.execute(sql1);    //执行更新语句
                        JOptionPane.showMessageDialog(null, "改密成功！", "恭喜~", JOptionPane.ERROR_MESSAGE);
                        this.dispose();
//                    JStudent.dispose();
//                    new Login();    //重新登录

                    } catch (Exception e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "改密失败！", "很遗憾~", JOptionPane.ERROR_MESSAGE);
                    }

                    //弹出消息对话框
                } else {
                    //弹出消息对话框
                    JOptionPane.showMessageDialog(null, "旧密码填写错误！", "警告⚠", JOptionPane.ERROR_MESSAGE);
                    JTpwd1.requestFocus();
                }
            } catch (Exception e2) {
                System.out.println("查旧密码出错");
            }
        });
    }
}

