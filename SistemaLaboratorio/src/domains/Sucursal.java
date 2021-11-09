package domains;

import dtos.SucursalDTO;

import java.util.List;

public class Sucursal {
    private Integer id;
    private int numero;
    private String direccion;
    private Usuario responsableTecnico;
    private List<Peticion> peticiones;

    public Sucursal(SucursalDTO sucursalDTO) {
        this.id = sucursalDTO.id;
        this.numero = sucursalDTO.numero;
        this.direccion = sucursalDTO.direccion;

        Usuario u = new Usuario(sucursalDTO.responsableTecnico);
        this.responsableTecnico = u;

        this.peticiones = sucursalDTO.peticiones;
    }

    public SucursalDTO toSucursalDTO() {
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.id = this.id;
        sucursalDTO.numero = this.numero;
        sucursalDTO.direccion = this.direccion;
        sucursalDTO.responsableTecnico = this.responsableTecnico.toUsuarioDTO();
        sucursalDTO.peticiones = this.peticiones;
        return sucursalDTO;
    }

    public void altaPeticion(){
        //TODO: Do something
        return;
    }

    public void dameUnaPeticionActiva(){
        //TODO: Do something
        return;
    }

    public void obtenerSucursalID(int sucursalID){
        //TODO: Do something
        return;
    }
}
