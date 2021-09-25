
package proyecto1;

import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static proyecto1.NuevoUsuario.informa;

public class LibroPrestado {
    
    static String datosp[][];
    int fila=Libro.fila;
    int columna=11;
    Calendar cal = Calendar.getInstance();
    int ids;
    static int vali2;
    int imal;
    
    
    
    public LibroPrestado(){
        ids=0;
        vali2=0;
        //Libro libs = new Libro();
        datosp=new String[fila][columna];
    }
    
    
    public void Agrega(String usuario, String nombre){
            ids=0;
          
        
            if(NuevoLibro.vali!=1){
            System.out.println("no hay datos");
        
            }else{
                compara(nombre);  
                comparalib(nombre);
                
                
                if(imal==0){
                    JPanel gg = new JPanel();
                JOptionPane.showMessageDialog(gg, "El libro esta prestado", " Error", 0);
                }else{
                
                
                for(int i=0;i<=fila-1;i++){
            

            if((datosp[i][0]==null)||(datosp[i][0].isEmpty())){
                vali2=1;
                //Devolver.evento=1;
                for(int b =0;b<=fila-1;b++){
                if(NuevoUsuario.informa[b][1]==usuario){
                int temp = Integer.parseInt(NuevoUsuario.informa[b][2])+1;
                String temps = Integer.toString(temp);
                NuevoUsuario.informa[b][2]=temps;
                
                }
                
                }
                
                
              //int agre= i+1;
              //String id= Integer.toString(agre);
              
              //datosp[i][0]=id;
             for(int j=0;j<=columna-1;j++){  
              
              switch(j){
                case 0:
                    System.out.println("valor a ingrear a id> "+ids);
                  PrestarLibro.datos[ids][7]= Integer.toString( Integer.parseInt(PrestarLibro.datos[ids][7])+1 );
                  
                    
                    String id= Integer.toString(ids);  
                  
                  
                datosp[i][j]=id;      
                break;  
                  
                case 1:
                datosp[i][j]=usuario;      
                break;
                
                case 2:
                datosp[i][j]=nombre;      
                break;
                
                case 3://autor
                datosp[i][j]=Libro.matriz[ids][2];      
                break;
                
                case 4://tipo
                datosp[i][j]=Libro.matriz[ids][3];      
                break;

                case 5:
                datosp[i][j]=dia();   
                break;
                
                case 6:
                datosp[i][j]=mes();   
                break;
                
                case 7:
                datosp[i][j]=ano();      
                break;
                
                case 8:
                datosp[i][j]=hora();      
                break;
                
                case 9:
                datosp[i][j]=minutos();      
                break;
                
                case 10:
                datosp[i][j]=segundos();      
                break;
                
                
                
                default:
                break;
              }
          }
             break;
            
            }else{
            
            }

        }
                    
                JPanel l = new JPanel();
                JOptionPane.showMessageDialog(l, "Se ha Prestado", " Prestar", 1);
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
    

    public void compara(String compa){
    for(int i=0;i<=fila-1;i++){
            

            if((Libro.matriz[i][1]==compa)){
                
            ids=i;
            System.out.println("si se hayo id"+ids);
            break;
            }else{
                System.out.println("no se hayo id");
            }
        }
    }
    
    public void comparalib(String lib){
        imal=0;
    for(int i=0;i<=fila-1;i++){
            

            if(datosp[i][2]==lib){

            System.out.println("si se libro id prestado");
            imal=0;
            break;
            }else{
            imal=1;
                System.out.println("no se hayo id");
            }
        }
    }
    

}
