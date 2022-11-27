/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

/**
 *
 * @author Frankz
 */
public interface IHistoriaClinica {
    //Obtener enfermedades anteriores
   public String[] obtenerAntecedentes(String cedula);
}
