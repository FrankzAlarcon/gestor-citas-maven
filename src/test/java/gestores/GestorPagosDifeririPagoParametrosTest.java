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
public class GestorPagosDifeririPagoParametrosTest {
    
    private double precio;
    private int meses;
    private double valorEsperado;

    public GestorPagosDifeririPagoParametrosTest(double precio,
            int meses, double valorEsperado) {
        this.precio = precio;
        this.meses = meses;
        this.valorEsperado = valorEsperado;
    }
    

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        ArrayList<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{110, 12, 11.4});
        objects.add(new Object[]{300, 4, 78.7});
        objects.add(new Object[]{200, 8, 28.0});
        objects.add(new Object[]{150, 1, 150.0});        
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
        double actual = gestorPagos.diferirPagoEnMeses(this.precio, this.meses);
        
        assertEquals(esperado, actual, 0.01);
    }    
}
