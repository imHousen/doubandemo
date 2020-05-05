package hjs.dao;

import hjs.model.Userinfo;
import hjs.util.DBUtil;

import java.sql.*;

import org.omg.CORBA.PUBLIC_MEMBER;

public class UserDao {

	public static int addUser(Connection conn,Userinfo userinfo)
			throws SQLException {
		 String sql = "insert into userinfo values(null,?,?,?)";
		 PreparedStatement prestmt = (PreparedStatement) conn
		 .prepareStatement(sql);
		 prestmt.setString(1, userinfo.getUsername());
		 prestmt.setString(2, userinfo.getPassword());
		 prestmt.setString(3, userinfo.getTxtemail());
		 return prestmt.executeUpdate();
		}

	public static Userinfo login(Connection conn, Userinfo userinfo)
			throws SQLException {
		Userinfo rsUserinfo = null;
		String sql = "select * from userinfo where username=? and Password=?";
		PreparedStatement prestmt = (PreparedStatement) conn
				.prepareStatement(sql);
		prestmt.setString(1, userinfo.getUserName());
		prestmt.setString(2, userinfo.getPassword());
		ResultSet rs = prestmt.executeQuery();
		if (rs.next()) {
			rsUserinfo = new Userinfo();
			rsUserinfo.setUsername(rs.getString("username"));
			rsUserinfo.setPassword(rs.getString("Password"));
		}
		return rsUserinfo;
	}

	public static boolean nameselect(Connection conn, String name)
			throws SQLException {
		Userinfo rsUserinfo = null;
		String sql = "select * from userinfo where userName=?";
		PreparedStatement prestmt = (PreparedStatement) conn
				.prepareStatement(sql);
		prestmt.setString(1, name);
		ResultSet rs = prestmt.executeQuery();
		if (rs.next()) {
			return true;
		} else {
			return false;
		}
	}

	public static int updatepwd(Connection conn, Userinfo userinfo)
			throws SQLException {
		String sql = "update userinfo set password=? where userName=?";
		PreparedStatement prestmt = (PreparedStatement) conn
				.prepareStatement(sql);
		prestmt.setString(1, userinfo.getPassword());
		prestmt.setString(2, userinfo.getUserName());
		return prestmt.executeUpdate();
	}
}
