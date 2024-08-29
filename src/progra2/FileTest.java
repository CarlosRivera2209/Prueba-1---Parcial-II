
package progra2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author adalb
 */
public class FileTest {
    static Scanner lea=new Scanner(System.in);
    
    public static void main(String args[]){
        MiFile mf=new MiFile();
        int opcion=0;
        do{
            System.out.println("1- Set Archivo/Folder");
            System.out.println("2- Ver informacion");
            System.out.println("3- Crear Archivo");
            System.out.println("4- Crear Folder");
            System.out.println("5- Borrar");
            System.out.println("6- Dir");
            System.out.println("7- Tree");
            System.out.println("8- Salir");
            try{
                opcion=lea.nextInt();
                switch(opcion){
                    case 1:
                        System.out.print("Direccion: ");
                        mf.setFile(lea.next());
                        break;
                    case 2:
                        mf.info();
                        break;
                    case 3:
                        if(mf.crearFile()){
                            System.out.println("Se Creo!");
                        }else{
                            System.out.println("No se Creo!");
                        }
                        break;
                    case 4:
                        if(mf.crearFolder()){
                            System.out.println("Se creo Folder!");
                        }else{
                            System.out.println("No se creo Folder!");
                        }
                        break;
                    case 5:
                        if(mf.Borrar()){
                            System.out.println("Se borro");
                        }else{
                            System.out.println("No se borro");
                        }
                        break;  
                    case 6:
                        mf.dir();
                        break;   
                        
                    case 7:
                        mf.tree();
                        break;     
                }
            }catch(InputMismatchException e){
                System.out.println("Ingrese una opcion valida");
                lea.next();
            }catch(NullPointerException e){
                System.out.println("Porfavor seleccione la primera opcion.");
            }catch(Exception e){
                System.out.println("Error");
            }
        }while(opcion!=8);
        
        /*
        Carpeta1:
        ---Archivo.ppt
        ---Carpeta.ppt
           ---Archivo.txt
        */
        
        //se me olvido poner Carpeta1\Archivo.pptx
    }
}
