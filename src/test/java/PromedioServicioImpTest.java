import org.junit.jupiter.api.Test;
import servicios.promedioServicioImp;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromedioServicioImpTest {

    @Test
    public void calcularPromedioTest() {
        promedioServicioImp promedioServicio = new promedioServicioImp();
        List<Double> notas = Arrays.asList(4.0, 5.0, 6.0);
        double promedioEsperado = 5.0;

        double promedio = promedioServicio.calcularPromedio(notas);

        assertEquals(promedioEsperado, promedio);
    }
}
