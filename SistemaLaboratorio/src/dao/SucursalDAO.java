package dao;

import dtos.SucursalDTO;
import dtos.UsuarioDTO;

import java.io.FileNotFoundException;

public class SucursalDAO extends utils.GenericDAO {

    public SucursalDAO() throws Exception {
        super(SucursalDTO.class, "./src/goldenfiles/sucursales/sucursal_db");
    }

    public void CrearSucursal(SucursalDTO s) throws Exception {
        try {
            this.save(s);
        } catch (Exception e) {
            throw (e);
        }
    }

    public boolean ActualizarSucursal(SucursalDTO s) throws Exception {

        boolean fueActualizado = false;
        try {
            fueActualizado = this.update(s);
        } catch (Exception e) {
            throw (e);
        }

        return fueActualizado;

    }

    public boolean BorrarSucursal(int sucursalID) throws Exception {
        boolean fueBorrado = false;
        try {
            fueBorrado = this.delete(sucursalID);
        } catch (Exception e) {
            throw (e);
        }
        return fueBorrado;
    }

    public SucursalDTO ObtenerSucursal(int sucursalID) throws FileNotFoundException {
        SucursalDTO sucursaleDTO = new SucursalDTO();
        try {
            sucursaleDTO = (SucursalDTO) this.search(sucursalID);
        } catch (Exception e) {
            throw (e);
        }
        return sucursaleDTO;
    }
}
