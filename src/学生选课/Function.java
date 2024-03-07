package 学生选课;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

class Fuction {
    //     static Login l = new Login();
//    //可选课程
    public static void choosable_courese() {
        String name = Login.JTname.getText();
        JTable table;
        JFrame jf = new JFrame();
        jf.setTitle("可选课程");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的宽=1536
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高=864
        jf.setBounds((width - 600) / 2, (height - 300) / 2+100 ,400,300);

        Vector titlename1 = new Vector();//{"学号","姓名","性别","年龄","专业"};
        titlename1.add("题号");
        titlename1.add("题目");
        titlename1.add("教师名");

        Vector rowdata1 = new Vector();  //数据
        ResultSet rs = null;
        try {
            new My_Connection(); //连接数据库
            Connection con = My_Connection.getConnection();
            Statement stmt = con.createStatement();   //statement声明
            String sql = "select C.CNO,CNAME,TNAME from c,sc where C.CNO=sc.CNO and sc.CNO not in (select CNO from sc where SNO='" + name + "')"; //SQL选择查询语句以该账号为条件查询该表
            rs = stmt.executeQuery(sql);

        } catch (Exception e1) {
            System.out.println(e1);
            System.out.println("查询可选课程出错");
        }
        try{
            while (rs.next()) {
                Vector hang1 = new Vector();
                hang1.add(rs.getString("CNO"));
                hang1.add(rs.getString("CNAME"));
                hang1.add(rs.getString("TNAME"));

                rowdata1.add(hang1);
            }
        }catch(Exception e1){
            System.out.println("添加错误");
        }

        table = new JTable(rowdata1, titlename1);
        table.setEnabled(false);   //表格不能编辑
        JScrollPane sroll1 = new JScrollPane(table);
        jf.add(sroll1);
        jf.setVisible(true);
    }
    //已选课程
    public static void choosed_courese() {
        String name = Login.JTname.getText();
        JTable table;
        JFrame jf = new JFrame();
        jf.setTitle("已选课程");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的宽=1536
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高=864
        jf.setBounds((width - 600) / 2, (height - 300) / 2+100 ,400,300);

        Vector titlename1 = new Vector();//{"学号","姓名","性别","年龄","专业"};
        titlename1.add("题号");
        titlename1.add("题目");

        Vector rowdata1 = new Vector();  //数据
        ResultSet rs = null;
        try {
            new My_Connection(); //连接数据库
            Connection con = My_Connection.getConnection();
            Statement stmt = con.createStatement();   //statement声明
            String sql = "select C.CNO,CNAME from sc,c where C.CNO=sc.CNO and SNO='" + name + "'"; //SQL选择查询语句以该账号为条件查询该表
            rs = stmt.executeQuery(sql);

        } catch (Exception e1) {
            System.out.println(e1);
            System.out.println("查询已选课程出错");
        }
        try{
            while (rs.next()) {
                Vector hang1 = new Vector();
                hang1.add(rs.getString("CNO"));
                hang1.add(rs.getString("CNAME"));
                rowdata1.add(hang1);
            }
        }catch(Exception e1){
            System.out.println("添加错误");
        }
        table = new JTable(rowdata1, titlename1);
        table.setEnabled(false);   //表格不能编辑
        JScrollPane sroll1 = new JScrollPane(table);
        jf.add(sroll1);
        jf.setVisible(true);
    }

    public static void teach_infor() {
        JTable table;
        JFrame jf = new JFrame();
        jf.setTitle("老师信息");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的宽=1536
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高=864
        jf.setBounds((width - 600) / 2, (height - 300) / 2+100 ,500,300);

        Vector titlename1 = new Vector();//{"学号","姓名","性别","年龄","专业"};
        titlename1.add("教工号");
        titlename1.add("教师名");
        titlename1.add("性别");
        titlename1.add("职称");
        titlename1.add("电话");
        titlename1.add("Email");

        Vector rowdata1 = new Vector();  //数据
        ResultSet rs = null;
        try {
            new My_Connection(); //连接数据库
            Connection con = My_Connection.getConnection();
            Statement stmt = con.createStatement();   //statement声明
            String sql = "select TNO,TNAME,SEX,TITLE,PHONE,EMAIL from t "; //SQL选择查询语句以该账号为条件查询该表
            rs = stmt.executeQuery(sql);

        } catch (Exception e1) {
            System.out.println(e1);
            System.out.println("查询教师信息出错");
        }
        try{
            while (rs.next()) {
                Vector hang1 = new Vector();
                hang1.add(rs.getString("TNO"));
                hang1.add(rs.getString("TNAME"));
                hang1.add(rs.getString("SEX"));
                hang1.add(rs.getString("TITLE"));
                hang1.add(rs.getString("PHONE"));
                hang1.add(rs.getString("EMAIL"));
                rowdata1.add(hang1);
            }
        }catch(Exception e1){
            System.out.println("添加错误");
        }
        table = new JTable(rowdata1, titlename1);
        table.setEnabled(false);   //表格不能编辑
        JScrollPane sroll1 = new JScrollPane(table);
        jf.add(sroll1);
        jf.setVisible(true);
    }

    public static void courese_infor() {
        JTable table;
        JFrame jf = new JFrame();
        jf.setTitle("课程信息");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;//获取屏幕的宽=1536
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;//获取屏幕的高=864
        jf.setBounds((width - 600) / 2, (height - 300) / 2+100 ,500,300);

        Vector titlename1 = new Vector();//{"学号","姓名","性别","年龄","专业"};
        titlename1.add("题号");
        titlename1.add("题目");
        titlename1.add("学分");
        titlename1.add("专业");
        titlename1.add("教师");
        titlename1.add("教工号");

        Vector rowdata1 = new Vector();  //数据
        ResultSet rs = null;
        try {
            new My_Connection(); //连接数据库
            Connection con = My_Connection.getConnection();
            Statement stmt = con.createStatement();   //statement声明
            String sql = "select CNO,CNAME,CREDI,CDEPT,TNAME,TNO from c "; //SQL选择查询语句以该账号为条件查询该表
            rs = stmt.executeQuery(sql);

        } catch (Exception e1) {
            System.out.println(e1);
            System.out.println("查询课程信息出错");
        }
        try{
            while (rs.next()) {
                Vector hang1 = new Vector();
                hang1.add(rs.getString("CNO"));
                hang1.add(rs.getString("CNAME"));
                hang1.add(rs.getString("CREDI"));
                hang1.add(rs.getString("CDEPT"));
                hang1.add(rs.getString("TNAME"));
                hang1.add(rs.getString("TNO"));
                rowdata1.add(hang1);
            }
        }catch(Exception e1){
            System.out.println("添加错误");
        }
        table = new JTable(rowdata1, titlename1);
        table.setEnabled(false);   //表格不能编辑
        JScrollPane sroll1 = new JScrollPane(table);
        jf.add(sroll1);
        jf.setVisible(true);
    }



    public static void main(String[] args) {
        Fuction.courese_infor();
    }
}

