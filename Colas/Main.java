import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ColaBanco banco = new ColaBanco();
        int opcion;

        do {
            System.out.println("GESTIÓN DE TURNOS - BANCO");
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
                    System.out.print("Tipo de servicio (retiro/consignación/asesoría): ");
                    String servicio = sc.nextLine();
                    System.out.print("Hora de llegada (número entero): ");
                    int hora;
                    try {
                        hora = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        hora = 0;
                    }
                    banco.encolar(nombre, servicio, hora);
                    break;

                case 2:
                    banco.desencolar();
                    break;

                case 3:
                    banco.verSiguiente();
                    break;

                case 4:
                    banco.verColaActual();
                    break;

                case 5:
                    banco.mostrarTurnos();
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 6);

        sc.close();
    }
}
