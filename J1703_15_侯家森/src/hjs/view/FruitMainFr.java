package hjs.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDesktopPane;

import java.awt.Component;

import javax.swing.JInternalFrame;
import java.awt.SystemColor;



public class FruitMainFr extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FruitMainFr frame = new FruitMainFr();
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
	public FruitMainFr() {
		setTitle(" J1703_15_\u4FAF\u5BB6\u68EE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 224));
		setJMenuBar(menuBar);
		
		JMenu menuYh = new JMenu("\u7528\u6237\u7BA1\u7406");
		menuYh.setIcon(null);

		menuBar.add(menuYh);
		
		JMenuItem menuUdPw = new JMenuItem("修改密码");
		menuUdPw.setIcon(null);
		menuUdPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdatePwdInterFr upf=new UpdatePwdInterFr();
				upf.setVisible(true);
				desktopPane.add(upf);
			}
		});
		
			

		menuYh.add(menuUdPw);
		
		JMenu menu_1 = new JMenu("\u6C34\u679C\u7BA1\u7406");
		menu_1.setIcon(null);

		menuBar.add(menu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("\u6C34\u679C\u4FE1\u606F\u7BA1\u7406\u5668");
		menuItem_1.setIcon(null);
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FruitInterfr fif=new FruitInterfr();
				fif.setVisible(true);
				desktopPane.add(fif);
			}
		});

		menu_1.add(menuItem_1);
		
		JMenu menu_2 = new JMenu("\u5173\u4E8E");
		menu_2.setIcon(null);

		menuBar.add(menu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("\u4F5C\u8005\u4FE1\u606F");
		menuItem_2.setIcon(null);
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AuthorInfInterFr aifFr=new AuthorInfInterFr();
				aifFr.setVisible(true);
				desktopPane.add(aifFr);
			}
		});

		menu_2.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u9000\u51FA");
		menuItem_3.setIcon(null);
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		menu_2.add(menuItem_3);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.CYAN);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel label = new JLabel("当前用户："+LoginFr.dbUserinfo.getUserName());
		label.setFont(new Font("黑体", Font.PLAIN, 18));
		label.setBounds(10, 634, 254, 28);
		contentPane.add(label,BorderLayout.SOUTH);
     	setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		setLocationRelativeTo(null);
	}
}

