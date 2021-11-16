package dao;

import dtos.PacienteDTO;

import java.io.FileNotFoundException;
import java.util.Objects;

public class PacienteDAO extends utils.GenericDAO {

    public PacienteDAO() throws Exception {
        super(PacienteDTO.class, "./src/goldenfiles/pacientes/pacientes_db");
    }

    public void CrearPaciente(PacienteDTO p) throws Exception {
        try {
            if (!Objects.isNull(this.search(p.id))){
                throw new Exception("Paciente ya existente");
            }
            this.save(p);
        } catch (Exception e) {
            throw (e);
        }
    }

    public boolean ActualizarPaciente(PacienteDTO p) throws Exception {
        boolean fueActualizado = false;
        try {
            fueActualizado = this.update(p);
        } catch (Exception e) {
            throw (e);
        }

        return fueActualizado;
    }

    public boolean BorrarPaciente(int pacienteID) throws Exception {
        boolean fueBorrado = false;
        try {
            fueBorrado = this.delete(pacienteID);
        } catch (Exception e) {
            throw (e);
        }
        return fueBorrado;
    }

    public PacienteDTO ObtenerPaciente(int pacienteID) throws FileNotFoundException {
        PacienteDTO pacienteDTO = new PacienteDTO();
        try {
            pacienteDTO = (PacienteDTO) this.search(pacienteID);
        } catch (Exception e) {
            throw (e);
        }
        return pacienteDTO;
    }
}
