package dao;

import domains.Administrador;
import domains.Laboratista;
import domains.Recepcion;
import domains.Usuario;
import dtos.UsuarioDTO;

public class UsuarioDAO extends utils.GenericDAO {

    public UsuarioDAO(String file) throws Exception {
        super(Usuario.class, "./src/goldenfiles/usuarios/dni_" + file);
    }

    public void CrearUsuario(UsuarioDTO u) throws Exception {
        try {
            this.save(u);
        } catch (Exception e) {
            throw (e);
        }
        return;
    }

    public void CrearLaboratista(Laboratista l) throws Exception {
        try {
            this.save(l);
        } catch (Exception e) {
            throw (e);
        }
        return;
    }

    public void CrearRecepcion(Recepcion r) throws Exception {
        try {
            this.save(r);
        } catch (Exception e) {
            throw (e);
        }
        return;
    }

    public void CrearAdministrador(Administrador a) throws Exception {
        try {
            this.save(a);
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
        UsuarioDTO usuarioDTO;
        try {
            usuarioDTO = (UsuarioDTO) this.search(usuarioID);
        } catch (Exception e) {
            throw (e);
        }
        return usuarioDTO;
    }
}
