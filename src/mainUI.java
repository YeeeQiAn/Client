
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;





















import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.mysql.jdbc.Connection;

public class mainUI{
	public static JFrame jf=new JFrame("Dictionary");
	public JLabel jl=new JLabel("Input");//input label
	public JTextField inputjtf=new JTextField();
	public JPanel jp=new JPanel(); 
	public ButtonGroup bg= new ButtonGroup();
	public JCheckBox baidujcb=new JCheckBox("百  度");
	public JCheckBox youdaojcb=new JCheckBox("有  道");
	public JCheckBox jinshanjcb=new JCheckBox("必 应");
	public JLabel baidujl=new JLabel("百  度");
	public JLabel youdaojl=new JLabel("有  道");
	public JLabel jinshanjl=new JLabel("必 应");
	public JTextArea baidujta=new JTextArea();
	public JTextArea youdaojta=new JTextArea();
	public JTextArea jinshanjta=new JTextArea();
	public JButton baidulikejb=new JButton();
	public JButton youdaolikejb=new JButton();
	public JButton jinshanlikejb=new JButton();
	public JButton baiduzzjb=new JButton();
	public JButton youdaozzjb=new JButton();
	public JButton jinshanzzjb=new JButton();
	public JButton loginjb=new JButton();
	public JButton searchjb=new JButton();
	public LoginJF loginjf=new LoginJF(this);
	public FunctionJF functionjf = new FunctionJF(this);
	public Picture picturejf = new Picture(this);
	public JButton hasloginjb=new JButton();
	public static JTextArea use = new JTextArea("未登录");
	public DictionaryService DictionyService;
	public int baiduLoveStatus = 0;
	public int youdaoLoveStatus = 0;
	public int jinshanLoveStatus = 0;
	public static String username=null;
	public int baidu_time = 0;
	public int youdao_time = 0;
	public int jinshan_time = 0;
	
