/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import org.hamcrest.core.Is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import persistencia.CitasPersistencia;
import principal.Cita;
import principal.CitaCompletada;

/**
 *
 * @author Frankz
 */
public class GestorCitasMedicasTest {
    GestorCitasMedicas gestorCitas = null;
    @Before
    public void setUp() {
        this.gestorCitas = new GestorCitasMedicas();
    }
    @Test
    public void given_idCita_y_precio_when_completarCita_then_ok() {        
        String idCita = "2549375";
        Cita respaldoCita = gestorCitas.obtenerCita(idCita);
        CitaCompletada citaCompletada = gestorCitas.completarCita(idCita);
        Cita cita = gestorCitas.obtenerCita(idCita);
        CitaCompletada citaCompletadaObtenida = gestorCitas
                .obtenerCitaCompletada(idCita);
        
        assertNull(cita);
        assertEquals(citaCompletada.toString(), 
                citaCompletadaObtenida.toString());
        
        respaldoCita.registrar();
        citaCompletada.cancelar();
    }
}
