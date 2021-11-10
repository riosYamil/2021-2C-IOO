package dtos;

import domains.PracticaAsociada;
import enums.EstadoPeticion;

import java.util.Date;
import java.util.List;

public class PeticionDTO {
    public Integer id;
    public PacienteDTO paciente;
    public String obraSocial;
    public Date fechaDeCarga;
    public Date fechaDeEntrega;
    public List<PracticaAsociada> practicasAsociadas;
    public EstadoPeticion estadoPeticion;
    public int sucursalID;

}
