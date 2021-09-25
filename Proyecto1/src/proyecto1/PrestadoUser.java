
package proyecto1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static proyecto1.PrestarLibro.datos;

public class PrestadoUser implements ActionListener {
    
    static JPanel panelu;
    String[][] muestrau;

    JButton boton;
    JTable table;
    JScrollPane scrollu;
    
    
    int fila = Libro.fila;
    int columna= 8;
    
    static int valor;
    int contador;
    int confi;
    
    
    public PrestadoUser(boolean val){ 
        
        
        muestrau = new String[fila][columna];
        confi=0;
        valor=0;
        contador=0;
             panelNLs();
             //Consulta();
             tabla();
             panelu.setVisible(true);
             
             
             
             
    }

    private void tabla(){
    if(NuevoLibro.vali==0){
        //libro= new Libro(0);
        
     }else{
    //muestra = new String[fila][columna];
    valor=1;
    String[] columnNames = {"ID","Nombre", "Autor","Tipo","Dia","Mes","Ano","dia"};
    
    
        table = new JTable(muestrau, columnNames){
         @Override
         public boolean isCellEditable(int row,int column){
             
             
             return false;
             
            
        }
        };
        
        
        
        scrollu = new JScrollPane(table);
        scrollu.setBounds(5, 150, 780, 330);
        scrollu.setVisible(true);
        panelu.add(scrollu);
    }
    
    }
     public void Consulta(){
        //campos columnas
        
     muestrau = new String[fila][columna];
     contador=0;
     for(int i=0;i<=fila-1;i++){
                    for(int j=0;j<=columna-1;j++){
                        
                    if((LibroPrestado.datosp[i][j]==null)||(LibroPrestado.datosp[i][j].isEmpty())){  
                        confi=0;
                    }else{
                        System.out.println("varlor muestra"+muestrau[contador][j]);
                        
                        
                        if((muestrau[contador][j]==null)||(muestrau[contador][j].isEmpty())){
                            
                        muestrau[contador][j]=LibroPrestado.datosp[i][j];
                        System.out.print(datos[i][j]);
                        confi=1;
                    
                        }else{
                            System.out.println("se ejecuto esta lleno el espacio");
                        }

                    }
                    }
        System.out.println("");
        
        if(confi==1){
            contador++;
        }else{
        
        }
        
        }
     
     
     
     

    
    }
    
    
    
    private void panelNLs(){

        
        
        
        


    panelu = new JPanel();
    panelu.setLayout(null);
    
    boton = new JButton(" Actualizar");
    boton.setBounds(550,20,100,30);
    boton.addActionListener(this);

    
    
    panelu.add(boton);
    
    
    }
   
  
    

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("se ejecuto evento de panelprestado bueno");
        if((NuevoLibro.vali==1)&&(LibroPrestado.vali2==1)){
        //libro= new Libro(0);
        
        if(valor==1){
            
            
        //scroll.setVisible(false);
        panelu.remove(scrollu);
        Consulta();
        tabla();
            System.out.println(" se metio en valor1//////////////////////////");
        scrollu.setVisible(true);    
        Proyecto1.panpres=1;
        
        
        }else{
        Consulta();
        tabla(); 
        System.out.println(" se metio en valor0//////////////////////////");
        }
        
     }else{
        //panel.remove(scroll);
        
        
        }
    }
    
    
    
    
}
