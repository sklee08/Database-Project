
package View;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.DBController;
import Control.GUIController;
import Control.SyncController;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AtmDrawl extends JFrame {

	private JPanel contentPane;
	private JTextField account_tf;
	private JTextField money_tf;
	private JPasswordField pwf;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JRadioButton shin_rd;
	private JRadioButton hana_rd;
	private JRadioButton kuk_rd;
	private SyncController sc;
	private DBController dc;
	private GUIController gc;

	/**
	 * Launch the application.
	 */
	public AtmDrawl() {
		init();
	}
	/**
	 * Create the frame.
	 */
	public void init () {
		sc = new SyncController();
		dc = new DBController();
		gc = new GUIController();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		account_tf = new JTextField();
		account_tf.setBounds(14, 23, 161, 24);
		contentPane.add(account_tf);
		account_tf.setColumns(10);
		
		JButton apply_btn = new JButton("\uCD9C    \uAE08");
		apply_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String accountNum = account_tf.getText();
				String pw = new String(pwf.getPassword());
				String money = money_tf.getText();
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
				System.out.println("bank is "+bank);
				try {
					int index = sc.isStolen(accountNum);
					if(index == 0) {
						// true 같은게 없음// 도난 계좌 아님
						if(sc.login(pw, accountNum, bank)) {
							//로그인 성공
							
							int imoney = Integer.parseInt(money);
							if(sc.calculate(accountNum, bank, -imoney)) {
								//입금 성공
								gc.popWorkSuccess();
								
							}
							else {
								// 입금 실패
								//잔액 부족
								gc.popLackBalance();
							}
						}
						else {
							// 로그인 실패
							gc.popInvalidAccountNum();
						}
					}
					else if(index == 1){
						//false //도난 계좌임
						gc.popRobberedAccount();
					}
					else {
						gc.popInvalidAccountNum();
					}
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		apply_btn.setBounds(295, 11, 123, 206);
		contentPane.add(apply_btn);
		
		JButton cancel_btn = new JButton("\uCDE8   \uC18C");
		cancel_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel_btn.setBounds(14, 229, 404, 49);
		contentPane.add(cancel_btn);
		
		money_tf = new JTextField();
		money_tf.setColumns(10);
		money_tf.setBounds(14, 105, 161, 24);
		contentPane.add(money_tf);
		
		pwf = new JPasswordField();
		pwf.setBounds(14, 65, 161, 24);
		contentPane.add(pwf);
		
		label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setBounds(190, 68, 62, 18);
		contentPane.add(label);
		
		label_1 = new JLabel("\uACC4\uC88C\uBC88\uD638");
		label_1.setBounds(190, 26, 62, 18);
		contentPane.add(label_1);
		
		label_2 = new JLabel("\uCD9C\uAE08\uAE08\uC561");
		label_2.setBounds(189, 108, 62, 18);
		contentPane.add(label_2);
		
		shin_rd = new JRadioButton("\uC2E0\uD55C\uC740\uD589");
		shin_rd.setBounds(10, 137, 139, 27);
		contentPane.add(shin_rd);
		
		hana_rd = new JRadioButton("\uD558\uB098\uC740\uD589");
		hana_rd.setBounds(10, 168, 139, 27);
		contentPane.add(hana_rd);
		
		kuk_rd = new JRadioButton("\uAD6D\uBBFC\uC740\uD589");
		kuk_rd.setBounds(10, 199, 139, 27);
		contentPane.add(kuk_rd);
		
		JLabel label_3 = new JLabel("\uC740\uD589\uC120\uD0DD");
		label_3.setBounds(190, 172, 62, 18);
		contentPane.add(label_3);
		
		ButtonGroup bankrad = new ButtonGroup();
		bankrad.add(kuk_rd);
		bankrad.add(hana_rd);
		bankrad.add(shin_rd);
		
		setVisible(true);
	}
}
