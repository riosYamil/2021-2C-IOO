package controllers;

import dao.SucursalDAO;
import domains.Peticion;
import dtos.PacienteDTO;
import dtos.SucursalDTO;
import dtos.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

public class SucursalController {

    public void AltaSucursal(SucursalDTO s, UsuarioDTO u) {
        try {
            SucursalDAO sucursalDAO = new SucursalDAO();
            s.responsableTecnico = u;
            sucursalDAO.CrearSucursal(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public boolean BajaSucursal(int sucursalID) {
        try {
            SucursalDAO sucursalDAO = new SucursalDAO();
            boolean fueBorrado = sucursalDAO.BorrarSucursal(sucursalID);

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

    public List<Peticion> ObtenerPeticionesActivas(SucursalDTO s) {
        List<Peticion> ps = new ArrayList<Peticion>();

        for (Peticion p : s.peticiones) {
            if (p.estaActiva()) {
                ps.add(p);
            }
        }
        return ps;
    }

    public List<Peticion> ObtenerPeticionesFinalizadas(SucursalDTO s) {
        List<Peticion> ps = new ArrayList<Peticion>();

        for (Peticion p : s.peticiones) {
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

    public List<Peticion> BuscarPeticionesPorPaciente(SucursalDTO s, PacienteDTO paciente) {
        List<Peticion> ps = new ArrayList<Peticion>();

        for (Peticion peticion : s.peticiones) {
            if (peticion.obtenerPaciente().equals(paciente)) {
                ps.add(peticion);
            }
        }
        return ps;
    }

}
