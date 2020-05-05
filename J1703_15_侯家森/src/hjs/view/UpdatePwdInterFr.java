package hjs.view;

import hjs.dao.UserDao;
import hjs.model.Userinfo;
import hjs.util.DBUtil;
import hjs.util.StrUtil;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JPasswordField;

import java.awt.SystemColor;

public class UpdatePwdInterFr extends JInternalFrame {
	private JLabel Labelpwd;
	private Object passwordField_now;
	private JLabel Labelpwdnew;
	private JLabel Labelpwdne;
	private JPasswordField passwordField;
	private JPasswordField passwordFiled_new;
	private JPasswordField passwordFiled_new2;
	private JLabel lblpasswordnow;
	private JLabel Lblpwdnew;
	private JLabel Lblpwdnew2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePwdInterFr frame = new UpdatePwdInterFr();
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
	public UpdatePwdInterFr() {
		getContentPane().setBackground(new Color(144, 238, 144));
		setTitle("修改密码");
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 450, 300);
		
		JPanel lblpasswordnew = new JPanel();
		lblpasswordnew.setBackground(Color.CYAN);
		getContentPane().add(lblpasswordnew, BorderLayout.CENTER);
		lblpasswordnew.setLayout(null);
		
		Labelpwd = new JLabel("\u8BF7\u8F93\u5165\u539F\u59CB\u5BC6\u7801\uFF1A");
		Labelpwd.setBounds(74, 43, 120, 18);
		lblpasswordnew.add(Labelpwd);
		
		Labelpwdne = new JLabel("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801 \uFF1A");
		Labelpwdne.setBounds(74, 98, 113, 18);
		lblpasswordnew.add(Labelpwdne);		
		Labelpwdnew = new JLabel("\u91CD\u65B0\u8F93\u5165\u65B0\u5BC6\u7801\uFF1A");
		Labelpwdnew.setBounds(74, 158, 120, 18);
		lblpasswordnew.add(Labelpwdnew);		
		JButton updatePwd = new JButton("\u786E\u8BA4");
		updatePwd.setIcon(null);
		updatePwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePwd(e);
			}
		});

		updatePwd.setBounds(54, 210, 120, 40);
		lblpasswordnew.add(updatePwd);		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.setIcon(null);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LoginFr LL=new LoginFr();
				LL.setVisible(true);
				dispose();
			}
		});
		button_1.setBounds(241, 210, 120, 40);
		lblpasswordnew.add(button_1);	
		
		passwordField = new JPasswordField();
		passwordField.setBounds(204, 41, 108, 24);
		lblpasswordnew.add(passwordField);
		
		passwordFiled_new = new JPasswordField();
		passwordFiled_new.setBounds(204, 96, 108, 24);
		lblpasswordnew.add(passwordFiled_new);
		
		passwordFiled_new2 = new JPasswordField();
		passwordFiled_new2.setBounds(204, 156, 108, 24);
		lblpasswordnew.add(passwordFiled_new2);
		
		lblpasswordnow = new JLabel("");
		lblpasswordnow.setForeground(Color.RED);
		lblpasswordnow.setBounds(327, 41, 72, 18);
		lblpasswordnew.add(lblpasswordnow);
		
		Lblpwdnew = new JLabel("");
		Lblpwdnew.setForeground(Color.RED);
		Lblpwdnew.setBounds(327, 99, 72, 18);
		lblpasswordnew.add(Lblpwdnew);
		
		Lblpwdnew2 = new JLabel("");
		Lblpwdnew2.setForeground(Color.RED);
		Lblpwdnew2.setBounds(327, 159, 72, 18);
		lblpasswordnew.add(Lblpwdnew2);
	}
		//修改密码
        protected void updatePwd(ActionEvent e1)	{
        	String pwdnow=new String(passwordField.getPassword());
        	String pwdnew=new String(passwordFiled_new.getPassword());
        	String pwdnew2=new String(passwordFiled_new.getPassword());
        	//判断原始密码是否正确 避免文本框输入内容为空
        	if (!pwdnow.equals(LoginFr.dbUserinfo.getPassword())) {
					JOptionPane.showMessageDialog(null,"原始密码输入不正确");
					passwordField.setText("");
					return;
			}
        	//修改密码长度不少于6位
        	if (pwdnew.length()<6) {
        		JOptionPane.showMessageDialog(null, "密码长度不能少于6位");
				passwordFiled_new.setText("");
				return;
			}
        	//判断两次新密码是否一样
        	if (!pwdnew.equals(pwdnew2)) {
					JOptionPane.showMessageDialog(null, "两次输入密码不一致");
					passwordFiled_new.setText("");
					passwordFiled_new2.setText("");
					return;
			}
        	if(StrUtil.isEmpty(pwdnew)){
        		lblpasswordnow.setText("此项必填! ");
        		  return;
        		  }
        		  if(StrUtil.isEmpty(pwdnew2)){
        			  Lblpwdnew.setText("此项必填! ");
        		  return;
        		  }
        		  if(StrUtil.isEmpty(pwdnow)){
        			  Lblpwdnew2.setText("此项必填! ");
        		  return;
        		  }
        		  if (StrUtil.isNotEmpty(pwdnew)) {
					
				        Connection conn;
        				Userinfo  userinfo=new Userinfo(LoginFr.dbUserinfo.getUserName(),pwdnew);
        				try {
        					conn=DBUtil.getConn();
        				 if ((UserDao.updatepwd(conn, userinfo))==1) {
							JOptionPane.showMessageDialog(null,"修改成功,请重新登录!");
							dispose();
							(new LoginFr()).setVisible(true);
						}
        				} catch (ClassNotFoundException e2) {
        					System.out.println("加载驱动失败");
        					e2.printStackTrace();
        			}catch (SQLException e2) {
        				System.out.println("数据库连接失败");
        				e2.printStackTrace();
        				}
        			}
        }
}
