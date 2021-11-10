package dtos;

import java.util.List;

public class SucursalDTO {
    public int id;
    public int numero;
    public String direccion;
    public UsuarioDTO responsableTecnico;
    public List<PeticionDTO> peticiones;

    //TODO: Desarrollar
    public void AltaPeticion(UsuarioDTO usuario, PeticionDTO peticion){
        return;
    }

    //TODO: Desarrollar
    public PeticionDTO DameUnaPeticionActiva() {
        PeticionDTO p = new PeticionDTO();
        return p;
    }

    //TODO: Desarrollar
    public int ObtenerSucursalID(int numero) {
        return 1;
    }


    @Override
    public boolean equals(Object obj) {
        SucursalDTO c = (SucursalDTO) obj;
        return this.id == c.id;
    }

}
