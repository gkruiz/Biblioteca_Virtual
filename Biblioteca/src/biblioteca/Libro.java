/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author KRUIZ9
 */
public class Libro {
    
   String nombre; 
   String autor;
   int anio; 
   String codigo;
   int noPaginas;
   
   
   
    public Libro(String nombre, String autor, int anio, String codigo, int noPaginas) {
        this.nombre = nombre;
        this.autor = autor;
        this.anio = anio;
        this.codigo = codigo;
        this.noPaginas = noPaginas;
    }

    public Libro() {
         }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNoPaginas() {
        return noPaginas;
    }

    public void setNoPaginas(int noPaginas) {
        this.noPaginas = noPaginas;
    }
    
    
    
   
    
    
   
   
   
   
   
   
}
