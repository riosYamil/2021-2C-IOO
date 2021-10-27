package domains;

import dtos.UsuarioDTO;

public class Recepcion extends Usuario {
    public Recepcion(UsuarioDTO usuario) {
        super(usuario);
        usuario.rol = enums.rol.Recepcion;
    }

    public UsuarioDTO toUsuarioDTO() {
        return toUsuarioDTO();
    }
}
