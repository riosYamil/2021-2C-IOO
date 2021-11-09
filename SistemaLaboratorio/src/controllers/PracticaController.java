package controllers;

import dao.PacienteDAO;
import dao.PracticaDAO;
import domains.Practica;
import dtos.PacienteDTO;
import dtos.PracticaDTO;

public class PracticaController {

    public PracticaDTO AltaPractica(PracticaDTO p) {
        try {
            PracticaDAO practicaDAO = new PracticaDAO();
            practicaDAO.CrearPractica(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public boolean BajaPractica(PracticaDTO p) {
        try {
            PracticaDAO practicaDAO = new PracticaDAO();
            boolean fueBorrado = practicaDAO.BorrarPractica(p.id);

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
