/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.util.ArrayList;
import java.util.Scanner;
import principal.Paciente;
import persistencia.PacientesPersistencia;

/**
 *
 * @author Frankz
 */
public class GestorPacientes {

    private Paciente paciente;

    private ArrayList<String> recogerDatosPaciente() {
        Scanner in = new Scanner(System.in);
        ArrayList<String> med = new ArrayList<String>();
        System.out.println("INGRESE CI:");
        med.add(in.nextLine());
        System.out.println("INGRESE NOMBRE COMPLETO:");
        med.add(in.nextLine());
        System.out.println("INGRESE SU EDAD:");
        med.add(in.nextLine());
        System.out.println("INGRESE SU CORREO ELECTRONICO:");
        med.add(in.nextLine());
        return med;
    }

    public void registrarPaciente() {
        //Obtencion de datos
        ArrayList<String> med = recogerDatosPaciente();

        //llamado del metodo registrar
        this.paciente.registrar();
    }

    public Paciente obtenerPaciente(String cedula) {
        PacientesPersistencia pacienteP = new PacientesPersistencia();
        Paciente p = pacienteP.obtenerPaciente(cedula);
        if (p == null) {
            return null;
        }
        return p;
    }

    public String modificarPaciente(String cedula) {
        Paciente paciente = this.obtenerPaciente(cedula);
        System.out.println("Encontrado: " + paciente);
        if (paciente == null) {
            return "El medico con cédula " + cedula + " no existe.";
        }
        ArrayList<String> med = recogerDatosModificacion();
        //dando valor a la instancia medico
        Paciente pacienteModificado = new Paciente(paciente.getCedula(), med.get(0),
                Integer.parseInt(med.get(1)), med.get(2));

        paciente.modificar(pacienteModificado);
        return "La modificacion ha sido exitosa";
    }

    public ArrayList<String> recogerDatosModificacion() {
        Scanner in = new Scanner(System.in);

        ArrayList<String> med = new ArrayList<String>();

        System.out.println("=== INGRESE LOS CAMBIOS ===");
        System.out.println("INGRESE NOMBRE COMPLETO:");
        med.add(in.nextLine());
        System.out.println("INGRESE SU EDAD:");
        med.add(in.nextLine());
        System.out.println("INGRESE SU CORREO ELECTRONICO:");
        med.add(in.nextLine());

        return med;

    }

    public String eliminarPaciente(String cedula) {
        PacientesPersistencia pacienteP = new PacientesPersistencia();
        Paciente p = pacienteP.obtenerPaciente(cedula);
        if (p == null) {
            return "El usuario con cédula " + cedula + " no existe.";
        }
        p.eliminar();
        return "Eliminado exitosamente.";
    }

}
