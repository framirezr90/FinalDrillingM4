package Vistas;

import Modelo.Alumno;
import Modelo.Materia;
import Modelo.MateriaEnum;
import servicios.AlumnoServicio;
import servicios.ArchivoServicio;

public class Menu extends MenuTemplate {
    private final AlumnoServicio alumnoServicio = new AlumnoServicio();
    private final ArchivoServicio archivoServicio = new ArchivoServicio();

    @Override
    public void exportarDatos() {
        System.out.println("--- Exportar Datos ---");
        String rutaDestino = "C:\\Cursos\\Java\\AlumnosyClase\\promedios.txt";
        archivoServicio.exportarDatos(alumnoServicio.listarAlumnos(), rutaDestino);
        System.out.println("Datos exportados a " + rutaDestino);
    }

    @Override
    public void crearAlumno() {
        System.out.println("--- Crear Alumno ---");
        System.out.print("Ingresa RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Ingresa nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingresa dirección: ");
        String direccion = scanner.nextLine();

        alumnoServicio.crearAlumno(new Alumno(rut, nombre, apellido, direccion));
        System.out.println("--- ¡Alumno agregado! ---");
    }

    @Override
    public void agregarMateria() {
        System.out.println("--- Agregar Materia ---");
        System.out.print("Ingresa el RUT del alumno: ");
        String rutAlumno = scanner.nextLine();

        Alumno alumno = alumnoServicio.listarAlumnos().get(rutAlumno);
        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }

        // Menú de selección de materias
        System.out.println("Seleccione una materia:");
        for (MateriaEnum materiaEnum : MateriaEnum.values()) {
            System.out.println((materiaEnum.ordinal() + 1) + ". " + materiaEnum);
        }

        int seleccion = scanner.nextInt();
        scanner.nextLine();
        MateriaEnum materiaSeleccionada = MateriaEnum.values()[seleccion - 1];

        Materia nuevaMateria = new Materia(materiaSeleccionada);
        alumnoServicio.agregarMateria(rutAlumno, nuevaMateria);
        System.out.println("--- Materia " + materiaSeleccionada + " agregada a " + alumno.getNombre() + " ---");
    }

    @Override
    public void agregarNotaPasoUno() {
        System.out.println("--- Agregar Nota ---");
        System.out.print("Ingresa el RUT del alumno: ");
        String rutAlumno = scanner.nextLine();

        Alumno alumno = alumnoServicio.listarAlumnos().get(rutAlumno);
        if (alumno == null) {
            System.out.println("Alumno no encontrado.");
            return;
        }

        // Verificar si el alumno tiene materias asignadas
        if (alumno.getMaterias().isEmpty()) {
            System.out.println("El alumno no tiene materias asignadas.");
            return;
        }

        // Listar las materias del alumno para que el usuario seleccione una
        System.out.println("Alumno tiene las siguientes materias agregadas:");
        int i = 1;
        for (Materia materia : alumno.getMaterias()) {
            System.out.println(i + ". " + materia.getNombre());
            i++;
        }

        System.out.print("Seleccionar materia: ");
        int seleccionMateria = scanner.nextInt();
        scanner.nextLine();

        // Validar selección de materia
        if (seleccionMateria < 1 || seleccionMateria > alumno.getMaterias().size()) {
            System.out.println("Selección inválida.");
            return;
        }

        // Obtener la materia seleccionada
        Materia materiaSeleccionada = alumno.getMaterias().get(seleccionMateria - 1);

        // Solicitar la nota y agregarla a la materia seleccionada
        System.out.print("Ingresa la nota: ");
        double nota = scanner.nextDouble();
        scanner.nextLine();  // Limpiar el buffer

        materiaSeleccionada.agregarNota(nota);
        System.out.println("--- Nota agregada a " + materiaSeleccionada.getNombre() + " ---");
    }

    @Override
    public void listarAlumnos() {
        System.out.println("--- Listar Alumnos ---");

        alumnoServicio.listarAlumnos().forEach((rut, alumno) -> {
            System.out.println("Datos Alumno");
            System.out.println("RUT: " + rut);
            System.out.println("Nombre: " + alumno.getNombre());
            System.out.println("Apellido: " + alumno.getApellido());
            System.out.println("Dirección: " + alumno.getDireccion());

            if (alumno.getMaterias().isEmpty()) {
                System.out.println("El alumno no tiene materias asignadas.");
            } else {
                System.out.println("Materias");
                alumno.getMaterias().forEach(materia -> {
                    System.out.println(materia.getNombre());
                    System.out.print("Notas: ");

                    if (materia.getNotas().isEmpty()) {
                        System.out.println("[Sin notas]");
                    } else {
                        System.out.println(materia.getNotas());
                    }
                });
            }
            System.out.println();
        });
    }
    }

