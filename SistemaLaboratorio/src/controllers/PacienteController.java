package controllers;

import dao.PacienteDAO;
import dtos.PacienteDTO;

public class PacienteController {

    public PacienteDTO AltaPaciente(PacienteDTO p) {
        try {
            PacienteDAO pacienteDAO = new PacienteDAO(p.dni);
            pacienteDAO.CrearPaciente(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public boolean BajaPaciente(PacienteDTO p) {
        try {
            PacienteDAO pacienteDAO = new PacienteDAO(p.id.toString());
            boolean fueBorrado = pacienteDAO.BorrarPaciente(p.id);

            if (!fueBorrado) {
                //Do something
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean ModificarPaciente(PacienteDTO p) {
        try {
            PacienteDAO pacienteDAO = new PacienteDAO(p.dni);
            boolean fueActualizado = pacienteDAO.ActualizarPaciente(p);
            if (!fueActualizado) {
                //Do something
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    //TODO: Checkear si este método será necesario
    public PacienteDTO ObtenerPaciente(Integer id) {
        PacienteDTO p = new PacienteDTO();
        try {
            PacienteDAO pacienteDAO = new PacienteDAO(id.toString());
            p = pacienteDAO.ObtenerPaciente(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}
