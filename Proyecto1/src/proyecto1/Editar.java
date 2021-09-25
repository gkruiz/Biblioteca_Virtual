
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

public class Editar implements ActionListener{
     String datosu[][];
    String temporal[][];
    
    
    
    static JPanel panele;
    JTable table,table2;
    
    //para busqueda
    JLabel lbus;
    JTextField cbus;
    //para busqueda
    
    
    int fila =Libro.fila;
    int columna =8;

 
    JScrollPane scrollPaneu,scrollPane2u;
    JButton bon,bon2;


    int parar;

    public Editar(){
    datosu = new String[fila][columna];
    temporal = new String[fila][columna];
    System.out.println("se ejecuto constructor prestar libro");
    propanel();
    boton();
    
    tabla();
    buscar();
    
    tablatemp();
   
    }

    public void propanel(){
      panele = new JPanel();
      panele.setLayout(null);
      panele.setVisible(false);
        System.out.println("se ejecuto panel y contenido");
    }
    public void Consulta(){
        //campos columnas
        
    
        //libro= new Libro(0);
        for(int i=0;i<=fila-1;i++){
                    for(int j=0;j<=columna-2;j++){
                        
                    if((Libro.matriz[i][j]==null)||(Libro.matriz[i][j].isEmpty())){
                        
                    }else{
                        
                    datosu[i][j]=Libro.matriz[i][j];

                    if((datosu[i][7]==null)||(datosu[i][7].isEmpty())){
                        
                        
                    datosu[i][7]="Disponible";
                    
                    }else if(datosu[i][7]=="Prestado"){
                        
                        compara();
                   
                   
                    }else{
                    
                    }
                    }
                     
                    }
                   

        System.out.println("");
        }

    
    }
    public void tabla(){
        
        String[] columnNames = {"ID","Nombre", "Autor","Tipo","Dia","Mes","Ano"};
        table = new JTable(Libro.matriz, columnNames){
         @Override
         public boolean isCellEditable(int row,int column){
             
             
            if(column<=1){
              return false;
              }else if((Libro.matriz[row][column]==null)||(Libro.matriz[row][column].isEmpty())||(Libro.matriz[row][column]=="")   ){
              return false;
             }else if(PrestarLibro.datos[row][8]=="Prestado"){
              return false;
              }else{
              return true;
              } 
             
                 
           
             
            
        }
        };

        scrollPaneu = new JScrollPane(table);
        scrollPaneu.setBounds(5, 150, 780, 330);
        scrollPaneu.setVisible(false);
        //table.add
        panele.add(scrollPaneu);
   
    }
    
    
    private void boton(){
    bon = new JButton(" Actualizar");
    bon.setBounds(600, 500, 100, 30);
    bon.addActionListener(this);
    panele.add(bon);
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==bon){
        
    if(NuevoLibro.vali!=1){
        System.out.println("no hay datos que mostrar");
        
    }else{
        
        panele.remove(cbus);
        panele.remove(lbus);
        
        
        
        
        panele.remove(scrollPane2u);
        panele.add(scrollPane2u);
        scrollPane2u.setVisible(false);
        
        scrollPaneu.setVisible(false);
        panele.remove(scrollPaneu);
        
        
        compara2();
        Consulta(); 
        compara2();
        tabla();
        buscar();

        lbus.setVisible(true);
        cbus.setVisible(true);
        scrollPaneu.setVisible(true);
        

        table.getValueAt(1, 2);
        System.out.println("valo si cambia jaj"+table.getValueAt(1, 2));

        
        
        
    }
        }else if(e.getSource()==bon2){

        System.out.println("se ejecuto bon2 para mostrar ingresar");

                
        
        
        }
    
    
    }
    


    
    private void buscar(){
        System.out.println("buscar se ejecuto en metodo ");
        lbus= new JLabel("Escriba para buscar");
        lbus.setBounds(10, 20, 120, 30);
        
        cbus= new JTextField();
        cbus.setBounds(130, 20, 100, 30);

        lbus.setVisible(false);
        panele.add(lbus);
        cbus.setVisible(false);
        panele.add(cbus);
        
        cbus.addKeyListener( new KeyListener(){
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
  
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
            

           temporal = new String[fila][columna];
            
           String buscado = (String)cbus.getText().trim();
           
           System.out.println("valor temporal"+temporal);
           
           if((buscado=="")||(buscado.isEmpty())||(buscado.equals(""))  ){
               
               if(NuevoLibro.vali!=1){
        System.out.println("no hay datos que mostrar");
        
    }else{
        panele.remove(scrollPane2u);
        panele.add(scrollPane2u);
        scrollPane2u.setVisible(false);           
                   
        scrollPaneu.setVisible(false);
        panele.remove(scrollPaneu);
        
        
        compara2();
        Consulta(); 
        compara2();
        
        tabla();

        scrollPaneu.setVisible(true);
               
               }
               
           }else{
           panele.remove(scrollPaneu);
          panele.remove(scrollPane2u);
          
          compara();
          tabla();
          resultado(buscado);
          tablatemp();
          
          scrollPane2u.setVisible(true);
          panele.add(scrollPane2u);
           }
           
           
//          panele.remove(scrollPaneu);
//          panele.remove(scrollPane2u);
//          
//          compara();
//          tabla();
//          resultado(buscado);
//          tablatemp();
//          
//          scrollPane2u.setVisible(true);
//          panele.add(scrollPane2u);
         
              
            
            
            
            
        }
    
    
    
    });
        
 
    }
    private void resultado(String busqueda){
        //boolean flag = false;
        //datos
        
        //primer for
        
        
        for(int s=0;s<=fila-1;s++){
            //segundo for
            for(int g=0;g<=columna-1;g++){

                

                    
                                if(busqueda.equals(datosu[s][g])){ 

                                    System.out.println("se encontro uno"+s);

                                            for(int i=0;i<=columna-1;i++){


                                                    if((temporal[i][0]==null)||(temporal[i][0].isEmpty() )){

                                                                        int agre= i+1;
                                                                        String id= Integer.toString(agre);
                                                                        temporal[i][0]=id;

                                                                        for(int j=1;j<=columna-1;j++){
                                                                            temporal[i][j]=datosu[s][j];
                                                                            } 

                                                                        break;

                                                            }else{

                                                            }
                                         }

                                   //final si es 
                                }else{
                                    
        
       
        
  


                                                //inicio no es 
                                                if((s==fila-1)&&(g==columna-1)){

                                                    if(temporal[0][0]==null){
                                                    System.out.println("lo que se busca"+busqueda);
                                                    //JOptionPane.showMessageDialog(panel, "No encotro resultados", " Error", 0);

                                                    }


                                                }else{
                                                }
                                                 //final no es   


                                }
                
                
                
                
                
            }//final primer for
            if(parar==1){
            break;
            }else{}
        
        }
        
       
       
   
    }
    private void tablatemp(){
    
     String[] columnNames = {"ID","Nombre", "Autor","Tipo","Dia","Mes","Ano","chec"};
        
        table2 = new JTable(temporal, columnNames){
         @Override
         public boolean isCellEditable(int row,int column){
             System.out.println("valor llegada celda"+"fila "+row+"  columna "+column);
             if(column<=1){
              return false;
              }else if((temporal[row][column]==null)||(temporal[row][column].isEmpty())||(temporal[row][column]=="")   ){
              return false;
             }else if(temporal[row][7]=="Prestado"){
              return false;
              }else{
              return true;
              } 
            
        }
        };
        
        
        scrollPane2u = new JScrollPane(table2);
        scrollPane2u.setBounds(5, 150, 780, 330);
        scrollPane2u.setVisible(false);
        
        
        
        
    
        panele.add(scrollPane2u);
    
    
    
    
    }
    
    private void compara(){
        for(int o=0;o<=fila-1;o++){
          
            for(int z=0;z<=columna-1;z++){
                
                
             if((LibroPrestado.datosp[z][2]!=null)){
                 
                 //si contiene algo diferente de nulo
                  if(datosu[o][1]==null){
                      //si es fila 1 todos son disponibles
                      
                      
                  }else{
                      
                   if(datosu[o][1]==LibroPrestado.datosp[z][2]){
                 datosu[o][columna-1]="Prestado";
                 break;
                 }
                 else{
                 
                 datosu[o][columna-1]="Disponible";
                 }   
                      
                          
                  }
                          
                 
                 
             }else if(z==(0)){
                 
                 
             for(int q=0;q<=fila-1;q++){
                 if((datosu[q][columna-1]==null)){
                 
                 }else{
                 
                 datosu[q][columna-1]="Disponible";
                 }
             }
             
             
             
             }else{
                 
             }
             
             }
             
             
             
            }
            
        }
  
    
    public void compara2(){
        for(int o=0;o<=fila-1;o++){
          
            for(int z=0;z<=columna-1;z++){
                
             //crear otro for porque este esta limitado  
             if((LibroPrestado.datosp[z][2]!=null)){
                 
                 //si contiene algo diferente de nulo
                 //System.out.println("valor datos "+datos[o][1]);
                 //System.out.println("valor prestado  "+LibroPrestado.datosp[z][2]);
                
                  if(datosu[o][1]==null){
                      //si es fila 1 todos son disponibles
                      
                      
                  }else{
                      //System.out.println("igual datos "+datos[o][1]);
                 //System.out.println("igual prestado  "+LibroPrestado.datosp[z][2]);
                
                      
                      
                   if(datosu[o][1]==LibroPrestado.datosp[z][2]){
                 datosu[o][columna-1]="Prestado";
                 //break;
                      // System.out.println("se eligio Prestado");
                       break;
                 }
                 else{
                 
                 datosu[o][columna-1]="Disponible";
                      // System.out.println("se eligioi disponible");
                 }   
                      
                          
                  }
                          
                 
                 
             }else{
              //System.out.println("no hay dato");
              
              //break;
             }
             
             }
            System.out.println("");   
            }
 
        }

    
    
    
    
}
