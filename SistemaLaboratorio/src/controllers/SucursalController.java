package controllers;

import dao.PeticionDAO;
import dao.SucursalDAO;
import domains.Peticion;
import dtos.PacienteDTO;
import dtos.SucursalDTO;
import dtos.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

public class SucursalController {
    static SucursalController instance = null;

    private SucursalController() {
    }

    public static SucursalController getInstance() {
        if (instance == null) {
            instance = new SucursalController();
        }
        return instance;
    }

    public SucursalDTO AltaSucursal(SucursalDTO s, UsuarioDTO u) {
        try {
            SucursalDAO sucursalDAO = new SucursalDAO();
            s.responsableTecnico = u;
            s.id = sucursalDAO.getLastInsertId() + 1;
            sucursalDAO.CrearSucursal(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public boolean BajaSucursal(SucursalDTO s) {
        try {
            SucursalDAO sucursalDAO = new SucursalDAO();
            boolean fueBorrado = sucursalDAO.BorrarSucursal(s.id);

            if (!fueBorrado) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean ModificarSucursal(SucursalDTO s) {
        try {
            SucursalDAO sucursalDAO = new SucursalDAO();
            boolean fueActualizado = sucursalDAO.ActualizarSucursal(s);
            if (!fueActualizado) {
                //Do something
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public SucursalDTO ObtenerSucursal(int sucursalID) {
        SucursalDTO s = new SucursalDTO();
        try {
            SucursalDAO sucursalDAO = new SucursalDAO();
            s = sucursalDAO.ObtenerSucursal(sucursalID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public List<Peticion> ObtenerPeticionesActivas(SucursalDTO s) {
        List<Peticion> ps = new ArrayList<Peticion>();
        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            List<Peticion> peticiones = peticionDAO.ObtenerPeticionesDeSurcursal(s.id);
            for (Peticion p : peticiones) {
                if (p.EstaActiva()) {
                    ps.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ps;
    }

    public List<Peticion> ObtenerPeticionesFinalizadas(SucursalDTO s) {
        List<Peticion> ps = new ArrayList<Peticion>();

        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            List<Peticion> peticiones = peticionDAO.ObtenerPeticionesDeSurcursal(s.id);
            for (Peticion p : peticiones) {
                if (p.EstaFinalizadas()) {
                    ps.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ps;
    }

    public boolean TienePeticionesActivas(SucursalDTO s) {
        return ObtenerPeticionesActivas(s).size() > 1;
    }

    public boolean TienePeticionesFinalizadas(SucursalDTO s) {
        return ObtenerPeticionesFinalizadas(s).size() > 1;
    }

    public List<Peticion> BuscarPeticionesPorPaciente(SucursalDTO s, PacienteDTO paciente) {
        List<Peticion> ps = new ArrayList<Peticion>();

        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            List<Peticion> peticiones = peticionDAO.ObtenerPeticionesDeSurcursal(s.id);
            for (Peticion peticion : peticiones) {
                if (peticion.ObtenerPaciente().equals(paciente)) {
                    ps.add(peticion);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ps;
    }

    public  List<SucursalDTO> ObtenerSurcursalesPorUsuario(UsuarioDTO usuarioDTO){
        List<SucursalDTO> sucursalDTOs = new ArrayList<SucursalDTO>();
        try {
            SucursalDAO sucursalDAO = new SucursalDAO();
            sucursalDTOs = sucursalDAO.ObtenerSucursalesPorUsuario(usuarioDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sucursalDTOs;
    }
}
