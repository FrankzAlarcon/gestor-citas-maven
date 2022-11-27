/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package persistencia;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import principal.Administrador;

/**
 *
 * @author welli
 */
public class AdministradorPersistenciaTest {
    
    public AdministradorPersistenciaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of obtenerAdministrador method, of class AdministradorPersistencia.
     */
    @Test
    public void given_cedula_when_obtenerAdministrador_then_ok() {
        AdministradorPersistencia admiPersistencia = new AdministradorPersistencia();
        Administrador administrador = admiPersistencia.obtenerAdministrador("1234567890");
        assertNotNull(administrador);
    }
    
}
