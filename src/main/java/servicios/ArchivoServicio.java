package servicios;

import Modelo.Alumno;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ArchivoServicio {

    private final promedioServicioImp promedioServicio = new promedioServicioImp();

    public void exportarDatos(Map<String, Alumno> alumnos, String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            for (Alumno alumno : alumnos.values()) {
                writer.write("Alumno : " + alumno.getRut() + " - " + alumno.getNombre() + "[");
                alumno.getMaterias().forEach(materia -> {
                    double promedio = promedioServicio.calcularPromedio(materia.getNotas());
                    try {
                        writer.write("materia [nombre=" + materia.getNombre() + ", notas=" + materia.getNotas() + "]");
                        writer.write("\nMateria: " + materia.getNombre() + " - Promedio: " + promedio + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                writer.write("]\n\n");
            }
            System.out.println("Datos exportados correctamente a " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al exportar datos: " + e.getMessage());
        }
    }
}
