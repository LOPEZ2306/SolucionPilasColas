public class Cliente {
    private int id;
    private String nombre;
    private String tipoServicio;
    private int horaLlegada;
    private boolean atendido;

    public Cliente(int id, String nombre, String tipoServicio, int horaLlegada) {
        this.id = id;
        this.nombre = nombre;
        this.tipoServicio = tipoServicio;
        this.horaLlegada = horaLlegada;
        this.atendido = false;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTipoServicio() { return tipoServicio; }
    public int getHoraLlegada() { return horaLlegada; }
    public boolean isAtendido() { return atendido; }

    // Setter
    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    public String toString() {
        String estado;
        if (atendido) {
            estado = "Atendido";
        } else {
            estado = "En espera";
        }
        
        return "Turno #" + id + " | " + nombre + " | Servicio: " + tipoServicio + " | Hora Llegada: " + horaLlegada + " | " + estado;
    }
}
