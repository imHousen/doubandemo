package hjs.view;

import hjs.dao.UserDao;
import hjs.model.Userinfo;
import hjs.util.DBUtil;
import hjs.util.StrUtil;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.security.ProtectionDomain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import org.omg.CORBA.PUBLIC_MEMBER;

public class RegisterFr extends JFrame {

	private JPanel contentPane;
	private JTextField txtuserName;
	private JPasswordField pwdField;
	private JPasswordField pwdField2;
	private JTextField txtemail;
	private JLabel lblpwd2;
	private JLabel lblpwd;
	private JLabel lbluserName;
	private String email;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFr frame = new RegisterFr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public RegisterFr() throws ClassNotFoundException {
		
		setTitle("J1703_15_\u4FAF\u5BB6\u68EE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 410);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6CE8\u518C\u9875\u9762");
		lblNewLabel.setIcon(null);
		lblNewLabel.setFont(new Font("华文行楷", Font.PLAIN, 25));
		lblNewLabel.setBounds(130, 10, 188, 62);
		panel.add(lblNewLabel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("*\u7528\u6237\u540D");
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(84, 88, 63, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" *\u5BC6\u7801");
		lblNewLabel_2.setIcon(null);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(79, 116, 63, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" *\u8BF7\u91CD\u590D\u5BC6\u7801");
		lblNewLabel_3.setIcon(null);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(79, 144, 105, 15);
		panel.add(lblNewLabel_3);
		
		txtuserName = new JTextField();
		txtuserName.setBounds(188, 80, 127, 21);
		panel.add(txtuserName);
		txtuserName.setColumns(10);
		
		pwdField = new JPasswordField();
		pwdField.setEchoChar('*');
		pwdField.setBounds(188, 110, 127, 21);
		panel.add(pwdField);
		
		pwdField2 = new JPasswordField();
		pwdField2.setEchoChar('*');
		pwdField2.setBounds(188, 140, 127, 21);
		panel.add(pwdField2);
		
		JButton WCbtn = new JButton("\u5B8C\u6210");
		WCbtn.setBackground(SystemColor.activeCaption);
		WCbtn.setIcon(null);
		WCbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset(arg0);
			}
		});
		JButton FHbtn = new JButton("\u8FD4\u56DE");
		FHbtn.setBackground(SystemColor.activeCaption);
		FHbtn.setIcon(null);
		FHbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginFr loginFr = new  LoginFr();
				dispose();
				loginFr.setVisible(true);
			}
		});
		FHbtn.setBounds(150, 250, 105, 40);
		panel.add(FHbtn);
		WCbtn.setBounds(29, 250, 105, 40);
		panel.add(WCbtn);
		
		JButton CZbtn = new JButton("\u91CD\u7F6E");
		CZbtn.setBackground(SystemColor.activeCaption);
		CZbtn.setIcon(null);
		CZbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cz(arg0);
			}
		});
		CZbtn.setBounds(265, 250, 105, 40);
		panel.add(CZbtn);
		
		JLabel label = new JLabel(" \u90AE\u7BB1");
		label.setIcon(null);
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(79, 172, 68, 15);
		panel.add(label);
		
		txtemail = new JTextField();
		txtemail.setBounds(188, 170, 127, 21);
		panel.add(txtemail);
		txtemail.setColumns(10);
		
		lbluserName = new JLabel("");
		lbluserName.setForeground(Color.RED);
		lbluserName.setBounds(330, 79, 72, 18);
		panel.add(lbluserName);
		
		lblpwd = new JLabel("");
		lblpwd.setForeground(Color.RED);
		lblpwd.setBounds(330, 112, 72, 18);
		panel.add(lblpwd);
		
		lblpwd2 = new JLabel("");
		lblpwd2.setForeground(Color.RED);
		lblpwd2.setBounds(325, 139, 72, 18);
		panel.add(lblpwd2);
		setResizable(false);
		
		setLocationRelativeTo(null);
	}
	protected void cz(ActionEvent e){
		txtuserName.setText("");
		pwdField.setText("");
		pwdField2.setText("");
		txtemail.setText("");
	}
		protected void reset(ActionEvent e) {
			  //获取文本框中输入的信息
			  String userName=txtuserName.getText();
			  String password=new String(pwdField.getPassword());
			  String password2=new String(pwdField2.getPassword());
			  String email=txtemail.getText();
			  //判断用户名和密码是否为空
			  if(StrUtil.isEmpty(userName)){
			  lbluserName.setText("此项必填! ");
			  return;
			  }
			  if(StrUtil.isEmpty(password)){
			  lblpwd.setText("此项必填! ");
			  return;
			  }
			  if(StrUtil.isEmpty(password2)){
			  lblpwd2.setText("此项必填! ");
			  return;
			  }
			  if (password.trim().equals(password2.trim())==false) {
				  JOptionPane.showMessageDialog(null, "两次输入密码必须一致");
				  return;
			}
			  if (password.length()<6) {
				  JOptionPane.showMessageDialog(null, "密码长不能少于6位");
			}else {
				
				Userinfo  userinfo=new Userinfo(userName,password,email);
					Connection conn=null;
					try {
						conn=DBUtil.getConn();
						if (UserDao.nameselect(conn, userName)) {
							JOptionPane.showMessageDialog(null,"用户名已存在！");
							txtuserName.setText("");
						}else {
							int add=UserDao.addUser(conn,userinfo);
									if (add==1) {
										JOptionPane.showMessageDialog(null,"注册成功");
									
							}
						}
					} catch (ClassNotFoundException e1) {
						System.out.println("加载驱动失败");
						e1.printStackTrace();
				}catch (SQLException e1) {
					System.out.println("数据库连接失败");
					e1.printStackTrace();
					}
				}
			  

		}
			}
	
		
	


