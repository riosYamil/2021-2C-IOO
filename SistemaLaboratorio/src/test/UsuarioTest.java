package test;

import controllers.UsuarioController;
import domains.Usuario;
import dtos.PacienteDTO;
import dtos.UsuarioDTO;
import enums.Rol;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UsuarioTest {

    @Test
    public void AltaUsuario() {
        UsuarioController usuarioController = new UsuarioController();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340794;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "pass";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "37340794";
        usuarioDTO.fechaDeNacimiento = new Date();
        usuarioDTO.rol = Rol.Laboratista;
        usuarioController.AltaUsuario(usuarioDTO);

        Usuario u = new Usuario(usuarioDTO);
        assertFalse(u.esAdministrador());
        assertFalse(u.esRecepcionista());
        assertTrue(u.esLaboratista());
    }

    @Test
    public void BajaUsuario() {
        UsuarioController usuarioController = new UsuarioController();

        UsuarioDTO usuarioDTO = usuarioController.ObtenerUsuario(37340794);
        usuarioController.BajaUsuario(usuarioDTO);
    }

    @Test
    public void ModificarUsuario() {
        UsuarioController usuarioController = new UsuarioController();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340794;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "pass";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "37340794";
        usuarioDTO.fechaDeNacimiento = new Date();
        usuarioDTO.rol = Rol.Laboratista;
        usuarioController.AltaUsuario(usuarioDTO);


        usuarioDTO.nombre = "YAMIL";
        usuarioDTO.domicilio = "CALLE VERDADERA 1234";
        assertTrue(usuarioController.ModificarUsuario(usuarioDTO));

    }
}
