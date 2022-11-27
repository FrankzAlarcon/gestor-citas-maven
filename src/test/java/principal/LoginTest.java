/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Frankz
 */
public class LoginTest {
    
    public LoginTest() {
    }

    /**
     * Test of validarCredenciales method, of class Login.
     */
    @Test
    public void given_user_and_password_when_login_then_ok() {
        Login login = new Login("1234567890","admin");
        
        assertTrue(login.validarCredenciales());  
    }
    
}
