package test;

import controllers.SucursalController;
import controllers.UsuarioController;
import dtos.SucursalDTO;
import dtos.UsuarioDTO;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class SucursalTest {

    @Test
    public void AltaSucursal() {

        SucursalController sucursalController = SucursalController.getInstance();
        UsuarioController usuarioController = UsuarioController.getInstance();

        SucursalDTO sucursalDTO = new SucursalDTO();
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        try {
            usuarioDTO.nombre = "GABRIEL";
            usuarioDTO.email = "GYRB@mail.com";
            usuarioDTO.password = "pass";
            usuarioDTO.nombreCompleto = "GABRIEL RIOS";
            usuarioDTO.domicilio = "CALLE FALSA 1234";
            usuarioDTO.dni = "37340001";
            usuarioDTO.fechaDeNacimiento = new Date();
            usuarioDTO = usuarioController.AltaUsuario(usuarioDTO);
            assertNotNull(usuarioDTO);


            sucursalDTO.numero = 12345;
            sucursalDTO.direccion = "Calle Falsa 1234";
            sucursalDTO.responsableTecnicoDNI = usuarioDTO.id;
            sucursalDTO = sucursalController.AltaSucursal(sucursalDTO);
            assertNotNull(sucursalDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            assertTrue(sucursalController.BajaSucursal(sucursalDTO.id));
            assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void BajaSucursal() {
        SucursalController sucursalController = SucursalController.getInstance();
        UsuarioController usuarioController = UsuarioController.getInstance();

        SucursalDTO sucursalDTO = new SucursalDTO();
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        try {
            usuarioDTO.nombre = "GABRIEL";
            usuarioDTO.email = "GYRB@mail.com";
            usuarioDTO.password = "pass";
            usuarioDTO.nombreCompleto = "GABRIEL RIOS";
            usuarioDTO.domicilio = "CALLE FALSA 1234";
            usuarioDTO.dni = "37340001";
            usuarioDTO.fechaDeNacimiento = new Date();
            usuarioDTO = usuarioController.AltaUsuario(usuarioDTO);
            assertNotNull(usuarioDTO);


            sucursalDTO.numero = 12345;
            sucursalDTO.direccion = "Calle Falsa 1234";
            sucursalDTO.responsableTecnicoDNI = usuarioDTO.id;
            sucursalDTO = sucursalController.AltaSucursal(sucursalDTO);
            assertNotNull(sucursalDTO);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //ID inexistente
            assertFalse(sucursalController.BajaSucursal(123456));
        } catch (Exception e) {
            assertEquals("La sucursal no existe", e.getMessage());
        }
        try {
            //ID existente
            assertTrue(sucursalController.BajaSucursal(sucursalDTO.id));
            assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ModificarSucursal() {
        SucursalController sucursalController = SucursalController.getInstance();
        UsuarioController usuarioController = UsuarioController.getInstance();


        UsuarioDTO usuarioDTO = new UsuarioDTO();
        UsuarioDTO usuarioDTONuevo = new UsuarioDTO();
        SucursalDTO sucursalDTO = new SucursalDTO();
        try {
            usuarioDTO.id = 37340001;
            usuarioDTO.nombre = "GABRIEL";
            usuarioDTO.email = "GYRB@mail.com";
            usuarioDTO.password = "pass";
            usuarioDTO.nombreCompleto = "GABRIEL RIOS";
            usuarioDTO.domicilio = "CALLE FALSA 1234";
            usuarioDTO.dni = "37340001";
            usuarioDTO.fechaDeNacimiento = new Date();
            usuarioDTO = usuarioController.AltaUsuario(usuarioDTO);
            assertNotNull(usuarioDTO);


            sucursalDTO.numero = 12345;
            sucursalDTO.direccion = "Calle Falsa 1234";
            sucursalDTO.responsableTecnicoDNI = usuarioDTO.id;
            sucursalDTO = sucursalController.AltaSucursal(sucursalDTO);
            assertNotNull(sucursalDTO);

            usuarioDTONuevo = new UsuarioDTO();
            usuarioDTONuevo.id = 37340002;
            usuarioDTONuevo.nombre = "MAR";
            usuarioDTONuevo.email = "mas@mail.com";
            usuarioDTONuevo.password = "1234";
            usuarioDTONuevo.nombreCompleto = "MAR BENITEZ";
            usuarioDTONuevo.domicilio = "CALLE FALSA 1111";
            usuarioDTONuevo.dni = "37340002";
            usuarioDTONuevo.fechaDeNacimiento = new Date();
            usuarioDTONuevo = usuarioController.AltaUsuario(usuarioDTONuevo);
            assertNotNull(usuarioDTONuevo);

            sucursalDTO.responsableTecnicoDNI = usuarioDTONuevo.id;
            assertTrue(sucursalController.ModificarSucursal(sucursalDTO));
            assertTrue(sucursalController.BajaSucursal(sucursalDTO.id));
            assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
            assertTrue(usuarioController.BajaUsuario(usuarioDTONuevo.id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ObtenerSucursal() {
        SucursalController sucursalController = SucursalController.getInstance();
        UsuarioController usuarioController = UsuarioController.getInstance();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        SucursalDTO sucursalDTO = new SucursalDTO();
        try {
            usuarioDTO.id = 37340001;
            usuarioDTO.nombre = "GABRIEL";
            usuarioDTO.email = "GYRB@mail.com";
            usuarioDTO.password = "pass";
            usuarioDTO.nombreCompleto = "GABRIEL RIOS";
            usuarioDTO.domicilio = "CALLE FALSA 1234";
            usuarioDTO.dni = "37340001";
            usuarioDTO.fechaDeNacimiento = new Date();
            usuarioDTO = usuarioController.AltaUsuario(usuarioDTO);
            assertNotNull(usuarioDTO);

            sucursalDTO.numero = 12345;
            sucursalDTO.direccion = "Calle Falsa 1234";
            sucursalDTO.responsableTecnicoDNI = usuarioDTO.id;
            sucursalDTO = sucursalController.AltaSucursal(sucursalDTO);
            assertNotNull(sucursalDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //ID inexistente
            assertNull(sucursalController.ObtenerSucursal(123456789));
        } catch (Exception e) {
            assertEquals("La sucursal no existe", e.getMessage());
        }

        try {
            //ID existente
            assertNotNull(sucursalController.ObtenerSucursal(sucursalDTO.id));

            assertTrue(sucursalController.BajaSucursal(sucursalDTO.id));
            assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ObtenerSucursalesPorUsuario() {
        SucursalController sucursalController = SucursalController.getInstance();
        UsuarioController usuarioController = UsuarioController.getInstance();

        SucursalDTO sucursalDTO1 = new SucursalDTO();
        SucursalDTO sucursalDTO2 = new SucursalDTO();
        SucursalDTO sucursalDTO3 = new SucursalDTO();
        SucursalDTO sucursalDTO4 = new SucursalDTO();
        SucursalDTO sucursalDTO5 = new SucursalDTO();

        UsuarioDTO usuarioDTO1 = new UsuarioDTO();
        UsuarioDTO usuarioDTO2 = new UsuarioDTO();
        UsuarioDTO usuarioDTO3 = new UsuarioDTO();
        UsuarioDTO usuarioDTO4 = new UsuarioDTO();
        UsuarioDTO usuarioDTO5 = new UsuarioDTO();

        try {
            //Sucursal 1
            sucursalDTO1.numero = 1;
            sucursalDTO1.direccion = "Calle Falsa 1";

            usuarioDTO1.dni = "37340001";

            usuarioDTO1 = usuarioController.AltaUsuario(usuarioDTO1);
            assertNotNull(usuarioDTO1);

            sucursalDTO1.responsableTecnicoDNI = usuarioDTO1.id;
            sucursalDTO1 = sucursalController.AltaSucursal(sucursalDTO1);
            assertNotNull(sucursalDTO1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //Sucursal 2
            sucursalDTO2.numero = 2;
            sucursalDTO2.direccion = "Calle Falsa 2";

            usuarioDTO2.dni = "37340002";

            usuarioDTO2 = usuarioController.AltaUsuario(usuarioDTO2);
            assertNotNull(usuarioDTO2);

            sucursalDTO2.responsableTecnicoDNI = usuarioDTO2.id;
            sucursalDTO2 = sucursalController.AltaSucursal(sucursalDTO2);
            assertNotNull(sucursalDTO2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //Sucursal 3
            sucursalDTO3.numero = 3;
            sucursalDTO3.direccion = "Calle Falsa 2";

            usuarioDTO3.dni = "37340003";

            usuarioDTO3 = usuarioController.AltaUsuario(usuarioDTO3);
            assertNotNull(usuarioDTO3);

            sucursalDTO3.responsableTecnicoDNI = usuarioDTO3.id;
            sucursalDTO3 = sucursalController.AltaSucursal(sucursalDTO3);
            assertNotNull(sucursalDTO3);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            //Sucursal 4
            sucursalDTO4.numero = 4;
            sucursalDTO4.direccion = "Calle Falsa 2";

            usuarioDTO4.dni = "37340004";

            usuarioDTO4 = usuarioController.AltaUsuario(usuarioDTO4);
            assertNotNull(usuarioDTO4);

            sucursalDTO4.responsableTecnicoDNI = usuarioDTO4.id;
            sucursalDTO4 = sucursalController.AltaSucursal(sucursalDTO4);
            assertNotNull(sucursalDTO4);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            //Sucursal 5
            sucursalDTO5.responsableTecnicoDNI = usuarioDTO1.id;
            sucursalDTO5 = sucursalController.AltaSucursal(sucursalDTO5);
            assertNotNull(sucursalDTO5);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            List<SucursalDTO> sucursalDTOs = sucursalController.ObtenerSurcursalesPorUsuario(usuarioDTO1);
            assertEquals(2, sucursalDTOs.size());

            assertTrue(sucursalController.BajaSucursal(sucursalDTO1.id));
            assertTrue(sucursalController.BajaSucursal(sucursalDTO2.id));
            assertTrue(sucursalController.BajaSucursal(sucursalDTO3.id));
            assertTrue(sucursalController.BajaSucursal(sucursalDTO4.id));
            assertTrue(sucursalController.BajaSucursal(sucursalDTO5.id));

            assertTrue(usuarioController.BajaUsuario(usuarioDTO1.id));
            assertTrue(usuarioController.BajaUsuario(usuarioDTO2.id));
            assertTrue(usuarioController.BajaUsuario(usuarioDTO3.id));
            assertTrue(usuarioController.BajaUsuario(usuarioDTO4.id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
