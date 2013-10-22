package PKI_EX_Stu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.CertificateFactory;
import java.util.Date;

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

import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateIssuerName;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateValidity;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;

public class SignCertPanel extends JFrame {
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
    JLabel jl3 = new JLabel();
    JLabel jl4 = new JLabel();
    JLabel jl5 = new JLabel();
    JLabel jl6 = new JLabel();
    JLabel jl7 = new JLabel();
    JLabel jl8 = new JLabel();
    JLabel jl9 = new JLabel();
    
    JTextField jtf1 = new JTextField();
    JTextField jtf2 = new JTextField();
    JTextField jtf3 = new JTextField();
    JTextField jtf4 = new JTextField();
    JTextField jtf5 = new JTextField();
    JTextField jtf6 = new JTextField();
    JTextField jtf7 = new JTextField();
    JTextField jtf8 = new JTextField();
    JTextField jtf9 = new JTextField();
    
    JButton jb1 = new JButton();
    JButton jb2 = new JButton();
    
    String filepath = new String();
    
    public SignCertPanel() {
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
           
        jl1.setText("CA证书别名（CA alias）");
        jl1.setBounds(new Rectangle(25, 40, 150, 25));       
        jtf1.setBounds(new Rectangle(200, 40, 150, 25));     
        
        jl2.setText("CA证书密码（CA keypass）");
        jl2.setBounds(new Rectangle(375, 40, 200, 25));       
        jtf2.setBounds(new Rectangle(600, 40, 150, 25));     

        jb1.setText("选择待签发的证书");
        jb1.setBounds(new Rectangle(25, 80, 150, 25));       
        jtf3.setBounds(new Rectangle(200, 80, 150, 25));
        
        jl9.setText("待签发证书别名（alias）");
        jl9.setBounds(new Rectangle(25, 120, 200, 25));       
        jtf9.setBounds(new Rectangle(200, 120, 150, 25));      
        
        jl4.setText("待签发证书密码（keypass）");
        jl4.setBounds(new Rectangle(375, 120, 200, 25));       
        jtf4.setBounds(new Rectangle(600, 120, 150, 25));
        
        jl5.setText("设置签发后证书新密码");
        jl5.setBounds(new Rectangle(25, 160, 150, 25));       
        jtf5.setBounds(new Rectangle(200, 160, 150, 25));
        
        jl6.setText("确认新密码（confirm keypass）");
        jl6.setBounds(new Rectangle(375, 160, 200, 25));       
        jtf6.setBounds(new Rectangle(600, 160, 150, 25));
        
        jl7.setText("设置签发后证书新别名");
        jl7.setBounds(new Rectangle(25, 200, 150, 25));       
        jtf7.setBounds(new Rectangle(200, 200, 150, 25));
        
        jl8.setText("设置签发后证书新有效期");
        jl8.setBounds(new Rectangle(375, 200, 200, 25));       
        jtf8.setBounds(new Rectangle(600, 200, 150, 25));       
        
        jb2.setText("签发证书");
        jb2.setBounds(new Rectangle(300, 235, 100, 25));
        jb2.setToolTipText("对应于jb2按钮");
        
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
        jPanel1.add(jl3);
        jPanel1.add(jtf3);
        jPanel1.add(jl4);
        jPanel1.add(jtf4);
        jPanel1.add(jl5);
        jPanel1.add(jtf5);
        jPanel1.add(jl6);
        jPanel1.add(jtf6);
        jPanel1.add(jl7);
        jPanel1.add(jtf7);
        jPanel1.add(jl8);
        jPanel1.add(jtf8);
        jPanel1.add(jl9);
        jPanel1.add(jtf9);
        
        jPanel1.add(jb1);
        jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				JFileChooser chooser=new JFileChooser();
				chooser.setDialogType(JFileChooser.OPEN_DIALOG);
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int i=chooser.showDialog(null,null);
				if(i==JFileChooser.APPROVE_OPTION)
				{
					filepath = chooser.getSelectedFile().getAbsolutePath().toString();
					String filename = chooser.getSelectedFile().getName();
					if(!filepath.substring(filepath.length()-4).toLowerCase().equals(".cer"))
					{
						info.setText("不是证书文件！");
						JOptionPane.showMessageDialog(null,"不是证书文件！","提示",JOptionPane.OK_OPTION); 
					}
						
					else
						jtf3.setText(filename);  
				}	
			}
        }
        );


        jPanel1.add(jb2);
        jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
		        /*“签发证书”按钮功能代码
		         * 
		         * 1、判断输入项是否合法
		         * "输入项不能为空，请重新输入！"
		         * "两次输入密码不相同，请您重新输入密码！"
		         * 
		         * 2、密钥库的选择与密钥库的存储密码选择
		         *  String name = "mykeystore.keystore";//密钥库的选择
		         *  char[] storepass = "117117".toCharArray();//密钥库的存储密码选择
		         * 
		         * 3、从密钥库读取CA的证书
		         *   java.security.cert.Certificate c1 = ks.getCertificate(alias);//从密钥库读取CA的证书
		         *   PrivateKey caprk = (PrivateKey)ks.getKey(alias, cakeypass);//从密钥库读取CA的私钥
		         *   从CA的证书中提取签发者信息
		         *   可能利用以下几个类：X509CertImpl，X509CertInfo，X500Name
		         *   
		         * 4、获取待签发的证书(利用jb1按钮功能代码中的filepath)
		         * 	 CertificateFactory cf = CertificateFactory.getInstance("X.509");
		         *   FileInputStream in2 = new FileInputStream(filepath);
		         *   java.security.cert.Certificate c2 = cf.generateCertificate(in2);
		         *   in2.close();
		         *   从待签发的证书提取证书信息（与提取CA证书信息类似）
		         * 
		         * 5、设置新证书有效期
		         *   cinfo2.set(X509CertInfo.VALIDITY, cv);
		         *   设置新证书序列号
		         *   cinfo2.set(X509CertInfo.SERIAL_NUMBER, csn);
		         *   设置新证书签发者
		         *   cinfo2.set(X509CertInfo.ISSUER + "." +CertificateIssuerName.DN_NAME, issuer);
		         *   设置新证书算法信息
		         *   cinfo2.set(CertificateAlgorithmId.NAME + "." + CertificateAlgorithmId.ALGORITHM, algorithm);
		         * 
		         * 6、创建证书并使用CA的私钥对其签名
		         *   newcert.sign(caprk, "MD5WithRSA");
		         *   将新证书存入密钥库
		         */
				JOptionPane.showMessageDialog(null,"该按钮对应于SignCertPanel.java中的jb2按钮","提请编写该按钮功能代码",JOptionPane.OK_OPTION);
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
        SignCertPanel signpanel = new SignCertPanel();
        signpanel.setVisible(true);
    }

}
