
package proyecto1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener{
    
    JLabel a1,a2;
    JTextField text1;
    JPasswordField text2;
    JPanel login;
    JButton boton,regre2;
    Ventana ven;
    Administrador Admin;
    UserAdmin useradmin;
    int valor;
    
    
    
    public Login(){
        
        
        if(Proyecto1.insta2==0){
        useradmin = new UserAdmin(0);
        UserAdmin.useradmin[0][1]="0";
        UserAdmin.useradmin[0][1]="admin";
        UserAdmin.useradmin[0][2]="admin";
        Proyecto1.insta2=1;
        }else{
        
        
        }
        
        
        panel();
        conte();
        ven= new Ventana();
        if(Proyecto1.insta==1){
            
            
            
        }else{
        
        Admin = new Administrador(false);
        Admin.panel1.setVisible(false);
        
        }
        
    }
    
    
    public void panel(){
    
    login = new JPanel();
    login.setLayout(null);
    
    }
    
    
    public void conte(){
    a1 = new JLabel("Usuario");
    a1.setBounds(100,20,200,30);
    
    text1 = new JTextField();
    text1.setBounds(100,50,200,30);
    
    
    a2 = new JLabel("Contraseña");
    a2.setBounds(100,80,200,30);
    
    
    text2 = new  JPasswordField();
    //text2 = new JTextField();
    text2.setEchoChar('*');
    text2.setBounds(100,110,200,30);
    
    boton = new JButton("Ingresar");
    boton.setBounds(100,160,200,30);
    boton.addActionListener(this);
    
    
    
    regre2 = new JButton("Regresar");
    regre2.setBounds(650, 500, 100, 30);
    
    JLabel etiqueta = new JLabel();
      etiqueta.setIcon(new ImageIcon (getClass().getResource("c.png")));
      etiqueta.setBounds(500, 90, 200, 200);
    
    login.add(etiqueta);
    
    
    login.add(regre2);
    login.add(a1);
    login.add(a2);
    login.add(text1);
    login.add(text2);
    login.add(boton);
    
    regre2.getModel().addActionListener(new ActionListener(){
    @Override
    public void actionPerformed (ActionEvent e){
    login.setVisible(false);
    Ventana.frame.remove(login);
    
    Ventana.frame.add(Ventana.panel);
    Ventana.panel.setVisible(true);
    
    
    }
    } );
    
    
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        
//        PanelPrestado presta = new PanelPrestado(false);
//        presta.panel.setVisible(false);
//        if(Proyecto1.panpres==0){
//        //PanelPrestado pans = new PanelPrestado(true);
//        Administrador.tab.addTab(" LibrosPrestado",presta.panel);
//        }else{
//         Administrador.tab.addTab(" LibrosPrestado",PanelPrestado.panel);   
//            
//        }
//        
        
        
        
        UserAdmin.useradmin[0][0]="1";
        UserAdmin.useradmin[0][1]="admin";
        UserAdmin.useradmin[0][2]="admin";
        
        String temp1 = text1.getText().trim();
        //String temp2 = text2.getText().trim();
        
        char[] arrayC= text2.getPassword();
        String temp2 = new String(arrayC); 
        valor=0;
        
        for(int i=0;i<=20-1;i++){
            System.out.println("valor consultado"+temp1+"con  "+temp2);
            
            System.out.println("valor consultado"+UserAdmin.useradmin[i][1]+"con  "+UserAdmin.useradmin[i][2]);
            
            if((UserAdmin.useradmin[i][1]==null)||(UserAdmin.useradmin[i][2]==null) ){  
            }else{
 
            if((UserAdmin.useradmin[i][1].equals(temp1))&&(UserAdmin.useradmin[i][2].equals(temp2))){
                System.out.println("valor que trae el insta"+Proyecto1.insta);
                Proyecto1.insta=1;
                System.out.println("valor temp ///"+temp1);
                Proyecto1.usera=temp1;
                
                System.out.println("postvalor temp ///"+Proyecto1.usera);
                //Administrador.tab.setVisible(true);
                valor=1;
                break;
            }else{ 
            }
            
            
            
            }
        }
        
        
        System.out.println("valor de valor"+valor);
        if(valor==1){
            System.out.println("entro evento");
            
        if(Proyecto1.insta==0){
        JOptionPane.showMessageDialog(login, " Bienvenido "+temp1, " Session", 1);
        login.setVisible(false);
        Admin.setadmin(temp1);
        Ventana.frame.remove(login);
        Ventana.frame.add(Admin.panel1);
        Administrador.tab.add(PanelPrestado.panel);
        //Administrador.sesion.setText(temp1);
        
        
        Administrador.sesion.setText("<html><p style='font_family:century gothic'><h3>"+temp1+"</h3></p></html>");
        //ven.frame.remove(login);
        //ven.frame.setVisible(true);
        //ven.frame.add(Admin.panel1);
        Admin.panel1.setVisible(true);
        
        
        
        }else{
        JOptionPane.showMessageDialog(login, " Bienvenido "+temp1, " Session", 1);
        //JOptionPane.showMessageDialog(login, "<html><p style='font_family:century gothic'><h4>"+temp1+"</h4></p></html>", " Session", 1);
        
        login.setVisible(false);
        
        Ventana.frame.remove(login);
        Ventana.frame.add(Administrador.panel1); 
        Administrador.sesion.setText(temp1);
        //ven.frame.remove(login);
        //ven.frame.setVisible(true);
        //ven.frame.add(Admin.panel1);
        
        Admin.panel1.setVisible(true);
       
        
        }    
            
            
        
        
        }else{
        JPanel z= new JPanel();
        JOptionPane.showMessageDialog(z, "Usuario o contrasena mala...", " Error", 0);
        
        }
        
        
        
        
        
        
        
        
        /////////////
            
        
        
    
        
        
    }
    
    
    
    
    
}
