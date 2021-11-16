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

public class ReglasDeNegocioTest {

    @Test
    public void NoSePuedeEliminarPacienteOSucursalConPeticionesFinalizadas() {

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
        sucursal = sucursalController.AltaSucursal(sucursal, usuario);
        assertNotNull(sucursal);

        //Creo petición asociada al usuario
        PeticionDTO peticion = new PeticionDTO();
        peticion.pacienteID = paciente.id;
        peticion.obraSocial = "OSDE";
        peticion.fechaDeCarga = new Date();
        peticion.fechaDeEntrega = new Date();
        peticion.sucursalID = 12345;

        //Creo practica asociada a petición
        PracticaAsociadaDTO practicaAsociada = new PracticaAsociadaDTO();
        practicaAsociada.practicaID= practica.id;
        practicaAsociada.resultadoPractica = EstadoResultadoPractica.Pendiente;
        practicaAsociada.resultado = 0;
        peticion.practicasAsociadas = new ArrayList<PracticaAsociadaDTO>();
        peticion.practicasAsociadas.add(practicaAsociada);
        peticion = peticionController.AltaPeticion(peticion);
        assertNotNull(peticion);

        assertEquals(EstadoPeticion.Activa, peticion.estadoPeticion);
        assertEquals(1, peticion.practicasAsociadas.size());

        //modifico petición
        for (PracticaAsociadaDTO pa : peticion.practicasAsociadas) {
            pa.resultadoPractica = EstadoResultadoPractica.Critico;
        }
        assertTrue(peticionController.ModificarPeticion(peticion));

        try {
            pacienteController.BajaPaciente(paciente.id);
        } catch (Exception e) {
            assertEquals("El paciente no puede ser eliminado", e.getMessage());
        }

        try {
            sucursalController.BajaSucursal(sucursal.id);
        } catch (Exception e) {
            assertEquals("La sucursal no puede ser eliminada", e.getMessage());
        }

        assertTrue(usuarioController.BajaUsuario(usuario.id));
        assertTrue(peticionController.BajaPeticion(peticion.id));
        assertTrue(pacienteController.BajaPaciente(paciente.id));
        assertTrue(sucursalController.BajaSucursal(sucursal.id));
        assertTrue(practicaController.BajaPractica(practica.id));
    }
}
