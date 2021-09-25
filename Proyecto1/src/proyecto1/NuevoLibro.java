
package proyecto1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NuevoLibro implements ActionListener{
    JPanel panel;

    JLabel Lb1 ;
    JLabel Lb2 ;
    JLabel Lb3 ;
    JLabel Lb4 ;
    
    JTextField txt1;
    JTextField txt2;
    JTextField txt3;
    
    String texto1;
    String texto2; 
    String texto3; 
    
    JButton boton;
    Libro libro;
    static int vali;
    
    
        
    

    public NuevoLibro(boolean val){  
            libro= new Libro();
             panelNL();
             panel.setVisible(val);
             

    }

    
    private void panelNL(){
        
  
    txt1 = new JTextField(); 
    txt1.setBounds(350,100,250,30);
    texto1 = txt1.getText();
    
    txt2 = new JTextField(); 
    txt2.setBounds(350,200,250,30);
    texto2 = txt2.getText();
    
    txt3 = new JTextField(); 
    txt3.setBounds(350,300,250,30);
    texto3 = txt3.getText();
    

    
    Lb1 = new JLabel("Nombre: ");
    Lb1.setBounds(200,90,200,50);
    
    Lb2 = new JLabel("Autor: ");
    Lb2.setBounds(200,190,200,50);
    
    
    Lb3 = new JLabel("Tipo: ");
    Lb3.setBounds(200,290,200,50);
    
    
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
    
    

    Lb4 = new JLabel("Fecha: "+day+"/"+month+"/"+year );
    Lb4.setBounds(500,20,300,30);
 
    panel = new JPanel();
    panel.setLayout(null);
    
    boton = new JButton(" Guardar");
    boton.setBounds(500,400,100,30);
    boton.addActionListener(this);
    
    
    
    
    
    panel.add(Lb1);
    panel.add(txt1);
    panel.add(Lb2);
    panel.add(txt2);
    panel.add(Lb3);
    panel.add(txt3);
    panel.add(Lb4);
    panel.add(boton);
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        texto1 = txt1.getText().trim();
        texto2 = txt2.getText().trim();
        texto3 = txt3.getText().trim();
        
        System.out.println("texto en evento"+texto1);
        
        if((texto1 == null) || (texto1.isEmpty())||(texto2 == null) || (texto2.isEmpty())||(texto3 == null) || (texto3.isEmpty())    ){
        
        JOptionPane.showMessageDialog(panel, "Un campo esta Vacio... ", " Agregar", 0);
        }else {
            this.vali=1;
            
        
        
        libro.Ingreso(texto1, texto2, texto3); 
        
        
         txt1.setText("");
         txt2.setText("");
         txt3.setText("");
        
        }
    }

    
}