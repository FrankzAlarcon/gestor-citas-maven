/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mockito;
/**
 *
 * @author Frankz
 */
public class ITarjetaCreditoTest {
    
    @Test
    public void given_tarjetaCradito_y_numero_when_esTarjetaAceptada_then_ok() {
        ITarjetaCredito tarjeta = Mockito.mock(ITarjetaCredito.class);
        Mockito.when(tarjeta.esValida("43817171")).thenReturn(true);
        
        GestorPagos gestorPagos = new GestorPagos();
        assertTrue(gestorPagos.esTarjetaAceptada(tarjeta, "43817171"));
    }
}
