package test;

import controllers.SucursalController;
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

        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.numero = 12345;
        sucursalDTO.direccion = "Calle Falsa 1234";

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340001;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "pass";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "37340001";
        usuarioDTO.fechaDeNacimiento = new Date();

        SucursalDTO sucursal = sucursalController.AltaSucursal(sucursalDTO, usuarioDTO);
        assertNotNull(sucursal);

        assertTrue(sucursalController.BajaSucursal(sucursal));
    }

    @Test
    public void BajaSucursal() {
        SucursalController sucursalController = SucursalController.getInstance();

        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.numero = 12345;
        sucursalDTO.direccion = "Calle Falsa 1234";

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340001;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "pass";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "37340001";
        usuarioDTO.fechaDeNacimiento = new Date();

        SucursalDTO sucursal = sucursalController.AltaSucursal(sucursalDTO, usuarioDTO);
        assertNotNull(sucursal);

        SucursalDTO sucursalDTOParaTest = new SucursalDTO();

        //ID inexistente
        sucursalDTOParaTest.id = 123456;
        assertFalse(sucursalController.BajaSucursal(sucursalDTOParaTest));

        //ID existente
        sucursalDTOParaTest.id = sucursal.id;
        assertTrue(sucursalController.BajaSucursal(sucursalDTOParaTest));
    }

    @Test
    public void ModificarSucursal() {
        SucursalController sucursalController = SucursalController.getInstance();

        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.numero = 12345;
        sucursalDTO.direccion = "Calle Falsa 1234";

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340001;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "pass";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "37340001";
        usuarioDTO.fechaDeNacimiento = new Date();

        SucursalDTO sucursal = sucursalController.AltaSucursal(sucursalDTO, usuarioDTO);
        assertNotNull(sucursal);

        usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340002;
        usuarioDTO.nombre = "MAR";
        usuarioDTO.email = "mas@mail.com";
        usuarioDTO.password = "1234";
        usuarioDTO.nombreCompleto = "MAR BENITEZ";
        usuarioDTO.domicilio = "CALLE FALSA 1111";
        usuarioDTO.dni = "37340002";
        usuarioDTO.fechaDeNacimiento = new Date();

        sucursal.responsableTecnico = usuarioDTO;
        assertTrue(sucursalController.ModificarSucursal(sucursal));
        assertTrue(sucursalController.BajaSucursal(sucursal));
    }


    @Test
    public void ObtenerSucursal() {
        SucursalController sucursalController = SucursalController.getInstance();

        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.numero = 12345;
        sucursalDTO.direccion = "Calle Falsa 1234";

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340001;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "pass";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "37340001";
        usuarioDTO.fechaDeNacimiento = new Date();

        SucursalDTO sucursal = sucursalController.AltaSucursal(sucursalDTO, usuarioDTO);
        assertNotNull(sucursal);

        //ID inexistente
        assertNull(sucursalController.ObtenerSucursal(123456789));
        //ID existente
        assertNotNull(sucursalController.ObtenerSucursal(sucursal.id));

        assertTrue(sucursalController.BajaSucursal(sucursal));
    }

    @Test
    public void ObtenerSucursalesPorUsuario() {
        SucursalController sucursalController = SucursalController.getInstance();

        //Sucursal 1
        SucursalDTO sucursalDTO1 = new SucursalDTO();
        sucursalDTO1.numero = 1;
        sucursalDTO1.direccion = "Calle Falsa 1";

        UsuarioDTO usuarioDTO1 = new UsuarioDTO();
        usuarioDTO1.dni = "37340001";
        sucursalDTO1 = sucursalController.AltaSucursal(sucursalDTO1, usuarioDTO1);
        assertNotNull(sucursalDTO1);

        //Sucursal 2
        SucursalDTO sucursalDTO2 = new SucursalDTO();
        sucursalDTO2.numero = 2;
        sucursalDTO2.direccion = "Calle Falsa 2";

        UsuarioDTO usuarioDTO2 = new UsuarioDTO();
        usuarioDTO2.dni = "37340002";
        sucursalDTO2 = sucursalController.AltaSucursal(sucursalDTO2, usuarioDTO2);
        assertNotNull(sucursalDTO2);

        //Sucursal 3
        SucursalDTO sucursalDTO3 = new SucursalDTO();
        sucursalDTO3.numero = 3;
        sucursalDTO3.direccion = "Calle Falsa 2";

        UsuarioDTO usuarioDTO3 = new UsuarioDTO();
        usuarioDTO3.dni = "37340003";
        sucursalDTO3 = sucursalController.AltaSucursal(sucursalDTO3, usuarioDTO3);
        assertNotNull(sucursalDTO3);

        //Sucursal 4
        SucursalDTO sucursalDTO4 = new SucursalDTO();
        sucursalDTO4.numero = 4;
        sucursalDTO4.direccion = "Calle Falsa 2";

        UsuarioDTO usuarioDTO4 = new UsuarioDTO();
        usuarioDTO4.dni = "37340004";
        sucursalDTO4 = sucursalController.AltaSucursal(sucursalDTO4, usuarioDTO4);
        assertNotNull(sucursalDTO4);

        //Sucursal 5
        SucursalDTO sucursalDTO5 = new SucursalDTO();
        sucursalDTO5.numero = 5;
        sucursalDTO5.direccion = "Calle Falsa 2";

        UsuarioDTO usuarioDTO5 = new UsuarioDTO();
        usuarioDTO5.dni = "37340001";
        sucursalDTO5 = sucursalController.AltaSucursal(sucursalDTO5, usuarioDTO5);
        assertNotNull(sucursalDTO5);

        List<SucursalDTO> sucursalDTOs = sucursalController.ObtenerSurcursalesPorUsuario(usuarioDTO5);
        assertEquals(2, sucursalDTOs.size());

        assertTrue(sucursalController.BajaSucursal(sucursalDTO1));
        assertTrue(sucursalController.BajaSucursal(sucursalDTO2));
        assertTrue(sucursalController.BajaSucursal(sucursalDTO3));
        assertTrue(sucursalController.BajaSucursal(sucursalDTO4));
        assertTrue(sucursalController.BajaSucursal(sucursalDTO5));
    }
}
