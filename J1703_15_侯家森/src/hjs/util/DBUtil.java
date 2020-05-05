package hjs.util;
import java.sql.*;

public class DBUtil {
	private static String jdbcName="com.mysql.jdbc.Driver";
	private static String dbUrl="jdbc:mysql://localhost:3306/fruit";
	private static String dbusername="root";
	private static String dbpassword="123456";
	//获取链接对象
	public static Connection getConn() throws ClassNotFoundException,
	SQLException{
		Class.forName(jdbcName);
		Connection conn = DriverManager.getConnection(dbUrl,dbusername,dbpassword);
		return conn;
	}
	//释放资源
	public static void release(Statement st,Connection conn) throws SQLException{
		if(st != null){
			st.close();
		}
		if(conn != null){
			conn.close();
		}
	}
	public void release(ResultSet rs,Statement st,Connection conn) throws SQLException{
	if(rs != null){
		rs.close();
	}
	release(st, conn);
	}
}

