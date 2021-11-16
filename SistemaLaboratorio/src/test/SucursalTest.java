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

        SucursalDTO sucursal = sucursalController.AltaSucursal(sucursalDTO);
        assertNotNull(sucursal);

        assertTrue(sucursalController.BajaSucursal(sucursal.id));
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

        SucursalDTO sucursal = sucursalController.AltaSucursal(sucursalDTO);
        assertNotNull(sucursal);

        SucursalDTO sucursalDTOParaTest = new SucursalDTO();

        //ID inexistente
        sucursalDTOParaTest.id = 123456;
        assertFalse(sucursalController.BajaSucursal(sucursalDTOParaTest.id));

        //ID existente
        sucursalDTOParaTest.id = sucursal.id;
        assertTrue(sucursalController.BajaSucursal(sucursalDTOParaTest.id));
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

        SucursalDTO sucursal = sucursalController.AltaSucursal(sucursalDTO);
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

        sucursal.responsableTecnicoDNI = 37340002;
        assertTrue(sucursalController.ModificarSucursal(sucursal));
        assertTrue(sucursalController.BajaSucursal(sucursal.id));
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

        SucursalDTO sucursal = sucursalController.AltaSucursal(sucursalDTO);
        assertNotNull(sucursal);

        //ID inexistente
        assertNull(sucursalController.ObtenerSucursal(123456789));
        //ID existente
        assertNotNull(sucursalController.ObtenerSucursal(sucursal.id));

        assertTrue(sucursalController.BajaSucursal(sucursal.id));
    }

    @Test
    public void ObtenerSucursalesPorUsuario() {
        SucursalController sucursalController = SucursalController.getInstance();

        //Sucursal 1
        SucursalDTO sucursalDTO1 = new SucursalDTO();
        sucursalDTO1.numero = 1;
        sucursalDTO1.direccion = "Calle Falsa 1";

        UsuarioDTO usuarioDTO1 = new UsuarioDTO();
        usuarioDTO1.id = 37340001;

        sucursalDTO1.responsableTecnicoDNI = usuarioDTO1.id;
        sucursalDTO1 = sucursalController.AltaSucursal(sucursalDTO1);
        assertNotNull(sucursalDTO1);

        //Sucursal 2
        SucursalDTO sucursalDTO2 = new SucursalDTO();
        sucursalDTO2.numero = 2;
        sucursalDTO2.direccion = "Calle Falsa 2";

        UsuarioDTO usuarioDTO2 = new UsuarioDTO();
        usuarioDTO2.id = 37340002;

        sucursalDTO2.responsableTecnicoDNI = usuarioDTO2.id;
        sucursalDTO2 = sucursalController.AltaSucursal(sucursalDTO2);
        assertNotNull(sucursalDTO2);

        //Sucursal 3
        SucursalDTO sucursalDTO3 = new SucursalDTO();
        sucursalDTO3.numero = 3;
        sucursalDTO3.direccion = "Calle Falsa 2";

        UsuarioDTO usuarioDTO3 = new UsuarioDTO();
        usuarioDTO3.id = 37340003;

        sucursalDTO3.responsableTecnicoDNI = usuarioDTO3.id;
        sucursalDTO3 = sucursalController.AltaSucursal(sucursalDTO3);
        assertNotNull(sucursalDTO3);

        //Sucursal 4
        SucursalDTO sucursalDTO4 = new SucursalDTO();
        sucursalDTO4.numero = 4;
        sucursalDTO4.direccion = "Calle Falsa 2";

        UsuarioDTO usuarioDTO4 = new UsuarioDTO();
        usuarioDTO4.id = 37340004;

        sucursalDTO4.responsableTecnicoDNI = usuarioDTO4.id;
        sucursalDTO4 = sucursalController.AltaSucursal(sucursalDTO4);
        assertNotNull(sucursalDTO4);

        //Sucursal 5
        SucursalDTO sucursalDTO5 = new SucursalDTO();
        sucursalDTO5.numero = 5;
        sucursalDTO5.direccion = "Calle Falsa 2";

        UsuarioDTO usuarioDTO5 = new UsuarioDTO();
        usuarioDTO5.id = 37340001;

        sucursalDTO5.responsableTecnicoDNI = usuarioDTO5.id;
        sucursalDTO5 = sucursalController.AltaSucursal(sucursalDTO5);
        assertNotNull(sucursalDTO5);

        List<SucursalDTO> sucursalDTOs = sucursalController.ObtenerSurcursalesPorUsuario(usuarioDTO5);
        assertEquals(2, sucursalDTOs.size());

        assertTrue(sucursalController.BajaSucursal(sucursalDTO1.id));
        assertTrue(sucursalController.BajaSucursal(sucursalDTO2.id));
        assertTrue(sucursalController.BajaSucursal(sucursalDTO3.id));
        assertTrue(sucursalController.BajaSucursal(sucursalDTO4.id));
        assertTrue(sucursalController.BajaSucursal(sucursalDTO5.id));
    }
}
