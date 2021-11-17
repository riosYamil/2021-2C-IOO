package test;

import controllers.*;
import dtos.*;
import enums.EstadoPaciente;
import enums.EstadoPeticion;
import enums.EstadoPractica;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ReglasDeNegocioTest {

    @Test
    public void NoSePuedeEliminarPacienteOSucursalConPeticionesFinalizadas() throws Exception {

        PacienteController pacienteController = PacienteController.getInstance();
        PracticaController practicaController = PracticaController.getInstance();
        PeticionController peticionController = PeticionController.getInstance();

        //Damos de alta un usuario
        PacienteDTO paciente = new PacienteDTO();
        paciente.dni = "37340794";
        paciente.nombre = "GABRIEL YAMIL";
        paciente.domicilio = "CALLE FALSA 1234";
        paciente.edad = 27;
        paciente.estado = EstadoPaciente.Activo;
        paciente.mail = "gabriel.rios.93@gmail.com";
        paciente.sexo = "Masculino";

        paciente = pacienteController.AltaPaciente(paciente);
        assertNotNull(paciente);

        //Damos de alta una practica
        PracticaDTO practica = new PracticaDTO();
        practica.nombre = "pcr";
        practica.grupo = "covid19";
        practica.valorCriticoMin = 1;
        practica.valorCriticoMax = 1;
        practica.valorReservadoMin = 1;
        practica.valorReservadoMax = 1;
        practica.horasEsperaResultado = 48;
        practica.estadoPractica = EstadoPractica.Habilitado;

        practica = practicaController.AltaPractica(practica);
        assertNotNull(practica);

        //Creo Usuario y Sucursal para crear la petición
        SucursalController sucursalController = SucursalController.getInstance();
        UsuarioController usuarioController = UsuarioController.getInstance();

        UsuarioDTO usuario = new UsuarioDTO();
        usuario.nombre = "GABRIEL";
        usuario.email = "GYRB@mail.com";
        usuario.password = "pass";
        usuario.nombreCompleto = "GABRIEL RIOS";
        usuario.domicilio = "CALLE FALSA 1234";
        usuario.dni = "37340001";
        usuario.fechaDeNacimiento = new Date();
        usuario = usuarioController.AltaAdministrador(usuario);
        assertNotNull(usuario);

        SucursalDTO sucursal = new SucursalDTO();
        sucursal.numero = 12345;
        sucursal.direccion = "Calle Falsa 1234";
        sucursal.responsableTecnicoDNI = 37340001;
        sucursal = sucursalController.AltaSucursal(sucursal);
        assertNotNull(sucursal);

        //Creo petición asociada al usuario
        PeticionDTO peticion = new PeticionDTO();
        peticion.pacienteID = paciente.id;
        peticion.obraSocial = "OSDE";
        peticion.fechaDeCarga = new Date();
        peticion.fechaDeEntrega = new Date();
        peticion.sucursalID = sucursal.id;

        //Creo practica asociada a petición
        PracticaAsociadaDTO practicaAsociada = new PracticaAsociadaDTO();
        practicaAsociada.practicaID = practica.id;
        peticion.practicasAsociadas = new ArrayList<PracticaAsociadaDTO>();
        peticion.practicasAsociadas.add(practicaAsociada);
        peticion = peticionController.AltaPeticion(peticion);
        assertNotNull(peticion);

        assertEquals(EstadoPeticion.Activa, peticion.estadoPeticion);
        assertEquals(1, peticion.practicasAsociadas.size());

        //modifico petición
        for (PracticaAsociadaDTO pa : peticion.practicasAsociadas) {
            pa.resultado = 1000;
        }
        assertTrue(peticionController.ModificarPeticion(peticion));

        try {
            pacienteController.BajaPaciente(paciente.id);
        } catch (Exception e) {
            assertEquals("El paciente tiene peticiones finalizadas", e.getMessage());
        }

        try {
            sucursalController.BajaSucursal(sucursal.id);

        } catch (Exception e) {
            assertEquals("La sucursal tiene peticiones finalizadas.", e.getMessage());
        }

        try {
            assertTrue(usuarioController.BajaUsuario(usuario.id));
            assertTrue(peticionController.BajaPeticion(peticion.id));
            assertTrue(pacienteController.BajaPaciente(paciente.id));
            assertTrue(sucursalController.BajaSucursal(sucursal.id));
            assertTrue(practicaController.BajaPractica(practica.id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ObtenerPeticionesReservadas() throws Exception {
        PacienteController pacienteController = PacienteController.getInstance();
        PracticaController practicaController = PracticaController.getInstance();
        PeticionController peticionController = PeticionController.getInstance();

        //Damos de alta un usuario
        PacienteDTO paciente = new PacienteDTO();
        paciente.dni = "37340794";
        paciente.nombre = "GABRIEL YAMIL";
        paciente.domicilio = "CALLE FALSA 1234";
        paciente.edad = 27;
        paciente.estado = EstadoPaciente.Activo;
        paciente.mail = "gabriel.rios.93@gmail.com";
        paciente.sexo = "Masculino";

        paciente = pacienteController.AltaPaciente(paciente);
        assertNotNull(paciente);

        //Damos de alta una practica
        PracticaDTO practica = new PracticaDTO();
        practica.nombre = "pcr";
        practica.grupo = "covid19";
        practica.horasEsperaResultado = 48;
        practica.estadoPractica = EstadoPractica.Habilitado;

        practica = practicaController.AltaPractica(practica);
        assertNotNull(practica);

        //Creo Usuario y Sucursal para crear la petición
        SucursalController sucursalController = SucursalController.getInstance();
        UsuarioController usuarioController = UsuarioController.getInstance();

        UsuarioDTO usuario = new UsuarioDTO();
        usuario.nombre = "GABRIEL";
        usuario.email = "GYRB@mail.com";
        usuario.password = "pass";
        usuario.nombreCompleto = "GABRIEL RIOS";
        usuario.domicilio = "CALLE FALSA 1234";
        usuario.dni = "37340001";
        usuario.fechaDeNacimiento = new Date();
        usuario = usuarioController.AltaAdministrador(usuario);
        assertNotNull(usuario);

        SucursalDTO sucursal = new SucursalDTO();
        sucursal.numero = 12345;
        sucursal.direccion = "Calle Falsa 1234";
        sucursal.responsableTecnicoDNI = usuario.id;
        sucursal = sucursalController.AltaSucursal(sucursal);
        assertNotNull(sucursal);

        //Creo petición asociada al usuario
        PeticionDTO peticion = new PeticionDTO();
        peticion.pacienteID = paciente.id;
        peticion.obraSocial = "OSDE";
        peticion.fechaDeCarga = new Date();
        peticion.fechaDeEntrega = new Date();
        peticion.sucursalID = sucursal.id;

        //Creo practica asociada a petición
        PracticaAsociadaDTO practicaAsociadaI = new PracticaAsociadaDTO();
        practicaAsociadaI.practicaID = practica.id;
        PracticaAsociadaDTO practicaAsociadaII = new PracticaAsociadaDTO();
        practicaAsociadaII.practicaID = practica.id;
        PracticaAsociadaDTO practicaAsociadaIII = new PracticaAsociadaDTO();
        practicaAsociadaIII.practicaID = practica.id;
        PracticaAsociadaDTO practicaAsociadaIV = new PracticaAsociadaDTO();
        practicaAsociadaIV.practicaID = practica.id;
        practicaAsociadaIV.resultado = 10;

        peticion.practicasAsociadas = new ArrayList<PracticaAsociadaDTO>();
        peticion.practicasAsociadas.add(practicaAsociadaI);
        peticion.practicasAsociadas.add(practicaAsociadaII);
        peticion.practicasAsociadas.add(practicaAsociadaIII);
        peticion.practicasAsociadas.add(practicaAsociadaIV);


        peticion = peticionController.AltaPeticion(peticion);
        assertNotNull(peticion);

        assertEquals(EstadoPeticion.RetirarPorSucursal, peticion.estadoPeticion);
        assertEquals(4, peticion.practicasAsociadas.size());

        assertEquals(0, peticionController.ObtenerPeticionesCriticas().size());
        assertEquals(0, peticionController.ObtenerPeticionesFinalizadas().size());

        List<PeticionDTO> peticiones = peticionController.ObtenerPeticionesDelPaciente(paciente.id);
        for (PeticionDTO p : peticiones){
            assertEquals(EstadoPeticion.RetirarPorSucursal, p.estadoPeticion);
        }

        try {
            assertTrue(usuarioController.BajaUsuario(usuario.id));
            assertTrue(peticionController.BajaPeticion(peticion.id));
            assertTrue(pacienteController.BajaPaciente(paciente.id));
            assertTrue(sucursalController.BajaSucursal(sucursal.id));
            assertTrue(practicaController.BajaPractica(practica.id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ObtenerPeticionesCriticasDelSistema() throws Exception {
        PeticionController peticionController = PeticionController.getInstance();

        assertEquals(0, peticionController.ObtenerPeticionesCriticas().size());
    }

    @Test
    public void BorrarSucursalYMigrarPeticiones() throws Exception {
        PeticionController peticionController = PeticionController.getInstance();

        assertEquals(0, peticionController.ObtenerPeticionesCriticas().size());
    }
}
