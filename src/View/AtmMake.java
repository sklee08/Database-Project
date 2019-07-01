package View;

import Control.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AtmMake extends JFrame {

	private JPanel contentPane;
	private JTextField account_tf;
	private JPasswordField pwf;
	private JPasswordField pwcheckf;
	private JLabel pwcor_lb = new JLabel("");
	private JLabel pwcor1_lb = new JLabel("");
	private JTextField name_tf;
	private JTextField idNum1;
	private JTextField idNum2;
	private JRadioButton shinhan_rad;
	private JRadioButton hana_rad;
	private JRadioButton kukmin_rad;
	private SyncController sc;
	private DBController dc;
	private GUIController gc;
	
	
	
	/**
	 * Launch the application.
	 */
	public AtmMake() {
		init();
	}

	/**
	 * Create the frame.
	 */
	public void init(){
		
		sc = new SyncController();
		dc = new DBController();
		gc = new GUIController();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		account_tf = new JTextField();
		
		account_tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if((e.getKeyCode() > 57 || e.getKeyCode() <48) && e.getKeyCode() != '-' && e.getKeyCode() != 8) {//숫자입력하려고 하면 입력 취소
					String rep = account_tf.getText();
					rep = rep.substring(0, rep.length()-1);
					account_tf.setText(rep);
					return;
				}
			}
		});
		account_tf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				account_tf.setText("");
			}
		});
		account_tf.setText("\uACC4\uC88C\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694.");
		account_tf.setBounds(14, 12, 285, 24);
		contentPane.add(account_tf);
		account_tf.setColumns(10);
		
		JButton dupcheck_btn = new JButton("\uC911 \uBCF5 \uD655 \uC778");
		dupcheck_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//성공또는 실패 창 띄우기
				String account = account_tf.getText();
				try {
					if(sc.dupCheck(account)) {
						//같은게 없음 
						pwf.requestFocus();
					}
					else {
						// 같은게 있음
						
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		dupcheck_btn.setBounds(313, 11, 105, 27);
		contentPane.add(dupcheck_btn);
		
		pwf = new JPasswordField();
		pwf.setBounds(14, 88, 285, 24);
		contentPane.add(pwf);
		
		pwcheckf = new JPasswordField();
		pwcheckf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String pw = new String(pwf.getPassword());
				String pwcheck = new String(pwcheckf.getPassword());
				if(!pw.equals(pwcheck)) {
					pwcor_lb.setText("비밀번호가");
					pwcor1_lb.setText("다릅니다.");
				}
				if(pw.equals(pwcheck)) {
					pwcor_lb.setText("비밀번호가");
					pwcor1_lb.setText("일치합니다.");
				}
			}
		});
		
		
		pwcheckf.setBounds(14, 149, 285, 24);
		contentPane.add(pwcheckf);
		
		shinhan_rad = new JRadioButton("\uC2E0\uD55C\uC740\uD589");
		shinhan_rad.setBounds(14, 332, 113, 27);
		contentPane.add(shinhan_rad);
		
		hana_rad = new JRadioButton("\uD558\uB098\uC740\uD589");
		hana_rad.setBounds(163, 332, 113, 27);
		contentPane.add(hana_rad);
		
		kukmin_rad = new JRadioButton("\uAD6D\uBBFC\uC740\uD589");
		kukmin_rad.setBounds(305, 332, 113, 27);
		contentPane.add(kukmin_rad);
		
		ButtonGroup bankrad = new ButtonGroup();
		bankrad.add(kukmin_rad);
		bankrad.add(hana_rad);
		bankrad.add(shinhan_rad);
		
		
		JLabel pw_lb = new JLabel("\uBE44\uBC00\uBC88\uD638 \uC785\uB825");
		pw_lb.setBounds(14, 58, 113, 18);
		contentPane.add(pw_lb);
		
		JLabel pw1_lb = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		pw1_lb.setBounds(14, 119, 113, 18);
		contentPane.add(pw1_lb);
		
		JButton make_btn = new JButton("\uACC4  \uC88C  \uC0DD  \uC131");
		make_btn.setBounds(14, 367, 404, 47);
		contentPane.add(make_btn);
		
		make_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//성공또는 실패 창 띄우기
				String account = account_tf.getText();
				String pw = new String(pwf.getPassword());
				String name = name_tf.getText();
				String idNum = idNum1.getText()+"-"+idNum2.getText();
				String bank= "";
				
				if(shinhan_rad.isSelected()) {
					bank = "신한";
				}
				else if(hana_rad.isSelected()) {
					bank = "하나";
				}
				else if(kukmin_rad.isSelected()) {
					
					bank = "국민";
				}
				
				if(sc.signUp(idNum, name, pw, account, bank)) {
					// 생성 성공
					gc.popWorkSuccess();
				}
				
			}
		});
		
		
		pwcor_lb.setBounds(313, 106, 105, 18);
		contentPane.add(pwcor_lb);
		
		
		pwcor1_lb.setBounds(313, 136, 113, 18);
		contentPane.add(pwcor1_lb);
		
		name_tf = new JTextField();
		name_tf.setBounds(14, 211, 285, 24);
		contentPane.add(name_tf);
		name_tf.setColumns(10);
		
		JLabel name_lb = new JLabel("\uC774\uB984");
		name_lb.setBounds(14, 185, 113, 18);
		contentPane.add(name_lb);
		
		idNum1 = new JTextField();
		idNum1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() > 57 || e.getKeyCode() <48 && e.getKeyCode() != 8) {//숫자입력하려고 하면 입력 취소
					String rep = idNum1.getText();
					rep = rep.substring(0, rep.length()-1);
					idNum1.setText(rep);
					return;
				}
				if(idNum1.getText().length() == 6) {
					idNum2.requestFocus();
				}
				if(idNum1.getText().length() > 6)
					idNum1.setText(idNum1.getText().substring(0, 6));
			}
		});
		idNum1.setColumns(10);
		idNum1.setBounds(14, 287, 113, 24);
		contentPane.add(idNum1);
		
		idNum2 = new JTextField();
		idNum2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(idNum1.getText().length() != 6) {
					idNum1.requestFocus();
				}
			}
		});
		idNum2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() > 57 || e.getKeyCode() <48 && e.getKeyCode() != 8) {//숫자입력하려고 하면 입력 취소
					String rep = idNum2.getText();
					rep = rep.substring(0, rep.length()-1);
					idNum2.setText(rep);
					return;
				}
				if(idNum2.getText().length() > 7) {
					String over = idNum2.getText();
					over = over.substring(0, over.length()-1);
					idNum2.setText(over);
					return;
				}
			}
		});
		idNum2.setColumns(10);
		idNum2.setBounds(186, 287, 113, 24);
		contentPane.add(idNum2);
		
		JLabel idNum_lb = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638");
		idNum_lb.setBounds(14, 257, 113, 18);
		contentPane.add(idNum_lb);
		
		JLabel hypon_default = new JLabel("-");
		hypon_default.setBounds(154, 290, 28, 18);
		contentPane.add(hypon_default);
		setVisible(true);
	}
}
