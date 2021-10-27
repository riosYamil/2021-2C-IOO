package domains;
import java.util.List;

import dtos.PacienteDTO;
import dtos.UsuarioDTO;
import enums.EstadoPaciente;

public class Paciente {
	private String DNI;
	private String nombre;
	private String apellido;
	private String mail;
	private String sexo;
	private int edad;
	private List<Peticion> peticiones_completas;
	private List<Peticion> peticiones_pendientes;
	private EstadoPaciente estado;
	
	public Paciente(PacienteDTO paciente) {
        this.DNI = paciente.DNI;
        this.nombre = paciente.nombre;
        this.apellido = paciente.apellido;
        this.mail = paciente.mail;
        this.sexo = paciente.sexo;
        this.edad = paciente.edad;
        this.peticiones_completas = paciente.peticiones_completas;
        this.peticiones_pendientes = paciente.peticiones_pendientes;
        this.estado = paciente.estado;
	}
	
    public PacienteDTO toPacienteDTO(){
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.DNI = this.DNI;
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
	
	public static void agregar_peticiones_completas(Peticion peticion) {
		
	}
	
	public static void quitar_peticion_completa(Peticion peticion) {
		
	}
	
	public static void agregar_peticion_pendientes(Peticion peticion) {
		
	}
	
	public static void quitar_peticion_pendientes(Peticion peticion) {
		
	}
	
	public static boolean tiene_peticiones_completas() {
		return true;
	}
	
	public static void notificar_estado_de_petición(Peticion peticion) {}

}
