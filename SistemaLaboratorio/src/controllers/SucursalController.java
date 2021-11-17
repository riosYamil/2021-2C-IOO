package controllers;

import dao.PeticionDAO;
import dao.SucursalDAO;
import domains.Peticion;
import dtos.PeticionDTO;
import dtos.SucursalDTO;
import dtos.UsuarioDTO;
import services.SucursalService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public SucursalDTO AltaSucursal(SucursalDTO s) throws Exception {
        try {
            UsuarioController usuarioController = UsuarioController.getInstance();
            SucursalDAO sucursalDAO = new SucursalDAO();

            usuarioController.ObtenerUsuario(s.responsableTecnicoDNI);
            s.id = sucursalDAO.getLastInsertId() + 1;
            sucursalDAO.CrearSucursal(s);
        } catch (Exception e) {
            throw e;
        }
        return s;
    }

    public boolean BajaSucursal(int sucursalID) throws Exception {
        try {
            SucursalDAO sucursalDAO = new SucursalDAO();
            SucursalService sucursalService = new SucursalService();

            //Valida que exista la sucursal
            SucursalDTO sucursalDTO = ObtenerSucursal(sucursalID);

            if (!sucursalService.PuedeSerEliminado(sucursalID)) {
                throw new Exception("La sucursal tiene peticiones finalizadas.");
            }

            boolean fueBorrado = sucursalDAO.BorrarSucursal(sucursalID);
            if (!fueBorrado) {
                return false;
            }
        } catch (FileNotFoundException nfe) {
            throw new Exception("La sucursal no existe");
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    public boolean BajaSucursal(int origenSucursalID, Integer destinoSucursalID) throws Exception {
        try {
            SucursalDAO sucursalDAO = new SucursalDAO();
            SucursalService sucursalService = new SucursalService();

            //Valida que existan las sucursales
            SucursalDTO sucursalOrigen = ObtenerSucursal(origenSucursalID);
            SucursalDTO sucursalDestino = ObtenerSucursal(destinoSucursalID);

            if (!sucursalService.PuedeSerEliminado(origenSucursalID)) {
                throw new Exception("La sucursal tiene peticiones finalizadas.");
            }

            sucursalService.MigrarPeticiones(origenSucursalID, destinoSucursalID);
            boolean fueBorrado = sucursalDAO.BorrarSucursal(origenSucursalID);
            if (!fueBorrado) {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    public boolean ModificarSucursal(SucursalDTO s) throws Exception {
        try {
            SucursalDAO sucursalDAO = new SucursalDAO();
            boolean fueActualizado = sucursalDAO.ActualizarSucursal(s);
            if (!fueActualizado) {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    public SucursalDTO ObtenerSucursal(int sucursalID) throws Exception {
        SucursalDTO s = new SucursalDTO();
        try {
            SucursalDAO sucursalDAO = new SucursalDAO();
            s = sucursalDAO.ObtenerSucursal(sucursalID);
            if (Objects.isNull(s)) {
                throw new Exception("La sucursal no existe");
            }
        } catch (Exception e) {
            throw e;
        }
        return s;
    }

    public List<Peticion> ObtenerPeticionesActivas(SucursalDTO s) {
        List<Peticion> ps = new ArrayList<Peticion>();
        try {
            PeticionDAO peticionDAO = new PeticionDAO();
            List<PeticionDTO> peticiones = peticionDAO.ObtenerPeticionesDeSurcursal(s.id);
            for (PeticionDTO peticionDTO : peticiones) {
                Peticion peticion = new Peticion(peticionDTO);
                if (peticion.EstaActiva()) {
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
