package test;

import controllers.PacienteController;
import controllers.PeticionController;
import dtos.PacienteDTO;
import dtos.PeticionDTO;
import dtos.PracticaAsociadaDTO;
import dtos.PracticaDTO;
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

        PeticionDTO peticionDTO = new PeticionDTO();
        peticionDTO.pacienteID = 37340794;
        peticionDTO.obraSocial = "OSDE";
        peticionDTO.fechaDeCarga = new Date();
        peticionDTO.fechaDeEntrega = new Date();

        PracticaAsociadaDTO practicaAsociadaDTO = new PracticaAsociadaDTO();
        practicaAsociadaDTO.practicaDTO = practicaDTO;
        practicaAsociadaDTO.resultadoPractica = EstadoResultadoPractica.Pendiente;
        practicaAsociadaDTO.resultado = 0;

        peticionDTO.practicasAsociadas = new ArrayList<PracticaAsociadaDTO>();
        peticionDTO.practicasAsociadas.add(practicaAsociadaDTO);
        peticionDTO.estadoPeticion = EstadoPeticion.Activa;
        peticionDTO.sucursalID = 12345;

        assertNotNull(peticionController.AltaPeticion(peticionDTO));
        assertTrue(peticionController.BajaPeticion(peticionDTO.id));
    }

    @Test
    public void BajaPeticion() {

        PeticionController peticionController = PeticionController.getInstance();

        PeticionDTO peticionDTO = new PeticionDTO();
        peticionDTO.pacienteID = 37340794;
        peticionDTO.obraSocial = "OSDE";
        peticionDTO.fechaDeCarga = new Date();
        peticionDTO.fechaDeEntrega = new Date();
        peticionDTO.estadoPeticion = EstadoPeticion.Activa;
        peticionDTO.sucursalID = 12345;

        peticionDTO = peticionController.AltaPeticion(peticionDTO);

        PacienteDTO pacienteDTOParaTest = new PacienteDTO();
        //ID inexistente
        pacienteDTOParaTest.id = 123456;
        assertFalse(peticionController.BajaPeticion(pacienteDTOParaTest.id));
        //ID existente
        pacienteDTOParaTest.id = peticionDTO.id;
        assertTrue(peticionController.BajaPeticion(pacienteDTOParaTest.id));
    }

    @Test
    public void ModificarPeticion() {

        PeticionController peticionController = PeticionController.getInstance();

        PeticionDTO peticionDTO = new PeticionDTO();
        peticionDTO.pacienteID = 37340794;
        peticionDTO.obraSocial = "OSDE";
        peticionDTO.fechaDeCarga = new Date();
        peticionDTO.fechaDeEntrega = new Date();
        peticionDTO.estadoPeticion = EstadoPeticion.Activa;
        peticionDTO.sucursalID = 12345;

        peticionDTO = peticionController.AltaPeticion(peticionDTO);
        peticionDTO = peticionController.ObtenerPeticion(peticionDTO.id);
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
        practicaAsociadaDTO.practicaDTO = practicaDTO;
        practicaAsociadaDTO.resultadoPractica = EstadoResultadoPractica.Pendiente;
        practicaAsociadaDTO.resultado = 0;

        peticionDTO.practicasAsociadas = new ArrayList<PracticaAsociadaDTO>();
        peticionDTO.practicasAsociadas.add(practicaAsociadaDTO);

        assertTrue(peticionController.ModificarPeticione(peticionDTO));
        peticionDTO = peticionController.ObtenerPeticion(peticionDTO.id);
        assertEquals(1, peticionDTO.practicasAsociadas.size());

        assertTrue(peticionController.BajaPeticion(peticionDTO.id));
    }

}
