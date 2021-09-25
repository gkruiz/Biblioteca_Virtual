
package proyecto1;

import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Libro {
    
    
   
    static String  matriz[][];
    
    String ID;
    String nombre;
    String autor;
    String tipo;
    String fecha;
    int valoc;
    Calendar cal = Calendar.getInstance();
    
    static int fila =20;
    static int columna =7;
    
    
    
    
    
     public Libro(){
                matriz = new String[fila][columna];
     }
     
     
     
    public void Ingreso(String dat1,String dat2,String dat3){
        this.nombre=dat1;    
        this.autor=dat2;
        this.tipo=dat3;
        
         valoc=0;
    for(int q=0;q<=fila-1;q++){
        
     if(matriz[q][1]!=null){
     
    
     
    if(matriz[q][1].equals(dat1)){
        System.out.println("111111111");
        System.out.println("se ejecuto "+dat1);
        System.out.println("valor iforma"+matriz[q][1]+" 11111");
        
        JPanel pans = new JPanel();
        JOptionPane.showMessageDialog(pans, "El Libro ya existe", " Error", 0);
        
        valoc=0;
        break;
    }else{
            System.out.println("2222222222");
            System.out.println("se ejecuto "+dat1);
            System.out.println("valor iforma"+matriz[q][1]+" 222222");
            valoc=2;
            
    }
    
     }else{
     if(q==(fila-1)){
     
     valoc=2;
     }
     
     }
    }

    if(valoc==2){
        
        
        
        
        
        for(int i=0;i<=fila-1;i++){
            
            System.out.println("nomre en for"+nombre);

            if((matriz[i][0]==null)||(matriz[i][0].isEmpty() )){
                
              
              
              //int agre= i+1;
              int agre= i;
              String id= Integer.toString(agre);
              
              matriz[i][0]=id;
             for(int j=1;j<=columna-1;j++){  
              
              switch(j){
                case 1:
                matriz[i][j]=nombre;      
                break;
                
                case 2:
                matriz[i][j]=autor;      
                break;
                
                case 3:
                matriz[i][j]=tipo;      
                break;
                
                case 4:
                //dia
                String dagre= dia();
                matriz[i][j]=dagre;      
                break;
                
                case 5:
                //dia
                String magre= mes();
                matriz[i][j]=magre;      
                break;
                
                case 6:
                //dia
                String aagre= ano();
                matriz[i][j]=aagre;      
                break;
              }
          }
             JPanel wer = new JPanel();
             JOptionPane.showMessageDialog(wer, "Se ha agregado...", " Agregar", 1);
             break;
            
            }else{
            
            }
        }
        
        
        
        
    }
        
    }
    
    
    
    
    
    public String dia(){
        Date date = new Date();
        cal.setTime(date);
        
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String dia= Integer.toString(day);
        return dia;

    }
    public String mes(){

        Date date = new Date();
        cal.setTime(date);

        int month = cal.get(Calendar.MONTH)+1;
        String mes= Integer.toString(month);
        return mes;
    
    }
    public String ano(){

        Date date = new Date();
        cal.setTime(date);

        int year = cal.get(Calendar.YEAR);

        String anos= Integer.toString(year);
        
        return anos;
    
    }
    
    public String getnombre(){
    return nombre;
    }
    
    public String getautor(){
    return autor;
    }
    
    public String gettipo(){
    return tipo;
    }
  
    
    
    
    public void iniciavariable(){
    
    for(int i=0;i<=fila-1;i++){
        for(int j=0;j<=columna-1;j++){
            matriz[i][j]="1"; 
        }
        }
    }

    public String getdat(int i, int j){
        matriz[1][1]="22";
        return matriz[i][j];
        
    }
    
    
    
}