import Modelo.Alumno;
import Modelo.Materia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicios.AlumnoServicio;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AlumnoServicioTest {

    private AlumnoServicio alumnoServicio;
    private Alumno alumno;

    @BeforeEach
    public void setup() {
        alumnoServicio = new AlumnoServicio();
        alumno = new Alumno("1.111.111-1", "Milton", "P.", "Casita 1");
        alumnoServicio.crearAlumno(alumno);
    }

    @Test
    public void crearAlumnoTest() {
        assertNotNull(alumnoServicio.listarAlumnos().get("1.111.111-1"));
    }

    @Test
    public void agregarMateriaTest() {
        Materia matematicas = new Materia("Matemáticas");
        alumnoServicio.agregarMateria("1.111.111-1", matematicas);

        List<Materia> materias = alumnoServicio.materiasPorAlumno("1.111.111-1");
        assertTrue(materias.contains(matematicas));
    }

    @Test
    public void materiasPorAlumnosTest() {
        List<Materia> materias = alumnoServicio.materiasPorAlumno("1.111.111-1");
        assertNotNull(materias);
    }

    @Test
    public void listarAlumnosTest() {
        Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();
        assertFalse(alumnos.isEmpty());
    }
}
