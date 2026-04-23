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

                    System.out.print("Ingrese hora de acceso (numero entero): ");
                    int hora = sc.nextInt();
                    sc.nextLine();

                    nav.visitarPagina(url, titulo, hora);
                    System.out.println("Pagina agregada correctamente");
                    break;

                case 2:
                    nav.retroceder();
                    System.out.println("Se ha retrocedido en el historial");
                    break;

                case 3:
                    if (nav.estaVacia()) {
                        System.out.println("No hay pagina actual");
                    } else {
                        System.out.println("Pagina actual: " + nav.getHistorial().peek().toString());
                    }
                    break;

                case 4:
                    System.out.println("Historial");
                    System.out.println(nav.obtenerHistorial());
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