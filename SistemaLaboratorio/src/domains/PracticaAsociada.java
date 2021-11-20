package domains;

import controllers.PracticaController;
import dtos.PracticaAsociadaDTO;
import dtos.PracticaDTO;
import enums.EstadoResultadoPractica;

public class PracticaAsociada {
    private int practicaID;
    private EstadoResultadoPractica resultadoPractica;
    private Integer resultado;

    public PracticaAsociada(PracticaAsociadaDTO practicaAsociadaDTO) {
        this.practicaID = practicaAsociadaDTO.practicaID;
        this.resultadoPractica = practicaAsociadaDTO.resultadoPractica;
        this.resultado = practicaAsociadaDTO.resultado;
    }

    public PracticaAsociada(PracticaDTO p){
        this.practicaID = p.id;
        this.resultadoPractica = EstadoResultadoPractica.Pendiente;
        this.resultado = 0;
    }
    public void ModificarResultadoPractica(EstadoResultadoPractica rp) {
        this.resultadoPractica = rp;
    }

    public boolean TieneValoresReservados() {
        PracticaController practicaController = PracticaController.getInstance();
        PracticaDTO practicaDTO = new PracticaDTO();
        try {
            practicaDTO = practicaController.ObtenerPractica(this.practicaID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Practica practica = new Practica(practicaDTO);
        return practica.EsUnValorReservado(resultado);
    }

    public boolean TieneValoresCriticos() {
        PracticaController practicaController = PracticaController.getInstance();
        PracticaDTO practicaDTO = new PracticaDTO();
        try {
            practicaDTO = practicaController.ObtenerPractica(this.practicaID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Practica practica = new Practica(practicaDTO);
        return practica.EsUnValorCritico(resultado);
    }

    public boolean TieneResultadoPendiente(){
        return  resultadoPractica.equals(EstadoResultadoPractica.Pendiente);
    }
}
