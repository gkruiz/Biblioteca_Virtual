
package proyecto1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;


public class Usuario {
    
    
    JPanel panel,panel2;
    JLabel jl1; 
    JTabbedPane tab2;
    JButton regre2;
    
    
    public Usuario(boolean val){   
    panel2();
    panel.setVisible(val);
        System.out.println(" val"+val);  
    }
    
    private void panel2(){
        
    
    
    jl1 = new JLabel("Este es el panel usuario");
    jl1.setBounds(500,100,200,50);
    jl1.setVisible(false);
    //panel.add(jl1);    
        
        
        
        
    panel = new JPanel(); 
    panel.setLayout(null);
    
    panel2 = new JPanel(); 
    panel2.setLayout(null);
    
    
    regre2 = new JButton("Regresar");
    regre2.setBounds(650, 500, 100, 30);
    panel2.add(regre2);
    
    JLabel etiqueta = new JLabel();
      etiqueta.setIcon(new ImageIcon (getClass().getResource("qwer.png")));
      etiqueta.setBounds(130, 130, 200, 200);
    
    panel2.add(etiqueta); 
    
    
    
    
    
    tab2 =new JTabbedPane();
   
    PrestadoUser pans = new PrestadoUser(true);
    LibrosUser user = new LibrosUser();
    JLabel la = new JLabel("<html><p style='font_family:century gothic'><h1> Usuarios</h1></p></html>");
    la.setBounds(550,200, 200, 40);
    panel2.add(la);
    
    tab2.add("Inicio",panel2);
    tab2.add("Libros Prestados",PrestadoUser.panelu);
    tab2.add("Libros",LibrosUser.panel);
    tab2.setBounds(0, 0, 795, 570);
    panel.add(tab2);

    
    regre2.getModel().addActionListener(new ActionListener(){
    @Override
    public void actionPerformed (ActionEvent e){
    panel.setVisible(false);
    Ventana.frame.remove(panel);
    
    Ventana.frame.add(Ventana.panel);
    Ventana.panel.setVisible(true);
    
    
    }
    } );
    
    
    }
    
    
 


}