/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;
import gestores.IGestorPagos;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mockito;
/**
 *
 * @author Frankz
 */
public class GestorPagosTest {
    IGestorPagos gestorPagos = null;
    
    @Before
    public void setUp() {
        gestorPagos = Mockito.mock(IGestorPagos.class);
        
    }
    
    @Test
    public void given_payment_when_is_correct_then_ok() {        
        Mockito.when(gestorPagos.calcularVuelto(90, 100)).thenReturn(10);

        //assertTrue();
    }
}
