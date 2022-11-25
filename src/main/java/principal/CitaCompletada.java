/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.time.LocalDateTime;
import persistencia.CitasCompletadasPersistencia;
import persistencia.CitasPersistencia;

/**
 *
 * @author Frankz
 */
public class CitaCompletada {
    private String id;
    private LocalDateTime fecha;
    private String especialidad;
    private String descripcion;
    private boolean estaCompletada;
    private double precio;

    private CitasCompletadasPersistencia citaCompletadasPersistencia;
    private Medico medico;
    private Paciente paciente;

    public CitaCompletada(String id, LocalDateTime fecha, String especialidad, String descripcion, boolean estaCompletada, double precio,  Medico medico, Paciente paciente) {
        this.id = id;
        this.fecha = fecha;
        this.especialidad = especialidad;
        this.descripcion = descripcion;
        this.estaCompletada = estaCompletada;
        this.precio = precio;
        this.citaCompletadasPersistencia = new CitasCompletadasPersistencia();
        this.medico = medico;
        this.paciente = paciente;
    }    
    

    public void registrar() {
        this.citaCompletadasPersistencia.registrarCita(this);
    }

    public void modificar(Cita cita) {
        this.cancelar();
        cita.registrar();
    }

    public void cancelar() {
        this.citaCompletadasPersistencia.eliminarCita(this);
    }

    @Override
    public String toString() {
        return id + "," + fecha.toString() + "," + especialidad + "," + descripcion + "," + estaCompletada +"," + precio +"," + medico.getCedula() + "," + paciente.getCedula();
    }

    public String getId() {
        return this.id;
    }
}
