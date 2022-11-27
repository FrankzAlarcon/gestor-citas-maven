/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import persistencia.CitasPersistencia;
import principal.Cita;
import principal.Medico;

/**
 *
 * @author Frankz
 */
@RunWith(value = Parameterized.class)
public class GestorPagosParametrosTest {
    
    private Cita cita;
    private double valorEsperado;
    
    public GestorPagosParametrosTest(Cita cita, double valorEsperado) {
        this.cita = cita;
        this.valorEsperado = valorEsperado;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        ArrayList<Object[]> objects = new ArrayList<Object[]>();
        CitasPersistencia citasP = new CitasPersistencia();
        //parametros (a,b,expected)
        objects.add(new Object[]{citasP.obtenerCita("2589372"), 32});
        objects.add(new Object[]{citasP.obtenerCita("6011685"), 72});
        objects.add(new Object[]{citasP.obtenerCita("1100408"), 50});
        return objects;
    }    
    /**
     * Test of calcularVuelto method, of class GestorPagos.
     */
    
    @Test
    public void given_cita_when_calcularPrecioCita_then_ok() {
        //Parametros
        GestorPagos gestorPagos =  new GestorPagos();
        double esperado = this.valorEsperado;
        double actual = gestorPagos.calcularPrecioCita(this.cita);
        
        assertEquals(esperado, actual, 0.01);
    }    
}
