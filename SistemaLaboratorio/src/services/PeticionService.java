package services;

import controllers.PeticionController;
import controllers.PracticaController;
import domains.Practica;
import dtos.PeticionDTO;
import dtos.PracticaAsociadaDTO;
import dtos.PracticaDTO;
import enums.EstadoPeticion;
import enums.EstadoResultadoPractica;

import java.util.List;
import java.util.Objects;

public class PeticionService {

    public EstadoPeticion DeterminarEstado(PeticionDTO peticionDTO) {

        boolean practicaPendiente = true;
        boolean practicaFinalizada = true;
        boolean practicaReservada = false;

        EstadoPeticion resultado = EstadoPeticion.Activa;

        for (PracticaAsociadaDTO pa : peticionDTO.practicasAsociadas) {

            PracticaController practicaController = PracticaController.getInstance();
            try {
                PracticaDTO practicaDTO = practicaController.ObtenerPractica(pa.practicaID);
                Practica practica = new Practica(practicaDTO);

                if (!Objects.isNull(pa.resultado)) {
                    pa.resultadoPractica = EstadoResultadoPractica.Normal;

                    if (practica.EsUnValorCritico(pa.resultado)) {
                        pa.resultadoPractica = EstadoResultadoPractica.Critico;
                    }
                    if (practica.EsUnValorReservado(pa.resultado)) {
                        pa.resultadoPractica = EstadoResultadoPractica.Reservado;
                    }
                } else {
                    pa.resultadoPractica = EstadoResultadoPractica.Pendiente;
                }
            } catch (Exception e) {

            }
            practicaPendiente = practicaPendiente && (pa.resultadoPractica.equals(EstadoResultadoPractica.Pendiente));
            practicaFinalizada = practicaFinalizada && (pa.resultadoPractica.equals(EstadoResultadoPractica.Critico) || pa.resultadoPractica.equals(EstadoResultadoPractica.Normal));
            practicaReservada = practicaReservada || (pa.resultadoPractica.equals(EstadoResultadoPractica.Reservado));
        }

        if (practicaPendiente) {
            resultado = EstadoPeticion.Activa;
        }

        if (practicaFinalizada) {
            resultado = EstadoPeticion.Finalizada;
        }

        if (practicaReservada) {
            resultado = EstadoPeticion.RetirarPorSucursal;
        }

        return resultado;

    }

    public boolean ExistePracticaAsociadaAAlgunaPeticion(int practicaID) {
        boolean result = false;
        PeticionController peticionController = PeticionController.getInstance();
        List<PeticionDTO> peticiones = peticionController.ObtenerTodasLasPeticiones();

        for (PeticionDTO peticion : peticiones) {
            for (PracticaAsociadaDTO practicaAsociadaDTO : peticion.practicasAsociadas) {
                if (practicaID == practicaAsociadaDTO.practicaID) {
                    result = true;
                    break;
                }
            }

            if (result) {
                break;
            }
        }

        return result;
    }
}
