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
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
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

        jl1.setText("注册名（CN）");
        jl1.setBounds(new Rectangle(25, 40, 150, 25));       
        jtf1.setBounds(new Rectangle(200, 40, 150, 25));     
        
        jl2.setText("别名（alias）");
        jl2.setBounds(new Rectangle(375, 40, 200, 25));       
        jtf2.setBounds(new Rectangle(600, 40, 150, 25));     

        jl3.setText("密码（keypass）");
        jl3.setBounds(new Rectangle(25, 80, 150, 25));       
        jtf3.setBounds(new Rectangle(200, 80, 150, 25));
        
        jl4.setText("确认密码（confirm keypass）");
        jl4.setBounds(new Rectangle(375, 80, 200, 25));       
        jtf4.setBounds(new Rectangle(600, 80, 150, 25));
        
        jl5.setText("组织单位名称（OU）");
        jl5.setBounds(new Rectangle(25, 120, 150, 25));       
        jtf5.setBounds(new Rectangle(200, 120, 150, 25));
        
        jl6.setText("组织名称（O）");
        jl6.setBounds(new Rectangle(375, 120, 200, 25));       
        jtf6.setBounds(new Rectangle(600, 120, 150, 25));
        
        jl7.setText("所在城市或区域名称（L）");
        jl7.setBounds(new Rectangle(25, 160, 150, 25));       
        jtf7.setBounds(new Rectangle(200, 160, 150, 25));
        
        jl8.setText("所在的州或者省份名称（ST）");
        jl8.setBounds(new Rectangle(375, 160, 200, 25));       
        jtf8.setBounds(new Rectangle(600, 160, 150, 25));
        
        jl9.setText("所在国家（C）");
        jl9.setBounds(new Rectangle(25, 200, 150, 25));       
        jtf9.setBounds(new Rectangle(200, 200, 150, 25));
        
        jl10.setText("证书有效期（validity）");
        jl10.setBounds(new Rectangle(375, 200, 200, 25));       
        jtf10.setBounds(new Rectangle(600, 200, 150, 25));
        
        jb1.setText("申请证书");
        jb1.setBounds(new Rectangle(250, 235, 100, 25));
        jb1.setToolTipText("对应于jb1按钮");
        
        jb2.setText("导出证书");
        jb2.setBounds(new Rectangle(375, 235, 100, 25));
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
        jPanel1.add(jl10);
        jPanel1.add(jtf10);
              
        jPanel1.add(jb1);
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				/*“申请证书”按钮功能代码
				 * 
				 *1、首先判断输入项是否合法： 
				 * "输入项不能为空，请重新输入！"
				 * "两次输入密码不相同，请您重新输入密码！"
				 * "密码位数小于6，请您重新输入密码！"
				 * "有效期需要输入正整数！"
				 * 
				 *2、若输入项都合法，则进行申请证书操作。
				 *  调用keytool来申请证书
				 *  例如设置为RSA算法，存储到mykeystore.keystore，设置存储密码为117117
				 *  keytool -genkey -keyalg RSA -keystore mykeystore.keystore -storepass 117117
				 *  其他参数请参考keytool的参数设置
				 */
				JOptionPane.showMessageDialog(null,"该按钮对应于RegCertPanel.java中的jb1按钮","请编写该按钮功能代码",JOptionPane.OK_OPTION);
			}
		});
		
        jPanel1.add(jb2);
		jb2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				/*“导出证书”按钮功能代码
				 * 
				 *1、输入证书别名（alias）
				 *  根据输入的证书别名（alias）选择需要导出的证书
				 *  调用keytool从密钥库里面导出证书
				 * 
				 */
				JOptionPane.showMessageDialog(null,"该按钮对应于RegCertPanel.java中的jb2按钮","请编写该按钮功能代码",JOptionPane.OK_OPTION);
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
