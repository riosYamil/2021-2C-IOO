package domains;

import dtos.PracticaDTO;
import enums.EstadoResultadoPractica;

public class PracticaAsociada {
    private Practica practica;
    private EstadoResultadoPractica resultadoPractica;
    private int resultado;

    public PracticaAsociada(PracticaDTO p){
        this.practica = new Practica(p);
        this.resultadoPractica = EstadoResultadoPractica.Pendiente;
        this.resultado = 0;
    }
    public void modificarResultadoPractica(EstadoResultadoPractica rp) {
        this.resultadoPractica = rp;
    }

    public boolean tieneValoresReservados() {
        return practica.esUnValorReservado(resultado);
    }

    public boolean tieneValoresCriticos() {
        return practica.esUnValorCritico(resultado);
    }

    public boolean tieneResultadoPendiente(){
        return  resultadoPractica.equals(EstadoResultadoPractica.Pendiente);
    }
}
