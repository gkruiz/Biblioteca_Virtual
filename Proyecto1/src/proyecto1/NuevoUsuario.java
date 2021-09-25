
package proyecto1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class NuevoUsuario {
    static JPanel panel;
    JLabel lab1;
    
    JButton boton1;
    JTextField caja1;
    int fila = Libro.fila;
    int columna =4;
    static String informa[][];
    String texto1 ;
    
    JButton bpres;
    
    JTable user;        
    JScrollPane scro;
    int valocom;
    int valitab;
    
    
    public NuevoUsuario(){
    valitab=0;
    panel1();
    conte();
    informa = new String[fila][columna];
    iniciavariable();
    tabla();
    botonactu();
    }
    
    private void tabla(){
        
    String[] columnNames = {"ID","Nombre","No.Libros Prestados", "Estatus"};    
    user = new JTable(informa, columnNames){
         @Override
         public boolean isCellEditable(int row,int column){
             return false;
        }
        };;
    scro = new JScrollPane(user);
        scro.setBounds(150, 180, 500, 300);
        scro.setVisible(false);
        panel.add(scro);
    
    
    }
    
    
    
    
    private void panel1(){
    panel = new JPanel();
    panel.setLayout(null);
    panel.setVisible(true);
    
    }
    
    public void conte(){
    lab1= new JLabel("Nuevo Usuario");
    lab1.setBounds(350,20,100,30);
    
    caja1 = new JTextField();
    caja1.setBounds(300,70,200,30);
    
    
    boton1 = new JButton("Guardar");
    boton1.setBounds(300,120,200,30);
   
    
    
    
    
    panel.add(lab1);
    panel.add(caja1);
    panel.add(boton1);
    
    boton1.getModel().addActionListener(new ActionListener() {
        @Override
      public void actionPerformed (ActionEvent e)
      {
          texto1 = caja1.getText().trim();
          agregar();
          System.out.println("valor de la lista "+texto1);
          System.out.println("se ejecuto evento boton interno bueno");
         //pul1ado();
         
          if(valitab==1){
          caja1.setText("");
          scro.setVisible(false);
          panel.remove(scro);
          tabla();
          scro.setVisible(true);
          
          }else{
          
          
          
          }
          
          
          
      }
    
    
    });
    
    
    
}
    
    
    public void agregar(){
        
        
        if((texto1.isEmpty())||(texto1.equals(""))||(texto1.equals(null))||(texto1=="")||(texto1==null)        ){  
            System.out.println("valor texto"+texto1);
        }else{
            
        valocom=0;
    for(int q=0;q<=fila-1;q++){
        
        
     
    if((informa[q][1].equals(texto1))){
        System.out.println("111111111");
        System.out.println("se ejecuto "+texto1);
        System.out.println("valor iforma"+informa[q][1]+" 11111");
        
        JOptionPane.showMessageDialog(panel, "El usuario ya existe", " Error", 0);
        valocom=0;
        break;
    }else{
            System.out.println("2222222222");
            System.out.println("se ejecuto "+texto1);
            System.out.println("valor iforma"+informa[q][1]+" 222222");
            valocom=2;
            valitab=1;
    }
    
    
    }

    if(valocom==2){
    
    
    
    
    for(int i=0;i<=fila-1;i++){
            

            if((informa[i][0]=="")){
    
              int agre= i+1;
              String id= Integer.toString(agre);
              
              informa[i][0]=id;
             for(int j=1;j<=columna-1;j++){  
              
              switch(j){
                case 1:
                informa[i][j]=texto1;      
                break;
                
                case 2:
                informa[i][j]="0";      
                break;
                
                case 3:
                informa[i][j]="No Moroso";      
                break;
                
                
              }
          }
             JOptionPane.showMessageDialog(panel, "Se ha agregado", " Nuevo Usuario", 1);
             break;
            
            }else{
            
            }
        }
    
    
    }else{
    
    
    }
    
    
    
    
    }
    }
    
    private void botonactu(){
    
    
        bpres = new JButton("Actualizar");
        bpres.setBounds(300,500,200,30);
        bpres.setVisible(true);
        
        bpres.getModel().addActionListener(new ActionListener() {
        @Override
      public void actionPerformed (ActionEvent e)
      {
          if(informa[0][0]!=""){
          scro.setVisible(false);
          panel.remove(scro);
          tabla();
          scro.setVisible(true);
          }else{
          
          }
      
          
          
       
          
      }});
    panel.add(bpres);
    }
    
    
  public void iniciavariable(){
    
    for(int i=0;i<=fila-1;i++){
        for(int j=0;j<=columna-1;j++){
            informa[i][j]=""; 
        }
        }
    }  
    
    
}