

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FunctionJF extends JFrame{
	JButton button1 = new JButton("在线用户");
	JButton button2 = new JButton("确认转发");
	JButton button3 = new JButton("所有用户");
	public mainUI mainui;
	public String[] name = new String[10];
	public JList jlist=new JList<Object>(name);
	public JScrollPane jsp;
	public String username = null;
	
	public FunctionJF(final mainUI mainui){
		super("菜单");
		for(int i=0;i<10;i++)
			name[i] = "";
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
					FunctionJF.this.setExtendedState(JFrame.ICONIFIED);
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
	    
	    Font f=new Font("楷体",Font.BOLD,20);
		button1.setFont(f);
		button1.setBackground(Color.white);
		button2.setFont(f);
		button2.setBackground(Color.white);
		button3.setFont(f);
		button3.setBackground(Color.white);
	    button1.setBounds(0,400,100,50);
	    button2.setBounds(0,350,200,50);
	    button3.setBounds(100,400,100,50);
	    button1.setOpaque(false);
		button1.setBorder (BorderFactory.createLineBorder(Color.gray,1));
		button2.setOpaque(false);
		button2.setBorder (BorderFactory.createLineBorder(Color.gray,1));
		button3.setOpaque(false);
		button3.setBorder (BorderFactory.createLineBorder(Color.gray,1));
		this.add(button1);
		this.add(button2);
		this.add(button3);
		
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> result = new ArrayList<String>();
				try {
					result = mainui.DictionyService.onlineuser();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int length = result.size();
				if(length == 0){
					for(int i=0;i<10;i++)
						name[i]="";
				}else{
				for(int i=0;i<length;i++)
				name[i] = result.get(i);
				for(int i=length;i<10;i++)
					name[i]="";}
				jlist.updateUI();
			}		
		});
		
		button2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 BufferedImage  bi = new BufferedImage(mainui.jf.getWidth(), mainui.jf.getHeight(), BufferedImage.TYPE_INT_ARGB);
			        Graphics2D  g2d = bi.createGraphics();
			        mainui.jf.paint(g2d);
			        try {
			        	String picturename = username+".png";
						ImageIO.write(bi, "PNG", new File(picturename));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}		
		});
		
		button3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<String> result = new ArrayList<String>();
				try {
					result = mainui.DictionyService.alluser();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int length = result.size();
				if(length == 0){
					for(int i=0;i<10;i++)
						name[i]="";
				}else{
				for(int i=0;i<length;i++)
				name[i] = result.get(i);
				for(int i=length;i<10;i++)
					name[i]="";}
				jlist.updateUI();
			}		
		});
		
		//jsp = new JScrollPane(jlist);
		jlist.setBounds(0, 50, 200, 300);
		//jsp.setBackground(new Color(0, 0, 0, 0));
		//jsp.setOpaque(false);
		jlist.setBackground(new Color(0, 0, 0, 0));
		jlist.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.white));
		jlist.setOpaque(false);
		jlist.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
            	if((String) jlist.getSelectedValue()=="")
            		;
            	else username = (String)jlist.getSelectedValue();
            	
            	jlist.setSelectedIndex(0);
            }
        });
		this.add(jlist);
	}

}
