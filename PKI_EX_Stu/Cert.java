package PKI_EX_Stu;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Cert extends JFrame {
    RegCertPanel regpanel = new RegCertPanel();
	SignCertPanel signpanel = new SignCertPanel();
    EncCertPanel  encpanel = new EncCertPanel();
    CertSignPanel certsignpanel = new CertSignPanel();
    JTabbedPane tabs = new JTabbedPane();     
    
    public Cert() {
        try {
            init();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void init() throws Exception {
		int WIDTH = 800; 
		int HEIGHT = 640; 
    	Toolkit tk = Toolkit.getDefaultToolkit(); 
		Dimension screenSize = tk.getScreenSize(); 
		this.setLocation((screenSize.width - WIDTH)/2,(screenSize.height - HEIGHT)/2); 
		this.setTitle("上海交通大学PKI编程实验系统"); 
    	
    	tabs.addTab("证书申请", regpanel.jSplitPane);
    	tabs.addTab("证书签发", signpanel.jSplitPane);
    	tabs.addTab("证书加密", encpanel.jSplitPane);
    	tabs.addTab("证书数字签名", certsignpanel.jSplitPane);
       this.getContentPane().add(tabs);
       this.setSize(800, 640); 
       this.addWindowListener(
           new WindowAdapter(){
               public void windowClosing(WindowEvent e){
                  System.exit(0);        
               }        
           }        
       );
    }
    
    public static void main(String[] args) {
        Cert c = new Cert();
        c.setVisible(true);
    }
}
