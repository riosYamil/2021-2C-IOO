package test;

import static org.junit.Assert.*;
import controllers.PacienteController;
import domains.Paciente;
import dtos.PacienteDTO;
import enums.EstadoPaciente;
import org.junit.Test;

public class PacienteTest {

    @Test
    public void AltaPaciente() {

        PacienteController pacienteController = PacienteController.getInstance();

        PacienteDTO pacienteDTO = new PacienteDTO();
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
    }

    @Test
    public void BajaPaciente() {
        PacienteController pacienteController = PacienteController.getInstance();

        PacienteDTO paciente = pacienteController.ObtenerPaciente(37340794);
        pacienteController.BajaPaciente(paciente);
    }

    @Test
    public void ModificarPaciente() {

        PacienteController pacienteController = PacienteController.getInstance();

        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.id = 37340794;
        pacienteDTO.dni = "37340794";
        pacienteDTO.nombre = "GABRIEL";
        pacienteDTO.domicilio = "CALLE FALSA 1234";
        pacienteDTO.edad = 27;
        pacienteDTO.estado = EstadoPaciente.Activo;
        pacienteDTO.mail = "gabriel.rios.93@gmail.com";
        pacienteDTO.sexo = "Masculino";
        PacienteDTO pacienteCreado = pacienteController.AltaPaciente(pacienteDTO);
        assertNotNull(pacienteCreado);

        pacienteDTO.nombre = "GABRIEL YAMIL";
        pacienteDTO.domicilio = "CALLE VERDADERA 1234";
        assertTrue(pacienteController.ModificarPaciente(pacienteDTO));

        PacienteDTO paciente = pacienteController.ObtenerPaciente(37340794);
        assertEquals("GABRIEL YAMIL", paciente.nombre);
        assertEquals("CALLE VERDADERA 1234", paciente.domicilio);
    }

}