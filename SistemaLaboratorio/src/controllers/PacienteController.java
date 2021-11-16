package controllers;

import dao.PacienteDAO;
import dtos.PacienteDTO;
import services.PacienteService;

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
            p.id = Integer.parseInt(p.dni);
            PacienteDAO pacienteDAO = new PacienteDAO();
            pacienteDAO.CrearPaciente(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public boolean BajaPaciente(int id) {
        try {
            PacienteDAO pacienteDAO = new PacienteDAO();
            PacienteService pacienteService = new PacienteService();

            if (!pacienteService.PuedeSerEliminado(id)) {
                throw new Exception("El paciente no puede ser eliminado");
            }

            boolean fueBorrado = pacienteDAO.BorrarPaciente(id);

            if (!fueBorrado) {
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
