package domains;

import dtos.SucursalDTO;

public class Sucursal {
    private Integer id;
    private int numero;
    private String direccion;
    private Usuario responsableTecnico;

    public Sucursal(SucursalDTO sucursalDTO) {
        this.id = sucursalDTO.id;
        this.numero = sucursalDTO.numero;
        this.direccion = sucursalDTO.direccion;

        Usuario u = new Usuario(sucursalDTO.responsableTecnico);
        this.responsableTecnico = u;
    }

    public SucursalDTO ToSucursalDTO() {
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.id = this.id;
        sucursalDTO.numero = this.numero;
        sucursalDTO.direccion = this.direccion;
        sucursalDTO.responsableTecnico = this.responsableTecnico.ToUsuarioDTO();
        return sucursalDTO;
    }

    public Integer ObtenerSucursalID(){
        return this.id;
    }
}
