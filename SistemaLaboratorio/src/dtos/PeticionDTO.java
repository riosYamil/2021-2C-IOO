package dtos;

import enums.EstadoPeticion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeticionDTO {
    public Integer id;
    public Integer pacienteID;
    public String obraSocial;
    public Date fechaDeCarga;
    public Date fechaDeEntrega;
    public List<PracticaAsociadaDTO> practicasAsociadas;
    public EstadoPeticion estadoPeticion;
    public int sucursalID;

    public PeticionDTO() {
        this.practicasAsociadas = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        PeticionDTO other = (PeticionDTO) obj;
        return this.id.equals(other.id);
    }
}

