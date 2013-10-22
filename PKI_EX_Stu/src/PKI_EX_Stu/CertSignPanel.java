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

        jb1.setText("��ѡ����Ҫ����ժҪ���ļ�");
        jb1.setBounds(new Rectangle(25, 80, 200, 25));       
        jtf3.setBounds(new Rectangle(250, 80, 200, 25));
        
        jb2.setText("��ѡ���ļ���ʼ����ժҪ");
        jb2.setBounds(new Rectangle(25, 120, 200, 25));       
        jtf4.setBounds(new Rectangle(250, 120, 200, 25));      
        
        jb3.setText("����˽Կ��ժҪ�ļ�����ǩ��");
        jb3.setBounds(new Rectangle(25, 160, 250, 25));
        jb3.setToolTipText("��Ӧ��jb3��ť");
        jtf5.setBounds(new Rectangle(300, 160, 200, 25));
        
        jb4.setText("���ù�Կ��ǩ���ļ�������֤");
        jb4.setBounds(new Rectangle(25, 200, 250, 25));
        jb4.setToolTipText("��Ӧ��jb4��ť");
        jtf6.setBounds(new Rectangle(300, 200, 200, 25));
              
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
        jPanel1.add(jtf3);       
        jPanel1.add(jtf4);
        jPanel1.add(jtf5);       
        jPanel1.add(jtf6);

        
        jPanel1.add(jb1);
        jb1.addActionListener(new ActionListener(){
        	//ѡ���ժҪ�ļ�
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
        	//ժҪѡ���ļ�
			public void actionPerformed(ActionEvent event){				
				if(jtf3.getText().isEmpty())
				{
					info.setText("�������Ϊ�գ����������룡");
					JOptionPane.showMessageDialog(null,"�������Ϊ�գ����������룡","��ʾ",JOptionPane.OK_OPTION);
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
				        System.out.println("���ļ�����ժҪ��Ľ����");
				        System.out.println(result);
				        
				        FileOutputStream f4 = new FileOutputStream("digest.dat");
				        f4.write(result.getBytes());
				        //System.out.println("");
				        info.setText("�ļ�ժҪ����");
				        System.out.println("�ļ�ժҪ����");
				        jtf4.setText("digest.dat");
					}catch (Exception e){e.printStackTrace();}
				}
			}
		    
		});
        

        jPanel1.add(jb3);
        jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){	
				/*������˽Կ��ժҪ�ļ�����ǩ������ť���ܴ���
				 * 
				 * 1���ж��������Ƿ�Ϸ�
				 * 				 
				 * 2������Կ���ȡ֤�� 
				 *   java.security.cert.Certificate c1 = ks.getCertificate(alias);//����Կ���ȡ֤��
				 *   PrivateKey caprk = (PrivateKey)ks.getKey(alias, cakeypass);//����Կ���ȡ֤���˽Կ
				 * 
				 * 3������֤��˽Կ��ժҪ��ť��jb2�����ɵ�ժҪ�ļ���digest.dat������ǩ�����õ�ǩ���ļ���Sign.dat��  
				 *   ����Signature��
				 *   
				 */
				JOptionPane.showMessageDialog(null,"�ð�ť��Ӧ��CertSignPanel.java�е�jb3��ť","���д�ð�ť���ܴ���",JOptionPane.OK_OPTION);
			}	    
		});
        
        jPanel1.add(jb4);
        jb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				/*�����ù�Կ��ǩ���ļ�������֤����ť���ܴ���
				 * 
				 * 1���ж��������Ƿ�Ϸ�
				 * 				 
				 * 2������Կ���ȡ֤�� 
				 *   java.security.cert.Certificate c1 = ks.getCertificate(alias);//����Կ���ȡ֤��
				 *   PublicKey pk=c1.getPublicKey();//����Կ���ȡ֤��Ĺ�Կ
				 * 
				 * 3������֤�鹫Կ��ǩ���ļ���Sign.dat����������ǩ������֤  
				 *   ����Signature��
				 *   
				 */		
				JOptionPane.showMessageDialog(null,"�ð�ť��Ӧ��CertSignPanel.java�е�jb4��ť","���д�ð�ť���ܴ���",JOptionPane.OK_OPTION);
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

