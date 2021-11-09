package domains;

import dtos.PacienteDTO;
import enums.EstadoPeticion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Peticion {
    private Integer id;
    private PacienteDTO paciente;
    private String obraSocial;
    private Date fechaDeCarga;
    private Date fechaDeEntrega;
    private List<PracticaAsociada> practicasAsociadas;
    private EstadoPeticion estadoPeticion;
    private int sucursalID;

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
	
	public static void ModificarPeticion(Peticion peticion) {
        //TODO: Hacerlo via DAO
    }

}
