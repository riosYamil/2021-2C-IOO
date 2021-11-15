package services;

import controllers.PeticionController;
import domains.Peticion;
import dtos.PeticionDTO;

import java.util.List;

public class SucursalService {

    public boolean PuedeSerEliminado(int sucursalID) throws Exception {
        Boolean result = true;
        PeticionController peticionController = PeticionController.getInstance();
        List<PeticionDTO> peticiones = peticionController.ObtenerPeticionesDeSucursal(sucursalID);

        for (PeticionDTO peticionDTO : peticiones) {
            Peticion peticion = new Peticion(peticionDTO);
            if (!peticion.ObtenerPracticasFinalizadas().isEmpty()) {
                result = false;
                break;
            }
        }

        return result;
    }

}
