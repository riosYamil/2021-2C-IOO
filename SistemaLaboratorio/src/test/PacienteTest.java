package test;

import static org.junit.Assert.*;
import controllers.PacienteController;
import domains.Paciente;
import dtos.PacienteDTO;
import enums.EstadoPaciente;
import org.junit.Test;

public class PacienteTest {

    @Test
    public void abmPaciente() {

        PacienteController pacienteController = new PacienteController();

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
        PacienteDTO pacienteA = pacienteController.ObtenerPaciente(37340794);


        pacienteDTO.nombre = "GABRIEL YAMIL";
        pacienteDTO.domicilio = "CALLE VERDADERA 1234";
        pacienteController.ModificarPaciente(pacienteDTO);

        PacienteDTO pacienteB = pacienteController.ObtenerPaciente(37340794);

        assertNotEquals( pacienteA.nombre,pacienteB.nombre);

        pacienteController.BajaPaciente(pacienteCreado);
    }

}