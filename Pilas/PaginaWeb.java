public class PaginaWeb {
    private String url;
    private String titulo;
    private int horaAcceso;

    public PaginaWeb(String url, String titulo, int horaAcceso) {
        this.url = url;
        this.titulo = titulo;
        this.horaAcceso = horaAcceso;
    }

    public String getUrl() {
        return url;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getHoraAcceso() {
        return horaAcceso;
    }

    public String toString() {
        return "Titulo: " + titulo + " | URL: " + url + " | Hora Acceso: " + horaAcceso;
    }
}