package Progra2_Parcial2_Prueba1;

import java.io.IOException;
import java.util.Scanner;

public class ControlEmpleado {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        EmpleadoManager manager = new EmpleadoManager();

        while (true) {
            System.out.println("**** MENU ****");
            System.out.println("1- Agregar Empleado");
            System.out.println("2- Listar Empleados No Despedidos");
            System.out.println("3- Despedir Empleado");
            System.out.println("4- Buscar Empleado Activo");
            System.out.println("5- Salir");
            System.out.print("Seleccione una opcion: ");

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Debe ingresar una opcion valida.");
                continue;
            }

            int option;
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre del empleado: ");
                    String name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Debe ingresar un nombre.");
                        continue;
                    }

                    System.out.print("Ingrese el salario del empleado: ");
                    input = scanner.nextLine().trim();
                    if (input.isEmpty()) {
                        System.out.println("Debe ingresar un salario.");
                        continue;
                    }

                    double salary;
                    try {
                        salary = Double.parseDouble(input);
                    } catch (NumberFormatException e) {
                        System.out.println("Debe ingresar un salario valido.");
                        continue;
                    }

                    manager.addEmployee(name, salary);
                    break;

                case 2:
                    manager.printActiveEmployees();
                    break;

                case 3:
                    System.out.print("Ingrese el codigo del empleado a despedir: ");
                    input = scanner.nextLine().trim();
                    if (input.isEmpty()) {
                        System.out.println("Debe ingresar un codigo.");
                        continue;
                    }

                    int fireCode;
                    try {
                        fireCode = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println("Debe ingresar un codigo valido.");
                        continue;
                    }

                    if (!manager.fireEmployee(fireCode)) {
                        System.out.println("Empleado no encontrado o ya despedido.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el codigo del empleado: ");
                    input = scanner.nextLine().trim();
                    if (input.isEmpty()) {
                        System.out.println("Debe ingresar un codigo.");
                        continue;
                    }
                    
                    int activeCode;
                    try {
                        activeCode = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println("Debe ingresar un codigo valido.");
                        continue;
                    }
                    
                    if (manager.isEmployeeActive(activeCode)) {
                        System.out.println("El empleado está activo.");
                    } else {
                        System.out.println("El empleado no está activo o fue despedido.");
                    }
                    break;
                
                case 5:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Opcion no válida. Intente de nuevo.");
            }
        }
    }
}
