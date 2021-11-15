package services;

import controllers.PeticionController;
import domains.Peticion;
import dtos.PeticionDTO;

import java.util.List;

public class PeticionService {

    public List<PeticionDTO> ObtenerPeticionesConResultadosCriticos(int pacienteID) {
        Boolean result = true;
        PeticionController peticionController = PeticionController.getInstance();
        List<PeticionDTO> peticiones = peticionController.ObtenerPeticionesCriticasPorPaciente(pacienteID);

        for (PeticionDTO peticionDTO : peticiones) {
            Peticion peticion = new Peticion(peticionDTO);
            if (!peticion.ObtenerPracticasFinalizadas().isEmpty()) {
                result = false;
                break;
            }
        }
        return peticiones;
    }
}
