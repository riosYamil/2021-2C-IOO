package dtos;

import domains.Peticion;
import domains.Usuario;

import java.util.List;

public class SucursalDTO {
    public int id;
    public int numero;
    public String direccion;
    public Usuario responsableTecnico;
    public List<Peticion> peticiones;

    //TODO: Desarrollar
    public void AltaPeticion(UsuarioDTO usuario, Peticion peticion){
        return;
    }

    //TODO: Desarrollar
    public Peticion DameUnaPeticionActiva() {
        Peticion p = new Peticion();
        return p;
    }

    //TODO: Desarrollar
    public int ObtenerSucursalID(int numero) {
        return 1;
    }

}
