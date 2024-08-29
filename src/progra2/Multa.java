
package progra2;

public class Multa {

    private int codigo;
    private String nombreInfractor;
    private String tipo;
    private double montoPagar;
    private boolean pagada;

    public static final double TIPO_LEVE = 50.0;
    public static final double TIPO_MEDIO = 100.0;
    public static final double TIPO_GRAVE = 200.0;

    public Multa(int codigo, String nombreInfractor, String tipo) {
        this.codigo = codigo;
        this.nombreInfractor = nombreInfractor;
        this.tipo = (tipo.equals("LEVE") || tipo.equals("MEDIO") || tipo.equals("GRAVE")) ? tipo : "LEVE";

        switch (this.tipo) {
            case "LEVE":
                this.montoPagar = TIPO_LEVE;
                break;
            case "MEDIO":
                this.montoPagar = TIPO_MEDIO;
                break;
            case "GRAVE":
                this.montoPagar = TIPO_GRAVE;
                break;
        }

        this.pagada = false;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getMontoPagar() {
        return montoPagar;
    }

    public boolean estaPagada() {
        return pagada;
    }

    public void print() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre del infractor: " + nombreInfractor);
        System.out.println("Tipo de multa: " + tipo);
        System.out.println("Monto a pagar: Lps. " + montoPagar);
        System.out.println(pagada ? "Pagada por un monto de Lps. " + montoPagar : "Multa pendiente");
    }

    public void pagar() {
        pagada = true;
        System.out.println("Multa con Código " + codigo + " fue pagada por un monto de Lps. " + montoPagar);
    }

    public String getNombreInfractor() {
        return nombreInfractor;
    }

    public String getTipo() {
        return tipo;
    }
    
     public String toString() {
        String estadoMulta = estaPagada() ? "Pagada por un monto de Lps. " + getMontoPagar() : "Multa pendiente";
        return "Código: " + getCodigo() +
               "\nNombre del infractor: " + getNombreInfractor() +
               "\nTipo de multa: " + getTipo() +
               "\nMonto a pagar: Lps. " + getMontoPagar() +
               "\nEstado: " + estadoMulta;
    }
}
