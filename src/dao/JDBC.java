package dao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class JDBC{
	private static Connection connection;
	public static PreparedStatement preparedStatement=null;
	private static String url ="jdbc:mysql://localhost:3306/meeting?useSSL=false&serverTimezone=UTC&Unicode=true&characterEncoding=gbk";
	private static String username="root";
	private static String password="111qqqQQQ";
	 public  static Connection getConnection() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, username, password);
				return connection;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return null;
			}
		}

	
		public static void closeAll() {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

			}
			

		}

		public static ResultSet execStatementQuery(String sql,List<Object> params) {
			
			try {
				preparedStatement = getConnection().prepareStatement(sql);
				
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			if(params!=null) {
				for (int i = 1; i <= params.size();i++) {
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
			return null;
			
		}
		
		public static int execStatementUpdate(String sql, List<Object> params) {
			try {
				preparedStatement = getConnection().prepareStatement(sql);
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



	
	public static void main(String[] args)throws Exception {
		
	
		
		
//		sql="update employee set password =? where username='wangxh'";
//		
//		 pstat=conn.prepareStatement(sql);
//		
//		 pstat.setString(1, JDBCUtil.md5(password));
//		 
//		 pstat.executeUpdate();
		
	

		 
	}

}

