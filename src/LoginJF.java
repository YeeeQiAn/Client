
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
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

import com.mysql.jdbc.Statement;

public class LoginJF  extends JFrame{
	/*
	 * 
	 */
	 public String name="user";
	 public String password="123";
	 
	 public DictionaryService DictionyService;
	 public String username=null;
	 
	 JLabel label1 = new JLabel("姓名");
	 JLabel label2 = new JLabel("密码");
	 JTextField namejtf = new JTextField();
	 JPasswordField passwordjtf = new JPasswordField();
	 JButton button = new JButton("登 录");
	 JLabel newclient=new JLabel("还没有账号？");
	 public mainUI mainui;
	 public newclientJF  newclientjf;
	 
	public LoginJF(final mainUI mainui){
		
	super("登录");
	ImageIcon background;
	 background = new ImageIcon("back.png");
   JLabel label = new JLabel(background);
   label.setBounds(0, 0, background.getIconWidth(),background.getIconHeight()); 
   JPanel imagePanel;
   imagePanel = (JPanel) this.getContentPane();  
   imagePanel.setOpaque(false); 
   this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); 
	this.setBounds(750, 200, 200, 450);
	this.setResizable(false);
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	this.getContentPane().setBackground(Color.WHITE);
    this.setLayout(null);
    this.setUndecorated(true);
    this.mainui=mainui;
    this.newclientjf=new  newclientJF(this,mainui);  
	this.DictionyService = mainui.DictionyService;
    //this.setVisible(true);  
    
    
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
				LoginJF.this.setExtendedState(JFrame.ICONIFIED);
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
    
    /*
     * jlabel
     */
    
    
	label1.setBounds(20, 105, 30, 30);
	this.add(label1);
	
	label2.setBounds(20, 165, 30, 30);
	this.add(label2);
		
	namejtf.setBounds(50, 110, 130, 20);
	namejtf.setOpaque(false);
	namejtf.setBorder (BorderFactory.createLineBorder(Color.gray,1));
	this.add(namejtf);
		
	passwordjtf .setBounds(50, 170, 130, 20);
	passwordjtf.setOpaque(false);
	passwordjtf.setBorder (BorderFactory.createLineBorder(Color.gray,1));
	this.add(passwordjtf );
    
	newclient.setBounds(120,200,100,30);
    newclient.setForeground(Color.blue);
    newclient.addMouseListener(new MouseListener(){
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			LoginJF.this.setVisible(false);
			newclientjf.setVisible(true);			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			newclient.setForeground(Color.YELLOW);
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			newclient.setForeground(Color.GRAY);
		}
	});
	this.add(newclient);
	    
	/*
	 * button
	 */
	button.setBounds(20, 250, 150, 40);
	Font f=new Font("楷体",Font.BOLD,25);
	button.setFont(f);
	button.setBackground(Color.white);
	//button.setBorderPainted(false);
    button.setOpaque(false);
	button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			name = namejtf.getText();
			password = passwordjtf.getText();
			//password.equals(passwordjtf.getText()) && name.equals(namejtf.getText())
			try {
				if(mainui.DictionyService.ifloginsuccess(name,password)) {
					//JOptionPane.showMessageDialog(null, "欢迎", "提示", JOptionPane.INFORMATION_MESSAGE);			
					LoginJF.this.username=namejtf.getText();			
					LoginJF.this.setVisible(false);
					//mainUI.jf.setVisible(true);
					mainUI.use.setText("Welcome " + username);
					mainui.username=username;		
					mainui.jf.setTitle(username +"'s "+"dictionary");
				    mainui.jf.remove(mainui.loginjb);
				    mainui.jf.add(mainui.hasloginjb);			    			    
					mainui.jf.repaint();
				} else {
					JOptionPane.showMessageDialog(null, "密码错误，请重新输入", "提示", JOptionPane.ERROR_MESSAGE);
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
		
	/*public static void main(String[] args){		
		new LoginJF();		
	}*/
	
}

