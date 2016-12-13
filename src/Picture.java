import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.File;
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

public class Picture extends JFrame{
	public mainUI mainui;
	public JLabel label;
	public Picture(final mainUI mainui){
		super("图片");
		this.setBounds(250, 200, 500, 450); 
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.white);
        this.setLayout(null);
        this.setUndecorated(true);
        
        label = new JLabel();
        label.setBounds(0, 0, 500, 450);
        this.add(label);
        final ImageIcon _min = new ImageIcon("min5.png");
        JButton min = new JButton();
        min.setIcon(_min);
        min.setBounds(455, 0,20, 20);
        min.setBorderPainted(false);
        min.setBackground(Color.white);  
        min.setOpaque(false);
        min.addActionListener(new ActionListener(){
    			@Override
    			public void actionPerformed(ActionEvent e) {	
    			
    				Picture.this.setExtendedState(JFrame.ICONIFIED);
    			}      	 
          });
        this.add(min);
        
        final ImageIcon _close= new ImageIcon("close3.png");
        JButton close = new JButton();
        close.setIcon(_close);
        close.setBounds(480, 0,20, 20);
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
        
        final ImageIcon _change= new ImageIcon("eye.png");
        JButton change = new JButton();
        change.setIcon(_change);
        change.setBounds(430, 0,20, 20);
        change.setBorderPainted(false);
        change.setBackground(Color.white);  
        change.setOpaque(false);
        change.addActionListener(new ActionListener(){
    			@Override
    			public void actionPerformed(ActionEvent e) {	
    				//dispose();
    				//LoginJF.this.setExtendedState(JFrame.DISPOSE_ON_CLOSE);
    				String picture = mainui.username+".png";
    				File file = new File(picture);
    				if(!file.exists()){label.setIcon(new ImageIcon("notfound.png"));}
    				else
    				label.setIcon(new ImageIcon(picture));
    			}      	 
          });
        this.add(change);
        
	}	
}
