package hjs.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;

public class AuthorInfInterFr extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthorInfInterFr frame = new AuthorInfInterFr();
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
	public AuthorInfInterFr() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u4F5C\u8005\u4FE1\u606F");

		setBounds(100, 100, 450, 300);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.CYAN);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u4F5C\u8005:\u4FAF\u5BB6\u68EE");
		label.setBounds(55, 30, 110, 15);
		desktopPane.add(label);
		
		JLabel label_1 = new JLabel("\u5236\u4F5C\u65F6\u95F4:2018-6-01");
		label_1.setBounds(55, 70, 159, 15);
		desktopPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u6307\u5BFC\u8001\u5E08:\u5F20\u4E39\u4E39");
		label_2.setBounds(55, 110, 147, 15);
		desktopPane.add(label_2);

	}
}
