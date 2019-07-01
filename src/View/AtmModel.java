package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class AtmModel extends JFrame {

	private JPanel contentPane;
	private String path = "C:\\Users\\Lee\\Desktop\\DB_ATM_MODEL\\src";
	private BufferedImage icon;

	public AtmModel() throws IOException {
		
		setTitle("DB BANK ATM");
		icon = ImageIO.read(new File(path+"//AtmModelImg.jpg"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 690);
		contentPane = new JPanel() {
			 public void paintComponent(Graphics g) {
				 super.paintComponent(g);
				 g.drawImage(icon, 0, 0, null);
			 }
		};
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Input_btn = new JButton("\uC785 \uAE08");
		Input_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AtmInput inputTab = new AtmInput();
			}
		});
		Input_btn.setFont(new Font("ÇÑÄÄ À±°íµñ 250", Font.BOLD | Font.ITALIC, 20));
		Input_btn.setBounds(14, 97, 207, 63);
		contentPane.add(Input_btn);
		
		JButton drawl_btn = new JButton("\uCD9C \uAE08");
		drawl_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtmDrawl drawlTab = new AtmDrawl();
			}
		});
		drawl_btn.setFont(new Font("ÇÑÄÄ À±°íµñ 250", Font.BOLD | Font.ITALIC, 20));
		drawl_btn.setBounds(641, 97, 207, 63);
		contentPane.add(drawl_btn);
		
		JButton view_btn = new JButton("\uC870 \uD68C");
		view_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtmView viewTab = new AtmView();
			}
		});
		view_btn.setFont(new Font("ÇÑÄÄ À±°íµñ 250", Font.BOLD | Font.ITALIC, 20));
		view_btn.setBounds(14, 230, 207, 63);
		contentPane.add(view_btn);
		
		JButton mkaccount_btn = new JButton("\uACC4\uC88C\uC0DD\uC131");
		mkaccount_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtmMake makeTab = new AtmMake();
			}
		});
		mkaccount_btn.setFont(new Font("ÇÑÄÄ À±°íµñ 250", Font.BOLD | Font.ITALIC, 20));
		mkaccount_btn.setBounds(641, 230, 207, 63);
		contentPane.add(mkaccount_btn);
		
		JButton robbery_btn = new JButton("\uBD84\uC2E4\uC2E0\uACE0");
		robbery_btn.setFont(new Font("ÇÑÄÄ À±°íµñ 250", Font.BOLD | Font.ITALIC, 20));
		robbery_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AtmRobberyLogin robberyTab = new AtmRobberyLogin();
			}
		});
		robbery_btn.setBounds(14, 380, 207, 63);
		contentPane.add(robbery_btn);
		
		JButton transview_btn = new JButton("°Å·¡³»¿ª Á¶È¸");
		transview_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtmTransView transviewTab = new AtmTransView();
			}
		});
		transview_btn.setFont(new Font("ÇÑÄÄ À±°íµñ 250", Font.BOLD | Font.ITALIC, 20));
		transview_btn.setBounds(641, 380, 207, 63);
		contentPane.add(transview_btn);
		
		JButton trans_btn = new JButton("°è ÁÂ ÀÌ Ã¼");
		trans_btn.setFont(new Font("ÇÑÄÄ À±°íµñ 250", Font.BOLD | Font.ITALIC, 20));
		trans_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AtmTransLogin transTab = new AtmTransLogin();
			}
		});
		trans_btn.setBounds(14, 519, 207, 63);
		contentPane.add(trans_btn);
		
		JButton btnNewButton = new JButton("\uC885 \uB8CC");
		btnNewButton.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		btnNewButton.setFont(new Font("ÇÑÄÄ À±°íµñ 250", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(641, 520, 207, 63);
		contentPane.add(btnNewButton);
	}
}
