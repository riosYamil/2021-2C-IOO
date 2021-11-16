package dtos;

public class SucursalDTO {
    public int id;
    public int numero;
    public String direccion;
    public int responsableTecnicoDNI;

    @Override
    public boolean equals(Object obj) {
        SucursalDTO s = (SucursalDTO) obj;
        return this.id == s.id;
    }
}
