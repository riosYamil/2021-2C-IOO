package dao;

import dtos.PeticionDTO;

public class PeticionDAO extends utils.GenericDAO {

    public PeticionDAO() throws Exception {
        super(PeticionDTO.class, "./src/goldenfiles/peticion/peticion_db");
    }

    public void CrearPeticion(PeticionDTO p) throws Exception {
        try {
            this.save(p);
        } catch (Exception e) {
            throw (e);
        }
    }

    public boolean ActualizarPeticion(PeticionDTO p) throws Exception {
        boolean fueActualizado = false;
        try {
            fueActualizado = this.update(p);
        } catch (Exception e) {
            throw (e);
        }

        return fueActualizado;
    }

    public boolean BorrarPeticion(int peticionID) throws Exception {
        boolean fueBorrado = false;
        try {
            fueBorrado = this.delete(peticionID);
        } catch (Exception e) {
            throw (e);
        }
        return fueBorrado;
    }

    //TODO: Checkear si es necesario tener este método
    public PeticionDTO ObtenerPeticion(int peticionID) throws Exception {
        PeticionDTO peticionDTO = new PeticionDTO();
        try {
            peticionDTO = (PeticionDTO) this.search(peticionID);
        } catch (Exception e) {
            throw (e);
        }
        return peticionDTO;
    }
}
