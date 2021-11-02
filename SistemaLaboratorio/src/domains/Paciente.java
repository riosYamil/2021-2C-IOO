package domains;

import dtos.PacienteDTO;
import enums.EstadoPaciente;

import java.util.List;

public class Paciente {
    private Integer id;
    private String dni;
    private String nombre;
    public String domicilio;
    private String mail;
    private String sexo;
    private int edad;
    private List<Peticion> peticionesCompletas;
    private List<Peticion> peticionesPendientes;
    private EstadoPaciente estado;

    public Paciente(PacienteDTO paciente) {
        this.id = paciente.id;
        this.dni = paciente.dni;
        this.nombre = paciente.nombre;
        this.domicilio = paciente.domicilio;
        this.mail = paciente.mail;
        this.sexo = paciente.sexo;
        this.edad = paciente.edad;
        this.peticionesCompletas = paciente.peticionesCompletas;
        this.peticionesPendientes = paciente.peticionePendientes;
        this.estado = paciente.estado;
    }

    public static void agregarPeticionCompleta(Peticion peticion) {
    }

    public static void quitarPeticionCompleta(Peticion peticion) {
    }

    public static void agregarPeticionPendiente(Peticion peticion) {
    }

    public static void quitarPeticionPendiente(Peticion peticion) {
    }

    public static boolean tienePeticionesCompletas() {
        return true;
    }

    public static void notificarEstadoDePeticion(Peticion peticion) {
    }

    public PacienteDTO toPacienteDTO() {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.id = this.id;
        pacienteDTO.dni = this.dni;
        pacienteDTO.nombre = this.nombre;
        pacienteDTO.domicilio = this.domicilio;
        pacienteDTO.mail = this.mail;
        pacienteDTO.sexo = this.sexo;
        pacienteDTO.edad = this.edad;
        pacienteDTO.peticionesCompletas = this.peticionesCompletas;
        pacienteDTO.peticionePendientes = this.peticionesPendientes;
        pacienteDTO.estado = this.estado;
        return pacienteDTO;
    }
}
