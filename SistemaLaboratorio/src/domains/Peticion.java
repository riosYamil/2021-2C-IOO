package domains;

import dtos.PacienteDTO;
import dtos.PeticionDTO;
import enums.EstadoPeticion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Peticion {
    private PacienteDTO paciente;
    private String obraSocial;
    private Date fechaDeCarga;
    private Date fechaDeEntrega;
    private List<PracticaAsociada> practicasAsociadas;
    private enums.EstadoPeticion estadoPeticion;
    private int sucursalID;

    public int ObtenerSucursalID() {
        return this.sucursalID;
    }

    public boolean EstaActiva() {
        return estadoPeticion.equals(EstadoPeticion.Activa);
    }

    public boolean EstaFinalizadas() {
        return estadoPeticion.equals(EstadoPeticion.Finalizada);
    }

    public PacienteDTO ObtenerPaciente() {
        return this.paciente;
    }

    public List<PracticaAsociada> obtenerPracticasFinalizadas() {
        List<PracticaAsociada> pas = new ArrayList<PracticaAsociada>();

        for (PracticaAsociada pa : this.practicasAsociadas) {
            if (!pa.TieneResultadoPendiente()) {
                pas.add(pa);
            }
        }
        return pas;
    }

    public List<PracticaAsociada> ObtenerPracticasPendientes() {
        List<PracticaAsociada> pas = new ArrayList<PracticaAsociada>();

        for (PracticaAsociada pa : this.practicasAsociadas) {
            if (pa.TieneResultadoPendiente()) {
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
