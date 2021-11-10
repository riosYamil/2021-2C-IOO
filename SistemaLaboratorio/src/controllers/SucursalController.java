package controllers;

import dao.SucursalDAO;
import dtos.PeticionDTO;
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
            s.id = sucursalDAO.getLastInsertId() + 1;
            s.responsableTecnico = u;
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
                //Do something
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

    public List<PeticionDTO> ObtenerPeticionesActivas(SucursalDTO s) {
        List<PeticionDTO> ps = new ArrayList<PeticionDTO>();

        for (PeticionDTO p : s.peticiones) {
            if (p.estaActiva()) {
                ps.add(p);
            }
        }
        return ps;
    }

    public List<PeticionDTO> ObtenerPeticionesFinalizadas(SucursalDTO s) {
        List<PeticionDTO> ps = new ArrayList<PeticionDTO>();

        for (PeticionDTO p : s.peticiones) {
            if (p.estaFinalizadas()) {
                ps.add(p);
            }
        }
        return ps;
    }

    public boolean TienePeticionesActivas(SucursalDTO s){
        return ObtenerPeticionesActivas(s).size() > 1;
    }

    public boolean TienePeticionesFinalizadas(SucursalDTO s){
        return ObtenerPeticionesFinalizadas(s).size() > 1;
    }

    public List<PeticionDTO> BuscarPeticionesPorPaciente(SucursalDTO s, PacienteDTO paciente) {
        List<PeticionDTO> ps = new ArrayList<PeticionDTO>();

        for (PeticionDTO peticion : s.peticiones) {
            if (peticion.obtenerPaciente().equals(paciente)) {
                ps.add(peticion);
            }
        }
        return ps;
    }

}
