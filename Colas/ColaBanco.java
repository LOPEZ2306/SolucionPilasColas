import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class ColaBanco {
    private Queue<Cliente> filaEspera;
    private List<Cliente> clientesAtendidos;
    private int contadorTurnos;

    public ColaBanco() {
        this.filaEspera = new LinkedList<>();
        this.clientesAtendidos = new ArrayList<>();
        this.contadorTurnos = 1;
    }

    // 1. Llegada de un cliente
    public void encolar(String nombre, String tipoServicio, int horaLlegada) {
        Cliente nuevoCliente = new Cliente(contadorTurnos++, nombre, tipoServicio, horaLlegada);
        filaEspera.offer(nuevoCliente);
        System.out.println("Cliente encolado: " + nuevoCliente.getNombre() + " con Turno #" + nuevoCliente.getId());
    }

    // 2. Atender cliente
    public void desencolar() {
        if (filaEspera.isEmpty()) {
            System.out.println("No hay clientes en la fila.");
            return;
        }
        Cliente atendido = filaEspera.poll();
        atendido.setAtendido(true);
        clientesAtendidos.add(atendido);
        System.out.println("Atendiendo a: " + atendido.getNombre() + " (Turno #" + atendido.getId() + ")");
    }

    // 3. Ver siguiente cliente (peek)
    public void verSiguiente() {
        if (filaEspera.isEmpty()) {
            System.out.println("No hay clientes en espera.");
            return;
        }
        System.out.println("Siguiente cliente en ser atendido: " + filaEspera.peek());
    }

    // 4. Ver cola actual
    public void verColaActual() {
        if (filaEspera.isEmpty()) {
            System.out.println("La fila está vacia.");
            return;
        }
        System.out.println("Clientes en espera: ");
        for (Cliente c : filaEspera) {
            System.out.println(c);
        }
    }

    // 5. Mostrar Turnos (Atendidos y Pendientes)
    public void mostrarTurnos() {
        System.out.println("Registro de turnos: ");
        
        System.out.println("Pendientes: ");
        if (filaEspera.isEmpty()) {
            System.out.println("Sin turnos pendientes.");
        } else {
            for (Cliente c : filaEspera) {
                System.out.println(c);
            }
        }

        System.out.println("Atendidos: ");
        if (clientesAtendidos.isEmpty()) {
            System.out.println("Aun no se ha atendido a nadie.");
        } else {
            for (Cliente c : clientesAtendidos) {
                System.out.println(c);
            }
        }
    }
}
