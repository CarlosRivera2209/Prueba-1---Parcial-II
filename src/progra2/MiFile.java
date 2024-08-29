/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MiFile {
    private File mifile=null;
    
    void setFile(String direccion){
        mifile=new File(direccion);
    }
    
    void info(){
        if(mifile.exists()){
            System.out.println("\nNombre: "+mifile.getName());
            System.out.println("Path: "+mifile.getPath());
            System.out.println("Absoluta: "+mifile.getAbsolutePath());
            System.out.println("Bytes: "+mifile.length());
            System.out.println("Modificado en: "+new Date(mifile.lastModified()));
            System.out.println("Padre: "+mifile.getAbsoluteFile().getParentFile().getName());
            if(mifile.isFile()){
                System.out.println("Es file.");
            }else if(mifile.isDirectory()){
                System.out.println("Es folder.");
            }
        }else{
            System.out.println("No existe el objeto.");
        }
    }
    
    boolean crearFile()throws IOException{
        return mifile.createNewFile();
    }

    boolean crearFolder(){
        return mifile.mkdirs();
    }
    
    boolean antidoto(File f){
        if(f.isDirectory()){
            for(File child : f.listFiles()){
                antidoto(child);
            }
        }
        return f.delete();
    }
    
    boolean Borrar(){
        return antidoto(mifile);
    }
    
    void dir(){
        if(mifile.isDirectory()){
            System.out.println("Directorio de: "+mifile.getAbsolutePath());
            System.out.println(" ");
            int cfiles=0,cdirs=0,tbytes=0;
            
            for(File child : mifile.listFiles()){
                if(!child.isHidden()){
                    //Ultima modificacion
                    Date ultima=new Date(child.lastModified());
                    System.out.println(ultima+"\t");
                    //Si es File o Dir
                    if(child.isDirectory()){
                        cdirs++;
                        System.out.println("<DIR>\t\t");
                    }else{
                        cfiles++;
                        tbytes+=child.length();
                    }
                    System.out.println(child.getName());
                }
            }
            System.out.println(cfiles+" archivos\t"+tbytes+" bytes"+
                              "\n"+cdirs+" dirs");
        }
    }
    
    private void tree(File dir, String tab){
        if(dir.isDirectory()){
            System.out.println(tab+dir.getName());
            //Recorrer el contenido
            for(File child : dir.listFiles()){
                if(!child.isHidden()){
                    tree(child,tab+"--");
                }
            }
        }
    }
    
    void tree(){
        tree(mifile,"-");
    }
    
    void viruloso()throws IOException{
        if(mifile.isDirectory()){
            for(int contD=1;contD<=5;contD++){
                File dir=new File(mifile,"Folder"+contD);
                dir.mkdir();
                for(int contF=1;contF<=10;contF++){
                    File fileD=new File(dir,"File"+contF+".txt");
                    fileD.createNewFile();
                }
            }
        }
    }
}
