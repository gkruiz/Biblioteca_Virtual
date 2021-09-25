package proyecto1;

import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;
//import static proyecto1.PrestarLibro.datos;


public class Devolver implements ActionListener{
    
    static JPanel panelde;
    JTable tablex;
    JScrollPane scrollPanex;

    int fila = Libro.fila;
    int columna =12;
    String devols[][];
    
    JButton dev;
    JComboBox comboBox;
    JCheckBox check;
    JTextArea area;
    int morosidad;
    //para deshacer
    //JTextField d, m,aa;
    JComboBox d, m,aa;
    JFrame frames;
    JPanel pan;
    JLabel lab1,lab2,lab3,lab4,lab5,lab6,a1,a2,a3,a4,ld,lm, la;
    JComboBox lista;
    JButton bpres;
    PrestarLibro libs ;
   
    
    Calendar cal = Calendar.getInstance();
    
    int contador;
    int confi;
    static int evento;

    Reporte res;      
          
    double hora1 ;
    double minutos1  ;
    double seg;
    
    int filingresa;
    int colingresa;
    JTextField as ;
    
    
    public Devolver(){
        int morosidad =10;
        res= new Reporte();
        libs = new PrestarLibro();
        
        confi=0;
        evento=0;
        devols = new String[fila][columna];
    try{    
        panel1();
        boton();
    } catch (Exception ew) { 
        System.out.println("error");
    }
        contador=0;
    }
    private void panel1(){
    panelde = new JPanel();
    panelde.setLayout(null);
    panelde.setVisible(true);
    
    }
    
