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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
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

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.util.logging.Level;
import java.util.logging.Logger;



public class EncCertPanel extends JFrame {
	public String miwen;
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
        titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(178, 178, 178)), "�������");
        titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(165, 163, 151)), "��־��Ϣ");
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
           
        jl1.setText("֤�������alias��");
        jl1.setBounds(new Rectangle(25, 40, 150, 25));       
        jtf1.setBounds(new Rectangle(200, 40, 150, 25));     
        
        jl2.setText("֤�����루keypass��");
        jl2.setBounds(new Rectangle(375, 40, 200, 25));       
        jtf2.setBounds(new Rectangle(600, 40, 150, 25));     

        jl3.setText("����������ܵ���Ϣ��");
        jl3.setBounds(new Rectangle(25, 80, 150, 25));       
        jtf3.setBounds(new Rectangle(200, 80, 250, 25));
        
        jb1.setText("���ù�Կ����Ϣ���м���");
        jb1.setBounds(new Rectangle(25, 120, 200, 25)); 
        jb1.setToolTipText("��Ӧ��jb1��ť");
        //jtf4.setBounds(new Rectangle(200, 120, 150, 25));      
        
        jb2.setText("����˽Կ�����Ľ��н���");
        jb2.setBounds(new Rectangle(375, 120, 200, 25));
        jb2.setToolTipText("��Ӧ��jb2��ť");
        //jtf5.setBounds(new Rectangle(600, 120, 150, 25));
        
        jl4.setText("���ܺ�õ���������Ϣ��");
        jl4.setBounds(new Rectangle(25, 160, 150, 25));       
        jtf4.setBounds(new Rectangle(200, 160, 250, 25));
              
        info.setBorder(null);
        info.setText("");
        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        info.setEditable(false);
 
        jScrollPane.getViewport().setBackground(new Color(222, 235, 255));

        jPanel3.setLayout(flowLayout1);  
        
        infout.setText("������־");       
        infout.setFont(new java.awt.Font("Dialog", 0, 14));
        infout.setToolTipText("��TXT�ĵ���ʽ�������Ļ������ļ�");
         
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
				/*�����ù�Կ����Ϣ���м��ܡ���ť���ܴ���
				 * 
				 * 1�������ж��������Ƿ�Ϸ�
				 * 
				 * 2������Կ���ж�ȡ֤��
				 * 	 java.security.cert.Certificate c1 = ks.getCertificate(alias);//����Կ���ȡ֤��
				 *   RSAPublicKey capuk = (RSAPublicKey)c1.getPublicKey();//����Կ���ȡ֤��Ĺ�Կ
				 *   
				 * 3�����ø�֤���RSA�����㷨��������Ĵ�������Ϣ���м��ܣ��õ�����
				 * 	 ��ȡ��Կ�Ĳ���e,n
				 *   BigInteger e = capuk.getPublicExponent();
				 *   BigInteger n = capuk.getModulus();
				 *   ���ù�Կ������������Ϣ���õ�����
				 */
				if(jtf1.getText().isEmpty() || jtf2.getText().isEmpty() || jtf3.getText().isEmpty())
				{
					info.setText("�������Ϊ�գ����������룡");
					JOptionPane.showMessageDialog(null,"�������Ϊ�գ����������룡","��ʾ",JOptionPane.OK_OPTION);
				}
				String name = "E:\\mykeytool.keystore";
		        char[] storepass = "222222".toCharArray();
		        KeyStore ks = null;
				try {
					ks = KeyStore.getInstance("JKS");
				} catch (KeyStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				FileInputStream in = null;
				try {
					in = new FileInputStream(name);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		        try {
					ks.load(in, storepass);
				} catch (NoSuchAlgorithmException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (CertificateException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				java.security.cert.Certificate c1 = null;
				try {
					c1 = ks.getCertificate(jtf1.getText());
				} catch (KeyStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        RSAPublicKey  capuk = (RSAPublicKey)c1.getPublicKey();
		        BigInteger e = capuk.getPublicExponent();
		        BigInteger n = capuk.getModulus();    
		        byte[] ptext = null;
				try {
					ptext = jtf3.getText().getBytes("UTF8");
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        BigInteger m = new BigInteger(ptext);
	            BigInteger c = m.modPow(e, n);	            
	            miwen = c.toString();
	            info.setText(miwen);
				JOptionPane.showMessageDialog(null,"��Ϣ�Ѽ���","��ʾ",JOptionPane.OK_OPTION);
			}
        }
        );

        jPanel1.add(jb2);
        jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				/*������˽Կ�����Ľ��н��ܡ���ť���ܴ���
				 * 
				 * 1������Կ���ȡ֤��
				 *   RSAPrivateKey caprk = (RSAPrivateKey)ks.getKey(alias, cakeypass);//����Կ���ȡ֤���˽Կ
				 * 
				 * 2�����ø�֤���RSA�����㷨�������Ľ��н��ܣ��õ�����
				 *   ��ȡ˽Կ�Ĳ���d��n2
				 *   BigInteger d = caprk.getPrivateExponent();
				 *   BigInteger n2 = caprk.getModulus();
				 *   ����˽Կ�������������ģ��õ�����
				 */
				String name = "E:\\mykeytool.keystore";
		        char[] storepass = "222222".toCharArray();
		        KeyStore ks = null;
				try {
					ks = KeyStore.getInstance("JKS");
				} catch (KeyStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				FileInputStream in = null;
				try {
					in = new FileInputStream(name);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		        try {
					ks.load(in, storepass);
				} catch (NoSuchAlgorithmException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (CertificateException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				RSAPrivateKey caprk = null;
				try {
					caprk = (RSAPrivateKey)ks.getKey(jtf1.getText(), jtf2.getText().toCharArray());
				} catch (UnrecoverableKeyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (KeyStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BigInteger d = caprk.getPrivateExponent();
				BigInteger n = caprk.getModulus();
		        //BigInteger p = caprk.getPrimeP();
		        //BigInteger q = caprk.getPrimeQ();
				BigInteger c = new BigInteger(miwen);        
		        BigInteger m=c.modPow(d,n);
		        byte[] mt=m.toByteArray();
		        StringBuffer mingwen= new StringBuffer();
		        for(int i=0;i<mt.length;i++){
		            mingwen.append((char)mt[i]);
		        }
		        jtf4.setText(mingwen.toString());
				JOptionPane.showMessageDialog(null,"��Ϣ�ѽ���","��ʾ",JOptionPane.OK_OPTION);
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
