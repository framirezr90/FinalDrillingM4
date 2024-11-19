package servicios;

import Modelo.Alumno;
import Modelo.Materia;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlumnoServicio {

    // Mapa para almacenar los alumnos por su RUT
    private final Map<String, Alumno> listaAlumnos = new HashMap<>();

    // Metodo para crear un nuevo alumno
    public void crearAlumno(Alumno alumno) {
        listaAlumnos.put(alumno.getRut(), alumno);
        System.out.println("Alumno creado: " + alumno.getNombre());
    }

    // Metodo para agregar una materia a un alumno
    public void agregarMateria(String rutAlumno, Materia materia) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        if (alumno != null) {
            alumno.getMaterias().add(materia);
            System.out.println("Materia agregada a " + alumno.getNombre());
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    // Metodo para listar las materias del alumno
    public List<Materia> materiasPorAlumno(String rutAlumno) {
        Alumno alumno = listaAlumnos.get(rutAlumno);
        return alumno != null ? alumno.getMaterias() : null;
    }

    // Metodo para listar los alumnos
    public Map<String, Alumno> listarAlumnos() {
        return listaAlumnos;
    }
}
