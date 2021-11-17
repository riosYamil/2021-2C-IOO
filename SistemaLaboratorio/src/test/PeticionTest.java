package test;

import controllers.*;
import dtos.*;
import enums.EstadoPaciente;
import enums.EstadoPeticion;
import enums.EstadoPractica;
import enums.EstadoResultadoPractica;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class PeticionTest {
    @Test
    public void AltaPeticion() {

        PeticionController peticionController = PeticionController.getInstance();
        PracticaController practicaController = PracticaController.getInstance();
        SucursalController sucursalController = SucursalController.getInstance();
        UsuarioController usuarioController = UsuarioController.getInstance();
        PacienteController pacienteController = PacienteController.getInstance();

        PracticaDTO practicaDTO = new PracticaDTO();
        practicaDTO.nombre = "pcr";
        practicaDTO.grupo = "covid19";
        practicaDTO.valorCriticoMin = 1;
        practicaDTO.valorCriticoMax = 1;
        practicaDTO.valorReservadoMin = 1;
        practicaDTO.valorReservadoMax = 1;
        practicaDTO.horasEsperaResultado = 48;
        practicaDTO.estadoPractica = EstadoPractica.Habilitado;
        try {
            practicaDTO = practicaController.AltaPractica(practicaDTO);
            assertNotNull(practicaDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

        PacienteDTO pacienteDTO = new PacienteDTO();
        try {
            pacienteDTO.id = 37340794;
            pacienteDTO.dni = "37340794";
            pacienteDTO.nombre = "GABRIEL";
            pacienteDTO.domicilio = "CALLE FALSA 1234";
            pacienteDTO.edad = 27;
            pacienteDTO.estado = EstadoPaciente.Activo;
            pacienteDTO.mail = "gabriel.rios.93@gmail.com";
            pacienteDTO.sexo = "Masculino";

            PacienteDTO paciente = pacienteController.AltaPaciente(pacienteDTO);
            assertNotNull(paciente);
        } catch (Exception e){
            e.printStackTrace();
        }

        PeticionDTO peticionDTO = new PeticionDTO();
        peticionDTO.pacienteID = pacienteDTO.id;
        peticionDTO.obraSocial = "OSDE";
        peticionDTO.fechaDeCarga = new Date();
        peticionDTO.fechaDeEntrega = new Date();

        PracticaAsociadaDTO practicaAsociadaDTO = new PracticaAsociadaDTO();
        practicaAsociadaDTO.practicaID = practicaDTO.id;
        practicaAsociadaDTO.resultadoPractica = EstadoResultadoPractica.Pendiente;
        practicaAsociadaDTO.resultado = 0;

        peticionDTO.practicasAsociadas = new ArrayList<PracticaAsociadaDTO>();
        peticionDTO.practicasAsociadas.add(practicaAsociadaDTO);
        peticionDTO.estadoPeticion = EstadoPeticion.Activa;
        peticionDTO.sucursalID = sucursalDTO.id;
        try {
            peticionController.AltaPeticion(peticionDTO);
            assertTrue(peticionController.BajaPeticion(peticionDTO.id));
            assertTrue(practicaController.BajaPractica(practicaDTO.id));
            assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
            assertTrue(sucursalController.BajaSucursal(sucursalDTO.id));
            assertTrue(pacienteController.BajaPaciente(pacienteDTO.id));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void BajaPeticion() {

        PeticionController peticionController = PeticionController.getInstance();
        UsuarioController usuarioController = UsuarioController.getInstance();
        SucursalController sucursalController = SucursalController.getInstance();
        PacienteController pacienteController = PacienteController.getInstance();

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

        PacienteDTO pacienteDTO = new PacienteDTO();
        try {
            pacienteDTO.id = 37340794;
            pacienteDTO.dni = "37340794";
            pacienteDTO.nombre = "GABRIEL";
            pacienteDTO.domicilio = "CALLE FALSA 1234";
            pacienteDTO.edad = 27;
            pacienteDTO.estado = EstadoPaciente.Activo;
            pacienteDTO.mail = "gabriel.rios.93@gmail.com";
            pacienteDTO.sexo = "Masculino";

            PacienteDTO paciente = pacienteController.AltaPaciente(pacienteDTO);
            assertNotNull(paciente);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PeticionDTO peticionDTO = new PeticionDTO();
        peticionDTO.pacienteID = pacienteDTO.id;
        peticionDTO.obraSocial = "OSDE";
        peticionDTO.fechaDeCarga = new Date();
        peticionDTO.fechaDeEntrega = new Date();
        peticionDTO.estadoPeticion = EstadoPeticion.Activa;
        peticionDTO.sucursalID = sucursalDTO.id;

        try {
            peticionDTO = peticionController.AltaPeticion(peticionDTO);
            assertNotNull(peticionDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PacienteDTO pacienteDTOParaTest = new PacienteDTO();
        try {
            //ID inexistente
            assertFalse(peticionController.BajaPeticion(123456));
        } catch (Exception e) {
            assertEquals("La petición no existe", e.getMessage());
        }

        try {
            assertTrue(peticionController.BajaPeticion(peticionDTO.id));
            assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
            assertTrue(sucursalController.BajaSucursal(sucursalDTO.id));
            assertTrue(pacienteController.BajaPaciente(pacienteDTO.id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ModificarPeticion() {

        PeticionController peticionController = PeticionController.getInstance();
        SucursalController sucursalController = SucursalController.getInstance();
        UsuarioController usuarioController = UsuarioController.getInstance();
        PacienteController pacienteController = PacienteController.getInstance();

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.id = 37340001;
        usuarioDTO.nombre = "GABRIEL";
        usuarioDTO.email = "GYRB@mail.com";
        usuarioDTO.password = "pass";
        usuarioDTO.nombreCompleto = "GABRIEL RIOS";
        usuarioDTO.domicilio = "CALLE FALSA 1234";
        usuarioDTO.dni = "37340001";
        usuarioDTO.fechaDeNacimiento = new Date();

        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.numero = 12345;
        sucursalDTO.direccion = "Calle Falsa 1234";
        sucursalDTO.responsableTecnicoDNI = usuarioDTO.id;

        try {
            usuarioDTO = usuarioController.AltaUsuario(usuarioDTO);
            sucursalDTO = sucursalController.AltaSucursal(sucursalDTO);
            assertNotNull(sucursalDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.id = 37340794;
        pacienteDTO.dni = "37340794";
        pacienteDTO.nombre = "GABRIEL";
        pacienteDTO.domicilio = "CALLE FALSA 1234";
        pacienteDTO.edad = 27;
        pacienteDTO.estado = EstadoPaciente.Activo;
        pacienteDTO.mail = "gabriel.rios.93@gmail.com";
        pacienteDTO.sexo = "Masculino";
        try {
            pacienteDTO = pacienteController.AltaPaciente(pacienteDTO);
            assertNotNull(pacienteDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PeticionDTO peticionDTO = new PeticionDTO();
        peticionDTO.pacienteID = 37340794;
        peticionDTO.obraSocial = "OSDE";
        peticionDTO.fechaDeCarga = new Date();
        peticionDTO.fechaDeEntrega = new Date();
        peticionDTO.estadoPeticion = EstadoPeticion.Activa;
        peticionDTO.sucursalID = sucursalDTO.id;

        try {
            peticionDTO = peticionController.AltaPeticion(peticionDTO);
            peticionDTO = peticionController.ObtenerPeticion(peticionDTO.id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(0, peticionDTO.practicasAsociadas.size());

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

        PracticaAsociadaDTO practicaAsociadaDTO = new PracticaAsociadaDTO();
        practicaAsociadaDTO.practicaID = practicaDTO.id;
        practicaAsociadaDTO.resultadoPractica = EstadoResultadoPractica.Pendiente;
        practicaAsociadaDTO.resultado = 0;

        peticionDTO.practicasAsociadas = new ArrayList<PracticaAsociadaDTO>();
        peticionDTO.practicasAsociadas.add(practicaAsociadaDTO);

        try {
            assertTrue(peticionController.ModificarPeticion(peticionDTO));
            peticionDTO = peticionController.ObtenerPeticion(peticionDTO.id);
            assertEquals(1, peticionDTO.practicasAsociadas.size());
            assertTrue(peticionController.BajaPeticion(peticionDTO.id));
            assertTrue(pacienteController.BajaPaciente(pacienteDTO.id));
            assertTrue(sucursalController.BajaSucursal(sucursalDTO.id));
            assertTrue(usuarioController.BajaUsuario(usuarioDTO.id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
