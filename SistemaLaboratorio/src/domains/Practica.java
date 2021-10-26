package domains;

import enums.EstadoPractica;

public class Practica {
    private int codigo;
    private String nombre;
    private String grupo;
    private int valorCriticoMin;
    private int valorCriticoMax;
    private int valorReservadoMin;
    private int valorReservadoMax;
    private int horasEsperaResultado;
    private enums.EstadoPractica estadoPractica;

    public Practica() {

    }

    public Practica(String nombre, String grupo, int valorCriticoMin, int valorCriticoMax, int valorReservadoMin, int valorReservadoMax, int horasEsperaResultado) {
        this.codigo = 2021;
        this.nombre = nombre;
        this.grupo = grupo;
        this.valorCriticoMin = valorCriticoMin;
        this.valorCriticoMax = valorCriticoMax;
        this.valorReservadoMin = valorReservadoMin;
        this.valorReservadoMax = valorReservadoMax;
        this.horasEsperaResultado = horasEsperaResultado;
        this.estadoPractica = EstadoPractica.Habilitado;
    }
}
