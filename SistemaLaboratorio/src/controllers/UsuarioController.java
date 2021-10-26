package controllers;

import domains.Administrador;
import domains.Laboratista;
import domains.Recepcion;
import dtos.UsuarioDTO;

public class UsuarioController {

    public Laboratista AltaLaboratista(UsuarioDTO usuarioDTO) {
        Laboratista l = new Laboratista(usuarioDTO);
        dao.UsuarioDAO.InsertarUsuario(l.toUsuarioDTO());
        return l;
    }

    public Recepcion AltaRecepción(UsuarioDTO usuarioDTO) {
        Recepcion r = new Recepcion(usuarioDTO);
        dao.UsuarioDAO.InsertarUsuario(r.toUsuarioDTO());
        return r;
    }

    public Administrador AltaAdministrador(UsuarioDTO usuarioDTO) {
        Administrador a = new Administrador(usuarioDTO);
        dao.UsuarioDAO.InsertarUsuario(a.toUsuarioDTO());
        return a;
    }

    public void BajaUsuario(int usuarioID) {
        dao.UsuarioDAO.BorrarUsuario(usuarioID);
    }

    public void ModificarUsuario(UsuarioDTO usuarioDTO) {
        dao.UsuarioDAO.ActualizarUsuario(usuarioDTO);
    }

    public UsuarioDTO ObtenerUsuario(int usuarioID) {
        return dao.UsuarioDAO.ObtenerUsuario(usuarioID);
    }
}
