package 学生选课;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class My_Connection {
    public static Connection getConnection() {
        String driver = "com.mysql.jdbc.Driver";//使用Jar包驱动
        String url = "jdbc:mysql://localhost:3306/design?characterEncoding=UTF-8";//链接数据库端口，数据库名
        String username = "root";//数据库用户名
        String password = "123456";//数据库密码
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("数据库已连接");
        } catch (ClassNotFoundException e) {//异常捕获
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] args) {
        My_Connection.getConnection();
    }
}

//public class My_Connection {
//    public static Connection getConnection() {
//        String driver = "com.mysql.cj.jdbc.Driver";//使用Jar包驱动
//        String url = "jdbc:mysql://localhost:3306/学生选课?serverTimezone=UTC";//链接数据库端口，数据库名
//        String username = "root";//数据库用户名
//        String password = "root";//数据库密码
//        Connection conn = null;
//        try {
//            Class.forName(driver); //classLoader,加载对应驱动
//            conn = (Connection) DriverManager.getConnection(url, username, password);
//            System.out.println("连接成功");
//        } catch (ClassNotFoundException e) {//异常捕获
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
//
//    public static void main(String[] args) {
//        My_Connection.getConnection();
//    }
//}



