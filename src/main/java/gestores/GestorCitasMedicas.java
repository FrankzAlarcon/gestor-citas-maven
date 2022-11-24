/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import persistencia.CitasPersistencia;
import principal.Cita;

/**
 *
 * @author Frankz
 */
public class GestorCitasMedicas {

    private GestorMedicos gMedicos;
    private GestorPacientes gPacientes;
    private Cita cita;

    public GestorCitasMedicas() {
        this.gMedicos = new GestorMedicos();
        this.gPacientes = new GestorPacientes();
    }

    public ArrayList<Cita> obtenerTodasLasCitas() {
        CitasPersistencia citaP = new CitasPersistencia();
        return citaP.recuperarCitas();
    }

    public Cita obtenerCita(String idCita) {
        CitasPersistencia citaP = new CitasPersistencia();
        Cita cita = citaP.obtenerCita(idCita);
        if (cita == null) {
            return null;
        }
        return cita;
    }

    private ArrayList<String> recogerDatosParaCita() {
        Scanner in = new Scanner(System.in);
        ArrayList<String> med = new ArrayList<String>();
        System.out.println("INGRESE FECHA DE CONSULTA [aa/mm/dd/hh:min]:");
        med.add(in.nextLine());
        System.out.println("INGRESE ESPECIALIDAD:");
        med.add(in.nextLine());
        System.out.println("INGRESE DESCRIPCION:");
        med.add(in.nextLine());
        //con el ci se encuentra y se obtiene el objeto medico desde el csv
        System.out.println("INGRESE CI DEL MEDICO:");
        med.add(in.nextLine());
        System.out.println("INGRESE CI DEL PACIENTE:");
        med.add(in.nextLine());

        return med;
    }

    public void registrarCita() {
        ArrayList<String> med = recogerDatosParaCita();

        //dando valor a la instancia Cita
        this.cita = new Cita(LocalDateTime.of(
                Integer.parseInt(med.get(0).substring(0, 3)),
                (Integer.parseInt(med.get(0).substring(5, 6))),
                (Integer.parseInt(med.get(0).substring(8, 9))),
                (Integer.parseInt(med.get(0).substring(11, 12))),
                (Integer.parseInt(med.get(0).substring(14, 15)))),
                med.get(1), med.get(2),
                gMedicos.obtenerMedico(med.get(3)),
                gPacientes.obtenerPaciente(med.get(4)));

        //llamado del metodo registrar
        this.cita.registrar();
    }

    private ArrayList<String> recogerDatosModificacion() {
        Scanner in = new Scanner(System.in);
        ArrayList<String> med = new ArrayList<String>();

        System.out.println("=== INGRESE LOS CAMBIOS ===");
        System.out.println("INGRESE FECHA DE CONSULTA [aa/mm/dd/hh:min]:");
        med.add(in.nextLine());
        System.out.println("INGRESE ESPECIALIDAD:");
        med.add(in.nextLine());
        System.out.println("INGRESE DESCRIPCION:");
        med.add(in.nextLine());
        //con el ci se encuentra y se obtiene el objeto medico desde el csv
        System.out.println("INGRESE CI DEL MEDICO:");
        med.add(in.nextLine());
        System.out.println("INGRESE CI DEL PACIENTE:");
        med.add(in.nextLine());

        return med;
    }

    public String modificarCita(String id) {
        Cita cita = this.obtenerCita(id);
        if (cita == null) {
            return "La cita con id " + id + " no existe.";
        }
        System.out.println(cita);
        ArrayList<String> med = recogerDatosModificacion();
        Cita citaModificada = new Cita(cita.getId(),
                LocalDateTime.of(
                Integer.parseInt(med.get(0).substring(0, 3)),
                (Integer.parseInt(med.get(0).substring(5, 6))),
                (Integer.parseInt(med.get(0).substring(8, 9))),
                (Integer.parseInt(med.get(0).substring(11, 12))),
                (Integer.parseInt(med.get(0).substring(14, 15)))),
                med.get(1), med.get(2),
                gMedicos.obtenerMedico(med.get(3)),
                gPacientes.obtenerPaciente(med.get(4)));
        cita.modificar(citaModificada);
        return "La modificacion ha sido exitosa";
    }

    public String eliminarCita(String idCita) {
        CitasPersistencia citaP = new CitasPersistencia();
        Cita cita = citaP.obtenerCita(idCita);
        if (cita == null) {
            return "El medico con cédula " + idCita + " no existe.";
        }
        System.out.println(cita.toString());
        cita.cancelar();
        return "Eliminado exitosamente.";
    }
}
