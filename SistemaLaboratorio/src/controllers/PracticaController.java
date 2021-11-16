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

    public PracticaDTO AltaPractica(PracticaDTO p) {
        try {
            PracticaDAO practicaDAO = new PracticaDAO();
            p.id = practicaDAO.getLastInsertId() + 1;
            practicaDAO.CrearPractica(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public boolean BajaPractica(int id) {
        try {
            PracticaDAO practicaDAO = new PracticaDAO();
            boolean fueBorrado = practicaDAO.BorrarPractica(id);

            if (!fueBorrado) {
                //Do something
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean ModificarPractica(PracticaDTO p) {
        try {
            PracticaDAO practicaDAO = new PracticaDAO();
            boolean fueActualizado = practicaDAO.ActualizarPractica(p);
            if (!fueActualizado) {
                //Do something
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public PracticaDTO ObtenerPractica(int practicaID) {
        PracticaDTO pdto = new PracticaDTO();
        try {
            PracticaDAO practicaDAO = new PracticaDAO();
            pdto = practicaDAO.ObtenerPractica(practicaID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pdto;
    }
}
