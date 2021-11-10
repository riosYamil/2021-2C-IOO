package dtos;

public class SucursalDTO {
    public int id;
    public int numero;
    public String direccion;
    public UsuarioDTO responsableTecnico;

    @Override
    public boolean equals(Object obj) {
        SucursalDTO c = (SucursalDTO) obj;
        return this.id == c.id;
    }

}
