package controllers;

import dao.PeticionDAO;
import domains.Peticion;
import domains.Practica;
import dtos.PeticionDTO;
import dtos.PracticaAsociadaDTO;
import dtos.SucursalDTO;
import enums.EstadoPeticion;
import services.PeticionService;

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

    public PeticionDTO AltaPeticion(PeticionDTO p) throws Exception {
        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            PacienteController pacienteController = PacienteController.getInstance();
            PeticionService peticionService = new PeticionService();

            pacienteController.ObtenerPaciente(p.pacienteID);

            p.id = peticionDAO.getLastInsertId() + 1;
            p.estadoPeticion = peticionService.DeterminarEstado(p);

            peticionDAO.CrearPeticion(p);
        } catch (Exception e) {
            throw e;
        }
        return p;
    }

    public boolean BajaPeticion(int id) throws Exception {
        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            boolean fueBorrado = peticionDAO.BorrarPeticion(id);

            if (!fueBorrado) {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    public boolean ModificarPeticion(PeticionDTO p) throws Exception {
        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            PeticionService peticionService = new PeticionService();
            p.estadoPeticion = peticionService.DeterminarEstado(p);

            boolean fueActualizado = peticionDAO.ActualizarPeticion(p);
            if (!fueActualizado) {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    public PeticionDTO ObtenerPeticion(int PeticionID) throws Exception {
        PeticionDTO p = new PeticionDTO();
        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            p = peticionDAO.ObtenerPeticion(PeticionID);
        } catch (Exception e) {
            throw e;
        }
        return p;
    }

    public void EnviarNotificacion() {
        System.out.println("notificación enviada");
    }

    public List<PeticionDTO> ObtenerPeticionesCriticas() {
        List<PeticionDTO> peticiones = new ArrayList<>();

        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            peticiones = peticionDAO.ObtenerPeticiones();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obtenerPeticionesCriticas(peticiones);
    }

    public List<PeticionDTO> ObtenerPeticionesDeSucursal(int sucursalID) {
        List<PeticionDTO> peticiones = new ArrayList<>();
        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            peticiones = peticionDAO.ObtenerPeticionesDeSurcursal(sucursalID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peticiones;
    }

    public List<PeticionDTO> ObtenerPeticionesDelPaciente(int pacienteID) {
        List<PeticionDTO> peticiones = new ArrayList<>();

        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            peticiones = peticionDAO.ObtenerPeticionesDePaciente(pacienteID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return peticiones;
    }

    public List<PeticionDTO> ObtenerPeticionesPendientesPorPaciente(int pacienteID) {
        List<PeticionDTO> peticiones = ObtenerPeticionesDelPaciente(pacienteID);
        List<PeticionDTO> resultado = new ArrayList<>();

        for (PeticionDTO p : peticiones) {
            if (p.estadoPeticion == EstadoPeticion.Activa) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<PeticionDTO> ObtenerPeticionesCompletasPorPaciente(int pacienteID) {
        List<PeticionDTO> peticiones = ObtenerPeticionesDelPaciente(pacienteID);
        List<PeticionDTO> resultado = new ArrayList<>();

        for (PeticionDTO p : peticiones) {
            if (p.estadoPeticion == EstadoPeticion.Finalizada) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<PeticionDTO> ObtenerPeticionesCriticasPorPaciente(int pacienteID) {
        List<PeticionDTO> peticiones = ObtenerPeticionesDelPaciente(pacienteID);

        return obtenerPeticionesCriticas(peticiones);
    }

    private List<PeticionDTO> obtenerPeticionesCriticas(List<PeticionDTO> peticiones) {
        List<PeticionDTO> resultado = new ArrayList<>();

        for (PeticionDTO p : peticiones) {
            for (PracticaAsociadaDTO paDTO : p.practicasAsociadas) {

                PracticaController practicaController = PracticaController.getInstance();

                try {
                    Practica practica = new Practica(practicaController.ObtenerPractica(paDTO.practicaID));

                    if (practica.EsUnValorCritico(paDTO.resultado)) {
                        resultado.add(p);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return resultado;
    }

    public List<Peticion> ObtenerPeticionesFinalizadas(SucursalDTO s) {
        List<Peticion> ps = new ArrayList<>();

        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            List<PeticionDTO> peticiones = peticionDAO.ObtenerPeticionesDeSurcursal(s.id);
            for (PeticionDTO peticionDTO : peticiones) {
                Peticion peticion = new Peticion(peticionDTO);
                if (peticion.EstaFinalizadas()) {
                    ps.add(peticion);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ps;
    }

}
