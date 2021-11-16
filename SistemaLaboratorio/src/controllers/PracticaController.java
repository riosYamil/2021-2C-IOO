package controllers;

import java.util.List;

import dao.PracticaDAO;
import domains.Peticion;
import dtos.PeticionDTO;
import dtos.PracticaAsociadaDTO;
import dtos.PracticaDTO;
import enums.EstadoResultadoPractica;

public class PracticaController {
    static PracticaController instance=null;

    private PracticaController(){
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

    public boolean BajaPractica(int id) throws Exception {
        try {
            PracticaDAO practicaDAO = new PracticaDAO();
            boolean fueBorrado = practicaDAO.BorrarPractica(id);

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
        PracticaDTO pdto = new PracticaDTO();
        try {
            PracticaDAO practicaDAO = new PracticaDAO();
            pdto = practicaDAO.ObtenerPractica(practicaID);
        } catch (Exception e) {
            throw e;
        }
        return pdto;
    }
    
    public PracticaAsociadaDTO ObtenerPracticaAsocidada(List<PracticaAsociadaDTO> pa, int id) {
    	PracticaAsociadaDTO p = null;
    	for (PracticaAsociadaDTO practicasAsociada : pa) {
        	if(practicasAsociada.practicaID == id) {
        		p = practicasAsociada;
        	}

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
