
package proyecto1;

import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class Reporte implements ActionListener{
 
    JFrame frames;
       JPanel pan;
       JLabel lab1,lab2,a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18;
       JComboBox lista;
       JButton bpres;

    static JPanel panels;

    
    JButton boton;
    JTable tables;
    JScrollPane scroll;
    int fila = Libro.fila;
    int columna= 14;
    static String[][] reporte;
    static int valor;
    static int contador;
    int confi;
    
    
    public Reporte(){ 
        reporte = new String[fila][columna];
        confi=0;
        valor=0;
        contador=0;
        panelNL();
        tabla();
             
    }

    private void tabla(){
    
    String[] columnNames = {"ID","Usuario","Nombre", "Autor","Tipo","Dia","Mes","Ano","Hor","Min","Seg","Condi","Moroso","Info"};
    
        
        tables = new JTable(reporte, columnNames){
         @Override
         public boolean isCellEditable(int row,int column){
             
             if((reporte[row][columna-1]!=null)&&(column==columna-1)){
             return true;
             }else{
             return false;
             }
             
             
            
        }
        };
        
        
        
        TableColumn agrega = tables.getColumnModel().getColumn(columna-1);
        lista = new JComboBox();
        lista.addItem("----------");
        lista.addItem("Info");
        agrega.setCellEditor(new DefaultCellEditor(lista));
        lista.setVisible(true);
        
        
         tables.getModel().addTableModelListener(new TableModelListener() {
      @Override
      public void tableChanged(TableModelEvent e) {
           System.out.println("se ejecuto evento de la tabla");
           TableModel modelo = ((TableModel) (e.getSource()));
           
            int filax = e.getFirstRow();
            int columnax = e.getColumn();
            String selec = (String) lista.getSelectedItem();
            if((selec=="Info")&&(columnax==(columna-1))){ 
                
            muestra(filax,columnax);
            frames.setVisible(true);

            
            }else{ 
                
            }
            
            
      }
        });
        
        
        

        
        scroll = new JScrollPane(tables);
        scroll.setBounds(5, 150, 780, 330);
        scroll.setVisible(false);
        //table.add
        panels.add(scroll);
    
    }
    
    
     public void ingresa(String id,String user,String nomb,String autor,String tipo,String dia,String mes,String ano,String hora,String min,String seg,String esta,String mora){
        //campos columnas
        
         System.out.println(id);
         System.out.println(user);
         System.out.println(nomb);
         System.out.println(autor);
         System.out.println(tipo);
         System.out.println(dia);
         System.out.println(mes);
         System.out.println(ano);
         System.out.println(hora);
         System.out.println(min);
         System.out.println(seg);
         System.out.println(esta);
         System.out.println(mora);
         
         
         
         
     
     if((id==null)||(user==null)||(nomb==null)||(autor==null)||(tipo==null)||(dia==null)||(mes==null)||(ano==null)||(hora==null)||(min==null)||(seg==null)||(mora==null) ){
         System.out.println("falta un dato ");
     }else{
     
     
     for(int i=0;i<=fila-1;i++){
     
     if((reporte[contador][0]==null)||(reporte[contador][0].isEmpty())){
         
         reporte[contador][0]=id;
         reporte[contador][1]=user;
         reporte[contador][2]=nomb;
         reporte[contador][3]=autor;
         reporte[contador][4]=tipo;
         reporte[contador][5]=dia;
         reporte[contador][6]=mes;
         reporte[contador][7]=ano;
         reporte[contador][8]=hora;
         reporte[contador][9]=min;
         reporte[contador][10]=seg;
         reporte[contador][11]=esta;
         reporte[contador][12]=mora; 
         reporte[contador][13]="info";
     valor=1;
     contador++;
     break;
     }else{
     
     }  
     }
     
     
     
     }
         

    }
    
    
    
    private void panelNL(){



    panels = new JPanel();
    panels.setLayout(null);
    
    boton = new JButton(" Actualizar");
    boton.setBounds(550,20,100,30);
    boton.addActionListener(this);
    //boton.addActionListener(this);
    
    panels.add(boton);
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("valor "+valor);
        if(valor==1){
        scroll.setVisible(false);
        panels.remove(scroll);
            System.out.println("asdfasd///////////////////////////"+reporte[1][2]);
             System.out.println("asdfasd///////////////////////////"+reporte[1][3]);
        tabla();
        scroll.setVisible(true);
        
        
        
        //scroll.setVisible(true);
        
        }else{
        
        
        }
        
        
    }

private void muestra(int filas , int columnas){
       
       
       
        frames= new JFrame();
        frames.setTitle("Informacion");                  
        frames.setSize(400, 500);                                 
        frames.setLocationRelativeTo(null);                       
        frames.setLayout(new GridLayout(1, 1));
        frames.setResizable(false);     
        frames.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
        frames.setVisible(false);
        
         pan = new JPanel();
        pan.setLayout(null);
        pan.setVisible(true);
        
        
        
        a1 = new JLabel("ID");
        a1.setBounds(10,10,150,20);
        
        a2 = new JLabel("Usuario");
        a2.setBounds(10,30,150,20);
        
        a3 = new JLabel("Libro");
        a3.setBounds(10,50,150,20);
        
        a4 = new JLabel("Autor");
        a4.setBounds(10,70,150,20);
        
        a5 = new JLabel("Tipo");
        a5.setBounds(10,90,150,20);
        
        a6 = new JLabel("Fecha");
        a6.setBounds(10,110,150,20);
        
        a7 = new JLabel("H/Min/S");
        a7.setBounds(10,130,150,20);
        
        a8 = new JLabel("Mora");
        a8.setBounds(10,150,150,20);
        
        
        a9 = new JLabel("Condiciones");
        a9.setBounds(10,170,150,150);
        
        
        
        
        a10 = new JLabel(reporte[filas][0]);
        a10.setBounds(160,10,200,20);
        
        a11 = new JLabel(reporte[filas][1]);
        a11.setBounds(160,30,200,20);
        
        a12 = new JLabel(reporte[filas][2]);
        a12.setBounds(160,50,200,20);
        
        a13 = new JLabel(reporte[filas][3]);
        a13.setBounds(160,70,200,20);
        
        a14 = new JLabel(reporte[filas][4]);
        a14.setBounds(160,90,200,20);
        
        a15 = new JLabel(reporte[filas][5]+"/"+reporte[filas][6]+"/"+reporte[filas][7]);
        a15.setBounds(160,110,200,20);
        
        a16 = new JLabel(reporte[filas][8]+"/"+reporte[filas][9]+"/"+reporte[filas][10]);
        a16.setBounds(160,130,200,20);
        
        a17 = new JLabel(reporte[filas][12]);
        a17.setBounds(160,150,200,20);
        
        
        a18 = new JLabel(reporte[filas][11]);
        a18.setBounds(160,170,200,20);
        
        JTextArea area = new JTextArea(reporte[filas][11]);
       area.setBounds(65, 120, 300, 200);
       area.setLineWrap(true);
       JScrollPane areas = new JScrollPane(area);
       areas.setBounds(88, 180, 300, 200);
       areas.setVisible(true);
       area.setEditable(false);
        

        
        pan.add(a1);
        pan.add(a2);
        pan.add(a3);
        pan.add(a4);
        pan.add(a5);
        pan.add(a6);
        pan.add(a7);
        pan.add(a8);
        pan.add(a9);
        pan.add(a10);
        pan.add(a11);
        pan.add(a12);
        pan.add(a13);
        pan.add(a14);
        pan.add(a15);
        pan.add(a16);
        pan.add(a17);
        //pan.add(a18);
        pan.add(areas);
        
        
        
        
        
        
        
        pan.setVisible(true);
        frames.add(pan);
        
      
    }

    
}
