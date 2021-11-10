package test;

import controllers.SucursalController;
import domains.PracticaAsociada;
import dtos.*;
import enums.EstadoPeticion;
import enums.EstadoPractica;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class SucursalTest {

    @Test
    public void AltaSucursal() {

        SucursalController sucursalController = SucursalController.getInstance();

        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.peticiones = new ArrayList<PeticionDTO>();
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
        sucursalDTO.peticiones = new ArrayList<PeticionDTO>();
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

        SucursalDTO sucursalDTOExpected = new SucursalDTO();

        //ID inexistente
        sucursalDTOExpected.id = 123456;
        assertFalse(sucursalController.BajaSucursal(sucursalDTOExpected));

        //ID existente
        sucursalDTOExpected.id = 1;
        assertTrue(sucursalController.BajaSucursal(sucursalDTOExpected));
    }

    @Test
    public void ObtenerSucursal() {
        SucursalController sucursalController = SucursalController.getInstance();

        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.peticiones = new ArrayList<PeticionDTO>();
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
        sucursal = sucursalController.ObtenerSucursal(123456789);
        assertNull(sucursal);

        //ID existente
        sucursal = sucursalController.ObtenerSucursal(1);
        assertNotNull(sucursal);
        assertTrue(sucursalController.BajaSucursal(sucursal));
    }

    @Test
    public void ModificarSucursal() {
        SucursalController sucursalController = SucursalController.getInstance();

        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.peticiones = new ArrayList<PeticionDTO>();
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

        //Creo una práctica
        PracticaDTO practicaDTO = new PracticaDTO();
        practicaDTO.id = 2020;
        practicaDTO.nombre = "pcr";
        practicaDTO.grupo = "covid19";
        practicaDTO.valorCriticoMin = 1;
        practicaDTO.valorCriticoMax = 1;
        practicaDTO.valorReservadoMin = 1;
        practicaDTO.valorReservadoMax = 1;
        practicaDTO.horasEsperaResultado = 48;
        practicaDTO.estadoPractica = EstadoPractica.Habilitado;
        PracticaAsociada practicaAsociada = new PracticaAsociada(practicaDTO);

        //Creo una petición
        PeticionDTO peticionDTO = new PeticionDTO();
        peticionDTO.id = 1001;
        peticionDTO.paciente = new PacienteDTO();
        peticionDTO.obraSocial = "OSDE";
        peticionDTO.fechaDeCarga = new Date();
        peticionDTO.fechaDeEntrega = new Date();
        peticionDTO.estadoPeticion = EstadoPeticion.Activa;
        peticionDTO.sucursalID = sucursal.id;
        peticionDTO.practicasAsociadas = new ArrayList<PracticaAsociada>();
        peticionDTO.practicasAsociadas.add(practicaAsociada);
        sucursal.peticiones.add(peticionDTO);

        assertTrue(sucursalController.ModificarSucursal(sucursal));

    }

}
