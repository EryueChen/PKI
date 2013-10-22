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
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.CertificateFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
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

public class EncCertPanel extends JFrame {
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
    
    JTextField jtf1 = new JTextField();
    JTextField jtf2 = new JTextField();
    JTextField jtf3 = new JTextField();
    JTextField jtf4 = new JTextField();

    
    JButton jb1 = new JButton();
    JButton jb2 = new JButton();
    

    public EncCertPanel() {
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

        jl3.setText("请输入待加密的消息：");
        jl3.setBounds(new Rectangle(25, 80, 150, 25));       
        jtf3.setBounds(new Rectangle(200, 80, 250, 25));
        
        jb1.setText("利用公钥对消息进行加密");
        jb1.setBounds(new Rectangle(25, 120, 200, 25)); 
        jb1.setToolTipText("对应于jb1按钮");
        //jtf4.setBounds(new Rectangle(200, 120, 150, 25));      
        
        jb2.setText("利用私钥对密文进行解密");
        jb2.setBounds(new Rectangle(375, 120, 200, 25));
        jb2.setToolTipText("对应于jb2按钮");
        //jtf5.setBounds(new Rectangle(600, 120, 150, 25));
        
        jl4.setText("解密后得到的明文消息：");
        jl4.setBounds(new Rectangle(25, 160, 150, 25));       
        jtf4.setBounds(new Rectangle(200, 160, 250, 25));
              
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

        
        jPanel1.add(jb1);
        jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				/*“利用公钥对消息进行加密”按钮功能代码
				 * 
				 * 1、首先判断输入项是否合法
				 * 
				 * 2、从密钥库中读取证书
				 * 	 java.security.cert.Certificate c1 = ks.getCertificate(alias);//从密钥库读取证书
				 *   RSAPublicKey capuk = (RSAPublicKey)c1.getPublicKey();//从密钥库读取证书的公钥
				 *   
				 * 3、利用该证书的RSA加密算法，对输入的待加密信息进行加密，得到密文
				 * 	 获取公钥的参数e,n
				 *   BigInteger e = capuk.getPublicExponent();
				 *   BigInteger n = capuk.getModulus();
				 *   利用公钥参数来加密信息，得到密文
				 */
				JOptionPane.showMessageDialog(null,"该按钮对应于EncCertPanel.java中的jb1按钮","请编写该按钮功能代码",JOptionPane.OK_OPTION);
			}
        }
        );


        jPanel1.add(jb2);
        jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				/*“利用私钥对密文进行解密”按钮功能代码
				 * 
				 * 1、从密钥库读取证书
				 *   RSAPrivateKey caprk = (RSAPrivateKey)ks.getKey(alias, cakeypass);//从密钥库读取证书的私钥
				 * 
				 * 2、利用该证书的RSA解密算法，对密文进行解密，得到明文
				 *   获取私钥的参数d，n2
				 *   BigInteger d = caprk.getPrivateExponent();
				 *   BigInteger n2 = caprk.getModulus();
				 *   利用私钥参数来解密密文，得到明文
				 */
				JOptionPane.showMessageDialog(null,"该按钮对应于EncCertPanel.java中的jb2按钮","请编写该按钮功能代码",JOptionPane.OK_OPTION);
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
        EncCertPanel encpanel = new EncCertPanel();
        encpanel.setVisible(true);
    }

}
