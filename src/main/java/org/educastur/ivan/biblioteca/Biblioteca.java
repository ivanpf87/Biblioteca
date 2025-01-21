/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.educastur.ivan.biblioteca;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Este es el proyecto de la biblioteca de Ivan Perez del Fresno 
 * @author alu22d
 */
public class Biblioteca {
 
    private ArrayList <Libro> libros;
    private ArrayList <Usuario> usuarios;
    private ArrayList <Prestamo> prestamos;
    private ArrayList <Prestamo> prestamosHist;

    public Biblioteca() {
        this.libros = new ArrayList();
        this.usuarios = new ArrayList();
        this.prestamos = new ArrayList();
        this.prestamosHist = new ArrayList();
    }
    
    public static void main(String[] args) {
       Biblioteca b= new Biblioteca();
       b.cargaDatos();
       b.fueraPlazo();
       b.menu();
    }
    
    //<editor-fold defaultstate="collapsed" desc="MENUS">
    public void menu(){
        Scanner sc=new Scanner (System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tBIBLIOTECA\n");
            System.out.println("\t\t\t\t1 - LIBROS");
            System.out.println("\t\t\t\t2 - USUARIOS");
            System.out.println("\t\t\t\t3 - PRESTAMOS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    menuLibros();
                    break;
                }    
                case 2:{
                    menuUsuarios();
                    break;
                } 
                case 3:{
                    menuPrestamos();
                    break;
                } 
            }
        }while (opcion != 9);
    }

    private void menuLibros() {
        Scanner sc=new Scanner (System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tlibros\n");
            System.out.println("\t\t\t\t1 - Nuevo libro");
            System.out.println("\t\t\t\t2 - Eliminar libro");
            System.out.println("\t\t\t\t3 - Modificador de libros");
            System.out.println("\t\t\t\t4 - Listados");
            System.out.println("\t\t\t\t9 - Salir de libros");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    nuevoLibro();
                    break;
                }    
                case 2:{
                    eliminarLibro();
                    break;
                } 
                case 3:{
                    modificarLibros();
                    break;
                } 
                case 4:{
                    listaLibros();
                    break;
                } 
            }
        }while (opcion != 9);
    }

    private void menuUsuarios() {
        Scanner sc=new Scanner (System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tUsuarios");
            System.out.println("\t\t\t\t1 - Nuevo usuario");
            System.out.println("\t\t\t\t2 - Eliminador de Usuarios");
            System.out.println("\t\t\t\t3 - Modificador de usuarios");
            System.out.println("\t\t\t\t4 - Listados de usuario");
            System.out.println("\t\t\t\t9 - Salir de usuarios");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    nuevoUsuario();
                    break;
                }    
                case 2:{
                    eliminarUsuario();
                    break;
                } 
                case 3:{
                    modificarUsuario();
                    break;
                } 
                case 4:{
                    listaUsuarios();
                    break;
                } 
            }
        }while (opcion != 9);
    }

    private void menuPrestamos() {
        Scanner sc=new Scanner (System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tPrestamos\n");
            System.out.println("\t\t\t\t1 - Nuevo Prestamos");
            System.out.println("\t\t\t\t2 - Devolucion de prestamos");
            System.out.println("\t\t\t\t3 - Prorroga de prestamo");
            System.out.println("\t\t\t\t4 - Litado de prestamos");
            System.out.println("\t\t\t\t5 - Lista de prestamos a usuarios");
            System.out.println("\t\t\t\t6 - Listado de prestamos de libros (USUARIOS QUE LO LEEN)");
            System.out.println("\t\t\t\t7 - Libro mas leido");
            System.out.println("\t\t\t\t8 - usario mas lector");
            System.out.println("\t\t\t\t9 - Salir de prestamos");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    nuevoPrestamo();
                    break;
                }    
                case 2:{
                    devolucion();
                    break;
                } 
                case 3:{
                    prorroga();
                    break;
                } 
                case 4:{
                    listaPrestamos();
                    break;
                } 
                case 5:{
                    listaPrestamosUsu();
                    break;
                } 
                case 6:{
                    listaPrestamosLibro();
                    break;
                } 
                case 7:{
                    libroMasLeido();
                    break;
                } 
                case 8:{
                    usuarioMasLector();
                    break;
                } 
            }
        }while (opcion != 9);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GESTION LIBROS">
    private void nuevoLibro() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Introduce el ISBN del libro:");
    String isbn = sc.nextLine();
    
    System.out.println("Introduce el título del libro:");
    String titulo = sc.nextLine();
    
    System.out.println("Introduce el autor del libro:");
    String autor = sc.nextLine();
    
    System.out.println("Introduce el número de unidades disponibles:");
    int unidades = sc.nextInt();
    
    // Crear un nuevo libro con los datos introducidos
    Libro nuevoLibro = new Libro(isbn, titulo, autor, "Desconocido", unidades); //  "Desconocido" ya que no nos pide genero
    
    
    libros.add(nuevoLibro);
    
    System.out.println("Libro añadido correctamente");
    }

    private void eliminarLibro() {
           Scanner sc = new Scanner(System.in);
    
    System.out.println("Introduce el ISBN del libro a eliminar:");
    String isbn = sc.nextLine();
    
    // Buscar por ISBN
    int pos = buscaIsbn(isbn);
    if (pos==-1) {
        System.out.println("No se ha encontrado ningún libro con ese ISBN.");
    } else {
        // Elimina el libro de la lista
        libros.remove(pos);
        System.out.println("Libro eliminado correctamente");
    }
    }

    private void modificarLibros() {
          Scanner sc = new Scanner(System.in);
    
    System.out.println("Introduce el ISBN del libro que deseas modificar:");
    String isbn = sc.nextLine();
    
    // Buscar por ISBN
    int pos=buscaIsbn(isbn);
    
    if (pos==-1) {
        System.out.println("No se ha encontrado ningún libro con ese ISBN.");
    } else {
        // Muestra el libro encontrado
        Libro libro = libros.get(pos);
        System.out.println("Libro encontrado: " + libro.getTitulo());
        System.out.println("Unidades actuales: " + libro.getEjemplares());
        
        // Solicita el cambio de libros
        System.out.println("Introduce el número de ejemplares a añadir o restar (puedes usar + o -):");
        int unidades = sc.nextInt();
        
        // Actualiza los ejemplares 
        libro.setEjemplares(libro.getEjemplares() + unidades);
        
        // Verificacion de que los ejemplares no sean negativos para que no den fallo
        if (libro.getEjemplares() < 0) {
            libro.setEjemplares(0);  // No permitimos ejemplares negativos
            System.out.println("El número de unidades no puede ser negativo. Se ha establecido a 0.");
        } else {
            System.out.println("Unidades actualizadas correctamente.");
        }
    }
    }

    private void listaLibros() {
        for (Libro l : libros) {
            System.out.println(l);
        }
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GESTION USUARIOS">
    private void nuevoUsuario() {
         Scanner sc = new Scanner(System.in);
    System.out.println("Introduce tus datos");

    System.out.print("DNI: ");
    String dni = sc.nextLine();

    for (Usuario usuario : usuarios) {
        if (usuario.getDni().equalsIgnoreCase(dni)) {
            System.out.println("El DNI ya está registrado. No se puede añadir el usuario.");
            return;
        }
    }

    System.out.print("Nombre: ");
    String nombre = sc.nextLine();
    
    System.out.print("email: ");
    String email = sc.nextLine();

    System.out.print("Teléfono: ");
    String telefono = sc.nextLine();

    usuarios.add(new Usuario(dni, nombre, email, telefono));
    System.out.println("Usuario añadido correctamente.");
    }

    private void eliminarUsuario() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Introduce el DNI del usuario a eliminar: ");
    String dni = sc.nextLine();

    int pos = buscaDni(dni); // Busca si el usuario existe
    if (pos == -1) {
        System.out.println("No se ha encontrado ningún usuario con ese DNI.");
    } else {
        usuarios.remove(pos); // Elimina el usuario
        System.out.println("Usuario con DNI " + dni + " eliminado correctamente.");
    }
    }
    

    private void modificarUsuario() {
    }

    private void listaUsuarios() {
          System.out.println("Lista de Usuarios");

    for (Usuario u : usuarios) {
        System.out.println("DNI: " + u.getDni());
        System.out.println("Nombre: " + u.getNombre());
        System.out.println("Email: " + u.getEmail());
        System.out.println("Teléfono: " + u.getTelefono());
    }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GESTION PRESTAMOS">
    private void nuevoPrestamo() {
        System.out.println("Identificacion del usuario:");
        String dni=solicitaDni();
        int posUsuario = buscaDni(dni);
        
        if (posUsuario==-1){
            System.out.println("No es aun usuario de la biblioteca");
        }else{
            System.out.println("Identificacion del libro:"); 
            String isbn=solicitaIsbn();
            int posLibro=buscaIsbn(isbn);
           
            if (posLibro==-1){
                System.out.println("El ISBN pertenece a un libro inexistente");
            } else if (libros.get(posLibro).getEjemplares()>0){
                if ((buscaPrestamo(dni,isbn))==-1){
                    LocalDate hoy=LocalDate.now();
                    prestamos.add(new Prestamo(libros.get(posLibro),usuarios.get(posUsuario),hoy,hoy.plusDays(15)));
                    libros.get(posLibro).setEjemplares(libros.get(posLibro).getEjemplares()-1);
                    }else{
                        System.out.println("Ese usuario ya tiene ese mismo libro en prestamo");
                    }
                }else{
                    System.out.println("No quedan unidades disponibles del libro");
                }
        }
    }
    private void devolucion() {
        System.out.println("Datos para la prorroga del préstamo:");
        String isbnLibro=solicitaIsbn();
        int pos=buscaPrestamo(solicitaDni(),isbnLibro);
        if (pos==-1){
            System.out.println("No hay ningun préstamo con esos datos");
        }else{
            prestamos.get(pos).setFechaDev(LocalDate.now());
            libros.get(buscaIsbn(isbnLibro))
              .setEjemplares(libros.get(buscaIsbn(isbnLibro)).getEjemplares()+1);
            prestamosHist.add(prestamos.get(pos));
            prestamos.remove(pos);
        }
    }
    private void prorroga() {
        System.out.println("Datos para la prorroga del préstamo:");
        
        String dni = solicitaDni();
        String isbn = solicitaIsbn();
        int pos=buscaPrestamo(dni,isbn);
        //int pos=buscaPrestamo(solicitaDni(),solicitaIsbn());
        if (pos==-1){
            System.out.println("No hay ningun préstamo con esos datos");
        }else{
            prestamos.get(pos).setFechaDev(prestamos.get(pos).getFechaDev().plusDays(15));
            prestamos.get(pos).setFechaPrest(LocalDate.now());
        }
    }

    private void listaPrestamos() {
        System.out.println("Listado de prestamos activos");
        for (Prestamo p : prestamos) {
            if (p.getFechaDev().isBefore(LocalDate.now())){
                        System.out.print("Libro fuera de plazo: ");
            }
            System.out.println(p);  
        }
        System.out.println("\nListado de prestamos historicos");
        for (Prestamo p : prestamosHist) {
            System.out.println(p);  
        }

    }
                   
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="LISTADOS DE LAS AMPLIACIONES 1-2-3-4">
    private void libroMasLeido(){
        ArrayList <Integer> contadoresLibros=new ArrayList();
        int contador;
        for (Libro l : libros) {
            contador=0;
            for (Prestamo p:prestamos) {
                if (l==p.getLibroPrest()){
                    contador++;
                }
            }
            for (Prestamo p:prestamosHist) {
                if (l==p.getLibroPrest()){
                    contador++;
                }
            }
            contadoresLibros.add(contador);
        }
        
        int max=0;
        for (int c:contadoresLibros){
            if (c>max){
                max=c;
            }
        }
        System.out.println("El libro/s mas leido/s con " + max + " prestamos es/son: " );
               
        for (int i = 0; i < contadoresLibros.size(); i++) {
            if (contadoresLibros.get(i)==max){
                System.out.println(libros.get(i));
            }
        }
    }
    
    private void usuarioMasLector(){
        ArrayList <Integer> contadoresUsuarios=new ArrayList();
        int contador;
        for (Usuario u : usuarios) {
            contador=0;
            for (Prestamo p:prestamos) {
                if (u==p.getUsuarioPrest()){
                    contador++;
                }
            }
            for (Prestamo p:prestamosHist) {
                if (u==p.getUsuarioPrest()){
                    contador++;
                }
            }
            contadoresUsuarios.add(contador);
        }
        
        int max=0;
        for (int c:contadoresUsuarios){
            if (c>max){
                max=c;
            }
        }
        System.out.println("Los usuarios/as mas lectores/as con " + max + " prestamos son: " );
               
        for (int i = 0; i < contadoresUsuarios.size(); i++) {
            if (contadoresUsuarios.get(i)==max){
                System.out.println(usuarios.get(i));
            }
        }
    }
    
    private void listaPrestamosUsu(){
        String dni=solicitaDni();
        int pos=buscaDni(dni);
        
        if (pos==-1){
            System.out.println("No tengo a nadie con ese DNI");
        }else{
            System.out.println("Prestamos activos de: "
                    + usuarios.get(pos).getNombre());
            for (Prestamo p : prestamos) {
                if (p.getUsuarioPrest().getDni().equals(dni)){
                    if (p.getFechaDev().isBefore(LocalDate.now())){
                        System.out.print("Libro fuera de plazo: ");
                    }
                    System.out.println(p);  
                }
            }
            System.out.println("\nPrestamos ya devueltos por: "
                    + usuarios.get(pos).getNombre());
            for (Prestamo p : prestamosHist) {
                if (p.getUsuarioPrest().getDni().equals(dni)){
                    System.out.println(p);  
                }
            }
        }
    }
    
    private void listaPrestamosLibro(){
        String isbn=solicitaIsbn();
        int pos=buscaIsbn(isbn);
        if (pos==-1){
             System.out.println("No tengo ningún libro con ese ISBN");
        }else{
            System.out.println("Usuarios/as que lo estan leyendo");
            for (Prestamo p : prestamos) {
                if (p.getLibroPrest().getIsbn().equals(isbn)){
                    System.out.println(p.getUsuarioPrest());
                }
            }
            
            System.out.println("Usuarios/as que ya lo han leido");
            for (Prestamo p : prestamosHist) {
                if (p.getLibroPrest().getIsbn().equals(isbn)){
                    System.out.println(p.getUsuarioPrest());
                }
            }
        }
    }
            
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="METODOS AUXILIARES">
    
    
    public void fueraPlazo(){
        System.out.println("Prestamos fuera de plazo:");
        for (Prestamo p : prestamos) {
            if (p.getFechaDev().isBefore(LocalDate.now())){
                    System.out.println(p);
            }
        }
    }
    
    public String solicitaDni(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Teclea el dni del usuario:");
        String dni=sc.next();
        return dni;
    }
    
    public String solicitaIsbn(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Teclea el isbn del libro:");
        String isbn=sc.next();
        return isbn;
    }
    
   
    public int buscaDni(String dni){
        int pos=-1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDni().equals(dni)){
                pos=i;
                break;
            }
        }
        return pos;       
    }
    
     
    public int buscaIsbn(String isbn){
        int pos=-1;
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(isbn)){
                pos=i;
                break;
            }
        }
        return pos;       
    }
    
    public int buscaPrestamo(String dni, String isbn){
        int pos=-1;
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getUsuarioPrest().getDni().equals(dni)
                && prestamos.get(i).getLibroPrest().getIsbn().equals(isbn)){   
                pos=i;
                break;
            }
        }
        return pos;       
    }
    
    
    public void cargaDatos(){
        
        libros.add(new Libro("1-11","El Hobbit","JRR Tolkien","Aventuras",3)); 
        libros.add(new Libro("1-22","El Silmarillon","JRR Tolkien","Aventuras",3)); 
        libros.add(new Libro("1-33","El Medico","N. Gordon","Aventuras",4)); 
        libros.add(new Libro("1-44","Chaman","N. Gordon","Aventuras",3)); 
        libros.add(new Libro("1-55","Momo","M. Ende","Aventuras",2)); 
        libros.add(new Libro("1-66","Paraiso inhabitado","A.M.Matute","Aventuras",2)); 
        libros.add(new Libro("1-77","Olvidado Rey Gudu","A.M.Matute","Aventuras",2)); 
        libros.add(new Libro("1-88","El ultimo barco","D.Villar","Novela Negra",3)); 
        libros.add(new Libro("1-99","Ojos de agua","D.Villar","Novela Negra",9
        )); 

        usuarios.add(new Usuario("11","Ana","ana@email.com","621111111")); 
        usuarios.add(new Usuario("22","David","david@email.com","622222222")); 
        usuarios.add(new Usuario("33","Bea","bea@email.com","623333333")); 
        usuarios.add(new Usuario("44","Lucas","lucas@email.com","624444444")); 
        usuarios.add(new Usuario("55","Carlota","carlota@email.com","625555555")); 
        usuarios.add(new Usuario("66","Juan","juan@email.com","626666666"));
        
        LocalDate hoy= LocalDate.now();
        prestamos.add(new Prestamo(libros.get(0),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(0),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(1),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(3),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamos.add(new Prestamo(libros.get(6),usuarios.get(4), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(6),usuarios.get(1), hoy,hoy.plusDays(15)));
        
        prestamosHist.add(new Prestamo(libros.get(0),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(2),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(7),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(5),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(1),usuarios.get(1), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(7),usuarios.get(2), hoy.minusDays(20),hoy.minusDays(5)));
        prestamosHist.add(new Prestamo(libros.get(6),usuarios.get(3), hoy.minusDays(20),hoy.minusDays(5)));
    }
//</editor-fold>
   
}
