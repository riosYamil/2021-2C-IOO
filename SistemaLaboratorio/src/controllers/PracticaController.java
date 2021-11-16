package controllers;

import dao.PracticaDAO;
import dtos.PracticaDTO;

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
}
