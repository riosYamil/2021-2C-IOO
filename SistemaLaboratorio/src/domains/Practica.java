package domains;

import dtos.PracticaDTO;

public class Practica {
    private Integer id;
    private String nombre;
    private String grupo;
    private int valorCriticoMin;
    private int valorCriticoMax;
    private int valorReservadoMin;
    private int valorReservadoMax;
    private int horasEsperaResultado;
    private enums.EstadoPractica estadoPractica;

    public Practica(PracticaDTO practicaDTO) {
        this.id = practicaDTO.id;
        this.nombre = practicaDTO.nombre;
        this.grupo = practicaDTO.grupo;
        this.valorCriticoMin = practicaDTO.valorCriticoMin;
        this.valorCriticoMax = practicaDTO.valorCriticoMax;
        this.valorReservadoMin = practicaDTO.valorReservadoMin;
        this.valorReservadoMax = practicaDTO.valorReservadoMax;
        this.horasEsperaResultado = practicaDTO.horasEsperaResultado;
        this.estadoPractica = practicaDTO.estadoPractica;
    }

    public boolean EsUnValorReservado(int resultado) {
        return this.valorReservadoMin < resultado && resultado < this.valorReservadoMax;
    }

    public boolean EsUnValorCritico(int resultado) {
        return this.valorCriticoMin < resultado && resultado < this.valorCriticoMax;
    }
}
