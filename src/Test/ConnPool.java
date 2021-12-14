package Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnPool {
    public static void main(String[] args) {
        DataSource ds=new ComboPooledDataSource();
        try {
            for(int i=0;i<=5;i++){
                Connection conn =ds.getConnection();
                if(i==2)
                conn.close();
                System.out.println(ds);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
