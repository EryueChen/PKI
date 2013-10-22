package PKI_EX_Stu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class CertSignPanel extends JFrame {
    BorderLayout borderLayout1 = new BorderLayout();
    BorderLayout borderLayout2 = new BorderLayout();
    FlowLayout flowLayout1 = new FlowLayout(FlowLayout.RIGHT);   
    JSplitPane jSplitPane;    
    JPanel jPanel1 = new JPanel();
    TitledBorder titledBorder1;
    JPanel jPanel2 = new JPanel();
    JScrollPane jScrollPane = new JScrollPane();
    TitledBorder titledBorder2;
    JTextArea info = new JTextArea(4, 15);
    JPanel jPanel3 = new JPanel();
    JButton infout = new JButton();

    JLabel jl1 = new JLabel();
    JLabel jl2 = new JLabel();
    
    JTextField jtf1 = new JTextField();
    JTextField jtf2 = new JTextField();
    JTextField jtf3 = new JTextField();
    JTextField jtf4 = new JTextField();
    JTextField jtf5 = new JTextField();
    JTextField jtf6 = new JTextField();
    
    JButton jb1 = new JButton();
    JButton jb2 = new JButton();
    JButton jb3 = new JButton();
    JButton jb4 = new JButton();
    
    String filepath = new String();

    public CertSignPanel() {
        try {
            init(); 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    private void init() throws Exception {
        titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(178, 178, 178)), "控制面板");
        titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(165, 163, 151)), "日志信息");
        titledBorder1.setTitleFont(new java.awt.Font("Dialog", 0, 12));
        titledBorder2.setTitleFont(new java.awt.Font("Dialog", 0, 12));
      
        this.setLayout(borderLayout1);
        this.setBackground(new Color(222, 235, 255));
        this.setSize(800, 640);  
    
        jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, false, jPanel1, jPanel2);
        jSplitPane.setBackground(new Color(222, 235, 255));
        jSplitPane.setDividerLocation(270);
        jSplitPane.setDividerSize(3);

        jPanel1.setLayout(null);
        jPanel1.setBackground(new Color(222, 235, 255));
        jPanel1.setFont(new java.awt.Font("Dialog", 0, 14));
        jPanel1.setBorder(titledBorder1);
        
        jPanel2.setLayout(borderLayout2);
        jPanel2.setBackground(new Color(222, 235, 255));
        jPanel2.setBorder(titledBorder2);
           
        jl1.setText("证书别名（alias）");
        jl1.setBounds(new Rectangle(25, 40, 150, 25));       
        jtf1.setBounds(new Rectangle(200, 40, 150, 25));     
        
        jl2.setText("证书密码（keypass）");
        jl2.setBounds(new Rectangle(375, 40, 200, 25));       
        jtf2.setBounds(new Rectangle(600, 40, 150, 25));     

        jb1.setText("请选择需要进行摘要的文件");
        jb1.setBounds(new Rectangle(25, 80, 200, 25));       
        jtf3.setBounds(new Rectangle(250, 80, 200, 25));
        
        jb2.setText("对选定文件开始进行摘要");
        jb2.setBounds(new Rectangle(25, 120, 200, 25));       
        jtf4.setBounds(new Rectangle(250, 120, 200, 25));      
        
        jb3.setText("利用私钥对摘要文件进行签名");
        jb3.setBounds(new Rectangle(25, 160, 250, 25));
        jb3.setToolTipText("对应于jb3按钮");
        jtf5.setBounds(new Rectangle(300, 160, 200, 25));
        
        jb4.setText("利用公钥对签名文件进行验证");
        jb4.setBounds(new Rectangle(25, 200, 250, 25));
        jb4.setToolTipText("对应于jb4按钮");
        jtf6.setBounds(new Rectangle(300, 200, 200, 25));
              
        info.setBorder(null);
        info.setText("");
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        info.setEditable(false);
 
        jScrollPane.getViewport().setBackground(new Color(222, 235, 255));

        jPanel3.setLayout(flowLayout1);  
        
        infout.setText("导出日志");       
        infout.setFont(new java.awt.Font("Dialog", 0, 14));
        infout.setToolTipText("以TXT文档形式导出明文或密文文件");
         
        jPanel1.add(jl1);
        jPanel1.add(jtf1);
        jPanel1.add(jl2);
        jPanel1.add(jtf2);
        jPanel1.add(jtf3);       
        jPanel1.add(jtf4);
        jPanel1.add(jtf5);       
        jPanel1.add(jtf6);

        
        jPanel1.add(jb1);
        jb1.addActionListener(new ActionListener(){
        	//选择待摘要文件
			public void actionPerformed(ActionEvent event){
				JFileChooser chooser=new JFileChooser();
				chooser.setDialogType(JFileChooser.OPEN_DIALOG);
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i=chooser.showDialog(null,null);
				if(i==JFileChooser.APPROVE_OPTION)
				{
					filepath = chooser.getSelectedFile().getAbsolutePath().toString();
					String filename = chooser.getSelectedFile().getName();
						jtf3.setText(filename);  
				}	
				
			}
        }
        );


        jPanel1.add(jb2);
        jb2.addActionListener(new ActionListener() {
        	//摘要选定文件
			public void actionPerformed(ActionEvent event){				
				if(jtf3.getText().isEmpty())
				{
					info.setText("输入项不能为空，请重新输入！");
					JOptionPane.showMessageDialog(null,"输入项不能为空，请重新输入！","提示",JOptionPane.OK_OPTION);
				}else{
					try{
				        FileInputStream f1 = new FileInputStream(filepath);
				        MessageDigest m = MessageDigest.getInstance("MD5");
				        DigestInputStream din = new DigestInputStream(f1,m);
				        while(din.read()!=-1);
				        byte ss[]=m.digest();
				        String result="";
				        for (int i=0;i<ss.length;i++){
				        	result += Integer.toHexString((0x000000ff & ss[i]) | 0xffffff00).substring(6);
				        }
				        System.out.println("对文件进行摘要后的结果：");
				        System.out.println(result);
				        
				        FileOutputStream f4 = new FileOutputStream("digest.dat");
				        f4.write(result.getBytes());
				        //System.out.println("");
				        info.setText("文件摘要结束");
				        System.out.println("文件摘要结束");
				        jtf4.setText("digest.dat");
					}catch (Exception e){e.printStackTrace();}
				}
			}
		    
		});
        

        jPanel1.add(jb3);
        jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){	
				/*“利用私钥对摘要文件进行签名”按钮功能代码
				 * 
				 * 1、判断输入项是否合法
				 * 				 
				 * 2、从密钥库读取证书 
				 *   java.security.cert.Certificate c1 = ks.getCertificate(alias);//从密钥库读取证书
				 *   PrivateKey caprk = (PrivateKey)ks.getKey(alias, cakeypass);//从密钥库读取证书的私钥
				 * 
				 * 3、利用证书私钥对摘要按钮（jb2）生成的摘要文件（digest.dat）进行签名，得到签名文件（Sign.dat）  
				 *   利用Signature类
				 *   
				 */
				JOptionPane.showMessageDialog(null,"该按钮对应于CertSignPanel.java中的jb3按钮","请编写该按钮功能代码",JOptionPane.OK_OPTION);
			}	    
		});
        
        jPanel1.add(jb4);
        jb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				/*“利用公钥对签名文件进行验证”按钮功能代码
				 * 
				 * 1、判断输入项是否合法
				 * 				 
				 * 2、从密钥库读取证书 
				 *   java.security.cert.Certificate c1 = ks.getCertificate(alias);//从密钥库读取证书
				 *   PublicKey pk=c1.getPublicKey();//从密钥库读取证书的公钥
				 * 
				 * 3、利用证书公钥对签名文件（Sign.dat）进行数字签名的验证  
				 *   利用Signature类
				 *   
				 */		
				JOptionPane.showMessageDialog(null,"该按钮对应于CertSignPanel.java中的jb4按钮","请编写该按钮功能代码",JOptionPane.OK_OPTION);
			}				
		});
        

        
        jPanel3.add(infout);
        jScrollPane.getViewport().add(info, null);
        jPanel2.add(jScrollPane, BorderLayout.CENTER);
        jPanel2.add(jPanel3, BorderLayout.SOUTH);

        this.add(jSplitPane, BorderLayout.CENTER);
        this.addWindowListener(
           new WindowAdapter(){
               public void windowClosing(WindowEvent e){
                  System.exit(0);        
               }        
           }        
        ); 
        
        

    }

    public static void main(String[] args) {
        CertSignPanel certsignpanel = new CertSignPanel();
        certsignpanel.setVisible(true);
    }

}

