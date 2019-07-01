// 거래내역 조회 결과창

package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class AtmTransViewResult extends JFrame {

   private JPanel contentPane;
   private JScrollPane InputScroll;
   private JScrollPane drawlScroll;

   /**
    * Launch the application.
    */
   public AtmTransViewResult(String accountNum, ArrayList<String> logrecv, ArrayList<String> logsend) {
      init(accountNum, logrecv, logsend);
   }
   /**
    * Create the frame.
    */
   public void init(String accountNum, ArrayList<String> logrecv, ArrayList<String> logsend) {
      
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 1001, 532);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      JButton okBtn = new JButton("\uD655       \uC778");
      okBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
         }
      });
      okBtn.setBounds(197, 426, 594, 47);
      contentPane.add(okBtn);
      
      JLabel defLb = new JLabel("\uC785\uAE08 \uB0B4\uC5ED");
      defLb.setBounds(197, 99, 62, 18);
      contentPane.add(defLb);
      
      JLabel defLb1 = new JLabel("\uCD9C\uAE08 \uB0B4\uC5ED");
      defLb1.setBounds(729, 99, 62, 18);
      contentPane.add(defLb1);
      
      JLabel defLb3 = new JLabel("\uC870\uD68C\uC911\uC778 \uACC4\uC88C \uBC88\uD638");
      defLb3.setBounds(430, 12, 122, 18);
      contentPane.add(defLb3);
      
      JLabel accountLb = new JLabel(accountNum);
      accountLb.setBounds(376, 47, 231, 18);
      contentPane.add(accountLb);
      
      InputScroll = new JScrollPane();
      InputScroll.setBounds(14, 155, 440, 259);
      contentPane.add(InputScroll);
      
      JTextArea recvTextArea = new JTextArea();
      InputScroll.setViewportView(recvTextArea);
      if(logrecv.size() == 0) {
    	 recvTextArea.append("기록이 존재하지 않습니다.");
      }
      for(int i = 0; i < logrecv.size(); i++) {
         recvTextArea.append(logrecv.get(i)+"\n");
         
         InputScroll.getVerticalScrollBar().setValue(InputScroll.getVerticalScrollBar().getMaximum());
      }
      
      drawlScroll = new JScrollPane();
      drawlScroll.setBounds(529, 155, 440, 259);
      contentPane.add(drawlScroll);
      
      JTextArea sendTextArea = new JTextArea();
      drawlScroll.setViewportView(sendTextArea);
      if(logsend.size() == 0) {
    	  sendTextArea.append("기록이 존재하지 않습니다.");
      }
      for(int i = 0; i < logsend.size(); i++) {
         sendTextArea.append(logsend.get(i)+"\n");
         drawlScroll.getVerticalScrollBar().setValue(drawlScroll.getVerticalScrollBar().getMaximum());
      }
      setVisible(true);
   }
}