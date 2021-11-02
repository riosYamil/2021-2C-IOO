package domains;

import enums.EstadoPeticion;

import java.util.Date;
import java.util.List;

public class Peticion {
    private Integer id;
    private Paciente paciente;
    private String obraSocial;
    private Date fechaDeCarga;
    private Date fechaDeEntrega;
    private List<PracticaAsociada> practicasAsociadas;
    private EstadoPeticion estadoPeticion;
    private int sucursalID;
	
	/*public static List<PracticaAsociada> obtener_practicas_asociadas(){
		
	}
	
	public static List<PracticaAsociada> obtener_practicas_pendientes(){
		
	}
	
	public static boolean es_petici�n_para_el_paciente() {
		return true;
	}
	
	public static void cambiar_estado(EstadoPeticion estado) {}
	
	public static void modificar_peticion(Peticion peticion) {} */

}
