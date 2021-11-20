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

public class PracticaTest {

    @Test
    public void AltaPractica() {
        PracticaController practicaController = PracticaController.getInstance();

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
        try {
            PracticaDTO practica = practicaController.AltaPractica(practicaDTO);
            assertNotNull(practica);
            practicaController.BajaPractica(practica.id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void BajaPractica() {
        PracticaController practicaController = PracticaController.getInstance();

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

        PracticaDTO practicaDTOParaTest = new PracticaDTO();
        try {
            //ID inexistente
            practicaDTOParaTest.id = 123456;
            assertFalse(practicaController.BajaPractica(practicaDTOParaTest.id));
        } catch (Exception e) {
            assertEquals("La practica no existe", e.getMessage());
        }

        try {
            practicaDTO = practicaController.AltaPractica(practicaDTO);
            assertNotNull(practicaDTO);

            //ID existente
            practicaDTOParaTest.id = practicaDTO.id;
            assertTrue(practicaController.BajaPractica(practicaDTOParaTest.id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void BajaPracticaAsociadaAPeticion() {
        PracticaController practicaController = PracticaController.getInstance();
        UsuarioController usuarioController = UsuarioController.getInstance();
        SucursalController sucursalController = SucursalController.getInstance();
        PacienteController pacienteController = PacienteController.getInstance();
        PeticionController peticionController = PeticionController.getInstance();

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
        } catch (Exception e) {
            e.printStackTrace();
        }

        SucursalDTO sucursalDTO = new SucursalDTO();
        try {
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

        PracticaDTO practicaDTO = new PracticaDTO();
        try {
            practicaDTO.id = 2020;
            practicaDTO.nombre = "pcr";
            practicaDTO.grupo = "covid19";
            practicaDTO.valorCriticoMin = 1;
            practicaDTO.valorCriticoMax = 1;
            practicaDTO.valorReservadoMin = 1;
            practicaDTO.valorReservadoMax = 1;
            practicaDTO.horasEsperaResultado = 48;
            practicaDTO.estadoPractica = EstadoPractica.Habilitado;

            practicaDTO = practicaController.AltaPractica(practicaDTO);
            assertNotNull(practicaDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PeticionDTO peticionDTO = new PeticionDTO();
        PracticaAsociadaDTO practicaAsociadaDTO = new PracticaAsociadaDTO();
        try {

            peticionDTO.pacienteID = pacienteDTO.id;
            peticionDTO.obraSocial = "OSDE";
            peticionDTO.fechaDeCarga = new Date();
            peticionDTO.fechaDeEntrega = new Date();

            practicaAsociadaDTO.practicaID = practicaDTO.id;
            practicaAsociadaDTO.resultadoPractica = EstadoResultadoPractica.Pendiente;
            practicaAsociadaDTO.resultado = 0;

            peticionDTO.practicasAsociadas = new ArrayList<PracticaAsociadaDTO>();
            peticionDTO.practicasAsociadas.add(practicaAsociadaDTO);
            peticionDTO.estadoPeticion = EstadoPeticion.Activa;
            peticionDTO.sucursalID = sucursalDTO.id;
            peticionController.AltaPeticion(peticionDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            assertTrue(practicaController.BajaPractica(practicaDTO.id));
            practicaDTO = practicaController.ObtenerPractica(practicaDTO.id);
            assertNotNull(practicaDTO);
            assertEquals(EstadoPractica.Inhabilidado, practicaDTO.estadoPractica);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            peticionController.BajaPeticion(peticionDTO.id);
            pacienteController.BajaPaciente(pacienteDTO.id);
            practicaController.BajaPractica(practicaDTO.id);
            sucursalController.BajaSucursal(sucursalDTO.id);
            usuarioController.BajaUsuario(usuarioDTO.id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ModificarPractica() {

        PracticaController practicaController = PracticaController.getInstance();

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

            practicaDTO.nombre = "asd";
            practicaDTO.grupo = "abc";
            assertTrue(practicaController.ModificarPractica(practicaDTO));

            PracticaDTO practica = practicaController.ObtenerPractica(practicaDTO.id);
            assertEquals("asd", practica.nombre);
            assertEquals("abc", practica.grupo);

            assertTrue(practicaController.BajaPractica(practica.id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ObtenerPractica() {
        PracticaController practicaController = PracticaController.getInstance();

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

        try {
            //ID inexistente
            assertNull(practicaController.ObtenerPractica(123456789));
        } catch (Exception e) {
            assertEquals("La practica no existe", e.getMessage());
        }

        try {
            practicaDTO = practicaController.AltaPractica(practicaDTO);
            assertNotNull(practicaDTO);

            //ID existente
            assertNotNull(practicaController.ObtenerPractica(practicaDTO.id));

            assertTrue(practicaController.BajaPractica(practicaDTO.id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
