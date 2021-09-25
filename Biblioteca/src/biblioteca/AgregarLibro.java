/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.Scanner;

/**
 *
 * @author KRUIZ9
 */
public class AgregarLibro {
    Scanner pedir = new Scanner(System.in);
    String nombre; 
    String autor;
    int anio; 
    String codigo;
    int noPaginas;

    Libro libro = new Libro();
   
    public void iniciar(){
        System.out.println("bienvenido");
        System.out.println("seleccione una opcion");
        System.out.println(" **************************************");
        System.out.println("1.............Agregar libro");
        System.out.println("2..............Consultar libro");
        
        System.out.println("****************************************");
        
        
        
        int opcion;
        opcion = pedir.nextInt();
        
        switch (opcion) {
            case 1:
                agregarLibro();
                break;
            case 2: 
                consultarLibro();
            default:
                throw new AssertionError();
        }
        
        
        
    }
    
    
    public void agregarLibro(){
        
        System.out.println("ingrese nombre del lbro");
        
        nombre = pedir.nextLine();
        String nom;
        nom = pedir.nextLine();
        
        libro.setNombre(nom);
        
        System.out.println("ingrese autor");
        
        autor = pedir.nextLine();
        libro.setAutor(autor);
        
        System.out.println("ingrese anio");
        
        anio = pedir.nextInt();
        libro.setAnio(anio);
        
        System.out.println("inrese codigo");
        
        codigo = pedir.nextLine();
        libro.setCodigo(codigo);
        
        System.out.println("inrese numero de paginas");
        
        noPaginas = pedir.nextInt();
        libro.setNoPaginas(noPaginas);
        
        
        System.out.println("El libro ingresado es>>>> ");
        System.out.println("nombre: " + libro.getNombre());
        System.out.println("autor: " + libro.getAutor());
        System.out.println("anio: " +libro.getAnio());
        System.out.println("Paginas : " + libro.getNoPaginas());
        System.out.println("codigo: " + libro.getCodigo());
        
    
    }
    
    
    public void consultarLibro(){
        
    
    }
}
