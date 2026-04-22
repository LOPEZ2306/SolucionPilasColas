import java.util.Stack;

public class Navegador {
    private Stack<PaginaWeb> historial;

    public Navegador() {
        historial = new Stack<>();
    }

    public void visitarPagina(String url, String titulo, int horaAcceso) {
        PaginaWeb nueva = new PaginaWeb(url, titulo, horaAcceso);
        historial.push(nueva);
        System.out.println("Pagina agregada correctamente");
    }

    public void retroceder() {
        if (historial.isEmpty()) {
            System.out.println("No hay paginas para retroceder");
            return;
        }

        historial.pop();

        if (historial.isEmpty()) {
            System.out.println("No hay pagina actual");
        } else {
            System.out.println("Ahora estás en: " + historial.peek().getTitulo());
        }
    }

    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("Historial vacio");
            return;
        }

        System.out.println("--- HISTORIAL ---");
        for (PaginaWeb p : historial) {
            System.out.println(p);
        }
    }

    public void paginaActual() {
        if (historial.isEmpty()) {
            System.out.println("No hay pagina actual");
        } else {
            System.out.println("Pagina actual:");
            System.out.println(historial.peek());
        }
    }
}