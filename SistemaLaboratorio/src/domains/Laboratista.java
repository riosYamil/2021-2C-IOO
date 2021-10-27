package domains;

import dtos.UsuarioDTO;

public class Laboratista extends Usuario {
    public Laboratista(UsuarioDTO usuario) {
        super(usuario);
        usuario.rol = enums.rol.Laboratista;
    }

    public UsuarioDTO toUsuarioDTO() {
        return toUsuarioDTO();
    }
}
