
package progra2;

import java.io.*;

class Libro implements Serializable, Cloneable {
    private String titulo;
    private String autor;

   
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
   
    public void mostrarInfo() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
    }
   
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

   
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}

public class Tarea_Serializable_Clonable {
    public static void main(String[] args) {
       
        Libro libroOriginal = new Libro("El señor de los anillos", "J.R.R. Tolkien");

        
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("libro.ser"))) {
            outputStream.writeObject(libroOriginal);
            System.out.println("Objeto serializado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Libro libroClonado = (Libro) libroOriginal.clone();
            
            libroClonado.setAutor("Autor Modificado");

            System.out.println("Informacion del libro original:");
            libroOriginal.mostrarInfo();

            System.out.println("\nInformacion del libro clonado:");
            libroClonado.mostrarInfo();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
