package test;

import controllers.UsuarioController;
import domains.Usuario;
import dtos.UsuarioDTO;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class UsuarioTest {

    @Test
    public void AltaUsuarioLaboratista() {
        UsuarioController usuarioController = UsuarioController.getInstance();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340001;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "1";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "1";
        usuarioDTO.fechaDeNacimiento = new Date();
        usuarioController.AltaLaboratista(usuarioDTO);

        Usuario u = new Usuario(usuarioDTO);
        assertFalse(u.EsAdministrador());
        assertFalse(u.EsRecepcionista());
        assertTrue(u.EsLaboratista());

        assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
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
        assertFalse(u.EsAdministrador());
        assertTrue(u.EsRecepcionista());
        assertFalse(u.EsLaboratista());

        assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
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
        assertTrue(u.EsAdministrador());
        assertFalse(u.EsRecepcionista());
        assertFalse(u.EsLaboratista());

        assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
    }

    @Test
    public void BajaUsuario() {
        UsuarioController usuarioController = UsuarioController.getInstance();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340794;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "pass";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "37340003";
        usuarioDTO.fechaDeNacimiento = new Date();
        usuarioController.AltaUsuario(usuarioDTO);

        UsuarioDTO usuarioDTOParaTest = new UsuarioDTO();

        //ID inexistente
        usuarioDTOParaTest.id = 1;
        assertFalse(usuarioController.BajaUsuario(usuarioDTOParaTest.id));

        //ID existente
        usuarioDTOParaTest.id = usuarioDTO.id;
        assertTrue(usuarioController.BajaUsuario(usuarioDTOParaTest.id));
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
        assertTrue(u.EsAdministrador());
        assertFalse(u.EsRecepcionista());
        assertFalse(u.EsLaboratista());

        assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
    }

    @Test
    public void ObtenerUsuario() {
        UsuarioController usuarioController = UsuarioController.getInstance();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340794;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "pass";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "37340003";
        usuarioDTO.fechaDeNacimiento = new Date();
        UsuarioDTO usuario = usuarioController.AltaUsuario(usuarioDTO);
        assertNotNull(usuario);

        //ID inexistente
        assertNull(usuarioController.ObtenerUsuario(123456789));
        //ID existente
        assertNotNull(usuarioController.ObtenerUsuario(usuario.id));

        assertTrue(usuarioController.BajaUsuario(usuario.id));
    }

    @Test
    public void AutentificarUsuario() {
        UsuarioController usuarioController = UsuarioController.getInstance();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340794;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "pass";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "37340003";
        usuarioDTO.fechaDeNacimiento = new Date();
        UsuarioDTO usuario = usuarioController.AltaUsuario(usuarioDTO);
        assertNotNull(usuario);

        assertFalse(usuarioController.Autenticador(usuarioDTO.id, "contraseña_invalida"));
        assertTrue(usuarioController.Autenticador(usuarioDTO.id, "pass"));

        assertTrue(usuarioController.BajaUsuario(usuario.id));
    }

    @Test
    public void BuscarLaboratista() {
        UsuarioController usuarioController = UsuarioController.getInstance();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340794;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "pass";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "37340003";
        usuarioDTO.fechaDeNacimiento = new Date();
        UsuarioDTO usuario = usuarioController.AltaLaboratista(usuarioDTO);
        assertNotNull(usuario);

        UsuarioDTO laboratista = usuarioController.BuscarUnLaboratista();
        assertEquals(usuarioDTO, laboratista);
        assertTrue(usuarioController.BajaUsuario(usuario.id));
    }
}
