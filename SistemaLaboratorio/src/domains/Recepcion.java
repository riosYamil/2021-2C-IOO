package domains;

import dtos.UsuarioDTO;
import enums.Rol;

public class Recepcion extends Usuario {
    public Recepcion(UsuarioDTO usuario) {
        super(usuario);
        usuario.rol = Rol.Recepcion;
    }

    public UsuarioDTO toUsuarioDTO() {
        return toUsuarioDTO();
    }

    @Override
    public void trabajar(){
        return;
    }
}
