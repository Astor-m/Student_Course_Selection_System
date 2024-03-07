package 学生选课;


import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame {
    public int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的宽
    public int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高
    //    TextField tf = new TextField(20);
    JPanel jp = new JPanel();

    ImageIcon image = new ImageIcon("../学生选课系统/Image/img.jpg");
    //    ImageIcon image2 = new ImageIcon("out/production/学生选课系统/学生选课/Image/Z.png");
//    ImageIcon image2 = new ImageIcon("out/production/学生选课系统/学生选课/Image/erweiam.png");
    ImageIcon image2 =new ImageIcon("../学生选课系统/Image/erweima.jpg");
    private JLabel JLtitle;
    private JLabel JLname;
    private JLabel JLpwd;
    static JTextField JTname;
    static JPasswordField JTpwd;
    private JButton JBsure;
    private  JRadioButton Jrb1,Jrb2,Jrb3;       //定义单选按钮
    ButtonGroup group=new ButtonGroup();    //按钮组 实现单选
    //    private  static LoginListener ll = null;
//    private JButton JBexit;
    public Login() {
        this.setTitle("学生选课系统");

        this.setBounds((width - 800) / 2, (height - 600) / 2 - 20, 800, 600); //使窗体居中
        this.setResizable(false);

        JLtitle = new JLabel("用户登录界面");
        JLtitle.setFont(new Font("宋体", 4, 50));
        JLtitle.setForeground(Color.black);
        JLname = new JLabel("用户名：");//设置Label和按钮名
        JLname.setForeground(Color.yellow);
        JLpwd = new JLabel("密  码：");
        JLpwd.setForeground(Color.yellow);
        JTname = new JTextField(20);
        JTpwd = new JPasswordField(20);
        JBsure = new JButton("登录");
        Jrb1 = new JRadioButton("学生");
        Jrb2 = new JRadioButton("老师");
        Jrb3 = new JRadioButton("管理员");
        JLabel background =new JLabel(image);   //将背景图片封装为一个JLable
        JLabel erweima = new JLabel(image2);    //二维码封装为JLable
//        Jrb1.setFocusPainted(false);
//        Jrb2.setFocusPainted(false);
//        Jrb3.setFocusPainted(false);
        Jrb3.setBounds(430,330,65,25);
        Jrb2.setBounds(375,330,55,25);
        Jrb1.setBounds(320,330,55,25);
        JLtitle.setBounds(250,50,300,100);
        JLname.setBounds(260, 240, 60, 25);//设置Label和按钮大小
        JTname.setBounds(320, 240, 170, 25);
        JLpwd.setBounds(260,280,60,25);
        JTpwd.setBounds(320,280,170,25);
        JBsure.setBounds(320,380,170,25);
        erweima.setBounds(680,440,100,100);
//        JBexit.setBounds(180,130,60,25);

        background.setBounds(0,0,800,image.getIconHeight());
        background.setOpaque(false); //背景透明
        background.setLayout(null);
        group.add(Jrb1);
        group.add(Jrb2);
        group.add(Jrb3);    //将单选组件放在一个组件组里从而实现单选
        background.add(this.Jrb1);
        background.add(this.Jrb2);
        background.add(this.Jrb3);
        background.add(JLtitle);
        background.add(JLname);
        background.add(JTname);
        background.add(JLpwd);
        background.add(JTpwd);
        background.add(JBsure);
        background.add(erweima);
//
        jp.add(background);
        this.add(jp);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

//       //添加按钮组件监听
        Jrb1.addActionListener(e -> {       //单选按钮选择学生时的监听

            JBsure.addActionListener(a->{
                String name = JTname.getText();
//                String pwd = new String(JTpwd.getPassword());
                String pwd = String.valueOf(JTpwd.getPassword());
                //判断验证学生登录信息，
                if("".equals(name)) {
                    //弹出消息对话框
                    JOptionPane.showMessageDialog(null,"账号不能为空","警告⚠",JOptionPane.ERROR_MESSAGE);
                }
                if("".equals(pwd)) {
                    //弹出消息对话框
                    JOptionPane.showMessageDialog(null,"密码不能为空","警告⚠",JOptionPane.ERROR_MESSAGE);
                }
                try{
                    new My_Connection(); //连接数据库
                    Connection con = My_Connection.getConnection();
                    Statement stmt=con.createStatement();   //statement声明
                    String sql = "select * from s where SNO = '" + name + "' and PSWD = '" + pwd + "'"; //SQL选择查询语句以该账号密码为条件查询该表
                    ResultSet rs=stmt.executeQuery(sql);    //执行查询  ResultSet对象存放操作结果，一次只能看到一行数据

                    if (rs.next()) {
                        this.dispose();
                        new JStudent();
                    }
                    else {
                        //弹出消息对话框
                        JOptionPane.showMessageDialog(null,"账号或者密码错误","警告⚠",JOptionPane.ERROR_MESSAGE);
                        JTpwd.requestFocus();
                    }
                }catch(Exception e1){
                    e1.printStackTrace();
                }
//                if (name.equals("123") && pwd.equals("456")){
//                    this.dispose();  //关闭当前的窗口
//
//                    //调用学生页面的显示窗口
//                    new JStudent();
//                }
//                else {
//                    //弹出消息对话框
//                    JOptionPane.showMessageDialog(null,"账号或者密码错误","警告⚠",JOptionPane.ERROR_MESSAGE);
//                }
            });
        });

        Jrb2.addActionListener(e -> {       //单选按钮选择教师时的监听

            JBsure.addActionListener(a->{
                String name = JTname.getText();
//                String pwd = new String(JTpwd.getPassword());
                String pwd = String.valueOf(JTpwd.getPassword());
                //判断验证学生登录信息，
                if("".equals(name)) {
                    //弹出消息对话框
                    JOptionPane.showMessageDialog(null,"账号不能为空","警告⚠",JOptionPane.ERROR_MESSAGE);
                }
                if("".equals(pwd)) {
                    //弹出消息对话框
                    JOptionPane.showMessageDialog(null,"密码不能为空","警告⚠",JOptionPane.ERROR_MESSAGE);
                }
                try{
                    new My_Connection(); //连接数据库
                    Connection con = My_Connection.getConnection();
                    Statement stmt=con.createStatement();   //statement声明
                    String sql = "select * from t where TNO = '" + name + "' and PSWD = '" + pwd + "'"; //SQL选择查询语句以该账号密码为条件查询该表
                    ResultSet rs=stmt.executeQuery(sql);    //执行查询

                    if (rs.next()) {
                        this.dispose();
                        new JTeacher();
                    }
                    else {
                        //弹出消息对话框
                        JOptionPane.showMessageDialog(null,"账号或者密码错误","警告⚠",JOptionPane.ERROR_MESSAGE);
                        JTpwd.requestFocus();
                    }
                }catch(Exception e1){
                    e1.printStackTrace();
                }

            });
        });

        Jrb3.addActionListener(e -> {       //单选按钮选择管理员时的监听

            JBsure.addActionListener(a->{
                String name = JTname.getText();
//                String pwd = new String(JTpwd.getPassword());
                String pwd = String.valueOf(JTpwd.getPassword());
                //判断验证学生登录信息，
                if("".equals(name)) {
                    //弹出消息对话框
                    JOptionPane.showMessageDialog(null,"账号不能为空","警告⚠",JOptionPane.ERROR_MESSAGE);
                }
                if("".equals(pwd)) {
                    //弹出消息对话框
                    JOptionPane.showMessageDialog(null,"密码不能为空","警告⚠",JOptionPane.ERROR_MESSAGE);
                }
                try{
                    new My_Connection(); //连接数据库
                    Connection con = My_Connection.getConnection();
                    Statement stmt=con.createStatement();   //statement声明
                    String sql = "select * from m where MNO = '" + name + "' and PSWD = '" + pwd + "'"; //SQL选择查询语句以该账号密码为条件查询该表
                    ResultSet rs=stmt.executeQuery(sql);    //执行查询

                    if (rs.next()) {
                        this.dispose();
                        new JManager();
                    }
                    else {
                        //弹出消息对话框
                        JOptionPane.showMessageDialog(null,"账号或者密码错误","警告⚠",JOptionPane.ERROR_MESSAGE);
                        JTpwd.requestFocus();
                    }
                }catch(Exception e1){
                    e1.printStackTrace();
                }

            });
        });

    }

    public static void main(String[] args) {
        new Login();

    }
}

