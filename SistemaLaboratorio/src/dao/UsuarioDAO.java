package dao;

import dtos.UsuarioDTO;

public class UsuarioDAO extends utils.GenericDAO {

    public UsuarioDAO() throws Exception {
        super(UsuarioDTO.class, "./src/goldenfiles/usuarios/usuario_db");
    }

    public void CrearUsuario(UsuarioDTO u) throws Exception {
        try {
            this.save(u);
        } catch (Exception e) {
            throw (e);
        }
        return;
    }

    public boolean ActualizarUsuario(UsuarioDTO u) throws Exception {
        boolean fueActualizado = false;
        try {
            fueActualizado = this.update(u);
        } catch (Exception e) {
            throw (e);
        }

        return fueActualizado;
    }

    public boolean BorrarUsuario(int usuarioID) throws Exception {
        boolean fueBorrado = false;
        try {
            fueBorrado = this.delete(usuarioID);
        } catch (Exception e) {
            throw (e);
        }
        return fueBorrado;
    }

    public UsuarioDTO ObtenerUsuario(int usuarioID) throws Exception {

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        try {
            usuarioDTO = (UsuarioDTO) this.search(usuarioID);
        } catch (Exception e) {
            throw (e);
        }
        return usuarioDTO;
    }

    //TODO: Codear este método
    public UsuarioDTO BuscarUnLaboratista() throws Exception {
        UsuarioDTO usuarioDTO;
        try {
            usuarioDTO = (UsuarioDTO) this.search(12345);
        } catch (Exception e) {
            throw (e);
        }
        return usuarioDTO;
    }
}
