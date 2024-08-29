package progra2;

public class palindromoAir {

    private Ticket[] asientos;

    boolean verificar = false;
    double price = 0;
    double totalIncome;

    public palindromoAir() {

        this.asientos = new Ticket[30];
    }

    public int firstAvailable(int index) {
        if (index == asientos.length) {
            return -1;
        }
        if (asientos[index] == null) {
            return index;
        }
        return firstAvailable(index + 1);
    }

    public int searchPassenger(String name, int index) {
        if (index == asientos.length) {
            return -1;
        }
        if (asientos[index] != null && asientos[index].getNombre().equals(name)) {
            return index;
        }
        return searchPassenger(name, index + 1);
    }

    public boolean isPalindromo(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindromo(str, start + 1, end - 1);
    }

    public void printPassengers(int index) {
        if (index == asientos.length) {
            return;
        }
        if (asientos[index] != null) {
            System.out.println("Nombre del pasajero: " + asientos[index].getNombre());
            System.out.println("Precio pagado: " + asientos[index].getPrecio());
            System.out.println("--------------------------");
        }
        printPassengers(index + 1);
    }

    public double income(int index) {
        if (index == asientos.length) {
            return 0;
        }
        if (asientos[index] != null) {
            return asientos[index].getPrecio() + income(index + 1);
        }
        return income(index + 1);
    }
    
    public void reset() {
        resetHelper(0);
    }

    private void resetHelper(int index) {
        if (index >= asientos.length) {
            return;
        }
        asientos[index] = null;
        resetHelper(index+1);
    }
    
    
    
    //Prueba
    public void reservarAsiento(String nombre, double precio) {
        int pos = firstAvailable(0);
        if (pos != -1) {
            asientos[pos] = new Ticket(nombre, precio);
            System.out.println("Asiento reservado para " + nombre);
        } else {
            System.out.println("No hay asientos disponibles");
        }
    }
    
    
}
