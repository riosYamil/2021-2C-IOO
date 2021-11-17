package controllers;

import dao.UsuarioDAO;
import dtos.UsuarioDTO;
import enums.Rol;

import java.util.Objects;

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

    public UsuarioDTO AltaUsuario(UsuarioDTO u) throws Exception {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            if (Objects.isNull(u.dni)){
                throw new Exception("El campo DNI es mandatorio");
            }

            u.id = Integer.parseInt(u.dni);
            usuarioDAO.CrearUsuario(u);
        } catch (Exception e) {
            throw e;
        }
        return u;
    }

    public UsuarioDTO AltaLaboratista(UsuarioDTO u) throws Exception {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            u.rol = Rol.Laboratista;
            u.id = Integer.parseInt(u.dni);
            usuarioDAO.CrearUsuario(u);
        } catch (Exception e) {
            throw e;
        }
        return u;
    }

    public UsuarioDTO AltaRecepcion(UsuarioDTO u) throws Exception {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            u.rol = Rol.Recepcion;
            u.id = Integer.parseInt(u.dni);
            usuarioDAO.CrearUsuario(u);
        } catch (Exception e) {
            throw e;
        }
        return u;
    }

    public UsuarioDTO AltaAdministrador(UsuarioDTO u) throws Exception {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            u.rol = Rol.Administrador;
            u.id = Integer.parseInt(u.dni);
            usuarioDAO.CrearUsuario(u);
        } catch (Exception e) {
            throw e;
        }
        return u;
    }

    public boolean BajaUsuario(int usuarioID) throws Exception {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            //Valida que exista el usuario
            UsuarioDTO usuarioDTO = ObtenerUsuario(usuarioID);

            boolean fueBorrado = usuarioDAO.BorrarUsuario(usuarioID);
            if (!fueBorrado) {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    public boolean ModificarUsuario(UsuarioDTO u) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean fueActualizado = usuarioDAO.ActualizarUsuario(u);
            if (!fueActualizado) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public UsuarioDTO ObtenerUsuario(int usuarioID) throws Exception {
        UsuarioDTO u = new UsuarioDTO();
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            u = usuarioDAO.ObtenerUsuario(usuarioID);
            if (Objects.isNull(u)) {
                throw new Exception("El usuario no existe");
            }
        } catch (Exception e) {
            throw e;
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

    public boolean Autenticador(int id, String password) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        try {
            usuarioDTO = ObtenerUsuario(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarioDTO.id == id && usuarioDTO.password.equals(password);
    }
}
