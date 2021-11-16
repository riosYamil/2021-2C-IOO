package domains;

import controllers.PacienteController;
import dtos.PacienteDTO;
import dtos.PeticionDTO;
import dtos.PracticaAsociadaDTO;
import enums.EstadoPeticion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Peticion {
    private int pacienteID;
    private String obraSocial;
    private Date fechaDeCarga;
    private Date fechaDeEntrega;
    private List<PracticaAsociadaDTO> practicasAsociadas;
    private enums.EstadoPeticion estadoPeticion;
    private int sucursalID;

    public Peticion(PeticionDTO p) {
        this.pacienteID = p.id;
        this.obraSocial = p.obraSocial;
        this.fechaDeCarga = p.fechaDeCarga;
        this.fechaDeEntrega = p.fechaDeEntrega;
        this.practicasAsociadas = p.practicasAsociadas;
        this.estadoPeticion = p.estadoPeticion;
        this.sucursalID = p.sucursalID;
    }

    public int ObtenerSucursalID() {
        return this.sucursalID;
    }

    public PacienteDTO ObtenerPaciente() throws Exception {
        PacienteDTO p = new PacienteDTO();
        PacienteController pacienteController = PacienteController.getInstance();
        try {
            p = pacienteController.ObtenerPaciente(this.pacienteID);
        } catch (Exception e) {
            throw e;
        }
        return p;
    }

    public boolean EstaActiva() {
        return estadoPeticion.equals(EstadoPeticion.Activa);
    }

    public boolean EstaFinalizadas() {
        return estadoPeticion.equals(EstadoPeticion.Finalizada);
    }

    public List<PracticaAsociada> ObtenerPracticasFinalizadas() {
        List<PracticaAsociada> pas = new ArrayList<PracticaAsociada>();

        for (PracticaAsociadaDTO paDTO : this.practicasAsociadas) {
            PracticaAsociada pa = new PracticaAsociada(paDTO);
            if (!pa.TieneResultadoPendiente()) {
                pas.add(pa);
            }
        }
        return pas;
    }

    public List<PracticaAsociada> ObtenerPracticasPendientes() {
        List<PracticaAsociada> pas = new ArrayList<PracticaAsociada>();

        for (PracticaAsociadaDTO paDTO : this.practicasAsociadas) {

            PracticaAsociada pa = new PracticaAsociada(paDTO);
            if (pa.TieneResultadoPendiente()) {
                pas.add(pa);
            }
        }
        return pas;
    }

}
