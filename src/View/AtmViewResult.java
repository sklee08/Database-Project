
// 잔액조회 결과창 

package View;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtmViewResult extends JFrame {

   private JPanel contentPane;

   public AtmViewResult(String name, String accountNum, int money) {
      init(name, accountNum, money);
   }
   /**
    * Create the frame.
    */
   public void init(String name, String accountNum, int money) {
      String balance = Integer.toString(money);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 431, 324);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JLabel nameLb = new JLabel(name);
      nameLb.setBounds(14, 12, 62, 18);
      contentPane.add(nameLb);
      
      JLabel defLb = new JLabel("\uD638\uAC31\uB2D8\uC758");
      defLb.setBounds(104, 12, 62, 18);
      contentPane.add(defLb);
      
      JLabel accountLb = new JLabel(accountNum);
      accountLb.setBounds(14, 61, 152, 18);
      contentPane.add(accountLb);
      
      JLabel def2Lb = new JLabel("\uACC4\uC88C\uC758");
      def2Lb.setBounds(180, 61, 62, 18);
      contentPane.add(def2Lb);
      
      JLabel def3Lb = new JLabel("\uC794\uC561\uC740");
      def3Lb.setBounds(14, 112, 48, 18);
      contentPane.add(def3Lb);
      
      JLabel balanceLb = new JLabel(balance+"원");
      balanceLb.setBounds(76, 112, 138, 18);
      contentPane.add(balanceLb);
      
      JLabel def5Lb = new JLabel("\uC785\uB2C8\uB2E4.");
      def5Lb.setBounds(228, 112, 62, 18);
      contentPane.add(def5Lb);
      
      JButton exitBtn = new JButton("\uD655 \uC778");
      exitBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
         }
      });
      exitBtn.setBounds(123, 185, 177, 45);
      contentPane.add(exitBtn);
      setVisible(true);
   }

}