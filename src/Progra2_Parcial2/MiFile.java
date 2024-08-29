package Progra2_Parcial2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class MiFile {

    private File mf = null;

    public void setFile(String dir) {
        mf = new File(dir);
    }

    public void Info() {
        if (mf.exists()) {
            System.out.print("\nSI EXISTE:\n -----------");
            System.out.println("Nombre: " + mf.getName());
            System.out.println("Path: " + mf.getPath());
            System.out.println("Absoluta: " + mf.getAbsolutePath());
            System.out.println("Padre: " + mf.getAbsoluteFile().getParentFile().getName());
            System.out.println("Bytes: " + mf.length());
            if (mf.isFile()) {
                System.out.println("ES UN ARCHIVO");
            } else if (mf.isDirectory()) {
                System.out.print("ES UN FOLDER");
                System.out.print("ULTIMA MODIFICACIÓN: " + new Date(mf.lastModified()));
            } else {
                System.out.print("Aun no existe");
            }
        }
    }

    public void crearFile() throws IOException {
        if (mf.createNewFile()) {
            System.out.println("CREADO EXITOSAMENTE");
        } else {
            System.out.println("NO SE PUDO CREAR");
        }
    }

    public void crearFolder() {
        if (mf.mkdirs()) {
            System.out.println("CREADO EXITOSAMENTE");
        } else {
            System.out.println("NO SE PUDO CREAR");
        }
    }

    private boolean antidoto(File file) {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                antidoto(child);
            }
        }
        return file.delete();
    }

    public void Borrar() {
        if (antidoto(mf)) {
            System.out.println("SE BORRO");
        } else {
            System.out.println("NO SE BORRO");
        }
    }

    public void dir() {
        if (mf.isDirectory()) {
            System.out.println("DIRECTRIO DE: " + mf.getAbsolutePath());
            System.out.println("");
            int cfiles = 0, cdirs = 0, tbytes = 0;

            for (File child : mf.listFiles()) {
                if (!child.isHidden()) {
                    Date ultima = new Date(child.lastModified());
                    System.out.print(ultima + "\t");

                    if (child.isDirectory()) {
                        cdirs++;
                        System.out.print("<DIR>\t\t");
                    } else {
                        cfiles++;
                        tbytes += child.length();
                        System.out.print("     \t" + child.length() + "\t");
                    }
                    System.out.println(child.getName());
                }
            }
            System.out.println(cfiles + " archivos\t" + tbytes + " bytes" + "\n" + cdirs + " dirs");
        }
    }

    public void tree() {
        tree(mf, "-");
    }

    private void tree(File dir, String tab) {
        if (dir.isDirectory()) {
            System.out.println(tab + dir.getName());
            for (File child : dir.listFiles()) {
                if (!child.isHidden()) {
                    tree(child, tab + "--");
                }
            }
        }
    }

    public void escribirReemplazar(String contenido) throws IOException {
        if (mf.exists() && mf.isFile()) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(mf))) {
                pw.println(contenido);
                System.out.println("Contenido reemplazado exitosamente.");
            }
        } else {
            System.out.println("Error: El archivo no existe.");
        }
    }

    public void escribirAppend(String contenido) throws IOException {
        if (mf.exists() && mf.isFile()) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(mf, true))) {
                pw.println();
                pw.println(contenido);
                System.out.println("Contenido agregado exitosamente.");
            }
        } else {
            System.out.println("Error: El archivo no existe.");
        }
    }

    public void leerArchivo() throws IOException {
        if (mf.exists() && mf.isFile()) {
            try (Scanner sc = new Scanner(mf)) {
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
            }
        } else {
            System.out.println("Error: El archivo no existe.");
        }
    }
}
