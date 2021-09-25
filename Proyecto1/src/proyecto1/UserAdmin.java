
package proyecto1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class UserAdmin {
    
    
    
    static String useradmin[][];
    static JPanel panel;
    JLabel lab1,lab2,lab3,lab4;
    JTextField caja1,caja3;
    
    JPasswordField caja2,caja4;
    
    JButton boton1;
    
    JTable user;        
    JScrollPane scro;
    JButton bpres;
    
    int fila = Libro.fila;
    int columna =3;
    
    
    
    String texto1,texto2 ;

    int valocom;
    int valitab;
    int valor;
    
    public UserAdmin(){
    valitab=0;
    panel1();
    conte();
    useradmin = new String[fila][columna];
    iniciavariable();
    //useradmin[0][0]="1";
    //useradmin[0][1]="admin";
    //useradmin[0][2]="admin";
    
    
    tabla();
    botonactu();
    }
    public UserAdmin(int is){
    
     useradmin = new String[fila][columna];
    
    //useradmin[0][1]="0";
    //useradmin[0][1]="admin";
    //useradmin[0][2]="admin";   
        
    }
    
    
    
    private void tabla(){
        
    String[] columnNames = {"ID","Usuario Administrador","Contrasena"};    
    user = new JTable(useradmin, columnNames){
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
    lab1= new JLabel("Nuevo Admin");
    lab1.setBounds(10,20,200,30);
    
    caja1 = new JTextField();
    caja1.setBounds(10,50,200,30);
    
    lab2= new JLabel("Nueva contrasena");
    lab2.setBounds(240,20,200,30);
    
    caja2 = new JPasswordField();
    caja2.setBounds(240,50,200,30);
    
    
    
    
    lab3= new JLabel("Autenticacion:Admin");
    lab3.setBounds(10,90,200,30);
    
    caja3 = new JTextField();
    caja3.setBounds(10,120,200,30);
    
    
    lab4= new JLabel("Contrasena:Admin");
    lab4.setBounds(240,90,200,30);
    
    caja4 = new JPasswordField();
    caja4.setBounds(240,120,200,30);
    
    
    
    
    
    boton1 = new JButton("Guardar");
    boton1.setBounds(460,20,100,30);
   
    //lab1.setBounds(350,20,100,30);
    
    
    
    panel.add(lab1);
    panel.add(caja1);
    panel.add(lab2);
    panel.add(caja2);
    panel.add(lab3);
    panel.add(caja3);
    panel.add(lab4);
    panel.add(caja4);
    
    
    
    panel.add(boton1);
    
    boton1.getModel().addActionListener(new ActionListener() {
        @Override
      public void actionPerformed (ActionEvent e)
      {
          texto1 = caja1.getText().trim();
          
          //texto2 = caja2.getText().trim();
          char[] arrayC = caja2.getPassword(); 
          texto2 = new String(arrayC).trim(); 
          
          char[] arrayC4 = caja4.getPassword(); 
          String texto4 = new String(arrayC4); 
          
          
          
          valor=0;
        
        for(int i=0;i<=20-1;i++){
           // System.out.println("valor consultado"+temp1+"con  "+temp2);
            System.out.println("valor consultado"+useradmin[i][1]+"con  "+useradmin[i][2]);
            if((useradmin[i][1]==null)||(useradmin[i][2]==null) ){  
            }else{
            if((useradmin[i][1]=="")||(useradmin[i][2]=="")){
            }else{   
            if((useradmin[i][1].equals(  caja3.getText().trim() ))&&(useradmin[i][2].equals(texto4))){
                //se valido el administrador antiguo
                valor=1;
                break;
            }else{
                valor=0;
            }
            }
            }
        }
          
          //va a proseguir para ingresar 
          if(valor==1){
          agregar();
          System.out.println("valor de la lista "+texto1);
          System.out.println("se ejecuto evento boton interno bueno");
         //pul1ado();
         //agregar devuelve un valo para seterar valores
          if(valitab==1){
          caja1.setText("");
          caja2.setText("");
          caja3.setText("");
          caja4.setText("");

          
          
          
          scro.setVisible(false);
          panel.remove(scro);
          tabla();
          scro.setVisible(true);
          
          }else{
          }
              
              
          }else{
          
          JPanel z= new JPanel();
        JOptionPane.showMessageDialog(z, "Usuario o contrasena mala del Administrador...", " Error", 0);
          
          }
          
          
          
          
          
      }
    
    
    });
    
    
    
}
    
    
    public void agregar(){
        
        
        if((texto1.isEmpty())||(texto1.equals(""))||(texto1.equals(null))||(texto1=="")||(texto1==null) ||  (texto2.isEmpty())||(texto2.equals(""))||(texto2.equals(null))||(texto2=="")||(texto2==null)      ){  
            System.out.println("valor texto"+texto1);
            JOptionPane.showMessageDialog(panel, "Campo Vacio", " Error", 0);
        }else{
            //si esta lleno el texto a ingresar
        valocom=0;
        //valor que dice si existe o no
    for(int q=0;q<=fila-1;q++){
 
    if((useradmin[q][1].equals(texto1))){
        System.out.println("111111111");
        System.out.println("se ejecuto "+texto1);
        System.out.println("valor iforma"+useradmin[q][1]+" 11111");
        
        
        
        JOptionPane.showMessageDialog(panel, "El usuario ya existe", " Error", 0);
            caja1.setText("");
          caja2.setText("");
          caja3.setText("");
          caja4.setText("");
        
        valocom=0;
        break;
    }else{
            System.out.println("2222222222");
            System.out.println("se ejecuto "+texto1);
            System.out.println("valor iforma"+useradmin[q][1]+" 222222");
            valocom=2;
            valitab=1;
    }
    
    
    }
    //si no existe
    if(valocom==2){
    
        System.out.println("entro a valocom2");
    
    
    for(int i=1;i<=fila-1;i++){
            

            if((useradmin[i][0]=="")){
    
              int agre= i+1;
              String id= Integer.toString(agre);
              
              useradmin[i][0]=id;
              useradmin[i][1]=texto1;      
              useradmin[i][2]=texto2;      
             JOptionPane.showMessageDialog(panel, "Se ha agregado", " Nuevo Administrador", 1);
             break;
            
            }else{
                System.out.println("contiene algo useradmin");
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
          if(useradmin[0][0]!=""){
          scro.setVisible(false);
          panel.remove(scro);
          tabla();
          scro.setVisible(true);
          caja1.setText("");
          caja2.setText("");
          caja3.setText("");
          caja4.setText("");
          }else{
          
          }
      
          
          
       
          
      }});
    panel.add(bpres);
    }
    
    
  public void iniciavariable(){
    
    for(int i=0;i<=fila-1;i++){
        for(int j=0;j<=columna-1;j++){
            useradmin[i][j]=""; 
        }
        }
    }  
    
    
}
    

