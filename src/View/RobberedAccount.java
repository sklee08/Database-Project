package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RobberedAccount extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public RobberedAccount() {
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
		
		JButton ok_btn = new JButton("\uBD84\uC2E4\uC2E0\uACE0 \uCC98\uB9AC\uB41C \uACC4\uC88C\uC785\uB2C8\uB2E4.");
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
