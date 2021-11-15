package dtos;

public class PracticaDTO {
    public int id;
    public int peticionID;
    public String nombre;
    public String grupo;
    public int valorCriticoMin;
    public int valorCriticoMax;
    public int valorReservadoMin;
    public int valorReservadoMax;
    public int horasEsperaResultado;
    public enums.EstadoPractica estadoPractica;

    @Override
    public boolean equals(Object obj) {
        PracticaDTO p = (PracticaDTO) obj;
        return this.id == p.id;
    }
}
