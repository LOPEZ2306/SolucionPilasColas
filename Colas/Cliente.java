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

    @Override
    public String toString() {
        String estado = atendido ? "[Atendido]" : "[En espera]";
        return String.format("Turno #%d | %-15s | Servicio: %-15s | Hora Llegada: %d | %s", 
                id, nombre, tipoServicio, horaLlegada, estado);
    }
}
