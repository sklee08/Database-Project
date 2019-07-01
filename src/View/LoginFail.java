package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LoginFail extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public LoginFail() {
		init();
	}
	/**
	 * Create the frame.
	 */
	public void init() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 393, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ok_btn = new JButton("로그인 오류 : 회원정보를 다시 확인하시오.");
		ok_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		ok_btn.setBounds(45, 58, 291, 57);
		contentPane.add(ok_btn);
		setVisible(true);
	}

}