	public mainUI(DictionaryService DictionnaryService) throws IOException{		
		/** JFrame **/
		this.DictionyService = DictionnaryService;
		jf.setName(username +"'s "+"dictionary");
		 ImageIcon background;
		 background = new ImageIcon("back.png");
        JLabel label = new JLabel(background);
        label.setBounds(0, 0, background.getIconWidth(),background.getIconHeight()); 
        JPanel imagePanel;
        imagePanel = (JPanel) jf.getContentPane();  
        imagePanel.setOpaque(false); 
        jf.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE)); 
		jf.setBounds(250, 200, 500, 450); 
		jf.setResizable(false);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.getContentPane().setBackground(Color.BLUE);
        jf.setLayout(null);
        jf.setUndecorated(true);
        jf.setVisible(true);
        
        
        Color c = new Color(255,255,255);//背影颜色设置         

        /**user**/
        use.setBounds(10, 10, 100, 25);
        use.setOpaque(false);
        use.setEditable(false);
        use.setForeground(c);
        jf.add(use);
        
        /**min icon && close icon**/
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
    				/* Here writes the code of search according to the jtextfiled and the choice button*/
    				jf.setExtendedState(JFrame.ICONIFIED);
    			}      	 
          });
        jf.add(min);
        
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
    				jf.dispose();
    				//LoginJF.this.setExtendedState(JFrame.DISPOSE_ON_CLOSE);
    			}      	 
          });
        jf.add(close);
        
        /** eye icon **/
        final ImageIcon _eye = new ImageIcon("eye.png");
        JButton eye = new JButton();
        eye.setIcon(_eye);
        eye.setBounds(430, 0,20, 20);
        eye.setBorderPainted(false);
        eye.setBackground(Color.white);  
        eye.setOpaque(false);
        eye.addActionListener(new ActionListener(){
    			@Override
    			public void actionPerformed(ActionEvent e) {	
    				/* Here writes the code of search according to the jtextfiled and the choice button*/
    				picturejf.setVisible(true);
    			}      	 
          });
        jf.add(eye);
        
        /** input Label **/
        jl.setBounds(20,40,40,20);
        jl.setBackground(Color.green);
        jl.setOpaque(false);
        jl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
        jl.setBorder(null);
        jf.add(jl);
              
        /** input Textfield **/
        inputjtf.setBounds(50, 35, 380, 30);
        inputjtf.setOpaque(false);
        //inputjtf.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
        jf.add(inputjtf);
                      
        /** multichoose Label **/
        baidujcb.setBounds(80,70,80,30);
        youdaojcb.setBounds(230,70,80,30);
        jinshanjcb.setBounds(380,70,80,30);
        baidujcb.setBackground(c); 
        youdaojcb.setBackground(c);
        jinshanjcb.setBackground(c);
        baidujcb.setOpaque(false);
        youdaojcb.setOpaque(false);
        jinshanjcb.setOpaque(false);
        baidujcb.setForeground(c);
        youdaojcb.setForeground(c);
        jinshanjcb.setForeground(c);
        jf.add(baidujcb);
        jf.add(youdaojcb);
        jf.add(jinshanjcb);
                     
        /** search Label **/
        final ImageIcon icon_baidu = new ImageIcon("baidu.png");
        final ImageIcon icon_youdao = new ImageIcon("youdao2.png");
        final ImageIcon icon_biying = new ImageIcon("biying.png");
        baidujl.setBounds(10,130,60,30);
        youdaojl.setBounds(10,230,60,30);
        jinshanjl.setBounds(10,330,60,30);
        youdaojl.setIcon(icon_youdao);
        jinshanjl.setIcon(icon_biying);
        baidujl.setIcon(icon_baidu);
        jf.add(baidujl);
        jf.add(youdaojl);
        jf.add(jinshanjl);
        baidujta.setBounds(80,110,350,70);
        baidujta.setOpaque(false);
        baidujta.setEditable(false) ;
        baidujta.setLineWrap(true);
        baidujta.setBorder (BorderFactory.createLineBorder(Color.gray,1));
        jf.add(baidujta);
        youdaojta.setBounds(80,210,350,70);
        youdaojta.setEditable(false);
        youdaojta.setOpaque(false);
        youdaojta.setLineWrap(true);
        youdaojta.setBorder (BorderFactory.createLineBorder(Color.gray,1));
        jf.add(youdaojta);
        jinshanjta.setBounds(80,310,350,70);
        jinshanjta.setEditable(false);
        jinshanjta.setOpaque(false);
        jinshanjta.setLineWrap(true);
        jinshanjta.setBorder (BorderFactory.createLineBorder(Color.gray,1));
        jf.add(jinshanjta);
              
        /** likeJButtons **/       
        final ImageIcon icon1 = new ImageIcon("kongxin.png");
        final ImageIcon icon2 = new ImageIcon("shixin.png");
        
        baidulikejb.setIcon(icon1);
        baidulikejb.setBounds(450, 110,30, 30);
        baidulikejb.setBorderPainted(false);
        baidulikejb.setBackground(c);  
        baidulikejb.setOpaque(false);
        baidulikejb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(baiduLoveStatus == 0){					
					try {
						mainUI.this.DictionyService.addtime(inputjtf.getText(),1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}										
				 baidulikejb.setIcon(icon2);
				 baiduLoveStatus = 1;
				 jf.repaint();}
				else{				
					try {
						mainUI.this.DictionyService.reducetime(inputjtf.getText(),1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
					baidulikejb.setIcon(icon1);
					 baiduLoveStatus = 0;
					 jf.repaint();
				}
			}      	
        });
        jf.add(baidulikejb);
        
        youdaolikejb.setIcon(icon1);
        youdaolikejb.setBounds(450, 210,30, 30);
        youdaolikejb.setBackground(c);  
        youdaolikejb.setBorderPainted(false);
        youdaolikejb.setOpaque(false);
        youdaolikejb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(youdaoLoveStatus == 0){					
					try {
						mainUI.this.DictionyService.addtime(inputjtf.getText(),2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
					 youdaolikejb.setIcon(icon2);
					 youdaoLoveStatus = 1;
					 jf.repaint();}
					else{					
						try {
							mainUI.this.DictionyService.reducetime(inputjtf.getText(),2);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
						youdaolikejb.setIcon(icon1);
						 youdaoLoveStatus = 0;
						 jf.repaint();
					}
			}      	
        });
        jf.add(youdaolikejb);
        
        jinshanlikejb.setIcon(icon1);
        jinshanlikejb.setBounds(450, 310,30, 30);
        jinshanlikejb.setBackground(c);  
        jinshanlikejb.setBorderPainted(false);
        jinshanlikejb.setOpaque(false);
        jinshanlikejb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jinshanLoveStatus == 0){				
					try {
						mainUI.this.DictionyService.addtime(inputjtf.getText(),3);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}				
					 jinshanlikejb.setIcon(icon2);
					 jinshanLoveStatus = 1;
					 jf.repaint();}
					else{			
						try {
							mainUI.this.DictionyService.reducetime(inputjtf.getText(),3);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}				
						jinshanlikejb.setIcon(icon1);
						 jinshanLoveStatus = 0;
						 jf.repaint();
					}
			}      	
        });
        jf.add(jinshanlikejb);
              
        /** zhuanzai Buttons **/
        ImageIcon icon3 = new ImageIcon("jiantou2.png");
        baiduzzjb.setIcon(icon3);
        baiduzzjb.setBounds(450, 75, 30, 30);
        baiduzzjb.setBackground(c);  
        baiduzzjb.setBorderPainted(false);
        baiduzzjb.setOpaque(false);
        baiduzzjb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Here writes the code of loadUI */
				if(username != null)
				functionjf.setVisible(true);
			}      	
        });
        jf.add(baiduzzjb);
        youdaozzjb.setIcon(icon3);
        youdaozzjb.setBounds(450, 245, 30, 30);
        youdaozzjb.setBackground(c); 
        youdaozzjb.setBorderPainted(false);
        youdaozzjb.setOpaque(false);
        youdaozzjb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Here writes the code of loadUI */
			}      	
        });
        //jf.add(youdaozzjb);
        jinshanzzjb.setIcon(icon3);
        jinshanzzjb.setBounds(450, 345, 30, 30);
        jinshanzzjb.setBackground(c); 
        jinshanzzjb.setBorderPainted(false);
        jinshanzzjb.setOpaque(false);
        jinshanzzjb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Here writes the code of loadUI */
			}      	
        });
        //jf.add(jinshanzzjb);
               
        /** login Button **/
    	 ImageIcon icon4 = new ImageIcon("4.png");
         loginjb.setIcon(icon4);
         loginjb.setBackground(c); 
         loginjb.setBounds(470,40,20,20);
         loginjb.setBorderPainted(false);
         loginjb.setOpaque(false);
         loginjb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub				
				loginjf.setVisible(true);
				//mainUI.this.username=loginjf.name;
				//mainUI.this.jf.repaint();			
			}      	 
         });
         jf.add(loginjb);
         
         /** searchJButton **/
         searchjb.setBounds(430, 30, 40, 40);
         ImageIcon icon5 = new ImageIcon("search.png");
         searchjb.setIcon(icon5);
         searchjb.setBackground(c); 
         searchjb.setBorderPainted(false);
         searchjb.setOpaque(false);
         searchjb.addActionListener(new ActionListener(){
			@Override
 			public void actionPerformed(ActionEvent e) {
			      try {
					baidu_time = mainUI.this.DictionyService.time(inputjtf.getText(), 1);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			      try {
					youdao_time = mainUI.this.DictionyService.time(inputjtf.getText(), 2);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			      try {
					jinshan_time = mainUI.this.DictionyService.time(inputjtf.getText(), 3);
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			         baidulikejb.setIcon(icon1);
					 baiduLoveStatus = 0;
					 youdaolikejb.setIcon(icon1);
					 youdaoLoveStatus = 0;
					 jinshanlikejb.setIcon(icon1);
					 jinshanLoveStatus = 0;
					 jf.repaint();
 				/* Here writes the code of search according to the jtextfiled and the choice button*/
 			            if(baidujcb.isSelected()==false && youdaojcb.isSelected()==false && jinshanjcb.isSelected()==false){
 			                if(baidu_time>=youdao_time && baidu_time>=jinshan_time && youdao_time>=jinshan_time){
 			            	 baidujl.setBounds(10,130,60,30);baidujta.setBounds(80,110,350,70);
			            	 baiduzzjb.setBounds(450, 145, 30, 30);baidulikejb.setBounds(450, 110,30, 30);
			            	jf.add(baidujl); jf.add(baidujta);
			            	 jf.add(baiduzzjb); jf.add(baidulikejb);
			            	 youdaojl.setBounds(10,230,60,30);youdaojta.setBounds(80,210,350,70);
			            	 youdaozzjb.setBounds(450, 245, 30, 30);youdaolikejb.setBounds(450, 210,30, 30);
			            	 jf.add(youdaojl); jf.add(youdaojta);
			            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
			            	 jinshanjl.setBounds(10,330,60,30);jinshanjta.setBounds(80,310,350,70);
			            	 jinshanzzjb.setBounds(450, 345, 30, 30);jinshanlikejb.setBounds(450, 310,30, 30);
			            	 jf.add(jinshanjl); jf.add(jinshanjta);
			            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);}
 			                else if(baidu_time>=youdao_time && baidu_time>=jinshan_time && youdao_time < jinshan_time){
 			                	baidujl.setBounds(10,130,60,30);baidujta.setBounds(80,110,350,70);
 				            	 baiduzzjb.setBounds(450, 145, 30, 30);baidulikejb.setBounds(450, 110,30, 30);
 				            	jf.add(baidujl); jf.add(baidujta);
 				            	 jf.add(baiduzzjb); jf.add(baidulikejb);
 				            	 youdaojl.setBounds(10,330,60,30);youdaojta.setBounds(80,310,350,70);
 				            	 youdaozzjb.setBounds(450, 345, 30, 30);youdaolikejb.setBounds(450, 310,30, 30);
 				            	 jf.add(youdaojl); jf.add(youdaojta);
 				            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
 				            	 jinshanjl.setBounds(10,230,60,30);jinshanjta.setBounds(80,210,350,70);
 				            	 jinshanzzjb.setBounds(450, 245, 30, 30);jinshanlikejb.setBounds(450, 210,30, 30);
 				            	 jf.add(jinshanjl); jf.add(jinshanjta);
 				            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);
 			                }
 			                else if(youdao_time > baidu_time && youdao_time >= jinshan_time && baidu_time >= jinshan_time){
 			                	baidujl.setBounds(10,230,60,30);baidujta.setBounds(80,210,350,70);
				            	 baiduzzjb.setBounds(450, 245, 30, 30);baidulikejb.setBounds(450, 210,30, 30);
				            	jf.add(baidujl); jf.add(baidujta);
				            	 jf.add(baiduzzjb); jf.add(baidulikejb);
				            	 youdaojl.setBounds(10,130,60,30);youdaojta.setBounds(80,110,350,70);
				            	 youdaozzjb.setBounds(450, 145, 30, 30);youdaolikejb.setBounds(450, 110,30, 30);
				            	 jf.add(youdaojl); jf.add(youdaojta);
				            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
				            	 jinshanjl.setBounds(10,330,60,30);jinshanjta.setBounds(80,310,350,70);
				            	 jinshanzzjb.setBounds(450, 345, 30, 30);jinshanlikejb.setBounds(450, 310,30, 30);
				            	 jf.add(jinshanjl); jf.add(jinshanjta);
				            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);
 			                }
 			                else if(youdao_time > baidu_time && youdao_time >=jinshan_time && baidu_time < jinshan_time){
 			                	baidujl.setBounds(10,330,60,30);baidujta.setBounds(80,310,350,70);
				            	 baiduzzjb.setBounds(450, 345, 30, 30);baidulikejb.setBounds(450, 310,30, 30);
				            	jf.add(baidujl); jf.add(baidujta);
				            	 jf.add(baiduzzjb); jf.add(baidulikejb);
				            	 youdaojl.setBounds(10,130,60,30);youdaojta.setBounds(80,110,350,70);
				            	 youdaozzjb.setBounds(450, 145, 30, 30);youdaolikejb.setBounds(450, 110,30, 30);
				            	 jf.add(youdaojl); jf.add(youdaojta);
				            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
				            	 jinshanjl.setBounds(10,230,60,30);jinshanjta.setBounds(80,210,350,70);
				            	 jinshanzzjb.setBounds(450, 245, 30, 30);jinshanlikejb.setBounds(450, 210,30, 30);
				            	 jf.add(jinshanjl); jf.add(jinshanjta);
				            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);
 			                }
 			                else if(jinshan_time > baidu_time && jinshan_time > youdao_time && baidu_time >= youdao_time){
 			                	baidujl.setBounds(10,230,60,30);baidujta.setBounds(80,210,350,70);
				            	 baiduzzjb.setBounds(450, 245, 30, 30);baidulikejb.setBounds(450, 210,30, 30);
				            	jf.add(baidujl); jf.add(baidujta);
				            	 jf.add(baiduzzjb); jf.add(baidulikejb);
				            	 youdaojl.setBounds(10,330,60,30);youdaojta.setBounds(80,310,350,70);
				            	 youdaozzjb.setBounds(450, 345, 30, 30);youdaolikejb.setBounds(450, 310,30, 30);
				            	 jf.add(youdaojl); jf.add(youdaojta);
				            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
				            	 jinshanjl.setBounds(10,130,60,30);jinshanjta.setBounds(80,110,350,70);
				            	 jinshanzzjb.setBounds(450, 145, 30, 30);jinshanlikejb.setBounds(450, 110,30, 30);
				            	 jf.add(jinshanjl); jf.add(jinshanjta);
				            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);
 			                }
 			                else if(jinshan_time > baidu_time && jinshan_time > youdao_time && youdao_time > baidu_time){
 			                	baidujl.setBounds(10,330,60,30);baidujta.setBounds(80,310,350,70);
				            	 baiduzzjb.setBounds(450, 345, 30, 30);baidulikejb.setBounds(450, 310,30, 30);
				            	jf.add(baidujl); jf.add(baidujta);
				            	 jf.add(baiduzzjb); jf.add(baidulikejb);
				            	 youdaojl.setBounds(10,230,60,30);youdaojta.setBounds(80,210,350,70);
				            	 youdaozzjb.setBounds(450, 245, 30, 30);youdaolikejb.setBounds(450, 210,30, 30);
				            	 jf.add(youdaojl); jf.add(youdaojta);
				            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
				            	 jinshanjl.setBounds(10,130,60,30);jinshanjta.setBounds(80,110,350,70);
				            	 jinshanzzjb.setBounds(450, 145, 30, 30);jinshanlikejb.setBounds(450, 110,30, 30);
				            	 jf.add(jinshanjl); jf.add(jinshanjta);
				            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);
 			                }
			            	 try {
			 					baidujta.setText(mainUI.this.DictionyService.GetMeaning(inputjtf.getText()));
			 				} catch (IOException e2) {
			 					// TODO Auto-generated catch block
			 					e2.printStackTrace();
			 				}			            	
			            	 youdaojta.setText(mainUI.this.DictionyService.youdaoGetMeaning(inputjtf.getText()));
			            	 try {
									jinshanjta.setText(mainUI.this.DictionyService.biyingGetMeaning(inputjtf.getText()));
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
			            	 jf.repaint();
 			            }
 			            else if(baidujcb.isSelected()==true && youdaojcb.isSelected()==false && jinshanjcb.isSelected()==false){
 			            	 baidujl.setBounds(10,130,60,30);baidujta.setBounds(80,110,350,70);
 			            	 baiduzzjb.setBounds(450, 145, 30, 30);baidulikejb.setBounds(450, 110,30, 30);
 			            	jf.add(baidujl); jf.add(baidujta);
			            	 jf.add(baiduzzjb); jf.add(baidulikejb);
 			            	 jf.remove(jinshanjl);jf.remove(jinshanjta);
 			            	 jf.remove(jinshanlikejb);jf.remove(jinshanzzjb);
 			            	 jf.remove(youdaojl);jf.remove(youdaojta);
 			            	 jf.remove(youdaolikejb);jf.remove(youdaozzjb);
 			               try {
								baidujta.setText(mainUI.this.DictionyService.GetMeaning(inputjtf.getText()));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
 			            	// baidujta.setText(mainUI.this.DictionService.search);
 			            	 jf.repaint();
 			            }
 			            else if(baidujcb.isSelected()==false && youdaojcb.isSelected()==true && jinshanjcb.isSelected()==false){
 			            	youdaojl.setBounds(10,130,60,30);youdaojta.setBounds(80,110,350,70);
			            	 youdaozzjb.setBounds(450, 145, 30, 30);youdaolikejb.setBounds(450, 110,30, 30);
			            	 jf.add(youdaojl); jf.add(youdaojta);
			            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
			            	 jf.remove(jinshanjl);jf.remove(jinshanjta);
			            	 jf.remove(jinshanlikejb);jf.remove(jinshanzzjb);
			            	 jf.remove(baidujl);jf.remove(baidujta);
			            	 jf.remove(baidulikejb);jf.remove(baiduzzjb);
			            	 youdaojta.setText(mainUI.this.DictionyService.youdaoGetMeaning(inputjtf.getText()));
			            	 jf.repaint();
 			            }
 			            else if(baidujcb.isSelected()==false && youdaojcb.isSelected()==false && jinshanjcb.isSelected()==true){
 			            	jinshanjl.setBounds(10,130,60,30);jinshanjta.setBounds(80,110,350,70);
			            	 jinshanzzjb.setBounds(450, 145, 30, 30);jinshanlikejb.setBounds(450, 110,30, 30);
			            	 jf.add(jinshanjl); jf.add(jinshanjta);
			            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);
			            	 jf.remove(youdaojl);jf.remove(youdaojta);
			            	 jf.remove(youdaolikejb);jf.remove(youdaozzjb);
			            	 jf.remove(baidujl);jf.remove(baidujta);
			            	 jf.remove(baidulikejb);jf.remove(baiduzzjb);
			            	 try {
								jinshanjta.setText(mainUI.this.DictionyService.biyingGetMeaning(inputjtf.getText()));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			            	 jf.repaint();
 			            }
 			            else if(baidujcb.isSelected()==true && youdaojcb.isSelected()==true && jinshanjcb.isSelected()==false){
 			            	if(baidu_time >= youdao_time){
 			            	baidujl.setBounds(10,130,60,30);baidujta.setBounds(80,110,350,70);
			            	 baiduzzjb.setBounds(450, 145, 30, 30);baidulikejb.setBounds(450, 110,30, 30);
			            	jf.add(baidujl); jf.add(baidujta);
			            	 jf.add(baiduzzjb); jf.add(baidulikejb);
			            	 youdaojl.setBounds(10,230,60,30);youdaojta.setBounds(80,210,350,70);
			            	 youdaozzjb.setBounds(450, 245, 30, 30);youdaolikejb.setBounds(450, 210,30, 30);
			            	 jf.add(youdaojl); jf.add(youdaojta);
			            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
			            	 jf.remove(jinshanjl);jf.remove(jinshanjta);
			            	 jf.remove(jinshanlikejb);jf.remove(jinshanzzjb);}
 			            	else{
 			            		baidujl.setBounds(10,230,60,30);baidujta.setBounds(80,210,350,70);
 				            	 baiduzzjb.setBounds(450, 245, 30, 30);baidulikejb.setBounds(450, 210,30, 30);
 				            	jf.add(baidujl); jf.add(baidujta);
 				            	 jf.add(baiduzzjb); jf.add(baidulikejb);
 				            	 youdaojl.setBounds(10,130,60,30);youdaojta.setBounds(80,110,350,70);
 				            	 youdaozzjb.setBounds(450, 145, 30, 30);youdaolikejb.setBounds(450, 110,30, 30);
 				            	 jf.add(youdaojl); jf.add(youdaojta);
 				            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
 				            	 jf.remove(jinshanjl);jf.remove(jinshanjta);
 				            	 jf.remove(jinshanlikejb);jf.remove(jinshanzzjb);
 			            	}
			            	 try {
									baidujta.setText(mainUI.this.DictionyService.GetMeaning(inputjtf.getText()));
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
			            	 youdaojta.setText(mainUI.this.DictionyService.youdaoGetMeaning(inputjtf.getText()));
			            	 jf.repaint();
 			            }
 			           else if(baidujcb.isSelected()==true && youdaojcb.isSelected()==false && jinshanjcb.isSelected()==true){
 			        	   if(baidu_time >= jinshan_time){
 			        	  baidujl.setBounds(10,130,60,30);baidujta.setBounds(80,110,350,70);
			            	 baiduzzjb.setBounds(450, 145, 30, 30);baidulikejb.setBounds(450, 110,30, 30);
			            	jf.add(baidujl); jf.add(baidujta);
			            	 jf.add(baiduzzjb); jf.add(baidulikejb);
			            	 jinshanjl.setBounds(10,230,60,30);jinshanjta.setBounds(80,210,350,70);
			            	 jinshanzzjb.setBounds(450, 245, 30, 30);jinshanlikejb.setBounds(450, 210,30, 30);
			            	 jf.add(jinshanjl); jf.add(jinshanjta);
			            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);
			            	 jf.remove(youdaojl);jf.remove(youdaojta);
			            	 jf.remove(youdaolikejb);jf.remove(youdaozzjb);
 			        	   }
 			        	   else{
 			        		  baidujl.setBounds(10,230,60,30);baidujta.setBounds(80,210,350,70);
 			            	 baiduzzjb.setBounds(450, 245, 30, 30);baidulikejb.setBounds(450, 210,30, 30);
 			            	jf.add(baidujl); jf.add(baidujta);
 			            	 jf.add(baiduzzjb); jf.add(baidulikejb);
 			            	 jinshanjl.setBounds(10,130,60,30);jinshanjta.setBounds(80,110,350,70);
 			            	 jinshanzzjb.setBounds(450, 145, 30, 30);jinshanlikejb.setBounds(450, 110,30, 30);
 			            	 jf.add(jinshanjl); jf.add(jinshanjta);
 			            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);
 			            	 jf.remove(youdaojl);jf.remove(youdaojta);
 			            	 jf.remove(youdaolikejb);jf.remove(youdaozzjb);
 			        	   }
			            	 try {
									baidujta.setText(mainUI.this.DictionyService.GetMeaning(inputjtf.getText()));
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
			            	 try {
									jinshanjta.setText(mainUI.this.DictionyService.biyingGetMeaning(inputjtf.getText()));
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
			            	 jf.repaint();
			            }
 			          else if(baidujcb.isSelected()==false && youdaojcb.isSelected()==true && jinshanjcb.isSelected()==true){
 			        	  if(youdao_time >= jinshan_time){
 			        	 youdaojl.setBounds(10,130,60,30);youdaojta.setBounds(80,110,350,70);
		            	 youdaozzjb.setBounds(450, 145, 30, 30);youdaolikejb.setBounds(450, 110,30, 30);
		            	 jf.add(youdaojl); jf.add(youdaojta);
		            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
		            	 jinshanjl.setBounds(10,230,60,30);jinshanjta.setBounds(80,210,350,70);
		            	 jinshanzzjb.setBounds(450, 245, 30, 30);jinshanlikejb.setBounds(450, 210,30, 30);
		            	 jf.add(jinshanjl); jf.add(jinshanjta);
		            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);
		            	 jf.remove(baidujl);jf.remove(baidujta);
		            	 jf.remove(baidulikejb);jf.remove(baiduzzjb);}
 			        	  else{
 			        		 youdaojl.setBounds(10,230,60,30);youdaojta.setBounds(80,210,350,70);
 			            	 youdaozzjb.setBounds(450, 245, 30, 30);youdaolikejb.setBounds(450, 210,30, 30);
 			            	 jf.add(youdaojl); jf.add(youdaojta);
 			            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
 			            	 jinshanjl.setBounds(10,130,60,30);jinshanjta.setBounds(80,110,350,70);
 			            	 jinshanzzjb.setBounds(450, 145, 30, 30);jinshanlikejb.setBounds(450, 110,30, 30);
 			            	 jf.add(jinshanjl); jf.add(jinshanjta);
 			            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);
 			            	 jf.remove(baidujl);jf.remove(baidujta);
 			            	 jf.remove(baidulikejb);jf.remove(baiduzzjb);
 			        	  }
		            	 youdaojta.setText(mainUI.this.DictionyService.youdaoGetMeaning(inputjtf.getText()));
		            	 try {
								jinshanjta.setText(mainUI.this.DictionyService.biyingGetMeaning(inputjtf.getText()));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		            	 jf.repaint();
			            }
 			          else{
  			                if(baidu_time>=youdao_time && baidu_time>=jinshan_time && youdao_time>=jinshan_time){
  			            	 baidujl.setBounds(10,130,60,30);baidujta.setBounds(80,110,350,70);
 			            	 baiduzzjb.setBounds(450, 145, 30, 30);baidulikejb.setBounds(450, 110,30, 30);
 			            	jf.add(baidujl); jf.add(baidujta);
 			            	 jf.add(baiduzzjb); jf.add(baidulikejb);
 			            	 youdaojl.setBounds(10,230,60,30);youdaojta.setBounds(80,210,350,70);
 			            	 youdaozzjb.setBounds(450, 245, 30, 30);youdaolikejb.setBounds(450, 210,30, 30);
 			            	 jf.add(youdaojl); jf.add(youdaojta);
 			            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
 			            	 jinshanjl.setBounds(10,330,60,30);jinshanjta.setBounds(80,310,350,70);
 			            	 jinshanzzjb.setBounds(450, 345, 30, 30);jinshanlikejb.setBounds(450, 310,30, 30);
 			            	 jf.add(jinshanjl); jf.add(jinshanjta);
 			            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);}
  			                else if(baidu_time>=youdao_time && baidu_time>=jinshan_time && youdao_time < jinshan_time){
  			                	baidujl.setBounds(10,130,60,30);baidujta.setBounds(80,110,350,70);
  				            	 baiduzzjb.setBounds(450, 145, 30, 30);baidulikejb.setBounds(450, 110,30, 30);
  				            	jf.add(baidujl); jf.add(baidujta);
  				            	 jf.add(baiduzzjb); jf.add(baidulikejb);
  				            	 youdaojl.setBounds(10,330,60,30);youdaojta.setBounds(80,310,350,70);
  				            	 youdaozzjb.setBounds(450, 345, 30, 30);youdaolikejb.setBounds(450, 310,30, 30);
  				            	 jf.add(youdaojl); jf.add(youdaojta);
  				            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
  				            	 jinshanjl.setBounds(10,230,60,30);jinshanjta.setBounds(80,210,350,70);
  				            	 jinshanzzjb.setBounds(450, 245, 30, 30);jinshanlikejb.setBounds(450, 210,30, 30);
  				            	 jf.add(jinshanjl); jf.add(jinshanjta);
  				            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);
  			                }
  			                else if(youdao_time > baidu_time && youdao_time >= jinshan_time && baidu_time >= jinshan_time){
  			                	baidujl.setBounds(10,230,60,30);baidujta.setBounds(80,210,350,70);
 				            	 baiduzzjb.setBounds(450, 245, 30, 30);baidulikejb.setBounds(450, 210,30, 30);
 				            	jf.add(baidujl); jf.add(baidujta);
 				            	 jf.add(baiduzzjb); jf.add(baidulikejb);
 				            	 youdaojl.setBounds(10,130,60,30);youdaojta.setBounds(80,110,350,70);
 				            	 youdaozzjb.setBounds(450, 145, 30, 30);youdaolikejb.setBounds(450, 110,30, 30);
 				            	 jf.add(youdaojl); jf.add(youdaojta);
 				            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
 				            	 jinshanjl.setBounds(10,330,60,30);jinshanjta.setBounds(80,310,350,70);
 				            	 jinshanzzjb.setBounds(450, 345, 30, 30);jinshanlikejb.setBounds(450, 310,30, 30);
 				            	 jf.add(jinshanjl); jf.add(jinshanjta);
 				            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);
  			                }
  			                else if(youdao_time > baidu_time && youdao_time >=jinshan_time && baidu_time < jinshan_time){
  			                	baidujl.setBounds(10,330,60,30);baidujta.setBounds(80,310,350,70);
 				            	 baiduzzjb.setBounds(450, 345, 30, 30);baidulikejb.setBounds(450, 310,30, 30);
 				            	jf.add(baidujl); jf.add(baidujta);
 				            	 jf.add(baiduzzjb); jf.add(baidulikejb);
 				            	 youdaojl.setBounds(10,130,60,30);youdaojta.setBounds(80,110,350,70);
 				            	 youdaozzjb.setBounds(450, 145, 30, 30);youdaolikejb.setBounds(450, 110,30, 30);
 				            	 jf.add(youdaojl); jf.add(youdaojta);
 				            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
 				            	 jinshanjl.setBounds(10,230,60,30);jinshanjta.setBounds(80,210,350,70);
 				            	 jinshanzzjb.setBounds(450, 245, 30, 30);jinshanlikejb.setBounds(450, 210,30, 30);
 				            	 jf.add(jinshanjl); jf.add(jinshanjta);
 				            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);
  			                }
  			                else if(jinshan_time > baidu_time && jinshan_time > youdao_time && baidu_time >= youdao_time){
  			                	baidujl.setBounds(10,230,60,30);baidujta.setBounds(80,210,350,70);
 				            	 baiduzzjb.setBounds(450, 245, 30, 30);baidulikejb.setBounds(450, 210,30, 30);
 				            	jf.add(baidujl); jf.add(baidujta);
 				            	 jf.add(baiduzzjb); jf.add(baidulikejb);
 				            	 youdaojl.setBounds(10,330,60,30);youdaojta.setBounds(80,310,350,70);
 				            	 youdaozzjb.setBounds(450, 345, 30, 30);youdaolikejb.setBounds(450, 310,30, 30);
 				            	 jf.add(youdaojl); jf.add(youdaojta);
 				            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
 				            	 jinshanjl.setBounds(10,130,60,30);jinshanjta.setBounds(80,110,350,70);
 				            	 jinshanzzjb.setBounds(450, 145, 30, 30);jinshanlikejb.setBounds(450, 110,30, 30);
 				            	 jf.add(jinshanjl); jf.add(jinshanjta);
 				            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);
  			                }
  			                else if(jinshan_time > baidu_time && jinshan_time > youdao_time && youdao_time > baidu_time){
  			                	baidujl.setBounds(10,330,60,30);baidujta.setBounds(80,310,350,70);
 				            	 baiduzzjb.setBounds(450, 345, 30, 30);baidulikejb.setBounds(450, 310,30, 30);
 				            	jf.add(baidujl); jf.add(baidujta);
 				            	 jf.add(baiduzzjb); jf.add(baidulikejb);
 				            	 youdaojl.setBounds(10,230,60,30);youdaojta.setBounds(80,210,350,70);
 				            	 youdaozzjb.setBounds(450, 245, 30, 30);youdaolikejb.setBounds(450, 210,30, 30);
 				            	 jf.add(youdaojl); jf.add(youdaojta);
 				            	 jf.add(youdaozzjb); jf.add(youdaolikejb);
 				            	 jinshanjl.setBounds(10,130,60,30);jinshanjta.setBounds(80,110,350,70);
 				            	 jinshanzzjb.setBounds(450, 145, 30, 30);jinshanlikejb.setBounds(450, 110,30, 30);
 				            	 jf.add(jinshanjl); jf.add(jinshanjta);
 				            	 jf.add(jinshanzzjb); jf.add(jinshanlikejb);
  			                }
		            	 
		            	 try {
								baidujta.setText(mainUI.this.DictionyService.GetMeaning(inputjtf.getText()));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		            	 youdaojta.setText(mainUI.this.DictionyService.youdaoGetMeaning(inputjtf.getText()));
		            	 try {
								jinshanjta.setText(mainUI.this.DictionyService.biyingGetMeaning(inputjtf.getText()));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		            	 jf.repaint();
 			          }
 			          }
          });          
         jf.add(searchjb);       
         
         /** haslogin Button **/        
         ImageIcon icon6 = new ImageIcon("2.png");
         hasloginjb.setIcon(icon6);
         hasloginjb.setBounds(470,40,20,20);
         hasloginjb.setBackground(c); 
         hasloginjb.setBorderPainted(false);
         hasloginjb.setOpaque(false);
         hasloginjb.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				/* Here writes the code of logout */	
				jf.remove(hasloginjb);
				jf.add(loginjb);	
				try {
					mainUI.this.DictionyService.logout(username);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				use.setText("未登录");
				mainUI.this.username=null;
				
				jf.repaint();
			}        	 
         });
        //jf.add(hasloginjb);       
	}

	/*public  static void  main(String[] args) throws IOException{
		new mainUI();	
	}*/	
}	