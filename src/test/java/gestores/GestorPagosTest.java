/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;
import principal.Cita;
import principal.Medico;

/**
 *
 * @author Frankz
 */
public class GestorPagosTest {
    
    public GestorPagosTest() {
    }

    /**
     * Test of calcularVuelto method, of class GestorPagos.
     */
    
    @Test
    public void given_cita_when_calcularPrecioCita_then_ok() {
        //Parametros
        GestorPagos gestorPagos =  new GestorPagos();
        GestorCitasMedicas gestorCitas = new GestorCitasMedicas();
        Cita cita = gestorCitas.obtenerCita("2589372");
        double esperado = 32;
        double actual = gestorPagos.calcularPrecioCita(cita);
        
        assertEquals(esperado, actual, 0.01);
    }
    
    @Test
    public void given_saldo_y_efectivo_when_calcularVuelto_then_ok() {
        GestorPagos gestorPagos =  new GestorPagos();
        double esperado = 10.0;
        double actual = gestorPagos.calcularVuelto(70, 80);
        
        assertEquals(esperado, actual, 0.1);        
    }    
    
    @Test
    public void given_precio_y_meses_when_diferirPagoEnMeses_then_ok() {
        GestorPagos gestorPagos =  new GestorPagos();
        double esperado = 11.5;
        double actual = gestorPagos.diferirPagoEnMeses(110, 12);
        assertEquals(esperado, actual, 0.01);
    }
}
