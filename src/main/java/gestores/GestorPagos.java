/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import principal.Cita;

/**
 *
 * @author Frankz
 */
public class GestorPagos {
    
    public double calcularPrecioCita(Cita cita) {
        return 0;
    }
    
    public double calcularVuelto(double saldo, double efectivo) {
        if (saldo > efectivo) return 0;
        return efectivo - saldo;
    }
}
