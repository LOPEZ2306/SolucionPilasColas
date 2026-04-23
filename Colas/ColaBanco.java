import java.util.LinkedList;
import java.util.Queue;

public class ColaBanco {
    private Queue<Cliente> filaEspera;
    private Queue<Cliente> clientesAtendidos;
    private int contadorTurnos;

    public ColaBanco() {
        this.filaEspera = new LinkedList<>();
        this.clientesAtendidos = new LinkedList<>();
        this.contadorTurnos = 1;
    }

    // Llegada de un cliente
    public Queue<Cliente> encolar(String nombre, String tipoServicio, int horaLlegada) {
        Cliente nuevoCliente = new Cliente(contadorTurnos++, nombre, tipoServicio, horaLlegada);
        filaEspera.offer(nuevoCliente);
        return filaEspera;
    }

    // Atender cliente
    public Cliente desencolar() {
        if (filaEspera.isEmpty()) {
            return null;
        }
        Cliente atendido = filaEspera.poll();
        atendido.setAtendido(true);
        clientesAtendidos.offer(atendido);
        return atendido;
    }

    // Ver siguiente cliente (peek)
    public Cliente verSiguiente() {
        return filaEspera.peek();
    }

    // Métodos para obtener el texto recorriendo con auxiliares
    public String obtenerColaActual() {
        if (filaEspera.isEmpty()) {
            return "La fila esta vacia";
        }
        String resultado = "";
        Queue<Cliente> aux = new LinkedList<>();
        while (!filaEspera.isEmpty()) {
            Cliente c = filaEspera.poll();
            resultado += c.toString() + "\n";
            aux.offer(c);
        }
        while (!aux.isEmpty()) {
            filaEspera.offer(aux.poll());
        }
        return resultado;
    }

    public String obtenerPendientes() {
        if (filaEspera.isEmpty()) {
            return "Sin turnos pendientes";
        }
        String resultado = "";
        Queue<Cliente> aux = new LinkedList<>();
        while (!filaEspera.isEmpty()) {
            Cliente c = filaEspera.poll();
            resultado += c.toString() + "\n";
            aux.offer(c);
        }
        while (!aux.isEmpty()) {
            filaEspera.offer(aux.poll());
        }
        return resultado;
    }

    public String obtenerAtendidos() {
        if (clientesAtendidos.isEmpty()) {
            return "Aun no se ha atendido a nadie";
        }
        String resultado = "";
        Queue<Cliente> aux = new LinkedList<>();
        while (!clientesAtendidos.isEmpty()) {
            Cliente c = clientesAtendidos.poll();
            resultado += c.toString() + "\n";
            aux.offer(c);
        }
        while (!aux.isEmpty()) {
            clientesAtendidos.offer(aux.poll());
        }
        return resultado;
    }

    // Métodos de estado (retornan booleans o números)
    public boolean estaVacia() {
        return filaEspera.isEmpty();
    }

    public boolean atendidosEstaVacia() {
        return clientesAtendidos.isEmpty();
    }

    public int cantidadPendientes() {
        return filaEspera.size();
    }

    public Queue<Cliente> getFilaEspera() {
        return filaEspera;
    }

    public Queue<Cliente> getClientesAtendidos() {
        return clientesAtendidos;
    }
}
