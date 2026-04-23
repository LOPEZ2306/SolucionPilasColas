import java.util.Stack;

public class Navegador {
    private Stack<PaginaWeb> historial;

    public Navegador() {
        historial = new Stack<>();
    }

    public Stack<PaginaWeb> visitarPagina(String url, String titulo, int horaAcceso) {
        PaginaWeb nueva = new PaginaWeb(url, titulo, horaAcceso);
        historial.push(nueva);
        return historial;
    }

    public Stack<PaginaWeb> retroceder() {
        if (!historial.isEmpty()) {
            historial.pop();
        }
        return historial;   
    }

    // Método para obtener el historial recorriendo con auxiliar
    public String obtenerHistorial() {
        if (historial.isEmpty()) {
            return "Historial vacio";
        }
        String resultado = "";
        Stack<PaginaWeb> aux = new Stack<>();
        while (!historial.isEmpty()) {
            PaginaWeb p = historial.pop();
            resultado += p.toString() + "\n";
            aux.push(p);
        }
        while (!aux.isEmpty()) {
            historial.push(aux.pop());
        }
        return resultado;
    }

    // Métodos de estado
    public boolean estaVacia() {
        return historial.isEmpty();
    }

    // Método para obtener la pila completa para el recorrido auxiliar en Main
    public Stack<PaginaWeb> getHistorial() {
        return historial;
    }
}