package domains;

import dtos.SucursalDTO;
import dtos.UsuarioDTO;

import java.util.List;

public class Sucursal {
    private int sucursalID;
    private int numero;
    private String direccion;
    private Usuario responsableTecnico;
    private List<Peticion> peticiones;

    public Sucursal(SucursalDTO sucursalDTO) {
        this.sucursalID = sucursalDTO.sucursalID;
        this.numero = sucursalDTO.numero;
        this.direccion = sucursalDTO.direccion;
        this.responsableTecnico = sucursalDTO.responsableTecnico;
        this.peticiones = sucursalDTO.peticiones;
    }

    public SucursalDTO toSucursalDTO() {
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.sucursalID = this.sucursalID;
        sucursalDTO.numero = this.numero;
        sucursalDTO.direccion = this.direccion;
        sucursalDTO.responsableTecnico = this.responsableTecnico;
        sucursalDTO.peticiones = this.peticiones;
        return sucursalDTO;
    }
}
