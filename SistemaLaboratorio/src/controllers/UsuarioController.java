package controllers;

import dao.UsuarioDAO;
import dtos.UsuarioDTO;
import enums.Rol;

public class UsuarioController {

    public UsuarioDTO AltaUsuario(UsuarioDTO u) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.CrearUsuario(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public UsuarioDTO AltaLaboratista(UsuarioDTO u) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.CrearUsuario(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public UsuarioDTO AltaRecepcion(UsuarioDTO u) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.CrearUsuario(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public UsuarioDTO AltaAdministrador(UsuarioDTO u) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.CrearUsuario(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public boolean BajaUsuario(UsuarioDTO u) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean fueBorrado = usuarioDAO.BorrarUsuario(u.id);

            if (!fueBorrado) {
                //Do something
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean ModificarUsuario(UsuarioDTO u) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean fueActualizado = usuarioDAO.ActualizarUsuario(u);
            if (!fueActualizado) {
                //Do something
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public UsuarioDTO ObtenerUsuario(Integer id) {
        UsuarioDTO u = new UsuarioDTO();
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            u = usuarioDAO.ObtenerUsuario(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    //TODO: Codear este método
    public UsuarioDTO BuscarUnLaboratista() {
        UsuarioDTO u = new UsuarioDTO();
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            u = usuarioDAO.BuscarUnLaboratista();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }
}
