package servicios;

import java.util.List;

public class promedioServicioImp {

    // Metodo para calcular promedio de alumnos
    public double calcularPromedio(List<Double> notas) {
        if (notas == null || notas.isEmpty()) {
            return 0.0;
        }
        double suma = 0;
        for (Double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }
}
