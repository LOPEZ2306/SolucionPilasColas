import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Navegador nav = new Navegador();

        int opcion;

        do {
            System.out.println("Menu");
            System.out.println("1. Visitar nueva pagina");
            System.out.println("2. Retroceder");
            System.out.println("3. Ver pagina actual");
            System.out.println("4. Ver historial");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese URL: ");
                    String url = sc.nextLine();

                    System.out.print("Ingrese titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Ingrese hora de acceso (número entero): ");
                    int hora = sc.nextInt();
                    sc.nextLine();

                    nav.visitarPagina(url, titulo, hora);
                    break;

                case 2:
                    nav.retroceder();
                    break;

                case 3:
                    nav.paginaActual();
                    break;

                case 4:
                    nav.mostrarHistorial();
                    break;

                case 5:
                    System.out.println("Saliendo del navegador");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 5);

        sc.close();
    }
}