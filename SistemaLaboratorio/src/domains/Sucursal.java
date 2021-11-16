package domains;

import dtos.SucursalDTO;

public class Sucursal {
    private Integer id;
    private int numero;
    private String direccion;
    private Integer responsableTecnico;

    public Sucursal(SucursalDTO sucursalDTO) {
        this.id = sucursalDTO.id;
        this.numero = sucursalDTO.numero;
        this.direccion = sucursalDTO.direccion;
        this.responsableTecnico = sucursalDTO.responsableTecnicoDNI;
    }

    public SucursalDTO ToSucursalDTO() {
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.id = this.id;
        sucursalDTO.numero = this.numero;
        sucursalDTO.direccion = this.direccion;
        sucursalDTO.responsableTecnicoDNI = this.responsableTecnico;
        return sucursalDTO;
    }

    public Integer ObtenerSucursalID(){
        return this.id;
    }
}
