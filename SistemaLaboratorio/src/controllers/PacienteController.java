package controllers;

import dao.PacienteDAO;
import dtos.PacienteDTO;
import services.PacienteService;

import java.io.FileNotFoundException;
import java.util.Objects;

public class PacienteController {
    static PacienteController instance = null;

    private PacienteController() {
    }

    public static PacienteController getInstance() {
        if (instance == null) {
            instance = new PacienteController();
        }
        return instance;
    }

    public PacienteDTO AltaPaciente(PacienteDTO p) throws Exception {
        try {
            p.id = Integer.parseInt(p.dni);
            PacienteDAO pacienteDAO = new PacienteDAO();
            pacienteDAO.CrearPaciente(p);
        } catch (Exception e) {
            throw e;
        }
        return p;
    }

    public boolean BajaPaciente(int pacienteID) throws Exception {
        try {
            PacienteDAO pacienteDAO = new PacienteDAO();
            PacienteService pacienteService = new PacienteService();

            //Valida que exista el paciente
            PacienteDTO pacienteDTO = ObtenerPaciente(pacienteID);

            if (!pacienteService.PuedeSerEliminado(pacienteID)) {
                throw new Exception("El paciente tiene peticiones finalizadas");
            }

            boolean fueBorrado = pacienteDAO.BorrarPaciente(pacienteID);
            if (!fueBorrado) {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    public boolean ModificarPaciente(PacienteDTO p) throws Exception {
        try {
            PacienteDAO pacienteDAO = new PacienteDAO();
            boolean fueActualizado = pacienteDAO.ActualizarPaciente(p);
            if (!fueActualizado) {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    public PacienteDTO ObtenerPaciente(int pacienteID) throws Exception {
        PacienteDTO p = new PacienteDTO();
        try {
            PacienteDAO pacienteDAO = new PacienteDAO();
            p = pacienteDAO.ObtenerPaciente(pacienteID);
            if (Objects.isNull(p)) {
                throw new Exception("El paciente no existe");
            }
        } catch (Exception e) {
            throw e;
        }
        return p;
    }
}
