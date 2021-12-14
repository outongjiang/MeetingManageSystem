package dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;


import javax.sql.DataSource;
import java.io.IOException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class JDBC2 {
    private static DataSource ds = null;
    private static PreparedStatement preparedStatement = null;
    static {

        Properties pro = new Properties();
        try {
            pro.load(JDBC2.class.getClassLoader().getResourceAsStream("druid.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }




    //---------------------
    public static ResultSet execStatementQuery(String sql, List<Object> params) {

        try {
            preparedStatement = ds.getConnection().prepareStatement(sql);

        } catch (Exception e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }
        if(params!=null) {
            for (int i = 1; i <= params.size();i++) {
                System.out.println("i:"+i);
                try {
                    preparedStatement.setObject(i,params.get(i-1));
                } catch (SQLException e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }
            }
        }
        try {
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        System.out.println("llllll");
        return null;

    }

    public static int execStatementUpdate(String sql, List<Object> params) {
        try {
            preparedStatement = ds.getConnection().prepareStatement(sql);
        } catch (SQLException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }
        for (int i = 1; i <= params.size();i++) {
            try {
                preparedStatement.setObject(i,params.get(i-1));
            } catch (SQLException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
        }
        int i=0;
        try {
            i= preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return i;
    }
    public final static String md5(String jiami) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = jiami.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
