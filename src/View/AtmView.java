package View;

import Model.*;
import Control.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtmView extends JFrame {

	private JPanel contentPane;
	private JTextField account_tf;
	private JPasswordField pwf;
	private JLabel label;
	private JLabel label_1;
	private SyncController sc;
	private DBController dc;
	private GUIController gc;
	private JRadioButton shin_rd;
	private JRadioButton hana_rd;
	private JRadioButton kuk_rd;
	

	/**
	 * Launch the application.
	 */
	public AtmView(){
		init();
	}
	

	/**
	 * Create the frame.
	 */
	public void init (){
		
		sc = new SyncController();
		dc = new DBController();
		gc = new GUIController();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		account_tf = new JTextField();
		account_tf.setBounds(14, 23, 161, 24);
		contentPane.add(account_tf);
		account_tf.setColumns(10);
		
		JButton apply_btn = new JButton("\uC870   \uD68C");
		apply_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account = account_tf.getText();
				String pw = new String(pwf.getPassword());
				String bank = "";
				if(shin_rd.isSelected()){
					// 신한 선택
					bank = "신한";
				}
				else if(hana_rd.isSelected()) {
					bank = "하나";
				}
				else if(kuk_rd.isSelected()) {
					bank = "국민";
				}		
				try {
					int index = sc.isStolen(account);
					if(index == 0) {
						if(sc.login(pw, account, bank)) {
							// 로그인성공
							
							UserInfo user = sc.find(account);
							// gui 창 띄우기
							gc.popAtmViewResult(user.getName(), account, user.getBalance());
						}
						else {
							// 로그인 실패
							gc.popLoginFail();
						}
					}
					else if(index == 1){
						gc.popRobberedAccount();
					}
					else {
						gc.popInvalidAccountNum();
					}
				}catch(Exception e3) {
					
				}
			}
		});
		apply_btn.setBounds(295, 11, 123, 178);
		contentPane.add(apply_btn);
		
		JButton cancel_btn = new JButton("\uCDE8   \uC18C");
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel_btn.setBounds(14, 201, 404, 49);
		contentPane.add(cancel_btn);
		
		pwf = new JPasswordField();
		pwf.setBounds(14, 65, 161, 24);
		contentPane.add(pwf);
		
		label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setBounds(190, 68, 62, 18);
		contentPane.add(label);
		
		label_1 = new JLabel("\uACC4\uC88C\uBC88\uD638");
		label_1.setBounds(190, 26, 62, 18);
		contentPane.add(label_1);
		
		shin_rd = new JRadioButton("\uC2E0\uD55C\uC740\uD589");
		shin_rd.setBounds(14, 101, 139, 27);
		contentPane.add(shin_rd);
		
		hana_rd = new JRadioButton("\uD558\uB098\uC740\uD589");
		hana_rd.setBounds(14, 132, 139, 27);
		contentPane.add(hana_rd);
		
		kuk_rd = new JRadioButton("\uAD6D\uBBFC\uC740\uD589");
		kuk_rd.setBounds(14, 163, 139, 27);
		contentPane.add(kuk_rd);
		
		ButtonGroup bankrad = new ButtonGroup();
		bankrad.add(kuk_rd);
		bankrad.add(hana_rd);
		bankrad.add(shin_rd);
		
		JLabel label_3 = new JLabel("\uC740\uD589\uC120\uD0DD");
		label_3.setBounds(190, 136, 62, 18);
		contentPane.add(label_3);
		setVisible(true);
	}
}
