/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progra2;

/**
 *
 * @author adalb
 */
public class info {
    /*
    En Java la libreria Java.io contiene las clases necesarias para manejos de archivos
    
    Aprenderemos a usar clases que Java ofrece y las dividiremos en 3 partes
    1. Clase utilitaria: file(solo sirve para crear, borrar, renombrar)
    2. Clases para Archivos de Texto: FileWriter y FileReader(aqui solo acepta texto y se gurada como byte)
    3. Clases para Archivos Binarios: RandomAccesFile(no se gurada solo texto)
    
    La instancia de file es: File obj=new File(direccion);
    La direccion del archivo puede ser abstracta o relativa(ejemplo: patito.txt) y absoluta(ejemplo: c:/algo/patito.pdf)
    
    Solamente en el constructor se indica la direccion del archivo, y no hay funcion para cambiarla
    
    Funciones:
    1.Informativas
    boolean eists(); Si el archivo o directorio existe o no
    booleanisFile() o isDirectory(); Si es archivo o directorio
    long length(); Especial para archivos: su tamano en bytes
    long lastModified(); La fecha en milisegundos de su ultima modificacion 
    boolean isHidden(); Si esta escondida o no
    boolean canWriter() o canRead(); Si pueden escribir o leer
    String getName(); El nombre del archivo o dirrecion
    String getPath(); La direccion con que se instancia dicho objeto File
    String getAbsolutePath(); La direccion absoluta
    String getParent(); La direccion padre pero solo si esta incluida en el getPath()
    2.Operaciones
    boolean mkdir() o mkdirs(); Crea un nuevo directorio
    */
}
