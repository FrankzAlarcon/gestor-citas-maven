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
        final double PRECIO_BASE = 10.0;
        double precio = PRECIO_BASE;
        switch (cita.getEspecialidad()) {             
            case "Odontologia":
                precio += 80;
                break;
            case "Endocrinologia": 
                precio += 60;
                break;
            case "Psiquiatria":
                precio += 40;
                break;
            case "Medicina General":
                precio += 30;
                break;
            case "Ginecologia":
                precio += 100;
                break;
        }
        int edadPaciente = cita.getPaciente().getEdad();        
        if (edadPaciente < 18 || edadPaciente > 60) {
            // descuento 20%
            precio = precio * 0.8;
        }        
        return precio;
    }
    
    public double calcularVuelto(double saldo, double efectivo) {
        if (saldo > efectivo) return 0;
        return efectivo - saldo;
    }
    
    public double diferirPagoEnMeses(double precio, int meses){
        double precioPorMes = precio;
        if (meses == 1) {
            return precioPorMes;
        }
        if (meses > 1 && meses < 5) {
            precioPorMes = precioPorMes * 1.05;
        }
        if (meses > 5 && meses < 10) {
            precioPorMes = precioPorMes * 1.12;
        }
        if (meses > 10) {
            precioPorMes = precioPorMes * 1.25;
        }
        System.out.println("Antes " + precioPorMes);
        precioPorMes = precioPorMes / meses;
        System.out.println("precio " + precioPorMes);
        
        return Math.floor(precioPorMes * 10) / 10;
    }
    
    public boolean esTarjetaAceptada(ITarjetaCredito tarjeta, String numero) {
        boolean esValida = tarjeta.esValida(numero);
        return esValida;
    }
}
