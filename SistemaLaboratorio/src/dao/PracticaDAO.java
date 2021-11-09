package dao;

import dtos.PracticaDTO;
import java.io.FileNotFoundException;

public class PracticaDAO extends utils.GenericDAO {

    public PracticaDAO() throws Exception {
        super(PracticaDTO.class, "./src/goldenfiles/practica/practicas_db");
    }

    public void CrearPractica(PracticaDTO p) throws Exception {
        try {
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
