/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.educastur.ivan.biblioteca;

import java.util.ArrayList;

/**
 *
 * @author alu22d
 */
public class Biblioteca {

    private ArrayList <Libro> libros; 
    private ArrayList <Usuario> usuarios; 
    private ArrayList <Prestamo> prestamos; 

    public Biblioteca() {
        this.libros = new ArrayList();
        this.usuarios = new ArrayList();
        this.prestamos = new ArrayList();
    }
    
    
    
    public static void main(String[] args) {
    Biblioteca b= new Biblioteca(); 
    b.cargaDatos();
    b.menu();
    }
    private void cargaDatos(){ 
        
    }
    public void menu(){ 
        
    }
    
}