    public void boton(){
        
     dev =new JButton("Actualizar");
     dev.setBounds(550,20,100,30);
     dev.addActionListener(this);
     /*
     dev.getModel().addActionListener(new ActionListener(){
     @Override
     public void actionPerformed (ActionEvent e){
         
     if(evento!=1){

     Consulta2();
     compara();
     tabla();
     
     }else{
     scrollPanex.setVisible(false);
     panel.remove(scrollPanex);
     panel.remove(comboBox);
     panel.remove(dev);
     //Consulta();
         System.out.println("se ejecito devolver mmmmmmm");
     
     Consulta2();
     tabla();
     compara();
     panel.add(dev);
     scrollPanex.setVisible(true);
     
     }

     }
     });
     */
     
     panelde.add(dev);
    }  
    
    
    public void Consulta2(){
        //campos columnas
        
     devols = new String[fila][columna];
     contador=0;
     for(int i=0;i<=fila-1;i++){
                    for(int j=0;j<=columna-2;j++){
                        
                    if((LibroPrestado.datosp[i][j]==null)||(LibroPrestado.datosp[i][j].isEmpty())){  
                        confi=0;
                    }else{
                        //System.out.println("varlor muestra"+devols[contador][j]);

                        if((devols[contador][j]==null)||(devols[contador][j].isEmpty())){   
                        devols[contador][j]=LibroPrestado.datosp[i][j];
                        
                        devols[contador][11]="Prestado";
                    //System.out.print(devols[i][j]);
                    confi=1;
                        }else{
                            confi=0;
                            //System.out.println("se ejecuto else");
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

    private void tabla(){
        try{
                
        
        if(LibroPrestado.vali2==0){
        
        
        }else{
        
            
        
        String[] columnNames = {"ID","Usuario","Nombre", "Autor","Tipo","Dia","Mes","Ano","Hor","Min","Seg","chec"};
        tablex = new JTable(devols, columnNames){
         @Override
         public boolean isCellEditable(int row,int column){
             
             if((devols[row][column]==null)||(devols[row][column]=="")||(devols[row][column].isEmpty())){
                return false; 
            }else if(column<=10){
            return false;
            
            }else{
             return true;
             }
            
        }
        };

       evento=1;
        TableColumn sportColumn = tablex.getColumnModel().getColumn(columna-1);
        comboBox = new JComboBox();
        comboBox.addItem("Prestado");
        comboBox.addItem("Regresar");
        
        
        
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
        comboBox.setVisible(true);
        
        tablex.getModel().addTableModelListener(new TableModelListener() {
      @Override
      public void tableChanged(TableModelEvent e) {
            //compara();
            //Consulta();
            //tabla();
          
            
           TableModel modelo = ((TableModel) (e.getSource()));
            int filax = e.getFirstRow();
            int columnax = e.getColumn();
            
            System.out.println("coumna editada"+columnax);
            System.out.println("valor del combox"+comboBox.getSelectedItem());
            
            if((comboBox.getSelectedItem().equals("Regresar"))&&(columnax==(columna-1))){  
                System.out.println("se ejecuto lo de adentro");
            
            ingresa3(filax,columnax);
            frames.setVisible(true);
            scrollPanex.setVisible(false);
            panelde.remove(scrollPanex);
            
            compara();
            Consulta2();
            tabla();
            //libs.compara2();
            //libs.Consulta(); 
            //libs.compara2();
        
            //libs.tabla();
            
            
            
            }else { 
                System.out.println("disponible");
            scrollPanex.setVisible(false);
            panelde.remove(scrollPanex);
            compara();
            Consulta2();
            tabla();
            
            //libs.compara2();
            //libs.Consulta(); 
            //libs.compara2();
        
            //libs.tabla();
            
            }
            
            
      }
        });
       
        
        
        scrollPanex = new JScrollPane(tablex);
        scrollPanex.setBounds(5, 150, 780, 330);
        scrollPanex.setVisible(true);
        //table.add
        panelde.add(scrollPanex);
            
            
            
            
            
            
        }
        
        
        }catch (Exception ew) { 
        System.out.println("error");
    }
        
   
    }
    
     private void compara(){
      try{
     
        for(int o=0;o<=fila-1;o++){
          
            for(int z=0;z<=columna-2;z++){
                
                
             if((LibroPrestado.datosp[z][2]!=null)){
                 
                 
                  if(PrestarLibro.datos[o][1]==null){
                      //si es fila 1 todos son disponibles
                      
                      
                  }else{
                      
                   if(PrestarLibro.datos[o][1]==LibroPrestado.datosp[z][2]){
                 PrestarLibro.datos[o][columna-4]="Prestado";
                 break;
                 }
                 else{
                 
                 PrestarLibro.datos[o][columna-4]="Disponible";
                 }   
                      
                          
                  }
                          
                 
                 
             }else if(z==(0)){
                 
                 
             for(int q=0;q<=fila-1;q++){
                 if((PrestarLibro.datos[q][columna-4]==null)){
                 
                 }else{
                 
                 PrestarLibro.datos[q][columna-4]="Disponible";
                 }
             }
             
             
             
             }else{
                 
             }
             
             }
             
             
             
            }
        
      }catch (Exception ew) { 
        System.out.println("error");
    }
            
        }
    
     
      private void ingresa3(int filas , int columnas){
          try{
          filingresa=0;
          colingresa=0;
          
          filingresa=filas;
          colingresa=columnas;
          
       
        frames= new JFrame();
        frames.setTitle("Devolver de Libro");                  
        frames.setSize(400, 400);                                 
        frames.setLocationRelativeTo(null);                       
        frames.setLayout(new GridLayout(1, 1));
        frames.setResizable(false);     
        frames.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
        frames.setVisible(false);
        
         pan = new JPanel();
        pan.setLayout(null);
        pan.setVisible(true);
        

        lab1 = new JLabel("Libro");
        lab1.setBounds(50,10,200,20);
        
        a1 = new JLabel(devols[filas][2]);
        a1.setBounds(50, 25, 200, 30);
        
        lab2 = new JLabel("Usuario");
        lab2.setBounds(50,50,200,20);
        //600*500
        a2 = new JLabel(devols[filas][1]);
        a2.setBounds(50, 65, 200, 30);
        
        lab6 = new JLabel("Estado Libro");
        lab6.setBounds(50,95,200,20);
        
        ld= new JLabel("D:");
        ld.setBounds(210,95,20,20);
        
        d = new JComboBox();
        for(int i=1;i<=31;i++){
        d.addItem(i);
        }
        d.setBounds(210,95,50,20);
      
        
        
        lm= new JLabel("M:");
        lm.setBounds(255,95,20,20);
        
        m = new JComboBox();
        for(int i=1;i<=12;i++){
        m.addItem(i);
        }
        m.setBounds(260,95,50,20);

        
        
        la= new JLabel("A:");
        la.setBounds(295,95,20,20);
        
        aa = new JComboBox();
        aa.setBounds(310,95,40,20);
        
        for(int i=0;i<=7;i++){
        aa.addItem(2017+i);
        }
        
        //pan.add(ld);
        pan.add(d);
        //pan.add(lm);
        pan.add(m);
        //pan.add(la);
        pan.add(aa);
        
        lab3 = new JLabel("Fecha Prestamo:D/M/A");
        lab3.setBounds(210,10,200,20);
        
        a3 = new JLabel(devols[filas][columna-7]+"/"+devols[filas][columna-6]+"/"+devols[filas][columna-5]);
        a3.setBounds(210, 25, 400, 30);        
        
        
        
        lab4 = new JLabel("Tiempo Prestado: H / M /S");
        lab4.setBounds(210,50,200,20);
        
        
        //para la hora
        //int numero1 = Integer.parseInt(hora())-Integer.parseInt(devols[filas][columna-4]);
        //int numero2 = Integer.parseInt(minutos())-Integer.parseInt(devols[filas][columna-3]);
        double numero1 =Integer.parseInt(devols[filas][columna-4]);
        double numero2 =Integer.parseInt(devols[filas][columna-3]);
        double numero3 =Integer.parseInt(devols[filas][columna-2]);
        
        double tiempo1= numero1*3600 +numero2*60+numero3;
        double tiempo2=  (Integer.parseInt(hora())*3600) + (Integer.parseInt(minutos())*60 )+ Integer.parseInt(segundos()); 
        
        double tiempouso= tiempo2-tiempo1;
        hora1=999;
        minutos1=999;
        seg=999;
        
        
        
        if(tiempouso<=59){
         hora1 =0;
         minutos1=0;
         
         seg = tiempouso;
            
        }else if((tiempouso<=3599)&&(tiempouso>=60)){
            
        hora1 =0;
        minutos1 = (int) (tiempouso/60);
        double  minutos2 = tiempouso/60;
        
        seg = Math.round((minutos2-minutos1)*60);
            
        
        }else if(tiempouso>=3600){
            
        hora1= (tiempouso/3600);////////////////////
        int hora2=(int)(tiempouso/3600);
        
        double mindeci =(hora1-hora2)*3600;//num entero de segundos
        minutos1 = (int) (mindeci/60);
        double minutos2 = mindeci/60;
        
        
        seg = Math.round((minutos2-minutos1));
            
        }
        
        
       //a3 = new JLabel("H / M /S"); 
       
       a4 = new JLabel(hora1+"/"+minutos1+"/"+seg);
       a4.setBounds(210, 65, 200, 30);
       //a3 = new JLabel("  tiempo1 "+tiempo1+"  tiempo2 "+tiempo2);
      
       
       area = new JTextArea(5, 20);
       area.setBounds(65, 120, 300, 200);
       area.setLineWrap(true);
       JScrollPane areas = new JScrollPane(area);
       areas.setBounds(65, 120, 300, 200);
       areas.setVisible(true);
       
       check = new JCheckBox();
       check.setBounds(21, 200, 30, 30);
       
       lab5= new JLabel("Moroso");
       lab5.setBounds(10, 165, 65, 30);
       
       as = new JTextField();
       as.setBounds(10, 250, 30, 20); 
       as.addKeyListener(new KeyListener(){
              @Override
              public void keyTyped(KeyEvent e) {
                  }

              @Override
              public void keyPressed(KeyEvent e) {
             }

              @Override
              public void keyReleased(KeyEvent e) {
                  try{
                   morosidad = Integer.parseInt(as.getText().trim());
                  }
                  catch(Exception w){
                      System.out.println(".");
                  
                  }
             
                  
              }
       
       
       
       
       });
        
        bpres = new JButton("Guardar");
        bpres.setBounds(150,330,100,30);

        
        
        
        
        
        
        
        //pan.add(lista);
        pan.add(as);
        pan.add(check);
        pan.add(areas);
        pan.add(lab1);
        pan.add(lab2);
        pan.add(lab3);
        pan.add(lab4);
        pan.add(lab5);
        pan.add(lab6);
        pan.add(a1);
        pan.add(a2);
        pan.add(a3);
        pan.add(a4);
        pan.add(bpres);
        
        pan.setVisible(true);
        frames.add(pan);
        
        
        bpres.getModel().addActionListener(new ActionListener() {
        @Override
      public void actionPerformed (ActionEvent e)
      {
          Reporte.valor=1;
          
         int defe=0;
         String moras =null;
         String moras2=null;
         
          System.out.println("valor de morosidad 2"+moras2);
        
       System.out.println("an;os"+aa.getSelectedItem().toString());
       System.out.println("casilla"+devols[filingresa][7]);
       int da1 = Integer.parseInt(d.getSelectedItem().toString());
       int me1 =  Integer.parseInt(m.getSelectedItem().toString())*31;   
       int aa1= Integer.parseInt(aa.getSelectedItem().toString())*365;   
       int suma1= da1+me1+aa1;
       int da2 = Integer.parseInt(devols[filingresa][5]);
       int me2 =  Integer.parseInt(devols[filingresa][6])*31;
       int aa2= Integer.parseInt(devols[filingresa][7])*365;
       int suma2= da2+me2+aa2;
       
       
       
        if(suma1>suma2){
        if((suma1-suma2)>morosidad){
           moras2="Moroso";
        }else{
        moras2="No Moroso";
        }
            
//       String days =(String)d.getSelectedItem();
//       String mex =  (String)m.getSelectedItem();   
//       String anos= (String)aa.getSelectedItem();
       String days =d.getSelectedItem().toString();
       String mex =  m.getSelectedItem().toString();   
       String anos= aa.getSelectedItem().toString();  
       
       
       //.toString()
        devols[filingresa][5]= days;
        devols[filingresa][6]= mex;
        devols[filingresa][7]= anos;
            defe=1;
        }else{
         JOptionPane.showMessageDialog(pan, "Fecha Erronea", " Error", 0);
         defe=0;
        }
        
        
        if(check.isSelected()==true){
        moras = "Moroso";
         }else{
        moras = "No Moroso";
        }
        //moras select
        //moras2 asigna tiempo
       
        if((moras=="No Moroso")&&(moras2=="No Moroso")){
        
        }else if((moras=="No Moroso")&&(moras2=="Moroso")){
        
            moras="Moroso";
        }else if((moras=="Moroso")&&(moras2=="No Moroso")){
        
        
        
        }else if((moras=="Moroso")||(moras2=="Moroso")){
        
        }
       
        
//        }else{
//        moras = "No Moroso";
//        int da1 = Integer.parseInt(d.getSelectedItem().toString());
//        int me1 =  Integer.parseInt(m.getSelectedItem().toString())*31;   
//       int aa1= Integer.parseInt(aa.getSelectedItem().toString())*365;   
//       int suma1= da1+me1+aa1;
//       
//       int da2 = Integer.parseInt(devols[filingresa][5]);
//       int me2 =  Integer.parseInt(devols[filingresa][6])*31;
//       int aa2= Integer.parseInt(devols[filingresa][7])*365;
//       int suma2= da2+me2+aa2;
//       
//       
//       
//        if(suma1>suma2){
////       String days =(String)d.getSelectedItem();
////       String mex =  (String)m.getSelectedItem();   
////       String anos= (String)aa.getSelectedItem();
//       String days =d.getSelectedItem().toString();
//       String mex =  m.getSelectedItem().toString();   
//       String anos= aa.getSelectedItem().toString();  
//       
//       
//       //.toString()
//        devols[filingresa][5]= days;
//        devols[filingresa][6]= mex;
//        devols[filingresa][7]= anos;
//            defe=1;
//        }else{
//         JOptionPane.showMessageDialog(pan, "Fecha Erronea", " Error", 0);
//         defe=0;
//        }
//        
//
//        
//        
//        
//        }
          
          System.out.println("valor de defe"+defe);
        if(defe==1){
            
            
         res.ingresa(devols[filingresa][0], devols[filingresa][1], devols[filingresa][2], devols[filingresa][3], devols[filingresa][4], devols[filingresa][5], devols[filingresa][6], devols[filingresa][7], hora(), minutos(), segundos(), area.getText(), moras);

        for(int b =0;b<=fila-1;b++){
                if(NuevoUsuario.informa[b][1]==devols[filingresa][1]){
                NuevoUsuario.informa[b][3]=moras;
                }
                }
        
        for(int t =0;t<=fila-1;t++){
              System.out.println("libro borrado"+a1.getText());
              
              if(LibroPrestado.datosp[t][2]!=null){
           if(LibroPrestado.datosp[t][2].equals(a1.getText())){
               for(int c =0;c<=columna-2;c++){   
               LibroPrestado.datosp[t][c]=null;
               }
          }
          }else{
              }
              
            
          }

          frames.setVisible(false);
          JOptionPane.showMessageDialog(panelde, "Se ha Devuelto", " Prestar", 1);
          //frames.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
          scrollPanex.setVisible(false);
            panelde.remove(scrollPanex);
            compara();
            Consulta2();
            compara();
            
            tabla();
        
        
        
        
        }else{
            
//        res.ingresa(devols[filingresa][0], devols[filingresa][1], devols[filingresa][2], devols[filingresa][3], devols[filingresa][4], devols[filingresa][5], devols[filingresa][6], devols[filingresa][7], devols[filingresa][8], devols[filingresa][9], devols[filingresa][10], area.getText(),moras );
//          
//        for(int b =0;b<=fila-1;b++){
//                if(NuevoUsuario.informa[b][1]==devols[filingresa][2]){
//                NuevoUsuario.informa[b][3]=moras;
//                
//                }
//                }
        
        
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
          
//          for(int t =0;t<=fila-1;t++){
//              System.out.println("libro borrado"+a1.getText());
//              
//              if(LibroPrestado.datosp[t][2]!=null){
//           if(LibroPrestado.datosp[t][2].equals(a1.getText())){
//               for(int c =0;c<=columna-2;c++){   
//               LibroPrestado.datosp[t][c]=null;
//               }
//          }
//          }else{
//              }
//              
//            
//          }
//
//          frames.setVisible(false);
//          JOptionPane.showMessageDialog(panelde, "Se ha Devuelto", " Prestar", 1);
//          //frames.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
//          scrollPanex.setVisible(false);
//            panelde.remove(scrollPanex);
//            compara();
//            Consulta2();
//            compara();
//            
//            tabla();
        
        //libs.compara2();
        //libs.Consulta(); 
        //libs.compara2();
        
        //libs.tabla();
          
          
          
          
      }});
        }catch (Exception ew) { 
        System.out.println("error");
    }
    }
      
      public String hora(){
        Date date = new Date();
        cal.setTime(date);

        int hora =cal.get(Calendar.HOUR_OF_DAY);
        String hor = Integer.toString(hora);
        return hor;
    
    }  
    public String minutos(){
        Date date = new Date();
        cal.setTime(date);

        int minutos = cal.get(Calendar.MINUTE);

        String min = Integer.toString(minutos);

        return min;
    
    }
    public String segundos(){
        Date date = new Date();
        cal.setTime(date);

        int segundos = cal.get(Calendar.SECOND);

        String seg = Integer.toString(segundos);

        return seg;
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("evento0"+evento);
        
        
        
      if(evento!=1){

          System.out.println("se metio vento 0");
          
     compara();
     Consulta2();
     tabla();
     
     }else{
     scrollPanex.setVisible(false);
     panelde.remove(scrollPanex);


         System.out.println("se ejecito devolver mmmmmmm");
     
     Consulta2();
     tabla();
     scrollPanex.setVisible(true);
     
     }  
        
        
        
    }
      
      
      
      
    
    
}