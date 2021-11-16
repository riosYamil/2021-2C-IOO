package services;

import dtos.PeticionDTO;
import dtos.PracticaAsociadaDTO;
import enums.EstadoPeticion;
import enums.EstadoResultadoPractica;

public class PeticionService {

    public EstadoPeticion DeterminarEstado(PeticionDTO peticionDTO) {

        boolean practicaPendiente = false;
        boolean practicaReservada = false;

        EstadoPeticion resultado = EstadoPeticion.Activa;

        for (PracticaAsociadaDTO pa : peticionDTO.practicasAsociadas) {
            practicaPendiente = practicaPendiente && (pa.resultadoPractica.equals(EstadoResultadoPractica.Pendiente));
            practicaReservada = practicaReservada || (pa.resultadoPractica.equals(EstadoResultadoPractica.Reservado));
        }

        if (practicaPendiente) {
            resultado = EstadoPeticion.Activa;
        }

        if (practicaReservada) {
            resultado = EstadoPeticion.RetirarPorSucursal;
        }

        return resultado;
    }
}
