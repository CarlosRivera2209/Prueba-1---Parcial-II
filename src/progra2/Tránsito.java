/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package progra2;

public class Tránsito {

    private Multa[] multas;
    private int contadorMultas;

    public Tránsito() {
        multas = new Multa[100];
        contadorMultas = 0;
    }

    public Multa buscarMulta(int codigo) {
        for (Multa multa : multas) {
            if (multa != null && multa.getCodigo() == codigo) {
                return multa;
            }
        }
        return null;
    }

    public void agregarMulta(int codigo, String nombre, String tipo) {
        if (contadorMultas < 100 && buscarMulta(codigo) == null) {
            multas[contadorMultas] = new Multa(codigo, nombre, tipo);
            contadorMultas++;
            System.out.println("Multa agregada con éxito.");
        } else {
            System.out.println("Error: No hay espacio en el arreglo o el código ya existe.");
        }
    }

    public void pagarMulta(int codigo) {
        Multa multa = buscarMulta(codigo);
        if (multa != null) {
            multa.pagar();
            System.out.println("Multa pagada con éxito.");
        } else {
            System.out.println("Error: La multa con código " + codigo + " no existe.");
        }
    }

    public void imprimirTodasLasMultas() {
        for (Multa multa : multas) {
            if (multa != null) {
                multa.print();
                System.out.println("------------------------------");
            }
        }
    }

    public void imprimirInformacionSistema() {
        int cantidadTotalMultas = contadorMultas;
        int cantidadMultasPagadas = 0;
        int cantidadMultasPendientes = 0;
        double montoTotalPagado = 0;

        for (Multa multa : multas) {
            if (multa != null) {
                if (multa.estaPagada()) {
                    cantidadMultasPagadas++;
                    montoTotalPagado += multa.getMontoPagar();
                } else {
                    cantidadMultasPendientes++;
                }
            }
        }

        System.out.println("Cantidad de Multas generadas: " + cantidadTotalMultas);
        System.out.println("Cantidad de Multas Pagadas: " + cantidadMultasPagadas + " con un monto total de Lps. " + montoTotalPagado);
        System.out.println("Cantidad de Multas pendientes de pagar: " + cantidadMultasPendientes + " con un monto total de Lps. " + (cantidadMultasPendientes * Multa.TIPO_LEVE));
    }

    public Multa[] getMultas() {
        return multas;
    }

    public int getCantidadMultasGeneradas() {
        return contadorMultas;
    }

    public int getCantidadMultasPagadas() {
        int count = 0;
        for (Multa multa : multas) {
            if (multa != null && multa.estaPagada()) {
                count++;
            }
        }
        return count;
    }

    public double getMontoTotalMultasPagadas() {
        double total = 0;
        for (Multa multa : multas) {
            if (multa != null && multa.estaPagada()) {
                total += multa.getMontoPagar();
            }
        }
        return total;
    }

    public int getCantidadMultasPendientes() {
        int count = 0;
        for (Multa multa : multas) {
            if (multa != null && !multa.estaPagada()) {
                count++;
            }
        }
        return count;
    }

    public double getMontoTotalMultasPendientes() {
        double total = 0;
        for (Multa multa : multas) {
            if (multa != null && !multa.estaPagada()) {
                total += multa.getMontoPagar();
            }
        }
        return total;
    }

    public boolean existeCodigoMulta(int codigo) {
        for (Multa multa : multas) {
            if (multa != null && multa.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

}
