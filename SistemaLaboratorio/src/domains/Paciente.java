package domains;

import dtos.PacienteDTO;
import dtos.PeticionDTO;
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
    private List<PeticionDTO> peticionesCompletas;
    private List<PeticionDTO> peticionesPendientes;
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

    public boolean AgregarPeticionCompleta(PeticionDTO peticion) {
        return this.peticionesCompletas.add(peticion);
    }

    public boolean QuitarPeticionCompleta(PeticionDTO peticion) {
        return this.peticionesCompletas.remove(peticion);
    }

    public boolean AgregarPeticionPendiente(PeticionDTO peticion) {
        return this.peticionesPendientes.add(peticion);
    }

    public boolean QuitarPeticionPendiente(PeticionDTO peticion) {
        return this.peticionesPendientes.remove(peticion);
    }

    public boolean TienePeticionesCompletas() {
        return !this.peticionesCompletas.isEmpty();
    }

    //TODO: Codear este método
    public static void NotificarEstadoDePeticion(PeticionDTO peticion) {
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
        pacienteDTO.peticionesCompletas = this.peticionesCompletas;
        pacienteDTO.peticionePendientes = this.peticionesPendientes;
        pacienteDTO.estado = this.estado;
        return pacienteDTO;
    }
}
