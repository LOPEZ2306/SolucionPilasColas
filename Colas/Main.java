import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ColaBanco banco = new ColaBanco();
        int opcion;

        do {
            System.out.println("Gestion de turnos Banco");
            System.out.println("1. Llegada de un cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Ver siguiente cliente");
            System.out.println("4. Ver cola actual");
            System.out.println("5. Mostrar todos los turnos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String nombre = sc.nextLine();
                    System.out.print("Tipo de servicio (retiro/consignacion/asesorias): ");
                    String servicio = sc.nextLine();
                    System.out.print("Hora de llegada (numero entero): ");
                    int hora;
                    try {
                        hora = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        hora = 0;
                    }
                    banco.encolar(nombre, servicio, hora);
                    System.out.println("Cliente agregado a la fila.");
                    break;

                case 2:
                    Cliente atendido = banco.desencolar();
                    if (atendido == null) {
                        System.out.println("No hay clientes para atender");
                    } else {
                        System.out.println("Atendiendo a: " + atendido.getNombre() + " (Turno #" + atendido.getId() + ")");
                    }
                    break;

                case 3:
                    Cliente siguiente = banco.verSiguiente();
                    if (siguiente == null) {
                        System.out.println("No hay nadie en espera");
                    } else {
                        System.out.println("El siguiente es: " + siguiente.toString());
                    }
                    break;

                case 4:
                    System.out.println("Clientes en espera");
                    System.out.println(banco.obtenerColaActual());
                    break;

                case 5:
                    System.out.println("Registro de turnos");
                    
                    System.out.println("Pendientes");
                    System.out.println(banco.obtenerPendientes());

                    System.out.println("Atendidos");
                    System.out.println(banco.obtenerAtendidos());
                    break;

                case 6:
                    System.out.println("Saliendo del sistema");
                    break;

                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }

        } while (opcion != 6);

        sc.close();
    }
}
