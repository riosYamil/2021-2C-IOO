package domains;

import enums.EstadoResultadoPractica;

public class PracticaAsociada {
    private Practica practica;
    private EstadoResultadoPractica resultadoPractica;
    private int resultado;

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
