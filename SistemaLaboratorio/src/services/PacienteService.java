package services;

import controllers.PeticionController;
import domains.Peticion;
import dtos.PeticionDTO;

import java.util.List;

public class PacienteService {

    public boolean PuedeSerEliminado(int pacienteID) throws Exception {
        Boolean result = true;
        PeticionController peticionController = PeticionController.getInstance();
        List<PeticionDTO> peticiones = peticionController.ObtenerPeticionesDelPaciente(pacienteID);

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
