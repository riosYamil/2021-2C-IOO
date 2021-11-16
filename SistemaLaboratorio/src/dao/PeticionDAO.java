package dao;

import dtos.PeticionDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PeticionDAO extends utils.GenericDAO {

    public PeticionDAO() throws Exception {
        super(PeticionDTO.class, "./src/goldenfiles/peticion/peticion_db");
    }

    public void CrearPeticion(PeticionDTO p) throws Exception {
        try {
            if (!Objects.isNull(ObtenerPeticion(p.id))){
                throw new Exception("Petición ya existente");
            }
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

    public PeticionDTO ObtenerPeticion(int peticionID) throws Exception {
        PeticionDTO peticionDTO = new PeticionDTO();
        try {
            peticionDTO = (PeticionDTO) this.search(peticionID);
        } catch (Exception e) {
            throw (e);
        }
        return peticionDTO;
    }

    public List<PeticionDTO> ObtenerPeticiones() throws Exception {
        List<PeticionDTO> peticiones = new ArrayList<>();
        try {
            peticiones = (List<PeticionDTO>) this.getAll();
        } catch (Exception e) {
            throw (e);
        }

        return peticiones;
    }

    public List<PeticionDTO> ObtenerPeticionesDePaciente(int pacienteID) throws Exception {
        List<PeticionDTO> peticiones = new ArrayList<>();
        try {
            peticiones = (List<PeticionDTO>) this.getAll();
        } catch (Exception e) {
            throw (e);
        }

        List<PeticionDTO> peticionesDePaciente = new ArrayList<PeticionDTO>();

        for (PeticionDTO p : peticiones) {
            if (p.pacienteID == pacienteID) {
                peticionesDePaciente.add(p);
            }
        }

        return peticionesDePaciente;
    }

    public List<PeticionDTO> ObtenerPeticionesDeSurcursal(int sucursalID) throws Exception {
        List<PeticionDTO> peticiones = new ArrayList<PeticionDTO>();
        try {
            peticiones = (List<PeticionDTO>) this.getAll();
        } catch (Exception e) {
            throw (e);
        }

        List<PeticionDTO> peticionesDeSucursal = new ArrayList<PeticionDTO>();

        for (PeticionDTO p : peticiones) {
            if (p.sucursalID == sucursalID) {
                peticionesDeSucursal.add(p);
            }
        }
        return peticiones;
    }
}
