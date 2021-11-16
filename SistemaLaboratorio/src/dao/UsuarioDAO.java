package dao;

import dtos.UsuarioDTO;
import enums.Rol;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

public class UsuarioDAO extends utils.GenericDAO {

    public UsuarioDAO() throws Exception {
        super(UsuarioDTO.class, "./src/goldenfiles/usuarios/usuario_db");
    }

    public void CrearUsuario(UsuarioDTO u) throws Exception {
        try {
            if (!Objects.isNull(ObtenerUsuario(u.id))){
                throw new Exception("Usuario ya existente");
            }

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

    public UsuarioDTO ObtenerUsuario(int usuarioID) throws FileNotFoundException {

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        try {
            usuarioDTO = (UsuarioDTO) this.search(usuarioID);
        } catch (Exception e) {
            throw (e);
        }
        return usuarioDTO;
    }

    public UsuarioDTO BuscarUnLaboratista() throws Exception {
        List<UsuarioDTO> usuarioDTOs;
        try {
            usuarioDTOs = (List<UsuarioDTO>) this.getAll();
        } catch (Exception e) {
            throw (e);
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        for (UsuarioDTO u : usuarioDTOs) {
            if (u.rol == Rol.Laboratista) {
                usuarioDTO = u;
                break;
            }
        }
        return usuarioDTO;
    }
}
