
package View;


import Control.*;
import Model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtmTrans extends JFrame {

   private JPanel contentPane;
   private JTextField account_tf;
   private JTextField money_tf;
   private JRadioButton shinhan_rad;
   private JRadioButton hana_rad;
   private JRadioButton kukmin_rad;
   private String fromAccount;
   private SyncController sc;
   private GUIController gc;

   /**
    * Launch the application.
    */
    public AtmTrans(String fromAccount) {
    	this.fromAccount = fromAccount;
    	init();
    }
   /**
    * Create the frame.
    */
   public void init() {
	   
	   this.sc = new SyncController();
	   this.gc = new GUIController();
	   
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 373, 237);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      account_tf = new JTextField();
      account_tf.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            account_tf.setText("");
         }
      });
      account_tf.setText("\uC774\uCCB4 \uBC1B\uC744 \uACC4\uC88C\uBC88\uD638");
      account_tf.setBounds(14, 12, 236, 24);
      contentPane.add(account_tf);
      account_tf.setColumns(10);
      
      money_tf = new JTextField();
      money_tf.addFocusListener(new FocusAdapter() {
         @Override
         public void focusGained(FocusEvent e) {
            money_tf.setText("");
         }
      });
      money_tf.setText("\uC774\uCCB4\uD558\uC2E4 \uAE08\uC561");
      money_tf.setBounds(14, 48, 236, 24);
      contentPane.add(money_tf);
      money_tf.setColumns(10);
      
      JButton send_btn = new JButton("\uC774 \uCCB4");
      send_btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 
        	 String toAccount = account_tf.getText();
        	 String money = money_tf.getText();
  
				String bank = "";
				if(shinhan_rad.isSelected()){
					// 신한 선택
					bank = "신한";
				}
				else if(hana_rad.isSelected()) {
					bank = "하나";
				}
				else if(kukmin_rad.isSelected()) {
					bank = "국민";
				}	
				try {
					int index = sc.isStolen(toAccount);
					if(index == 1){
						// 도난 계좌
						gc.popRobberedAccount();
					}
					else {
						UserInfo toUser = sc.find(toAccount);
						UserInfo fromUser = sc.find(fromAccount);
						
						int imoney = Integer.parseInt(money);
						
						if(sc.calculate(fromAccount, fromUser.getBank(), -imoney)) {
							gc.popWorkSuccess();
						}
						else {
							gc.popLackBalance();
						}
						
						sc.calculate(toAccount, toUser.getBank(), imoney);
					}
					
				}
				catch(Exception e1) {
					
				}
         }
      });
      send_btn.setBounds(264, 12, 77, 60);
      contentPane.add(send_btn);
      
      shinhan_rad = new JRadioButton("\uC2E0\uD55C\uC740\uD589");
      shinhan_rad.setBounds(10, 87, 113, 27);
      contentPane.add(shinhan_rad);
      
      hana_rad = new JRadioButton("\uD558\uB098\uC740\uD589");
      hana_rad.setBounds(129, 87, 113, 27);
      contentPane.add(hana_rad);
      
      kukmin_rad = new JRadioButton("\uAD6D\uBBFC\uC740\uD589");
      kukmin_rad.setBounds(248, 87, 113, 27);
      contentPane.add(kukmin_rad);
      
      ButtonGroup bankrad = new ButtonGroup();
      bankrad.add(kukmin_rad);
      bankrad.add(hana_rad);
      bankrad.add(shinhan_rad);
      
      JButton exit_btn = new JButton("\uCDE8        \uC18C");
      exit_btn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose(); 
         }
      });
      exit_btn.setBounds(14, 134, 327, 40);
      contentPane.add(exit_btn);
      setVisible(true);
   }

}