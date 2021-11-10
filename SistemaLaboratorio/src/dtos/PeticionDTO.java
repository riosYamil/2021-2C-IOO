package dtos;

import domains.PracticaAsociada;
import enums.EstadoPeticion;

import java.util.ArrayList;
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

    public boolean estaActiva() {
        return estadoPeticion.equals(EstadoPeticion.Activa);
    }

    public boolean estaFinalizadas() {
        return estadoPeticion.equals(EstadoPeticion.Finalizada);
    }

    public PacienteDTO obtenerPaciente() {
        return this.paciente;
    }

    public List<PracticaAsociada> obtenerPracticasFinalizadas() {
        List<PracticaAsociada> pas = new ArrayList<PracticaAsociada>();

        for (PracticaAsociada pa : this.practicasAsociadas) {
            if (!pa.tieneResultadoPendiente()) {
                pas.add(pa);
            }
        }
        return pas;
    }

    public List<PracticaAsociada> obtenerPracticasPendientes() {
        List<PracticaAsociada> pas = new ArrayList<PracticaAsociada>();

        for (PracticaAsociada pa : this.practicasAsociadas) {
            if (pa.tieneResultadoPendiente()) {
                pas.add(pa);
            }
        }
        return pas;
    }

	public boolean EsPeticionParaElPaciente(PacienteDTO pacienteDTO) {
		return this.paciente.equals(pacienteDTO);
	}

	public void CambiarEstado(EstadoPeticion estadoPeticion) {
        this.estadoPeticion = estadoPeticion;
    }
	
	public static void ModificarPeticion(PeticionDTO peticion) {
        //TODO: Hacerlo via DAO
    }

}
