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
import gestores.GestorPagos;
/**
 *
 * @author Frankz
 */
public class GestorPagosTest {    
    @Test
    public void given_payment_when_is_correct_then_ok() {  
        GestorPagos gestorPagos = Mockito.mock(GestorPagos.class);
        Mockito.when(gestorPagos.calcularVuelto(90, 100)).thenReturn(10);
        assertEquals(10, gestorPagos.calcularVuelto(90, 100));        
    }
}
