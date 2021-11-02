package domains;

import dtos.UsuarioDTO;
import enums.Rol;

public class Laboratista extends Usuario {
    public Laboratista(UsuarioDTO usuario) {
        super(usuario);
        usuario.rol = Rol.Laboratista;
    }

    public UsuarioDTO toUsuarioDTO() {
        return toUsuarioDTO();
    }

    @Override
    public void trabajar(){
        return;
    }
}
