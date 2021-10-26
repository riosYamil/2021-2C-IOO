package domains;

import dtos.UsuarioDTO;
import enums.rol;

public class Administrador extends Usuario {
    public Administrador(UsuarioDTO usuario) {
        super(usuario);
        usuario.rol = enums.rol.Administrador;
    }

    public UsuarioDTO toUsuarioDTO(){
        return toUsuarioDTO();
    }
}
