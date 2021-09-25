
package proyecto1;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class Administrador implements ActionListener{
  
    JButton boton1,boton2,boton3,boton4,boton5,boton6;  
    static JTabbedPane tab;
    
    NuevoLibro nulibro ;
    PrestarLibro prestalibro;
    NuevoUsuario nuevousuario;
    PanelPrestado presta;
    Devolver devuel;
    Reporte report;
    UserAdmin useradmin;
    Editar edi;
    
    static String actual;
    static JPanel panel1;
    JPanel panel2;
    
    
    static String administrador;
    JLabel jl1;
    static JLabel sesion;
    
    
    JButton regre;
    
    public Administrador(boolean val){
     administrador = null;
    
        actual="";
    panel2 = new JPanel();
    panel2.setLayout(null);
    
   
       //ImageIcon imagen = new ImageIcon("a.png");
       JLabel etiqueta = new JLabel();
      etiqueta.setIcon(new ImageIcon (getClass().getResource("a.png")));
      etiqueta.setBounds(130, 130, 200, 200);
      
      panel2.add(etiqueta); 
      
      
    panel1();
   panel1.setVisible(val);
    
    campo();
    
    }
    
    
    
    
    
    private void panel1(){
    panel1 = new JPanel();
    panel1.setLayout(null);
    Componente();
    
    }
    
    
    public void Componente() {
        
        tab=new JTabbedPane();
        tab.setBounds(0, 0, 795, 570);
        //tab.setLayout( new GridLayout(1,1) );
        
        
        panel2.setVisible(false);
        
        
        nulibro = new NuevoLibro(false);
        //nulibro.panel.setVisible(false);
        
        prestalibro = new PrestarLibro();
        //prestalibro.panel.setVisible(false);
        
        nuevousuario =new NuevoUsuario();
        //nuevousuario.panel.setVisible(false);
        
        presta = new PanelPrestado(false);
        //presta.panel.setVisible(false);
        
        devuel= new Devolver();
        //devuel.panel.setVisible(false);
        
        report= new Reporte();
       //report.panels.setVisible(false);
        
        useradmin = new UserAdmin();
        //useradmin.panel.setVisible(false);
        
        edi = new Editar();
        
        //Login log = new Login();
        //log.login.setVisible(true);
        
        
        //tab.addTab(" Login",log.login);
        tab.addTab(" Inicio",panel2);
        tab.addTab(" NuevoLibro",nulibro.panel);
        tab.addTab(" Prestalibro",prestalibro.panel );
        tab.addTab(" NuevoUsuario",nuevousuario.panel);
        
        if(Proyecto1.panpres==0){
        //PanelPrestado pans = new PanelPrestado(true);
        tab.addTab(" LibrosPrestado",presta.panel);
        }else{
         tab.addTab(" LibrosPrestado",PanelPrestado.panel);   
            
        }
        
        
        
        tab.addTab(" Devuelve",devuel.panelde);
        tab.addTab(" Reporte",report.panels);
        
        tab.addTab(" NuevoAdmin",useradmin.panel);
        tab.addTab(" EditarLibro",edi.panele);
        
        tab.setVisible(true);
        panel1.add(tab);
        
  
        System.out.println(" se ejecuto componente");
    }
    
    
    public void campo(){
    JLabel la = new JLabel("<html><p style='font_family:century gothic'><h2> Administrador Actual</h2></p></html>");
    la.setBounds(550,100, 200, 40);
        
    System.out.println("valo cosulta usera"+administrador);
    
    sesion= new JLabel("<html><center>"+administrador+"</center></html>");
    sesion.setBounds(550,150, 100, 30);
    
    
    regre = new JButton("Regresar");
    regre.setBounds(650, 500, 100, 30);
    
    panel2.add(la);
    panel2.add(sesion);
    panel2.add(regre);
    
    regre.getModel().addActionListener(new ActionListener(){
    
    
    @Override
    public void actionPerformed (ActionEvent e){
    panel1.setVisible(false);
    Ventana.frame.remove(panel1);
    Ventana.frame.add(Ventana.panel);
    Ventana.panel.setVisible(true);
    
    
    }
    } );
    
    
    
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
      nulibro = new NuevoLibro(true);
      nulibro.panel.setVisible(true);
      panel1.setVisible(false);
      Ventana ven = new Ventana();
      ven.frame.remove(panel1);
      ven.frame.remove(ven.panel);
      
      ven.frame.add(nulibro.panel);
      
    
      
    }
    
    public void setadmin(String valor){
        this.administrador=valor;
        
    }
    
    public String getadmin(){
    
    return administrador;
    }
    
    
    
    
    
    
}
