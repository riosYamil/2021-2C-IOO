package domains;

import enums.EstadoResultadoPractica;

public class PracticaAsociada {
    private Practica practica;
    private EstadoResultadoPractica resultadoPractica;
    private int resultado;

    public static void modificarResultadoPractica(EstadoResultadoPractica rp) {

    }

    public boolean tieneValoresReservados() {
        return true;
    }

    public boolean tieneValoresCriticos() {
        return true;
    }

}
