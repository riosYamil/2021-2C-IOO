package domains;

import dtos.UsuarioDTO;
import enums.Rol;

public class Administrador extends Usuario {
    public Administrador(UsuarioDTO usuario) {
        super(usuario);
        usuario.rol = Rol.Administrador;
    }

    public UsuarioDTO ToUsuarioDTO() {
        return ToUsuarioDTO();
    }

    //TODO: Implementar
    @Override
    public void trabajar(){
        return;
    }
}
