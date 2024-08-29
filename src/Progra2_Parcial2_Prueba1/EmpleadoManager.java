package Progra2_Parcial2_Prueba1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;

public class EmpleadoManager {

    private RandomAccessFile rcods, remps;

    public EmpleadoManager() {
        try {
            File mf = new File("Company");
            mf.mkdir();
            rcods = new RandomAccessFile("Company/codigos.emp", "rw");
            remps = new RandomAccessFile("Company/empleados.emp", "rw");
            initCodes();
        } catch (IOException e) {
            System.out.println("No deberia de pasar esto");
        }
    }

    private void initCodes() throws IOException {
        if (rcods.length() == 0) {
            rcods.writeInt(1);
        }
    }

    private int getCode() throws IOException {
        rcods.seek(0);
        int codigo = rcods.readInt();
        rcods.seek(0);
        rcods.writeInt(codigo + 1);
        return codigo;
    }

    public void addEmployee(String name, double monto) throws IOException {
        remps.seek(remps.length());
        int code = getCode();
        remps.writeInt(code);
        //Nombre
        remps.writeUTF(name);
        //Salario
        remps.writeDouble(monto);
        //Fecha de contratación
        remps.writeLong(Calendar.getInstance().getTimeInMillis());
        remps.writeLong(0);
        createEmployeeFolders(code);
    }

    private String employeeFolder(int code) {
        return "company/empleado" + code;
    }

    private void createEmployeeFolders(int code) throws IOException {
        File edir = new File(employeeFolder(code));
        edir.mkdir();
        this.createYearSalesFileFor(code);
    }

    private RandomAccessFile salesFileFor(int code) throws IOException {
        String dirPadre = employeeFolder(code);
        int yearActual = Calendar.getInstance().get(Calendar.YEAR);
        String path = dirPadre + "/ventas" + yearActual + ".emp";

        return new RandomAccessFile(path, "rw");
    }

    private void createYearSalesFileFor(int code) throws IOException {
        RandomAccessFile raf = salesFileFor(code);
        if (raf.length() == 0) {
            for (int mes = 0; mes < 12; mes++) {
                raf.writeDouble(0.0);
                raf.writeBoolean(false);
            }
        }
        raf.close();
    }

    public void printActiveEmployees() throws IOException {
        remps.seek(0);
        System.out.println("**** LISTA DE EMPLEADOS ****");

        while (remps.getFilePointer() < remps.length()) {
            int code = remps.readInt();
            String name = remps.readUTF();
            double salary = remps.readDouble();
            long hireDateMillis = remps.readLong();
            long fireDateMillis = remps.readLong();

            if (fireDateMillis == 0) {
                Date hireDate = new Date(hireDateMillis);
                Calendar cal = Calendar.getInstance();
                cal.setTime(hireDate);
                String formattedDate = String.format("%02d/%02d/%04d",
                        cal.get(Calendar.DAY_OF_MONTH),
                        cal.get(Calendar.MONTH) + 1,
                        cal.get(Calendar.YEAR));
                System.out.printf("codigo: %d - nombre: %s - salario: %.2f Lps - Fecha de contratacion: %s%n",
                        code, name, salary, formattedDate);
            }
        }
    }

    public boolean isEmployeeActive(int code) throws IOException {
        remps.seek(0);

        while (remps.getFilePointer() < remps.length()) {
            int currentCode = remps.readInt();
            String name = remps.readUTF();
            double salary = remps.readDouble();
            long hireDateMillis = remps.readLong();
            long fireDateMillis = remps.readLong();

            if (currentCode == code) {
                if (fireDateMillis == 0) {
                    Date hireDate = new Date(hireDateMillis);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(hireDate);
                    String formattedDate = String.format("%02d/%02d/%04d",
                            cal.get(Calendar.DAY_OF_MONTH),
                            cal.get(Calendar.MONTH) + 1,
                            cal.get(Calendar.YEAR));
                    System.out.printf("Empleado activo - codigo: %d - nombre: %s - salario: %.2f Lps - Fecha de contratacion: %s%n",
                            code, name, salary, formattedDate);
                    return true;
                } else {
                    System.out.printf("El empleado con codigo %d ha sido despedido.%n", code);
                    return false;
                }
            }
        }
        System.out.printf("El empleado con codigo %d no existe.%n", code);
        return false;
    }

    public boolean fireEmployee(int codeToFire) throws IOException {
        remps.seek(0);

        while (remps.getFilePointer() < remps.length()) {
            int code = remps.readInt();
            String name = remps.readUTF();
            double salary = remps.readDouble();
            long hireDateMillis = remps.readLong();
            long fireDateMillis = remps.readLong();

            if (code == codeToFire && fireDateMillis == 0) {
                remps.seek(remps.getFilePointer() - 8);
                remps.writeLong(Calendar.getInstance().getTimeInMillis());
                System.out.println("Empleado despedido: " + name);
                return true;
            }
        }

        return false;
    }

}
