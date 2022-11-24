/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.ArrayList;
import java.util.Scanner;
import persistencia.PacientesPersistencia;

/**
 *
 * @author Frankz
 */
public class Paciente {

    private String cedula;
    private String nombre;
    private int edad;
    //private int numHistoriaClinica;
    private String correoElectronico;
    private PacientesPersistencia pacientePersistencia;

    public Paciente() {
        this.pacientePersistencia = new PacientesPersistencia();
    }

    public Paciente(String cedula, String nombre, int edad, String correoElectronico) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.pacientePersistencia = new PacientesPersistencia();
    }

    public void registrar() {
        this.pacientePersistencia.registrarPaciente(this);
    }

    public void modificar(Paciente pacienteModificado) {
        this.eliminar();
        pacienteModificado.registrar();
    }

    public void eliminar() {
        this.pacientePersistencia.eliminarPaciente(this);
    }

    public String getCedula() {
        return cedula;
    }

    @Override
    public String toString() {
        return cedula + "," + nombre + "," + edad + "," + correoElectronico;
    }

}
