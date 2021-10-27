package dtos;

import java.util.List;

import domains.Peticion;
import enums.EstadoPaciente;

public class PacienteDTO {
	public String DNI;
	public String nombre;
	public String apellido;
	public String mail;
	public String sexo;
	public int edad;
	public List<Peticion> peticiones_completas;
	public List<Peticion> peticiones_pendientes;
	public EstadoPaciente estado;
}
