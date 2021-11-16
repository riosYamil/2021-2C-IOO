package dao;

import dtos.PracticaDTO;
import java.io.FileNotFoundException;
import java.util.Objects;

public class PracticaDAO extends utils.GenericDAO {

    public PracticaDAO() throws Exception {
        super(PracticaDTO.class, "./src/goldenfiles/practica/practicas_db");
    }

    public void CrearPractica(PracticaDTO p) throws Exception {
        try {
            if (!Objects.isNull(ObtenerPractica(p.id))){
                throw new Exception("Practica ya existente");
            }
            this.save(p);
        } catch (Exception e) {
            throw (e);
        }
    }

    public boolean ActualizarPractica(PracticaDTO p) throws Exception {

        boolean fueActualizado = false;
        try {
            fueActualizado = this.update(p);
        } catch (Exception e) {
            throw (e);
        }

        return fueActualizado;
    }

    public boolean BorrarPractica(int practicaID) throws Exception {

        boolean fueBorrado = false;
        try {
            fueBorrado = this.delete(practicaID);
        } catch (Exception e) {
            throw (e);
        }
        return fueBorrado;

    }

    public PracticaDTO ObtenerPractica(int practicaID) throws FileNotFoundException {
        PracticaDTO practicaDTO = new PracticaDTO();
        try {
            practicaDTO = (PracticaDTO) this.search(practicaID);
        } catch (Exception e) {
            throw (e);
        }
        return practicaDTO;
    }
}
