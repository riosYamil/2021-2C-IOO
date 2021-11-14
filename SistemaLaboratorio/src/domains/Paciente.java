package domains;

import dtos.PacienteDTO;
import dtos.PeticionDTO;
import enums.EstadoPaciente;

public class Paciente {
    private Integer id;
    private String dni;
    private String nombre;
    public String domicilio;
    private String mail;
    private String sexo;
    private int edad;
    private EstadoPaciente estado;

    public Paciente(PacienteDTO paciente) {
        this.id = paciente.id;
        this.dni = paciente.dni;
        this.nombre = paciente.nombre;
        this.domicilio = paciente.domicilio;
        this.mail = paciente.mail;
        this.sexo = paciente.sexo;
        this.edad = paciente.edad;
        this.estado = paciente.estado;
    }

    public static void NotificarEstadoDePeticion(PeticionDTO peticion) {
        System.out.println("Se notificó al paciente_id:" + peticion.pacienteID + " que su peticion_id: " + peticion.id + "tiene estado" + peticion.estadoPeticion);
    }

    public PacienteDTO ToPacienteDTO() {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.id = this.id;
        pacienteDTO.dni = this.dni;
        pacienteDTO.nombre = this.nombre;
        pacienteDTO.domicilio = this.domicilio;
        pacienteDTO.mail = this.mail;
        pacienteDTO.sexo = this.sexo;
        pacienteDTO.edad = this.edad;
        pacienteDTO.estado = this.estado;
        return pacienteDTO;
    }
}
