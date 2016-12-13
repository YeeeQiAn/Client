
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class newclientJF extends JFrame {
	
	 JLabel label1 = new JLabel("姓名");
	 JLabel label2 = new JLabel("密码");
	 JTextField namejtf = new JTextField();
	 JPasswordField passwordjtf = new JPasswordField();
	 JButton button = new JButton("注册");
	 public LoginJF Loginjf;
	 public mainUI mainui;
	 public String username=null;
	 public DictionaryService DictionyService;
	 
	public newclientJF(final LoginJF Loginjf ,final mainUI mainui){
				
	super("注册");
		
	this.Loginjf= Loginjf;
	this.mainui=mainui;
	this.DictionyService = mainui.DictionyService;
	this.setBounds(750, 200, 200, 450);
	this.setResizable(false);
    this.setUndecorated(true);
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	this.getContentPane().setBackground(Color.WHITE);
    this.setLayout(null);
  //  this.setVisible(true);
    
    ImageIcon background;
	background = new ImageIcon("back.png");
    JLabel label = new JLabel(background);
    label.setBounds(0, 0, background.getIconWidth(),background.getIconHeight()); 
    JPanel imagePanel;
    imagePanel = (JPanel) this.getContentPane();  
    imagePanel.setOpaque(false); 
    this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); 
      
    final ImageIcon _min = new ImageIcon("min5.png");
    JButton min = new JButton();
    min.setIcon(_min);
    min.setBounds(155, 0,20, 20);
    min.setBorderPainted(false);
    min.setBackground(Color.white);  
    min.setOpaque(false);
    min.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {	
				/* Here writes the code of search according to the jtextfiled and the choice button*/
				newclientJF.this.setExtendedState(JFrame.ICONIFIED);
			}      	 
    });
    this.add(min);
  
    final ImageIcon _close= new ImageIcon("close3.png");
    JButton close = new JButton();
    close.setIcon(_close);
    close.setBounds(180, 0,20, 20);
    close.setBorderPainted(false);
    close.setBackground(Color.white);  
    close.setOpaque(false);
    close.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {	
				dispose();
				//LoginJF.this.setExtendedState(JFrame.DISPOSE_ON_CLOSE);
			}      	 
    });
    this.add(close);
  
    /** JLabel **/ 
	label1.setBounds(20, 105, 30, 30);
	this.add(label1);
		
	label2.setBounds(20, 165, 30, 30);
	this.add(label2);	
	
	namejtf.setBounds(50, 110, 130, 20);
	namejtf.setBorder (BorderFactory.createLineBorder(Color.gray,1));
	this.add(namejtf);
		
	passwordjtf .setBounds(50, 170, 130, 20);
	passwordjtf.setBorder (BorderFactory.createLineBorder(Color.gray,1));
	this.add(passwordjtf );
    
	   
	/** Button **/	
	button.setBounds(20, 250, 150, 40);
	Font f=new Font("楷体",Font.BOLD,25);
	button.setFont(f);
	button.setBackground(Color.white);
	//button.setBorderPainted(false);
    button.setOpaque(false);
	button.addActionListener(new ActionListener() {	
		@Override
		public void actionPerformed(ActionEvent e) {
            String name = namejtf.getText();
            String password = passwordjtf.getText();
			try {
				if(mainui.DictionyService.ifregistersuccess(name,password)) {
					JOptionPane.showMessageDialog(null, "注册成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					newclientJF.this.username=namejtf.getText();
					newclientJF.this.setVisible(false);
					/*mainui.username=username;
					mainui.jf.setTitle(username+"'s "+"dictionary");
				    mainui.jf.remove(mainui.loginjb);
				    mainui.jf.add(mainui.hasloginjb);*/
					Loginjf.setVisible(true);		    
					//mainui.jf.repaint();				
				} 
				else {
					JOptionPane.showMessageDialog(null, "用户名已存在，请重新输入", "提示", JOptionPane.ERROR_MESSAGE);
					passwordjtf.setText("");
					namejtf.setText("");
				}
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		}
	});
	this.add(button);
}
		
/*	public static void main(String[] args){
		new newclientJF();		
	}	*/	
}
