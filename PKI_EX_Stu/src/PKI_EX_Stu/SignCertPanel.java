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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
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

import java.security.*;
import java.io.*;
import java.util.*;
import java.security.*;
import java.security.cert.*;
import sun.security.x509.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;

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
           
        jl1.setText("CA֤�������CA alias��");
        jl1.setBounds(new Rectangle(25, 40, 150, 25));       
        jtf1.setBounds(new Rectangle(200, 40, 150, 25));     
        
        jl2.setText("CA֤�����루CA keypass��");
        jl2.setBounds(new Rectangle(375, 40, 200, 25));       
        jtf2.setBounds(new Rectangle(600, 40, 150, 25));     

        jb1.setText("ѡ���ǩ����֤��");
        jb1.setBounds(new Rectangle(25, 80, 150, 25));       
        jtf3.setBounds(new Rectangle(200, 80, 150, 25));
        
        jl9.setText("��ǩ��֤�������alias��");
        jl9.setBounds(new Rectangle(25, 120, 200, 25));       
        jtf9.setBounds(new Rectangle(200, 120, 150, 25));      
        
        jl4.setText("��ǩ��֤�����루keypass��");
        jl4.setBounds(new Rectangle(375, 120, 200, 25));       
        jtf4.setBounds(new Rectangle(600, 120, 150, 25));
        
        jl5.setText("����ǩ����֤��������");
        jl5.setBounds(new Rectangle(25, 160, 150, 25));       
        jtf5.setBounds(new Rectangle(200, 160, 150, 25));
        
        jl6.setText("ȷ�������루confirm keypass��");
        jl6.setBounds(new Rectangle(375, 160, 200, 25));       
        jtf6.setBounds(new Rectangle(600, 160, 150, 25));
        
        jl7.setText("����ǩ����֤���±���");
        jl7.setBounds(new Rectangle(25, 200, 150, 25));       
        jtf7.setBounds(new Rectangle(200, 200, 150, 25));
        
        jl8.setText("����ǩ����֤������Ч��");
        jl8.setBounds(new Rectangle(375, 200, 200, 25));       
        jtf8.setBounds(new Rectangle(600, 200, 150, 25));       
        
        jb2.setText("ǩ��֤��");
        jb2.setBounds(new Rectangle(300, 235, 100, 25));
        jb2.setToolTipText("��Ӧ��jb2��ť");
        
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
						info.setText("����֤���ļ���");
						JOptionPane.showMessageDialog(null,"����֤���ļ���","��ʾ",JOptionPane.OK_OPTION); 
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
		        /*��ǩ��֤�顱��ť���ܴ���
		         * 
		         * 1���ж��������Ƿ�Ϸ�
		         * "�������Ϊ�գ����������룡"
		         * "�����������벻��ͬ�����������������룡"
		         * 
		         * 2����Կ���ѡ������Կ��Ĵ洢����ѡ��
		         *  String name = "mykeystore.keystore";//��Կ���ѡ��
		         *  char[] storepass = "117117".toCharArray();//��Կ��Ĵ洢����ѡ��
		         * 
		         * 3������Կ���ȡCA��֤��
		         *   java.security.cert.Certificate c1 = ks.getCertificate(alias);//����Կ���ȡCA��֤��
		         *   PrivateKey caprk = (PrivateKey)ks.getKey(alias, cakeypass);//����Կ���ȡCA��˽Կ
		         *   ��CA��֤������ȡǩ������Ϣ
		         *   �����������¼����ࣺX509CertImpl��X509CertInfo��X500Name
		         *   
		         * 4����ȡ��ǩ����֤��(����jb1��ť���ܴ����е�filepath)
		         * 	 CertificateFactory cf = CertificateFactory.getInstance("X.509");
		         *   FileInputStream in2 = new FileInputStream(filepath);
		         *   java.security.cert.Certificate c2 = cf.generateCertificate(in2);
		         *   in2.close();
		         *   �Ӵ�ǩ����֤����ȡ֤����Ϣ������ȡCA֤����Ϣ���ƣ�
		         * 
		         * 5��������֤����Ч��
		         *   cinfo2.set(X509CertInfo.VALIDITY, cv);
		         *   ������֤�����к�
		         *   cinfo2.set(X509CertInfo.SERIAL_NUMBER, csn);
		         *   ������֤��ǩ����
		         *   cinfo2.set(X509CertInfo.ISSUER + "." +CertificateIssuerName.DN_NAME, issuer);
		         *   ������֤���㷨��Ϣ
		         *   cinfo2.set(CertificateAlgorithmId.NAME + "." + CertificateAlgorithmId.ALGORITHM, algorithm);
		         * 
		         * 6������֤�鲢ʹ��CA��˽Կ����ǩ��
		         *   newcert.sign(caprk, "MD5WithRSA");
		         *   ����֤�������Կ��
		         */
				if(jtf1.getText().isEmpty() || jtf2.getText().isEmpty() || jtf3.getText().isEmpty() || jtf4.getText().isEmpty() ||
						jtf5.getText().isEmpty() || jtf6.getText().isEmpty() || jtf7.getText().isEmpty() || jtf8.getText().isEmpty())
				{
					info.setText("�������Ϊ�գ����������룡");
					JOptionPane.showMessageDialog(null,"�������Ϊ�գ����������룡","��ʾ",JOptionPane.OK_OPTION);
				}
				if(!jtf5.getText().equals(jtf6.getText())){
					info.setText("�����������벻��ͬ�����������������룻");
					JOptionPane.showMessageDialog(null, "�����������벻��ͬ������������������", "��ʾ", JOptionPane.OK_OPTION);
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
		        PrivateKey caprk = null;
				try {
					caprk = (PrivateKey)ks.getKey(jtf1.getText(), jtf2.getText().toCharArray());
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
		        byte[] encod1 = null;
				try {
					encod1 = c1.getEncoded();
				} catch (CertificateEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        X509CertImpl cimp1 = null;
				try {
					cimp1 = new X509CertImpl(encod1);
				} catch (CertificateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        X509CertInfo cinfo1 = null;
				try {
					cinfo1 = (X509CertInfo)cimp1.get(X509CertImpl.NAME+"."+X509CertImpl.INFO);
				} catch (CertificateParsingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        X500Name issuer = null;
				try {
					issuer = (X500Name)cinfo1.get(X509CertInfo.SUBJECT+"."+CertificateIssuerName.DN_NAME);
				} catch (CertificateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        CertificateFactory cf = null;
				try {
					cf = CertificateFactory.getInstance("X.509");
				} catch (CertificateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        FileInputStream in2 = null;
				try {
					in2 = new FileInputStream(filepath);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        java.security.cert.Certificate c2 = null;
				try {
					c2 = cf.generateCertificate(in2);
				} catch (CertificateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try {
					in2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        byte[] encod2 = null;
				try {
					encod2 = c2.getEncoded();
				} catch (CertificateEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        X509CertImpl cimp2 = null;
				try {
					cimp2 = new X509CertImpl(encod2);
				} catch (CertificateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        X509CertInfo cinfo2 = null;
				try {
					cinfo2 = (X509CertInfo)cimp2.get(X509CertImpl.NAME+"."+X509CertImpl.INFO);
				} catch (CertificateParsingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		        Date begindate=new Date();
		        Date enddate=new Date(begindate.getTime()+Integer.parseInt(jtf8.getText())*24*60*60*1000L);
		        CertificateValidity cv=new CertificateValidity(begindate,enddate); 
		        try {
					cinfo2.set(X509CertInfo.VALIDITY, cv);
				} catch (CertificateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        int sn=(int)(begindate.getTime()/1000);
		        CertificateSerialNumber csn=new CertificateSerialNumber(sn);
		        try {
					cinfo2.set(X509CertInfo.SERIAL_NUMBER,csn);
				} catch (CertificateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try {
					cinfo2.set(X509CertInfo.ISSUER + "." +CertificateIssuerName.DN_NAME, issuer);
				} catch (CertificateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        AlgorithmId algorithm=new AlgorithmId(AlgorithmId.md5WithRSAEncryption_oid);
		        try {
					cinfo2.set(CertificateAlgorithmId.NAME + "." + CertificateAlgorithmId.ALGORITHM, algorithm);
				} catch (CertificateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        X509CertImpl newcert=new X509CertImpl(cinfo2);
		        try {
					newcert.sign(caprk, "MD5WithRSA");
				} catch (InvalidKeyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CertificateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchProviderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SignatureException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try {
					ks.setCertificateEntry(jtf7.getText(),newcert);
				} catch (KeyStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        FileOutputStream out = null;
				try {
					out = new FileOutputStream(name);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try {
					ks.store(out,storepass);
				} catch (KeyStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CertificateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
		        JOptionPane.showMessageDialog(null,"֤����ǩ��","֤��ǩ��",JOptionPane.OK_OPTION);
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
