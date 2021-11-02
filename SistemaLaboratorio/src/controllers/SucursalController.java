package controllers;

import dao.SucursalDAO;
import dtos.SucursalDTO;
import dtos.UsuarioDTO;

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
}
