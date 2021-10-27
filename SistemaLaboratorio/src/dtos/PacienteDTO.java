package dtos;

import domains.Peticion;
import enums.EstadoPaciente;

import java.util.List;

public class PacienteDTO {
    public Integer id;
    public String dni;
    public String nombre;
    public String apellido;
    public String mail;
    public String sexo;
    public int edad;
    public List<Peticion> peticiones_completas;
    public List<Peticion> peticiones_pendientes;
    public EstadoPaciente estado;

    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        PacienteDTO other = (PacienteDTO) obj;

        if ((!this.dni.equals(other.dni)) && (!this.dni.equals(other.dni))) {
            return false;
        }

        return true;
    }
}

