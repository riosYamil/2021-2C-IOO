package domains;

import enums.EstadoResultadoPractica;

public class PracticaAsociada {
	private Practica practica;
	private EstadoResultadoPractica resultado_practica;
	private int resultado;
	
	public boolean tiene_valores_reservados() {
		return true;
	}
	
	public boolean tiene_valores_criticos() {
		return true;
	}
	
	public static void modificar_resultado_practica(EstadoResultadoPractica rp) {
		
	}

}
