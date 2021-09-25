
package proyecto1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Ventana implements ActionListener  {
    static JFrame frame;
    static JPanel panel;
    JLabel jl1;
    JButton boton1;
    JButton boton2;
    static int fila =20;
    static int columna=11;
    
    
    
    
    public Ventana() {
    //frame();
    //frame.setVisible(true);

    

}
    
    
    
public void frame(){
        frame= new JFrame();
        frame.setTitle("Libreria el 'Casar' ");                   // colocamos titulo a la ventana
        frame.setSize(800, 600);                                 // colocamos tamanio a la ventana (ancho, alto)
        frame.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        //this.setLayout(null);     
        frame.setLayout(new GridLayout(1, 1));// no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        frame.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        panel();
        
    panel.setVisible(true);
    
    frame.add(panel);
    
    //clase4.panel.
    //frame.add(clase4.panel);
    
    //frame.add(clase3);
    }
    
    private void panel(){
    panel = new JPanel(); 
    panel.setLayout(null);
    
    jl1 = new JLabel("Este es el panel Principal");
    panel.add(jl1);
    botones();

    }
    
    
    public void  botones(){
    boton1= new JButton("Administrador");
    boton2= new JButton("Usuario");
    
    
    boton1.setBounds(300,100,200,50);
    boton1.addActionListener(this);
    boton2.setBounds(300,200,200,50);
    boton2.addActionListener(this);
    panel.add(boton1);
    panel.add(boton2);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if( e.getSource()==boton1  ){
        Login login = new Login();
        login.login.setVisible(true);
        panel.setVisible(false);
        frame.remove(panel);
        frame.add(login.login);    
            
            
        //Administrador Admin = new Administrador(true);
        //Admin.panel1.setVisible(true);
        //panel.setVisible(false);
        //frame.remove(panel);
        //frame.add(Admin.panel1);
        
        System.out.println("se ejecuto el evento");
        }else if( e.getSource()==boton2){
        Usuario user = new Usuario(true);
        user.panel.setVisible(true);
        panel.setVisible(false);
        
        
        frame.remove(panel);
        frame.add(user.panel);
        System.out.println("se ejecuto boton2");
        }else{
            
            System.out.println(" se ejcuto otro");
        }
    
    
    


    
}
}