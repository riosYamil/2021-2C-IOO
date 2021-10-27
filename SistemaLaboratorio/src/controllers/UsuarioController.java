package controllers;

import dao.UsuarioDAO;
import domains.Administrador;
import domains.Laboratista;
import domains.Recepcion;
import dtos.UsuarioDTO;

public class UsuarioController {

    public UsuarioDTO AltaUsuario(UsuarioDTO u) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(u.dni);
            usuarioDAO.CrearUsuario(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public UsuarioDTO AltaLaboratista(Laboratista l) {
        UsuarioDTO u = l.toUsuarioDTO();
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(u.dni);
            usuarioDAO.CrearLaboratista(l);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public UsuarioDTO AltaRecepcion(Recepcion r) {
        UsuarioDTO u = r.toUsuarioDTO();
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(u.dni);
            usuarioDAO.CrearRecepcion(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public UsuarioDTO AltaAdministrador(Administrador a) {
        UsuarioDTO u = a.toUsuarioDTO();
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(u.dni);
            usuarioDAO.CrearAdministrador(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public boolean BajaUsuario(UsuarioDTO u) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO(u.dni);
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
            UsuarioDAO usuarioDAO = new UsuarioDAO(u.dni);
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
            UsuarioDAO usuarioDAO = new UsuarioDAO(id.toString());
            u = usuarioDAO.ObtenerUsuario(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }
}
