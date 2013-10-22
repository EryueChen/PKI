package PKI_EX_Stu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

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

public class RegCertPanel extends JFrame {
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
    JLabel jl10 = new JLabel();
    
    JTextField jtf1 = new JTextField();
    JTextField jtf2 = new JTextField();
    JTextField jtf3 = new JTextField();
    JTextField jtf4 = new JTextField();
    JTextField jtf5 = new JTextField();
    JTextField jtf6 = new JTextField();
    JTextField jtf7 = new JTextField();
    JTextField jtf8 = new JTextField();
    JTextField jtf9 = new JTextField();
    JTextField jtf10 = new JTextField();
    
    JButton jb1 = new JButton();
    JButton jb2 = new JButton();
    
    
    public RegCertPanel() {
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

        jl1.setText("ע������CN��");
        jl1.setBounds(new Rectangle(25, 40, 150, 25));       
        jtf1.setBounds(new Rectangle(200, 40, 150, 25));     
        
        jl2.setText("������alias��");
        jl2.setBounds(new Rectangle(375, 40, 200, 25));       
        jtf2.setBounds(new Rectangle(600, 40, 150, 25));     

        jl3.setText("���루keypass��");
        jl3.setBounds(new Rectangle(25, 80, 150, 25));       
        jtf3.setBounds(new Rectangle(200, 80, 150, 25));
        
        jl4.setText("ȷ�����루confirm keypass��");
        jl4.setBounds(new Rectangle(375, 80, 200, 25));       
        jtf4.setBounds(new Rectangle(600, 80, 150, 25));
        
        jl5.setText("��֯��λ���ƣ�OU��");
        jl5.setBounds(new Rectangle(25, 120, 150, 25));       
        jtf5.setBounds(new Rectangle(200, 120, 150, 25));
        
        jl6.setText("��֯���ƣ�O��");
        jl6.setBounds(new Rectangle(375, 120, 200, 25));       
        jtf6.setBounds(new Rectangle(600, 120, 150, 25));
        
        jl7.setText("���ڳ��л��������ƣ�L��");
        jl7.setBounds(new Rectangle(25, 160, 150, 25));       
        jtf7.setBounds(new Rectangle(200, 160, 150, 25));
        
        jl8.setText("���ڵ��ݻ���ʡ�����ƣ�ST��");
        jl8.setBounds(new Rectangle(375, 160, 200, 25));       
        jtf8.setBounds(new Rectangle(600, 160, 150, 25));
        
        jl9.setText("���ڹ��ң�C��");
        jl9.setBounds(new Rectangle(25, 200, 150, 25));       
        jtf9.setBounds(new Rectangle(200, 200, 150, 25));
        
        jl10.setText("֤����Ч�ڣ�validity��");
        jl10.setBounds(new Rectangle(375, 200, 200, 25));       
        jtf10.setBounds(new Rectangle(600, 200, 150, 25));
        
        jb1.setText("����֤��");
        jb1.setBounds(new Rectangle(250, 235, 100, 25));
        jb1.setToolTipText("��Ӧ��jb1��ť");
        
        jb2.setText("����֤��");
        jb2.setBounds(new Rectangle(375, 235, 100, 25));
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
        jPanel1.add(jl10);
        jPanel1.add(jtf10);
              
        jPanel1.add(jb1);
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				/*������֤�顱��ť���ܴ���
				 * 
				 *1�������ж��������Ƿ�Ϸ��� 
				 * "�������Ϊ�գ����������룡"
				 * "�����������벻��ͬ�����������������룡"
				 * "����λ��С��6�����������������룡"
				 * "��Ч����Ҫ������������"
				 * 
				 *2����������Ϸ������������֤�������
				 *  ����keytool������֤��
				 *  ��������ΪRSA�㷨���洢��mykeystore.keystore�����ô洢����Ϊ117117
				 *  keytool -genkey -keyalg RSA -keystore mykeystore.keystore -storepass 117117
				 *  ����������ο�keytool�Ĳ�������
				 */
				if(jtf1.getText().isEmpty() || jtf2.getText().isEmpty() || jtf3.getText().isEmpty() || jtf4.getText().isEmpty() ||
						jtf5.getText().isEmpty() || jtf6.getText().isEmpty() || jtf7.getText().isEmpty() || jtf8.getText().isEmpty() ||
						jtf9.getText().isEmpty() || jtf10.getText().isEmpty())
				{
					info.setText("�������Ϊ�գ����������룡");
					JOptionPane.showMessageDialog(null,"�������Ϊ�գ����������룡","��ʾ",JOptionPane.OK_OPTION);
				}
				else if(!jtf3.getText().equals(jtf4.getText())){
					info.setText("�����������벻��ͬ�����������������룻");
					JOptionPane.showMessageDialog(null, "�����������벻��ͬ������������������", "��ʾ", JOptionPane.OK_OPTION);
				}
				else if(jtf3.getText().length() < 6){
					info.setText("����λ��С��6�����������������룡");
					JOptionPane.showMessageDialog(null, "����λ��С��6�����������������룡", "��ʾ", JOptionPane.OK_OPTION);
				}
				else if(!jtf10.getText().matches("[0-9]+")){
					info.setText("��Ч����Ҫ������������");
					JOptionPane.showMessageDialog(null, "��Ч����Ҫ������������", "��ʾ", JOptionPane.OK_OPTION);
				}else{
					StringBuffer cmd = new StringBuffer();  
					cmd.append("C:\\Progra~1\\JAVA\\jdk1.7.0_21\\bin\\keytool -genkey -v -keyalg RSA");  
					cmd.append(" -keystore E:\\mykeytool.keystore");
					cmd.append(" -alias ");
					cmd.append(jtf2.getText());
					cmd.append(" -keypass ");
					cmd.append(jtf3.getText());
					cmd.append(" -storepass 222222");
					cmd.append(" -validity ");
					cmd.append(jtf10.getText());
					cmd.append(" -dname \"CN=");
					cmd.append(jtf1.getText());
					cmd.append(",OU=");
					cmd.append(jtf5.getText());
					cmd.append(",O=");
					cmd.append(jtf6.getText());
					cmd.append(",L=");
					cmd.append(jtf7.getText());
					cmd.append(",ST=");
					cmd.append(jtf8.getText());
					cmd.append(",C=");
					cmd.append(jtf9.getText());
					cmd.append("\"");
					info.setText(cmd.toString());
					Runtime r = Runtime.getRuntime();
					try {
						Process p = r.exec(cmd.toString());
						try {
							p.waitFor();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
						String str = null;
						while ((str = reader.readLine()) != null) {
							info.append(str);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"֤��������ɹ�","֤������",JOptionPane.OK_OPTION);
				}
			}
		});
        jPanel1.add(jb2);
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				/*������֤�顱��ť���ܴ���
				 * 
				 *1������֤�������alias��
				 *  ���������֤�������alias��ѡ����Ҫ������֤��
				 *  ����keytool����Կ�����浼��֤��
				 * 
				 */
				String aliasstr = JOptionPane.showInputDialog("������֤�������alias��");
				StringBuffer command = new StringBuffer();
				command.append("C:\\Progra~1\\JAVA\\jdk1.7.0_21\\bin\\keytool -export -alias ");
				command.append(aliasstr);
				command.append(" -file E:\\");
				command.append(aliasstr);
				command.append(".cer");
				command.append(" -keystore E:\\mykeytool.keystore -storepass 222222\n");
				Runtime rx = Runtime.getRuntime();
				try {
					rx.exec(command.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"֤���ѵ���","֤�鵼��",JOptionPane.OK_OPTION);
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
        RegCertPanel regpanel = new RegCertPanel();
        regpanel.setVisible(true);
    }

}
