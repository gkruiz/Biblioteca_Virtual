
package proyecto1;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class Proyecto1 {

    static int insta;
    static int insta2;
    static int panpres;
    static String usera;
    
    public static void main(String[] args) {
        usera="";
        insta=0;
        insta2=0;
        panpres=0;
        try{
            
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        }
        catch(Exception e){
            e.printStackTrace();
        }
            
        try{
        Ventana ven = new Ventana() {};
       ven.frame();
       ven.frame.setVisible(true);
        }catch(Exception ewe){
            System.out.println("error ven");
        }
    }

   
    
}
