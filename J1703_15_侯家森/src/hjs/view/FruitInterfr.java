package hjs.view;

import hjs.dao.FruitDao;
import hjs.dao.UserDao;
import hjs.model.Fruitltem;
import hjs.model.Userinfo;
import hjs.util.DBUtil;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.SystemColor;

import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

public class FruitInterfr extends JInternalFrame {
	JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField BHtext;
	private JTextField CDtext;
	private JTextField Fruitnametext;
	private JTextField JGtext;
	private JTable table;
	private JTextField BZtext;
	public static Userinfo dbUserinfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FruitInterfr frame = new FruitInterfr();
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
	public FruitInterfr() {
		getContentPane().setBackground(Color.CYAN);
		setTitle("\u6C34\u679C\u4FE1\u606F\u7BA1\u7406");
		setClosable(true);
		setIconifiable(true);

		setBounds(50, 50, 633, 556);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(224, 255, 255));
		getContentPane().add(desktopPane, BorderLayout.NORTH);

		textField = new JTextField();
		textField.setBounds(143, 40, 291, 24);
		desktopPane.add(textField);
		textField.setColumns(10);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().setLayout(null);

		textField_1 = new JTextField();
		textField_1.setBounds(180, 30, 238, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {
				"\u6309\u4EA7\u5730\u641C\u7D22",
				"\u6309\u5355\u4EF7\u641C\u7D22",
				"\u6309\u6298\u6263\u641C\u7D22" }));
		comboBox.setBounds(53, 30, 112, 21);
		getContentPane().add(comboBox);

		JButton CXbtn = new JButton("\u67E5\u8BE2");
		CXbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getAllTable();
			}
		});
		CXbtn.setBounds(458, 29, 93, 23);
		getContentPane().add(CXbtn);

		JLabel label = new JLabel("\u7F16\u53F7:");
		label.setBounds(27, 298, 54, 15);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("\u4EA7\u5730:");
		label_1.setBounds(27, 328, 54, 15);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\u6C34\u679C\u540D\u79F0:");
		label_2.setBounds(194, 298, 72, 15);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\u5355\u4EF7:");
		label_3.setBounds(194, 328, 72, 15);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel("\u5907\u6CE8:");
		label_4.setBounds(27, 388, 54, 15);
		getContentPane().add(label_4);

		BHtext = new JTextField();
		BHtext.setBounds(66, 295, 106, 21);
		getContentPane().add(BHtext);
		BHtext.setColumns(10);

		CDtext = new JTextField();
		CDtext.setBounds(66, 328, 106, 21);
		getContentPane().add(CDtext);
		CDtext.setColumns(10);

		Fruitnametext = new JTextField();
		Fruitnametext.setColumns(10);
		Fruitnametext.setBounds(258, 298, 93, 21);
		getContentPane().add(Fruitnametext);

		JGtext = new JTextField();
		JGtext.setColumns(10);
		JGtext.setBounds(258, 328, 93, 21);
		getContentPane().add(JGtext);

		JButton CZbtn = new JButton("\u91CD\u7F6E");
		CZbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reset(arg0);
			}
		});
		CZbtn.setBounds(368, 362, 90, 40);
		getContentPane().add(CZbtn);

		JButton TJbtn = new JButton("\u6DFB\u52A0");
		TJbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fruitltem fr = new Fruitltem();
				fr.setFruitname(Fruitnametext.getText());
				fr.setNumber(BHtext.getText());
				fr.setPlaceofOrigin(CDtext.getText());
				fr.setRemarks(BZtext.getText());
				fr.setUnitPrice(JGtext.getText());
				FruitDao.tianjia(fr);
			}
		});
		TJbtn.setBounds(486, 362, 90, 40);
		getContentPane().add(TJbtn);

		JButton SCbtn = new JButton("\u5220\u9664");
		SCbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FruitDao.shanchu(BHtext.getText());
			}
		});
		SCbtn.setBounds(486, 426, 90, 40);
		getContentPane().add(SCbtn);

	    scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 68, 553, 209);
		getContentPane().add(scrollPane);

		JLabel label_5 = new JLabel("\u91C7\u8D2D\u65E5\u671F:");
		label_5.setBounds(27, 360, 73, 15);
		getContentPane().add(label_5);

		JComboBox cb_year = new JComboBox();
		cb_year.setModel(new DefaultComboBoxModel(new String[] { "2018",
				"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010",
				"2009" }));
		cb_year.setBounds(91, 359, 61, 21);
		getContentPane().add(cb_year);

		JLabel lblNewLabel = new JLabel("\u5E74");
		lblNewLabel.setBounds(159, 360, 18, 15);
		getContentPane().add(lblNewLabel);

		JComboBox cb_month = new JComboBox();
		cb_month.setModel(new DefaultComboBoxModel(new String[] { "12", "11",
				"10", "9", "8", "7", "6", "5", "4", "3", "2", "1" }));
		cb_month.setBounds(180, 356, 44, 21);
		getContentPane().add(cb_month);

		JLabel lblNewLabel_1 = new JLabel("\u6708 ");
		lblNewLabel_1.setBounds(236, 360, 30, 15);
		getContentPane().add(lblNewLabel_1);

		JComboBox cb_day = new JComboBox();
		cb_day.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "21"}));
		cb_day.setBounds(268, 357, 42, 21);
		getContentPane().add(cb_day);

		JLabel lblNewLabel_2 = new JLabel("\u65E5");
		lblNewLabel_2.setBounds(314, 360, 54, 15);
		getContentPane().add(lblNewLabel_2);

		BZtext = new JTextField();
		BZtext.setBounds(66, 390, 281, 127);
		getContentPane().add(BZtext);
		BZtext.setColumns(10);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(114, 426, 6, 21);
		getContentPane().add(textPane);

		JButton XGbtn = new JButton("\u4FEE\u6539");
		XGbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fruitltem fr = new Fruitltem();
				fr.setFruitname(Fruitnametext.getText());
				fr.setNumber(BHtext.getText());
				fr.setPlaceofOrigin(CDtext.getText());
				fr.setRemarks(BZtext.getText());
				fr.setUnitPrice(JGtext.getText());
				FruitDao.xiugai(fr, BHtext.getText());
			}
		});
		XGbtn.setBounds(368, 426, 90, 40);
		getContentPane().add(XGbtn);
	}
	
	private void getAllTable() {
		Vector<String> tableName = new Vector<String>();
		tableName = new Vector<String>();
		tableName.add("编号");
		tableName.add("水果名称");
		tableName.add("产地");
		tableName.add("单价");
		tableName.add("备注");
		Vector<Vector<String>> fruit = null;
		try {
			fruit = FruitDao.getAllfruitInfo();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		table = new JTable(fruit, tableName);
		scrollPane.setViewportView(table);
	}

	protected void reset(ActionEvent e) {
		BHtext.setText("");
		Fruitnametext.setText("");
		CDtext.setText("");
		JGtext.setText("");
		BZtext.setText("");

	}

}
