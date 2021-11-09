package test;

import controllers.UsuarioController;
import domains.Usuario;
import dtos.UsuarioDTO;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UsuarioTest {

    @Test
    public void AltaUsuarioLaboratista() {
        UsuarioController usuarioController = UsuarioController.getInstance();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340001;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "pass";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "37340001";
        usuarioDTO.fechaDeNacimiento = new Date();
        usuarioController.AltaLaboratista(usuarioDTO);

        Usuario u = new Usuario(usuarioDTO);
        assertFalse(u.esAdministrador());
        assertFalse(u.esRecepcionista());
        assertTrue(u.esLaboratista());
    }

    @Test
    public void AltaUsuarioRecepcion() {
        UsuarioController usuarioController = UsuarioController.getInstance();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340002;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "pass";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "37340002";
        usuarioDTO.fechaDeNacimiento = new Date();
        usuarioController.AltaRecepcion(usuarioDTO);

        Usuario u = new Usuario(usuarioDTO);
        assertFalse(u.esAdministrador());
        assertTrue(u.esRecepcionista());
        assertFalse(u.esLaboratista());
    }

    @Test
    public void AltaUsuarioAdministrador() {
        UsuarioController usuarioController = UsuarioController.getInstance();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340003;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "pass";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "37340003";
        usuarioDTO.fechaDeNacimiento = new Date();
        usuarioController.AltaAdministrador(usuarioDTO);

        Usuario u = new Usuario(usuarioDTO);
        assertTrue(u.esAdministrador());
        assertFalse(u.esRecepcionista());
        assertFalse(u.esLaboratista());
    }

    @Test
    public void BajaUsuario() {
        UsuarioController usuarioController = UsuarioController.getInstance();

        UsuarioDTO usuarioDTO = usuarioController.ObtenerUsuario(37340001);
        usuarioController.BajaUsuario(usuarioDTO);
    }

    @Test
    public void ModificarUsuario() {
        UsuarioController usuarioController = UsuarioController.getInstance();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340794;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "pass";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "37340794";
        usuarioDTO.fechaDeNacimiento = new Date();
        usuarioController.AltaAdministrador(usuarioDTO);

        usuarioDTO.nombre = "YAMIL";
        usuarioDTO.domicilio = "CALLE VERDADERA 1234";
        assertTrue(usuarioController.ModificarUsuario(usuarioDTO));

        Usuario u = new Usuario(usuarioDTO);
        assertTrue(u.esAdministrador());
        assertFalse(u.esRecepcionista());
        assertFalse(u.esLaboratista());
    }
}
