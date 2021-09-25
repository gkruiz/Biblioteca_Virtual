
package proyecto1;

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

public class PanelPrestado implements ActionListener {
    
     static JPanel panel;

     JTextField cajabus; 
    JLabel mostrar; 
     
    
    JButton boton;
    JTable table;
    JScrollPane scroll;
    int fila = Libro.fila;
    int columna= 8;
    String[][] muestra;
    static int valor;
    int contador;
    int confi;
    public PanelPrestado(boolean val){ 
        
        
        muestra = new String[fila][columna];
        confi=0;
        valor=0;
        contador=0;
             panelNL();
             //Consulta();
             tabla();
             panel.setVisible(true);
             
             
             
             
    }

    private void tabla(){
    if(NuevoLibro.vali==0){
        //libro= new Libro(0);
        
     }else{
    //muestra = new String[fila][columna];
    valor=1;
    String[] columnNames = {"ID","Nombre", "Autor","Tipo","Dia","Mes","Ano","dia"};
    
    
        table = new JTable(muestra, columnNames){
         @Override
         public boolean isCellEditable(int row,int column){
             
             
             return false;
             
            
        }
        };
        
        
        
        scroll = new JScrollPane(table);
        scroll.setBounds(5, 150, 780, 330);
        scroll.setVisible(true);
        panel.add(scroll);
    }
    
    }
     public void Consulta(){
        //campos columnas
        
     muestra = new String[fila][columna];
     contador=0;
     for(int i=0;i<=fila-1;i++){
                    for(int j=0;j<=columna-1;j++){
                        
                    if((LibroPrestado.datosp[i][j]==null)||(LibroPrestado.datosp[i][j].isEmpty())){  
                        confi=0;
                    }else{
                        System.out.println("varlor muestra"+muestra[contador][j]);
                        
                        
                        if((muestra[contador][j]==null)||(muestra[contador][j].isEmpty())){
                            
                        muestra[contador][j]=LibroPrestado.datosp[i][j];
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
    
    
    
    private void panelNL(){

        
        
        
        


    panel = new JPanel();
    panel.setLayout(null);
    
    boton = new JButton(" Actualizar");
    boton.setBounds(550,20,100,30);
    boton.addActionListener(this);
    
    cajabus = new JTextField();
    mostrar = new JLabel("");
    
    cajabus.setBounds(20,20,100,30);
    mostrar.setBounds(20,40,100,30);
//    cajabus.addKeyListener( new KeyListener(){
//        @Override
//        public void keyTyped(KeyEvent e) {
//          
//           
//           
//           
//        }
//
//        @Override
//        public void keyPressed(KeyEvent e) {
//             String tempo = cajabus.getText();
//           mostrar.setText(tempo);
//           
//        }
//
//        @Override
//        public void keyReleased(KeyEvent e) {
//            
//        }
//    
//    
//    
//    });
//    
            
   
            
    
     //panel.add(cajabus);
     panel.add(mostrar);
    
    
    panel.add(boton);
    
    
    }
   
  
    

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("se ejecuto evento de panelprestado bueno");
        if((NuevoLibro.vali==1)&&(LibroPrestado.vali2==1)){
        //libro= new Libro(0);
        
        if(valor==1){
            
            
        //scroll.setVisible(false);
        panel.remove(scroll);
        Consulta();
        tabla();
            System.out.println(" se metio en valor1//////////////////////////");
        scroll.setVisible(true);    
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
