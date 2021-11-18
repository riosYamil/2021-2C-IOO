package controllers;

import dao.PracticaDAO;
import dtos.PracticaAsociadaDTO;
import dtos.PracticaDTO;
import enums.EstadoResultadoPractica;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

public class PracticaController {
    static PracticaController instance = null;

    private PracticaController() {
    }

    public static PracticaController getInstance() {
        if (instance == null) {
            instance = new PracticaController();
        }
        return instance;
    }

    public PracticaDTO AltaPractica(PracticaDTO p) throws Exception {
        try {
            PracticaDAO practicaDAO = new PracticaDAO();
            p.id = practicaDAO.getLastInsertId() + 1;
            practicaDAO.CrearPractica(p);
        } catch (Exception e) {
            throw e;
        }
        return p;
    }

    public boolean BajaPractica(int practicaID) throws Exception {
        try {
            PracticaDAO practicaDAO = new PracticaDAO();

            //Valida que exista la practica
            PracticaDTO practicaDTO = ObtenerPractica(practicaID);

            boolean fueBorrado = practicaDAO.BorrarPractica(practicaID);
            if (!fueBorrado) {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    public boolean ModificarPractica(PracticaDTO p) throws Exception {
        try {
            PracticaDAO practicaDAO = new PracticaDAO();
            boolean fueActualizado = practicaDAO.ActualizarPractica(p);
            if (!fueActualizado) {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    public PracticaDTO ObtenerPractica(int practicaID) throws Exception {
        PracticaDTO p = new PracticaDTO();
        try {
            PracticaDAO practicaDAO = new PracticaDAO();
            p = practicaDAO.ObtenerPractica(practicaID);

            if (Objects.isNull(p)) {
                throw new Exception("La practica no existe");
            }
        } catch (Exception e) {
            throw e;
        }
        return p;
    }
        
    public boolean EstaHabilitada(EstadoResultadoPractica e, int id) {
    	boolean habilidata = false;
		if(e == EstadoResultadoPractica.Pendiente) {
			habilidata = true;
		}
    	return habilidata;
    }
}
