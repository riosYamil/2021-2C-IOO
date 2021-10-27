package domains;

import dtos.PacienteDTO;
import enums.EstadoPaciente;

import java.util.List;

public class Paciente {
    private Integer id;
    private String dni;
    private String nombre;
    private String apellido;
    private String mail;
    private String sexo;
    private int edad;
    private List<Peticion> peticiones_completas;
    private List<Peticion> peticiones_pendientes;
    private EstadoPaciente estado;

    public Paciente(PacienteDTO paciente) {
        this.id = paciente.id;
        this.dni = paciente.dni;
        this.nombre = paciente.nombre;
        this.apellido = paciente.apellido;
        this.mail = paciente.mail;
        this.sexo = paciente.sexo;
        this.edad = paciente.edad;
        this.peticiones_completas = paciente.peticiones_completas;
        this.peticiones_pendientes = paciente.peticiones_pendientes;
        this.estado = paciente.estado;
    }

    public static void agregarPeticionesCompletas(Peticion peticion) {
    }

    public static void quitarPeticionCompleta(Peticion peticion) {
    }

    public static void agregarPeticionPendientes(Peticion peticion) {
    }

    public static void quitarPeticionPendientes(Peticion peticion) {
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
        pacienteDTO.apellido = this.apellido;
        pacienteDTO.mail = this.mail;
        pacienteDTO.sexo = this.sexo;
        pacienteDTO.edad = this.edad;
        pacienteDTO.peticiones_completas = this.peticiones_completas;
        pacienteDTO.peticiones_pendientes = this.peticiones_pendientes;
        pacienteDTO.estado = this.estado;
        return pacienteDTO;
    }
}
