import java.util.ArrayList;
import java.util.Scanner;

class Evento {
    private String titulo;
    private String fecha;
    private String descripcion;

    public Evento(String titulo, String fecha, String descripcion) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

public class AgendaApp {
    private static ArrayList<Evento> eventos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    agregarEvento();
                    break;
                case 2:
                    eliminarEvento();
                    break;
                case 3:
                    modificarEvento();
                    break;
                case 4:
                    listarEventos();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Agenda Electrónica ---");
        System.out.println("1. Agregar Evento");
        System.out.println("2. Eliminar Evento");
        System.out.println("3. Modificar Evento");
        System.out.println("4. Listar Eventos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarEvento() {
        System.out.print("Ingrese el título del evento: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese la fecha del evento (dd/mm/aaaa): ");
        String fecha = scanner.nextLine();
        System.out.print("Ingrese la descripción del evento: ");
        String descripcion = scanner.nextLine();
        eventos.add(new Evento(titulo, fecha, descripcion));
        System.out.println("Evento agregado exitosamente.");
    }

    private static void eliminarEvento() {
        System.out.print("Ingrese el ID del evento a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (id >= 0 && id < eventos.size()) {
            eventos.remove(id);
            System.out.println("Evento eliminado exitosamente.");
        } else {
            System.out.println("ID no válido.");
        }
    }

    private static void modificarEvento() {
        System.out.print("Ingrese el ID del evento a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        if (id >= 0 && id < eventos.size()) {
            Evento evento = eventos.get(id);
            System.out.print("Ingrese el nuevo título del evento: ");
            String titulo = scanner.nextLine();
            System.out.print("Ingrese la nueva fecha del evento (dd/mm/aaaa): ");
            String fecha = scanner.nextLine();
            System.out.print("Ingrese la nueva descripción del evento: ");
            String descripcion = scanner.nextLine();
            evento.setTitulo(titulo);
            evento.setFecha(fecha);
            evento.setDescripcion(descripcion);
            System.out.println("Evento modificado exitosamente.");
        } else {
            System.out.println("ID no válido.");
        }
    }

    private static void listarEventos() {
        System.out.println("\n--- Lista de Eventos ---");
        for (int i = 0; i < eventos.size(); i++) {
            Evento evento = eventos.get(i);
            System.out.println("ID: " + i + " | Título: " + evento.getTitulo() + " | Fecha: " + evento.getFecha() + " | Descripción: " + evento.getDescripcion());
        }
    }
}
