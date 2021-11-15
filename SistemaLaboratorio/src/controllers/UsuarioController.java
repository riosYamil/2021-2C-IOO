package controllers;

import dao.UsuarioDAO;
import dtos.UsuarioDTO;
import enums.Rol;

public class UsuarioController {

    static UsuarioController instance = null;

    private UsuarioController() {
    }

    public static UsuarioController getInstance() {
        if (instance == null) {
            instance = new UsuarioController();
        }
        return instance;
    }

    public UsuarioDTO AltaUsuario(UsuarioDTO u) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if(!verificarSiUsuarioExiste(u.id)) {
                usuarioDAO.CrearUsuario(u);
            } else {
                u = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public UsuarioDTO AltaLaboratista(UsuarioDTO u) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            u.rol = Rol.Laboratista;
            usuarioDAO.CrearUsuario(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public UsuarioDTO AltaRecepcion(UsuarioDTO u) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            u.rol = Rol.Recepcion;
            usuarioDAO.CrearUsuario(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public UsuarioDTO AltaAdministrador(UsuarioDTO u) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            u.rol = Rol.Administrador;
            usuarioDAO.CrearUsuario(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public boolean BajaUsuario(int id) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean fueBorrado = usuarioDAO.BorrarUsuario(id);

            if (!fueBorrado) {
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

    public UsuarioDTO ObtenerUsuario(int usuarioID) {
        UsuarioDTO u = new UsuarioDTO();
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            u = usuarioDAO.ObtenerUsuario(usuarioID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

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
    
    public boolean verificarSiUsuarioExiste(int id) {
    	boolean existe = false;
    	UsuarioDTO u = ObtenerUsuario(id);
        if(u != null){
            existe = true;
        }
    	return existe;
    }

    public boolean Autenticador(int id, String password) {
        UsuarioDTO usuarioDTO = ObtenerUsuario(id);
        return usuarioDTO.id == id && usuarioDTO.password.equals(password);
    }
}
