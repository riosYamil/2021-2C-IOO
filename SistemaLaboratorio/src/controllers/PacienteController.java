package controllers;

import dao.PacienteDAO;
import dtos.PacienteDTO;

public class PacienteController {
    static PacienteController instance=null;

    private PacienteController(){
    }

    public static PacienteController getInstance() {
        if (instance == null) {
            instance = new PacienteController();
        }
        return instance;
    }

    public PacienteDTO AltaPaciente(PacienteDTO p) {
        try {
            PacienteDAO pacienteDAO = new PacienteDAO();
            pacienteDAO.CrearPaciente(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public boolean BajaPaciente(PacienteDTO p) {
        try {
            PacienteDAO pacienteDAO = new PacienteDAO();
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
            PacienteDAO pacienteDAO = new PacienteDAO();
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

    public PacienteDTO ObtenerPaciente(int pacienteID) {
        PacienteDTO p = new PacienteDTO();
        try {
            PacienteDAO pacienteDAO = new PacienteDAO();
            p = pacienteDAO.ObtenerPaciente(pacienteID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}
