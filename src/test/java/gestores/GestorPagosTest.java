/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import principal.Cita;
import principal.Medico;

/**
 *
 * @author Frankz
 */
public class GestorPagosTest {
    GestorPagos gestorPagos = null;
    
    @Before
    public void setUp() {
        this.gestorPagos = new GestorPagos();;
    }
    
    @Test
    public void given_cita_when_calcularPrecioCita_then_ok() {
        //Parametros        
        GestorCitasMedicas gestorCitas = new GestorCitasMedicas();
        Cita cita = gestorCitas.obtenerCita("2589372");
        double esperado = 32;
        double actual = this.gestorPagos.calcularPrecioCita(cita);        
        assertEquals(esperado, actual, 0.01);
    }
    
    @Test
    public void given_saldo_y_efectivo_when_calcularVuelto_then_ok() {        
        double esperado = 10.0;
        double actual = this.gestorPagos.calcularVuelto(70, 80);        
        assertEquals(esperado, actual, 0.1);        
    }    
    
    @Test
    public void given_precio_y_meses_when_diferirPagoEnMeses_then_ok() {        
        double esperado = 11.4;
        double actual = this.gestorPagos.diferirPagoEnMeses(110, 12);
        assertEquals(esperado, actual, 0.01);
    }
}
