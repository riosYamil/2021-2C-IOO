package domains;

import java.util.Date;
import java.util.List;

import enums.EstadoPeticion;

public class Peticion {
	private Paciente paciente;
	private String obra_social;
	private Date fecha_de_carga;
	private Date fecha_de_entrega;
	private List<PracticaAsociada> practicas_asociadas;
	private EstadoPeticion estadoPeticion;
	private int sucursalID;
	
	/*public static List<PracticaAsociada> obtener_practicas_asociadas(){
		
	}
	
	public static List<PracticaAsociada> obtener_practicas_pendientes(){
		
	}
	
	public static boolean es_petición_para_el_paciente() {
		return true;
	}
	
	public static void cambiar_estado(EstadoPeticion estado) {}
	
	public static void modificar_peticion(Peticion peticion) {} */
	
}
