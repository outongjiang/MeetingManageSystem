package Test;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import dao.JDBC2;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBC;
import javax.sql.CommonDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class DruidDemo {
    //导入jar包
    public static void main(String[] args) throws Exception {
        JdbcTemplate template=new JdbcTemplate(JDBC2.getDataSource());
        List<Map<String, Object>> lm =template.queryForList("select phone,email from employee where email=? and phone=?","322@qq.com","18023040732");
          for(Map<String, Object> m:lm){
              System.out.println(m);
          }
//        Connection c =JDBC2.getConnection();
//        PreparedStatement p=c.prepareStatement("select *from employee");
//        ResultSet rs =p.executeQuery();
//        while(rs.next()){
//            System.out.println(rs.getString(1));
//        }
    }
}