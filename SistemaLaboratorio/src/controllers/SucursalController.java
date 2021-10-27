package controllers;

import domains.Sucursal;
import dtos.SucursalDTO;

public class SucursalController {

    public Sucursal AltaSucursal(SucursalDTO sucursalDTO) {
        Sucursal s = new Sucursal(sucursalDTO);
        dao.SucursalDAO.CrearSucursal(s.toSucursalDTO());
        return s;
    }

    public void BajaSucursal(int sucursalID) {
        dao.SucursalDAO.BorrarSucursal(sucursalID);
    }

    public void ModificarSucursal(SucursalDTO sucursalDTO) {
        dao.SucursalDAO.ActualizarSucursal(sucursalDTO);
    }

    public SucursalDTO ObtenerSucursal(int sucursalID) {
        return dao.SucursalDAO.ObtenerSucursal(sucursalID);
    }
}
