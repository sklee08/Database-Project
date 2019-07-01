
package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AccountDup extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	 public AccountDup() {
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
		
		JButton ok_btn = new JButton("\uC911\uBCF5\uB418\uB294 \uACC4\uC88C\uBC88\uD638\uAC00 \uC788\uC2B5\uB2C8\uB2E4.");
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
