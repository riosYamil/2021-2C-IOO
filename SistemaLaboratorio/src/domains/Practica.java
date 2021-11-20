package domains;

import dtos.PracticaDTO;

import java.util.Objects;

public class Practica {
    private Integer id;
    private String nombre;
    private String grupo;
    private Integer valorCriticoMin;
    private Integer valorCriticoMax;
    private Integer valorReservadoMin;
    private Integer valorReservadoMax;
    private int horasEsperaResultado;
    private enums.EstadoPractica estadoPractica;

    public Practica(PracticaDTO practicaDTO) {
        this.id = practicaDTO.id;
        this.nombre = practicaDTO.nombre;
        this.grupo = practicaDTO.grupo;

        if (!Objects.isNull(practicaDTO.valorCriticoMin)) {
            this.valorCriticoMin = practicaDTO.valorCriticoMin;
        } else {
            this.valorCriticoMin = Integer.MIN_VALUE;
        }

        if (!Objects.isNull(practicaDTO.valorCriticoMax)) {
            this.valorCriticoMax = practicaDTO.valorCriticoMax;
        } else {
            this.valorCriticoMax = Integer.MAX_VALUE;
        }

        if (!Objects.isNull(practicaDTO.valorReservadoMin)) {
            this.valorReservadoMin = practicaDTO.valorReservadoMin;
        } else {
            this.valorReservadoMin = Integer.MIN_VALUE;
        }

        if (!Objects.isNull(practicaDTO.valorReservadoMax)) {
            this.valorReservadoMax = practicaDTO.valorReservadoMax;
        } else {
            this.valorReservadoMax = Integer.MAX_VALUE;

        }
        this.horasEsperaResultado = practicaDTO.horasEsperaResultado;
        this.estadoPractica = practicaDTO.estadoPractica;
    }

    public boolean EsUnValorReservado(Integer resultado) {
        return !Objects.isNull(resultado) && this.valorReservadoMin <= resultado && resultado <= this.valorReservadoMax;
    }

    public boolean EsUnValorCritico(Integer resultado) {
        return !Objects.isNull(resultado) && this.valorCriticoMin <= resultado && resultado <= this.valorCriticoMax;
    }
}
