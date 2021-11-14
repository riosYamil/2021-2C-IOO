package domains;

import dtos.PracticaAsociadaDTO;
import dtos.PracticaDTO;
import dtos.UsuarioDTO;
import enums.EstadoResultadoPractica;

public class PracticaAsociada {
    private Practica practica;
    private EstadoResultadoPractica resultadoPractica;
    private int resultado;

    public PracticaAsociada(PracticaAsociadaDTO practicaAsociadaDTO) {
        this.practica = new Practica(practicaAsociadaDTO.practicaDTO);
        this.resultadoPractica = practicaAsociadaDTO.resultadoPractica;
        this.resultado = practicaAsociadaDTO.resultado;
    }

    public PracticaAsociada(PracticaDTO p){
        this.practica = new Practica(p);
        this.resultadoPractica = EstadoResultadoPractica.Pendiente;
        this.resultado = 0;
    }
    public void ModificarResultadoPractica(EstadoResultadoPractica rp) {
        this.resultadoPractica = rp;
    }

    public boolean TieneValoresReservados() {
        return practica.EsUnValorReservado(resultado);
    }

    public boolean TieneValoresCriticos() {
        return practica.EsUnValorCritico(resultado);
    }

    public boolean TieneResultadoPendiente(){
        return  resultadoPractica.equals(EstadoResultadoPractica.Pendiente);
    }
}
