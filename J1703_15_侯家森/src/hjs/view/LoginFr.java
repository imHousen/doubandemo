package hjs.view;

import hjs.dao.UserDao;
import hjs.model.Userinfo;
import hjs.util.DBUtil;
import hjs.util.StrUtil;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;








import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Color;

public class LoginFr extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField pwdField;
	public static Userinfo dbUserinfo;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFr frame = new LoginFr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFr() {
		setTitle("\u6C34\u679C\u4FE1\u606F\u7BA1\u7406\u5668");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel DLlab = new JLabel("\u767B\u9646\u9875\u9762");
		DLlab.setFont(new Font("仿宋", Font.PLAIN, 25));
		DLlab.setBounds(160, 39, 108, 51);
		panel.add(DLlab);
		
		JLabel YHlab = new JLabel("\u7528\u6237:");
		YHlab.setIcon(null);
		YHlab.setFont(new Font("宋体", Font.PLAIN, 14));
		YHlab.setBounds(61, 89, 63, 29);
		panel.add(YHlab);
		
		JLabel MMlab = new JLabel("\u5BC6\u7801:");
		MMlab.setIcon(null);
		MMlab.setFont(new Font("宋体", Font.PLAIN, 14));
		MMlab.setBounds(61, 128, 63, 18);
		panel.add(MMlab);
		
		JButton DLbtn = new JButton("\u767B\u9646");
		DLbtn.setIcon(null);
		DLbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		           login(arg0);
		   
			}
		});
		DLbtn.setBounds(37, 269, 100, 40);
		panel.add(DLbtn);
		
		JButton ZCbtn = new JButton("\u6CE8\u518C");
		ZCbtn.setIcon(null);
		ZCbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				register(arg0);
			}
		});
		ZCbtn.setBounds(160, 269, 100, 40);
		panel.add(ZCbtn);
		
		JButton CZbtn = new JButton("\u91CD\u7F6E");
		CZbtn.setIcon(null);
		CZbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset(arg0);
			}
		});
		CZbtn.setBounds(286, 269, 100, 40);
		panel.add(CZbtn);
		
		txtUser = new JTextField();
		txtUser.setBounds(134, 93, 164, 21);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		pwdField = new JPasswordField();
		pwdField.setEchoChar('*');
		pwdField.setBounds(134, 127, 164, 21);
		panel.add(pwdField);
		
		JLabel lb1 = new JLabel("");
		lb1.setToolTipText("");
		lb1.setBounds(286, 89, 54, 15);
		panel.add(lb1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(286, 140, 54, 15);
		panel.add(lblNewLabel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u6C34\u679C\u4FE1\u606F\u7BA1\u7406\u5668");
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setFont(new Font("仿宋", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(90, 13, 296, 51);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u90AE\u7BB1:");
		label.setIcon(null);
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(61, 164, 63, 15);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(134, 161, 164, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JCheckBox checkBox = new JCheckBox("\u8BB0\u4F4F\u5BC6\u7801");
		checkBox.setBounds(61, 205, 78, 23);
		panel.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("\u4FEE\u6539\u5BC6\u7801");
		checkBox_1.setBounds(165, 205, 78, 23);
		panel.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("\u81EA\u52A8\u767B\u5F55");
		checkBox_2.setBounds(271, 205, 78, 23);
		panel.add(checkBox_2);
		setLocationRelativeTo(null);
		
	}
	//注册
		protected void register(ActionEvent e){
			dispose();
			try {
				new RegisterFr().setVisible(true);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		//重置
		protected void reset(ActionEvent e){
			txtUser.setText("");
			pwdField.setText("");
			textField.setText("");
		}
		//登录到主窗体
		protected void login(ActionEvent e){
			String userName=txtUser.getText();
			String password=new String(pwdField.getPassword());
			if(StrUtil.isEmpty(userName)){
				//弹出消息框提示用户名不能为空
				JOptionPane.showMessageDialog(null, "用户名不能为空");
				return;
			}
			if(StrUtil.isEmpty(password)){
				//弹出消息框提示密码不能为空
				JOptionPane.showMessageDialog(null, "密码不能为空");
				return;
			}
			Userinfo userinfo = new Userinfo(userName,password);
			Connection conn=null;
			try {
				conn=DBUtil.getConn();
				dbUserinfo=UserDao.login(conn,userinfo);
				if(dbUserinfo!=null){
					dispose();
					new FruitMainFr().setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "用户名不存在或密码错误！");
				}
			} catch (ClassNotFoundException e1) {
					System.out.println("加载驱动失败");
					e1.printStackTrace();
			}catch (SQLException e1) {
				System.out.println("数据库连接失败");
				e1.printStackTrace();
				// TODO: handle exception
			}
		}
	}

	
		
		

