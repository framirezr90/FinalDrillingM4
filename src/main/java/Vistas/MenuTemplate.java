package Vistas;

import java.util.Scanner;

public abstract class MenuTemplate {
    protected Scanner scanner = new Scanner(System.in);

    public void exportarDatos() {

    }

    public void crearAlumno() {

    }

    public void agregarMateria() {

    }

    public void agregarNotaPasoUno() {

    }

    public void listarAlumnos() {

    }

    public void terminarPrograma() {
        System.out.println("Programa terminado.");
    }

    public final void iniciarMenu() {
        int opcion;
        do {
            System.out.println("1. Crear Alumno");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Agregar Materias");
            System.out.println("4. Agregar Notas");
            System.out.println("5. Salir");
            System.out.println("6. Exportar Datos");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> crearAlumno();
                case 2 -> listarAlumnos();
                case 3 -> agregarMateria();
                case 4 -> agregarNotaPasoUno();
                case 5 -> terminarPrograma();
                case 6 -> exportarDatos();
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }
}
