
package progra2;

import java.util.Calendar;

public class CuentaBancaria {

    protected int numero;
    protected String cliente;
    protected double saldo;
    protected double tasa;
    protected Calendar creacion;

    public CuentaBancaria(int numero, String cliente, double tasa) {
        this.numero = numero;
        this.cliente = cliente;
        this.tasa = tasa;
        saldo = 500;
        creacion = Calendar.getInstance();
    }

    public String getCliente() {
        return cliente;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTasa() {
        return tasa;
    }

    public Calendar getCreacion() {
        return creacion;
    }

    public boolean retirar(double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            return true;
        }
        return false;

    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    public String toString() {
        return "Numero de Cuenta: " + numero + ", Cliente: " + cliente + ", Saldo: " + saldo + ", tasa: " + tasa;
    }
    
    public static void main(String args[]) {
       
   }
}
