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

        try {
            usuarioController.AltaLaboratista(usuarioDTO);

            Usuario u = new Usuario(usuarioDTO);
            assertFalse(u.EsAdministrador());
            assertFalse(u.EsRecepcionista());
            assertTrue(u.EsLaboratista());

            assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
        } catch (Exception e) {
            e.printStackTrace();
        }


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

        try {
            usuarioController.AltaRecepcion(usuarioDTO);

            Usuario u = new Usuario(usuarioDTO);
            assertFalse(u.EsAdministrador());
            assertTrue(u.EsRecepcionista());
            assertFalse(u.EsLaboratista());

            assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
        } catch (Exception e) {
            e.printStackTrace();
        }

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
        try {
            usuarioController.AltaAdministrador(usuarioDTO);

            Usuario u = new Usuario(usuarioDTO);
            assertTrue(u.EsAdministrador());
            assertFalse(u.EsRecepcionista());
            assertFalse(u.EsLaboratista());

            assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void BajaUsuario() {
        UsuarioController usuarioController = UsuarioController.getInstance();
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        try {
            usuarioDTO.nombre = "GABRIEL";
            usuarioDTO.email = "GYRB@mail.com";
            usuarioDTO.password = "pass";
            usuarioDTO.nombreCompleto = "GABRIEL RIOS";
            usuarioDTO.domicilio = "CALLE FALSA 1234";
            usuarioDTO.dni = "37340003";
            usuarioDTO.fechaDeNacimiento = new Date();
            usuarioController.AltaUsuario(usuarioDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //ID inexistente
            assertFalse(usuarioController.BajaUsuario(1));
        } catch (Exception e) {
            assertEquals("El usuario no existe", e.getMessage());
        }

        try {
            //ID existente
            assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
        } catch (Exception e){
            e.printStackTrace();
        }
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

        try {
            usuarioController.AltaAdministrador(usuarioDTO);

            usuarioDTO.nombre = "YAMIL";
            usuarioDTO.domicilio = "CALLE VERDADERA 1234";
            assertTrue(usuarioController.ModificarUsuario(usuarioDTO));

            Usuario u = new Usuario(usuarioDTO);
            assertTrue(u.EsAdministrador());
            assertFalse(u.EsRecepcionista());
            assertFalse(u.EsLaboratista());

            assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void ObtenerUsuario() throws Exception {
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

        try {
            //ID inexistente
            assertNull(usuarioController.ObtenerUsuario(123456789));
        } catch (Exception e) {
            assertEquals("El usuario no existe", e.getMessage());
        }
        //ID existente
        assertNotNull(usuarioController.ObtenerUsuario(usuario.id));

        assertTrue(usuarioController.BajaUsuario(usuario.id));
    }

    @Test
    public void AutentificarUsuario() throws Exception {
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

        assertFalse(usuarioController.Autenticador(usuarioDTO.id, "contrase??a_invalida"));
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

        try {
            usuarioDTO = usuarioController.AltaLaboratista(usuarioDTO);
            assertNotNull(usuarioDTO);

            UsuarioDTO laboratista = usuarioController.BuscarUnLaboratista();
            assertEquals(usuarioDTO, laboratista);
            assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
