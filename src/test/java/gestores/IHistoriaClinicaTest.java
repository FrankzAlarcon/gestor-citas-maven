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
public class IHistoriaClinicaTest {
    
    @Test
    public void given_historiaClinica_y_cedula_when_obtenerHistoriaClinica_then_ok() {
        IHistoriaClinica historiaClinica = Mockito.mock(IHistoriaClinica.class);
        Mockito.when(historiaClinica.obtenerAntecedentes("123456789"))
                .thenReturn(new String[]{"Conjuntivitis","Diabetes","Gastritis"});
        
        GestorPacientes gestorPacientes = new GestorPacientes();
        assertArrayEquals(new String[]{"Conjuntivitis","Diabetes","Gastritis"},
                gestorPacientes.obtenerAntecedentes(historiaClinica, "123456789"));
    }
}
