
package proyecto1;

import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.DefaultCellEditor;
import javax.swing.*;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


public class PrestarLibro implements ActionListener {
    static String datos[][];
    String temporal[][];
    String  nopres[][];
    
    static JPanel panel;
    JTable table,table2;
    
    //para busqueda
    JLabel lbus;
    JTextField cbus;
    JButton bbus;
    //para busqueda
    
    int fila =Libro.fila;
    int columna =9;

    JComboBox comboBox ;
    JScrollPane scrollPane,scrollPane2;
    JCheckBox cb1, cb2;
    JButton bon,bon2;
    
    JLabel a1;
    
    
    //componentes de subventana
        JFrame frames;
        JPanel pan;
        JComboBox lista ,lista2;
        JLabel lab1,lab2;
        JButton bpres;
    //termina
    int parar;
    LibroPrestado pres;
    int filacon;
    String actual;
    
    int vcf;
    int vcc;
    
    
    public PrestarLibro(){
        pres = new LibroPrestado();
    datos = new String[fila][columna];
    temporal = new String[fila][columna];
    
    nopres =new String[fila][columna];
    
    System.out.println("se ejecuto constructor prestar libro");
    propanel();
    boton();
    boton2();
    tabla();
    buscar();
    ingresa();
    tablatemp();
    frames.setVisible(false);
    }

