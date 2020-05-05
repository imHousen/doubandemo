package hjs.dao;

import hjs.model.Fruitltem;
import hjs.model.Userinfo;
import hjs.util.DBUtil;
import hjs.view.FruitInterfr;
import hjs.view.LoginFr;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import hjs.*;

public class FruitDao {
	static Connection conn = null;
	static Statement stmt = null;
	static java.sql.ResultSet rs = null;
	
	public static Vector<Vector<String>> getAllfruitInfo() throws ClassNotFoundException {
		Vector<Vector<String>> allfruit = new Vector<Vector<String>>();
		try {
			conn = DBUtil.getConn();
			if (conn == null) {
				return null;
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM fruitm;");
			while (rs.next()) {
				Vector<String> in = new Vector<String>();
				in.add(rs.getString("number"));
				in.add(rs.getString("unitPrice"));
				in.add(rs.getString("remarks"));
				in.add(rs.getString("fruitname"));
				in.add(rs.getString("placeofOrign"));
				allfruit.add(in);
			}
			return allfruit;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void tianjia(Fruitltem item) {		
		try {
			conn = DBUtil.getConn();
			stmt = conn.createStatement();
			stmt.executeUpdate("insert into `fruit`.`fruitm` (`unitPrice`, `remarks`, `fruitname`, `placeofOrign`) values ('"+item.getPlaceofOrigin()+"', '"+item.getRemarks()+"', '"+item.getFruitname()+"', '"+item.getPlaceofOrigin()+"')");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null,"添加成功");

	}
	public static void shanchu(String num){
		try {
			conn = DBUtil.getConn();
			stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM fruitm WHERE number='" + num + "';");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void xiugai(Fruitltem fruitltem,String num)	{
		try {
			conn = DBUtil.getConn();
			stmt = conn.createStatement();
			stmt.executeUpdate(""
					+ "UPDATE `fruit`.`fruitm` "
					+ "SET `unitPrice` = '"+fruitltem.getUnitPrice()+"' ,"
					+ " `remarks` = '"+fruitltem.getRemarks()+"' ,"
					+ " `fruitname` = '"+fruitltem.getFruitname()+"' ,"
					+ " `placeofOrign` = '"+fruitltem.getPlaceofOrigin()+"' "
					+ "WHERE `number` = '"+num+"';");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}JOptionPane.showMessageDialog(null,"修改成功");

	}
}
