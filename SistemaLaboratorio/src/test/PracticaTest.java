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
