package dtos;

import enums.EstadoPaciente;

public class PacienteDTO {
    public Integer id;
    public String dni;
    public String nombre;
    public String domicilio;
    public String mail;
    public String sexo;
    public int edad;
    public EstadoPaciente estado;

    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        PacienteDTO other = (PacienteDTO) obj;
        return this.dni.equals(other.dni);
    }
}

