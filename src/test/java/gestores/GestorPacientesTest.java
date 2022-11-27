/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gestores;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import gestores.GestorPacientes;
import principal.Paciente;
import persistencia.PacientesPersistencia;


/**
 *
 * @author Glender Miranda
 */
public class GestorPacientesTest {
    
    public GestorPacientesTest() {
    }
    
    @Test
    public void given_cedula_when_eliminarPaciente_then_ok(){
        GestorPacientes gestorP = new GestorPacientes();
        PacientesPersistencia pacienteP = new PacientesPersistencia();
        Paciente paciente1 = gestorP.obtenerPaciente("1250395702");
        gestorP.eliminarPaciente(paciente1.getCedula());        
        assertNull(gestorP.obtenerPaciente(paciente1.getCedula()));
        pacienteP.registrarPaciente(paciente1);
    }
    
}
