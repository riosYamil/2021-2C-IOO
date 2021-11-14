package controllers;

import dao.PeticionDAO;
import dtos.PacienteDTO;
import dtos.PeticionDTO;

import java.util.ArrayList;
import java.util.List;

public class PeticionController {
    static PeticionController instance=null;

    private PeticionController(){
    }

    public static PeticionController getInstance() {
        if (instance == null) {
            instance = new PeticionController();
        }
        return instance;
    }

    public PeticionDTO AltaPeticion(PeticionDTO p) {
        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            p.id = peticionDAO.getLastInsertId() + 1;
            peticionDAO.CrearPeticion(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public boolean BajaPeticion(int id) {
        try {
        	PeticionDAO peticionDAO = new PeticionDAO();
            boolean fueBorrado = peticionDAO.BorrarPeticion(id);

            if (!fueBorrado) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean ModificarPeticione(PeticionDTO p) {
        try {
        	PeticionDAO peticionDAO = new PeticionDAO();
            boolean fueActualizado = peticionDAO.ActualizarPeticion(p);
            if (!fueActualizado) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public PeticionDTO ObtenerPeticion(int PeticionID) {
        PeticionDTO p = new PeticionDTO();
        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            p = peticionDAO.ObtenerPeticion(PeticionID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }




    public static List<PeticionDTO> ObtenerPeticionesCompletasPorPaciente(PacienteDTO p) {
        List<PeticionDTO> peticiones = new ArrayList<PeticionDTO>();
        return peticiones;
    }

    public static List<PeticionDTO> ObtenerPeticionesPendientesPorPaciente(PacienteDTO p) {
        List<PeticionDTO> peticiones = new ArrayList<PeticionDTO>();
        return peticiones;
    }
}
