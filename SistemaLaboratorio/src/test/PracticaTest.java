package test;

import controllers.PracticaController;
import dtos.PracticaDTO;
import enums.EstadoPractica;
import org.junit.Test;

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

        PracticaDTO practica = practicaController.AltaPractica(practicaDTO);
        assertNotNull(practica);
        practicaController.BajaPractica(practica.id);
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

        PracticaDTO practica = practicaController.AltaPractica(practicaDTO);
        assertNotNull(practica);

        PracticaDTO practicaDTOParaTest = new PracticaDTO();

        //ID inexistente
        practicaDTOParaTest.id = 123456;
        assertFalse(practicaController.BajaPractica(practicaDTOParaTest.id));
        //ID existente
        practicaDTOParaTest.id = practica.id;
        assertTrue(practicaController.BajaPractica(practicaDTOParaTest.id));
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

        practicaDTO = practicaController.AltaPractica(practicaDTO);
        assertNotNull(practicaDTO);

        practicaDTO.nombre = "asd";
        practicaDTO.grupo = "abc";
        assertTrue(practicaController.ModificarPractica(practicaDTO));

        PracticaDTO practica = practicaController.ObtenerPractica(practicaDTO.id);
        assertEquals("asd", practica.nombre);
        assertEquals("abc", practica.grupo);

        assertTrue(practicaController.BajaPractica(practica.id));
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

        PracticaDTO practica = practicaController.AltaPractica(practicaDTO);
        assertNotNull(practica);

        //ID inexistente
        assertNull(practicaController.ObtenerPractica(123456789));
        //ID existente
        assertNotNull(practicaController.ObtenerPractica(practica.id));

        assertTrue(practicaController.BajaPractica(practica.id));
    }
}