    public void propanel(){
      panel = new JPanel();
      panel.setLayout(null);
      panel.setVisible(false);
        System.out.println("se ejecuto panel y contenido");
    }
    public void Consulta(){
        //campos columnas
//        for(int i=0;i<=fila-1;i++){
//            
//            if(Libro.matriz[i][0]==null){
//            
//            }else{
//                nopres[i][0]=Libro.matriz[i][0];
//                if(nopres[i][1]==null){
//                nopres[i][1]="0";
//                }else{
//                
//                }
//            }  
//        }
    
        //libro= new Libro(0);
        for(int i=0;i<=fila-1;i++){
                    for(int j=0;j<=columna-3;j++){
                        
                    if((Libro.matriz[i][j]==null)||(Libro.matriz[i][j].isEmpty())){
                        
                    }else{
                        
                    datos[i][j]=Libro.matriz[i][j];
                    
                    
                    if((datos[i][8]==null)||(datos[i][8].isEmpty())){  
                    datos[i][8]="Disponible";
                    }else if(datos[i][8]=="Prestado"){
                        compara2();
                    }else{
                        compara2();
                    }
                    
                    if((datos[i][7]==null)||(datos[i][7]=="")||(datos[i][7].isEmpty()) ){
                    datos[i][7]="0";
                    }else{

                    }
                    
                    
                    }
                     
                    }
                   

        System.out.println("");
        }

    
    }
    public void tabla(){
        
        String[] columnNames = {"ID","Nombre", "Autor","Tipo","Dia","Mes","Ano","Veces Prestado","Check"};
        table = new JTable(datos, columnNames){
         @Override
         public boolean isCellEditable(int row,int column){
             
             if(datos[row][columna-1]==null){
                
                
                 return false;
            }if(column<=columna-2){
              return false;
              }else{
             return true;
             }
            
             
             
             
        }
        };
        
        
        //paraseleccionar bueno
        //TableColumn sportColumn = table.getColumnModel().getColumn(10);
        //JComboBox comboBox = new JComboBox();
        //comboBox.addItem("Prestado");
        //comboBox.addItem("Disponible");
        //sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
        
        //para seleccionar bueno
        //table.setVisible(true);
        
        //table.setBounds(100, 20, 600, 330);
        
       
        TableColumn sportColumn = table.getColumnModel().getColumn(columna-1);
        comboBox = new JComboBox();
        comboBox.addItem("Prestado");
        comboBox.addItem("Disponible");
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
        comboBox.setVisible(true);

        table.getModel().addTableModelListener(new TableModelListener() {
      @Override
      public void tableChanged(TableModelEvent e) {
          
           TableModel modelo = ((TableModel) (e.getSource()));
            int filax = e.getFirstRow();
            int columnax = e.getColumn();
            
            if((comboBox.getSelectedItem()=="Prestado")&&(columnax==(columna-1))){ 
            ingresa2(filax,columnax);
            frames.setVisible(true);

            
            }else if((comboBox.getSelectedItem()=="Disponible")&&(columnax==(columna-1))){ 
                System.out.println("disponible");
            compara2();
            }
            
            
      }
        });
       
        
        
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 150, 780, 330);
        scrollPane.setVisible(false);
        //table.add
        panel.add(scrollPane);
   
    }
    
    
    private void boton(){
    bon = new JButton(" Actualizar");
    bon.setBounds(600, 500, 100, 30);
    bon.addActionListener(this);
    panel.add(bon);
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        ingresa();
        if(e.getSource()==bon){
        
    if(NuevoLibro.vali!=1){
        System.out.println("no hay datos que mostrar");
        
    }else{
        
        panel.remove(cbus);
        panel.remove(bbus);
        panel.remove(lbus);
        
        
        
        
        panel.remove(scrollPane2);
        panel.add(scrollPane2);
        scrollPane2.setVisible(false);
        panel.remove(bon2);
        scrollPane.setVisible(false);
        panel.remove(scrollPane);
        
        
        //compara2();
        Consulta(); 
        //compara2();
        
        tabla();
        
        boton2();
        buscar();
        
        ingresa();
        
        bbus.setVisible(true);
        lbus.setVisible(true);
        cbus.setVisible(true);
        scrollPane.setVisible(true);
        bon2.setVisible(true);

        table.getValueAt(1, 2);
        System.out.println("valo si cambia jaj"+table.getValueAt(1, 2));

        
        
        
    }
        }else if(e.getSource()==bon2){

        System.out.println("se ejecuto bon2 para mostrar ingresar");
        ingresa();
        frames.setVisible(true);
                
        
        
        }
    
    
    }
    

    private void ingresa(){
        frames= new JFrame();
        frames.setTitle("Prestamo de Libro");                  
        frames.setSize(400, 500);                                 
        frames.setLocationRelativeTo(null);                       
        frames.setLayout(new GridLayout(1, 1));
        frames.setResizable(false);     
        frames.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
        frames.setVisible(false);
        
        
        
        pan = new JPanel();
        pan.setLayout(null);
        pan.setVisible(true);
        
        
        
        lab1 = new JLabel("Seleccione Usuario");
        lab1.setBounds(100,10,200,20);
        
        lista = new JComboBox();
        lista.setBounds(100, 30, 200, 30);
        
        lab2 = new JLabel("Selecciones Libro");
        lab2.setBounds(100,60,200,20);
        
        lista2 = new JComboBox();
        lista2.setBounds(100, 80, 200, 30);

        
        bpres = new JButton("Guardar");
        bpres.setBounds(100,150,200,20);
        
        if(NuevoLibro.vali!=1){
        }else{
        for(int i=0;i<=fila-1;i++){
            if((NuevoUsuario.informa[i][1]==null)||(NuevoUsuario.informa[i][1].isEmpty()) ){
            }else{
            lista.addItem(NuevoUsuario.informa[i][1]);
            }
        }
        }
        
        
        if(NuevoLibro.vali!=1){
        }else{
        for(int i=0;i<=fila-1;i++){
            if((Libro.matriz[i][0]==null)||(Libro.matriz[i][0].isEmpty()) ){
            }else{
            lista2.addItem(Libro.matriz[i][1]);
            
            }
        }
        }
        
        
        
        
        lista.setVisible(true);
        pan.add(lista);
        lista2.setVisible(true);
        pan.add(lista2);
        pan.add(lab1);
        pan.add(lab2);
        pan.add(bpres);
        
        pan.setVisible(true);
        frames.add(pan);
        
        
        bpres.getModel().addActionListener(new ActionListener() {
        @Override
      public void actionPerformed (ActionEvent e)
      {
          String usuario = (String) lista.getSelectedItem();
          //String txtp1 = txt1.getText();
          String list2 = (String) lista2.getSelectedItem();
          if((usuario==null)||(list2==null)){
          frames.setVisible(false);
          JOptionPane.showMessageDialog(panel, "Falta dato", " Prestar", 0);
          frames.setVisible(false);
          }else{
          pres.Agrega(usuario, list2);
          frames.setVisible(false);
          //JOptionPane.showMessageDialog(panel, "Se ha Prestado", " Prestar", 1);
          
          }
          //System.out.println("valor de la lista"+categoria1);
          System.out.println("se ejecuto evento boton interno bueno");
          
          
      }});
    }
    private void boton2(){
     
        bon2 = new JButton(" Prestar");
        bon2.setBounds(600, 20, 100, 30);
        bon2.addActionListener(this);
        bon2.setVisible(false);
        panel.add(bon2);
        
        
    }
    
    
    private void ingresa2(int filas , int columnas){
       vcf=filas;
       vcc=columnas;
        frames= new JFrame();
        frames.setTitle("Prestamo de Libro");                  
        frames.setSize(400, 500);                                 
        frames.setLocationRelativeTo(null);                       
        frames.setLayout(new GridLayout(1, 1));
        frames.setResizable(false);     
        frames.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
        frames.setVisible(false);
        
         pan = new JPanel();
        pan.setLayout(null);
        pan.setVisible(true);
        
        
        lab1 = new JLabel("Usuario");
        lab1.setBounds(100,10,200,20);

        lista = new JComboBox();
        lista.setBounds(100, 30, 200, 30);
        
        lab2 = new JLabel("Libro");
        lab2.setBounds(100,60,200,20);
        
        a1 = new JLabel(datos[filas][1]);
        a1.setBounds(100, 80, 200, 30);
        
        bpres = new JButton("Guardar");
        bpres.setBounds(100,150,200,20);

        
        
        
        if(NuevoLibro.vali!=1){
        }else{
        for(int i=0;i<=fila-1;i++){
            if((NuevoUsuario.informa[i][1]==null)||(NuevoUsuario.informa[i][1].isEmpty()) ){
            }else{
            lista.addItem(NuevoUsuario.informa[i][1]);
            }
        }
        }
        
        
        
        
        pan.add(lista);
        pan.add(lab1);
        pan.add(lab2);
        pan.add(a1);
        pan.add(bpres);
        
        pan.setVisible(true);
        frames.add(pan);
        
        
        bpres.getModel().addActionListener(new ActionListener() {
        @Override
      public void actionPerformed (ActionEvent e)
      {
          
           
          String usuario = (String) lista.getSelectedItem();
          System.out.println("valor de usuario"+usuario+"//////////");
          if(usuario==null){
          frames.setVisible(false);
          JOptionPane.showMessageDialog(panel, "No hay Usuario", " Prestar", 0);
          }else{
          pres.Agrega(usuario, a1.getText());
          frames.setVisible(false);
          //JOptionPane.showMessageDialog(panel, "Se ha Prestado", " Prestar", 1);
          //frames.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
          }
          
      }});
    }
    
    
    private void buscar(){
        System.out.println("buscar se ejecuto en metodo ");
        lbus= new JLabel("Escriba para buscar");
        lbus.setBounds(10, 20, 120, 30);
        
        cbus= new JTextField();
        cbus.setBounds(130, 20, 100, 30);
        
        bbus = new JButton(" Buscar");
        bbus.setBounds(10, 60, 100, 30);

        //bbus.setVisible(false);
        //panel.add(bbus);
        lbus.setVisible(false);
        panel.add(lbus);
        cbus.setVisible(false);
        panel.add(cbus);
        
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
         scrollPane2.setVisible(false);           
                   
        scrollPane.setVisible(false);        
        panel.remove(scrollPane2);
        panel.add(scrollPane2);
        scrollPane2.setVisible(false);           
                   
        scrollPane.setVisible(false);
        panel.remove(scrollPane);
        
        
        compara2();
        Consulta(); 
        compara2();
        
        tabla();

        scrollPane.setVisible(true);
               
               }
               
           }else{
           scrollPane2.setVisible(false);           
                   
        scrollPane.setVisible(false);    
           panel.remove(scrollPane);
          panel.remove(scrollPane2);
          
          compara2();
          tabla();
          resultado(buscado);
          tablatemp();
          
          scrollPane2.setVisible(true);
          panel.add(scrollPane2);
           }
           
          
         
              
            
            
            
            
        }
    
    
    
    });
        
        
        
        
        /*
        
        
        bbus.getModel().addActionListener(new ActionListener() {
        @Override
      public void actionPerformed (ActionEvent e)
      {
          temporal = new String[fila][columna];
           String buscado = cbus.getText().trim();

          if(buscado!=null){
          
              if((buscado=="")||(buscado.isEmpty())){
                  JOptionPane.showMessageDialog(panel, "No se escribio nada ", " Agregar", 0);
          }else{
              
             
                  
                   panel.remove(scrollPane);
          panel.remove(scrollPane2);

          
          compara();
          tabla();
          
          resultado(buscado);
          tablatemp();
          scrollPane2.setVisible(true);
          panel.add(scrollPane2);

          
          System.out.println("se ejecuto evento boton interno bueno");
              
              
              
              }
          }else{
          JOptionPane.showMessageDialog(panel, "No se escribio nada ", " Agregar", 0);
          }
         
          
          
      }});
        */
    }
    private void resultado(String busqueda){
        //boolean flag = false;
        //datos
        
        //primer for
        
        //fila 20
        //columna 8
        for(int s=0;s<=fila-1;s++){
            //segundo for
            for(int g=0;g<=columna-1;g++){

                

                                //fila s columna g para consultar
                                if(busqueda.equals(datos[s][g])){ 

                                    System.out.println("se encontro uno"+s);

                                            for(int i=0;i<=fila-1;i++){


                                                    if((temporal[i][0]==null)||(temporal[i][0].isEmpty() )){
                                                                        
                                                                        int agre= i+1;
                                                                        String id= Integer.toString(agre);
                                                                        temporal[i][0]=id;

                                                                        for(int j=1;j<=columna-2;j++){
                                                                            temporal[i][j]=datos[s][j];
                                                                            temporal[i][8]=datos[s][columna-1];
                                                                            } 

                                                                        break;

                                                            }else{

                                                            }
                                         }

                                   //final si es 
                                }else{
                                    
        
       
        /*
        scrollPane.setVisible(false);
        panel.remove(scrollPane);
        compara2();
        Consulta(); 
        compara2();
        
        tabla();

        scrollPane.setVisible(true);
        */


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
    
     String[] columnNames = {"ID","Nombre", "Autor","Tipo","Dia","Mes","Ano","Veces Pretado","chec"};
        //table2 = new JTable(temporal, columnNames);
        table2 = new JTable(temporal, columnNames){
         @Override
         public boolean isCellEditable(int row,int column){
             
             if(temporal[row][columna-1]==null){
                return false; 
            }else if(column<columna-1){
            
            return false;
            }else{
             return true;
             }
            
        }
        };
        
        
        scrollPane2 = new JScrollPane(table2);
        scrollPane2.setBounds(5, 150, 780, 330);
        scrollPane2.setVisible(false);
        //table.add
        TableColumn sportColumn = table2.getColumnModel().getColumn(columna-1);
        comboBox = new JComboBox();
        comboBox.addItem("Prestado");
        comboBox.addItem("Disponible");
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
        
        table2.getModel().addTableModelListener(new TableModelListener() {
      @Override
      public void tableChanged(TableModelEvent e) {
          System.out.println("se ejecuto evento tabal");
          System.out.println("valor de ingreso "+comboBox.getSelectedItem());
          
            compara2();
           TableModel modelo = ((TableModel) (e.getSource()));
            int filax = e.getFirstRow();
            int columnax = e.getColumn();
            
            
            if((comboBox.getSelectedItem()=="Prestado")&&(columnax==(columna-1))){ 
            ingresa3(filax,columnax);
            frames.setVisible(true);
                System.out.println("se ejecuto prestado busqeuda");
            
            }else if((comboBox.getSelectedItem()=="Disponible")&&(columnax==(columna-1))){ 
                System.out.println("se ejcuto disponible busqueda");
            compara2();
            }
            
            
      }
        });
        
        
        
        
        
        comboBox.setVisible(true);
        panel.add(scrollPane2);
    
    
    
    
    }
    
//    private void compara(){
//        for(int o=0;o<=fila-1;o++){
//          
//            for(int z=0;z<=columna-1;z++){
//                
//                
//             if((LibroPrestado.datosp[z][2]!=null)){
//                 
//                 //si contiene algo diferente de nulo
//                  if(datos[o][1]==null){
//                      //si es fila 1 todos son disponibles
//                      
//                      
//                  }else{
//                      
//                   if(datos[o][1]==LibroPrestado.datosp[z][2]){
//                 datos[o][columna-1]="Prestado";
//                 break;
//                 }
//                 else{
//                 
//                 datos[o][columna-1]="Disponible";
//                 }   
//                      
//                          
//                  }
//                          
//                 
//                 
//             }else if(z==(0)){
//                 
//                 
//             for(int q=0;q<=fila-1;q++){
//                 if((datos[q][columna-1]==null)){
//                 
//                 }else{
//                 
//                 datos[q][columna-1]="Disponible";
//                 }
//             }
//             
//             
//             
//             }else{
//                 
//             }
//             
//             }
//             
//             
//             
//            }
//            
//        }
//  
    
    public void compara2(){
        for(int o=0;o<=fila-1;o++){
          
            for(int z=0;z<=fila-1;z++){
                
             //crear otro for porque este esta limitado  
             if((LibroPrestado.datosp[z][2]!=null)){
                 
                 //si contiene algo diferente de nulo
                 //System.out.println("valor datos "+datos[o][1]);
                 //System.out.println("valor prestado  "+LibroPrestado.datosp[z][2]);
                
                  if(datos[o][1]==null){
                      //si es fila 1 todos son disponibles
                      
                      
                  }else{
                      //System.out.println("igual datos "+datos[o][1]);
                 //System.out.println("igual prestado  "+LibroPrestado.datosp[z][2]);
                
                      
                      
                   if(datos[o][1]==LibroPrestado.datosp[z][2]){
                 datos[o][columna-1]="Prestado";
                 //break;
                      // System.out.println("se eligio Prestado");
                       break;
                 }
                 else{
                 
                 datos[o][columna-1]="Disponible";
                      // System.out.println("se eligioi disponible");
                 }   
                      
                          
                  }
                          
                 
                 
             }else{
              //System.out.println("no hay dato");
              
              //break;
             }
             
             }//final for2
            System.out.println("");   
            }//final for1
 
        }

    private void ingresa3(int filas , int columnas){
       vcf=filas;
       vcc=columnas;
        frames= new JFrame();
        frames.setTitle("Prestamo de Libro");                  
        frames.setSize(400, 500);                                 
        frames.setLocationRelativeTo(null);                       
        frames.setLayout(new GridLayout(1, 1));
        frames.setResizable(false);     
        frames.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
        frames.setVisible(false);
        
         pan = new JPanel();
        pan.setLayout(null);
        pan.setVisible(true);
        
        
        lab1 = new JLabel("Usuario");
        lab1.setBounds(100,10,200,20);

        lista = new JComboBox();
        lista.setBounds(100, 30, 200, 30);
        
        lab2 = new JLabel("Libro");
        lab2.setBounds(100,60,200,20);
        
        a1 = new JLabel(temporal[filas][1]);
        a1.setBounds(100, 80, 200, 30);
        
        bpres = new JButton("Guardar");
        bpres.setBounds(100,150,200,20);

        
        
        
        if(NuevoLibro.vali!=1){
        }else{
        for(int i=0;i<=fila-1;i++){
            if((NuevoUsuario.informa[i][1]==null)||(NuevoUsuario.informa[i][1].isEmpty()) ){
            }else{
            lista.addItem(NuevoUsuario.informa[i][1]);
            }
        }
        }
        
        
        
        
        pan.add(lista);
        pan.add(lab1);
        pan.add(lab2);
        pan.add(a1);
        pan.add(bpres);
        
        pan.setVisible(true);
        frames.add(pan);
        
        
        bpres.getModel().addActionListener(new ActionListener() {
        @Override
      public void actionPerformed (ActionEvent e)
      {
          
          String usuario = (String) lista.getSelectedItem();
          
          if(usuario==null){
          frames.setVisible(false);
          JOptionPane.showMessageDialog(panel, "No hay Usuario", " Prestar", 0);
          }else{
          
          
          pres.Agrega(usuario, a1.getText());
          frames.setVisible(false);
          
          //frames.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
          }
          
      }});
    }
    
    
    
    }

   
    
    
    


